package me.fortibrine.playeresp.mixin;

import me.fortibrine.playeresp.event.render.PlayerRenderCallback;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityRenderer.class)
public class PlayerEntityRendererMixin {

    @Inject(method = "render(Lnet/minecraft/client/network/AbstractClientPlayerEntity;DDDFF)V", at = @At("TAIL"))
    public void render(AbstractClientPlayerEntity player, double d, double e, double f, float g, float h, CallbackInfo info) {
        PlayerRenderCallback.EVENT.invoker().render(player);
    }

}
