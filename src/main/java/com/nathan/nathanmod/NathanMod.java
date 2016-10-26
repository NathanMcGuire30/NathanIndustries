package com.nathan.nathanmod;

import com.nathan.nathanmod.basic.BasicInit;
import com.nathan.nathanmod.basic.CreativeTabNathan;
import com.nathan.nathanmod.world.TreeList;
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
    public static final String VERSION = "4.0";
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
	public static Item SpaceSuitMaterial;
	
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
	
	
	//Matierals
	public static ArmorMaterial TITANIUM = net.minecraftforge.common.util.EnumHelper.addArmorMaterial("TITANIUM", 16, new int[] {4, 9, 7, 4}, 30);
	public static ArmorMaterial SPACESUIT = net.minecraftforge.common.util.EnumHelper.addArmorMaterial("SPACESUIT", 5, new int[] {1, 1, 1, 1}, 0);
	
	public static ToolMaterial TITANIUMTOOL = net.minecraftforge.common.util.EnumHelper.addToolMaterial("Titanium", 3, 1561, 10.0F, 6, 25);
	
	//pre-initialization
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
    	WoodTypes = new String[3];
    	WoodTypes[0] = "Hickory";
    	WoodTypes[1] = "elm";
    	WoodTypes[2] = "beech";
    }
    
    //initialization
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	BasicInit.BlockInit();				//registers all the blocks
    	BasicInit.ItemInit();				//Registers all items
    	BasicInit.RecipeInit();				//registers all the recipes
    	
    	//World block generator
    	GameRegistry.registerWorldGenerator(new WorldGenBasicMineable(NathanMod.TitaniumOre), 0);
    	GameRegistry.registerWorldGenerator(new TreeList(), 0);
    }
}
