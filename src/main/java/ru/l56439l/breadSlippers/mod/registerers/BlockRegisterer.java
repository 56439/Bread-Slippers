package ru.l56439l.breadSlippers.mod.registerers;

import java.util.function.Function;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import ru.l56439l.breadSlippers.BreadSlippers;

public class BlockRegisterer {

  public static Block register(String name, Function<Settings, Block> blockFactory,
      AbstractBlock.Settings settings) {
    return register(name, blockFactory, settings, null);
  }

  public static Block register(String name, Function<Settings, Block> blockFactory,
      AbstractBlock.Settings settings, EquipmentSlot equipmentSlot) {

    RegistryKey<Block> blockKey = keyOfBlock(name);
    Block block = blockFactory.apply(settings.registryKey(blockKey));

    registerAsItem(name, block, equipmentSlot);

    return Registry.register(Registries.BLOCK, blockKey, block);
  }

  private static void registerAsItem(String name, Block block, EquipmentSlot equipmentSlot) {
    RegistryKey<Item> itemKey = keyOfItem(name);

    Item.Settings itemSettings = new Item.Settings().registryKey(itemKey);

    if (equipmentSlot != null && equipmentSlot.isArmorSlot()) {
      itemSettings.equippable(equipmentSlot);
    }

    BlockItem blockItem = new BlockItem(block, itemSettings);

    Registry.register(Registries.ITEM, itemKey, blockItem);
  }

  private static RegistryKey<Block> keyOfBlock(String name) {
    return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(BreadSlippers.MOD_ID, name));
  }

  private static RegistryKey<Item> keyOfItem(String name) {
    return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(BreadSlippers.MOD_ID, name));
  }

}
