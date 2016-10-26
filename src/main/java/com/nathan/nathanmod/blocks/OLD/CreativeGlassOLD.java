package com.nathan.nathanmod.blocks.OLD;

import com.nathan.nathanmod.NathanMod;

import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;

public class CreativeGlassOLD extends BlockGlass{
	private static boolean field_149996_a;

	public CreativeGlassOLD() {
		super(Material.anvil, field_149996_a);
		setBlockName(NathanMod.MODID + "_creativeGlassOLD");
		setHardness(50000F);
		setCreativeTab(null);
	}
}
