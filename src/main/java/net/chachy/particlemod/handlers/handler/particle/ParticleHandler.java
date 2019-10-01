package net.chachy.particlemod.handlers.handler.particle;

import cc.hyperium.event.InvokeEvent;
import cc.hyperium.event.PlayerAttackEntityEvent;
import net.chachy.particlemod.config.Configuration;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.EntityDamageSource;

public class ParticleHandler {
    @InvokeEvent
    public void onAttack(PlayerAttackEntityEvent event) {
        int multiplier = Configuration.INSTANCE.getMultiplier();
        Entity entity = event.getEntity();
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        if (player == null || multiplier == 1 || !Configuration.INSTANCE.isMultiplyOnAnimals()) return;
        boolean critical = player.fallDistance > 0.0f && !player.onGround && !player.isOnLadder() && !player.isInWater() && !player.isPotionActive(Potion.blindness) && player.ridingEntity == null;
        float enchantment = EnchantmentHelper.getEnchantmentModifierDamage(new ItemStack[]{player.getHeldItem()}, new EntityDamageSource("player", player));
        for (int i = 1; i < multiplier; ++i) {
            if (Configuration.INSTANCE.isEnabled()) {
                if (critical || Configuration.INSTANCE.isMultiplyWithoutCrits()) {
                    Minecraft.getMinecraft().thePlayer.onCriticalHit(entity);
                }
                if (enchantment > 0.0f) {
                    Minecraft.getMinecraft().thePlayer.onEnchantmentCritical(entity);
                }
            }
        }
    }
}
