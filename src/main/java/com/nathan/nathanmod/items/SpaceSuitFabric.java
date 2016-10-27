package com.nathan.nathanmod.items;

import com.nathan.nathanmod.NathanMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SpaceSuitFabric extends Item {
	public SpaceSuitFabric () {
		setUnlocalizedName(NathanMod.MODID + "_SpaceSuitFabric");
		setTextureName(NathanMod.MODID + ":SpaceSuitFabric");
		setCreativeTab(NathanMod.tabNathan);
	}
}
