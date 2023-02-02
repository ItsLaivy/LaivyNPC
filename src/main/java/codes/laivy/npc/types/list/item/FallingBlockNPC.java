package codes.laivy.npc.types.list.item;

import codes.laivy.npc.mappings.utils.classes.entity.Entity;
import codes.laivy.npc.types.EntityNPC;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static codes.laivy.npc.LaivyNPC.laivynpc;

public class FallingBlockNPC extends EntityNPC {

    public static @NotNull FallingBlockNPC fastInstance(@NotNull List<OfflinePlayer> player, @NotNull Location location, @NotNull Object object) {
        return new FallingBlockNPC(player, Material.valueOf(object.toString()), location);
    }

    public static void debug(@NotNull Location location) {
        FallingBlockNPC fallingBlockNPC = new FallingBlockNPC(new ArrayList<>(), Material.DIAMOND_BLOCK, location);
        fallingBlockNPC.debug();
        fallingBlockNPC.destroy();
    }

    @SuppressWarnings("NullableProblems")
    private final @Nullable Material material;

    public FallingBlockNPC(@NotNull List<OfflinePlayer> players, @NotNull Material material, @NotNull Location location) {
        super(players, Entity.EntityType.FALLING_BLOCK, location);
        this.material = material;
    }

    @Override
    protected @NotNull Entity getNewEntity() {
        if (material != null) {
            return laivynpc().getVersion().createFallingBlockEntity(getLocation(), material);
        } else {
            return laivynpc().getVersion().createFallingBlockEntity(getLocation(), Material.DIAMOND_BLOCK);
        }
    }
}