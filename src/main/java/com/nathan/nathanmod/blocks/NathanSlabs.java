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
		super(!isHalf, Material.wood);
		if (isHalf == true) {
			this.setCreativeTab(CreativeTabs.tabBlock);
		}
		if (NathanMod.woodTypes.length < 8) {
			woodTypes = new String[NathanMod.woodTypes.length];
			woodTypes = NathanMod.woodTypes;
		} else {
			woodTypes = new String[8];
			woodTypes = Arrays.copyOfRange(NathanMod.woodTypes, 0, 7);
		}
		isDouble = !isHalf;
	}
	
	public boolean isDoubleSlab() {
		return isDouble;
	}

	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg) {
		this.iconArray = new IIcon[woodTypes.length];

        for (int i=0; i < this.iconArray.length; i++)
        {
        	this.iconArray[i] = reg.registerIcon(NathanMod.MODID + ":planks_" + woodTypes[i]);
        }
	}
	
    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
    	if (meta > 7) {
			meta%=8; 
		} 
    	if (meta < 0 || (meta >= woodTypes.length && meta <= 7)) {
			meta=0;
		}
		return iconArray[meta];
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(Blocks.wooden_slab);
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int meta)
    {
    	return new ItemStack(NathanMod.nathanSlabs, meta);
    }

    //Get unlocalised name or something
    public String func_150002_b(int meta)
    {
      if (meta < 0 || meta >= woodTypes.length)
      {
          meta = 0;
      }
      if (this.isDouble == true) {
    	  return "NathanMod.Double." + woodTypes[meta];
      } else {
    	  return "NathanMod." + woodTypes[meta] + "slab";
      }
      
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
    
	// Minecraft's BlockSlab overrides this for their slabs, so we change it back to normal here
	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(this);
	}
	
}
