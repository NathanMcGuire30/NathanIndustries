package com.nathan.nathanmod.items;

import com.nathan.nathanmod.NathanMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;

public class BasicHoe extends ItemHoe {

	public BasicHoe(ToolMaterial material, String unlocalizedName) {
		super(material);
		this.setUnlocalizedName(NathanMod.MODID + "_" + unlocalizedName);
        this.setTextureName(NathanMod.MODID + ":" + unlocalizedName);
        setCreativeTab(CreativeTabs.tabTools);
	}
}
