package world;

import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.Main;
import voronoi.GraphEdge;
import voronoi.Voronoi;

public class World {

	public static ValueNoiseGenerator tempGen, precipGen, heightGen;
	private double[] xValues, yValues;
	// private ArrayList<Chunk> chunks = new ArrayList<Chunk>();
	Chunk chunk;
	private BufferedImage baseLayer, waterLayer, decoLayer, terrain;
	private Graphics baseG, waterG, decoG, terrainG;
	private Random random;
	private List<BiomeBorder> biomeBorders;

	public World(long tempSeed, long precipSeed, long heightSeed) {
		tempGen = new ValueNoiseGenerator(tempSeed, 0.25f, 1, 4);
		precipGen = new ValueNoiseGenerator(precipSeed, 0.25f, 1, 4);
		heightGen = new ValueNoiseGenerator(heightSeed, 0.25f, 1, 4);
		random = new Random();
		xValues = new double[10];
		yValues = new double[10];
		for (int i = 0; i < xValues.length; i++) {
			xValues[i] = random.nextDouble() * (double) Main.width;
			yValues[i] = random.nextDouble() * (double) Main.height;
		}
		Voronoi voronoi = new Voronoi(0);
		List<GraphEdge> graphEdges = voronoi.generateVoronoi(xValues, yValues, 0, 32 * 16 * Main.ratio, 0,
				32 * 16 * Main.ratio);
		convertGraphEdges(graphEdges);
		Biome.createDefaultBiomes();
		chunk = new Chunk(0, 0);
		baseLayer = new BufferedImage(Main.width, Main.height, BufferedImage.TYPE_INT_ARGB);
		waterLayer = new BufferedImage(Main.width, Main.height, BufferedImage.TYPE_INT_ARGB);
		decoLayer = new BufferedImage(Main.width, Main.height, BufferedImage.TYPE_INT_ARGB);
		terrain = new BufferedImage(Main.width, Main.height, BufferedImage.TYPE_INT_ARGB);
		baseG = baseLayer.getGraphics();
		waterG = waterLayer.getGraphics();
		decoG = decoLayer.getGraphics();
		terrainG = terrain.getGraphics();
		drawLayers();
		createTerrain();
	}

	public void update() {
	}

	public void draw(Graphics g) {
		g.drawImage(terrain, 0, 0, Main.width, Main.height, null);
	}

