package ru.l56439l.breadSlippers.mod.blocks;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemGroups;
import net.minecraft.sound.BlockSoundGroup;
import ru.l56439l.breadSlippers.mod.registerers.BlockRegisterer;

public class ModBlocks {

  public static final Block BREAD_BLOCK = BlockRegisterer.register(
      "bread_block",
      BreadBlock::new,
      AbstractBlock.Settings.create()
          .sounds(BlockSoundGroup.WOOD)
          .strength(0.9f)
          .instrument(NoteBlockInstrument.DIDGERIDOO)
          .pistonBehavior(PistonBehavior.DESTROY)
          .mapColor(MapColor.BROWN)
  );

  public static final Block CARVED_BREAD = BlockRegisterer.register(
      "carved_bread",
      CarvedBreadBlock::new,
      AbstractBlock.Settings.create()
          .sounds(BlockSoundGroup.WOOD)
          .strength(0.8f)
          .pistonBehavior(PistonBehavior.DESTROY)
          .mapColor(MapColor.BROWN),
      EquipmentSlot.HEAD
  );

  public static void initialize() {
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
        .register((itemGroup) -> itemGroup.add(ModBlocks.BREAD_BLOCK.asItem()));

    ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
        .register((itemGroup) -> itemGroup.add(ModBlocks.CARVED_BREAD.asItem()));
  }

}
