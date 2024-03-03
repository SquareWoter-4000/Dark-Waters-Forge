package mod.azure.darkwaters.util;

import mod.azure.darkwaters.DarkWatersMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DarkWatersSounds {

	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DarkWatersMod.MODID);
	public static final RegistryObject<SoundEvent> ABBERATION_AGGRO = register("darkwaters.abberation_aggro");
	public static final RegistryObject<SoundEvent> ABBERATION_AMBIENT = register("darkwaters.abberation_ambient");
	public static final RegistryObject<SoundEvent> ABBERATION_ATTACK = register("darkwaters.abberation_attack");
	public static final RegistryObject<SoundEvent> ABBERATION_HURT = register("darkwaters.abberation_hurt");
	public static final RegistryObject<SoundEvent> CRAEKEN_ATTACK1 = register("darkwaters.craeken_attack");
	public static final RegistryObject<SoundEvent> CRAEKEN_ATTACK2 = register("darkwaters.craeken_attack2");
	public static final RegistryObject<SoundEvent> CRAEKEN_HURT1 = register("darkwaters.craeken_hurt1");
	public static final RegistryObject<SoundEvent> CRAEKEN_HURT2 = register("darkwaters.craeken_hurt2");
	public static final RegistryObject<SoundEvent> MANARAW_AGGRO1 = register("darkwaters.manaraw_aggro");
	public static final RegistryObject<SoundEvent> MANARAW_AGGRO2 = register("darkwaters.manaraw_aggro2");
	public static final RegistryObject<SoundEvent> MANARAW_AMBIENT1 = register("darkwaters.manaraw_ambient1");
	public static final RegistryObject<SoundEvent> MANARAW_AMBIENT2 = register("darkwaters.manaraw_ambient2");
	public static final RegistryObject<SoundEvent> MANARAW_ATTACK = register("darkwaters.manaraw_attack");
	public static final RegistryObject<SoundEvent> MANARAW_HURT = register("darkwaters.manaraw_hurt");
	public static final RegistryObject<SoundEvent> MIRAD_HUM = register("darkwaters.hallucination_hum");
	public static final RegistryObject<SoundEvent> MIRAD_AMBIENT = register("darkwaters.miraid_aggroambient");
	public static final RegistryObject<SoundEvent> MIRAD_HURT = register("darkwaters.miraid_hallucination_hurt");
	public static final RegistryObject<SoundEvent> MOHAST_AMBIENT1 = register("darkwaters.mohast_ambient1");
	public static final RegistryObject<SoundEvent> MOHAST_AMBIENT2 = register("darkwaters.mohast_ambient2");
	public static final RegistryObject<SoundEvent> MOHAST_ATTACK_HURT = register("darkwaters.mohast_hurt_attack");
	public static final RegistryObject<SoundEvent> SLIGHTHUNTER_AGGRO = register("darkwaters.sighthunter_aggro");
	public static final RegistryObject<SoundEvent> SLIGHTHUNTER_AMBIENT1 = register("darkwaters.sighthunter_aggroambient");
	public static final RegistryObject<SoundEvent> SLIGHTHUNTER_AMBIENT2 = register("darkwaters.sighthunter_aggroambient2");
	public static final RegistryObject<SoundEvent> SLIGHTHUNTER_ATTACK_HURT = register("darkwaters.sighthunter_attack_hurt");
	public static final RegistryObject<SoundEvent> STORM_ABIENT1 = register("darkwaters.storm_ambient1");
	public static final RegistryObject<SoundEvent> STORM_ABIENT2 = register("darkwaters.storm_ambient2");
	public static final RegistryObject<SoundEvent> STORM_ABIENT3 = register("darkwaters.storm_ambient3");
	public static final RegistryObject<SoundEvent> STORM_BEGINNING1 = register("darkwaters.storm_beginning");
	public static final RegistryObject<SoundEvent> STORM_BEGINNING2 = register("darkwaters.storm_beginning2");
	public static final RegistryObject<SoundEvent> STORM_END = register("darkwaters.storm_end");

	private static RegistryObject<SoundEvent> register(String location) {
		return SOUNDS.register(location, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DarkWatersMod.MODID, location)));
	}

}
