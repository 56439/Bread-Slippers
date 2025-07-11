package ru.l56439l.breadSlippers.mod.registerers;

import java.util.function.Function;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import ru.l56439l.breadSlippers.BreadSlippers;

public class ItemRegisterer {

  public static Item register(String name, Item.Settings settings) {
    return register(name, Item::new, settings);
  }

  private static Item register(String name, Function<Settings, Item> itemFactory,
      Item.Settings settings) {

    RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM,
        Identifier.of(BreadSlippers.MOD_ID, name));

    Item item = itemFactory.apply(settings.registryKey(itemKey));

    Registry.register(Registries.ITEM, itemKey, item);

    return item;
  }

}
