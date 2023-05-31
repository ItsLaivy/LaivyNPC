package codes.laivy.npc.mappings.versions;

import codes.laivy.npc.mappings.Version;
import codes.laivy.npc.mappings.defaults.classes.datawatcher.DataWatcher;
import codes.laivy.npc.mappings.defaults.classes.datawatcher.DataWatcherItem;
import codes.laivy.npc.mappings.defaults.classes.datawatcher.DataWatcherObject;
import codes.laivy.npc.mappings.defaults.classes.entity.*;
import codes.laivy.npc.mappings.defaults.classes.entity.ambient.Bat;
import codes.laivy.npc.mappings.defaults.classes.entity.ambient.Egg;
import codes.laivy.npc.mappings.defaults.classes.entity.animal.*;
import codes.laivy.npc.mappings.defaults.classes.entity.animal.fish.*;
import codes.laivy.npc.mappings.defaults.classes.entity.animal.horse.*;
import codes.laivy.npc.mappings.defaults.classes.entity.boss.dragon.EnderDragon;
import codes.laivy.npc.mappings.defaults.classes.entity.boss.dragon.EnderSignal;
import codes.laivy.npc.mappings.defaults.classes.entity.boss.wither.Wither;
import codes.laivy.npc.mappings.defaults.classes.entity.boss.wither.WitherSkull;
import codes.laivy.npc.mappings.defaults.classes.entity.decoration.ArmorStand;
import codes.laivy.npc.mappings.defaults.classes.entity.decoration.ItemFrame;
import codes.laivy.npc.mappings.defaults.classes.entity.decoration.LeashKnot;
import codes.laivy.npc.mappings.defaults.classes.entity.item.FallingBlock;
import codes.laivy.npc.mappings.defaults.classes.entity.item.Item;
import codes.laivy.npc.mappings.defaults.classes.entity.monster.*;
import codes.laivy.npc.mappings.defaults.classes.entity.monster.illagers.Evoker;
import codes.laivy.npc.mappings.defaults.classes.entity.monster.illagers.IllagerWizard;
import codes.laivy.npc.mappings.defaults.classes.entity.monster.illagers.Illusioner;
import codes.laivy.npc.mappings.defaults.classes.entity.monster.illagers.Vindicator;
import codes.laivy.npc.mappings.defaults.classes.entity.monster.skeleton.Skeleton;
import codes.laivy.npc.mappings.defaults.classes.entity.monster.skeleton.SkeletonStray;
import codes.laivy.npc.mappings.defaults.classes.entity.monster.skeleton.SkeletonWither;
import codes.laivy.npc.mappings.defaults.classes.entity.monster.zombie.Zombie;
import codes.laivy.npc.mappings.defaults.classes.entity.monster.zombie.ZombieDrowned;
import codes.laivy.npc.mappings.defaults.classes.entity.monster.zombie.ZombieHusk;
import codes.laivy.npc.mappings.defaults.classes.entity.monster.zombie.ZombieVillager;
import codes.laivy.npc.mappings.defaults.classes.entity.npc.Villager;
import codes.laivy.npc.mappings.defaults.classes.entity.npc.objs.VillagerData;
import codes.laivy.npc.mappings.defaults.classes.entity.npc.objs.VillagerProfessionExec;
import codes.laivy.npc.mappings.defaults.classes.entity.npc.objs.VillagerType;
import codes.laivy.npc.mappings.defaults.classes.entity.player.EntityPlayer;
import codes.laivy.npc.mappings.defaults.classes.entity.player.ProfilePublicKey;
import codes.laivy.npc.mappings.defaults.classes.entity.vehicle.Boat;
import codes.laivy.npc.mappings.defaults.classes.enums.*;
import codes.laivy.npc.mappings.defaults.classes.gameprofile.GameProfile;
import codes.laivy.npc.mappings.defaults.classes.gameprofile.Property;
import codes.laivy.npc.mappings.defaults.classes.gameprofile.PropertyMap;
import codes.laivy.npc.mappings.defaults.classes.nbt.NBTBase;
import codes.laivy.npc.mappings.defaults.classes.nbt.tags.*;
import codes.laivy.npc.mappings.defaults.classes.others.chat.IChatBaseComponent;
import codes.laivy.npc.mappings.defaults.classes.others.inventories.InventorySubcontainer;
import codes.laivy.npc.mappings.defaults.classes.others.location.*;
import codes.laivy.npc.mappings.defaults.classes.others.managers.PlayerInteractManager;
import codes.laivy.npc.mappings.defaults.classes.others.objects.*;
import codes.laivy.npc.mappings.defaults.classes.others.server.CraftServer;
import codes.laivy.npc.mappings.defaults.classes.others.server.MinecraftServer;
import codes.laivy.npc.mappings.defaults.classes.packets.*;
import codes.laivy.npc.mappings.defaults.classes.packets.info.legacy.PlayerInfoPacket;
import codes.laivy.npc.mappings.defaults.classes.scoreboard.CraftScoreboard;
import codes.laivy.npc.mappings.defaults.classes.scoreboard.Scoreboard;
import codes.laivy.npc.mappings.defaults.classes.scoreboard.ScoreboardTeam;
import codes.laivy.npc.mappings.instances.Executor;
import codes.laivy.npc.mappings.instances.FieldExecutor;
import codes.laivy.npc.mappings.instances.MethodExecutor;
import codes.laivy.npc.mappings.instances.classes.ClassExecutor;
import io.netty.channel.Channel;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Set;

public class V1_19_R1 extends V1_18_R2 {

    @Override
    protected boolean onLoad(@NotNull Class<? extends Version> version, @NotNull String key, @NotNull Executor executor) {
        if (version == V1_18_R2.class) {
            return false;
        } else if (version == V1_14_R1.class) {
            if (key.equals("VillagerProfession:Name") ||
                    key.equals("VillagerProfession:PROFESSIONS:NONE") ||
                    key.equals("VillagerProfession:PROFESSIONS:ARMORER") ||
                    key.equals("VillagerProfession:PROFESSIONS:BUTCHER") ||
                    key.equals("VillagerProfession:PROFESSIONS:CARTOGRAPHER") ||
                    key.equals("VillagerProfession:PROFESSIONS:CLERIC") ||
                    key.equals("VillagerProfession:PROFESSIONS:FARMER") ||
                    key.equals("VillagerProfession:PROFESSIONS:FISHERMAN") ||
                    key.equals("VillagerProfession:PROFESSIONS:FLETCHER") ||
                    key.equals("VillagerProfession:PROFESSIONS:LEATHERWORKER") ||
                    key.equals("VillagerProfession:PROFESSIONS:LIBRARIAN") ||
                    key.equals("VillagerProfession:PROFESSIONS:MASON") ||
                    key.equals("VillagerProfession:PROFESSIONS:NITWIT") ||
                    key.equals("VillagerProfession:PROFESSIONS:SHEPHERD") ||
                    key.equals("VillagerProfession:PROFESSIONS:TOOLSMITH") ||
                    key.equals("VillagerProfession:PROFESSIONS:WEAPONSMITH")
            ) {
                return false;
            }
        }

        return super.onLoad(version, key, executor);
    }

