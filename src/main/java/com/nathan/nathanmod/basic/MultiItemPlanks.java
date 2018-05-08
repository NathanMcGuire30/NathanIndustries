package com.nathan.nathanmod.basic;

import com.nathan.nathanmod.NathanMod;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class MultiItemPlanks extends ItemBlockWithMetadata {
	public MultiItemPlanks(Block block) {
        super(block, block);
    }
	
	public String getUnlocalizedName(ItemStack stack) {
		if (stack.getItemDamage() >= 0 && stack.getItemDamage() < NathanMod.woodTypes.length) {
			return NathanMod.woodTypes[stack.getItemDamage()] + "Planks";
		} else {
			return "Hickory";
		}
	}
}
