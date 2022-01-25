package com.ordana.immersive_weathering.registry.items;

import com.ordana.immersive_weathering.ImmersiveWeathering;
import com.ordana.immersive_weathering.registry.blocks.ModBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final BlockItem MOSSY_BRICKS = new BlockItem(ModBlocks.MOSSY_BRICKS, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final BlockItem MOSSY_BRICK_STAIRS = new BlockItem(ModBlocks.MOSSY_BRICK_STAIRS, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final BlockItem MOSSY_BRICK_SLAB = new BlockItem(ModBlocks.MOSSY_BRICK_SLAB, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final BlockItem MOSSY_BRICK_WALL = new BlockItem(ModBlocks.MOSSY_BRICK_WALL, new Item.Settings().group(ItemGroup.DECORATIONS));

    public static final BlockItem MOSSY_STONE = new BlockItem(ModBlocks.MOSSY_STONE, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final BlockItem MOSSY_STONE_STAIRS = new BlockItem(ModBlocks.MOSSY_STONE_STAIRS, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final BlockItem MOSSY_STONE_SLAB = new BlockItem(ModBlocks.MOSSY_STONE_SLAB, new Item.Settings().group(ItemGroup.DECORATIONS));

    public static final BlockItem CRACKED_BRICKS = new BlockItem(ModBlocks.CRACKED_BRICKS, new Item.Settings().group(ItemGroup.DECORATIONS));

    public static final Item STONE_BRICK = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Item BLACKSTONE_BRICK = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Item DEEPSLATE_BRICK = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Item DEEPSLATE_TILE = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

    public static void registerItems() {

        Registry.register(Registry.ITEM, new Identifier(ImmersiveWeathering.MOD_ID, "mossy_bricks"), MOSSY_BRICKS);
        Registry.register(Registry.ITEM, new Identifier(ImmersiveWeathering.MOD_ID, "mossy_brick_stairs"), MOSSY_BRICK_STAIRS);
        Registry.register(Registry.ITEM, new Identifier(ImmersiveWeathering.MOD_ID, "mossy_brick_slab"), MOSSY_BRICK_SLAB);
        Registry.register(Registry.ITEM, new Identifier(ImmersiveWeathering.MOD_ID, "mossy_brick_wall"), MOSSY_BRICK_WALL);

        Registry.register(Registry.ITEM, new Identifier(ImmersiveWeathering.MOD_ID, "mossy_stone"), MOSSY_STONE);
        Registry.register(Registry.ITEM, new Identifier(ImmersiveWeathering.MOD_ID, "mossy_stone_stairs"), MOSSY_STONE_STAIRS);
        Registry.register(Registry.ITEM, new Identifier(ImmersiveWeathering.MOD_ID, "mossy_stone_slab"), MOSSY_STONE_SLAB);

        Registry.register(Registry.ITEM, new Identifier(ImmersiveWeathering.MOD_ID, "cracked_bricks"), CRACKED_BRICKS);

        Registry.register(Registry.ITEM, new Identifier(ImmersiveWeathering.MOD_ID, "stone_brick"), STONE_BRICK);
        Registry.register(Registry.ITEM, new Identifier(ImmersiveWeathering.MOD_ID, "blackstone_brick"), BLACKSTONE_BRICK);
        Registry.register(Registry.ITEM, new Identifier(ImmersiveWeathering.MOD_ID, "deepslate_brick"), DEEPSLATE_BRICK);
        Registry.register(Registry.ITEM, new Identifier(ImmersiveWeathering.MOD_ID, "deepslate_tile"), DEEPSLATE_TILE);

    }
}