    @Override
    public void loadClasses() {
        load(V1_19_R1.class, "WatchableObject", new ClassExecutor.BrokenClassExecutor());
        load(V1_19_R1.class, "EnumSkeletonType", new ClassExecutor.BrokenClassExecutor());
        load(V1_19_R1.class, "EnumHorseType", new ClassExecutor.BrokenClassExecutor());
        load(V1_19_R1.class, "EnumZombieType", new ClassExecutor.BrokenClassExecutor());

        load(V1_19_R1.class, "NBTBase", new NBTBase.NBTBaseClass("net.minecraft.nbt.NBTBase"));

        load(V1_19_R1.class, "NBTBase:NBTTagByte", new NBTTagByte.NBTTagByteClass("net.minecraft.nbt.NBTTagByte"));
        load(V1_19_R1.class, "NBTBase:NBTTagByteArray", new NBTTagByteArray.NBTTagByteArrayClass("net.minecraft.nbt.NBTTagByteArray"));
        load(V1_19_R1.class, "NBTBase:NBTTagCompound", new NBTTagCompound.NBTTagCompoundClass("net.minecraft.nbt.NBTTagCompound"));
        load(V1_19_R1.class, "NBTBase:NBTTagDouble", new NBTTagDouble.NBTTagDoubleClass("net.minecraft.nbt.NBTTagDouble"));
        load(V1_19_R1.class, "NBTBase:NBTTagFloat", new NBTTagFloat.NBTTagFloatClass("net.minecraft.nbt.NBTTagFloat"));
        load(V1_19_R1.class, "NBTBase:NBTTagInt", new NBTTagInt.NBTTagIntClass("net.minecraft.nbt.NBTTagInt"));
        load(V1_19_R1.class, "NBTBase:NBTTagIntArray", new NBTTagIntArray.NBTTagIntArrayClass("net.minecraft.nbt.NBTTagIntArray"));
        load(V1_19_R1.class, "NBTBase:NBTTagList", new NBTTagList.NBTTagListClass("net.minecraft.nbt.NBTTagList"));
        load(V1_19_R1.class, "NBTBase:NBTTagLong", new NBTTagLong.NBTTagLongClass("net.minecraft.nbt.NBTTagLong"));
        load(V1_19_R1.class, "NBTBase:NBTTagShort", new NBTTagShort.NBTTagShortClass("net.minecraft.nbt.NBTTagShort"));
        load(V1_19_R1.class, "NBTBase:NBTTagString", new NBTTagString.NBTTagStringClass("net.minecraft.nbt.NBTTagString"));
        //

        // Packets
        load(V1_19_R1.class, "Packet", new Packet.PacketClass("net.minecraft.network.protocol.Packet"));
        load(V1_19_R1.class, "PacketPlayOutSpawnEntity", new EntitySpawnPacket.EntitySpawnPacketClass("net.minecraft.network.protocol.game.PacketPlayOutSpawnEntity"));
        load(V1_19_R1.class, "PacketPlayOutEntityDestroy", new EntityDestroyPacket.EntityDestroyPacketClass("net.minecraft.network.protocol.game.PacketPlayOutEntityDestroy"));
        load(V1_19_R1.class, "PacketPlayOutAnimation", new EntityAnimationPacket.EntityAnimationPacketClass("net.minecraft.network.protocol.game.PacketPlayOutAnimation"));
        load(V1_19_R1.class, "PacketPlayOutEntityMetadata", new EntityMetadataPacket.EntityMetadataPacketClass("net.minecraft.network.protocol.game.PacketPlayOutEntityMetadata"));
        load(V1_19_R1.class, "PacketPlayOutNamedEntitySpawn", new EntityNamedSpawnPacket.EntityNamedSpawnPacketClass("net.minecraft.network.protocol.game.PacketPlayOutNamedEntitySpawn"));
        load(V1_19_R1.class, "PacketPlayOutPlayerInfo", new PlayerInfoPacket.PlayerInfoPacketClass("net.minecraft.network.protocol.game.PacketPlayOutPlayerInfo"));
        load(V1_19_R1.class, "PacketPlayOutPlayerInfo:EnumPlayerInfoAction", new EnumPlayerInfoActionEnum.EnumPlayerInfoActionClass("net.minecraft.network.protocol.game.PacketPlayOutPlayerInfo$EnumPlayerInfoAction"));
        load(V1_19_R1.class, "PacketPlayOutScoreboardTeam", new ScoreboardTeamPacket.ScoreboardTeamPacketClass("net.minecraft.network.protocol.game.PacketPlayOutScoreboardTeam"));
        load(V1_19_R1.class, "PacketPlayOutEntityEquipment", new EntityEquipmentPacket.EntityEquipmentPacketClass("net.minecraft.network.protocol.game.PacketPlayOutEntityEquipment"));
        load(V1_19_R1.class, "PacketPlayOutEntityTeleport", new EntityTeleportPacket.EntityTeleportPacketClass("net.minecraft.network.protocol.game.PacketPlayOutEntityTeleport"));
        load(V1_19_R1.class, "PacketPlayOutEntityHeadRotation", new EntityHeadRotationPacket.EntityHeadRotationPacketClass("net.minecraft.network.protocol.game.PacketPlayOutEntityHeadRotation"));
        load(V1_19_R1.class, "PacketPlayOutEntityLook", new EntityLookPacket.EntityLookPacketClass("net.minecraft.network.protocol.game.PacketPlayOutEntity$PacketPlayOutEntityLook"));

        load(V1_19_R1.class, "PacketPlayInUseEntity", new EntityUseInPacket.EntityUseInPacketClass("net.minecraft.network.protocol.game.PacketPlayInUseEntity"));
        load(V1_19_R1.class, "PacketPlayInUseEntity:EnumEntityUseAction", new EntityUseInPacket.ActionEnum.ActionClass("net.minecraft.network.protocol.game.PacketPlayInUseEntity$b"));
        load(V1_19_R1.class, "PacketPlayInUseEntity:EnumEntityUseAction:Real", new ClassExecutor("net.minecraft.network.protocol.game.PacketPlayInUseEntity$EnumEntityUseAction"));
        //

        // Server
        load(V1_19_R1.class, "MinecraftServer", new MinecraftServer.MinecraftServerClass("net.minecraft.server.MinecraftServer"));
        load(V1_19_R1.class, "WorldServer", new WorldServer.WorldServerClass("net.minecraft.server.level.WorldServer"));
        load(V1_19_R1.class, "CraftServer", new CraftServer.CraftServerClass("org.bukkit.craftbukkit.v1_19_R1.CraftServer"));
        //

        // Entity
        load(V1_19_R1.class, "EntityTypes", new EntityTypes.EntityTypesClass("net.minecraft.world.entity.EntityTypes"));

        load(V1_19_R1.class, "Entity", new Entity.EntityClass("net.minecraft.world.entity.Entity"));
        load(V1_19_R1.class, "EntityLiving", new EntityLiving.EntityLivingClass("net.minecraft.world.entity.EntityLiving"));
        load(V1_19_R1.class, "Entity:Human", new Entity.EntityClass("net.minecraft.world.entity.player.EntityHuman"));
        load(V1_19_R1.class, "CraftPlayer", new CraftPlayer.CraftPlayerClass("org.bukkit.craftbukkit.v1_19_R1.entity.CraftPlayer"));
        load(V1_19_R1.class, "EntityPlayer", new EntityPlayer.EntityPlayerClass("net.minecraft.server.level.EntityPlayer"));

        load(V1_19_R1.class, "Entity:ArmorStand", new ArmorStand.ArmorStandClass("net.minecraft.world.entity.decoration.EntityArmorStand"));
        load(V1_19_R1.class, "Entity:Pig", new Pig.PigClass("net.minecraft.world.entity.animal.EntityPig"));
        load(V1_19_R1.class, "Entity:Cow", new Cow.CowClass("net.minecraft.world.entity.animal.EntityCow"));
        load(V1_19_R1.class, "Entity:Ocelot", new Ocelot.OcelotClass("net.minecraft.world.entity.animal.EntityOcelot"));
        load(V1_19_R1.class, "Entity:Bat", new Bat.BatClass("net.minecraft.world.entity.ambient.EntityBat"));
        load(V1_19_R1.class, "Entity:Egg", new Egg.EggClass("net.minecraft.world.entity.projectile.EntityEgg"));
        load(V1_19_R1.class, "Entity:Chicken", new Chicken.ChickenClass("net.minecraft.world.entity.animal.EntityChicken"));
        load(V1_19_R1.class, "Entity:Horse", new AbstractHorse.AbstractHorseClass("net.minecraft.world.entity.animal.horse.EntityHorse"));
        load(V1_19_R1.class, "Entity:IronGolem", new IronGolem.IronGolemClass("net.minecraft.world.entity.animal.EntityIronGolem"));
        load(V1_19_R1.class, "Entity:Rabbit", new Rabbit.RabbitClass("net.minecraft.world.entity.animal.EntityRabbit"));
        load(V1_19_R1.class, "Entity:Sheep", new Sheep.SheepClass("net.minecraft.world.entity.animal.EntitySheep"));
        load(V1_19_R1.class, "Entity:Snowman", new Snowman.SnowmanClass("net.minecraft.world.entity.animal.EntitySnowman"));
        load(V1_19_R1.class, "Entity:Squid", new Squid.SquidClass("net.minecraft.world.entity.animal.EntitySquid"));
        load(V1_19_R1.class, "Entity:Wolf", new Wolf.WolfClass("net.minecraft.world.entity.animal.EntityWolf"));
        load(V1_19_R1.class, "Entity:ItemFrame", new ItemFrame.ItemFrameClass("net.minecraft.world.entity.decoration.EntityItemFrame"));
        load(V1_19_R1.class, "Entity:LeashKnot", new LeashKnot.LeashKnotClass("net.minecraft.world.entity.decoration.EntityLeash"));
        load(V1_19_R1.class, "Entity:FallingBlock", new FallingBlock.FallingBlockClass("net.minecraft.world.entity.item.EntityFallingBlock"));
        load(V1_19_R1.class, "Entity:Item", new Item.ItemClass("net.minecraft.world.entity.item.EntityItem"));
        load(V1_19_R1.class, "Entity:EnderDragon", new EnderDragon.EnderDragonClass("net.minecraft.world.entity.boss.enderdragon.EntityEnderDragon"));
        load(V1_19_R1.class, "Entity:EnderSignal", new EnderSignal.EnderSignalClass("net.minecraft.world.entity.projectile.EntityEnderSignal"));
        load(V1_19_R1.class, "Entity:Wither", new Wither.WitherClass("net.minecraft.world.entity.boss.wither.EntityWither"));
        load(V1_19_R1.class, "Entity:WitherSkull", new WitherSkull.WitherSkullClass("net.minecraft.world.entity.projectile.EntityWitherSkull"));
        load(V1_19_R1.class, "Entity:Blaze", new Blaze.BlazeClass("net.minecraft.world.entity.monster.EntityBlaze"));
        load(V1_19_R1.class, "Entity:Creeper", new Creeper.CreeperClass("net.minecraft.world.entity.monster.EntityCreeper"));
        load(V1_19_R1.class, "Entity:Enderman", new Enderman.EndermanClass("net.minecraft.world.entity.monster.EntityEnderman"));
        load(V1_19_R1.class, "Entity:Ghast", new Ghast.GhastClass("net.minecraft.world.entity.monster.EntityGhast"));
        load(V1_19_R1.class, "Entity:Guardian", new Guardian.GuardianClass("net.minecraft.world.entity.monster.EntityGuardian"));
        load(V1_19_R1.class, "Entity:Silverfish", new Silverfish.SilverfishClass("net.minecraft.world.entity.monster.EntitySilverfish"));
        load(V1_19_R1.class, "Entity:Skeleton", new Skeleton.SkeletonClass("net.minecraft.world.entity.monster.EntitySkeleton"));
        load(V1_19_R1.class, "Entity:Slime", new Slime.SlimeClass("net.minecraft.world.entity.monster.EntitySlime"));
        load(V1_19_R1.class, "Entity:Spider", new Spider.SpiderClass("net.minecraft.world.entity.monster.EntitySpider"));
        load(V1_19_R1.class, "Entity:Witch", new Witch.WitchClass("net.minecraft.world.entity.monster.EntityWitch"));
        load(V1_19_R1.class, "Entity:Zombie", new Zombie.ZombieClass("net.minecraft.world.entity.monster.EntityZombie"));
        load(V1_19_R1.class, "Entity:Villager", new Villager.VillagerClass("net.minecraft.world.entity.npc.EntityVillager"));
        load(V1_19_R1.class, "Entity:Shulker", new Shulker.ShulkerClass("net.minecraft.world.entity.monster.EntityShulker"));
        load(V1_19_R1.class, "Entity:PolarBear", new PolarBear.PolarBearClass("net.minecraft.world.entity.animal.EntityPolarBear"));
        load(V1_19_R1.class, "Entity:Boat", new Boat.BoatClass("net.minecraft.world.entity.vehicle.EntityBoat"));
        load(V1_19_R1.class, "Entity:CaveSpider", new CaveSpider.CaveSpiderClass("net.minecraft.world.entity.monster.EntityCaveSpider"));

        load(V1_19_R1.class, "Entity:Ageable", new AgeableEntityLiving.AgeableEntityLivingClass("net.minecraft.world.entity.EntityAgeable"));
        load(V1_19_R1.class, "Entity:Tameable", new TameableEntityLiving.TameableEntityLivingClass("net.minecraft.world.entity.EntityTameableAnimal"));
        // EntityPlayer
        load(V1_19_R1.class, "GameProfile", new GameProfile.GameProfileClass("com.mojang.authlib.GameProfile"));
        load(V1_19_R1.class, "PropertyMap", new PropertyMap.PropertyMapClass("com.mojang.authlib.properties.PropertyMap"));
        load(V1_19_R1.class, "Property", new Property.PropertyClass("com.mojang.authlib.properties.Property"));
        //

        // Managers
        load(V1_19_R1.class, "PlayerInteractManager", new PlayerInteractManager.PlayerInteractManagerClass("net.minecraft.server.level.PlayerInteractManager"));
        //

        // DataWatcher
        load(V1_19_R1.class, "DataWatcher", new DataWatcher.DataWatcherClass("net.minecraft.network.syncher.DataWatcher"));
        load(V1_19_R1.class, "DataWatcherObject", new DataWatcherObject.DataWatcherObjectClass("net.minecraft.network.syncher.DataWatcherObject"));
        load(V1_19_R1.class, "DataWatcher:Item", new DataWatcherItem.DataWatcherItemClass("net.minecraft.network.syncher.DataWatcher$Item"));
        //

        // Scoreboard
        load(V1_19_R1.class, "CraftScoreboard", new CraftScoreboard.CraftScoreboardClass("org.bukkit.craftbukkit.v1_19_R1.scoreboard.CraftScoreboard"));
        load(V1_19_R1.class, "Scoreboard", new Scoreboard.ScoreboardClass("net.minecraft.world.scores.Scoreboard"));

        load(V1_19_R1.class, "ScoreboardTeam", new ScoreboardTeam.ScoreboardTeamClass("net.minecraft.world.scores.ScoreboardTeam"));
        load(V1_19_R1.class, "ScoreboardTeam:EnumTeamPush", new EnumTeamPushEnum.EnumTeamPushClass("net.minecraft.world.scores.ScoreboardTeamBase$EnumTeamPush"));

        load(V1_19_R1.class, "ScoreboardTeamBase:EnumNameTagVisibility", new EnumNameTagVisibilityEnum.EnumNameTagVisibilityClass("net.minecraft.world.scores.ScoreboardTeamBase$EnumNameTagVisibility"));
        //

        // Others
        load(V1_19_R1.class, "PlayerConnection", new PlayerConnection.PlayerConnectionClass("net.minecraft.server.network.PlayerConnection"));
        load(V1_19_R1.class, "NetworkManager", new NetworkManager.NetworkManagerClass("net.minecraft.network.NetworkManager"));

        load(V1_19_R1.class, "EnumChatFormat", new EnumChatFormatEnum.EnumChatFormatClass("net.minecraft.EnumChatFormat"));
        load(V1_19_R1.class, "EnumColor", new EnumColorEnum.EnumColorClass("net.minecraft.world.item.EnumColor"));
        load(V1_19_R1.class, "EnumItemSlot", new EnumItemSlotEnum.EnumItemSlotClass("net.minecraft.world.entity.EnumItemSlot"));
        load(V1_19_R1.class, "EnumDirection", new EnumDirectionEnum.EnumDirectionClass("net.minecraft.core.EnumDirection"));
        //

        // Chat
        load(V1_19_R1.class, "IChatBaseComponent", new IChatBaseComponent.IChatBaseComponentClass("net.minecraft.network.chat.IChatBaseComponent"));
        load(V1_19_R1.class, "ChatSerializer", new IChatBaseComponent.ChatSerializerClass("net.minecraft.network.chat.IChatBaseComponent$ChatSerializer"));
        //

        // Objects
        load(V1_19_R1.class, "CraftWorld", new CraftWorld.CraftWorldClass("org.bukkit.craftbukkit.v1_19_R1.CraftWorld"));
        load(V1_19_R1.class, "World", new World.WorldClass("net.minecraft.world.level.World"));
        load(V1_19_R1.class, "Vector3f", new Vector3f.Vector3fClass("net.minecraft.core.Vector3f"));
        load(V1_19_R1.class, "Vec3D", new Vec3D.Vec3DClass("net.minecraft.world.phys.Vec3D"));
        load(V1_19_R1.class, "BlockPosition", new BlockPosition.BlockPositionClass("net.minecraft.core.BlockPosition"));
        load(V1_19_R1.class, "CraftBlock", new CraftBlock.CraftBlockClass("org.bukkit.craftbukkit.v1_19_R1.block.CraftBlock"));
        load(V1_19_R1.class, "IBlockData", new IBlockData.IBlockDataClass("net.minecraft.world.level.block.state.IBlockData"));
        load(V1_19_R1.class, "Block", new Block.BlockClass("net.minecraft.world.level.block.Block"));
        load(V1_19_R1.class, "CraftMagicNumbers", new ClassExecutor("org.bukkit.craftbukkit.v1_19_R1.util.CraftMagicNumbers"));
        load(V1_19_R1.class, "Pair", new Pair.PairClass("com.mojang.datafixers.util.Pair"));

        load(V1_19_R1.class, "InventorySubcontainer", new InventorySubcontainer.InventorySubcontainerClass("net.minecraft.world.InventorySubcontainer"));
        //

        // Items
        load(V1_19_R1.class, "ItemStack", new ItemStack.ItemStackClass("net.minecraft.world.item.ItemStack"));
        load(V1_19_R1.class, "CraftItemStack", new CraftItemStack.CraftItemStackClass("org.bukkit.craftbukkit.v1_19_R1.inventory.CraftItemStack"));
        //

        // Entity horse
        load(V1_19_R1.class, "Entity:Horse:Abstract", new AbstractHorse.AbstractHorseClass("net.minecraft.world.entity.animal.horse.EntityHorseAbstract"));
        load(V1_19_R1.class, "Entity:Horse:Abstract:Chested", new AbstractChestedHorse.AbstractChestedHorseClass("net.minecraft.world.entity.animal.horse.EntityHorseChestedAbstract"));
        load(V1_19_R1.class, "Entity:Horse:Donkey", new HorseDonkey.HorseDonkeyClass("net.minecraft.world.entity.animal.horse.EntityHorseDonkey"));
        load(V1_19_R1.class, "Entity:Horse:Mule", new HorseMule.HorseMuleClass("net.minecraft.world.entity.animal.horse.EntityHorseMule"));
        load(V1_19_R1.class, "Entity:Horse:Skeleton", new HorseSkeleton.HorseSkeletonClass("net.minecraft.world.entity.animal.horse.EntityHorseSkeleton"));
        load(V1_19_R1.class, "Entity:Horse:Zombie", new HorseZombie.HorseZombieClass("net.minecraft.world.entity.animal.horse.EntityHorseZombie"));
        // Entity skeleton
        load(V1_19_R1.class, "Entity:Skeleton:Wither", new SkeletonWither.SkeletonWitherClass("net.minecraft.world.entity.monster.EntitySkeletonWither"));
        load(V1_19_R1.class, "Entity:Skeleton:Stray", new SkeletonStray.SkeletonStrayClass("net.minecraft.world.entity.monster.EntitySkeletonStray"));
        // Entity zombie
        load(V1_19_R1.class, "Entity:Zombie:Villager", new ZombieVillager.ZombieVillagerClass("net.minecraft.world.entity.monster.EntityZombieVillager"));
        load(V1_19_R1.class, "Entity:Zombie:Husk", new ZombieHusk.ZombieHuskClass("net.minecraft.world.entity.monster.EntityZombieHusk"));
        load(V1_19_R1.class, "Entity:Zombie:Drowned", new ZombieDrowned.ZombieDrownedClass("net.minecraft.world.entity.monster.EntityDrowned"));
        // Entity vindicator
        load(V1_19_R1.class, "Entity:Vindicator", new Vindicator.VindicatorClass("net.minecraft.world.entity.monster.EntityVindicator"));
        // Entity evoker
        load(V1_19_R1.class, "Entity:Evoker", new Evoker.EvokerClass("net.minecraft.world.entity.monster.EntityEvoker"));
        // Entity vex
        load(V1_19_R1.class, "Entity:Vex", new Vex.VexClass("net.minecraft.world.entity.monster.EntityVex"));
        // Entity llama
        load(V1_19_R1.class, "Entity:Llama", new Llama.LlamaClass("net.minecraft.world.entity.animal.horse.EntityLlama"));
        // Entity illager illusioner
        load(V1_19_R1.class, "Entity:Illusioner", new Illusioner.IllusionerClass("net.minecraft.world.entity.monster.EntityIllagerIllusioner"));
        // Entity illager wizard
        load(V1_19_R1.class, "Entity:IllagerWizard", new IllagerWizard.IllagerWizardClass("net.minecraft.world.entity.monster.EntityIllagerWizard"));
        load(V1_19_R1.class, "Entity:IllagerWizard:Spell", new EnumSpellEnum.EnumSpellClass("net.minecraft.world.entity.monster.EntityIllagerWizard$Spell"));
        // Entity parrot
        load(V1_19_R1.class, "Entity:Parrot", new Parrot.ParrotClass("net.minecraft.world.entity.animal.EntityParrot"));
        // Entity dolphin
        load(V1_19_R1.class, "Entity:Dolphin", new Dolphin.DolphinClass("net.minecraft.world.entity.animal.EntityDolphin"));
        // Entity fish
        load(V1_19_R1.class, "Entity:Fish", new Fish.FishClass("net.minecraft.world.entity.animal.EntityFish"));
        load(V1_19_R1.class, "Entity:Cod", new Cod.CodClass("net.minecraft.world.entity.animal.EntityCod"));
        load(V1_19_R1.class, "Entity:Salmon", new Salmon.SalmonClass("net.minecraft.world.entity.animal.EntitySalmon"));
        load(V1_19_R1.class, "Entity:PufferFish", new Pufferfish.PufferfishClass("net.minecraft.world.entity.animal.EntityPufferFish"));
        load(V1_19_R1.class, "Entity:TropicalFish", new Tropicalfish.TropicalfishClass("net.minecraft.world.entity.animal.EntityTropicalFish"));
        // Entity phantom
        load(V1_19_R1.class, "Entity:Phantom", new Phantom.PhantomClass("net.minecraft.world.entity.monster.EntityPhantom"));
        // Entity turtle
        load(V1_19_R1.class, "Entity:Turtle", new Turtle.TurtleClass("net.minecraft.world.entity.animal.EntityTurtle"));
        // Entity cat
        load(V1_19_R1.class, "Entity:Cat", new Cat.CatClass("net.minecraft.world.entity.animal.EntityCat"));
        // Entity villager
        load(V1_19_R1.class, "VillagerData", new VillagerData.VillagerDataClass("net.minecraft.world.entity.npc.VillagerData"));
        load(V1_19_R1.class, "VillagerProfession", new VillagerProfessionExec.VillagerProfessionExecClass("net.minecraft.world.entity.npc.VillagerProfession"));
        load(V1_19_R1.class, "VillagerType", new VillagerType.VillagerTypeClass("net.minecraft.world.entity.npc.VillagerType"));
        // Entity player
        load(V1_19_R1.class, "ProfilePublicKey", new ProfilePublicKey.ProfilePublicKeyClass("net.minecraft.world.entity.player.ProfilePublicKey"));
        // Entity cat
        load(V1_19_R1.class, "Cat:Variant", new ClassExecutor("net.minecraft.world.entity.animal.CatVariant"));
    }

