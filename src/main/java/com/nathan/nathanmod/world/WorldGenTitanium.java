package com.nathan.nathanmod.world;

import java.util.Random;

import com.nathan.nathanmod.NathanMod;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenTitanium implements IWorldGenerator {
	private WorldGenerator genTitaniumOre; //Generates Titanium Ore (used in Overworld)
	
	public WorldGenTitanium() {
		this.genTitaniumOre = new WorldGenMinable(NathanMod.TitaniumOre, 8);
	}
	
	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
	    if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
	        throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

	    int heightDiff = maxHeight - minHeight + 1;
	    for (int i = 0; i < chancesToSpawn; i ++) {
	        int x = chunk_X * 16 + rand.nextInt(16);
	        int y = minHeight + rand.nextInt(heightDiff);
	        int z = chunk_Z * 16 + rand.nextInt(16);
	        generator.generate(world, rand, x, y, z);
	    }
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
	    case 0: //Overworld
	    	this.runGenerator(this.genTitaniumOre, world, random, chunkX, chunkZ, 13, 0, 64);
	        break;
	    case -1: //Nether
	    	
	        break;
	    case 1: //End
	    	
	        break;
	    }
	}
}
