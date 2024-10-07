package me.fortibrine.playeresp.event.render;

import net.legacyfabric.fabric.api.event.Event;
import net.legacyfabric.fabric.api.event.EventFactory;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.util.ActionResult;

public interface InGameHudRenderCallback {
    Event<InGameHudRenderCallback> EVENT = EventFactory.createArrayBacked(
            InGameHudRenderCallback.class,
            (listeners) -> (hud, delta) -> {
                for (InGameHudRenderCallback listener : listeners) {
                    ActionResult result = listener.render(hud, delta);
                    if (result != ActionResult.PASS) {
                        return result;
                    }
                }

                return ActionResult.PASS;
            }
    );

    ActionResult render(InGameHud hud, float delta);
}

