package codes.laivy.npc.types.list.monster;

import codes.laivy.npc.mappings.defaults.classes.entity.Entity;
import codes.laivy.npc.mappings.defaults.classes.entity.monster.Witch;
import codes.laivy.npc.types.EntityLivingNPC;
import codes.laivy.npc.types.NPC;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class WitchNPC extends EntityLivingNPC {

    public static @NotNull WitchNPC fastInstance(int id, @NotNull List<OfflinePlayer> players, @NotNull Location location, @Nullable Object object) {
        return new WitchNPC(id, players, location);
    }

    public static void debug(@NotNull Location location) {
        WitchNPC witchNPC = new WitchNPC(new ArrayList<>(), location);
        witchNPC.debug();
        witchNPC.destroy();
    }

    protected WitchNPC(int id, @NotNull List<OfflinePlayer> players, @NotNull Entity.EntityType type, @NotNull Location location) {
        super(id, players, type, location);
    }
    public WitchNPC(@NotNull List<OfflinePlayer> players, @NotNull Location location) {
        this(NPC.getNextNpcId(), players, location);
    }
    public WitchNPC(int id, @NotNull List<OfflinePlayer> players, @NotNull Location location) {
        super(id, players, Entity.EntityType.WITCH, location);
    }

    @Override
    public @NotNull Witch getEntity() {
        return (Witch) super.getEntity();
    }
}
