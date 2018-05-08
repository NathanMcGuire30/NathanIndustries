package com.nathan.nathanmod.basic;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

import com.nathan.nathanmod.NathanMod;

public class MultiItemLog extends ItemBlockWithMetadata {
	public MultiItemLog(Block block) {
        super(block, block);
	}
	
	public String getUnlocalizedName(ItemStack stack) {
		if (stack.getItemDamage() < 0 || (stack.getItemDamage() >= NathanMod.woodTypes.length && stack.getItemDamage() < 4)) {
			return "Hickory";
		} else if (stack.getItemDamage() > 3) {
			int i; 
			i = stack.getItemDamage()%4;
			return NathanMod.woodTypes[i] + "Log";
		} else {
			return NathanMod.woodTypes[stack.getItemDamage()] + "Log";
		}
	}
}
