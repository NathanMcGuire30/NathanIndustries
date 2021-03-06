package com.nathan.nathanmod.basic;

import com.nathan.nathanmod.NathanMod;
import com.nathan.nathanmod.blocks.*;
import com.nathan.nathanmod.blocks.OLD.*;
import com.nathan.nathanmod.items.*;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

//Class handles all the blocks and recipes
public class BasicInit {
	//Blocks
	public static void blockInit() {
		//Creative blocks
		NathanMod.creativeTitanium = new CreativeTitanium();				//Creative Titanium
    	GameRegistry.registerBlock(NathanMod.creativeTitanium, "Creative_Titanium");
    	NathanMod.creativeTitaniumOLD = new CreativeTitaniumOLD();			//OLD Creative Titanium
    	GameRegistry.registerBlock(NathanMod.creativeTitaniumOLD, "Creative Titanium");
    	NathanMod.creativeGlass = new CreativeGlass();						//Creative Glass
    	GameRegistry.registerBlock(NathanMod.creativeGlass, "Creative_Glass");
    	NathanMod.creativeGlassOLD = new CreativeGlassOLD();						//Creative Glass
    	GameRegistry.registerBlock(NathanMod.creativeGlassOLD, "Creative Glass");
    	NathanMod.creativeStoneBrick = new CreativeStoneBrick();			//Creative Stone Brick
    	GameRegistry.registerBlock(NathanMod.creativeStoneBrick, "Creative_Stone_Brick");
    	NathanMod.creativeQuartz = new CreativeQuartz();				//Creative Quartz
    	GameRegistry.registerBlock(NathanMod.creativeQuartz, "Creative_Quartz");
    	
    	//Blocks
    	NathanMod.titanium = new Titanium();								//Normal Titanium
    	GameRegistry.registerBlock(NathanMod.titanium, "Titanium");
    	NathanMod.titaniumOre = new TitaniumOre();							//Titanium Ore
    	GameRegistry.registerBlock(NathanMod.titaniumOre, "Titanium_Ore");
    	NathanMod.nathanLogs = new NathanLogs();								//Logs1
    	GameRegistry.registerBlock(NathanMod.nathanLogs, MultiItemLog.class, "NathanLogs");
    	NathanMod.nathanPlanks = new NathanPlanks("NathanPlanks");				//Planks1
    	GameRegistry.registerBlock(NathanMod.nathanPlanks, MultiItemPlanks.class, "NathanPlanks");
    	NathanMod.nathanLeaves = new NathanLeaves();							//Leaves1
    	GameRegistry.registerBlock(NathanMod.nathanLeaves, MultiItemLeaves.class, "NathanLeaves");
    	NathanMod.nathanSapplings = new BasicSappling();
    	GameRegistry.registerBlock(NathanMod.nathanSapplings, MultiItemSapplings.class, "NathanSapplings");

    	
    	
    	/*
    	NathanMod.NathanSlabs = new NathanSlabs(true);							//Half Slab
    	GameRegistry.registerBlock(NathanMod.NathanSlabs, ItemNathanSlab.class, "NathanSlabs");
    	
    	NathanMod.NathanSlabsDouble = new NathanSlabs(false);					//Full Slab
    	GameRegistry.registerBlock(NathanMod.NathanSlabsDouble, ItemNathanSlab.class, "NathanSlabsDouble");
    	*/
    	
	}
	
