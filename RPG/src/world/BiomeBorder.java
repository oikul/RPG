package world;

import java.awt.geom.Point2D;
import java.util.Random;

import voronoi.GraphEdge;
import voronoi.Site;

public class BiomeBorder {

	private double x1, y1, x2, y2;

	private Site site1, site2;

	private Biome biome1, biome2;

	private Random random = new Random();

	public BiomeBorder(GraphEdge g) {
		setX1(g.x1);
		setX2(g.x2);
		setY1(g.y1);
		setY2(g.y2);
		setSite1(g.site1);
		setSite2(g.site2);
		biome1 = chooseBiome(site1);
		biome2 = chooseBiome(site2);
	}

	public boolean isPointInTriangle1(Point2D.Double p) {
		double ABC = Math.abs(0.5 * ((site1.coord.x - x2) * (y1 - site1.coord.y) - (site1.coord.x - x1) * (y2 - site1.coord.y)));
		double ABP = Math.abs(0.5 * ((site1.coord.x - p.x) * (y1 - site1.coord.y) - (site1.coord.x - x1) * (p.y - site1.coord.y)));
		double APC = Math.abs(0.5 * ((site1.coord.x - x2) * (p.y - site1.coord.y) - (site1.coord.x - p.x) * (y2 - site1.coord.y)));
		double PBC = Math.abs(0.5 * ((p.x - x2) * (y1 - p.y) - (p.x - x1) * (y2 - p.y)));
		return Math.abs(ABP + APC + PBC - ABC) < 0.005;
	}

	public boolean isPointInTriangle2(Point2D.Double p) {
		double ABC = Math.abs(0.5 * ((site2.coord.x - x2) * (y1 - site2.coord.y) - (site2.coord.x - x1) * (y2 - site2.coord.y)));
		double ABP = Math.abs(0.5 * ((site2.coord.x - p.x) * (y1 - site2.coord.y) - (site2.coord.x - x1) * (p.y - site2.coord.y)));
		double APC = Math.abs(0.5 * ((site2.coord.x - x2) * (p.y - site2.coord.y) - (site2.coord.x - p.x) * (y2 - site2.coord.y)));
		double PBC = Math.abs(0.5 * ((p.x - x2) * (y1 - p.y) - (p.x - x1) * (y2 - p.y)));
		return Math.abs(ABP + APC + PBC - ABC) < 0.005;
	}

	public Biome getBiome1() {
		return biome1;
	}

	public Biome getBiome2() {
		return biome2;
	}

	private Biome chooseBiome(Site site) {
		Biome b = null;
		while (World.assignedBiomes.size() < site.sitenbr + 1) {
			World.assignedBiomes.add(Biome.biomes.get(random.nextInt(25)));
		}
		b = World.assignedBiomes.get(site.sitenbr);
		/*
		 * int n = site % 25; switch (n) { case 0: b = Biome.polar_desert;
		 * break; case 1: b = Biome.ice_spikes; break; case 2: b =
		 * Biome.frozen_lakes; break; case 3: b = Biome.ice_sheet; break; case
		 * 4: b = Biome.ice_bergs; break; case 5: b = Biome.tundra; break; case
		 * 6: b = Biome.mountain; break; case 7: b = Biome.taiga; break; case 8:
		 * b = Biome.mountain_forest; break; case 9: b = Biome.ocean; break;
		 * case 10: b = Biome.steppe; break; case 11: b = Biome.plains; break;
		 * case 12: b = Biome.forest; break; case 13: b = Biome.lakes; break;
		 * case 14: b = Biome.islands; break; case 15: b = Biome.desert_plains;
		 * break; case 16: b = Biome.canyon; break; case 17: b = Biome.savannah;
		 * break; case 18: b = Biome.jungle; break; case 19: b =
		 * Biome.rainforest; break; case 20: b = Biome.lava_ocean; break; case
		 * 21: b = Biome.lava_islands; break; case 22: b = Biome.lava_lakes;
		 * break; case 23: b = Biome.igneous_desert; break; case 24: b =
		 * Biome.volcanic_mountains; break; }
		 */
		return b;
	}

	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getY1() {
		return y1;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}

	public double getY2() {
		return y2;
	}

	public void setY2(double y2) {
		this.y2 = y2;
	}

	public Site getSite1() {
		return site1;
	}

	public void setSite1(Site site1) {
		this.site1 = site1;
	}

	public Site getSite2() {
		return site2;
	}

	public void setSite2(Site site2) {
		this.site2 = site2;
	}

}
