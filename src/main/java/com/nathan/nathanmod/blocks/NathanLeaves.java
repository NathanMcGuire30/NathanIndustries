package com.nathan.nathanmod.blocks;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.nathan.nathanmod.NathanMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NathanLeaves extends BlockLeaves {
    private static final String __OBFID = "CL_00000276";
	private IIcon[] iconArray;
	private boolean graphicsLevel = false;			//False = fancy graphics
	private String[] woodTypes;

	public NathanLeaves () {
		super();
		if (NathanMod.woodTypes.length < 16) {
			woodTypes = new String[NathanMod.woodTypes.length];
			woodTypes = NathanMod.woodTypes;
		} else {
			woodTypes = new String[16];
			woodTypes = Arrays.copyOfRange(NathanMod.woodTypes, 0, 15);
		}
	}
	
    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int p_149692_1_)
    {
        return super.damageDropped(p_149692_1_);
    }
    
    /**
     * Get the block's damage value (for use with pick block).
     */
    public int getDamageValue(World world, int x, int y, int z)
    {
        return world.getBlockMetadata(x, y, z);
    }
    
    /**
     * Gets the block's texture. Args: side, meta
     * Called once per tick
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
    	//graphicsLevel = GameSettings.fancyGraphics;
    	if (meta < 0 || meta >= woodTypes.length) {
			meta=0;
		}
    	if (this.graphicsLevel == false) {
    		return this.iconArray[(2*meta)+1];
    	} else {
    		return this.iconArray[meta*2];
    	}
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
    	for (int i = 0; i < woodTypes.length; i ++) {
	        list.add(new ItemStack(item, 1, i));
	    }
    }
    
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(NathanMod.nathanSapplings);
    }

    //Registers meta icons
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg)
    {
    	this.iconArray = new IIcon[((woodTypes.length)*2)];

        for (int i=0; i < this.iconArray.length; i+=2)
        {
            this.iconArray[i] = reg.registerIcon(NathanMod.MODID + ":leaves_" + woodTypes[i/2]);
            this.iconArray[i+1] = reg.registerIcon(NathanMod.MODID + ":leaves_" + woodTypes[i/2] + "_opaque");
        }
    }

    public String[] func_150125_e()
    {
        return woodTypes;
    }
    
    /**
     * Is it an opaque cube?
     * If ever fast graphics, return true
     * Called once per tick
     */
    public boolean isOpaqueCube()
    {
    	graphicsLevel = Minecraft.getMinecraft().gameSettings.fancyGraphics;
        return !graphicsLevel;
    }
    
    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int cordX, int cordY, int cordZ, int side)
    {
        return true;
    }
}
