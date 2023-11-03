package com.babarsdecorations;

import net.minecraft.block.*;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.slf4j.LoggerFactory;

import java.util.*;


public class TrellisBlock extends HorizontalFacingBlock {

    public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger("babars-decorations");

    private static final HashMap<String, Integer> ITEM_TO_DESIGN_MAP = new HashMap<>();

    public static final IntProperty DESIGN = IntProperty.of("design", 0, 9);

    public TrellisBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(DESIGN, 0));

        ITEM_TO_DESIGN_MAP.put("moss_block", 1);
        ITEM_TO_DESIGN_MAP.put("azalea_leaves", 2);
        ITEM_TO_DESIGN_MAP.put("flowering_azalea_leaves", 3);
        ITEM_TO_DESIGN_MAP.put("vine", 4);
        ITEM_TO_DESIGN_MAP.put("lilac", 5);
        ITEM_TO_DESIGN_MAP.put("rose_bush", 6);
        ITEM_TO_DESIGN_MAP.put("peony", 7);
        ITEM_TO_DESIGN_MAP.put("twisting_vines", 8);
        ITEM_TO_DESIGN_MAP.put("weeping_vines", 9);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
        builder.add(DESIGN);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        return switch (dir) {
            case SOUTH -> VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.1875);
            case NORTH -> VoxelShapes.cuboid(0.0f, 0.0f, 0.8125, 1.0f, 1.0f, 1.0f);
            case WEST -> VoxelShapes.cuboid(0.8125, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            case EAST -> VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 0.1875, 1.0f, 1.0f);
            default -> VoxelShapes.fullCube();
        };
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ArrayList<ItemStack> heldItems = (ArrayList<ItemStack>) player.getItemsHand();
        String item = heldItems.get(0).getItem().toString();

        // Setting a design
        // If I want to increase the number of designs I need to increase the max value of Design
        if (ITEM_TO_DESIGN_MAP.containsKey(item)){

            if (!Objects.equals(state.get(DESIGN), ITEM_TO_DESIGN_MAP.get(item))){
                world.playSound(
                        null,
                        pos,
                        SoundEvents.BLOCK_FLOWERING_AZALEA_PLACE,
                        SoundCategory.BLOCKS,
                        1f,
                        1f );
            }
            world.setBlockState(pos, state.with(DESIGN, ITEM_TO_DESIGN_MAP.get(item)));

            return ActionResult.SUCCESS;
        }

        // Removing the design
        if (item.contains("axe")) {
            if (state.get(DESIGN) != 0){
                world.playSound(
                        null,
                        pos,
                        SoundEvents.BLOCK_AZALEA_LEAVES_BREAK,
                        SoundCategory.BLOCKS,
                        1f,
                        1f );
            }

            world.setBlockState(pos, state.with(DESIGN, 0));
            return ActionResult.SUCCESS;
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        if (Screen.hasShiftDown()) {
            tooltip.add(new TranslatableText("block.babarsdecorations.trellis.tooltip_1").formatted(Formatting.AQUA));
            tooltip.add(new TranslatableText("block.babarsdecorations.trellis.tooltip_2").formatted(Formatting.AQUA));
            tooltip.add(new TranslatableText("block.babarsdecorations.trellis.tooltip_3").formatted(Formatting.AQUA));
            tooltip.add(new TranslatableText("block.babarsdecorations.trellis.tooltip_4").formatted(Formatting.AQUA));
            tooltip.add(new TranslatableText("block.babarsdecorations.trellis.tooltip_5").formatted(Formatting.AQUA));
        } else {
            tooltip.add(new TranslatableText("block.babarsdecorations.trellis.tooltip_shift").formatted(Formatting.AQUA));
        }

    }
}