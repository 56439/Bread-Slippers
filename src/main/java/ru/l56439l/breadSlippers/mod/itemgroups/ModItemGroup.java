package ru.l56439l.breadSlippers.mod.itemgroups;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import ru.l56439l.breadSlippers.mod.blocks.ModBlocks;
import ru.l56439l.breadSlippers.mod.items.ModItems;
import ru.l56439l.breadSlippers.mod.registerers.ItemGroupRegisterer;

public class ModItemGroup {

  private static final RegistryKey<ItemGroup> BREAD_ITEM_GROUP_KEY = ItemGroupRegisterer.register(
      FabricItemGroup.builder()
          .displayName(Text.translatable("itemGroup.bread-slippers"))
          .icon(() -> new ItemStack(ModItems.BREAD_BOOTS))
          .build()
  );

  public static void initialize() {

    ItemGroupEvents.modifyEntriesEvent(BREAD_ITEM_GROUP_KEY).register(itemGroup -> {
      itemGroup.add(ModItems.BREAD_BOOTS);
      itemGroup.add(ModBlocks.BREAD_BLOCK);
      itemGroup.add(ModBlocks.CARVED_BREAD);
      itemGroup.add(ModItems.BREAD_CRUMBS);
    });
  }
}
