package com.nathan.nathanmod.basic;

import com.nathan.nathanmod.NathanMod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;


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
	public Item getTabIconItem() {
		return Item.getItemFromBlock(iconBlock);
	}
}
