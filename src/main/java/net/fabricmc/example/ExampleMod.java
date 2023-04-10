package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.HitResult;
import net.fabricmc.api.*;
import net.fabricmc.fabric.api.client.rendering.v1.*;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.minecraft.block.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.entity.decoration.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.projectile.*;
import net.minecraft.text.*;
import net.minecraft.util.hit.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import javax.swing.text.JTextComponent.KeyBinding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mojang.authlib.minecraft.client.MinecraftClient;

import hure.client.keybind.keyBindings;

public class ExampleMod implements ModInitializer{
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");
	public static final CustomItem CUSTOM_ITEM = new CustomItem(new FabricItemSettings().maxCount(1));
	public static ToolItem HURE_SWORD = new SwordItem(HureToolMaterial.INSTANCE, 99, 5,new Item.Settings());
	public static ToolItem HURE_SHOVEL = new ShovelItem(HureToolMaterial.INSTANCE, 99, 5, new Item.Settings());
	public static ToolItem HURE_PICKAXE = new CustomPickaxeItem(HureToolMaterial.INSTANCE, 99, 5, new Item.Settings());
	public static ToolItem HURE_HOE = new CustomHoeItem(HureToolMaterial.INSTANCE, 99, 5, new Item.Settings());
	public static ToolItem HURE_AXE = new CustomAxeItem(HureToolMaterial.INSTANCE, 99, 5, new Item.Settings());
	private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier("hure", "hure_group")).icon(() -> new ItemStack(CUSTOM_ITEM)).build();

	public static String MOD_ID = "huremod";
	public static final StatusEffect EXP = new CustomEffect();

	@Override
	public void onInitialize() {
		keyBindings.init();
		Registry.register(Registries.STATUS_EFFECT, new Identifier("hure","exp"), EXP);
		Registry.register(Registries.ITEM, new Identifier("hure", "hure_cannon"), CUSTOM_ITEM);
		Registry.register(Registries.ITEM, new Identifier("hure", "hure_sword"), HURE_SWORD);
		Registry.register(Registries.ITEM, new Identifier("hure", "hure_shovel"), HURE_SHOVEL);
		Registry.register(Registries.ITEM, new Identifier("hure", "hure_pickaxe"), HURE_PICKAXE);
		Registry.register(Registries.ITEM, new Identifier("hure", "hure_hoe"), HURE_HOE);
		Registry.register(Registries.ITEM, new Identifier("hure", "hure_axe"), HURE_AXE);
		
		// ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
		// 	content.addAfter(Items.OAK_DOOR, CUSTOM_ITEM);
		// });

		ServerNetworks.init();

		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> {
			content.add(CUSTOM_ITEM);
			content.add(HURE_SWORD);
			content.add(HURE_SHOVEL);
			content.add(HURE_PICKAXE);
			content.add(HURE_HOE);
			content.add(HURE_AXE);
		});
	}

	public static Identifier id(String path) { return new Identifier(MOD_ID,path);}

	
}
