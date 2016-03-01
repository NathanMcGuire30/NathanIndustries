package com.nathan.nathanmod.items;

import com.nathan.nathanmod.NathanMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TitaniumIngot extends Item {
	public TitaniumIngot () {
		setUnlocalizedName(NathanMod.MODID + "_Titanium_Ingot");
		setTextureName(NathanMod.MODID + ":ingotTitanium");
		setCreativeTab(CreativeTabs.tabMaterials);
	}
}
