package com.helloworld.helloworld.blocks.testcontainer;

import com.helloworld.helloworld.HelloWorld;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TestContainerBlock extends Block implements ITileEntityProvider {

    public static final int GUI_ID = 1;

    public TestContainerBlock() {
        super(Material.WOOD);
        setUnlocalizedName(HelloWorld.MODID + ".testcontainerblock");
        setRegistryName("testcontainerblock");
        setCreativeTab(CreativeTabs.DECORATIONS);
        setHardness(2.0F);
        
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TestContainerTileEntity();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        }
        TileEntity te = world.getTileEntity(pos);
        if (!(te instanceof TestContainerTileEntity)) {
            return false;
        }
        player.openGui(HelloWorld.instance, GUI_ID, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }
    
    //code below gives items back after breaking the blocks
    public void breakBlock( World worldIn, BlockPos pos, IBlockState state ){
        TileEntity te = worldIn.getTileEntity( pos );
        if( te instanceof TestContainerTileEntity ){
            ItemStackHandler ish = (ItemStackHandler)te.getCapability( CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP );
            for( int i=0; i<ish.getSlots(); i++ ){
                if( ish.getStackInSlot( i ) != null ){
                    worldIn.spawnEntity( new EntityItem( worldIn, pos.getX(), pos.getY(), pos.getZ(), ish.getStackInSlot( i ) ) );
                }
            }
        }

        super.breakBlock(worldIn, pos, state);
    }
}
