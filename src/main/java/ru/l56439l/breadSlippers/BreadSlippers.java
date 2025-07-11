package ru.l56439l.breadSlippers;

import net.fabricmc.api.ModInitializer;
import ru.l56439l.breadSlippers.mod.blocks.ModBlocks;
import ru.l56439l.breadSlippers.mod.items.ModItems;

public class BreadSlippers implements ModInitializer {

  public static final String MOD_ID = "bread-slippers";

  @Override
  public void onInitialize() {
    ModItems.initialize();
    ModBlocks.initialize();
  }
}
