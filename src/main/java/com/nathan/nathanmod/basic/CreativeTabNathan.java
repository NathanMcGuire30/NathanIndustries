package com.nathan.nathanmod.basic;

import com.nathan.nathanmod.NathanMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.nathan.nathanmod.NathanMod;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabNathan extends CreativeTabs {
	private Block iconBlock;
	
    public CreativeTabNathan(String tabLabel, Block blockForIcon) {
        super(tabLabel);
        iconBlock = blockForIcon;
    }

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return Item.getItemFromBlock(NathanMod.titanium);
	}
}
