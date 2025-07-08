package ru.l56439l.breadSlippers.mod;

import java.util.function.Function;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import ru.l56439l.breadSlippers.BreadSlippers;

public class ModItems {

  public static final Item BREAD_BOOTS = register(
      "bread_boots", Item::new,
      new Item.Settings()
          .armor(ModMaterials.BREAD_MATERIAL, EquipmentType.BOOTS)
          .repairable(Items.BREAD)
  );

  public static void initialize() {
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
        .register((itemGroup) -> itemGroup.add(ModItems.BREAD_BOOTS));
  }

  private static Item register(String name, Function<Item.Settings, Item> itemFactory,
      Item.Settings settings) {

    RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM,
        Identifier.of(BreadSlippers.MOD_ID, name));

    Item item = itemFactory.apply(settings.registryKey(itemKey));

    Registry.register(Registries.ITEM, itemKey, item);

    return item;
  }

}
