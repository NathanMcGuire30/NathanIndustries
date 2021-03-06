package com.nathan.nathanmod.items;

import com.nathan.nathanmod.NathanMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

public class BasicAxe extends ItemAxe {

	public BasicAxe(ToolMaterial material, String unlocalizedName) {
		super(material);
		this.setUnlocalizedName(NathanMod.MODID + "_" + unlocalizedName);
        this.setTextureName(NathanMod.MODID + ":" + unlocalizedName);
        setCreativeTab(CreativeTabs.tabTools);
	}
}
