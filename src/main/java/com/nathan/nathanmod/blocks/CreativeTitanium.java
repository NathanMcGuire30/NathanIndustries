package com.nathan.nathanmod.blocks;

import com.nathan.nathanmod.NathanMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTitanium extends Block {
	public CreativeTitanium() {
		super(Material.anvil);
		setBlockName(NathanMod.MODID + "_creativeTitanium");
		setBlockTextureName(NathanMod.MODID + ":Block_Titanium");
		setCreativeTab(NathanMod.tabNathan);
		setHardness(50000F);
	}
}
