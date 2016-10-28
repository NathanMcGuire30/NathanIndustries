package com.nathan.nathanmod.items;

import com.nathan.nathanmod.NathanMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class SpaceSuit extends ItemArmor {
	private String textureName;

	public SpaceSuit(ArmorMaterial material, String name, int type, String texturename) {
		super(material, 0, type);
		setUnlocalizedName(NathanMod.MODID + name);
		setTextureName(NathanMod.MODID + ":" + name);
		setCreativeTab(NathanMod.tabNathan);
		textureName = texturename;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return NathanMod.MODID + ":textures/models/armor/" + this.textureName + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
	}
}
