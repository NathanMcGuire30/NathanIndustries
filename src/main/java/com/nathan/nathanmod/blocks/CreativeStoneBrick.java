package com.nathan.nathanmod.blocks;

import com.nathan.nathanmod.NathanMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeStoneBrick extends Block {
	public CreativeStoneBrick() {
		super(Material.anvil);
		setBlockName(NathanMod.MODID + "_creativeStoneBrick");
		setBlockTextureName("stonebrick");
		setCreativeTab(NathanMod.tabNathan);
		setHardness(50000F);
	}
}