    @Override
    public void loadMethods() {
        super.loadMethods();

        load(V1_19_R1.class, "NBTTagCompound:set", new MethodExecutor(getClassExec("NBTBase:NBTTagCompound"), getClassExec("NBTBase"), "a", "Sets a value inside a NBTTagCompound", ClassExecutor.STRING, getClassExec("NBTBase")));
        load(V1_19_R1.class, "NBTTagCompound:get", new MethodExecutor(getClassExec("NBTBase:NBTTagCompound"), getClassExec("NBTBase"), "c", "Gets a value inside a NBTTagCompound", ClassExecutor.STRING));
        load(V1_19_R1.class, "NBTTagCompound:remove", new MethodExecutor(getClassExec("NBTBase:NBTTagCompound"), ClassExecutor.VOID, "r", "Removes a value from a NBTTagCompound", ClassExecutor.STRING));
        load(V1_19_R1.class, "NBTTagCompound:contains", new MethodExecutor(getClassExec("NBTBase:NBTTagCompound"), ClassExecutor.BOOLEAN, "e", "Check if a NBTTagCompound contains a key", ClassExecutor.STRING));
        load(V1_19_R1.class, "NBTTagCompound:isEmpty", new MethodExecutor(getClassExec("NBTBase:NBTTagCompound"), ClassExecutor.BOOLEAN, "f", "Check if a NBTTagCompound is empty"));
        load(V1_19_R1.class, "NBTTagCompound:keySet", new MethodExecutor(getClassExec("NBTBase:NBTTagCompound"), new ClassExecutor(Set.class) {}, "d", "Gets a NBTTagCompound's keys"));
        load(V1_19_R1.class, "PlayerConnection:sendPacket", new MethodExecutor(getClassExec("PlayerConnection"), ClassExecutor.VOID, "a", "Sends a packet to a PlayerConnection", getClassExec("Packet")));

        // Entity
        load(V1_19_R1.class, "Entity:Entity:getId", new MethodExecutor(getClassExec("Entity"), ClassExecutor.INT, "ae", "Gets the entity id of a Entity"));
        load(V1_19_R1.class, "Entity:Entity:getDataWatcher", new MethodExecutor(getClassExec("Entity"), getClassExec("DataWatcher"), "ai", "Gets the DataWatcher of a Entity"));
        load(V1_19_R1.class, "Entity:Entity:setLocation", new MethodExecutor(getClassExec("Entity"), ClassExecutor.VOID, "a", "Sets the Entity's location", ClassExecutor.DOUBLE, ClassExecutor.DOUBLE, ClassExecutor.DOUBLE, ClassExecutor.FLOAT, ClassExecutor.FLOAT));
        load(V1_19_R1.class, "Entity:Human:getName", new MethodExecutor(getClassExec("Entity:Human"), getClassExec("IChatBaseComponent"), "X", "Gets the Entity's name"));
        load(V1_19_R1.class, "Entity:Entity:getCustomName", new MethodExecutor(getClassExec("Entity"), getClassExec("IChatBaseComponent"), "Z", "Gets the custom name of a Entity"));
        load(V1_19_R1.class, "Entity:Entity:setCustomName", new MethodExecutor(getClassExec("Entity"), ClassExecutor.VOID, "b", "Sets the custom name of a Entity", getClassExec("IChatBaseComponent")));
        load(V1_19_R1.class, "Entity:Entity:isCustomNameVisible", new MethodExecutor(getClassExec("Entity"), ClassExecutor.BOOLEAN, "cu", "Check if the Entity's custom name is visible"));
        load(V1_19_R1.class, "Entity:Entity:setCustomNameVisible", new MethodExecutor(getClassExec("Entity"), ClassExecutor.VOID, "n", "Sets the Entity's custom name visibility", ClassExecutor.BOOLEAN));
        load(V1_19_R1.class, "Entity:Entity:EntityData", new MethodExecutor(getClassExec("Entity"), ClassExecutor.BOOLEAN, "h", "Gets the entity zero data byte", ClassExecutor.INT));
        load(V1_19_R1.class, "Entity:Entity:setInvisible", new MethodExecutor(getClassExec("Entity"), ClassExecutor.VOID, "j", "Sets the Entity's visibility mode", ClassExecutor.BOOLEAN));

        try {
            load(V1_19_R1.class, "Entity:EntityPlayer:getProfile", new MethodExecutor(getClassExec("Entity:Human"), getClassExec("GameProfile"), "fz", "Gets the EntityPlayer's GameProfile"));
        } catch (RuntimeException e) {
            if (e.getCause() instanceof NoSuchMethodException) {
                load(V1_19_R1.class, "Entity:EntityPlayer:getProfile", new MethodExecutor(getClassExec("Entity:Human"), getClassExec("GameProfile"), "fy", "Gets the EntityPlayer's GameProfile"));
            } else {
                throw e;
            }
        }

        load(V1_19_R1.class, "Entity:isGlowing", new MethodExecutor(getClassExec("Entity"), ClassExecutor.BOOLEAN, "bW", "Gets the glowing state of a Entity"));
        load(V1_19_R1.class, "Entity:setGlowing", new MethodExecutor(getClassExec("Entity"), ClassExecutor.VOID, "i", "Sets the glowing state of a Entity", ClassExecutor.BOOLEAN));
        // ArmorStand
        load(V1_19_R1.class, "Entity:ArmorStand:setBasePlate", new MethodExecutor(getClassExec("Entity:ArmorStand"), ClassExecutor.VOID, "s", "Sets the base plate of a ArmorStand", ClassExecutor.BOOLEAN));
        load(V1_19_R1.class, "Entity:ArmorStand:hasBasePlate", new MethodExecutor(getClassExec("Entity:ArmorStand"), ClassExecutor.BOOLEAN, "r", "Checks if ArmorStand has base plate"));
        load(V1_19_R1.class, "Entity:ArmorStand:setArms", new MethodExecutor(getClassExec("Entity:ArmorStand"), ClassExecutor.VOID, "r", "Sets the arms of a ArmorStand", ClassExecutor.BOOLEAN));
        load(V1_19_R1.class, "Entity:ArmorStand:hasArms", new MethodExecutor(getClassExec("Entity:ArmorStand"), ClassExecutor.BOOLEAN, "q", "Checks if ArmorStand has arms"));
        load(V1_19_R1.class, "Entity:ArmorStand:setSmall", new MethodExecutor(getClassExec("Entity:ArmorStand"), ClassExecutor.VOID, "a", "Sets the small state of a ArmorStand", ClassExecutor.BOOLEAN));
        load(V1_19_R1.class, "Entity:ArmorStand:isSmall", new MethodExecutor(getClassExec("Entity:ArmorStand"), ClassExecutor.BOOLEAN, "n", "Checks if ArmorStand is small"));
        // Ageable
        load(V1_19_R1.class, "Entity:Ageable:isBaby", new MethodExecutor(getClassExec("Entity:Ageable"), ClassExecutor.BOOLEAN, "y_", "Checks if a entity is a baby"));
        load(V1_19_R1.class, "Entity:Ageable:setAge", new MethodExecutor(getClassExec("Entity:Ageable"), ClassExecutor.VOID, "a_", "Sets the baby state of a entity", ClassExecutor.INT));
        // Scoreboard
        load(V1_19_R1.class, "Entity:EntityPlayer:getScoreboard", new MethodExecutor(getClassExec("EntityPlayer"), getClassExec("Scoreboard"), "fQ", "Gets the Scoreboard from the EntityPlayer"));
        load(V1_19_R1.class, "Scoreboard:getTeam", new MethodExecutor(getClassExec("Scoreboard"), getClassExec("ScoreboardTeam"), "f", "Gets a ScoreboardTeam from a Scoreboard", ClassExecutor.STRING));
        load(V1_19_R1.class, "Scoreboard:addToTeam", new MethodExecutor(getClassExec("Scoreboard"), ClassExecutor.BOOLEAN, "a", "Adds a EntityPlayer to a ScoreboardTeam", ClassExecutor.STRING, getClassExec("ScoreboardTeam")));
        load(V1_19_R1.class, "Scoreboard:createTeam", new MethodExecutor(getClassExec("Scoreboard"), getClassExec("ScoreboardTeam"), "g", "Creates a new team on a Scoreboard", ClassExecutor.STRING));
        load(V1_19_R1.class, "ScoreboardTeam:getPlayerNameSet", new MethodExecutor(getClassExec("ScoreboardTeam"), ClassExecutor.COLLECTION, "g", "Gets the player's list of this ScoreboardTeam"));
        load(V1_19_R1.class, "ScoreboardTeam:setColor", new MethodExecutor(getClassExec("ScoreboardTeam"), ClassExecutor.VOID, "a", "Sets the color of a ScoreboardTeam", getClassExec("EnumChatFormat")));
        load(V1_19_R1.class, "ScoreboardTeam:setPrefix", new MethodExecutor(getClassExec("ScoreboardTeam"), ClassExecutor.VOID, "b", "Sets the prefix of a ScoreboardTeam", getClassExec("IChatBaseComponent")));
        load(V1_19_R1.class, "ScoreboardTeam:getName", new MethodExecutor(getClassExec("ScoreboardTeam"), ClassExecutor.STRING, "b", "Gets the name of a ScoreboardTeam"));
        load(V1_19_R1.class, "ScoreboardTeam:setNameTagVisibity", new MethodExecutor(getClassExec("ScoreboardTeam"), ClassExecutor.VOID, "a", "Sets the nametag visibility of a ScoreboardTeam", getClassExec("ScoreboardTeamBase:EnumNameTagVisibility")));
        load(V1_19_R1.class, "ScoreboardTeam:getCollision", new MethodExecutor(getClassExec("ScoreboardTeam"), getClassExec("ScoreboardTeam:EnumTeamPush"), "l", "Gets the collision state of the ScoreboardTeam"));
        load(V1_19_R1.class, "ScoreboardTeam:setCollision", new MethodExecutor(getClassExec("ScoreboardTeam"), ClassExecutor.VOID, "a", "Sets the collision state of the ScoreboardTeam", getClassExec("ScoreboardTeam:EnumTeamPush")));
        load(V1_19_R1.class, "ChatSerializer:convertToString", new MethodExecutor(getClassExec("IChatBaseComponent"), ClassExecutor.STRING, "getString", "Converts a IChatBaseComponent to a string"));

        load(V1_19_R1.class, "World:getEntityById", new MethodExecutor(getClassExec("World"), getClassExec("Entity"), "a", "Gets a entity by its ID", ClassExecutor.INT));
        load(V1_19_R1.class, "Block:getData", new MethodExecutor(getClassExec("Block"), getClassExec("IBlockData"), "m", "Gets the data of a block"));
        load(V1_19_R1.class, "IBlockData:getBlock", new MethodExecutor(getClassExec("IBlockData"), getClassExec("Block"), "b", "Gets the block of a data"));
        load(V1_19_R1.class, "CraftBlock:getNMSBlock", new MethodExecutor(getClassExec("CraftBlock"), getClassExec("IBlockData"), "getNMS", "Gets the NMS Block from a CraftBlock"));
        load(V1_19_R1.class, "EnumColor:getColorIndex", new MethodExecutor(getClassExec("EnumColor"), ClassExecutor.INT, "a", "Gets the color index of a EnumColor"));
        load(V1_19_R1.class, "EnumColor:fromColorIndex", new MethodExecutor(getClassExec("EnumColor"), getClassExec("EnumColor"), "a", "Gets the color enum from the index of a EnumColor", ClassExecutor.INT));
        // Location and Position
        load(V1_19_R1.class, "Vector3f:getX", new MethodExecutor(getClassExec("Vector3f"), ClassExecutor.FLOAT, "b", "Gets the X align of a Vector3f"));
        load(V1_19_R1.class, "Vector3f:getY", new MethodExecutor(getClassExec("Vector3f"), ClassExecutor.FLOAT, "c", "Gets the Y align of a Vector3f"));
        load(V1_19_R1.class, "Vector3f:getZ", new MethodExecutor(getClassExec("Vector3f"), ClassExecutor.FLOAT, "d", "Gets the Z align of a Vector3f"));
        load(V1_19_R1.class, "Vec3D:getX", new MethodExecutor(getClassExec("Vec3D"), ClassExecutor.DOUBLE, "a", "Gets the X align of a Vec3D"));
        load(V1_19_R1.class, "Vec3D:getY", new MethodExecutor(getClassExec("Vec3D"), ClassExecutor.DOUBLE, "b", "Gets the Y align of a Vec3D"));
        load(V1_19_R1.class, "Vec3D:getZ", new MethodExecutor(getClassExec("Vec3D"), ClassExecutor.DOUBLE, "c", "Gets the Z align of a Vec3D"));

        load(V1_19_R1.class, "BlockPosition:getX", new MethodExecutor(getClassExec("BlockPosition"), ClassExecutor.INT, "u", "Gets the X position of a BlockPosition"));
        load(V1_19_R1.class, "BlockPosition:getY", new MethodExecutor(getClassExec("BlockPosition"), ClassExecutor.INT, "v", "Gets the Y position of a BlockPosition"));
        load(V1_19_R1.class, "BlockPosition:getZ", new MethodExecutor(getClassExec("BlockPosition"), ClassExecutor.INT, "w", "Gets the Z position of a BlockPosition"));
        // DataWatcher
        load(V1_19_R1.class, "DataWatcher:get:DataWatcherObject", new MethodExecutor(getClassExec("DataWatcher"), ClassExecutor.OBJECT, "a", "Gets a datawatcher value by it object", getClassExec("DataWatcherObject")));
        load(V1_19_R1.class, "DataWatcher:set:DataWatcherObject", new MethodExecutor(getClassExec("DataWatcher"), ClassExecutor.VOID, "b", "Sets a datawatcher value of a object", getClassExec("DataWatcherObject"), ClassExecutor.OBJECT));
        // Villager Data
        load(V1_19_R1.class, "VillagerData:getType", new MethodExecutor(getClassExec("VillagerData"), getClassExec("VillagerType"), "a", "Gets the type of a villager data"));
        load(V1_19_R1.class, "VillagerData:getProfession", new MethodExecutor(getClassExec("VillagerData"), getClassExec("VillagerProfession"), "b", "Gets the profession of a villager data"));
        load(V1_19_R1.class, "VillagerData:getLevel", new MethodExecutor(getClassExec("VillagerData"), ClassExecutor.INT, "c", "Gets the level of a villager data"));

        load(V1_19_R1.class, "InventorySubcontainer:getItem", new MethodExecutor(getClassExec("InventorySubcontainer"), getClassExec("ItemStack"), "a", "Gets a item from a InventorySubcontainer", ClassExecutor.INT));
        load(V1_19_R1.class, "InventorySubcontainer:setItem", new MethodExecutor(getClassExec("InventorySubcontainer"), ClassExecutor.VOID, "a", "Sets a item of slot at a InventorySubcontainer", ClassExecutor.INT, getClassExec("ItemStack")));
    }

