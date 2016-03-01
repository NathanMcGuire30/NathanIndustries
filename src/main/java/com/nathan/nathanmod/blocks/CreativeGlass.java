package com.nathan.nathanmod.blocks;

import com.nathan.nathanmod.NathanMod;
import com.nathan.nathanmod.basic.NathanGlass;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.Facing;
import net.minecraft.world.IBlockAccess;

public class CreativeGlass extends NathanGlass {
	public static String iconPath = "glass";	//NathanMod.MODID + ":Block_CGlass"

	public CreativeGlass() {
		super(Material.anvil, iconPath);
		setBlockName(NathanMod.MODID + "_creativeGlass");
		setCreativeTab(NathanMod.tabNathan);
		setHardness(50000F);
		setBlockTextureName(iconPath);
	}
}
