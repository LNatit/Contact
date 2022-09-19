package cloud.lemonslice.contact.common.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

import static cloud.lemonslice.contact.Contact.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public final class NormalConfigs
{
    public static final ForgeConfigSpec SERVER_CONFIG = new ForgeConfigSpec.Builder().configure(ServerConfig::new).getRight();
    public static final ForgeConfigSpec CLIENT_CONFIG = new ForgeConfigSpec.Builder().configure(ClientConfig::new).getRight();
    public static final ForgeConfigSpec COMMON_CONFIG = new ForgeConfigSpec.Builder().configure(CommonConfig::new).getRight();

    @SubscribeEvent
    public static void onReload(ModConfigEvent.Reloading event)
    {
        ((CommentedFileConfig) event.getConfig().getConfigData()).load();
    }
}
