package com.nathan.nathanmod.blocks;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.nathan.nathanmod.NathanMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class NathanSlabs extends BlockSlab {
	private String[] woodTypes;
    private static final String __OBFID = "CL_00000337";
	private IIcon[] iconArray;
	private boolean isDouble;
	
	public NathanSlabs(boolean isHalf) {
		super(isHalf, Material.wood);
		this.setCreativeTab(CreativeTabs.tabBlock);
		if (NathanMod.WoodTypes.length < 8) {
			woodTypes = new String[NathanMod.WoodTypes.length];
			woodTypes = NathanMod.WoodTypes;
		} else {
			woodTypes = new String[8];
			woodTypes = Arrays.copyOfRange(NathanMod.WoodTypes, 0, 7);
		}
		isDouble = isHalf;
	}
	

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return Blocks.planks.getIcon(p_149691_1_, p_149691_2_ & 7);
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(Blocks.wooden_slab);
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int p_149644_1_)
    {
        return new ItemStack(Item.getItemFromBlock(Blocks.wooden_slab), 2, p_149644_1_ & 7);
    }

    public String func_150002_b(int p_150002_1_)
    {
        if (p_150002_1_ < 0 || p_150002_1_ >= woodTypes.length)
        {
            p_150002_1_ = 0;
        }

        return super.getUnlocalizedName() + "." + woodTypes[p_150002_1_];
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
        if (p_149666_1_ != Item.getItemFromBlock(Blocks.double_wooden_slab))
        {
            for (int i = 0; i < woodTypes.length; ++i)
            {
                p_149666_3_.add(new ItemStack(p_149666_1_, 1, i));
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_) {}
	
}
