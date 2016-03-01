package com.nathan.nathanmod.basic;

import com.nathan.nathanmod.NathanMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.Facing;
import net.minecraft.world.IBlockAccess;

//Used by any glass that I make.  Allows see through blocks
public class NathanGlass extends Block {
	private static boolean field_149996_a;
	private String iconPath;
	
	protected NathanGlass(Material material, String iconPath) {
		super(material);
		this.iconPath = iconPath;
	}
	/*
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int cordX, int cordY, int cordZ, int side)
    {
        Block block = blockAccess.getBlock(cordX, cordY, cordZ);

        if (this == NathanMod.creativeGlass)
        {
            if (blockAccess.getBlockMetadata(cordX, cordY, cordZ) != blockAccess.getBlockMetadata(cordX - Facing.offsetsXForSide[side], cordY - Facing.offsetsYForSide[side], cordZ - Facing.offsetsZForSide[side]))
            {
                return true;
            }

            if (block == this)
            {
                return false;
            }
        }

        return !this.field_149996_a && block == this ? false : super.shouldSideBeRendered(blockAccess, cordX, cordY, cordZ, side);
    }
	
	/**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 0;
    }
    
    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg)
    {
        this.blockIcon = reg.registerIcon(this.iconPath);
    }
}
