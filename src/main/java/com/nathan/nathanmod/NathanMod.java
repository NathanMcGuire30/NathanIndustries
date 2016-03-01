package com.nathan.nathanmod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.nathan.nathanmod.basic.BasicInit;
import com.nathan.nathanmod.basic.CreativeTabNathan;
import com.nathan.nathanmod.blocks.NathanLogs;
import com.nathan.nathanmod.world.TreeList;
import com.nathan.nathanmod.world.WorldGenTitanium;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = NathanMod.MODID, version = NathanMod.VERSION)
public class NathanMod
{
    public static final String MODID = "nathanmod";
    public static final String VERSION = "3.0";
    public static final String NAME = "Nathan Industries";
    
    //Creative tab
    public static CreativeTabs tabNathan = new CreativeTabNathan("Nathan Industries");
    
    //Wood types
    public static String[] WoodTypes;
    
    //Blocks
    public static Block creativeTitanium;
    public static Block creativeGlass;
    public static Block creativeStoneBrick;
	public static Block Titanium;
	public static Block TitaniumOre;
	public static Block creativeTitaniumOLD;
	public static Block creativeQuartz;
	public static Block creativeGlassOLD;
	public static Block NathanLogs;
	public static Block NathanPlanks;
	public static Block NathanLeaves;
	public static Block NathanSlabs;
	public static Block NathanSlabsDouble;
	
	//Items
	public static Item TitaniumIngot;
	
	//pre-initialization
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
    	WoodTypes = new String[2];
    	WoodTypes[0] = "Hickory";
    	WoodTypes[1] = "elm";
    }
    
    //initialization
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	BasicInit.BlockInit();				//registers all the blocks
    	BasicInit.ItemInit();				//Registers all items
    	BasicInit.RecipeInit();				//registers all the recipes
    	
    	//World block generator
    	GameRegistry.registerWorldGenerator(new WorldGenTitanium(), 0);
    	GameRegistry.registerWorldGenerator(new TreeList(), 0);
    }
}
