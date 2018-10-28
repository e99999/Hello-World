package com.helloworld.helloworld.items;

import com.helloworld.helloworld.HelloWorld;
import com.helloworld.helloworld.ModBlocks;
import com.helloworld.helloworld.proxy.CommonProxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DogeCoin extends Item {

    //basic information about this item
	public DogeCoin() {
        setRegistryName("dogecoin");        // The unique name (within your mod) that identifies this item
        setUnlocalizedName(HelloWorld.MODID + ".dogecoin");     // Used for localization (en_US.lang)
        setCreativeTab(CreativeTabs.MISC);
    }
    
    //init texture
    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
    
    @Override
	public EnumActionResult onItemUse(EntityPlayer entity, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY,
			float hitZ) {
		pos = pos.offset(facing);
		ItemStack itemstack = entity.getHeldItem(hand);
		if (!entity.canPlayerEdit(pos, facing, itemstack)) {
			return EnumActionResult.FAIL;
		} else {
			if (world.isAirBlock(pos)) {
				CommonProxy.portal.trySpawnPortal(world, pos);
			}
			itemstack.damageItem(1, entity);
			return EnumActionResult.SUCCESS;
		}

    }
}
