package ru.l56439l.breadSlippers.mod.blocks;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import ru.l56439l.breadSlippers.mod.items.ModItems;

public class BreadBlock extends Block {

  private static final List<Item> SHOVELS = List.of(Items.WOODEN_SHOVEL, Items.STONE_SHOVEL,
      Items.IRON_SHOVEL, Items.GOLDEN_SHOVEL, Items.DIAMOND_SHOVEL, Items.NETHERITE_SHOVEL);

  public BreadBlock(Settings settings) {
    super(settings);
  }

  @Override
  protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos,
      PlayerEntity player, Hand hand, BlockHitResult hit) {

    if (SHOVELS.contains(stack.getItem())) {
      if (!world.isClient) {

        Direction hitSide = hit.getSide();
        Direction direction =
            hitSide.getAxis() == Axis.Y ? player.getHorizontalFacing().getOpposite() : hitSide;

        world.setBlockState(pos, ModBlocks.CARVED_BREAD.getDefaultState()
            .with(CarvedBreadBlock.FACING, direction), 11);

        ItemEntity itemEntity = spawnEntityCounter(world, pos, direction);
        world.spawnEntity(itemEntity);

        world.playSound(null, pos, SoundEvents.BLOCK_PUMPKIN_CARVE, SoundCategory.BLOCKS, 1.0F,
            1.0F);
        stack.damage(1, player, LivingEntity.getSlotForHand(hand));

        world.emitGameEvent(player, GameEvent.SHEAR, pos);
        player.incrementStat(Stats.USED.getOrCreateStat(stack.getItem()));
      }
      return ActionResult.SUCCESS;
    }
    return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
  }

  private ItemEntity spawnEntityCounter(World world, BlockPos pos, Direction direction) {

    ItemEntity itemEntity = new ItemEntity(world,
        (double) pos.getX() + (double) 0.5F + (double) direction.getOffsetX() * 0.65,
        (double) pos.getY() + 0.1,
        (double) pos.getZ() + (double) 0.5F + (double) direction.getOffsetZ() * 0.65,
        new ItemStack(ModItems.BREAD_CRUMBS, 4));
    itemEntity.setVelocity(
        0.05 * (double) direction.getOffsetX() + world.random.nextDouble() * 0.02, 0.05,
        0.05 * (double) direction.getOffsetZ() + world.random.nextDouble() * 0.02);

    return itemEntity;
  }
}
