package com.babarsdecorations;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static TrellisBlock Oak_Trellis = new TrellisBlock(FabricBlockSettings.of(Material.WOOD).strength(0.5f).nonOpaque());
    public static TrellisBlock Spruce_Trellis = new TrellisBlock(FabricBlockSettings.of(Material.WOOD).strength(0.5f).nonOpaque());

    public static void registerModBlocks(){
        Registry.register(Registry.BLOCK, new Identifier("babarsdecorations", "oak_trellis"), Oak_Trellis);
        Registry.register(Registry.ITEM, new Identifier("babarsdecorations", "oak_trellis"), new BlockItem(Oak_Trellis, new FabricItemSettings().group(ModItemGroups.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("babarsdecorations", "spruce_trellis"), Spruce_Trellis);
        Registry.register(Registry.ITEM, new Identifier("babarsdecorations", "spruce_trellis"), new BlockItem(Spruce_Trellis, new FabricItemSettings().group(ModItemGroups.ITEM_GROUP)));
    }
}
