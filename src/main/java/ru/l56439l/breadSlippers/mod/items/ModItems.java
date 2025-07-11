package ru.l56439l.breadSlippers.mod.items;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.equipment.EquipmentType;
import ru.l56439l.breadSlippers.mod.ModMaterials;
import ru.l56439l.breadSlippers.mod.registerers.ItemRegisterer;

public class ModItems {

  public static final Item BREAD_BOOTS = ItemRegisterer.register(
      "bread_boots",
      new Item.Settings()
          .armor(ModMaterials.BREAD_MATERIAL, EquipmentType.BOOTS)
          .repairable(Items.BREAD)
  );

  public static final Item BREAD_CRUMBS = ItemRegisterer.register(
      "bread_crumbs",
      new Item.Settings()
          .food(new FoodComponent.Builder()
              .nutrition(2)
              .saturationModifier(0.1F)
              .build()
          )
  );

  public static void initialize() {
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
        .register((itemGroup) -> itemGroup.add(ModItems.BREAD_BOOTS));

    ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
        .register((itemGroup) -> itemGroup.add(ModItems.BREAD_CRUMBS));
  }

}
