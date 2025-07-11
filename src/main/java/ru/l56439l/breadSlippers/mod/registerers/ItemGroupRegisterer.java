package ru.l56439l.breadSlippers.mod.registerers;

import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import ru.l56439l.breadSlippers.BreadSlippers;

public class ItemGroupRegisterer {

  public static RegistryKey<ItemGroup> register(ItemGroup breadItemGroup) {

    RegistryKey<ItemGroup> breadItemGroupKey = RegistryKey.of(
        Registries.ITEM_GROUP.getKey(), Identifier.of(BreadSlippers.MOD_ID, "bread_item_group"));

    Registry.register(Registries.ITEM_GROUP, breadItemGroupKey, breadItemGroup);

    return breadItemGroupKey;
  }

}
