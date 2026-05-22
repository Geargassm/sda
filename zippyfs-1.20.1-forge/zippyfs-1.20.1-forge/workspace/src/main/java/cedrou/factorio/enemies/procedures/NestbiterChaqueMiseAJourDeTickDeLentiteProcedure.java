package cedrou.factorio.enemies.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

import cedrou.factorio.enemies.init.FactorioEnemiesModEntities;
import cedrou.factorio.enemies.init.FactorioEnemiesModBlocks;
import cedrou.factorio.enemies.entity.SmallwormEntity;
import cedrou.factorio.enemies.entity.MediumwormEntity;
import cedrou.factorio.enemies.entity.BigwormEntity;
import cedrou.factorio.enemies.entity.BehemothwormEntity;

public class NestbiterChaqueMiseAJourDeTickDeLentiteProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double numberworm = 0;
		numberworm = 0;
		if (Mth.nextInt(RandomSource.create(), 1, 7) == 2) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == FactorioEnemiesModBlocks.NESTBITER.get()) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = FactorioEnemiesModEntities.SMALLBITER.get().spawn(_level,
							BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -2, 2), y + Mth.nextDouble(RandomSource.create(), 1, 2), z + Mth.nextDouble(RandomSource.create(), -2, 2)), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof SmallwormEntity || entityiterator instanceof MediumwormEntity || entityiterator instanceof BigwormEntity || entityiterator instanceof BehemothwormEntity) {
							numberworm = numberworm + 1;
						}
					}
				}
				if (numberworm < Mth.nextInt(RandomSource.create(), 2, 5)) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = FactorioEnemiesModEntities.SMALLWORM.get().spawn(_level,
								BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -6, 6), y + Mth.nextDouble(RandomSource.create(), 1, 2), z + Mth.nextDouble(RandomSource.create(), -6, 6)), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == FactorioEnemiesModBlocks.NESTBITERSMALLMEDIUM.get()) {
				if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = FactorioEnemiesModEntities.MEDIUMBITER.get().spawn(_level,
								BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -2, 2), y + Mth.nextDouble(RandomSource.create(), 1, 2), z + Mth.nextDouble(RandomSource.create(), -2, 2)), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = FactorioEnemiesModEntities.SMALLBITER.get().spawn(_level,
								BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -2, 2), y + Mth.nextDouble(RandomSource.create(), 1, 2), z + Mth.nextDouble(RandomSource.create(), -2, 2)), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof SmallwormEntity || entityiterator instanceof MediumwormEntity || entityiterator instanceof BigwormEntity || entityiterator instanceof BehemothwormEntity) {
							numberworm = numberworm + 1;
						}
					}
				}
				if (numberworm < Mth.nextInt(RandomSource.create(), 2, 5)) {
					if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = FactorioEnemiesModEntities.MEDIUMWORM.get().spawn(_level,
									BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -6, 6), y + Mth.nextDouble(RandomSource.create(), 1, 2), z + Mth.nextDouble(RandomSource.create(), -6, 6)), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = FactorioEnemiesModEntities.SMALLWORM.get().spawn(_level,
									BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -6, 6), y + Mth.nextDouble(RandomSource.create(), 1, 2), z + Mth.nextDouble(RandomSource.create(), -6, 6)), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					}
				}
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == FactorioEnemiesModBlocks.NESTBITERMEDIUM.get()) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = FactorioEnemiesModEntities.MEDIUMBITER.get().spawn(_level,
							BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -2, 2), y + Mth.nextDouble(RandomSource.create(), 1, 2), z + Mth.nextDouble(RandomSource.create(), -2, 2)), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof SmallwormEntity || entityiterator instanceof MediumwormEntity || entityiterator instanceof BigwormEntity || entityiterator instanceof BehemothwormEntity) {
							numberworm = numberworm + 1;
						}
					}
				}
				if (numberworm < Mth.nextInt(RandomSource.create(), 2, 5)) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = FactorioEnemiesModEntities.MEDIUMWORM.get().spawn(_level,
								BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -6, 6), y + Mth.nextDouble(RandomSource.create(), 1, 2), z + Mth.nextDouble(RandomSource.create(), -6, 6)), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == FactorioEnemiesModBlocks.NESTBITERMEDIUMBIG.get()) {
				if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = FactorioEnemiesModEntities.BIGBITER.get().spawn(_level,
								BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -2, 2), y + Mth.nextDouble(RandomSource.create(), 1, 2), z + Mth.nextDouble(RandomSource.create(), -2, 2)), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = FactorioEnemiesModEntities.MEDIUMBITER.get().spawn(_level,
								BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -2, 2), y + Mth.nextDouble(RandomSource.create(), 1, 2), z + Mth.nextDouble(RandomSource.create(), -2, 2)), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof SmallwormEntity || entityiterator instanceof MediumwormEntity || entityiterator instanceof BigwormEntity || entityiterator instanceof BehemothwormEntity) {
							numberworm = numberworm + 1;
						}
					}
				}
				if (numberworm < Mth.nextInt(RandomSource.create(), 2, 5)) {
					if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = FactorioEnemiesModEntities.BIGWORM.get().spawn(_level,
									BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -6, 6), y + Mth.nextDouble(RandomSource.create(), 1, 2), z + Mth.nextDouble(RandomSource.create(), -6, 6)), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = FactorioEnemiesModEntities.MEDIUMWORM.get().spawn(_level,
									BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -6, 6), y + Mth.nextDouble(RandomSource.create(), 1, 2), z + Mth.nextDouble(RandomSource.create(), -6, 6)), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					}
				}
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == FactorioEnemiesModBlocks.NESTBITERBIG.get()) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = FactorioEnemiesModEntities.BIGBITER.get().spawn(_level,
							BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -2, 2), y + Mth.nextDouble(RandomSource.create(), 1, 2), z + Mth.nextDouble(RandomSource.create(), -2, 2)), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof SmallwormEntity || entityiterator instanceof MediumwormEntity || entityiterator instanceof BigwormEntity || entityiterator instanceof BehemothwormEntity) {
							numberworm = numberworm + 1;
						}
					}
				}
				if (numberworm < Mth.nextInt(RandomSource.create(), 2, 5)) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = FactorioEnemiesModEntities.BIGWORM.get().spawn(_level,
								BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -6, 6), y + Mth.nextDouble(RandomSource.create(), 1, 2), z + Mth.nextDouble(RandomSource.create(), -6, 6)), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == FactorioEnemiesModBlocks.NESTBITERBIGBEHEMOTH.get()) {
				if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = FactorioEnemiesModEntities.BEHEMOTHBITER.get().spawn(_level,
								BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -2, 2), y + Mth.nextDouble(RandomSource.create(), 1, 2), z + Mth.nextDouble(RandomSource.create(), -2, 2)), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = FactorioEnemiesModEntities.BIGBITER.get().spawn(_level,
								BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -2, 2), y + Mth.nextDouble(RandomSource.create(), 1, 2), z + Mth.nextDouble(RandomSource.create(), -2, 2)), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof SmallwormEntity || entityiterator instanceof MediumwormEntity || entityiterator instanceof BigwormEntity || entityiterator instanceof BehemothwormEntity) {
							numberworm = numberworm + 1;
						}
					}
				}
				if (numberworm < Mth.nextInt(RandomSource.create(), 2, 5)) {
					if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = FactorioEnemiesModEntities.BEHEMOTHWORM.get().spawn(_level,
									BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -6, 6), y + Mth.nextDouble(RandomSource.create(), 1, 2), z + Mth.nextDouble(RandomSource.create(), -6, 6)), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = FactorioEnemiesModEntities.BIGWORM.get().spawn(_level,
									BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -6, 6), y + Mth.nextDouble(RandomSource.create(), 1, 2), z + Mth.nextDouble(RandomSource.create(), -6, 6)), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					}
				}
			} else {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = FactorioEnemiesModEntities.BEHEMOTHBITER.get().spawn(_level,
							BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -2, 2), y + Mth.nextDouble(RandomSource.create(), 1, 2), z + Mth.nextDouble(RandomSource.create(), -2, 2)), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof SmallwormEntity || entityiterator instanceof MediumwormEntity || entityiterator instanceof BigwormEntity || entityiterator instanceof BehemothwormEntity) {
							numberworm = numberworm + 1;
						}
					}
				}
				if (numberworm < Mth.nextInt(RandomSource.create(), 2, 5)) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = FactorioEnemiesModEntities.BEHEMOTHWORM.get().spawn(_level,
								BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -6, 6), y + Mth.nextDouble(RandomSource.create(), 1, 2), z + Mth.nextDouble(RandomSource.create(), -6, 6)), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			}
		}
	}
}
