package com.nathan.nathanmod.blocks;

import com.nathan.nathanmod.NathanMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class CreativeQuartz extends Block{
	public CreativeQuartz() {
		super(Material.anvil);
		setBlockName(NathanMod.MODID + "_creativeQuartz");
		setBlockTextureName("quartz_block_side");
		setCreativeTab(NathanMod.tabNathan);
		setHardness(50000F);
	}
}
