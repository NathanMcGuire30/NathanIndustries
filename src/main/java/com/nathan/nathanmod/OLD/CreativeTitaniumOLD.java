package com.nathan.nathanmod.OLD;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.nathan.nathanmod.NathanMod;

//Old compatibility Titanium
public class CreativeTitaniumOLD extends Block {
	public CreativeTitaniumOLD() {
		super(Material.anvil);
		setBlockName(NathanMod.MODID + "_creativeTitaniumOLD");
		setBlockTextureName(NathanMod.MODID + ":Block_Titanium");
		setHardness(50000F);
		setCreativeTab(null);
	}
}
