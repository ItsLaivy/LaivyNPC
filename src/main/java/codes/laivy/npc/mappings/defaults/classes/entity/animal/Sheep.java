package codes.laivy.npc.mappings.defaults.classes.entity.animal;

import codes.laivy.npc.mappings.defaults.classes.entity.AgeableEntityLiving;
import codes.laivy.npc.mappings.defaults.classes.enums.EnumColorEnum;
import codes.laivy.npc.mappings.defaults.classes.java.BooleanObjExec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static codes.laivy.npc.LaivyNPC.laivynpc;

public class Sheep extends AgeableEntityLiving {
    public Sheep(@Nullable Object value) {
        super(value);
    }

    public @NotNull EnumColorEnum.EnumColor getColor() {
        return laivynpc().getVersion().getEntitySheepColor(this);
    }
    public void setColor(@NotNull EnumColorEnum.EnumColor color) {
        laivynpc().getVersion().setEntitySheepColor(this, color);
    }

    public boolean isSheared() {
        return laivynpc().getVersion().isEntitySheepSheared(this);
    }
    public void setSheared(boolean flag) {
        laivynpc().getVersion().setEntitySheepSheared(this, flag);
    }

    @Override
    public @NotNull SheepClass getClassExecutor() {
        return (SheepClass) laivynpc().getVersion().getClassExec("Entity:Sheep");
    }

    public static class SheepClass extends AgeableEntityLivingClass {
        public SheepClass(@NotNull String className) {
            super(className);
        }
    }
}
