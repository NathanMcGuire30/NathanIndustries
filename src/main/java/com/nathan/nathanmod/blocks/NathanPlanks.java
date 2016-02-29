package com.nathan.nathanmod.blocks;

import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.nathan.nathanmod.NathanMod;

public class NathanPlanks extends Block{
	private IIcon[] iconArray;
	private String[] woodTypes;
	
	public NathanPlanks(String name) {
		super(Material.wood);
		setBlockName(name);
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2F);
		if (NathanMod.WoodTypes.length < 16) {
			woodTypes = new String[NathanMod.WoodTypes.length];
			woodTypes = NathanMod.WoodTypes;
		} else {
			woodTypes = new String[16];
			woodTypes = Arrays.copyOfRange(NathanMod.WoodTypes, 0, 15);
		}
	}
	
	@Override
    public void registerBlockIcons(IIconRegister reg) { 
		this.iconArray = new IIcon[woodTypes.length];

        for (int i=0; i < this.iconArray.length; i++)
        {
            this.iconArray[i] = reg.registerIcon(NathanMod.MODID + ":planks_" + woodTypes[i]);
        }
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		if (meta < 0 || meta >= woodTypes.length) {
			meta=0;
		}
		return iconArray[meta];
	}
	
	@Override
	public int damageDropped(int meta) {
	    return meta;
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
	    for (int i=0; i < woodTypes.length; i ++) {
	        list.add(new ItemStack(item, 1, i));
	    }
	}
}
