package com.plottwist.wirelessredstone.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class SenderBlock extends Block {

    private boolean hasReceivedSignal = false;

    public SenderBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        // No properties to append
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        if (!world.isClient) {
            boolean hasPower = world.isReceivingRedstonePower(pos);
            if (hasPower && !hasReceivedSignal) {
                hasReceivedSignal = true;
                triggerBlock(world, pos);
            } else if (!hasPower && hasReceivedSignal) {
                hasReceivedSignal = false;
            }
        }
    }

    private void triggerBlock(World world, BlockPos pos) {
        if (world instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld) world;
            serverWorld.getPlayers().forEach(player ->
                    player.sendMessage(Text.literal("Redstone signal received at " + pos), false)
            );
        }
    }
}
