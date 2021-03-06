package com.nathan.nathanmod.blocks;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.nathan.nathanmod.NathanMod;
import com.nathan.nathanmod.world.tree.MakeBigTree;
import com.nathan.nathanmod.world.tree.MakeBigTree2;
import com.nathan.nathanmod.world.tree.MakeNormalTree;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BasicSappling extends BlockBush implements IGrowable {
	private IIcon[] iconArray;
	private String[] woodTypes;
	
	public BasicSappling()
    {
        float f = 0.4F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        
        //Create wood types array
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
    public int damageDropped(int meta)
    {
        return(meta);
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
    	for (int i=0; i < woodTypes.length; i ++) {
 	        list.add(new ItemStack(item, 1, i));
 	    }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg) {
		this.iconArray = new IIcon[woodTypes.length];
        for (int i=0; i < this.iconArray.length; i++)
        {
            this.iconArray[i] = reg.registerIcon(NathanMod.MODID + ":sappling_" + woodTypes[i]);
        }
    }
	
    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
		if (meta < 0 || meta >= woodTypes.length) {
			meta=0;
		}
		return iconArray[meta];
    }
	
	
	
	/**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World world, int x, int y, int z, Random random)
    {
        if (!world.isRemote)
        {
            super.updateTick(world, x, y, z, random);

            if (world.getBlockLightValue(x, y + 1, z) >= 9 && random.nextInt(7) == 0)
            {
                this.func_149879_c(world, x, y, z, random);
            }
        }
    }
    
    public void func_149879_c(World world, int x, int y, int z, Random random)
    {
        int l = world.getBlockMetadata(x, y, z);

        if ((l & 8) == 0) {
            world.setBlockMetadataWithNotify(x, y, z, l | 8, 4);
        } else {
            this.func_149878_d(world, x, y, z, random);
        }
    }
    
    //The function that actually grows the tree
    public void func_149878_d(World world, int x, int y, int z, Random random)
    {
        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(world, random, x, y, z)) return;
        int meta = world.getBlockMetadata(x, y, z) & 7;
        int i1 = 0;
        int j1 = 0;
        boolean flag = false;

        Block block = Blocks.air;
        if (flag)
        {
            world.setBlock(x + i1, y, z + j1, block, 0, 4);
            world.setBlock(x + i1 + 1, y, z + j1, block, 0, 4);
            world.setBlock(x + i1, y, z + j1 + 1, block, 0, 4);
            world.setBlock(x + i1 + 1, y, z + j1 + 1, block, 0, 4);
        }
        else
        {
            world.setBlock(x, y, z, block, 0, 4);
        }
        
        //Generate the tree!
        NathanMod.treeGenTypes.genSapplingTree(meta, world, random, x, z);
    }
    
    public boolean func_149880_a(World world, int x, int y, int z, int metadata)
    {
        return world.getBlock(x, y, z) == this && (world.getBlockMetadata(x, y, z) & 7) == metadata;
    }
    
    public boolean func_149851_a(World world, int x, int y, int z, boolean p_149851_5_)
    {
        return true;
    }

    public boolean func_149852_a(World world, Random random, int x, int y, int z)
    {
        return (double)world.rand.nextFloat() < 0.45D;
    }

    public void func_149853_b(World world, Random random, int x, int y, int z)
    {
        this.func_149879_c(world, x, y, z, random);
    }
}
