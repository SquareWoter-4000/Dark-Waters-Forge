package mod.azure.darkwaters;

import java.awt.Color;

import mod.azure.azurelib.AzureLibMod;
import mod.azure.azurelib.config.format.ConfigFormats;
import mod.azure.azurelib.items.AzureSpawnEgg;
import mod.azure.darkwaters.config.DarkWatersConfig;
import mod.azure.darkwaters.effect.StormDarknessEffect;
import mod.azure.darkwaters.entity.helper.AttackType;
import mod.azure.darkwaters.util.DarkWatersMobs;
import mod.azure.darkwaters.util.DarkWatersSounds;
import mod.azure.darkwaters.util.DarkWatersSpawning;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(DarkWatersMod.MODID)
public class DarkWatersMod {

	public static final String MODID = "darkwaters";
	public static DarkWatersConfig config;
	public static final MobEffect STORMDARKNESS = new StormDarknessEffect(MobEffectCategory.BENEFICIAL, new Color(0, 0, 0).getRGB());
	public static final TagKey<Biome> DARKWATER_BIOMES = TagKey.create(Registries.BIOME, DarkWatersMod.modResource("darkwaterbiomes"));
	public static final ResourceKey<CreativeModeTab> GENERAL = ResourceKey.create(Registries.CREATIVE_MODE_TAB, DarkWatersMod.modResource("itemgroup"));
	public static final EntityDataSerializer<AttackType> ATTACK_TYPE = new EntityDataSerializer<>() {
		@Override
		public void write(FriendlyByteBuf packetByteBuf, AttackType alienAttackType) {
			packetByteBuf.writeEnum(alienAttackType);
		}

		@Override
		public AttackType read(FriendlyByteBuf packetByteBuf) {
			return packetByteBuf.readEnum(AttackType.class);
		}

		@Override
		public AttackType copy(AttackType alienAttackType) {
			return alienAttackType;
		}
	};

	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
	public static final RegistryObject<AzureSpawnEgg> ABERRATION_SPAWN_EGG = ITEMS.register("aberration_spawn_egg", () -> new AzureSpawnEgg(DarkWatersMobs.ABERRATION,0x150056,0x826ccc));
	public static final RegistryObject<AzureSpawnEgg> MANARAW_SPAWN_EGG = ITEMS.register("manaraw_spawn_egg", () -> new AzureSpawnEgg(DarkWatersMobs.MANARAW, 0x181c59, 0x636b6d));
	public static final RegistryObject<AzureSpawnEgg> MOHAST_SPAWN_EGG = ITEMS.register("mohast_spawn_egg", () -> new AzureSpawnEgg(DarkWatersMobs.MOHAST, 0x477385, 0xacb7b7));
	public static final RegistryObject<AzureSpawnEgg> SIGHT_HUNTER_SPAWN_EGG = ITEMS.register("sighthunter_spawn_egg", () -> new AzureSpawnEgg(DarkWatersMobs.SIGHT_HUNTER,0x01293a, 0x808f95));
	public static final RegistryObject<AzureSpawnEgg> CRAEKEN_SPAWN_EGG = ITEMS.register("craeken_spawn_egg", () -> new AzureSpawnEgg(DarkWatersMobs.CRAEKEN, 0xada7a2, 0xcee3e3));
	public static final RegistryObject<AzureSpawnEgg> MIRAID_SPAWN_EGG = ITEMS.register("miraid_spawn_egg", () -> new AzureSpawnEgg(DarkWatersMobs.MIRAID, 0x5d5d6e, 0xd6d6d6));

	public static final DeferredRegister<CreativeModeTab> ITEM_GROUPS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

