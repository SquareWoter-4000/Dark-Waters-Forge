package mod.azure.darkwaters.client;

import mod.azure.darkwaters.DarkWatersMod;
import mod.azure.darkwaters.client.renders.AberrationRender;
import mod.azure.darkwaters.client.renders.CraekenRender;
import mod.azure.darkwaters.client.renders.ManarawRender;
import mod.azure.darkwaters.client.renders.MiraidHallucinationRender;
import mod.azure.darkwaters.client.renders.MiraidRender;
import mod.azure.darkwaters.client.renders.MohastRender;
import mod.azure.darkwaters.client.renders.SightHunterRender;
import mod.azure.darkwaters.util.DarkWatersMobs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DarkWatersMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DarkWatersClient {

	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {

		event.registerEntityRenderer(DarkWatersMobs.ABERRATION.get(), (ctx) -> new AberrationRender(ctx));
		event.registerEntityRenderer(DarkWatersMobs.CRAEKEN.get(), (ctx) -> new CraekenRender(ctx));
		event.registerEntityRenderer(DarkWatersMobs.MANARAW.get(), (ctx) -> new ManarawRender(ctx));
		event.registerEntityRenderer(DarkWatersMobs.MIRAID_HALLUCINATION.get(), (ctx) -> new MiraidHallucinationRender(ctx));
		event.registerEntityRenderer(DarkWatersMobs.MIRAID.get(), (ctx) -> new MiraidRender(ctx));
		event.registerEntityRenderer(DarkWatersMobs.MOHAST.get(), (ctx) -> new MohastRender(ctx));
		event.registerEntityRenderer(DarkWatersMobs.SIGHT_HUNTER.get(), (ctx) -> new SightHunterRender(ctx));

	}
}
