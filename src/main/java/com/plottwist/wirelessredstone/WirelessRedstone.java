package com.plottwist.wirelessredstone;

import com.plottwist.wirelessredstone.block.ModBlocks;
import com.plottwist.wirelessredstone.item.ModItemGroups;
import com.plottwist.wirelessredstone.item.ModItems;
import com.plottwist.wirelessredstone.sound.ModSounds;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WirelessRedstone implements ModInitializer {

	public static final String MOD_ID = "wirelessredstone";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();

		ModBlocks.registerModBlocks();

		ModSounds.registerSounds();
	}
}