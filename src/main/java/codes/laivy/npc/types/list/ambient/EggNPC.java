package codes.laivy.npc.types.list.ambient;

import codes.laivy.npc.mappings.defaults.classes.entity.Entity;
import codes.laivy.npc.mappings.defaults.classes.entity.ambient.Egg;
import codes.laivy.npc.types.EntityNPC;
import codes.laivy.npc.types.NPC;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class EggNPC extends EntityNPC {

    public static @NotNull EggNPC fastInstance(int id, @NotNull List<OfflinePlayer> players, @NotNull Location location, @Nullable Object object) {
        return new EggNPC(id, players, location);
    }

    public static void debug(@NotNull Location location) {
        EggNPC egg = new EggNPC(new ArrayList<>(), location);
        egg.debug();
        egg.destroy();
    }

    protected EggNPC(int id, @NotNull List<OfflinePlayer> players, @NotNull Entity.EntityType type, @NotNull Location location) {
        super(id, players, type, location);
    }
    public EggNPC(@NotNull List<OfflinePlayer> players, @NotNull Location location) {
        this(NPC.getNextNpcId(), players, location);
    }
    public EggNPC(int id, @NotNull List<OfflinePlayer> players, @NotNull Location location) {
        super(id, players, Entity.EntityType.EGG, location);
        getHolograms().setDistanceFromNPC(-1.25D);
    }

    @Override
    public @NotNull Egg getEntity() {
        return (Egg) super.getEntity();
    }
}
