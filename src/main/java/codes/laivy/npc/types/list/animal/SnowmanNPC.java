package codes.laivy.npc.types.list.animal;

import codes.laivy.npc.config.Translate;
import codes.laivy.npc.mappings.utils.classes.entity.Entity;
import codes.laivy.npc.mappings.utils.classes.entity.animal.Snowman;
import codes.laivy.npc.mappings.versions.V1_9_R1;
import codes.laivy.npc.types.EntityLivingNPC;
import codes.laivy.npc.types.NPC;
import codes.laivy.npc.types.commands.NPCConfiguration;
import codes.laivy.npc.utils.ReflectionUtils;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static codes.laivy.npc.config.Translate.translate;

public class SnowmanNPC extends EntityLivingNPC {

    public static @NotNull SnowmanNPC fastInstance(@NotNull List<OfflinePlayer> player, @NotNull Location location, @Nullable Object object) {
        return new SnowmanNPC(player, location);
    }

    public static void debug(@NotNull Location location) {
        SnowmanNPC snowmanNPC = new SnowmanNPC(new ArrayList<>(), location);
        snowmanNPC.debug();
        snowmanNPC.destroy();
    }

    @Override
    protected void debug() {
        super.debug();

        if (ReflectionUtils.isCompatible(V1_9_R1.class)) {
            setPumpkinHat(!hasPumpkinHat());
        }
    }

    public SnowmanNPC(@NotNull List<OfflinePlayer> players, @NotNull Location location) {
        super(players, Entity.EntityType.SNOWMAN, location);
    }

    public boolean hasPumpkinHat() {
        return getEntity().hasPumpkinHat();
    }
    public void setPumpkinHat(boolean flag) {
        getEntity().setPumpkinHat(flag);
        sendUpdatePackets(getSpawnedPlayers(), false, false, true, false, false, false);
    }

    @Override
    public List<NPCConfiguration> getByCommandConfigurations() {
        List<NPCConfiguration> list = super.getByCommandConfigurations();

        if (ReflectionUtils.isCompatible(V1_9_R1.class)) {
            list.add(new NPCConfiguration("pumpkin", "/laivynpc config pumpkin (flag)") {
                @Override
                public void execute(@NotNull NPC npc, @NotNull Player sender, @NotNull String[] args) {
                    SnowmanNPC snowmanNPC = (SnowmanNPC) npc;

                    if (!ReflectionUtils.isCompatible(V1_9_R1.class)) {
                        sender.sendMessage(Translate.translate(sender, "npc.commands.snowman.version"));
                        return;
                    }

                    if (args.length > 0) {
                        boolean flag;
                        if (args[0].equalsIgnoreCase("false")) {
                            flag = false;
                        } else if (args[0].equalsIgnoreCase("true")) {
                            flag = true;
                        } else {
                            sender.performCommand("laivynpc config " + getName());
                            return;
                        }

                        snowmanNPC.setPumpkinHat(flag);
                        sender.sendMessage(translate(sender, "npc.commands.general.flag_changed"));
                        return;
                    }

                    sender.sendMessage("§cUse " + getSyntax());
                }
            });
        }

        return list;
    }

    @Override
    public @NotNull Snowman getEntity() {
        return (Snowman) super.getEntity();
    }
}