package com.nathan.nathanmod.world.tree;

import java.util.Random;

import com.nathan.nathanmod.NathanMod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.util.ForgeDirection;

//This class makes a tree when given coordinates and stuff about tree.
public class MakeNormalTree extends WorldGenAbstractTree {
	private final int minTreeHeight; // Minimum height
	private final boolean vinesGrow; // Do vines grow?
	private final Block trunkBlock; // Block to use for trunk
	private final Block leavesBlock; // Block for leaves
	private static final String __OBFID = "CL_00000438"; // ???????
	private int meta;

	// Constructor
	public MakeNormalTree(boolean p_i2028_1_, int minTreeHeight, Block trunk, Block leaves, boolean vinesGrow, int meta) {
		super(p_i2028_1_);
		this.minTreeHeight = minTreeHeight;
		this.trunkBlock = trunk;
		this.leavesBlock = leaves;
		this.vinesGrow = vinesGrow;
		this.meta = meta;
	}

	// Generates Tree
	public boolean generate(World world, Random random, int xValue, int yValue, int zValue) {
		boolean returnValue = false;
		int l = random.nextInt(3) + this.minTreeHeight;
		boolean flag = true;

		if (yValue >= 1 && yValue + l + 1 <= 256) {
			byte b0;
			int k1;
			Block block;

			for (int i1 = yValue; i1 <= yValue + 1 + l; ++i1) {
				b0 = 1;

				if (i1 == yValue) {
					b0 = 0;
				}

				if (i1 >= yValue + 1 + l - 2) {
					b0 = 2;
				}

				for (int j1 = xValue - b0; j1 <= xValue + b0 && flag; ++j1) {
					for (k1 = zValue - b0; k1 <= zValue + b0 && flag; ++k1) {
						if (i1 >= 0 && i1 < 256) {
							block = world.getBlock(j1, i1, k1);

							if (!this.isReplaceable(world, j1, i1, k1)) {
								flag = false;
							}
						} else {
							flag = false;
						}
					}
				}
			}

			if (!flag) {
				returnValue = false;
			} else {
				Block block2 = world.getBlock(xValue, yValue - 1, zValue);

				// Determines whether tree can grow on block
				boolean isSoil = block2.canSustainPlant(world, xValue, yValue - 1, zValue, ForgeDirection.UP,
						(BlockSapling) Blocks.sapling);
				if (isSoil && yValue < 256 - l - 1) {
					block2.onPlantGrow(world, xValue, yValue - 1, zValue, xValue, yValue, zValue);
					b0 = 3;
					byte b1 = 0;
					int l1;
					int i2;
					int j2;
					int i3;

					// Place Trunk and vines
					for (k1 = 0; k1 < l; ++k1) {
						block = world.getBlock(xValue, yValue + k1, zValue);

						if (block.isAir(world, xValue, yValue + k1, zValue)
								|| block.isLeaves(world, xValue, yValue + k1, zValue)) {
							this.setBlockAndNotifyAdequately(world, xValue, yValue + k1, zValue, this.trunkBlock,
									this.meta);

							if (this.vinesGrow && k1 > 0) {
								if (random.nextInt(3) > 0 && world.isAirBlock(xValue - 1, yValue + k1, zValue)) {
									this.setBlockAndNotifyAdequately(world, xValue - 1, yValue + k1, zValue,
											Blocks.vine, 8);
								}

								if (random.nextInt(3) > 0 && world.isAirBlock(xValue + 1, yValue + k1, zValue)) {
									this.setBlockAndNotifyAdequately(world, xValue + 1, yValue + k1, zValue,
											Blocks.vine, 2);
								}

								if (random.nextInt(3) > 0 && world.isAirBlock(xValue, yValue + k1, zValue - 1)) {
									this.setBlockAndNotifyAdequately(world, xValue, yValue + k1, zValue - 1,
											Blocks.vine, 1);
								}

								if (random.nextInt(3) > 0 && world.isAirBlock(xValue, yValue + k1, zValue + 1)) {
									this.setBlockAndNotifyAdequately(world, xValue, yValue + k1, zValue + 1,
											Blocks.vine, 4);
								}
							}
						}
					}

					// Places leaves. Will overwrite other leaves, and Vines
					for (k1 = yValue - b0 + l; k1 <= yValue + l; ++k1) {
						i3 = k1 - (yValue + l);
						l1 = b1 + 1 - i3 / 2;

						for (i2 = xValue - l1; i2 <= xValue + l1; ++i2) {
							j2 = i2 - xValue;

							for (int k2 = zValue - l1; k2 <= zValue + l1; ++k2) {
								int l2 = k2 - zValue;

								if (Math.abs(j2) != l1 || Math.abs(l2) != l1 || random.nextInt(2) != 0 && i3 != 0) {
									Block block1 = world.getBlock(i2, k1, k2);

									if (block1.isAir(world, i2, k1, k2) || block1.isLeaves(world, i2, k1, k2) || block1.isLadder(world, i2, k1, k2, null)) {
										this.setBlockAndNotifyAdequately(world, i2, k1, k2, this.leavesBlock, this.meta);
									}
								}
							}
						}
					}

					// Makes vines grow on leaves and trunk
					if (this.vinesGrow) {
						for (k1 = yValue - 3 + l; k1 <= yValue + l; ++k1) {
							i3 = k1 - (yValue + l);
							l1 = 2 - i3 / 2;

							for (i2 = xValue - l1; i2 <= xValue + l1; ++i2) {
								for (j2 = zValue - l1; j2 <= zValue + l1; ++j2) {
									if (world.getBlock(i2, k1, j2).isLeaves(world, i2, k1, j2)) {
										if (random.nextInt(4) == 0
												&& world.getBlock(i2 - 1, k1, j2).isAir(world, i2 - 1, k1, j2)) {
											this.growVines(world, i2 - 1, k1, j2, 8);
										}

										if (random.nextInt(4) == 0
												&& world.getBlock(i2 + 1, k1, j2).isAir(world, i2 + 1, k1, j2)) {
											this.growVines(world, i2 + 1, k1, j2, 2);
										}

										if (random.nextInt(4) == 0
												&& world.getBlock(i2, k1, j2 - 1).isAir(world, i2, k1, j2 - 1)) {
											this.growVines(world, i2, k1, j2 - 1, 1);
										}

										if (random.nextInt(4) == 0
												&& world.getBlock(i2, k1, j2 + 1).isAir(world, i2, k1, j2 + 1)) {
											this.growVines(world, i2, k1, j2 + 1, 4);
										}
									}
								}
							}
						}

						// Puts cocoa beans on tree
						// Not used
						if (random.nextInt(5) == 0 && l > 5) {
							for (k1 = 0; k1 < 2; ++k1) {
								for (i3 = 0; i3 < 4; ++i3) {
									if (random.nextInt(4 - k1) == 0) {
										l1 = random.nextInt(3);
										this.setBlockAndNotifyAdequately(world,
												xValue + Direction.offsetX[Direction.rotateOpposite[i3]],
												yValue + l - 5 + k1,
												zValue + Direction.offsetZ[Direction.rotateOpposite[i3]], Blocks.cocoa,
												l1 << 2 | i3);
									}
								}
							}
						}
					}
					returnValue = true;
				} else {
					returnValue = false;
				}
			}
		} else {
			returnValue = false;
		}
		return returnValue;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	/**
	 * Grows vines downward from the given block for a given length. Args:
	 * World, x, starty, z, vine-length
	 */
	private void growVines(World world, int x, int starty, int z, int vineLength) {
		this.setBlockAndNotifyAdequately(world, x, starty, z, Blocks.vine, vineLength);
		int i1 = 4;

		while (true) {
			--starty;

			if (!world.getBlock(x, starty, z).isAir(world, x, starty, z) || i1 <= 0) {
				return;
			}

			this.setBlockAndNotifyAdequately(world, x, starty, z, Blocks.vine, vineLength);
			--i1;
		}
	}
}
