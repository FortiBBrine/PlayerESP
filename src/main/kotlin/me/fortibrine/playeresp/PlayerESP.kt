package me.fortibrine.playeresp

import me.fortibrine.playeresp.event.render.InGameHudRenderCallback
import me.fortibrine.playeresp.event.render.PlayerRenderCallback
import net.fabricmc.api.ModInitializer
import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.DrawableHelper
import net.minecraft.util.ActionResult

class PlayerESP : ModInitializer {

    override fun onInitialize() {

        PlayerRenderCallback.EVENT.register(PlayerRenderCallback { player ->
            player.isGlowing = true

            return@PlayerRenderCallback ActionResult.PASS
        })

        InGameHudRenderCallback.EVENT.register(
            InGameHudRenderCallback { hud, _ ->

                DrawableHelper.fill(
                    5, 5, 50, 20,
                    0xFF000000.toInt()
                )

                hud.drawWithShadow(
                    MinecraftClient.getInstance().textRenderer,
                    "1.12.2",
                    10,
                    10,
                    0xFFFFFFFF.toInt()
                )

                return@InGameHudRenderCallback ActionResult.PASS
            }
        )
    }

}