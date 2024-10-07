package me.fortibrine.playeresp.event.render;

import net.legacyfabric.fabric.api.event.Event;
import net.legacyfabric.fabric.api.event.EventFactory;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.util.ActionResult;

public interface PlayerRenderCallback {
    Event<PlayerRenderCallback> EVENT = EventFactory.createArrayBacked(
            PlayerRenderCallback.class,
            (listeners) -> (player) -> {
                for (PlayerRenderCallback listener : listeners) {
                    ActionResult result = listener.render(player);
                    if (result != ActionResult.PASS) {
                        return result;
                    }
                }

                return ActionResult.PASS;
            }
    );

    ActionResult render(AbstractClientPlayerEntity player);
}

