package cloud.lemonslice.contact.data;

import cloud.lemonslice.contact.data.provider.AdvancementProvider;
import cloud.lemonslice.contact.data.provider.RecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static cloud.lemonslice.contact.Contact.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGatherHandler
{
    @SubscribeEvent
    public static void onDataGather(GatherDataEvent event)
    {
        DataGenerator gen = event.getGenerator();
        gen.addProvider(event.includeServer(), new RecipeProvider(gen));
        gen.addProvider(event.includeServer(), new AdvancementProvider(gen));
    }
}
