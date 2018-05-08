package com.nathan.nathanmod.blocks;

import java.util.Arrays;
import java.util.List;

import com.nathan.nathanmod.NathanMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

//IMPORNTANT:	ALL REFRENCES TO WOODTYPES ARRAY NEED TO CHANGE WHEN THE LENGTH OF THAT ARRAY IS >3
public class NathanLogs extends BlockLog {
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;
	private String[] woodTypes;
    private static final String __OBFID = "CL_00000335";

    public NathanLogs()
    {
        this.setCreativeTab(CreativeTabs.tabBlock);
        setBlockName("NathanLog");
        setHardness(2F);
        if (NathanMod.woodTypes.length < 4) {
			woodTypes = new String[NathanMod.woodTypes.length];
			woodTypes = NathanMod.woodTypes;
		} else {
			woodTypes = new String[4];
			woodTypes = Arrays.copyOfRange(NathanMod.woodTypes, 0, 3);
		}
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     * Has to change when >4 types of wood
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs p_149666_2_, List list)
    {
    	for (int i=0; i < woodTypes.length; i ++) {
	        list.add(new ItemStack(item, 1, i));
	    }
    }
    
    /**
     * Registers icons
     * Has to change when >4 types of wood
     */
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg)
    {
        this.iconArray = new IIcon[((woodTypes.length)*2)];

        for (int i=0; i < this.iconArray.length; i+=2)
        {
            this.iconArray[i] = reg.registerIcon(NathanMod.MODID + ":wood_" + woodTypes[i/2] + "_Side");
            this.iconArray[i+1] = reg.registerIcon(NathanMod.MODID + ":wood_" + woodTypes[i/2] + "_Top");
        }
    }

    /**
     * gets side icon
     */
    @SideOnly(Side.CLIENT)
    protected IIcon getSideIcon(int meta)
    {
    	if (meta < 0 || (meta >= woodTypes.length && meta < 4)) {
			meta=0;
		} else if (meta > 3) {
			meta %=4; 
		}
        return this.iconArray[meta*2];
    }

    //Returns top texture
    @SideOnly(Side.CLIENT)
    protected IIcon getTopIcon(int meta)
    {
    	if (meta < 0 || (meta >= woodTypes.length && meta < 4)) {
			meta=0;
		} else if (meta > 3) {
			meta %=4; 
		}
        return this.iconArray[(2*meta)+1];
    }
}
