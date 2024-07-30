package com.plottwist.wirelessredstone.block;

import com.plottwist.wirelessredstone.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;

import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SenderBlock extends Block {

    private boolean hasReceivedSignal = false;

    public SenderBlock(Settings settings) {
        super(settings);
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
            serverWorld.playSound(null, pos, ModSounds.HARVEST_SUGARCANE, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
    }

}
