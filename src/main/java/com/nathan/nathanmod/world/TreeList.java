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
    
    //List of trees.  (true, min height, trunkblock, leavesblock, vinesgrow, name)
    //To make a new tree, add one of these
    private MakeNormalTree hickoryTree = new MakeNormalTree(true, 5, NathanMod.NathanLogs, NathanMod.NathanLeaves, false, 0);
    private MakeNormalTree elmTree = new MakeNormalTree(true, 5, NathanMod.NathanLogs, NathanMod.NathanLeaves, false, 1);

    public TreeList()
    {
    	
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
    	//Get block cords from chunk for biome finding
    	int x = chunkX*16;
    	int z = chunkZ*16;
    	
    	//To have tree generate everywhere, put the tree generation code 
    	//(random number and actual tree making stuff) here
    	
    	//For biome specific tree generation, put tree gen code in biome specific if statement
    	//Find biome
    	String s = world.getBiomeGenForCoords(x, z).biomeName;
        if (s.toLowerCase().contains("Forest".toLowerCase()))			//If biome name includes forest
        {
        	//Generate new random numbers and make a Hickory tree
	    	x = (int) (chunkX*16 + (16*Math.random()));
	    	z = (int) (chunkZ*16 + (16*Math.random()));
	        hickoryTree.generate(world, random, x, world.getHeightValue(x, z), z);
	        
	        //Generate new random numbers and make a Elm tree
	        x = (int) (chunkX*16 + (16*Math.random()));
	    	z = (int) (chunkZ*16 + (16*Math.random()));
	        elmTree.generate(world, random, x, world.getHeightValue(x, z), z);
        }
	}
}
