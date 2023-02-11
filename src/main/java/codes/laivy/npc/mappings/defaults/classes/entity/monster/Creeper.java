package codes.laivy.npc.mappings.defaults.classes.entity.monster;

import codes.laivy.npc.mappings.defaults.classes.datawatcher.DataWatcherObject;
import codes.laivy.npc.mappings.defaults.classes.entity.EntityLiving;
import codes.laivy.npc.mappings.defaults.classes.java.BooleanObjExec;
import codes.laivy.npc.mappings.versions.V1_9_R1;
import codes.laivy.npc.utils.ReflectionUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static codes.laivy.npc.LaivyNPC.laivynpc;

public class Creeper extends EntityLiving {

    public static @NotNull DataWatcherObject IGNITED_METADATA() {
        if (ReflectionUtils.isCompatible(V1_9_R1.class)) {
            return new DataWatcherObject(laivynpc().getVersion().getFieldExec("Metadata:Creeper:Ignited").invokeStatic());
        } else {
            throw new IllegalStateException("Metadata objects is compatible only at 1.9+");
        }
    }
    public static @NotNull DataWatcherObject POWERED_METADATA() {
        if (ReflectionUtils.isCompatible(V1_9_R1.class)) {
            return new DataWatcherObject(laivynpc().getVersion().getFieldExec("Metadata:Creeper:Powered").invokeStatic());
        } else {
            throw new IllegalStateException("Metadata objects is compatible only at 1.9+");
        }
    }

    public Creeper(@Nullable Object value) {
        super(value);
    }

    public boolean isPowered() {
        return laivynpc().getVersion().isEntityCreeperPowered(this);
    }
    public void setPowered(boolean flag) {
        laivynpc().getVersion().setEntityCreeperIgnited(this, flag);
    }

    public boolean isIgnited() {
        return laivynpc().getVersion().isEntityCreeperIgnited(this);
    }
    public void setIgnited(boolean flag) {
        laivynpc().getVersion().setEntityCreeperIgnited(this, flag);
    }

    @Override
    public @NotNull CreeperClass getClassExecutor() {
        return (CreeperClass) laivynpc().getVersion().getClassExec("Entity:Creeper");
    }

    public static class CreeperClass extends EntityLivingClass {
        public CreeperClass(@NotNull String className) {
            super(className);
        }
    }
}