	//Items
	public static void itemInit() {
		//Titanium Ingot
		NathanMod.titaniumIngot = new TitaniumIngot();
		GameRegistry.registerItem(NathanMod.titaniumIngot, "Titanium_Ingot");
		//Space Suit Material
		NathanMod.spaceSuitMaterial = new SpaceSuitFabric();
		GameRegistry.registerItem(NathanMod.spaceSuitMaterial, "Space_Suit_Fabric");
		
		//Tools
		NathanMod.TitaniumSword = new BasicSword(NathanMod.TITANIUMTOOL, "TitaniumSword");
		GameRegistry.registerItem(NathanMod.TitaniumSword, "Titanium_Sword");
		NathanMod.TitaniumPickaxe = new BasicPickaxe(NathanMod.TITANIUMTOOL, "TitaniumPickaxe");
		GameRegistry.registerItem(NathanMod.TitaniumPickaxe, "Titanium_Pickaxe");
		NathanMod.TitaniumAxe = new BasicAxe(NathanMod.TITANIUMTOOL, "TitaniumAxe");
		GameRegistry.registerItem(NathanMod.TitaniumAxe, "Titanium_Axe");
		NathanMod.TitaniumHoe = new BasicHoe(NathanMod.TITANIUMTOOL, "TitaniumHoe");
		GameRegistry.registerItem(NathanMod.TitaniumHoe, "Titanium_Hoe");
		NathanMod.TitaniumShovel = new BasicShovel(NathanMod.TITANIUMTOOL, "TitaniumShovel");
		GameRegistry.registerItem(NathanMod.TitaniumShovel, "Titanium_Shovel");
		
		//Armour
		NathanMod.TitaniumHelmet = new BasicArmour(NathanMod.TITANIUM, "helmetTitanium", 0, "titanium");
		GameRegistry.registerItem(NathanMod.TitaniumHelmet, "Titanium_Helmet");
		NathanMod.TitaniumChestplate = new BasicArmour(NathanMod.TITANIUM, "chestplateTitanium", 1, "titanium");
		GameRegistry.registerItem(NathanMod.TitaniumChestplate, "Titanium_Chestplate");
		NathanMod.TitaniumLeggings = new BasicArmour(NathanMod.TITANIUM, "leggingsTitanium", 2, "titanium");
		GameRegistry.registerItem(NathanMod.TitaniumLeggings, "Titanium_Leggings");
		NathanMod.TitaniumBoots = new BasicArmour(NathanMod.TITANIUM, "bootsTitanium", 3, "titanium");
		GameRegistry.registerItem(NathanMod.TitaniumBoots, "Titanium_Boots");
		
		NathanMod.SpacesuitHelmet = new SpaceSuit(NathanMod.SPACESUIT, "helmetSpacesuit", 0, "spacesuit");
		GameRegistry.registerItem(NathanMod.SpacesuitHelmet, "Spacesuit_Helmet");
		NathanMod.SpacesuitChestplate = new SpaceSuit(NathanMod.SPACESUIT, "chestplateSpacesuit", 1, "spacesuit");
		GameRegistry.registerItem(NathanMod.SpacesuitChestplate, "Spacesuit_Chestplate");
		NathanMod.SpacesuitLeggings = new SpaceSuit(NathanMod.SPACESUIT, "leggingsSpacesuit", 2, "spacesuit");
		GameRegistry.registerItem(NathanMod.SpacesuitLeggings, "Spacesuit_Leggings");
		NathanMod.SpacesuitBoots = new SpaceSuit(NathanMod.SPACESUIT, "bootsSpacesuit", 3, "spacesuit");
		GameRegistry.registerItem(NathanMod.SpacesuitBoots, "Spacesuit_Boots");
	}
	
