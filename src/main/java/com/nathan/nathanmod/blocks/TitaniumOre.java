package com.nathan.nathanmod.blocks;

import java.util.Random;

import com.nathan.nathanmod.NathanMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class TitaniumOre extends Block {
	public TitaniumOre() {
		super(Material.rock);
		setBlockName(NathanMod.MODID + "_TitaniumOre");
		setBlockTextureName(NathanMod.MODID + ":oreTitanium");
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(3F);
	}
}
