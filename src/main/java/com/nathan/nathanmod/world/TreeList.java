package com.nathan.nathanmod.world;

import java.util.Random;

import com.nathan.nathanmod.NathanMod;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class TreeList implements IWorldGenerator {
	private final String __OBFID = "CL_00000438";

	// List of trees. (true, min height, trunkblock, leavesblock, vinesgrow,
	// name)
	// To make a new tree, add one of these
	public static MakeNormalTree[] generatorArray = new MakeNormalTree[NathanMod.woodTypes.length];

	public TreeList() {
		for (int i = 0; i < NathanMod.woodTypes.length; i++) {
			generatorArray[i] = new MakeNormalTree(true, 5, NathanMod.nathanLogs, NathanMod.nathanLeaves, false, i);
		}
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
		if (s.toLowerCase().contains("Forest".toLowerCase())) {
			for (int i = 0; i < NathanMod.woodTypes.length; i++) {
				x = (int) (chunkX * 16 + (16 * Math.random()));
				z = (int) (chunkZ * 16 + (16 * Math.random()));
				generatorArray[i].generate(world, random, x, world.getHeightValue(x, z), z);
			}
		}
	}
}
