package ru.l56439l.breadSlippers.mod;

import java.util.Map;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import ru.l56439l.breadSlippers.BreadSlippers;

public class ModMaterials {

  private static final String BREAD_BOOTS_MATERIAL = "bread_boots_material";
  private static final int BASE_DURABILITY = 6;
  private static final int ENCHANTMENT_VALUE = 25;
  private static final float TOUGHNESS = 1.0f;
  private static final float KNOCKBACK_RESISTANCE = 0.1f;

  private static final RegistryKey<EquipmentAsset> BREAD_ARMOR_MATERIAL_KEY = RegistryKey.of(
      EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(BreadSlippers.MOD_ID, BREAD_BOOTS_MATERIAL));

  public static final ArmorMaterial BREAD_MATERIAL = new ArmorMaterial(
      BASE_DURABILITY,
      Map.of(
          EquipmentType.BOOTS, 1
      ),
      ENCHANTMENT_VALUE,
      SoundEvents.ITEM_ARMOR_EQUIP_WOLF,
      TOUGHNESS,
      KNOCKBACK_RESISTANCE,
      null,
      BREAD_ARMOR_MATERIAL_KEY
  );

}
