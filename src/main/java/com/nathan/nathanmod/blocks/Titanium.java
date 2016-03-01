package com.nathan.nathanmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import com.nathan.nathanmod.NathanMod;

public class Titanium extends Block{
	public Titanium() {
		super(Material.iron);
		setBlockName(NathanMod.MODID + "_Titanium");
		setBlockTextureName(NathanMod.MODID + ":Block_Titanium");
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(10F);
	}
}
