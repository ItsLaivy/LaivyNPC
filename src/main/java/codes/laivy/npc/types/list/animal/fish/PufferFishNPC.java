package codes.laivy.npc.types.list.animal.fish;

import codes.laivy.npc.mappings.defaults.classes.entity.animal.fish.Fish;
import codes.laivy.npc.mappings.defaults.classes.entity.animal.fish.PufferFish;
import codes.laivy.npc.types.EntityLivingNPC;
import codes.laivy.npc.types.NPC;
import codes.laivy.npc.types.commands.NPCConfiguration;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static codes.laivy.npc.config.Translate.translate;

public class PufferFishNPC extends FishNPC {

    public static @NotNull PufferFishNPC fastInstance(@NotNull List<OfflinePlayer> players, @NotNull Location location, @NotNull Object object) {
        return new PufferFishNPC(players, location);
    }

    public static void debug(@NotNull Location location) {
        PufferFishNPC pufferFishNPC = new PufferFishNPC(new ArrayList<>(), location);
        pufferFishNPC.debug();
        pufferFishNPC.destroy();
    }

    public PufferFishNPC(@NotNull List<OfflinePlayer> players, @NotNull Location location) {
        super(players, Fish.Type.PUFFERFISH, location);
    }

    public int getPuffState() {
        return getEntity().getPuffState();
    }
    public void setPuffState(int puffState) {
        getEntity().setPuffState(puffState);
        sendUpdatePackets(getSpawnedPlayers(), false, false, true, false, false, false);
    }

    @Override
    public @NotNull PufferFish getEntity() {
        return (PufferFish) super.getEntity();
    }

    @Override
    public List<NPCConfiguration> getByCommandConfigurations() {
        List<NPCConfiguration> list = super.getByCommandConfigurations();

        list.add(new NPCConfiguration("puff", "/laivynpc config puff (size)") {
            @Override
            public void execute(@NotNull NPC npc, @NotNull Player sender, @NotNull String[] args) {
                PufferFishNPC pufferFish = (PufferFishNPC) npc;

                if (args.length > 0) {
                    int size;
                    try {
                        size = Integer.parseInt(args[0].replace(",", "."));
                    } catch (NumberFormatException ignore) {
                        sender.performCommand("laivynpc config " + getName());
                        return;
                    }

                    pufferFish.setPuffState(size);
                    sender.sendMessage(translate(sender, "npc.commands.general.flag_changed"));
                    return;
                }

                sender.sendMessage("§cUse " + getSyntax());
            }
        });

        return list;
    }

    // Serializators
    @Override
    public @NotNull Map<@NotNull String, @NotNull Object> serialize() {
        Map<String, Object> map = super.serialize();
        map.put("TropicalFishNPC Configuration", new LinkedHashMap<String, Object>() {{
            put("Puff state", getPuffState());
        }});
        return map;
    }

    public static @NotNull PufferFishNPC deserialize(@NotNull ConfigurationSection section) {
        PufferFishNPC npc = (PufferFishNPC) EntityLivingNPC.deserialize(section);
        npc.setPuffState(section.getConfigurationSection("TropicalFishNPC Configuration").getInt("Puff state"));
        return npc;
    }
    //
}
