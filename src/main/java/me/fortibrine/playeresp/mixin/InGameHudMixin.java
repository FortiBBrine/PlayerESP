package me.fortibrine.playeresp.mixin;

import me.fortibrine.playeresp.event.render.InGameHudRenderCallback;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    public void render(float delta, CallbackInfo info) {
        InGameHud hud = (InGameHud) (Object) this;

        ActionResult result = InGameHudRenderCallback.EVENT.invoker().render(hud, delta);

        if (result == ActionResult.FAIL) {
            info.cancel();
        }
    }

}