	//Recipes
	public static void recipeInit() {
		//Creative Glass
		GameRegistry.addRecipe(new ItemStack(NathanMod.creativeGlass), new Object[]{"AAA", "ABA", "AAA", 'A', Blocks.diamond_block, 'B', Blocks.glass});
		//Creative Titanium
		GameRegistry.addRecipe(new ItemStack(NathanMod.creativeTitanium), new Object[]{"AAA", "ABA", "AAA", 'A', Blocks.diamond_block, 'B', NathanMod.titanium});
		//Creative Stone Brick
		GameRegistry.addRecipe(new ItemStack(NathanMod.creativeStoneBrick), new Object[]{"AAA","ABA","AAA",'A', Blocks.diamond_block, 'B', Blocks.stonebrick});
		//Creative Quartz
		GameRegistry.addRecipe(new ItemStack(NathanMod.creativeQuartz), new Object[]{ "AAA", "ABA", "AAA", 'A', Blocks.diamond_block, 'B', Blocks.quartz_block});
		
		//Titanium
		GameRegistry.addRecipe(new ItemStack(NathanMod.titanium), new Object[]{ "AAA", "AAA", "AAA", 'A', NathanMod.titaniumIngot});
		
		//Titanium Ingot
		GameRegistry.addSmelting(NathanMod.titaniumOre, new ItemStack(NathanMod.titaniumIngot), 0.5F);
		//Titanium Ingot from titanium block
		GameRegistry.addShapelessRecipe(new ItemStack(NathanMod.titaniumIngot, 9, 1), new Object[]{new ItemStack(NathanMod.titanium, 1, 1)});
		//Space Suit Fabric
		GameRegistry.addRecipe(new ItemStack(NathanMod.spaceSuitMaterial), new Object[]{ "AAA", "CBC", "AAA", 'A', Items.leather, 'B', Items.redstone, 'C', Items.iron_ingot});
		
		//Things for all wood metadatas ---------------------------------------------------------------------------------
		for (int i=0; i<NathanMod.woodTypes.length; i++) {
			//Make planks from logs
			GameRegistry.addShapelessRecipe(new ItemStack(NathanMod.nathanPlanks, 4, i), new Object[]{new ItemStack(NathanMod.nathanLogs, 1, i)});
			//Make sticks from planks
			GameRegistry.addRecipe(new ItemStack(Items.stick, 4), "A", "A", 'A', new ItemStack(NathanMod.nathanPlanks, 1, i));
			//Make crafting table from planks
			GameRegistry.addRecipe(new ItemStack(Blocks.crafting_table, 1), "AA", "AA", 'A', new ItemStack(NathanMod.nathanPlanks, 1, i));
			//Convert my wood planks into oak wood planks
			GameRegistry.addRecipe(new ItemStack(Blocks.planks, 1), "A", 'A', new ItemStack(NathanMod.nathanPlanks, 1, i));
		}
		
		//Tool recipies ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
		GameRegistry.addRecipe(new ItemStack(NathanMod.TitaniumSword), new Object[]{" A ", " A ", " B ", 'A', NathanMod.titaniumIngot, 'B', Items.stick});
		GameRegistry.addRecipe(new ItemStack(NathanMod.TitaniumPickaxe), new Object[]{"AAA", " B ", " B ", 'A', NathanMod.titaniumIngot, 'B', Items.stick});
		GameRegistry.addRecipe(new ItemStack(NathanMod.TitaniumAxe), new Object[]{"AA ", "AB ", " B ", 'A', NathanMod.titaniumIngot, 'B', Items.stick});
		GameRegistry.addRecipe(new ItemStack(NathanMod.TitaniumShovel), new Object[]{" A ", " B ", " B ", 'A', NathanMod.titaniumIngot, 'B', Items.stick});
		GameRegistry.addRecipe(new ItemStack(NathanMod.TitaniumHoe), new Object[]{"AA ", " B ", " B ", 'A', NathanMod.titaniumIngot, 'B', Items.stick});
		
		//Armor recipies -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		//Titanium Helmet
		GameRegistry.addRecipe(new ItemStack(NathanMod.TitaniumHelmet), new Object[]{"AAA", "A A", 'A', NathanMod.titaniumIngot });
		GameRegistry.addRecipe(new ItemStack(NathanMod.TitaniumChestplate), new Object[]{"A A", "AAA", "AAA", 'A', NathanMod.titaniumIngot});
		GameRegistry.addRecipe(new ItemStack(NathanMod.TitaniumLeggings), new Object[]{"AAA", "A A", "A A", 'A', NathanMod.titaniumIngot});
		GameRegistry.addRecipe(new ItemStack(NathanMod.TitaniumBoots), new Object[]{"A A", "A A", 'A', NathanMod.titaniumIngot});
		
		//Space Suit
		GameRegistry.addRecipe(new ItemStack(NathanMod.SpacesuitHelmet), new Object[]{"AAA", "A A", 'A', NathanMod.spaceSuitMaterial});
		GameRegistry.addRecipe(new ItemStack(NathanMod.SpacesuitChestplate), new Object[]{"A A", "AAA", "AAA", 'A', NathanMod.spaceSuitMaterial});
		GameRegistry.addRecipe(new ItemStack(NathanMod.SpacesuitLeggings), new Object[]{"AAA", "A A", "A A", 'A', NathanMod.spaceSuitMaterial});
		GameRegistry.addRecipe(new ItemStack(NathanMod.SpacesuitBoots), new Object[]{"A A", "A A", 'A', NathanMod.spaceSuitMaterial});
	}
}
