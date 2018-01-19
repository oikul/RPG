package world;

import java.awt.geom.Point2D;

import voronoi.GraphEdge;

public class BiomeBorder {

	private double x1, y1, x2, y2;

	private int site1, site2;
	private Point2D.Double a, b, c, d;

	private Biome biome1, biome2;

	public BiomeBorder(double x1, double y1, double x2, double y2, int site1, int site2) {
		setX1(x1);
		setX2(x2);
		setY1(y1);
		setY2(y2);
		setSite1(site1);
		setSite2(site2);
		biome1 = chooseBiome(site1);
		biome2 = chooseBiome(site2);
		a = new Point2D.Double(x1, y1);
		b = new Point2D.Double(x2, y1);
		c = new Point2D.Double(x1, y2);
		d = new Point2D.Double(x2, y2);
	}

	public BiomeBorder(GraphEdge g) {
		setX1(g.x1);
		setX2(g.x2);
		setY1(g.y1);
		setY2(g.y2);
		setSite1(g.site1);
		setSite2(g.site2);
		biome1 = chooseBiome(site1);
		biome2 = chooseBiome(site2);
		a = new Point2D.Double(x1, y1);
		b = new Point2D.Double(x2, y1);
		c = new Point2D.Double(x1, y2);
		d = new Point2D.Double(x2, y2);
	}

	public boolean isPointInTriangle1(Point2D.Double p) {
		double ABC = Math.abs(a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y));
		double ABP = Math.abs(a.x * (b.y - p.y) + b.y * (p.y - a.y) + p.x * (a.y - b.y));
		double APC = Math.abs(a.x * (p.y - c.y) + p.x * (c.y - a.y) + c.x * (a.y - p.y));
		double PBC = Math.abs(p.x * (b.y - c.y) + b.x * (c.y - p.y) + c.x * (p.y - b.y));
		return ABP + APC + PBC == ABC;
	}

	public boolean isPointInTriangle2(Point2D.Double p) {
		double BCD = Math.abs(b.x * (c.y - d.y) + c.x * (d.y - b.y) + d.x * (b.y - c.y));
		double BCP = Math.abs(b.x * (c.y - p.y) + c.y * (p.y - b.y) + p.x * (b.y - c.y));
		double BPD = Math.abs(b.x * (p.y - d.y) + p.x * (d.y - b.y) + d.x * (b.y - p.y));
		double PCD = Math.abs(p.x * (c.y - d.y) + c.x * (d.y - p.y) + d.x * (p.y - c.y));
		return BCP + BPD + PCD == BCD;
	}

	public Biome getBiome1() {
		return biome1;
	}

	public Biome getBiome2() {
		return biome2;
	}

	private Biome chooseBiome(int site) {
		Biome b = Biome.forest;
		int n = site % 25;
		switch (n) {
		case 0:
			b = Biome.polar_desert;
			break;
		case 1:
			b = Biome.ice_spikes;
			break;
		case 2:
			b = Biome.frozen_lakes;
			break;
		case 3:
			b = Biome.ice_sheet;
			break;
		case 4:
			b = Biome.ice_bergs;
			break;
		case 5:
			b = Biome.tundra;
			break;
		case 6:
			b = Biome.mountain;
			break;
		case 7:
			b = Biome.taiga;
			break;
		case 8:
			b = Biome.mountain_forest;
			break;
		case 9:
			b = Biome.ocean;
			break;
		case 10:
			b = Biome.steppe;
			break;
		case 11:
			b = Biome.plains;
			break;
		case 12:
			b = Biome.forest;
			break;
		case 13:
			b = Biome.lakes;
			break;
		case 14:
			b = Biome.islands;
			break;
		case 15:
			b = Biome.desert_plains;
			break;
		case 16:
			b = Biome.canyon;
			break;
		case 17:
			b = Biome.savannah;
			break;
		case 18:
			b = Biome.jungle;
			break;
		case 19:
			b = Biome.rainforest;
			break;
		case 20:
			b = Biome.lava_ocean;
			break;
		case 21:
			b = Biome.lava_islands;
			break;
		case 22:
			b = Biome.lava_lakes;
			break;
		case 23:
			b = Biome.igneous_desert;
			break;
		case 24:
			b = Biome.volcanic_mountains;
			break;
		}
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

	public int getSite1() {
		return site1;
	}

	public void setSite1(int site1) {
		this.site1 = site1;
	}

	public int getSite2() {
		return site2;
	}

	public void setSite2(int site2) {
		this.site2 = site2;
	}

}
