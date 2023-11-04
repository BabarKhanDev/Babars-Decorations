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

    public static TrellisBlock Birch_Trellis = new TrellisBlock(FabricBlockSettings.of(Material.WOOD).strength(0.5f).nonOpaque());

    public static TrellisBlock Jungle_Trellis = new TrellisBlock(FabricBlockSettings.of(Material.WOOD).strength(0.5f).nonOpaque());

    public static TrellisBlock Dark_Oak_Trellis = new TrellisBlock(FabricBlockSettings.of(Material.WOOD).strength(0.5f).nonOpaque());

    public static TrellisBlock Acacia_Trellis = new TrellisBlock(FabricBlockSettings.of(Material.WOOD).strength(0.5f).nonOpaque());

    public static TrellisBlock Crimson_Trellis = new TrellisBlock(FabricBlockSettings.of(Material.WOOD).strength(0.5f).nonOpaque());

    public static TrellisBlock Warped_Trellis = new TrellisBlock(FabricBlockSettings.of(Material.WOOD).strength(0.5f).nonOpaque());

//    public static TrellisBlock Cherry_Trellis = new TrellisBlock(FabricBlockSettings.of(Material.WOOD).strength(0.5f).nonOpaque());
//
//    public static TrellisBlock Mangrove_Trellis = new TrellisBlock(FabricBlockSettings.of(Material.WOOD).strength(0.5f).nonOpaque());
//
//    public static TrellisBlock Bamboo_Trellis = new TrellisBlock(FabricBlockSettings.of(Material.WOOD).strength(0.5f).nonOpaque());

    public static void registerModBlocks(){
        Registry.register(Registry.BLOCK, new Identifier("babarsdecorations", "oak_trellis"), Oak_Trellis);
        Registry.register(Registry.ITEM, new Identifier("babarsdecorations", "oak_trellis"), new BlockItem(Oak_Trellis, new FabricItemSettings().group(ModItemGroups.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("babarsdecorations", "spruce_trellis"), Spruce_Trellis);
        Registry.register(Registry.ITEM, new Identifier("babarsdecorations", "spruce_trellis"), new BlockItem(Spruce_Trellis, new FabricItemSettings().group(ModItemGroups.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("babarsdecorations", "birch_trellis"), Birch_Trellis);
        Registry.register(Registry.ITEM, new Identifier("babarsdecorations", "birch_trellis"), new BlockItem(Birch_Trellis, new FabricItemSettings().group(ModItemGroups.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("babarsdecorations", "jungle_trellis"), Jungle_Trellis);
        Registry.register(Registry.ITEM, new Identifier("babarsdecorations", "jungle_trellis"), new BlockItem(Jungle_Trellis, new FabricItemSettings().group(ModItemGroups.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("babarsdecorations", "dark_oak_trellis"), Dark_Oak_Trellis);
        Registry.register(Registry.ITEM, new Identifier("babarsdecorations", "dark_oak_trellis"), new BlockItem(Dark_Oak_Trellis, new FabricItemSettings().group(ModItemGroups.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("babarsdecorations", "acacia_trellis"), Acacia_Trellis);
        Registry.register(Registry.ITEM, new Identifier("babarsdecorations", "acacia_trellis"), new BlockItem(Acacia_Trellis, new FabricItemSettings().group(ModItemGroups.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("babarsdecorations", "crimson_trellis"), Crimson_Trellis);
        Registry.register(Registry.ITEM, new Identifier("babarsdecorations", "crimson_trellis"), new BlockItem(Crimson_Trellis, new FabricItemSettings().group(ModItemGroups.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("babarsdecorations", "warped_trellis"), Warped_Trellis);
        Registry.register(Registry.ITEM, new Identifier("babarsdecorations", "warped_trellis"), new BlockItem(Warped_Trellis, new FabricItemSettings().group(ModItemGroups.ITEM_GROUP)));
    }
}
