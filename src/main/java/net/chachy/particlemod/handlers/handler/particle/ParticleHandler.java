package net.chachy.particlemod.handlers.handler.particle;

import cc.hyperium.event.InvokeEvent;
import cc.hyperium.event.PlayerAttackEntityEvent;
import net.chachy.particlemod.config.Configuration;
import net.chachy.particlemod.handlers.utils.Handler;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.EntityDamageSource;

public class ParticleHandler implements Handler {

    @Override
    public String getHandlerName() {
        return "ParticleHandler";
    }

    @InvokeEvent
    public void onAttack(PlayerAttackEntityEvent event) {
        // Create a variable for Configuration#getMultiplier()
        int multiplier = Configuration.INSTANCE.getMultiplier();
        // Create a variable for the entity.
        Entity entity = event.getEntity();
        // Create a variable for Minecraft#thePlayer
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        // Check if the player is null or multiplier is 1 or Configuration#isMultiplyOnAnimals() is false.
        if (player == null || multiplier == 1 || !Configuration.INSTANCE.isMultiplyOnAnimals()) return;
        // Check if the attack was critical.
        boolean critical = player.fallDistance > 0.0f && !player.onGround && !player.isOnLadder() && !player.isInWater() && !player.isPotionActive(Potion.blindness) && player.ridingEntity == null;
        // Create a float to get the EMD (Enchantment Modifier Damage).
        float enchantment = EnchantmentHelper.getEnchantmentModifierDamage(new ItemStack[]{player.getHeldItem()}, new EntityDamageSource("player", player));
        // Create a for statement which loops for the length of the multiplier and runs the code inside.
        for (int i = 1; i < multiplier; ++i) {
            // Checks if enabled.
            if (Configuration.INSTANCE.isEnabled()) {
                // Check if its a critical hit or the multiply without critical hits option is enabled.
                if (critical || Configuration.INSTANCE.isMultiplyWithoutCrits()) {
                    // Run Minecraft#onCriticalHit(entity) to show the critical marks
                    Minecraft.getMinecraft().thePlayer.onCriticalHit(entity);
                }
                // Check if the enchantment float is over 0.0f
                if (enchantment > 0.0f) {
                    // Run Minecraft#onEnchantmentCritical(entity) instead.
                    Minecraft.getMinecraft().thePlayer.onEnchantmentCritical(entity);
                }
            }
        }
    }
}
