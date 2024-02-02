package me.ix.icksmod.entity.ai;

import me.ix.icksmod.entity.entity.EntityHunter;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.monster.EntityZombie;

public class EntityAIHunterAttack extends EntityAIAttackMelee
{
    private final EntityHunter hunter;
    private int raiseArmTicks;

    public EntityAIHunterAttack(EntityHunter hunterIn, double speedIn, boolean longMemoryIn)
    {
        super(hunterIn, speedIn, longMemoryIn);
        this.hunter = hunterIn;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        super.startExecuting();
        this.raiseArmTicks = 0;
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void resetTask()
    {
        super.resetTask();
        //this.hunter.setArmsRaised(false);
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void updateTask()
    {
        super.updateTask();
        /*
        ++this.raiseArmTicks;

        if (this.raiseArmTicks >= 5 && this.attackTick < 10)
        {
            this.zombie.setArmsRaised(true);
        }
        else
        {
            this.zombie.setArmsRaised(false);
        }
        */
    }
}