    @Override
    public void loadFields() {
        super.loadFields();

        load(V1_19_R1.class, "VillagerProfession:Name", new FieldExecutor(getClassExec("VillagerProfession"), ClassExecutor.STRING, "q", "Gets the name of VillagerProfession"));

        load(V1_19_R1.class, "NetworkManager:channel", new FieldExecutor(getClassExec("NetworkManager"), new ClassExecutor(Channel.class), "m", "Gets the Channel of a NetworkManager"));
        load(V1_19_R1.class, "Entity:loc", new FieldExecutor(getClassExec("Entity"), getClassExec("Vec3D"), "aw", "Gets the Vec3D loc of an entity"));
        load(V1_19_R1.class, "Entity:world", new FieldExecutor(getClassExec("Entity"), getClassExec("World"), "s", "Gets the world of an Entity"));
        // ArmorStand
        load(V1_19_R1.class, "Entity:ArmorStand:headPose", new FieldExecutor(getClassExec("Entity:ArmorStand"), getClassExec("Vector3f"), "cg", "Gets the head pose of an ArmorStand"));
        load(V1_19_R1.class, "Entity:ArmorStand:bodyPose", new FieldExecutor(getClassExec("Entity:ArmorStand"), getClassExec("Vector3f"), "ch", "Gets the body pose of an ArmorStand"));
        load(V1_19_R1.class, "Entity:ArmorStand:leftArmPose", new FieldExecutor(getClassExec("Entity:ArmorStand"), getClassExec("Vector3f"), "ci", "Gets the left arm pose of an ArmorStand"));
        load(V1_19_R1.class, "Entity:ArmorStand:rightArmPose", new FieldExecutor(getClassExec("Entity:ArmorStand"), getClassExec("Vector3f"), "cj", "Gets the right arm pose of an ArmorStand"));
        load(V1_19_R1.class, "Entity:ArmorStand:leftLegPose", new FieldExecutor(getClassExec("Entity:ArmorStand"), getClassExec("Vector3f"), "ck", "Gets the left leg pose of an ArmorStand"));
        load(V1_19_R1.class, "Entity:ArmorStand:rightLegPose", new FieldExecutor(getClassExec("Entity:ArmorStand"), getClassExec("Vector3f"), "cl", "Gets the right leg pose of an ArmorStand"));
        // Metadata
        load(V1_19_R1.class, "Metadata:ItemFrame:Item", new FieldExecutor(getClassExec("Entity:ItemFrame"), getClassExec("DataWatcherObject"), "ao", "Gets the ItemFrame's item DataWatcher object"));
        load(V1_19_R1.class, "Metadata:ItemFrame:Rotation", new FieldExecutor(getClassExec("Entity:ItemFrame"), getClassExec("DataWatcherObject"), "ap", "Gets the ItemFrame's rotation DataWatcher object"));
        load(V1_19_R1.class, "Metadata:Sheep:Shear", new FieldExecutor(getClassExec("Entity:Sheep"), getClassExec("DataWatcherObject"), "bY", "Gets the Sheep's shear DataWatcher object"));
        load(V1_19_R1.class, "Metadata:Rabbit:Variant", new FieldExecutor(getClassExec("Entity:Rabbit"), getClassExec("DataWatcherObject"), "cm", "Gets the Rabbit's variant DataWatcher object"));
        load(V1_19_R1.class, "Metadata:Tameable:Values", new FieldExecutor(getClassExec("Entity:Tameable"), getClassExec("DataWatcherObject"), "bX", "Gets the tameable animal's variables DataWatcher object"));
        load(V1_19_R1.class, "Metadata:Item:Item", new FieldExecutor(getClassExec("Entity:Item"), getClassExec("DataWatcherObject"), "c", "Gets the EntityItem's item DataWatcher object"));
        load(V1_19_R1.class, "Metadata:WitherSkull:Charge", new FieldExecutor(getClassExec("Entity:WitherSkull"), getClassExec("DataWatcherObject"), "e", "Gets the Wither skull's charged DataWatcher object"));
        load(V1_19_R1.class, "Metadata:Enderman:screaming", new FieldExecutor(getClassExec("Entity:Enderman"), getClassExec("DataWatcherObject"), "bZ", "Gets the enderman's screaming datawatcher object"));
        load(V1_19_R1.class, "Metadata:Enderman:carried", new FieldExecutor(getClassExec("Entity:Enderman"), getClassExec("DataWatcherObject"), "bY", "Gets the enderman's carried datawatcher object"));
        load(V1_19_R1.class, "Metadata:Horse:Chested:Chest", new FieldExecutor(getClassExec("Entity:Horse:Abstract:Chested"), getClassExec("DataWatcherObject"), "cn", "Gets the chested horse's chest datawatcher object"));
        load(V1_19_R1.class, "Metadata:Slime:Size", new FieldExecutor(getClassExec("Entity:Slime"), getClassExec("DataWatcherObject"), "bX", "Gets the slime's size datawatcher object"));
        load(V1_19_R1.class, "Metadata:Bat:Asleep", new FieldExecutor(getClassExec("Entity:Bat"), getClassExec("DataWatcherObject"), "d", "Gets the bat's asleep datawatcher object"));
        load(V1_19_R1.class, "Metadata:Snowman:Pumpkin", new FieldExecutor(getClassExec("Entity:Snowman"), getClassExec("DataWatcherObject"), "b", "Gets the snowman's pumpkin datawatcher object"));
        load(V1_19_R1.class, "Metadata:IllagerWizard:Spell", new FieldExecutor(getClassExec("Entity:IllagerWizard"), getClassExec("DataWatcherObject"), "e", "Gets the illager wizard's spell datawatcher object"));
        load(V1_19_R1.class, "Metadata:Parrot:Variant", new FieldExecutor(getClassExec("Entity:Parrot"), getClassExec("DataWatcherObject"), "ce", "Gets the parrot's variant datawatcher object"));
        load(V1_19_R1.class, "Metadata:Horse:Variant", new FieldExecutor(getClassExec("Entity:Horse"), getClassExec("DataWatcherObject"), "cn", "Gets the horse variant DataWatcherObject"));
        load(V1_19_R1.class, "Metadata:Pig:Saddle", new FieldExecutor(getClassExec("Entity:Pig"), getClassExec("DataWatcherObject"), "bX", "Gets the pig saddle DataWatcherObject"));
        load(V1_19_R1.class, "Metadata:Turtle:Egg", new FieldExecutor(getClassExec("Entity:Turtle"), getClassExec("DataWatcherObject"), "cb", "Gets the turtle's egg DataWatcherObject", false, true));
        load(V1_19_R1.class, "Metadata:Llama:Variant", new FieldExecutor(getClassExec("Entity:Llama"), getClassExec("DataWatcherObject"), "cs", "Gets the llama's variant DataWatcherObject"));
        load(V1_19_R1.class, "Metadata:Llama:CarpetColor", new FieldExecutor(getClassExec("Entity:Llama"), getClassExec("DataWatcherObject"), "cr", "Gets the llama's carpet color DataWatcherObject"));
        load(V1_19_R1.class, "Metadata:PolarBear:Standing", new FieldExecutor(getClassExec("Entity:PolarBear"), getClassExec("DataWatcherObject"), "bX", "Gets the polar bear's standing DataWatcherObject"));
        load(V1_19_R1.class, "Metadata:Villager:Data", new FieldExecutor(getClassExec("Entity:Villager"), getClassExec("DataWatcherObject"), "ce", "Gets the villager's data DataWatcherObject"));
        load(V1_19_R1.class, "Metadata:Cat:Type", new FieldExecutor(getClassExec("Entity:Cat"), getClassExec("DataWatcherObject"), "ce", "Gets the cat's variant DataWatcherObject"));
        load(V1_19_R1.class, "Metadata:Wolf:Angry", new FieldExecutor(getClassExec("Entity:Wolf"), getClassExec("DataWatcherObject"), "cd", "Gets the wolf angry DataWatcherObject"));
        load(V1_19_R1.class, "Metadata:Wolf:CollarColor", new FieldExecutor(getClassExec("Entity:Wolf"), getClassExec("DataWatcherObject"), "cc", "Gets the wolf collar color DataWatcherObject"));
        load(V1_19_R1.class, "Metadata:TropicalFish:Variant", new FieldExecutor(getClassExec("Entity:TropicalFish"), getClassExec("DataWatcherObject"), "bX", "Gets the tropical fish's variant DataWatcherObject"));
        load(V1_19_R1.class, "Metadata:Dolphin:hasFish", new FieldExecutor(getClassExec("Entity:Dolphin"), getClassExec("DataWatcherObject"), "e", "Gets the dolphin's hasFish DataWatcherObject"));
        load(V1_19_R1.class, "Metadata:Phantom:Size", new FieldExecutor(getClassExec("Entity:Phantom"), getClassExec("DataWatcherObject"), "d", "Gets the phantom's size DataWatcherObject"));
        load(V1_19_R1.class, "Metadata:Zombie:Baby", new FieldExecutor(getClassExec("Entity:Zombie"), getClassExec("DataWatcherObject"), "d", "Gets the zombie baby DataWatcherObject"));
        load(V1_19_R1.class, "Metadata:ZombieVillager:Data", new FieldExecutor(getClassExec("Entity:Zombie:Villager"), getClassExec("DataWatcherObject"), "d", "Gets the zombie villager's data DataWatcherObject"));
        load(V1_19_R1.class, "Metadata:Guardian:Target", new FieldExecutor(getClassExec("Entity:Guardian"), getClassExec("DataWatcherObject"), "e", "Gets the Guardian target DataWatcherObject"));
        load(V1_19_R1.class, "Metadata:Creeper:Powered", new FieldExecutor(getClassExec("Entity:Creeper"), getClassExec("DataWatcherObject"), "c", "Gets the creeper powered DataWatcherObject"));
        load(V1_19_R1.class, "Metadata:PufferFish:PuffState", new FieldExecutor(getClassExec("Entity:PufferFish"), getClassExec("DataWatcherObject"), "e", "Gets the puffer fish's puff state DataWatcherObject"));
        load(V1_19_R1.class, "Metadata:Shulker:Color", new FieldExecutor(getClassExec("Entity:Shulker"), getClassExec("DataWatcherObject"), "c", "Gets the shulker's color DataWatcherObject"));

        load(V1_19_R1.class, "Entity:Horse:Abstract:horseInventory", new FieldExecutor(getClassExec("Entity:Horse:Abstract"), getClassExec("InventorySubcontainer"), "ci", "Gets the horse's inventoryChest"));

        load(V1_19_R1.class, "VillagerProfession:PROFESSIONS:NONE", new FieldExecutor(getClassExec("VillagerProfession"), getClassExec("VillagerProfession"), "b", "Gets the NONE villager profession"));
        load(V1_19_R1.class, "VillagerProfession:PROFESSIONS:ARMORER", new FieldExecutor(getClassExec("VillagerProfession"), getClassExec("VillagerProfession"), "c", "Gets the ARMORER villager profession"));
        load(V1_19_R1.class, "VillagerProfession:PROFESSIONS:BUTCHER", new FieldExecutor(getClassExec("VillagerProfession"), getClassExec("VillagerProfession"), "d", "Gets the BUTCHER villager profession"));
        load(V1_19_R1.class, "VillagerProfession:PROFESSIONS:CARTOGRAPHER", new FieldExecutor(getClassExec("VillagerProfession"), getClassExec("VillagerProfession"), "e", "Gets the CARTOGRAPHER villager profession"));
        load(V1_19_R1.class, "VillagerProfession:PROFESSIONS:CLERIC", new FieldExecutor(getClassExec("VillagerProfession"), getClassExec("VillagerProfession"), "f", "Gets the CLERIC villager profession"));
        load(V1_19_R1.class, "VillagerProfession:PROFESSIONS:FARMER", new FieldExecutor(getClassExec("VillagerProfession"), getClassExec("VillagerProfession"), "g", "Gets the FARMER villager profession"));
        load(V1_19_R1.class, "VillagerProfession:PROFESSIONS:FISHERMAN", new FieldExecutor(getClassExec("VillagerProfession"), getClassExec("VillagerProfession"), "h", "Gets the FISHERMAN villager profession"));
        load(V1_19_R1.class, "VillagerProfession:PROFESSIONS:FLETCHER", new FieldExecutor(getClassExec("VillagerProfession"), getClassExec("VillagerProfession"), "i", "Gets the FLETCHER villager profession"));
        load(V1_19_R1.class, "VillagerProfession:PROFESSIONS:LEATHERWORKER", new FieldExecutor(getClassExec("VillagerProfession"), getClassExec("VillagerProfession"), "j", "Gets the LEATHERWORKER villager profession"));
        load(V1_19_R1.class, "VillagerProfession:PROFESSIONS:LIBRARIAN", new FieldExecutor(getClassExec("VillagerProfession"), getClassExec("VillagerProfession"), "k", "Gets the LIBRARIAN villager profession"));
        load(V1_19_R1.class, "VillagerProfession:PROFESSIONS:MASON", new FieldExecutor(getClassExec("VillagerProfession"), getClassExec("VillagerProfession"), "l", "Gets the MASON villager profession"));
        load(V1_19_R1.class, "VillagerProfession:PROFESSIONS:NITWIT", new FieldExecutor(getClassExec("VillagerProfession"), getClassExec("VillagerProfession"), "m", "Gets the NITWIT villager profession"));
        load(V1_19_R1.class, "VillagerProfession:PROFESSIONS:SHEPHERD", new FieldExecutor(getClassExec("VillagerProfession"), getClassExec("VillagerProfession"), "n", "Gets the SHEPHERD villager profession"));
        load(V1_19_R1.class, "VillagerProfession:PROFESSIONS:TOOLSMITH", new FieldExecutor(getClassExec("VillagerProfession"), getClassExec("VillagerProfession"), "o", "Gets the TOOLSMITH villager profession"));
        load(V1_19_R1.class, "VillagerProfession:PROFESSIONS:WEAPONSMITH", new FieldExecutor(getClassExec("VillagerProfession"), getClassExec("VillagerProfession"), "p", "Gets the WEAPONSMITH villager profession"));

        load(V1_19_R1.class, "Cat:Variant:tabby", new FieldExecutor(getClassExec("Cat:Variant"), getClassExec("Cat:Variant"), getText("Cat:Variant:tabby"), "Gets the tabby cat variant"));
        load(V1_19_R1.class, "Cat:Variant:black", new FieldExecutor(getClassExec("Cat:Variant"), getClassExec("Cat:Variant"), getText("Cat:Variant:black"), "Gets the black cat variant"));
        load(V1_19_R1.class, "Cat:Variant:red", new FieldExecutor(getClassExec("Cat:Variant"), getClassExec("Cat:Variant"), getText("Cat:Variant:red"), "Gets the red cat variant"));
        load(V1_19_R1.class, "Cat:Variant:siamese", new FieldExecutor(getClassExec("Cat:Variant"), getClassExec("Cat:Variant"), getText("Cat:Variant:siamese"), "Gets the siamese cat variant"));
        load(V1_19_R1.class, "Cat:Variant:british_shorthair", new FieldExecutor(getClassExec("Cat:Variant"), getClassExec("Cat:Variant"), getText("Cat:Variant:british_shorthair"), "Gets the british_shorthair cat variant"));
        load(V1_19_R1.class, "Cat:Variant:calico", new FieldExecutor(getClassExec("Cat:Variant"), getClassExec("Cat:Variant"), getText("Cat:Variant:calico"), "Gets the calico cat variant"));
        load(V1_19_R1.class, "Cat:Variant:persian", new FieldExecutor(getClassExec("Cat:Variant"), getClassExec("Cat:Variant"), getText("Cat:Variant:persian"), "Gets the persian cat variant"));
        load(V1_19_R1.class, "Cat:Variant:ragdoll", new FieldExecutor(getClassExec("Cat:Variant"), getClassExec("Cat:Variant"), getText("Cat:Variant:ragdoll"), "Gets the ragdoll cat variant"));
        load(V1_19_R1.class, "Cat:Variant:white", new FieldExecutor(getClassExec("Cat:Variant"), getClassExec("Cat:Variant"), getText("Cat:Variant:white"), "Gets the white cat variant"));
        load(V1_19_R1.class, "Cat:Variant:jellie", new FieldExecutor(getClassExec("Cat:Variant"), getClassExec("Cat:Variant"), getText("Cat:Variant:jellie"), "Gets the jellie cat variant"));
        load(V1_19_R1.class, "Cat:Variant:all_black", new FieldExecutor(getClassExec("Cat:Variant"), getClassExec("Cat:Variant"), getText("Cat:Variant:all_black"), "Gets the all_black cat variant"));
    }

