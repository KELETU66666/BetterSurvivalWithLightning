package com.mujmajnkraft.bettersurvival.integration;

import bettercombat.mod.network.PacketHandler;
import bettercombat.mod.network.PacketMainhandAttack;
import bettercombat.mod.util.inf.InFHandler;
import com.mujmajnkraft.bettersurvival.BetterSurvival;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;

public abstract class RLCombatCompat {

    public static void attackEntityFromClient(RayTraceResult mov, EntityPlayer player) {
        if((BetterSurvival.isIafLoaded || BetterSurvival.isIafRotnLoaded) && InFHandler.isMultipart(mov.entityHit)) {
            mov.entityHit = InFHandler.getMultipartParent(mov.entityHit);
        }

        player.attackTargetEntityWithCurrentItem(mov.entityHit);
        PacketHandler.instance.sendToServer(new PacketMainhandAttack(mov.entityHit.getEntityId()));
    }
}