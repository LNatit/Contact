package cloud.lemonslice.silveroak;

import cloud.lemonslice.silveroak.client.ClientProxy;
import cloud.lemonslice.silveroak.common.CommonProxy;
import cloud.lemonslice.silveroak.network.SimpleNetworkHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.*;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static cloud.lemonslice.silveroak.common.item.SilveroakItemsRegistry.ITEM_REGISTER;

//@Mod("silveroakoutpost")
public class SilveroakOutpost
{
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String MODID = "silveroakoutpost";
    public static final CommonProxy PROXY = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);

    private static boolean verification = false;

    public SilveroakOutpost() {
//        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, NormalConfigs.SERVER_CONFIG);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        ITEM_REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public void commonSetup(final FMLCommonSetupEvent event) {
        SimpleNetworkHandler.init();
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        if (verification) {
            info("Password was verified successfully!");
        }
    }

    public static void error(String format, Object... data) {
        SilveroakOutpost.LOGGER.log(Level.ERROR, String.format(format, data));
    }

    public static void warn(String format, Object... data) {
        SilveroakOutpost.LOGGER.log(Level.WARN, String.format(format, data));
    }

    public static void info(String format, Object... data) {
        SilveroakOutpost.LOGGER.log(Level.INFO, String.format(format, data));
    }

    public static void needVerification() {
        verification = true;
    }
}
