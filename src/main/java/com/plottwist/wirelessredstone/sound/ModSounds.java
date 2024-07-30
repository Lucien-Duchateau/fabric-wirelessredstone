package com.plottwist.wirelessredstone.sound;

import com.plottwist.wirelessredstone.WirelessRedstone;
import com.plottwist.wirelessredstone.block.ModBlocks;
import net.minecraft.client.sound.Sound;
import net.minecraft.client.sound.SoundEngine;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent HARVEST_SUGARCANE = registerSoundEvent("harvest_sugarcane");

    public static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(WirelessRedstone.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        WirelessRedstone.LOGGER.info("Registering Sounds for " + WirelessRedstone.MOD_ID);
    }
}
