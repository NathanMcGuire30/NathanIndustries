package com.nathan.nathanmod.world.tree;

import java.util.Random;

import com.nathan.nathanmod.NathanMod;

import net.minecraft.world.World;

//A class to organize my tree gen code
public class TreeGenTypes {
	public static MakeNormalTree[] normalTreeGenerator = new MakeNormalTree[NathanMod.woodTypes.length];
	public static MakeBigTree[] canopyGeneratorArray = new MakeBigTree[NathanMod.woodTypes.length];
	public static MakeBigTree2[] bigTreeGeneratorArray = new MakeBigTree2[NathanMod.woodTypes.length];
	public static int[] normalTreeHeights = new int[NathanMod.woodTypes.length];
	public static int[] canopyTreeHeights = new int[NathanMod.woodTypes.length];
	public static int defaultNormalTreeHeight = 5;
	public static int defaultCanopyTreeHeight = 4;
	
	public TreeGenTypes() {
		int treeHeight;
		int canopyTreeHeight;
		
		//define tree heights		
		normalTreeHeights[0] = 5;		//Hickory
		normalTreeHeights[1] = 4;		//Elm
		normalTreeHeights[2] = 6;		//Beech
		
		canopyTreeHeights[0] = 4;		//Hickory
		canopyTreeHeights[1] = 3;		//Elm
		canopyTreeHeights[2] = 5;		//Beech
		
		//Create tree gen objects
		for (int i = 0; i < NathanMod.woodTypes.length; i++) {
			//Make sure tree height is defined
			if (normalTreeHeights[i] > 0) {treeHeight = normalTreeHeights[i];} 
			else {treeHeight = defaultNormalTreeHeight;}
			
			if (canopyTreeHeights[i] > 0) {canopyTreeHeight = canopyTreeHeights[i];} 
			else {canopyTreeHeight = defaultCanopyTreeHeight;}
			
			//make the objects
			normalTreeGenerator[i] = new MakeNormalTree(true, treeHeight, NathanMod.nathanLogs, NathanMod.nathanLeaves, false, i);
			canopyGeneratorArray[i] = new MakeBigTree(true, treeHeight, NathanMod.nathanLogs, NathanMod.nathanLeaves, i);
			bigTreeGeneratorArray[i] = new MakeBigTree2(true, NathanMod.nathanLogs, NathanMod.nathanLeaves, i);
		}
	}
	
	public static boolean genNormalTree(int treeMetaType, World world, Random random, int x, int z) {
		if(treeMetaType >= 0 && treeMetaType < NathanMod.woodTypes.length) {
			return normalTreeGenerator[treeMetaType].generate(world, random, x, world.getHeightValue(x, z), z);
		} else { return false;}
	}
	
	public static boolean genBigTree(int treeMetaType, World world, Random random, int x, int z) {
		if(treeMetaType >= 0 && treeMetaType < NathanMod.woodTypes.length) {
			return bigTreeGeneratorArray[treeMetaType].generate(world, random, x, world.getHeightValue(x, z), z, 1);
		} else { return false;}
	}
	
	public static boolean genCanopyTree(int treeMetaType, World world, Random random, int x, int z) {
		if(treeMetaType >= 0 && treeMetaType < NathanMod.woodTypes.length) {
			return canopyGeneratorArray[treeMetaType].generate(world, random, x, world.getHeightValue(x, z), z);
		} else { return false;}
	}
	
	//The specific logic used for generating trees from sapplings
	public static void genSapplingTree(int treeMetaType, World world, Random random, int x, int z) {
		int i = (int) (Math.random()*4);
        if(i==0) {
        	if (genCanopyTree(treeMetaType, world, random, x, z) == false) {
        		genNormalTree(treeMetaType, world, random, x, z);
        	}
        } else if (i==1) {
        	if (genBigTree(treeMetaType, world, random, x, z) == false) {
        		genNormalTree(treeMetaType, world, random, x, z);
        	}
        } else {
        	genNormalTree(treeMetaType, world, random, x, z);
        }
	}
}
