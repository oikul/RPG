package world;

import java.util.ArrayList;

public class Biome {
	
	private String name;
	private ArrayList<BiomePart> baseParts, waterParts, decoParts;
	
	public Biome(String name){
		setName(name);
		baseParts = new ArrayList<BiomePart>();
		waterParts = new ArrayList<BiomePart>();
		decoParts = new ArrayList<BiomePart>();
	}
	
	public void addBiomePart(BiomePart biomePart){
		baseParts.add(biomePart);
	}
	
	public void addWaterPart(BiomePart biomePart){
		waterParts.add(biomePart);
	}
	
	public void addDecoPart(BiomePart biomePart){
		decoParts.add(biomePart);
	}

	public ArrayList<BiomePart> getBaseParts() {
		return baseParts;
	}

	public ArrayList<BiomePart> getWaterParts() {
		return waterParts;
	}

	public ArrayList<BiomePart> getDecoParts() {
		return decoParts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static void createDefaultBiomes() {
		//very cold
		polar_desert.addBiomePart(new BiomePart(Block.snow, 0f, 0.4f, 1f));
		polar_desert.addBiomePart(new BiomePart(Block.ice, 0.4f, 0.5f, 1f));
		polar_desert.addBiomePart(new BiomePart(Block.snow, 0.5f, 1f, 1f));

		ice_spikes.addBiomePart(new BiomePart(Block.snow, 0.4f, 1f, 1f));
		ice_spikes.addBiomePart(new BiomePart(Block.ice, 0f, 0.4f, 1f));
		ice_spikes.addDecoPart(new BiomePart(Block.ice_spikes, 0.3f, 0.7f, 0.01f));

		frozen_lakes.addBiomePart(new BiomePart(Block.snow, 0f, 0.7f, 1f));
		frozen_lakes.addBiomePart(new BiomePart(Block.ice, 0.7f, 1f, 1f));

		ice_sheet.addBiomePart(new BiomePart(Block.ice, 0f, 0.35f, 1f));
		ice_sheet.addWaterPart(new BiomePart(Block.water_river, 0.35f, 0.5f, 1f));
		ice_sheet.addBiomePart(new BiomePart(Block.ice, 0.5f, 1f, 1f));
		
		ice_bergs.addWaterPart(new BiomePart(Block.water_ocean, 0f, 0.6f, 1f));
		ice_bergs.addBiomePart(new BiomePart(Block.ice, 0.6f, 1f, 1f));
		
		//cold
		tundra.addBiomePart(new BiomePart(Block.grass_tundra, 0f, 0.7f, 1f));
		tundra.addWaterPart(new BiomePart(Block.water_murky, 0.7f, 1f, 1f));
		
		mountain.addWaterPart(new BiomePart(Block.water_ocean, 0f, 0.4f, 1f));
		mountain.addBiomePart(new BiomePart(Block.sand, 0.4f, 0.45f, 1f));
		mountain.addBiomePart(new BiomePart(Block.grass_mountains, 0.45f, 0.7f, 1f));
		mountain.addBiomePart(new BiomePart(Block.stone_solid, 0.7f, 0.8f, 1f));
		mountain.addBiomePart(new BiomePart(Block.stone_snowy, 0.8f, 0.9f, 1f));
		mountain.addBiomePart(new BiomePart(Block.snow, 0.9f, 1f, 1f));
		mountain.addDecoPart(new BiomePart(Block.rocks, 0.65f, 0.75f, 0.1f));
		mountain.addDecoPart(new BiomePart(Block.tree_pine, 0.45f, 0.7f, 0.08f));

		taiga.addBiomePart(new BiomePart(Block.grass_snowy, 0f, 0.4f, 1f));
		taiga.addBiomePart(new BiomePart(Block.water_river, 0.4f, 0.5f, 1f));
		taiga.addBiomePart(new BiomePart(Block.grass_snowy, 0.5f, 1f, 1f));
		taiga.addDecoPart(new BiomePart(Block.tree_pine, 0f, 0.4f, 0.1f));
		taiga.addDecoPart(new BiomePart(Block.tree_pine, 0.5f, 1f, 0.1f));
		
		mountain_forest.addWaterPart(new BiomePart(Block.water_ocean, 0f, 0.4f, 1f));
		mountain_forest.addBiomePart(new BiomePart(Block.sand, 0.4f, 0.45f, 1f));
		mountain_forest.addBiomePart(new BiomePart(Block.grass_mountains, 0.45f, 0.7f, 1f));
		mountain_forest.addBiomePart(new BiomePart(Block.stone_solid, 0.7f, 0.8f, 1f));
		mountain_forest.addBiomePart(new BiomePart(Block.stone_snowy, 0.8f, 0.9f, 1f));
		mountain_forest.addBiomePart(new BiomePart(Block.snow, 0.9f, 1f, 1f));
		mountain_forest.addDecoPart(new BiomePart(Block.rocks, 0.65f, 0.75f, 0.1f));
		mountain_forest.addDecoPart(new BiomePart(Block.tree_pine, 0.45f, 0.7f, 0.2f));
		mountain_forest.addDecoPart(new BiomePart(Block.tree_spruce, 0.45f, 0.7f, 0.2f));
		
		ocean.addBiomePart(new BiomePart(Block.rock, 0f, 0.1f, 1f));
		ocean.addWaterPart(new BiomePart(Block.water_ocean, 0.1f, 1f, 1f));
		ocean.addDecoPart(new BiomePart(Block.rocks, 0.05f, 0.25f, 0.1f));
		ocean.addDecoPart(new BiomePart(Block.rocks, 0.5f, 1f, 0.05f));
		
		//medium
		steppe.addBiomePart(new BiomePart(Block.grass_steppe, 0f, 1f, 1f));
		steppe.addDecoPart(new BiomePart(Block.tree_shrub, 0f, 1f, 0.05f));
		steppe.addDecoPart(new BiomePart(Block.tree_shrub_1, 0.5f, 1f, 0.1f));
		
		plains.addBiomePart(new BiomePart(Block.grass_plains, 0f, 1f, 1f));
		plains.addDecoPart(new BiomePart(Block.flowers, 0.3f, 0.5f, 0.2f));
		plains.addDecoPart(new BiomePart(Block.flower, 0.8f, 1f, 0.2f));
		plains.addDecoPart(new BiomePart(Block.tree_oak, 0f, 0.4f, 0.001f));
		plains.addDecoPart(new BiomePart(Block.tree_shrub, 0f, 1f, 0.03f));

		forest.addWaterPart(new BiomePart(Block.water_river, 0.9f, 1f, 1f));
		forest.addBiomePart(new BiomePart(Block.sand, 0.83f, 0.9f, 1f));
		forest.addBiomePart(new BiomePart(Block.grass_forest, 0f, 0.83f, 1f));
		forest.addDecoPart(new BiomePart(Block.tree_birch, 0f, 0.8f, 0.2f));
		forest.addDecoPart(new BiomePart(Block.tree_oak_1, 0f, 0.8f, 0.2f));
		forest.addDecoPart(new BiomePart(Block.tree_pine, 0f, 0.8f, 0.1f));

		lakes.addBiomePart(new BiomePart(Block.grass_plains, 0f, 0.7f, 1f));
		lakes.addWaterPart(new BiomePart(Block.water_river, 0.7f, 1f, 1f));
		lakes.addDecoPart(new BiomePart(Block.tree_shrub_1, 0f, 0.7f, 0.01f));

		islands.addWaterPart(new BiomePart(Block.water_ocean, 0f, 0.8f, 1f));
		islands.addBiomePart(new BiomePart(Block.sand, 0.8f, 0.9f, 1f));
		islands.addBiomePart(new BiomePart(Block.grass_jungle, 0.9f, 1f, 1f));
		islands.addDecoPart(new BiomePart(Block.tree_palm, 0.9f, 1f, 0.03f));
		islands.addDecoPart(new BiomePart(Block.rocks, 0f, 0.3f, 0.05f));

		//hot
		desert_plains.addBiomePart(new BiomePart(Block.sand_cracked, 0f, 0.8f, 1f));
		desert_plains.addBiomePart(new BiomePart(Block.sand_arid, 0.8f, 1f, 1f));
		desert_plains.addDecoPart(new BiomePart(Block.tree_shrub_1, 0f, 1f, 0.05f));
		desert_plains.addDecoPart(new BiomePart(Block.tree_cactus, 0.4f, 1f, 0.05f));
		desert_plains.addDecoPart(new BiomePart(Block.rocks, 0f, 0.6f, 0.05f));
		
		canyon.addBiomePart(new BiomePart(Block.sand_cracked, 0f, 0.2f, 1f));
		canyon.addBiomePart(new BiomePart(Block.clay, 0.2f, 1f, 1f));
		canyon.addDecoPart(new BiomePart(Block.tree_shrub_1, 0f, 1f, 0.01f));
		
		savannah.addBiomePart(new BiomePart(Block.grass_savannah, 0f, 1f, 1f));
		savannah.addDecoPart(new BiomePart(Block.tree_baobab, 0f, 1f, 0.01f));
		savannah.addDecoPart(new BiomePart(Block.tree_shrub_1, 0f, 1f, 0.02f));
		
		jungle.addBiomePart(new BiomePart(Block.grass_jungle, 0f, 1f, 1f));
		jungle.addDecoPart(new BiomePart(Block.tree_palm, 0f, 0.7f, 0.3f));
		jungle.addDecoPart(new BiomePart(Block.tree_rubber, 0.3f, 1f, 0.3f));
		jungle.addDecoPart(new BiomePart(Block.tree_shrub, 0f, 1f, 0.1f));

		rainforest.addBiomePart(new BiomePart(Block.grass_rainforest, 0f, 0.42f, 1f));
		rainforest.addWaterPart(new BiomePart(Block.water_river, 0.42f, 0.48f, 1f));
		rainforest.addBiomePart(new BiomePart(Block.grass_rainforest, 0.48f, 1f, 1f));
		rainforest.addDecoPart(new BiomePart(Block.tree_palm, 0f, 0.42f, 0.3f));
		rainforest.addDecoPart(new BiomePart(Block.tree_rubber, 0f, 0.42f, 0.3f));
		rainforest.addDecoPart(new BiomePart(Block.tree_shrub, 0f, 0.42f, 0.1f));
		rainforest.addDecoPart(new BiomePart(Block.tree_palm, 0.48f, 1f, 0.3f));
		rainforest.addDecoPart(new BiomePart(Block.tree_rubber, 0.48f, 1f, 0.3f));
		rainforest.addDecoPart(new BiomePart(Block.tree_shrub, 0.48f, 1f, 0.1f));
		
		//very hot
		lava_ocean.addWaterPart(new BiomePart(Block.lava, 0f, 1f, 1f));
		lava_ocean.addDecoPart(new BiomePart(Block.rocks, 0f, 1f, 0.01f));

		lava_islands.addWaterPart(new BiomePart(Block.lava, 0f, 0.7f, 1f));
		lava_islands.addBiomePart(new BiomePart(Block.rock, 0.7f, 1f, 1f));
		lava_islands.addDecoPart(new BiomePart(Block.rocks, 0f, 1f, 0.05f));

		lava_lakes.addBiomePart(new BiomePart(Block.rock, 0f, 0.6f, 1f));
		lava_lakes.addWaterPart(new BiomePart(Block.lava, 0.6f, 1f, 1f));
		
		igneous_desert.addBiomePart(new BiomePart(Block.rock, 0f, 0.8f, 1f));
		igneous_desert.addBiomePart(new BiomePart(Block.stone_solid, 0.8f, 1f, 1f));
		
		volcanic_mountains.addWaterPart(new BiomePart(Block.lava, 0f, 0.3f, 1f));
		volcanic_mountains.addBiomePart(new BiomePart(Block.stone_solid, 0.3f, 0.8f, 1f));
		volcanic_mountains.addBiomePart(new BiomePart(Block.stone_solid, 0.8f, 1f, 1f));
		volcanic_mountains.addDecoPart(new BiomePart(Block.rocks, 0.2f, 0.9f, 0.1f));
	}
	
	// very cold biomes
		public static Biome polar_desert = new Biome("polar desert");
		public static Biome ice_spikes = new Biome("ice spikes");
		public static Biome frozen_lakes = new Biome("frozen lakes");
		public static Biome ice_sheet = new Biome("ice sheet");
		public static Biome ice_bergs = new Biome("ice bergs");

		// cold biomes
		public static Biome tundra = new Biome("tundra");
		public static Biome mountain = new Biome("mountain");
		public static Biome taiga = new Biome("taiga");
		public static Biome mountain_forest = new Biome("mountain forest");
		public static Biome ocean = new Biome("ocean");

		// medium biomes
		public static Biome steppe = new Biome("steppe");
		public static Biome plains = new Biome("plains");
		public static Biome forest = new Biome("forest");
		public static Biome lakes = new Biome("lakes");
		public static Biome islands = new Biome("islands");

		// hot biomes
		public static Biome desert_plains = new Biome("desert plains");
		public static Biome canyon = new Biome("canyon");
		public static Biome savannah = new Biome("savannah");
		public static Biome jungle = new Biome("jungle");
		public static Biome rainforest = new Biome("rainforest");

		// very hot biomes
		public static Biome lava_ocean = new Biome("lava ocean");
		public static Biome lava_islands = new Biome("lava islands");
		public static Biome lava_lakes = new Biome("lava lakes");
		public static Biome igneous_desert = new Biome("igneous desert");
		public static Biome volcanic_mountains = new Biome("volcanic_mountains");

}
