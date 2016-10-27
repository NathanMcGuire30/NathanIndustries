package com.nathan.nathanmod.basic;

import com.nathan.nathanmod.NathanMod;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class MultiItemSapplings extends ItemBlockWithMetadata {
	public MultiItemSapplings(Block block) {
        super(block, block);
    }
	
	public String getUnlocalizedName(ItemStack stack) {
		if (stack.getItemDamage() >= 0 && stack.getItemDamage() < NathanMod.WoodTypes.length) {
			return NathanMod.WoodTypes[stack.getItemDamage()] + "Sapplings";
		} else {
			return "Hickory";
		}
	}
}