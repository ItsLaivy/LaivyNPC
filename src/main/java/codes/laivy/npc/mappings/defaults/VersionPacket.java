package codes.laivy.npc.mappings.defaults;

import codes.laivy.npc.mappings.defaults.classes.datawatcher.DataWatcher;
import codes.laivy.npc.mappings.defaults.classes.entity.Entity;
import codes.laivy.npc.mappings.defaults.classes.entity.EntityHuman;
import codes.laivy.npc.mappings.defaults.classes.entity.EntityLiving;
import codes.laivy.npc.mappings.defaults.classes.entity.player.EntityPlayer;
import codes.laivy.npc.mappings.defaults.classes.enums.EnumItemSlotEnum;
import codes.laivy.npc.mappings.defaults.classes.enums.EnumPlayerInfoActionEnum;
import codes.laivy.npc.mappings.defaults.classes.others.objects.PlayerConnection;
import codes.laivy.npc.mappings.defaults.classes.packets.*;
import codes.laivy.npc.mappings.defaults.classes.scoreboard.ScoreboardTeam;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;

public interface VersionPacket {

    /**
     * Sends a packet to a list of PlayerConnections
     * @param packet the packet that will be send
     * @param connections the connections
     */
    void sendPacket(@NotNull Packet packet, @NotNull PlayerConnection... connections);

    @NotNull EntitySpawnPacket createSpawnPacket(@NotNull Entity entity);
    @NotNull EntityLivingSpawnPacket createSpawnLivingPacket(@NotNull EntityLiving entity);
    @NotNull EntityNamedSpawnPacket createSpawnNamedPacket(@NotNull EntityHuman entity);

    @NotNull Set<EntityDestroyPacket> createDestroyPacket(@NotNull Entity... entity);
    @NotNull EntityMetadataPacket createMetadataPacket(@NotNull Entity entity, @NotNull DataWatcher dataWatcher, boolean b);
    @Nullable PlayerInfoPacket createPlayerInfoPacket(@Nullable EnumPlayerInfoActionEnum.EnumPlayerInfoAction action, @NotNull EntityPlayer player);
    @NotNull ScoreboardTeamPacket createScoreboardTeamPacket(@NotNull ScoreboardTeam team, boolean b);
    @NotNull Set<EntityEquipmentPacket> createEquipmentPacket(@NotNull Entity entity, @NotNull Map<EnumItemSlotEnum.@NotNull EnumItemSlot, @NotNull ItemStack> items);

    @NotNull EntityTeleportPacket createTeleportPacket(@NotNull Entity entity);
    @NotNull EntityHeadRotationPacket createHeadRotationPacket(@NotNull Entity entity, int yaw);
    @NotNull EntityLookPacket createLookPacket(@NotNull Entity entity, double yaw, double pitch);

    @NotNull EntityUseInPacket.ActionEnum.Action getEntityUseInPacketAction(@NotNull EntityUseInPacket packet);
    
}
