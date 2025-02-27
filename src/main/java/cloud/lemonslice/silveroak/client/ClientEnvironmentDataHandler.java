package cloud.lemonslice.silveroak.client;

import cloud.lemonslice.silveroak.SilveroakOutpost;
import cloud.lemonslice.silveroak.common.environment.Humidity;
import cloud.lemonslice.silveroak.common.environment.Rainfall;
import cloud.lemonslice.silveroak.common.environment.Temperature;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.biome.Biome;

import java.text.DecimalFormat;

public final class ClientEnvironmentDataHandler
{
    @SuppressWarnings("deprecation")
    public static Component getTemperatureInfo()
    {
        Player player = SilveroakOutpost.PROXY.getClientPlayer();
        Biome biome = player.level().getBiome(player.blockPosition()).value();
        float tempF = biome.getHeightAdjustedTemperature(player.blockPosition());
        Temperature temperature = Temperature.getTemperatureLevel(tempF);
        return Component.translatable("info.silveroak.environment.temperature", temperature.getTranslation(), new DecimalFormat("0.00").format(tempF));
    }

    public static Component getRainfallInfo()
    {
        Player player = SilveroakOutpost.PROXY.getClientPlayer();
        Biome biome = player.level().getBiome(player.blockPosition()).value();
        float rainfallF = biome.getModifiedClimateSettings().downfall();
        Rainfall rainfall = Rainfall.getRainfallLevel(rainfallF);
        return Component.translatable("info.silveroak.environment.rainfall", rainfall.getTranslation(), new DecimalFormat("0.00").format(rainfallF));
    }

    @SuppressWarnings("deprecation")
    public static Component getHumidityInfo()
    {
        Player player = SilveroakOutpost.PROXY.getClientPlayer();
        Biome biome = player.level().getBiome(player.blockPosition()).value();
        float tempF = biome.getHeightAdjustedTemperature(player.blockPosition());
        float rainfallF = biome.getModifiedClimateSettings().downfall();
        Humidity humidity = Humidity.getHumid(rainfallF, tempF);
        return Component.translatable("info.silveroak.environment.humidity", humidity.getTranslation());
    }
}
