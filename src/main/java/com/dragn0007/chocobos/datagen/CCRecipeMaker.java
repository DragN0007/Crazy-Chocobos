package com.dragn0007.chocobos.datagen;

import com.dragn0007.chocobos.items.CCItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class CCRecipeMaker extends RecipeProvider implements IConditionBuilder {
    public CCRecipeMaker(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CCItems.LEATHER_CHOCOBO_ARMOR.get())
                .define('A', Items.LEATHER)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("A A")
                .unlockedBy("has_leather", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.LEATHER).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CCItems.IRON_CHOCOBO_ARMOR.get())
                .define('A', Items.LEATHER)
                .define('B', Items.IRON_INGOT)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("B B")
                .unlockedBy("has_iron", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.IRON_INGOT).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CCItems.GOLD_CHOCOBO_ARMOR.get())
                .define('A', Items.LEATHER)
                .define('B', Items.GOLD_INGOT)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("B B")
                .unlockedBy("has_gold", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.GOLD_INGOT).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CCItems.DIAMOND_CHOCOBO_ARMOR.get())
                .define('A', Items.LEATHER)
                .define('B', Items.DIAMOND)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("B B")
                .unlockedBy("has_diamond", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.DIAMOND).build()))
                .save(pFinishedRecipeConsumer);

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(CCItems.CHOCOBO.get()), RecipeCategory.MISC, CCItems.COOKED_CHOCOBO.get(), 0.35F, 100)
                .unlockedBy("has_chocobo", has(CCItems.CHOCOBO.get())).save(pFinishedRecipeConsumer, new ResourceLocation("chocobos", "cooked_chocobo_smoking"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(CCItems.CHOCOBO.get()), RecipeCategory.MISC, CCItems.COOKED_CHOCOBO.get(), 0.35F, 200)
                .unlockedBy("has_chocobo", has(CCItems.CHOCOBO.get())).save(pFinishedRecipeConsumer, new ResourceLocation("chocobos", "cooked_chocobo_smelting"));
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(CCItems.CHOCOBO.get()), RecipeCategory.MISC, CCItems.COOKED_CHOCOBO.get(), 0.35F, 600)
                .unlockedBy("has_chocobo", has(CCItems.CHOCOBO.get())).save(pFinishedRecipeConsumer, new ResourceLocation("chocobos", "cooked_chocobo_campfire_cooking"));
    }
}