package net.Destiny.destinymod.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FreezeEffect extends MobEffect {
    private static final Logger LOGGER = LogManager.getLogger();
    private final Map<UUID, Vec3> playerInitialPositions = new HashMap<>();

    public FreezeEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level().isClientSide()) {
            UUID playerId = pLivingEntity.getUUID();

            if (!playerInitialPositions.containsKey(playerId)) {
                // Store the initial position only when the effect is applied for this player
                Vec3 initialPosition = pLivingEntity.position();
                playerInitialPositions.put(playerId, initialPosition);

                // Log initial coordinates
                LOGGER.info("Player {} - Initial Coords: X={}, Y={}, Z={}", playerId, initialPosition.x(), initialPosition.y(), initialPosition.z());
            }

            // Teleport back to the initial position
            Vec3 initialPosition = playerInitialPositions.get(playerId);
            pLivingEntity.teleportTo(initialPosition.x(), initialPosition.y(), initialPosition.z());
            pLivingEntity.setDeltaMovement(Vec3.ZERO);
        }

        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
