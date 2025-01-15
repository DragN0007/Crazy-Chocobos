package com.dragn0007.chocobos.entities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.Random;

public class Chocobo extends AbstractChocobo implements GeoEntity {
	public static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(Chocobo.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> OVERLAY = SynchedEntityData.defineId(Chocobo.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> BREED = SynchedEntityData.defineId(Chocobo.class, EntityDataSerializers.INT);

	public Chocobo leader;
	public int herdSize = 1;

	public Chocobo(EntityType<? extends Chocobo> type, Level level) {
		super(type, level);
	}

	@Override
	public Vec3 getLeashOffset() {
		return new Vec3(0D, (double) this.getEyeHeight() * 0.8F, (double) (this.getBbWidth() * 1.2F));
		//              ^ Side offset                      ^ Height offset                   ^ Length offset
	}

	public static AttributeSupplier.Builder createBaseChocoboAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.JUMP_STRENGTH)
				.add(Attributes.MAX_HEALTH, 60.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.255F)
				.add(Attributes.ATTACK_DAMAGE, 1D);
	}

	public void randomizeAttributes() {
		this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(this.generateRandomMaxHealth());
		this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(this.generateRandomSpeed());
		this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(this.generateRandomJumpStrength());
	}

	@Override
	public void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 0.7D));
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.4, true));
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 0.0F));

		this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D, AbstractChocobo.class));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, LivingEntity.class, 15.0F, 1.8F, 1.8F, (livingEntity) -> livingEntity instanceof Wolf));
	}

	public float generateRandomMaxHealth() {
		float baseHealth;
		if (getModelResource().equals(BreedModel.ROUNSEY.resourceLocation)) {
			baseHealth = 16.0F;
			return baseHealth + this.random.nextInt(3) + this.random.nextInt(5);
		}
		if (getModelResource().equals(BreedModel.DESTRIER.resourceLocation)) {
			baseHealth = 20.0F;
			return baseHealth + this.random.nextInt(3) + this.random.nextInt(5);
		}
		if (getModelResource().equals(BreedModel.KENNEL.resourceLocation)) {
			baseHealth = 14.0F;
			return baseHealth + this.random.nextInt(3) + this.random.nextInt(5);
		}
		return 15.0F + (float) this.random.nextInt(4) + (float) this.random.nextInt(5);
	}

	public double generateRandomJumpStrength() {
		double baseStrength = 0.6F;
		double multiplier = this.random.nextDouble() * 0.2D + this.random.nextDouble() * 0.2D + this.random.nextDouble() * 0.25D;

		if (getModelResource().equals(BreedModel.ROUNSEY.resourceLocation)) {
			baseStrength = 0.6F;
			return baseStrength + multiplier;
		}
		if (getModelResource().equals(BreedModel.DESTRIER.resourceLocation)) {
			baseStrength = 0.4F;
			return baseStrength + multiplier;
		}
		if (getModelResource().equals(BreedModel.KENNEL.resourceLocation)) {
			baseStrength = 0.5F;
			return baseStrength + multiplier;
		}
		return baseStrength + this.random.nextDouble() * 0.15D;
	}

	public double generateRandomSpeed() {
		double baseSpeed = 0.0F;
		double multiplier = (this.random.nextDouble() * 0.1D + this.random.nextDouble() * 0.1D + this.random.nextDouble() * 0.1D) * 0.30D;

		if (getModelResource().equals(BreedModel.ROUNSEY.resourceLocation)) {
			baseSpeed = 0.2F;
			return baseSpeed + multiplier;
		}
		if (getModelResource().equals(BreedModel.DESTRIER.resourceLocation)) {
			baseSpeed = 0.15F;
			return baseSpeed + multiplier;
		}
		if (getModelResource().equals(BreedModel.KENNEL.resourceLocation)) {
			baseSpeed = 0.15F;
			return baseSpeed + multiplier;
		}
		return baseSpeed + multiplier;
	}

	@Override
	protected boolean canPerformRearing() {
		return false;
	}

	private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(new AnimationController<>(this, "controller", 2, this::predicate));
		controllers.add(new AnimationController<>(this, "emoteController", 5, this::emotePredicate));
	}

	private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
		double x = this.getX() - this.xo;
		double z = this.getZ() - this.zo;

		boolean isMoving = (x * x + z * z) > 0.0001;

		double movementSpeed = this.getAttributeBaseValue(Attributes.MOVEMENT_SPEED);
		double animationSpeed = Math.max(0.1, movementSpeed);

		AnimationController<T> controller = tAnimationState.getController();

		if (this.isJumping()) {
			controller.setAnimation(RawAnimation.begin().then("jump", Animation.LoopType.PLAY_ONCE));
			controller.setAnimationSpeed(1.0);
		} else {
			if (isMoving) {
				if (this.isAggressive() || (this.isVehicle() && this.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(SPRINT_SPEED_MOD))) {
					controller.setAnimation(RawAnimation.begin().then("Run_Faster_R", Animation.LoopType.LOOP));
					controller.setAnimationSpeed(Math.max(0.1, 0.82 * controller.getAnimationSpeed() + animationSpeed));

				} else if (this.isVehicle() && !this.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(WALK_SPEED_MOD) && !this.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(SPRINT_SPEED_MOD)) {
					controller.setAnimation(RawAnimation.begin().then("Run_R", Animation.LoopType.LOOP));
					controller.setAnimationSpeed(Math.max(0.1, 0.8 * controller.getAnimationSpeed() + animationSpeed));

				} else {
					controller.setAnimation(RawAnimation.begin().then("Walk_R", Animation.LoopType.LOOP));
					controller.setAnimationSpeed(Math.max(0.1, 0.84 * controller.getAnimationSpeed() + animationSpeed));
				}
			} else {
				if (this.isVehicle()) {
					controller.setAnimation(RawAnimation.begin().then("Idle_R", Animation.LoopType.LOOP));
				} else {
					controller.setAnimation(RawAnimation.begin().then("Idle_MoreBounce_R", Animation.LoopType.LOOP));
				}
				controller.setAnimationSpeed(1.0);
			}
		}
		return PlayState.CONTINUE;
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.geoCache;
	}

	@Override
	public void playEmote(String emoteName, String loopType) {
		AnimationController<?> controller = this.getAnimatableInstanceCache().getManagerForId(this.getId()).getAnimationControllers().get("emoteController");
		controller.forceAnimationReset();
		controller.stop();
		controller.setAnimation(RawAnimation.begin().then(emoteName, Animation.LoopType.fromString(loopType)));
		this.shouldEmote = true;
	}

	private <T extends GeoAnimatable> PlayState emotePredicate(AnimationState<T> tAnimationState) {
		AnimationController<T> controller = tAnimationState.getController();

		if (tAnimationState.isMoving() || !this.shouldEmote) {
			controller.forceAnimationReset();
			controller.stop();
			this.shouldEmote = false;
			return PlayState.STOP;
		}

		return PlayState.CONTINUE;
	}

	//ground tie
	@Override
	public void tick() {
		super.tick();
		if (this.isSaddled() && !this.isVehicle() || this.isLeashed()) {
			this.getNavigation().stop();
		}
	}

	@Override
	public void positionRider(Entity entity, Entity.MoveFunction moveFunction) {
		if (this.hasPassenger(entity)) {

			double offsetX = 0;
			double offsetY = 1.6;
			double offsetZ = -0.3;

			if (getModelResource().equals(BreedModel.ROUNSEY.resourceLocation)) {
				offsetY = 1.15;
			}

			if (getModelResource().equals(BreedModel.DESTRIER.resourceLocation)) {
				offsetY = 1.55;
			}

			if (getModelResource().equals(BreedModel.KENNEL.resourceLocation)) {
				offsetY = 0.65;
			}

			double radYaw = Math.toRadians(this.getYRot());

			double offsetXRotated = offsetX * Math.cos(radYaw) - offsetZ * Math.sin(radYaw);
			double offsetYRotated = offsetY;
			double offsetZRotated = offsetX * Math.sin(radYaw) + offsetZ * Math.cos(radYaw);

			double x = this.getX() + offsetXRotated;
			double y = this.getY() + offsetYRotated;
			double z = this.getZ() + offsetZRotated;

			entity.setPos(x, y, z);
		}
	}

	@Override
	public SoundEvent getAmbientSound() {
		super.getAmbientSound();
		return SoundEvents.CHICKEN_AMBIENT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return SoundEvents.CHICKEN_DEATH;
	}

	@Nullable
	@Override
	public SoundEvent getEatingSound() {
		return SoundEvents.HORSE_EAT;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource damageSource) {
		super.getHurtSound(damageSource);
		return SoundEvents.CHICKEN_HURT;
	}

	@Override
	public SoundEvent getAngrySound() {
		super.getAngrySound();
		return SoundEvents.CHICKEN_HURT;
	}

	public ResourceLocation getTextureResource() {
		return ChocoboModel.Variant.variantFromOrdinal(getVariant()).resourceLocation;
	}

	public ResourceLocation getOverlayLocation() {
		return ChocoboMarkingLayer.Overlay.overlayFromOrdinal(getOverlayVariant()).resourceLocation;
	}

	public ResourceLocation getModelResource() {
		return BreedModel.breedFromOrdinal(getBreed()).resourceLocation;
	}


	public int getVariant() {
		return this.entityData.get(VARIANT);
	}

	public int getOverlayVariant() {
		return this.entityData.get(OVERLAY);
	}

	public int getBreed() {
		return this.entityData.get(BREED);
	}


	public void setVariant(int variant) {
		this.entityData.set(VARIANT, variant);
	}

	public void setOverlayVariant(int variant) {
		this.entityData.set(OVERLAY, variant);
	}

	public void setBreed(int breed) {
		this.entityData.set(BREED, breed);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);

		if (tag.contains("Variant")) {
			this.setVariant(tag.getInt("Variant"));
		}

		if (tag.contains("Overlay")) {
			this.setOverlayVariant(tag.getInt("Overlay"));
		}

		if (tag.contains("Breed")) {
			this.setBreed(tag.getInt("Breed"));
		}
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putInt("Variant", this.getVariant());
		tag.putInt("Overlay", this.getOverlayVariant());
		tag.putInt("Breed", this.getBreed());
	}

	@Override
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance instance, MobSpawnType spawnType, @Nullable SpawnGroupData data, @Nullable CompoundTag tag) {
		if (data == null) {
			data = new AgeableMobGroupData(0.2F);
		}

		Random random = new Random();
		this.setVariant(random.nextInt(ChocoboModel.Variant.values().length));
		this.setOverlayVariant(random.nextInt(ChocoboMarkingLayer.Overlay.values().length));
		this.setBreed(random.nextInt(BreedModel.values().length));

		this.randomizeAttributes();
		return super.finalizeSpawn(serverLevelAccessor, instance, spawnType, data, tag);
	}

	@Override
	public void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(VARIANT, 0);
		this.entityData.define(OVERLAY, 0);
		this.entityData.define(BREED, 0);
	}

	public boolean canMate(Animal animal) {
		if (animal == this) {
			return false;
		} else if (!(animal instanceof Chocobo)) {
			return false;
		} else {
			return this.canParent() && ((AbstractChocobo) animal).canParent();
		}
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
		AbstractChocobo abstractChocobo;
			Chocobo chocobo = (Chocobo) ageableMob;
			abstractChocobo = EntityTypes.CHOCOBO_ENTITY.get().create(serverLevel);

			int i = this.random.nextInt(9);
			int variant;
			if (i < 4) {
				variant = this.getVariant();
			} else if (i < 8) {
				variant = chocobo.getVariant();
			} else {
				variant = this.random.nextInt(ChocoboModel.Variant.values().length);
			}

			int j = this.random.nextInt(5);
			int overlay;
			if (j < 2) {
				overlay = this.getOverlayVariant();
			} else if (j < 4) {
				overlay = chocobo.getOverlayVariant();
			} else {
				overlay = this.random.nextInt(ChocoboMarkingLayer.Overlay.values().length);
			}

			int k = this.random.nextInt(4);
			int breed;
			if (k == 0) {
				breed = this.random.nextInt(BreedModel.values().length);
			} else {
				breed = (this.random.nextInt(2) == 0) ? this.getBreed() : chocobo.getBreed();
			}

			((Chocobo) abstractChocobo).setVariant(variant);
			((Chocobo) abstractChocobo).setOverlayVariant(overlay);
			((Chocobo) abstractChocobo).setBreed(breed);

			if (this.random.nextInt(4) == 0) {
				int randomJumpStrength = (int) Math.max(chocobo.generateRandomJumpStrength(), this.random.nextInt(10) + 10);
				((Chocobo) abstractChocobo).generateRandomJumpStrength();

				int betterSpeed = (int) Math.max(chocobo.getSpeed(), this.random.nextInt(10) + 20);
				((Chocobo) abstractChocobo).setSpeed(betterSpeed);

				int betterHealth = (int) Math.max(chocobo.getHealth(), this.random.nextInt(20) + 40);
				((Chocobo) abstractChocobo).setHealth(betterHealth);
			} else {
				((Chocobo) abstractChocobo).setSpeed(chocobo.getSpeed());
				((Chocobo) abstractChocobo).setHealth(chocobo.getHealth());
			}

		this.setOffspringAttributes(ageableMob, abstractChocobo);
		return abstractChocobo;
	}

}