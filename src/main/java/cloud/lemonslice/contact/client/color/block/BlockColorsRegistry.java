package cloud.lemonslice.contact.client.color.block;

import net.fabricmc.fabric.impl.client.rendering.ColorProviderRegistryImpl;
import net.minecraft.client.color.block.BlockColorProvider;

import static cloud.lemonslice.contact.common.block.BlockRegistry.*;

public final class BlockColorsRegistry
{
    public static final BlockColorProvider MAILBOX_COLOR = new MailboxBlockColor();

    public static void init()
    {
        ColorProviderRegistryImpl.BLOCK.register(MAILBOX_COLOR,
                ORANGE_MAILBOX, MAGENTA_MAILBOX, LIGHT_BLUE_MAILBOX, YELLOW_MAILBOX,
                LIME_MAILBOX, PINK_MAILBOX, GRAY_MAILBOX, LIGHT_GRAY_MAILBOX,
                CYAN_MAILBOX, PURPLE_MAILBOX, BLUE_MAILBOX, BROWN_MAILBOX,
                GREEN_MAILBOX, RED_MAILBOX, BLACK_MAILBOX, WHITE_MAILBOX);
    }
}
