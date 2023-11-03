package com.babarsdecorations;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier("babarsdecorations", "item_group"),
            () -> new ItemStack(ModBlocks.Oak_Trellis));

}
