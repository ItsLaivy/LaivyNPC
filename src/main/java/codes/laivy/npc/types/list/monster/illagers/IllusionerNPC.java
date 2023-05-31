package codes.laivy.npc.types.list.monster.illagers;

import codes.laivy.npc.mappings.defaults.classes.entity.Entity;
import codes.laivy.npc.types.NPC;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class IllusionerNPC extends IllagerWizardNPC {

    public static @NotNull IllusionerNPC fastInstance(int id, @NotNull List<OfflinePlayer> players, @NotNull Location location, @Nullable Object object) {
        return new IllusionerNPC(id, players, location);
    }

    public static void debug(@NotNull Location location) {
        IllusionerNPC illusionerNPC = new IllusionerNPC(new ArrayList<>(), location);
        illusionerNPC.debug();
        illusionerNPC.destroy();
    }

    protected IllusionerNPC(int id, @NotNull List<OfflinePlayer> players, @NotNull Entity.EntityType type, @NotNull Location location) {
        super(id, players, type, location);
    }
    public IllusionerNPC(@NotNull List<OfflinePlayer> players, @NotNull Location location) {
        this(NPC.getNextNpcId(), players, location);
    }
    public IllusionerNPC(int id, @NotNull List<OfflinePlayer> players, @NotNull Location location) {
        super(id, players, Entity.EntityType.ILLUSIONER, location);
    }
}
