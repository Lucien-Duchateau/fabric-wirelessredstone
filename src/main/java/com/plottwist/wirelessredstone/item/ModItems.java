package com.plottwist.wirelessredstone.item;

import com.plottwist.wirelessredstone.WirelessRedstone;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.impl.itemgroup.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item REDSTONEITE = registerItem("redstoneite", new Item(new FabricItemSettings()));

    private static void addItemsToRedstoneTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(REDSTONEITE);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(WirelessRedstone.MOD_ID, name), item);
    }

    public static void registerModItems() {
        WirelessRedstone.LOGGER.info("Registering Mod Items for " + WirelessRedstone.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(ModItems::addItemsToRedstoneTabItemGroup);
    }
}
