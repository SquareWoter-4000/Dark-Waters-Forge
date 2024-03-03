package mod.azure.darkwaters.util;

import mod.azure.darkwaters.DarkWatersMod;
import mod.azure.darkwaters.entity.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = DarkWatersMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DarkWatersMobs {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DarkWatersMod.MODID);
	public static final RegistryObject<EntityType<AberrationEntity>> ABERRATION = ENTITY_TYPES.register("aberration",
			() -> EntityType.Builder.of(AberrationEntity::new, MobCategory.AMBIENT).fireImmune().sized(0.9f, 2.05F).clientTrackingRange(90).build("aberration"));

	public static final RegistryObject<EntityType<ManarawEntity>> MANARAW = ENTITY_TYPES.register("manaraw",
			() -> EntityType.Builder.of(ManarawEntity::new, MobCategory.AMBIENT).fireImmune().sized(3.6f, 3.95F).clientTrackingRange(90).build("manaraw"));

	public static final RegistryObject<EntityType<MohastEntity>> MOHAST = ENTITY_TYPES.register("mohast",
			() -> EntityType.Builder.of(MohastEntity::new, MobCategory.AMBIENT).fireImmune().sized(2.2f, 0.65F).clientTrackingRange(90).build("mohast"));

	public static final RegistryObject<EntityType<SightHunterEntity>> SIGHT_HUNTER = ENTITY_TYPES.register("sight_hunter",
			() -> EntityType.Builder.of(SightHunterEntity::new, MobCategory.AMBIENT).fireImmune().sized(4.6f, 1.45F).clientTrackingRange(90).build("sight_hunter"));

	public static final RegistryObject<EntityType<CraekenEntity>> CRAEKEN = ENTITY_TYPES.register("craeken",
			() -> EntityType.Builder.of(CraekenEntity::new, MobCategory.AMBIENT).fireImmune().sized(4.6f, 1.95F).clientTrackingRange(90).build("craeken"));

	public static final RegistryObject<EntityType<MiraidEntity>> MIRAID = ENTITY_TYPES.register("miraid",
			() -> EntityType.Builder.of(MiraidEntity::new, MobCategory.AMBIENT).fireImmune().sized(4.6f, 2.95F).clientTrackingRange(90).build("miraid"));
	public static final RegistryObject<EntityType<MiraidHallucinationEntity>> MIRAID_HALLUCINATION = ENTITY_TYPES.register("miraid_hallucination",
			() -> EntityType.Builder.of(MiraidHallucinationEntity::new, MobCategory.AMBIENT).fireImmune().sized(1.6f, 3.45F).clientTrackingRange(90).build("miraid_hallucination"));

	@SubscribeEvent
	public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
		event.register(ABERRATION.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BaseWaterEntity::canSpawnInDarkWater, SpawnPlacementRegisterEvent.Operation.OR);
		event.register(CRAEKEN.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BaseWaterEntity::canSpawnInDarkWater, SpawnPlacementRegisterEvent.Operation.OR);
		event.register(MIRAID.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BaseWaterEntity::canSpawnInDarkWater, SpawnPlacementRegisterEvent.Operation.OR);
		event.register(MIRAID_HALLUCINATION.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BaseWaterEntity::canSpawnInDarkWater, SpawnPlacementRegisterEvent.Operation.OR);
		event.register(MOHAST.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BaseWaterEntity::canSpawnInDarkWater, SpawnPlacementRegisterEvent.Operation.OR);
		event.register(SIGHT_HUNTER.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BaseWaterEntity::canSpawnInDarkWater, SpawnPlacementRegisterEvent.Operation.OR);
		event.register(MANARAW.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BaseWaterEntity::canSpawnInDarkWater, SpawnPlacementRegisterEvent.Operation.OR);
	}


	@SubscribeEvent
	public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
		event.put(ABERRATION.get(), AberrationEntity.createMobAttributes().build());
		event.put(MANARAW.get(), ManarawEntity.createMobAttributes().build());
		event.put(CRAEKEN.get(), CraekenEntity.createMobAttributes().build());
		event.put(MIRAID.get(), MiraidEntity.createMobAttributes().build());
		event.put(MOHAST.get(), MohastEntity.createMobAttributes().build());
		event.put(MIRAID_HALLUCINATION.get(), MiraidHallucinationEntity.createMobAttributes().build());
		event.put(SIGHT_HUNTER.get(), SightHunterEntity.createMobAttributes().build());
	}
}