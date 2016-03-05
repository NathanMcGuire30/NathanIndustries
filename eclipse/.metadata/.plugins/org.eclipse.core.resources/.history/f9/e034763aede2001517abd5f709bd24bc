package com.nathan.nathanmod.basic;

import com.nathan.nathanmod.NathanMod;
import com.nathan.nathanmod.OLD.*;
import com.nathan.nathanmod.blocks.*;
import com.nathan.nathanmod.items.*;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

//Class handles all the blocks and recipes
public class BasicInit {
	//Blocks
	public static void BlockInit() {
		NathanMod.creativeTitanium = new CreativeTitanium();				//Creative Titanium
    	GameRegistry.registerBlock(NathanMod.creativeTitanium, "Creative_Titanium");
    	
    	NathanMod.creativeTitaniumOLD = new CreativeTitaniumOLD();			//OLD Creative Titanium
    	GameRegistry.registerBlock(NathanMod.creativeTitaniumOLD, "Creative Titanium");
    	
    	NathanMod.Titanium = new Titanium();								//Normal Titanium
    	GameRegistry.registerBlock(NathanMod.Titanium, "Titanium");
    	
    	NathanMod.TitaniumOre = new TitaniumOre();							//Normal Titanium
    	GameRegistry.registerBlock(NathanMod.TitaniumOre, "Titanium Ore");
    	
    	NathanMod.creativeGlass = new CreativeGlass();						//Creative Glass
    	GameRegistry.registerBlock(NathanMod.creativeGlass, "Creative_Glass");
    	
    	NathanMod.creativeGlassOLD = new CreativeGlassOLD();						//Creative Glass
    	GameRegistry.registerBlock(NathanMod.creativeGlassOLD, "Creative Glass");
    	
    	NathanMod.creativeStoneBrick = new CreativeStoneBrick();			//Creative Stone Brick
    	GameRegistry.registerBlock(NathanMod.creativeStoneBrick, "Creative_Stone_Brick");
    	
    	NathanMod.creativeQuartz = new CreativeQuartz();				//Creative Quartz
    	GameRegistry.registerBlock(NathanMod.creativeQuartz, "Creative_Quartz");
    	
    	NathanMod.NathanLogs = new NathanLogs();
    	GameRegistry.registerBlock(NathanMod.NathanLogs, MultiItemLog.class, "NathanLogs");
    	
    	NathanMod.NathanLeaves = new NathanLeaves();
    	GameRegistry.registerBlock(NathanMod.NathanLeaves, MultiItemLeaves.class, "NathanLeaves");
    	
    	NathanMod.NathanSlabs = new NathanSlabs(true);
    	GameRegistry.registerBlock(NathanMod.NathanSlabs, ItemNathanSlab.class, "NathanSlabs");
    	
    	NathanMod.NathanSlabsDouble = new NathanSlabs(false);
    	GameRegistry.registerBlock(NathanMod.NathanSlabsDouble, ItemNathanSlab.class, "NathanSlabsDouble");
    	
    	GameRegistry.registerBlock(NathanMod.NathanPlanks = new NathanPlanks("NathanPlanks"), MultiItemPlanks.class, "NathanPlanks");
	}
	
	//Items
	public static void ItemInit() {
		NathanMod.TitaniumIngot = new TitaniumIngot();
		GameRegistry.registerItem(NathanMod.TitaniumIngot, "Titanium Ingot");
	}
	
	//Recipes
	public static void RecipeInit() {
		//Creative Glass
		GameRegistry.addRecipe(new ItemStack(NathanMod.creativeGlass), new Object[]{
	    	"AAA",
	    	"ABA",
	    	"AAA",
	    	'A', Blocks.diamond_block, 'B', Blocks.glass
	    });
		
		//Creative Titanium
		GameRegistry.addRecipe(new ItemStack(NathanMod.creativeTitanium), new Object[]{
	    	"AAA",
	    	"ABA",
	    	"AAA",
	    	'A', Blocks.diamond_block, 'B', NathanMod.Titanium
	    });
		
		//Creative Stone Brick
		GameRegistry.addRecipe(new ItemStack(NathanMod.creativeStoneBrick), new Object[]{
	    	"AAA",
	    	"ABA",
	    	"AAA",
	    	'A', Blocks.diamond_block, 'B', Blocks.stonebrick
	    });
		
		//Titanium
		GameRegistry.addRecipe(new ItemStack(NathanMod.Titanium), new Object[]{
			"AAA",
			"AAA",
			"AAA",
			'A', NathanMod.TitaniumIngot
		});
		
		//Titanium
		GameRegistry.addRecipe(new ItemStack(NathanMod.creativeQuartz), new Object[]{
			"AAA",
			"ABA",
			"AAA",
			'A', Blocks.diamond_block, 'B', Blocks.quartz_block
		});
		
		//Titanium Ingot
		GameRegistry.addSmelting(NathanMod.TitaniumOre, new ItemStack(NathanMod.TitaniumIngot), 0.5F);
		
		//Titanium Ingot from titanium block
		GameRegistry.addShapelessRecipe(new ItemStack(NathanMod.TitaniumIngot, 9, 1), new Object[]
		{
		    	new ItemStack(NathanMod.Titanium, 1, 1)
		});
		
		//Things for all wood metadatas
		for (int i=0; i<NathanMod.WoodTypes.length; i++) {
			//Make planks from logs
			GameRegistry.addShapelessRecipe(new ItemStack(NathanMod.NathanPlanks, 4, i), new Object[]
					{
					    	new ItemStack(NathanMod.NathanLogs, 1, i)
					});
			
			//Make sticks from planks
			GameRegistry.addRecipe(new ItemStack(Items.stick, 4),
				    "A",
				    "A",
				    'A', new ItemStack(NathanMod.NathanPlanks, 1, i));
			
			//Make crafting table from planks
			GameRegistry.addRecipe(new ItemStack(Blocks.crafting_table, 1),
				    "AA",
				    "AA",
				    'A', new ItemStack(NathanMod.NathanPlanks, 1, i));
		}
	}
}
