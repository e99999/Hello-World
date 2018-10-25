package com.helloworld.helloworld.blocks.ores;

import java.util.Random;

import com.helloworld.helloworld.HelloWorld;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EmeraldSand extends BlockFalling {
	
	public EmeraldSand() {
		super(Material.SAND);
		setUnlocalizedName(HelloWorld.MODID + ".emeraldsand");
        setRegistryName("emeraldsand");
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setHardness(0.5F);
        setSoundType(SoundType.SAND);
        setHarvestLevel("shovel", 0);
    }
	
	/**
     * Get the Item that this Block should drop when harvested.
     */
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
    	return Items.EMERALD;
    }
    
    /**
     * Get the quantity dropped based on the given fortune level
     */
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random)
    {
        return this.quantityDropped(random) + random.nextInt(fortune + 1);
    }
    
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(Random random)
    {
        return 1;
    }
    
    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        if (this.getItemDropped(state, RANDOM, fortune) != Item.getItemFromBlock(this))
        {
            return 1 + RANDOM.nextInt(2);
        }
        return 0;
    }
	
	//initializes the block texture as an item texture
	@SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}

