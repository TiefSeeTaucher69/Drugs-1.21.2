package net.benjo.drugsmod.item;

import net.benjo.drugsmod.DrugsMod;
import net.benjo.drugsmod.DrugsMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DrugsMod.MOD_ID);

    public static final DeferredItem<Item> COCAINE = ITEMS.register("cocaine",
            () -> new Item(new Item.Properties().food(ModFoodProperties.COCAINE)));

    public static final DeferredItem<Item> RAW_COCAINE = ITEMS.register("raw_cocaine",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
