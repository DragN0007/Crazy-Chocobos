package com.dragn0007.chocobos.util;

import com.dragn0007.chocobos.entities.Chocobo;
import com.dragn0007.chocobos.entities.EntityTypes;
import com.dragn0007.chocobos.items.CCItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class ThrownChocoboEgg extends ThrowableItemProjectile {
   public ThrownChocoboEgg(EntityType<? extends ThrownChocoboEgg> p_37473_, Level p_37474_) {
      super(p_37473_, p_37474_);
   }

   public ThrownChocoboEgg(Level p_37481_, LivingEntity p_37482_) {
      super(EntityType.EGG, p_37482_, p_37481_);
   }

   public ThrownChocoboEgg(Level p_37476_, double p_37477_, double p_37478_, double p_37479_) {
      super(EntityType.EGG, p_37477_, p_37478_, p_37479_, p_37476_);
   }

   public void handleEntityEvent(byte p_37484_) {
      if (p_37484_ == 3) {
         double d0 = 0.08D;

         for(int i = 0; i < 8; ++i) {
            this.level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D);
         }
      }

   }

   protected void onHitEntity(EntityHitResult p_37486_) {
      super.onHitEntity(p_37486_);
      p_37486_.getEntity().hurt(this.damageSources().thrown(this, this.getOwner()), 0.0F);
   }

   @Override
   protected void onHit(HitResult p_37488_) {
      super.onHit(p_37488_);
      if (!this.level().isClientSide) {
         int i = 1;
         if (this.random.nextInt(64) == 0) {
            i = 4;
         }

         for (int j = 0; j < i; ++j) {
            Chocobo chocobo = EntityTypes.CHOCOBO_ENTITY.get().create(this.level());
            chocobo.setAge(-24000);
            chocobo.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);

            int randomVariant = this.level().getRandom().nextInt(23);
            chocobo.setVariant(randomVariant);
            int randomOverlayVariant = this.level().getRandom().nextInt(31);
            chocobo.setOverlayVariant(randomOverlayVariant);

            this.level().addFreshEntity(chocobo);
         }

         this.level().broadcastEntityEvent(this, (byte) 3);
         this.discard();
      }
   }

   protected Item getDefaultItem() {
      return CCItems.CHOCOBO_EGG.get();
   }
}