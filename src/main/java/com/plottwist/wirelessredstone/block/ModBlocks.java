package com.plottwist.wirelessredstone.block;

import com.plottwist.wirelessredstone.WirelessRedstone;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final BooleanProperty ACTIVATED = BooleanProperty.of("activated");

    public static final Block SENDER_BLOCK = registerBlock("sender_block",
            new SenderBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    // public static final Block SENDER_BLOCK = registerBlock("sender_block",
    //         new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(WirelessRedstone.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(WirelessRedstone.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        WirelessRedstone.LOGGER.info("Registering ModBlocks for " + WirelessRedstone.MOD_ID);
    }
}
