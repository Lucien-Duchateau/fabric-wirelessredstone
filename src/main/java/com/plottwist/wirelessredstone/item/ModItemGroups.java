package com.plottwist.wirelessredstone.item;

import com.plottwist.wirelessredstone.WirelessRedstone;
import com.plottwist.wirelessredstone.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup WIRELESS_REDSTONE_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(WirelessRedstone.MOD_ID, "wirelessredstone"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.wirelessredstone"))
                    .icon(() -> new ItemStack(ModItems.REDSTONEITE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.REDSTONEITE);

                        entries.add(ModBlocks.SENDER_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        WirelessRedstone.LOGGER.info("Registering Mod Item Groups for " + WirelessRedstone.MOD_ID);
    }
}