    @Override
    public void loadTexts() {
        super.loadTexts();

        super.getTexts().put("EntityTypes:ARMOR_STAND", "d");
        super.getTexts().put("EntityTypes:BAT", "g");
        super.getTexts().put("EntityTypes:EGG", "aQ");
        super.getTexts().put("EntityTypes:BLAZE", "i");
        super.getTexts().put("EntityTypes:BOAT", "j");
        super.getTexts().put("EntityTypes:CAT", "l");
        super.getTexts().put("EntityTypes:CAVE_SPIDER", "m");
        super.getTexts().put("EntityTypes:CHICKEN", "n");
        super.getTexts().put("EntityTypes:COD", "o");
        super.getTexts().put("EntityTypes:COW", "p");
        super.getTexts().put("EntityTypes:CREEPER", "q");
        super.getTexts().put("EntityTypes:DONKEY", "s");
        super.getTexts().put("EntityTypes:DOLPHIN", "r");
        super.getTexts().put("EntityTypes:DRAGON_FIREBALL", "t");
        super.getTexts().put("EntityTypes:DROWNED", "u");
        super.getTexts().put("EntityTypes:ELDER_GUARDIAN", "v");
        super.getTexts().put("EntityTypes:END_CRYSTAL", "w");
        super.getTexts().put("EntityTypes:ENDER_DRAGON", "x");
        super.getTexts().put("EntityTypes:ENDERMAN", "y");
        super.getTexts().put("EntityTypes:ENDERMITE", "z");
        super.getTexts().put("EntityTypes:EVOKER_FANGS", "B");
        super.getTexts().put("EntityTypes:EVOKER", "A");
        super.getTexts().put("EntityTypes:EYE_OF_ENDER", "D");
        super.getTexts().put("EntityTypes:FALLING_BLOCK", "E");
        super.getTexts().put("EntityTypes:FOX", "G");
        super.getTexts().put("EntityTypes:GHAST", "I");
        super.getTexts().put("EntityTypes:GIANT", "J");
        super.getTexts().put("EntityTypes:GUARDIAN", "N");
        super.getTexts().put("EntityTypes:HORSE", "P");
        super.getTexts().put("EntityTypes:HUSK", "Q");
        super.getTexts().put("EntityTypes:ILLUSIONER", "R");
        super.getTexts().put("EntityTypes:ITEM", "T");
        super.getTexts().put("EntityTypes:ITEM_FRAME", "U");
        super.getTexts().put("EntityTypes:FIREBALL", "V");
        super.getTexts().put("EntityTypes:LEASH_KNOT", "W");
        super.getTexts().put("EntityTypes:LLAMA", "Y");
        super.getTexts().put("EntityTypes:LLAMA_SPIT", "Z");
        super.getTexts().put("EntityTypes:MAGMA_CUBE", "aa");
        super.getTexts().put("EntityTypes:MINECART", "ac");
        super.getTexts().put("EntityTypes:CHEST_MINECART", "ad");
        super.getTexts().put("EntityTypes:COMMAND_BLOCK_MINECART", "ae");
        super.getTexts().put("EntityTypes:FURNACE_MINECART", "af");
        super.getTexts().put("EntityTypes:HOPPER_MINECART", "ag");
        super.getTexts().put("EntityTypes:SPAWNER_MINECART", "ah");
        super.getTexts().put("EntityTypes:TNT_MINECART", "ai");
        super.getTexts().put("EntityTypes:MULE", "aj");
        super.getTexts().put("EntityTypes:MOOSHROOM", "ak");
        super.getTexts().put("EntityTypes:OCELOT", "al");
        super.getTexts().put("EntityTypes:PAINTING", "am");
        super.getTexts().put("EntityTypes:PANDA", "an");
        super.getTexts().put("EntityTypes:PARROT", "ao");
        super.getTexts().put("EntityTypes:PIG", "aq");
        super.getTexts().put("EntityTypes:PUFFERFISH", "aw");
        super.getTexts().put("EntityTypes:ZOMBIE_PIGMAN", "bm");
        super.getTexts().put("EntityTypes:POLAR_BEAR", "au");
        super.getTexts().put("EntityTypes:TNT", "av");
        super.getTexts().put("EntityTypes:RABBIT", "ax");
        super.getTexts().put("EntityTypes:SALMON", "az");
        super.getTexts().put("EntityTypes:SHEEP", "aA");
        super.getTexts().put("EntityTypes:SHULKER", "aB");
        super.getTexts().put("EntityTypes:SHULKER_BULLET", "aC");
        super.getTexts().put("EntityTypes:SILVERFISH", "aD");
        super.getTexts().put("EntityTypes:SKELETON", "aE");
        super.getTexts().put("EntityTypes:SKELETON_HORSE", "aF");
        super.getTexts().put("EntityTypes:SLIME", "aG");
        super.getTexts().put("EntityTypes:SMALL_FIREBALL", "aH");
        super.getTexts().put("EntityTypes:SNOW_GOLEM", "aI");
        super.getTexts().put("EntityTypes:SNOWBALL", "aJ");
        super.getTexts().put("EntityTypes:SPIDER", "aL");
        super.getTexts().put("EntityTypes:SQUID", "aM");
        super.getTexts().put("EntityTypes:STRAY", "aN");
        super.getTexts().put("EntityTypes:TRADER_LLAMA", "aV");
        super.getTexts().put("EntityTypes:TROPICAL_FISH", "aW");
        super.getTexts().put("EntityTypes:TURTLE", "aX");
        super.getTexts().put("EntityTypes:ENDER_PEARL", "aR");
        super.getTexts().put("EntityTypes:VEX", "aY");
        super.getTexts().put("EntityTypes:VILLAGER", "aZ");
        super.getTexts().put("EntityTypes:IRON_GOLEM", "S");
        super.getTexts().put("EntityTypes:VINDICATOR", "ba");
        super.getTexts().put("EntityTypes:PILLAGER", "at");
        super.getTexts().put("EntityTypes:WANDERING_TRADER", "bb");
        super.getTexts().put("EntityTypes:WITCH", "bd");
        super.getTexts().put("EntityTypes:WITHER", "be");
        super.getTexts().put("EntityTypes:WITHER_SKELETON", "bf");
        super.getTexts().put("EntityTypes:WITHER_SKULL", "bg");
        super.getTexts().put("EntityTypes:WOLF", "bh");
        super.getTexts().put("EntityTypes:ZOMBIE", "bj");
        super.getTexts().put("EntityTypes:ZOMBIE_HORSE", "bk");
        super.getTexts().put("EntityTypes:ZOMBIE_VILLAGER", "bl");
        super.getTexts().put("EntityTypes:PHANTOM", "ap");
        super.getTexts().put("EntityTypes:RAVAGER", "ay");

        super.getTexts().put("Cat:Variant:tabby", "a");
        super.getTexts().put("Cat:Variant:black", "b");
        super.getTexts().put("Cat:Variant:red", "c");
        super.getTexts().put("Cat:Variant:siamese", "d");
        super.getTexts().put("Cat:Variant:british_shorthair", "e");
        super.getTexts().put("Cat:Variant:calico", "f");
        super.getTexts().put("Cat:Variant:persian", "g");
        super.getTexts().put("Cat:Variant:ragdoll", "h");
        super.getTexts().put("Cat:Variant:white", "i");
        super.getTexts().put("Cat:Variant:jellie", "j");
        super.getTexts().put("Cat:Variant:all_black", "k");
    }

