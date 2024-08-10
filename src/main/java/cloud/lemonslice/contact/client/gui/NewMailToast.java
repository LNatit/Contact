package cloud.lemonslice.contact.client.gui;

import cloud.lemonslice.contact.common.item.ItemRegistry;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.toasts.Toast;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class NewMailToast implements Toast
{
    @Override
    public Visibility render(GuiGraphics guiGraphics, ToastComponent toastComponent, long ticks)
    {
        PoseStack matrixStack = guiGraphics.pose();
        RenderSystem.setShaderTexture(0, TEXTURE);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        guiGraphics.blit(TEXTURE, 0, 0, 0, 0, this.width(), this.height());

        List<FormattedCharSequence> list = toastComponent.getMinecraft().font.split(Component.translatable("info.contact.new_mail.desc"), 125);
        int i = 16776960;
        if (list.size() == 1)
        {
            guiGraphics.drawString(toastComponent.getMinecraft().font, Component.translatable("info.contact.new_mail.title").getVisualOrderText(), 30.0F, 7.0F, i | -16777216, true);
//            toastComponent.getMinecraft().font.draw(matrixStack, Component.translatable("info.contact.new_mail.title"), 30.0F, 7.0F, i | -16777216);
            guiGraphics.drawString(toastComponent.getMinecraft().font, list.get(0), 30.0F, 18.0F, -1, true);
//            toastComponent.getMinecraft().font.draw(matrixStack, list.get(0), 30.0F, 18.0F, -1);
        }
        else
        {
            if (ticks < 1500L)
            {
                int k = Mth.floor(Mth.clamp((float) (1500L - ticks) / 300.0F, 0.0F, 1.0F) * 255.0F) << 24 | 67108864;
                guiGraphics.drawString(toastComponent.getMinecraft().font, Component.translatable("info.contact.new_mail.desc").getVisualOrderText(), 30.0F, 11.0F, i | k, true);
//                toastComponent.getMinecraft().font.draw(matrixStack, Component.translatable("info.contact.new_mail.desc"), 30.0F, 11.0F, i | k);
            }
            else
            {
                int i1 = Mth.floor(Mth.clamp((float) (ticks - 1500L) / 300.0F, 0.0F, 1.0F) * 252.0F) << 24 | 67108864;
                int l = this.height() / 2 - list.size() * 9 / 2;

                for (FormattedCharSequence formattedCharSequence : list)
                {
                    guiGraphics.drawString(toastComponent.getMinecraft().font, formattedCharSequence, 30.0F, (float) l, 16777215 | i1, false);
//                    toastComponent.getMinecraft().font.draw(matrixStack, formattedCharSequence, 30.0F, (float) l, 16777215 | i1);
                    l += 9;
                }
            }
        }

        guiGraphics.renderItem(new ItemStack(ItemRegistry.MAIL.get()), 8, 8);
        return ticks >= 5000L ? Toast.Visibility.HIDE : Toast.Visibility.SHOW;
    }
}
