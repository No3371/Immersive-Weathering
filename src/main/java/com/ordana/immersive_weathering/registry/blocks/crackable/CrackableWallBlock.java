package com.ordana.immersive_weathering.registry.blocks.crackable;

import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class CrackableWallBlock extends CrackedWallBlock {

    public CrackableWallBlock(CrackLevel crackLevel, Settings settings) {
        super(crackLevel, settings);
        this.setDefaultState(this.getDefaultState().with(WEATHERABLE, false).with(STABLE, false).with(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView getter, BlockPos pos, ShapeContext context) {
        return super.getOutlineShape(state.with(WEATHERABLE, true).with(STABLE, true), getter, pos, context);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView getter, BlockPos pos, ShapeContext context) {
        return super.getCollisionShape(state.with(WEATHERABLE, true).with(STABLE, true), getter, pos, context);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return isWeatherable(state);
    }

    //-----weathereable-start---

    @Override
    public boolean isWeatherable(BlockState state) {
        return state.contains(WEATHERABLE) && state.get(WEATHERABLE) && state.contains(STABLE) &&!state.get(STABLE);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateBuilder) {
        super.appendProperties(stateBuilder);
        stateBuilder.add(WEATHERABLE);
        stateBuilder.add(STABLE);
    }

    @Override
    public void neighborUpdate(BlockState state, World level, BlockPos pos, Block block, BlockPos neighbor, boolean isMoving) {
        super.neighborUpdate(state, level, pos, block, neighbor,true);
        if (level instanceof ServerWorld serverLevel) {
            boolean weathering = this.getWantedWeatheringState(state, pos, serverLevel);
            if (state.get(WEATHERABLE) != weathering) {
                //update weathering state
                serverLevel.setBlockState(pos, state.with(WEATHERABLE, weathering));
            }
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext placeContext) {
        BlockState state = super.getPlacementState(placeContext);
        if (state != null) {
            boolean weathering = this.getWantedWeatheringState(state, placeContext.getBlockPos(), placeContext.getWorld());
            state = state.with(WEATHERABLE, weathering);
        }
        return state;
    }

    //-----weathereable-end---


    @Override
    public void randomTick(BlockState state, ServerWorld serverLevel, BlockPos pos, Random random) {
        float weatherChance = 0.5f;
        if (random.nextFloat() < weatherChance) {
            Optional<BlockState> opt = Optional.empty();
            if(this.getCrackSpreader().getWanderWeatheringState(true, pos, serverLevel)) {
                opt = this.getNextCracked(state);
            }
            BlockState newState = opt.orElse(state.with(WEATHERABLE, false));
            serverLevel.setBlockState(pos, newState);
        }
    }

}
