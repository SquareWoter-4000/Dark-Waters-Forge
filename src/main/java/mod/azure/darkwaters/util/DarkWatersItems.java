package mod.azure.darkwaters.util;

import mod.azure.azurelib.items.AzureSpawnEgg;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static mod.azure.darkwaters.DarkWatersMod.MODID;

public class DarkWatersItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final RegistryObject<SpawnEggItem> ABERRATION_SPAWN_EGG = ITEMS.register("aberration_spawn_egg", () -> new ForgeSpawnEggItem(DarkWatersMobs.ABERRATION, 0x150056,0x826ccc, (new Item.Properties()).stacksTo(64)));
    public static final RegistryObject<SpawnEggItem> MANARAW_SPAWN_EGG = ITEMS.register("manaraw_spawn_egg", () -> new ForgeSpawnEggItem(DarkWatersMobs.MANARAW, 0x181c59, 0x636b6d, (new Item.Properties()).stacksTo(64)));
    public static final RegistryObject<SpawnEggItem> MOHAST_SPAWN_EGG = ITEMS.register("mohast_spawn_egg", () -> new ForgeSpawnEggItem(DarkWatersMobs.MOHAST, 0x477385, 0xacb7b7, (new Item.Properties()).stacksTo(64)));
    public static final RegistryObject<SpawnEggItem> SIGHT_HUNTER_SPAWN_EGG = ITEMS.register("sighthunter_spawn_egg", () -> new ForgeSpawnEggItem(DarkWatersMobs.SIGHT_HUNTER,0x01293a, 0x808f95, (new Item.Properties()).stacksTo(64)));
    public static final RegistryObject<SpawnEggItem> CRAEKEN_SPAWN_EGG = ITEMS.register("craeken_spawn_egg", () -> new ForgeSpawnEggItem(DarkWatersMobs.CRAEKEN, 0xada7a2, 0xcee3e3, (new Item.Properties()).stacksTo(64)));
    public static final RegistryObject<SpawnEggItem> MIRAID_SPAWN_EGG = ITEMS.register("miraid_spawn_egg", () -> new ForgeSpawnEggItem(DarkWatersMobs.MIRAID, 0x5d5d6e, 0xd6d6d6, (new Item.Properties()).stacksTo(64)));

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

}
