package codes.laivy.npc.types;

import codes.laivy.npc.mappings.utils.classes.entity.Entity;
import codes.laivy.npc.mappings.utils.classes.entity.TameableLivingEntity;
import codes.laivy.npc.types.commands.NPCConfiguration;
import codes.laivy.npc.utils.Validation;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static codes.laivy.npc.LaivyNPC.laivynpc;
import static codes.laivy.npc.config.Translate.translate;

public abstract class TameableLivingEntityNPC extends EntityLivingNPC {

    @Override
    public void debug() {
        super.debug();
        setTamed(!isTamed());
        setSitting(!isSitting());
    }

    public TameableLivingEntityNPC(@NotNull List<OfflinePlayer> players, @NotNull Entity.EntityType entityType, @NotNull Location location) {
        super(players, entityType, location);
        Validation.isTrue(!entityType.isAgeableLivingEntity(), new IllegalArgumentException("This EntityType isn't a AgeableLivingEntity."));
    }

    protected @NotNull TameableLivingEntity getNewEntity() {
        return (TameableLivingEntity) laivynpc().getVersion().createEntity(getEntityType(), getLocation());
    }
    public @NotNull TameableLivingEntity getEntity() {
        return (TameableLivingEntity) super.getEntity();
    }

    public boolean isTamed() {
        return getEntity().isTamed();
    }
    public void setTamed(boolean flag) {
        getEntity().setTamed(flag);
        sendUpdatePackets(getSpawnedPlayers(), false, false, true, false, false, false);
    }

    public boolean isSitting() {
        return getEntity().isSitting();
    }
    public void setSitting(boolean flag) {
        getEntity().setSitting(flag);
        sendUpdatePackets(getSpawnedPlayers(), false, false, true, false, false, false);
    }

    @Override
    public List<NPCConfiguration> getByCommandConfigurations() {
        List<NPCConfiguration> list = super.getByCommandConfigurations();

        list.add(new NPCConfiguration("tamed", "/laivynpc config tamed (flag)") {
            @Override
            public void execute(@NotNull NPC npc, @NotNull Player sender, @NotNull String[] args) {
                if (args.length > 0) {
                    boolean flag;
                    if (args[0].equalsIgnoreCase("false")) {
                        flag = false;
                    } else if (args[0].equalsIgnoreCase("true")) {
                        flag = true;
                    } else {
                        sender.performCommand("laivynpc config tamed");
                        return;
                    }

                    ((TameableLivingEntityNPC) npc).setTamed(flag);
                    sender.sendMessage(translate(sender, "npc.commands.general.flag_changed"));
                } else {
                    sender.sendMessage("§cUse /laivynpc config tamed (flag)");
                }
            }
        });
        list.add(new NPCConfiguration("sitting", "/laivynpc config sitting (flag)") {
            @Override
            public void execute(@NotNull NPC npc, @NotNull Player sender, @NotNull String[] args) {
                if (args.length > 0) {
                    boolean flag;
                    if (args[0].equalsIgnoreCase("false")) {
                        flag = false;
                    } else if (args[0].equalsIgnoreCase("true")) {
                        flag = true;
                    } else {
                        sender.performCommand("laivynpc config sitting");
                        return;
                    }

                    ((TameableLivingEntityNPC) npc).setSitting(flag);
                    sender.sendMessage(translate(sender, "npc.commands.general.flag_changed"));
                } else {
                    sender.sendMessage("§cUse /laivynpc config sitting (flag)");
                }
            }
        });

        return list;
    }

    // Serializators
    @Override
    public @NotNull Map<@NotNull String, @NotNull Object> serialize() {
        Map<String, Object> map = super.serialize();
        map.put("TameableNPC Configuration", new LinkedHashMap<String, Object>() {{
            put("Tamed", isTamed());
            put("Sitting", isSitting());
        }});
        return map;
    }

    public static @NotNull TameableLivingEntityNPC deserialize(@NotNull ConfigurationSection section) {
        TameableLivingEntityNPC npc = (TameableLivingEntityNPC) EntityLivingNPC.deserialize(section);

        section = section.getConfigurationSection("TameableNPC Configuration");
        npc.setTamed(section.getBoolean("Tamed"));
        npc.setSitting(section.getBoolean("Sitting"));

        return npc;
    }
    //

}