    @Override
    public @NotNull Cat.Variant getEntityCatVariant(@NotNull Cat cat) {
        return Cat.Variant.getByEnum(Objects.requireNonNull(cat.getDataWatcher().get(Cat.VARIANT_METADATA())));
    }
    @Override
    public void setEntityCatVariant(@NotNull Cat cat, Cat.@NotNull Variant variant) {
        cat.getDataWatcher().set(Cat.VARIANT_METADATA().getId(), variant.getEnum());
    }

    @Override
    public @NotNull EntityPlayer createPlayer(@NotNull GameProfile profile, @NotNull org.bukkit.Location location) {
        if (location.getWorld() == null) {
            throw new NullPointerException("This location's world is null!");
        }

        EntityPlayer player = new EntityPlayer(getClassExec("EntityPlayer").getConstructor(
                getClassExec("MinecraftServer"),
                getClassExec("WorldServer"),
                getClassExec("GameProfile"),
                getClassExec("ProfilePublicKey")
        ).newInstance(
                CraftServer.getCraftServer(Bukkit.getServer()).getServer(),
                CraftWorld.getCraftWorld(location.getWorld()).getHandle(),
                profile,
                null
        ));
        player.setLocation(location);
        return player;
    }

    @Override
    public @NotNull EntityLivingSpawnPacket createSpawnLivingPacket(@NotNull EntityLiving entity) {
        Object packet = getClassExec("PacketPlayOutSpawnEntity").getConstructor(getClassExec("EntityLiving")).newInstance(entity);
        return new EntitySpawnPacket(packet);
    }

    @Override
    public @NotNull String getName() {
        return "v1_19_R1";
    }

}
