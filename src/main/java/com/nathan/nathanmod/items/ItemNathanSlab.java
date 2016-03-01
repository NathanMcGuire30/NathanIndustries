package com.nathan.nathanmod.items;

import com.nathan.nathanmod.NathanMod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;

public class ItemNathanSlab extends ItemSlab {

	public ItemNathanSlab(Block block) {
		super(block, (BlockSlab)NathanMod.NathanSlabs, (BlockSlab)NathanMod.NathanSlabsDouble, false);
		this.setMaxDamage(15);
	    this.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack stack) {
		if (stack.getItemDamage() >= 0 && stack.getItemDamage() < NathanMod.WoodTypes.length) {
			return NathanMod.WoodTypes[stack.getItemDamage()] + "Slabs";
		} else {
			return "Hickory";
		}
	}
}