	public static final RegistryObject<CreativeModeTab> DW_CREATIVE_TAB = ITEM_GROUPS.register("dw_tab", () -> CreativeModeTab.builder()
			.title(Component.translatable("itemGroup.darkwaters.itemgroup"))
			.icon(() -> new ItemStack(ABERRATION_SPAWN_EGG.get()))
			.displayItems((params, output) -> {
				output.accept(ABERRATION_SPAWN_EGG.get());
				output.accept(MANARAW_SPAWN_EGG.get());
				output.accept(MOHAST_SPAWN_EGG.get());
				output.accept(SIGHT_HUNTER_SPAWN_EGG.get());
				output.accept(CRAEKEN_SPAWN_EGG.get());
				output.accept(MIRAID_SPAWN_EGG.get());
			}).build());

	public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MODID);

	public static final ResourceLocation modResource(String name) {
		return new ResourceLocation(MODID, name);
	}

	public DarkWatersMod() {
		config = AzureLibMod.registerConfig(DarkWatersConfig.class, ConfigFormats.json()).getConfigInstance();
		DarkWatersMobs.init();
		DarkWatersSounds.init();
		EntityDataSerializers.registerSerializer(ATTACK_TYPE);


		MOB_EFFECTS.register("storm_darkness", () -> STORMDARKNESS);

		IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
		IEventBus forgeBus = MinecraftForge.EVENT_BUS;

		MOB_EFFECTS.register(modBus);
		ITEMS.register(modBus);
		ITEM_GROUPS.register(modBus);


		/*
		ABERRATION_SPAWN_EGG = Registry.register(BuiltInRegistries.ITEM, modResource("aberration_spawn_egg"), new AzureSpawnEgg(DarkWatersMobs.ABERRATION, 0x150056, 0x826ccc));
		MANARAW_SPAWN_EGG = Registry.register(BuiltInRegistries.ITEM, modResource("manaraw_spawn_egg"), new AzureSpawnEgg(DarkWatersMobs.MANARAW, 0x181c59, 0x636b6d));
		MOHAST_SPAWN_EGG = Registry.register(BuiltInRegistries.ITEM, modResource("mohast_spawn_egg"), new AzureSpawnEgg(DarkWatersMobs.MOHAST, 0x477385, 0xacb7b7));
		SIGHT_HUNTER_SPAWN_EGG = Registry.register(BuiltInRegistries.ITEM, modResource("sighthunter_spawn_egg"), new AzureSpawnEgg(DarkWatersMobs.SIGHT_HUNTER, 0x01293a, 0x808f95));
		CRAEKEN_SPAWN_EGG = Registry.register(BuiltInRegistries.ITEM, modResource("craeken_spawn_egg"), new AzureSpawnEgg(DarkWatersMobs.CRAEKEN, 0xada7a2, 0xcee3e3));
		MIRAID_SPAWN_EGG = Registry.register(BuiltInRegistries.ITEM, modResource("miraid_spawn_egg"), new AzureSpawnEgg(DarkWatersMobs.MIRAID, 0x5d5d6e, 0xd6d6d6));
		Registry.register(BuiltInRegistries.MOB_EFFECT, modResource("storm_darkness"), STORMDARKNESS);

		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, GENERAL, FabricItemGroup.builder().icon(() -> new ItemStack(DarkWatersMod.ABERRATION_SPAWN_EGG)) // icon
				.title(Component.translatable("itemGroup.darkwaters.itemgroup")) // title
				.displayItems((context, entries) -> {
					entries.accept(DarkWatersMod.ABERRATION_SPAWN_EGG);
					entries.accept(DarkWatersMod.MANARAW_SPAWN_EGG);
					entries.accept(DarkWatersMod.MOHAST_SPAWN_EGG);
					entries.accept(DarkWatersMod.SIGHT_HUNTER_SPAWN_EGG);
					entries.accept(DarkWatersMod.CRAEKEN_SPAWN_EGG);
					entries.accept(DarkWatersMod.MIRAID_SPAWN_EGG);
				}).build()); // build() no longer registers by itself

		 fabric reference */

		DarkWatersSpawning.addSpawnEntries();
	}
}
