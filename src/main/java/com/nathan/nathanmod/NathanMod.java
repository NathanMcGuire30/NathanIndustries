package com.nathan.nathanmod;

import com.nathan.nathanmod.basic.BasicInit;
import com.nathan.nathanmod.basic.CreativeTabNathan;
import com.nathan.nathanmod.world.WorldGenTrees;
import com.nathan.nathanmod.world.tree.TreeGenTypes;
import com.nathan.nathanmod.world.WorldGenBasicMineable;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;

@Mod(modid = NathanMod.MODID, version = NathanMod.VERSION)
public class NathanMod
{
    public static final String MODID = "nathanmod";
    public static final String VERSION = "4.2";
    public static final String NAME = "Nathan Industries";
    
    //Wood types
    public static String[] woodTypes;
    
    //Blocks
    public static Block creativeTitanium;
    public static Block creativeGlass;
    public static Block creativeStoneBrick;
	public static Block titanium;
	public static Block titaniumOre;
	public static Block creativeTitaniumOLD;
	public static Block creativeQuartz;
	public static Block creativeGlassOLD;
	public static Block nathanLogs;
	public static Block nathanPlanks;
	public static Block nathanLeaves;
	public static Block nathanSlabs;
	public static Block nathanSlabsDouble;
	public static Block nathanSapplings;
	
	//Items
	public static Item titaniumIngot;
	public static Item spaceSuitMaterial;
	
	public static Item TitaniumSword;
	public static Item TitaniumPickaxe;
	public static Item TitaniumAxe;
	public static Item TitaniumHoe;
	public static Item TitaniumShovel;
	
	public static Item TitaniumHelmet;
	public static Item TitaniumChestplate;
	public static Item TitaniumLeggings;
	public static Item TitaniumBoots;
	
	public static Item SpacesuitHelmet;
	public static Item SpacesuitChestplate;
	public static Item SpacesuitLeggings;
	public static Item SpacesuitBoots;
	
    //Creative tab
    public static CreativeTabs tabNathan = new CreativeTabNathan("Nathan Industries", NathanMod.titanium);
	
	//Materials
	public static ArmorMaterial TITANIUM = net.minecraftforge.common.util.EnumHelper.addArmorMaterial("TITANIUM", 16, new int[] {4, 9, 7, 4}, 30);
	public static ArmorMaterial SPACESUIT = net.minecraftforge.common.util.EnumHelper.addArmorMaterial("SPACESUIT", 5, new int[] {1, 1, 1, 1}, 0);
	
	public static ToolMaterial TITANIUMTOOL = net.minecraftforge.common.util.EnumHelper.addToolMaterial("Titanium", 3, 1561, 10.0F, 6, 25);
	
	//Tree types code
	public static TreeGenTypes treeGenTypes;
	
	//pre-initialization
    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
    	woodTypes = new String[3];
    	woodTypes[0] = "Hickory";
    	woodTypes[1] = "Elm";
    	woodTypes[2] = "Beech";
    }
    
    //initialization
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	BasicInit.blockInit();				//registers all the blocks
    	BasicInit.itemInit();				//Registers all items
    	BasicInit.recipeInit();				//registers all the recipes
    	
    	//TreGen init
    	treeGenTypes = new TreeGenTypes();
    	
    	//World block generator
    	GameRegistry.registerWorldGenerator(new WorldGenBasicMineable(NathanMod.titaniumOre, 13), 0);
    	GameRegistry.registerWorldGenerator(new WorldGenTrees(), 0);
    }
}
