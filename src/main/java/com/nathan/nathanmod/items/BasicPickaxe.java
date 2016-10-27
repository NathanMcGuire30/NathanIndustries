package com.nathan.nathanmod.items;

import com.nathan.nathanmod.NathanMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class BasicPickaxe extends ItemPickaxe {

	public BasicPickaxe(ToolMaterial material, String unlocalizedName) {
		super(material);
		this.setUnlocalizedName(NathanMod.MODID + "_" + unlocalizedName);
        this.setTextureName(NathanMod.MODID + ":" + unlocalizedName);
        setCreativeTab(CreativeTabs.tabTools);
	}
}
