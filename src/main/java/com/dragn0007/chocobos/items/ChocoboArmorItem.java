package com.dragn0007.chocobos.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ChocoboArmorItem extends Item {
   private final int protection;

   public ChocoboArmorItem(int i, Properties properties) {
      super(properties);
      this.protection = i;
   }

   public int getProtection() {
      return this.protection;
   }

   @Override
   public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
      pTooltipComponents.add(Component.translatable("tooltip.chocobos.armor.tooltip").withStyle(ChatFormatting.GRAY));
   }
}