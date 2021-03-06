package com.nathan.nathanmod.items;

import com.nathan.nathanmod.NathanMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemNathanSlab extends ItemSlab {
	private final boolean isDouble;
	private final BlockSlab singleSlab;
	private final BlockSlab doubleSlab;
	private static final String __OBFID = "CL_00000071";

	public ItemNathanSlab(Block block)
	{
		super(block, (BlockSlab) NathanMod.nathanSlabs, (BlockSlab) NathanMod.nathanSlabsDouble, false);
		singleSlab = (BlockSlab) NathanMod.nathanSlabs;
		doubleSlab = (BlockSlab) NathanMod.nathanSlabsDouble;
		isDouble = false;
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	/**
	 * Gets an icon index based on an item's damage value
	 */
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1)
	{
		return Block.getBlockFromItem(this).getIcon(2, par1);
	}

	/**
	 * Returns the metadata of the block which this Item (ItemBlock) can place
	 */
	public int getMetadata(int par1)
	{
		return par1;
	}

	/**
	 * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
	 * different names based on their damage or NBT.
	 */
	public String getUnlocalizedName(ItemStack is)
	{
		return singleSlab.func_150002_b(is.getItemDamage());
	}

	/**
	 * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
	 * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
	 */
	public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		if (isDouble)
		{
			return super.onItemUse(is, player, world, par4, par5, par6, par7, par8, par9, par10);
		}
		else if (is.stackSize == 0)
		{
			return false;
		}
		else if (!player.canPlayerEdit(par4, par5, par6, par7, is))
		{
			return false;
		}
		else
		{
			Block block = world.getBlock(par4, par5, par6);
			int i1 = world.getBlockMetadata(par4, par5, par6);
			int j1 = i1 & 7;
			boolean flag = (i1 & 8) != 0;

			if ((par7 == 1 && !flag || par7 == 0 && flag) && block == singleSlab && j1 == is.getItemDamage())
			{
				if (world.checkNoEntityCollision(doubleSlab.getCollisionBoundingBoxFromPool(world, par4, par5, par6)) && world.setBlock(par4, par5, par6, doubleSlab, j1, 3))
				{
					world.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), doubleSlab.stepSound.func_150496_b(), (doubleSlab.stepSound.getVolume() + 1.0F) / 2.0F, doubleSlab.stepSound.getPitch() * 0.8F);
					--is.stackSize;
				}

				return true;
			}
			else
			{
				return this.func_150946_a(is, player, world, par4, par5, par6, par7) ? true : super.onItemUse(is, player, world, par4, par5, par6, par7, par8, par9, par10);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean func_150936_a(World world, int xcord, int ycord, int zcord, int meta, EntityPlayer player, ItemStack itemStack)
	{
		int x1 = xcord;
		int y1 = ycord;
		int z1 = zcord;
		Block block = world.getBlock(xcord, ycord, zcord);
		int m1 = world.getBlockMetadata(xcord, ycord, zcord);
		int m2 = m1 & 7;
		boolean flag = (m1 & 8) != 0;

		if ((meta == 1 && !flag || meta == 0 && flag) && block == singleSlab && m2 == itemStack.getItemDamage())
		{
			return true;
		}
		else
		{
			if (meta == 0)
			{
				--ycord;
			}

			if (meta == 1)
			{
				++ycord;
			}

			if (meta == 2)
			{
				--zcord;
			}

			if (meta == 3)
			{
				++zcord;
			}

			if (meta == 4)
			{
				--xcord;
			}

			if (meta == 5)
			{
				++xcord;
			}

			Block block1 = world.getBlock(xcord, ycord, zcord);
			int j2 = world.getBlockMetadata(xcord, ycord, zcord);
			m2 = j2 & 7;
			return true; /*block1 == singleSlab && m2 == itemStack.getItemDamage() ? true : super.func_150936_a(world, x1, y1, z1, meta, player, itemStack);*/
		}
	}

	//Has problems right now
	private boolean func_150946_a(ItemStack itemStack, EntityPlayer player, World world, int xCord, int yCord, int zCord, int side)
	{
		if (side == 0)
		{
			--yCord;
		}

		if (side == 1)
		{
			++yCord;
		}

		if (side == 2)
		{
			--zCord;
		}

		if (side == 3)
		{
			++zCord;
		}

		if (side == 4)
		{
			--xCord;
		}

		if (side == 5)
		{
			++xCord;
		}

		Block block = world.getBlock(xCord, yCord, zCord);
		int i1 = world.getBlockMetadata(xCord, yCord, zCord);
		int j1 = i1 & 7;

		if (block == singleSlab && j1 == itemStack.getItemDamage())
		{
			if (world.checkNoEntityCollision(this.doubleSlab.getCollisionBoundingBoxFromPool(world, xCord, yCord, zCord)) && world.setBlock(xCord, yCord, zCord, doubleSlab, j1, 3))
			{
				world.playSoundEffect((double)((float)xCord + 0.5F), (double)((float)yCord + 0.5F), (double)((float)zCord + 0.5F), doubleSlab.stepSound.func_150496_b(), (doubleSlab.stepSound.getVolume() + 1.0F) / 2.0F, doubleSlab.stepSound.getPitch() * 0.8F);
				--itemStack.stackSize;
			}

			return true;
		}
		else
		{
			return false;
		}
	}
}
