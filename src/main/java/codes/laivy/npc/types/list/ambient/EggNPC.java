package codes.laivy.npc.types.list.ambient;

import codes.laivy.npc.mappings.utils.classes.entity.Entity;
import codes.laivy.npc.mappings.utils.classes.entity.ambient.Egg;
import codes.laivy.npc.types.EntityNPC;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class EggNPC extends EntityNPC {

    public static @NotNull EggNPC fastInstance(@NotNull List<OfflinePlayer> player, @NotNull Location location, @Nullable Object object) {
        return new EggNPC(player, location);
    }

    public static void debug(@NotNull Location location) {
        EggNPC egg = new EggNPC(new ArrayList<>(), location);
        egg.debug();
        egg.destroy();
    }

    public EggNPC(@NotNull List<OfflinePlayer> players, @NotNull Location location) {
        super(players, Entity.EntityType.EGG, location);
        getHolograms().setDistanceFromNPC(-1.25D);
    }

    @Override
    public @NotNull Egg getEntity() {
        return (Egg) super.getEntity();
    }
}
