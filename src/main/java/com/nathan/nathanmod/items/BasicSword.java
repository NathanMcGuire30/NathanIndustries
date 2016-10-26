package com.nathan.nathanmod.items;

import com.nathan.nathanmod.NathanMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class BasicSword extends ItemSword {

	public BasicSword(ToolMaterial material, String unlocalizedName) {
		super(material);
		this.setUnlocalizedName(NathanMod.MODID + "_" + unlocalizedName);
        this.setTextureName(NathanMod.MODID + ":" + unlocalizedName);
        setCreativeTab(CreativeTabs.tabCombat);
	}
}
