package com.nathan.nathanmod.world;

import java.util.Random;

import com.nathan.nathanmod.NathanMod;
import com.nathan.nathanmod.world.tree.MakeNormalTree;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldGenTrees implements IWorldGenerator {
	private final String __OBFID = "CL_00000438";

	public WorldGenTrees() {
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		// Get block cords from chunk for biome finding
		int x = chunkX * 16;
		int z = chunkZ * 16;

		// To have tree generate everywhere, put the tree generation code
		// (random number and actual tree making stuff) here

		// For biome specific tree generation, put tree gen code in biome
		// specific if statement
		// Find biome
		String s = world.getBiomeGenForCoords(x, z).biomeName;
		
		// Forest generation code
		if (s.toLowerCase().contains("forest")) {
			for (int i = 0; i < NathanMod.woodTypes.length; i++) {
				x = (int) (chunkX * 16 + (16 * Math.random()));
				z = (int) (chunkZ * 16 + (16 * Math.random()));
				NathanMod.treeGenTypes.genNormalTree(i, world, random, x, z);
			}
			
		}
	}
}
