package codes.laivy.npc.mappings.utils.classes.enums;

import codes.laivy.npc.mappings.instances.classes.ClassExecutor;
import codes.laivy.npc.mappings.instances.EnumExecutor;
import codes.laivy.npc.mappings.utils.classes.java.EnumObjExec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static codes.laivy.npc.LaivyNPC.laivynpc;

public class EnumChatFormatEnum extends EnumExecutor {

    public static @NotNull EnumChatFormatEnum getInstance() {
        return (EnumChatFormatEnum) laivynpc().getVersion().getEnumExec("EnumChatFormat");
    }
    
    public static @NotNull EnumChatFormat BLACK() {
        return new EnumChatFormat(getInstance().getEnums().get("BLACK").getValue());
    }
    public static @NotNull EnumChatFormat DARK_BLUE() {
        return new EnumChatFormat(getInstance().getEnums().get("DARK_BLUE").getValue());
    }
    public static @NotNull EnumChatFormat DARK_GREEN() {
        return new EnumChatFormat(getInstance().getEnums().get("DARK_GREEN").getValue());
    }
    public static @NotNull EnumChatFormat DARK_AQUA() {
        return new EnumChatFormat(getInstance().getEnums().get("DARK_AQUA").getValue());
    }
    public static @NotNull EnumChatFormat DARK_RED() {
        return new EnumChatFormat(getInstance().getEnums().get("DARK_RED").getValue());
    }
    public static @NotNull EnumChatFormat DARK_PURPLE() {
        return new EnumChatFormat(getInstance().getEnums().get("DARK_PURPLE").getValue());
    }
    public static @NotNull EnumChatFormat GOLD() {
        return new EnumChatFormat(getInstance().getEnums().get("GOLD").getValue());
    }
    public static @NotNull EnumChatFormat GRAY() {
        return new EnumChatFormat(getInstance().getEnums().get("GRAY").getValue());
    }
    public static @NotNull EnumChatFormat DARK_GRAY() {
        return new EnumChatFormat(getInstance().getEnums().get("DARK_GRAY").getValue());
    }
    public static @NotNull EnumChatFormat BLUE() {
        return new EnumChatFormat(getInstance().getEnums().get("BLUE").getValue());
    }
    public static @NotNull EnumChatFormat GREEN() {
        return new EnumChatFormat(getInstance().getEnums().get("GREEN").getValue());
    }
    public static @NotNull EnumChatFormat AQUA() {
        return new EnumChatFormat(getInstance().getEnums().get("AQUA").getValue());
    }
    public static @NotNull EnumChatFormat RED() {
        return new EnumChatFormat(getInstance().getEnums().get("RED").getValue());
    }
    public static @NotNull EnumChatFormat LIGHT_PURPLE() {
        return new EnumChatFormat(getInstance().getEnums().get("LIGHT_PURPLE").getValue());
    }
    public static @NotNull EnumChatFormat YELLOW() {
        return new EnumChatFormat(getInstance().getEnums().get("YELLOW").getValue());
    }
    public static @NotNull EnumChatFormat WHITE() {
        return new EnumChatFormat(getInstance().getEnums().get("WHITE").getValue());
    }

    public EnumChatFormatEnum(@NotNull ClassExecutor classExecutor) {
        super(classExecutor);
    }

    public static class EnumChatFormat extends EnumObjExec {
        public EnumChatFormat(@Nullable Enum<?> value) {
            super(value);
        }
    }

    public static class EnumChatFormatClass extends ClassExecutor {
        public EnumChatFormatClass(@NotNull String className) {
            super(className);
        }
    }
}
