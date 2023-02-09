package codes.laivy.npc.types.list.animal;

import codes.laivy.npc.mappings.defaults.classes.entity.Entity;
import codes.laivy.npc.mappings.defaults.classes.entity.animal.Parrot;
import codes.laivy.npc.types.NPC;
import codes.laivy.npc.types.TameableLivingEntityNPC;
import codes.laivy.npc.types.commands.NPCConfiguration;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static codes.laivy.npc.config.Translate.translate;

public class ParrotNPC extends TameableLivingEntityNPC {

    public static @NotNull ParrotNPC fastInstance(@NotNull List<OfflinePlayer> players, @NotNull Location location, @Nullable Object object) {
        return new ParrotNPC(players, location);
    }

    public static void debug(@NotNull Location location) {
        ParrotNPC parrotNPC = new ParrotNPC(new ArrayList<>(), location);
        parrotNPC.debug();
        parrotNPC.destroy();
    }

    @Override
    public void debug() {
        super.debug();
        setVariant(getVariant());
    }

    public ParrotNPC(@NotNull List<OfflinePlayer> players, @NotNull Location location) {
        super(players, Entity.EntityType.PARROT, location);
        getHolograms().setDistanceFromNPC(-1.25D);
    }

    public @NotNull Parrot.Variant getVariant() {
        return getEntity().getVariant();
    }
    public void setVariant(@NotNull Parrot.Variant variant) {
        getEntity().setVariant(variant);
        sendUpdatePackets(getSpawnedPlayers(), false, false, true, false, false, false);
    }

    @Override
    public @NotNull Parrot getEntity() {
        return (Parrot) super.getEntity();
    }

    @Override
    public List<NPCConfiguration> getByCommandConfigurations() {
        List<NPCConfiguration> list = super.getByCommandConfigurations();

        list.add(new NPCConfiguration("variant", "/laivynpc config variant") {
            @Override
            public void execute(@NotNull NPC npc, @NotNull Player sender, @NotNull String[] args) {
                ParrotNPC parrotNPC = (ParrotNPC) npc;

                if (args.length > 0) {
                    try {
                        Parrot.Variant variant = Parrot.Variant.valueOf(args[0].toUpperCase());
                        parrotNPC.setVariant(variant);
                        sender.sendMessage(translate(sender, "npc.commands.general.flag_changed"));
                    } catch (IllegalArgumentException ignore) {
                        sender.performCommand("laivynpc config " + getName());
                        return;
                    }
                    return;
                }

                StringBuilder builder = new StringBuilder();
                int row = 0;
                for (Parrot.Variant variant : Parrot.Variant.values()) {
                    if (row != 0) builder.append("§7, ");
                    builder.append("§f").append(variant.name());
                    row++;
                }

                sender.sendMessage("§cUse " + getSyntax());
                sender.sendMessage(translate(sender, "npc.commands.general.available_options", builder));
            }
        });

        return list;
    }

    // Serializators
    @Override
    public @NotNull Map<@NotNull String, @NotNull Object> serialize() {
        Map<String, Object> map = super.serialize();
        map.put("ParrotNPC Configuration", new HashMap<String, Object>() {{
            put("Variant", getVariant().name());
        }});

        return map;
    }

    public static @NotNull ParrotNPC deserialize(@NotNull ConfigurationSection section) {
        ParrotNPC npc = (ParrotNPC) TameableLivingEntityNPC.deserialize(section);

        section = section.getConfigurationSection("ParrotNPC Configuration");
        npc.setVariant(Parrot.Variant.valueOf(section.getString("Variant").toUpperCase()));

        return npc;
    }
    //

}