	public void drawLayers() {
		Biome b = Biome.forest;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < 32; j++) {
				Point2D.Double p = new Point2D.Double(i * 32 * 16 * Main.ratio, j * 32 * 16 * Main.ratio);
				for(BiomeBorder bb : biomeBorders){
					if(bb.isPointInTriangle1(p)){
						b = bb.getBiome1();
					}else if(bb.isPointInTriangle2(p)){
						b = bb.getBiome2();
					}
				}
				//b = chooseBiome(chunk.getTemperature(i, j), chunk.getPrecipitation(i, j));
				for (BiomePart part : b.getBaseParts()) {
					float chance = random.nextFloat();
					if (part.getStart() <= chunk.getHeight(i, j) && part.getEnd() >= chunk.getHeight(i, j)
							&& part.getChance() >= chance) {
						part.getBlock().draw(baseG, (int) (i * 16 * Main.ratio), (int) (j * 16 * Main.ratio),
								Main.ratio, Main.width, Main.height);
					}
					
					 /** System.out.println("\nstart: " + part.getStart() +
					 * "\nend: " + part.getEnd() + "\nchance: " +
					 * part.getChance() + "\nroll: " + chance);
					 * System.out.println("temperature: " +
					 * chunk.getTemperature(i, j) + "\nprecipitation: " +
					 * chunk.getPrecipitation(i, j) + "\nheight: " +
					 * chunk.getHeight(i, j) + "\nbiome: " + b.getName());*/
					 
				}
				for (BiomePart part : b.getWaterParts()) {
					float chance = random.nextFloat();
					if (part.getStart() <= chunk.getHeight(i, j) && part.getEnd() >= chunk.getHeight(i, j)
							&& part.getChance() >= chance) {
						part.getBlock().draw(waterG, (int) (i * 16 * Main.ratio), (int) (j * 16 * Main.ratio),
								Main.ratio, Main.width, Main.height);
					}
					
					 /** System.out.println("\nstart: " + part.getStart() +
					 * "\nend: " + part.getEnd() + "\nchance: " +
					 * part.getChance() + "\nroll: " + chance);
					 * System.out.println("temperature: " +
					 * chunk.getTemperature(i, j) + "\nprecipitation: " +
					 * chunk.getPrecipitation(i, j) + "\nheight: " +
					 * chunk.getHeight(i, j) + "\nbiome: " + b.getName());*/
					 
				}
				for (BiomePart part : b.getDecoParts()) {
					float chance = random.nextFloat();
					if (part.getStart() <= chunk.getHeight(i, j) && part.getEnd() >= chunk.getHeight(i, j)
							&& part.getChance() >= chance) {
						part.getBlock().draw(decoG, (int) (i * 16 * Main.ratio), (int) (j * 16 * Main.ratio),
								Main.ratio, Main.width, Main.height);
					}
					
					 /*System.out.println("\nstart: " + part.getStart() +
					 * "\nend: " + part.getEnd() + "\nchance: " +
					 * part.getChance() + "\nroll: " + chance);
					 * System.out.println("temperature: " +
					 * chunk.getTemperature(i, j) + "\nprecipitation: " +
					 * chunk.getPrecipitation(i, j) + "\nheight: " +
					  chunk.getHeight(i, j) + "\nbiome: " + b.getName());*/
					 
				}
			}
		}
	}

	public void createTerrain() {
		terrainG.drawImage(baseLayer, 0, 0, null);
		terrainG.drawImage(waterLayer, 0, 0, null);
		terrainG.drawImage(decoLayer, 0, 0, null);
	}

	public Biome chooseBiome(float temperature, float precipitation) {
		Biome b = Biome.forest;
		if (temperature >= 0 && temperature < 0.2) {
			if (precipitation >= 0 && precipitation < 0.2) {
				b = Biome.polar_desert;
			} else if (precipitation >= 0.2 && precipitation < 0.4) {
				b = Biome.ice_spikes;
			} else if (precipitation >= 0.4 && precipitation < 0.6) {
				b = Biome.frozen_lakes;
			} else if (precipitation >= 0.6 && precipitation < 0.8) {
				b = Biome.ice_sheet;
			} else if (precipitation >= 0.8 && precipitation <= 1.0) {
				b = Biome.ice_bergs;
			}
		} else if (temperature >= 0.2 && temperature < 0.4) {
			if (precipitation >= 0 && precipitation < 0.2) {
				b = Biome.tundra;
			} else if (precipitation >= 0.2 && precipitation < 0.4) {
				b = Biome.mountain;
			} else if (precipitation >= 0.4 && precipitation < 0.6) {
				b = Biome.taiga;
			} else if (precipitation >= 0.6 && precipitation < 0.8) {
				b = Biome.mountain_forest;
			} else if (precipitation >= 0.8 && precipitation <= 1.0) {
				b = Biome.ocean;
			}
		} else if (temperature >= 0.4 && temperature < 0.6) {
			if (precipitation >= 0 && precipitation < 0.2) {
				b = Biome.steppe;
			} else if (precipitation >= 0.2 && precipitation < 0.4) {
				b = Biome.plains;
			} else if (precipitation >= 0.4 && precipitation < 0.6) {
				b = Biome.forest;
			} else if (precipitation >= 0.6 && precipitation < 0.8) {
				b = Biome.lakes;
			} else if (precipitation >= 0.8 && precipitation <= 1.0) {
				b = Biome.islands;
			}
		} else if (temperature >= 0.6 && temperature < 0.8) {
			if (precipitation >= 0 && precipitation < 0.2) {
				b = Biome.desert_plains;
			} else if (precipitation >= 0.2 && precipitation < 0.4) {
				b = Biome.canyon;
			} else if (precipitation >= 0.4 && precipitation < 0.6) {
				b = Biome.savannah;
			} else if (precipitation >= 0.6 && precipitation < 0.8) {
				b = Biome.jungle;
			} else if (precipitation >= 0.8 && precipitation <= 1.0) {
				b = Biome.rainforest;
			}
		} else if (temperature >= 0.8 && temperature <= 1.0) {
			if (precipitation >= 0 && precipitation < 0.2) {
				b = Biome.lava_ocean;
			} else if (precipitation >= 0.2 && precipitation < 0.4) {
				b = Biome.lava_islands;
			} else if (precipitation >= 0.4 && precipitation < 0.6) {
				b = Biome.lava_lakes;
			} else if (precipitation >= 0.6 && precipitation < 0.8) {
				b = Biome.igneous_desert;
			} else if (precipitation >= 0.8 && precipitation <= 1.0) {
				b = Biome.volcanic_mountains;
			}
		}
		return b;
	}

	private void convertGraphEdges(List<GraphEdge> l) {
		biomeBorders = new ArrayList<BiomeBorder>();
		for (GraphEdge i : l) {
			/*System.out.println("x1: " + i.x1
					+ "\nx2: " + i.x2
					+ "\ny1: " + i.y1
					+ "\ny2: " + i.y2
					+ "\n");*/
			biomeBorders.add(new BiomeBorder(i));
		}
	}

}
