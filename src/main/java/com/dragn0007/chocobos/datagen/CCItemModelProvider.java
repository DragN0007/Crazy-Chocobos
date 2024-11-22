package com.dragn0007.chocobos.datagen;

import com.dragn0007.chocobos.CrazyChocobos;
import com.dragn0007.chocobos.items.CCItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class CCItemModelProvider extends ItemModelProvider {
    public CCItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CrazyChocobos.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(CCItems.CHOCOBO_ICON);
        simpleItem(CCItems.CHOCOBO);
        simpleItem(CCItems.COOKED_CHOCOBO);
        simpleItem(CCItems.CHOCOBO_EGG);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CrazyChocobos.MODID,"item/" + item.getId().getPath()));
    }
}