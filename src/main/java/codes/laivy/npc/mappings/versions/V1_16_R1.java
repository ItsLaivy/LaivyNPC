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
import codes.laivy.npc.mappings.defaults.classes.entity.vehicle.Boat;
import codes.laivy.npc.mappings.defaults.classes.enums.*;
import codes.laivy.npc.mappings.defaults.classes.gameprofile.GameProfile;
import codes.laivy.npc.mappings.defaults.classes.gameprofile.Property;
import codes.laivy.npc.mappings.defaults.classes.gameprofile.PropertyMap;
import codes.laivy.npc.mappings.defaults.classes.java.IntegerObjExec;
import codes.laivy.npc.mappings.defaults.classes.java.ObjectObjExec;
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
import codes.laivy.npc.mappings.instances.EnumExecutor;
import codes.laivy.npc.mappings.instances.Executor;
import codes.laivy.npc.mappings.instances.FieldExecutor;
import codes.laivy.npc.mappings.instances.MethodExecutor;
import codes.laivy.npc.mappings.instances.classes.ClassExecutor;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class V1_16_R1 extends V1_15_R1 {

    @Override
    protected boolean onLoad(@NotNull Class<? extends Version> version, @NotNull String key, @NotNull Executor executor) {
        if (version == V1_15_R1.class) {
            if (executor instanceof ClassExecutor && !(executor instanceof EnumExecutor)) {
                return false;
            } else if (executor instanceof FieldExecutor) {
                switch (key) {
                    case "Metadata:Turtle:Egg":
                        load(V1_16_R1.class, key, new FieldExecutor(getClassExec("Entity:Turtle"), getClassExec("DataWatcherObject"), "bx", "Gets the turtle's egg DataWatcherObject", false, true));
                        return false;   
                    case "Metadata:Zombie:Baby":
                        load(V1_16_R1.class, key, new FieldExecutor(getClassExec("Entity:Zombie"), getClassExec("DataWatcherObject"), "d", "Gets the zombie baby DataWatcherObject"));
                        return false;
                    case "Metadata:Llama:Variant":
                        load(V1_16_R1.class, key, new FieldExecutor(getClassExec("Entity:Llama"), getClassExec("DataWatcherObject"), "bG", "Gets the llama's variant DataWatcherObject"));
                        return false;
                    case "Metadata:Llama:CarpetColor":
                        load(V1_16_R1.class, key, new FieldExecutor(getClassExec("Entity:Llama"), getClassExec("DataWatcherObject"), "bF", "Gets the llama's carpet color DataWatcherObject"));
                        return false;
                    case "Metadata:Guardian:Target":
                        load(V1_16_R1.class, key, new FieldExecutor(getClassExec("Entity:Guardian"), getClassExec("DataWatcherObject"), "d", "Gets the Guardian target DataWatcherObject"));
                        return false;
                    case "Metadata:Enderman:screaming":
                        load(V1_16_R1.class, key, new FieldExecutor(getClassExec("Entity:Enderman"), getClassExec("DataWatcherObject"), "bv", "Gets the enderman's screaming datawatcher object"));
                        return false;
                    case "Metadata:PolarBear:Standing":
                        load(V1_16_R1.class, key, new FieldExecutor(getClassExec("Entity:PolarBear"), getClassExec("DataWatcherObject"), "bv", "Gets the polar bear's standing DataWatcherObject"));
                        return false;
                    case "Metadata:Villager:Data":
                        load(V1_16_R1.class, key, new FieldExecutor(getClassExec("Entity:Villager"), getClassExec("DataWatcherObject"), "by", "Gets the villager's data DataWatcherObject"));
                        return false;
                    case "Metadata:Cat:Type":
                        load(V1_16_R1.class, key, new FieldExecutor(getClassExec("Entity:Cat"), getClassExec("DataWatcherObject"), "bz", "Gets the cat's variant DataWatcherObject"));
                        return false;
                    case "Metadata:Pig:Saddle":
                        load(V1_16_R1.class, key, new FieldExecutor(getClassExec("Entity:Pig"), getClassExec("DataWatcherObject"), "bv", "Gets the pig saddle DataWatcherObject"));
                        return false;
                    case "Metadata:Wolf:Angry":
                        load(V1_16_R1.class, key, new FieldExecutor(getClassExec("Entity:Wolf"), getClassExec("DataWatcherObject"), "by", "Gets the wolf angry DataWatcherObject"));
                        return false;
                    case "Metadata:Wolf:CollarColor":
                        load(V1_16_R1.class, key, new FieldExecutor(getClassExec("Entity:Wolf"), getClassExec("DataWatcherObject"), "bz", "Gets the wolf collar color DataWatcherObject"));
                        return false;
                    case "Metadata:Horse:Variant":
                        load(V1_16_R1.class, key, new FieldExecutor(getClassExec("Entity:Horse"), getClassExec("DataWatcherObject"), "bE", "Gets the horse variant DataWatcherObject"));
                        return false;
                    default:
                        break;
                }
            }
        } else if (version == V1_14_R1.class) {
            if (executor instanceof MethodExecutor) {
                if (key.equals("Entity:isGlowing")) {
                    load(V1_16_R1.class, key, new MethodExecutor(getClassExec("Entity"), ClassExecutor.BOOLEAN, "bA", "Gets the glowing state of a Entity"));
                    return false;
                }
            }
        } else if (version == V1_13_R1.class) {
            if (executor instanceof MethodExecutor) {
                if (key.equals("Entity:setGlowing")) {
                    load(V1_16_R1.class, key, new MethodExecutor(getClassExec("Entity"), ClassExecutor.VOID, "i", "Sets the glowing state of a Entity", ClassExecutor.BOOLEAN));
                    return false;
                }
            }
        } else if (version == V1_8_R1.class) {
            if (executor instanceof FieldExecutor) {
                switch (key) {
                    case "Entity:locX":
                    case "Entity:locY":
                    case "Entity:locZ":
                        return false;
                    default:
                        break;
                }
            }
        }
        
        return super.onLoad(version, key, executor);
    }

    @Override
    public org.bukkit.@NotNull Location getEntityLocation(@NotNull Entity entity) {
        org.bukkit.World world = (org.bukkit.World) Objects.requireNonNull(new World(getFieldExec("Entity:world").invokeInstance(entity)).getCraftWorld().getValue());
        return new Vec3D(getFieldExec("Entity:loc").invokeInstance(entity)).toLocation(world);
    }

    @Override
    public @NotNull Set<EntityEquipmentPacket> createEquipmentPacket(@NotNull Entity entity, @NotNull Map<EnumItemSlotEnum.@NotNull EnumItemSlot, org.bukkit.inventory.@NotNull ItemStack> items) {
        List<Object> list = new LinkedList<>();

        for (Map.Entry<EnumItemSlotEnum.@NotNull EnumItemSlot, org.bukkit.inventory.@NotNull ItemStack> entry : items.entrySet()) {
            Pair pair = new Pair(getClassExec("Pair").getConstructor(ClassExecutor.OBJECT, ClassExecutor.OBJECT).newInstance(entry.getKey().getEnum(), ItemStack.getNMSItemStack(entry.getValue())));
            list.add(pair.getValue());
        }

        Object packet = getClassExec("PacketPlayOutEntityEquipment").getConstructor(ClassExecutor.INT, new ClassExecutor(List.class)).newInstance(new IntegerObjExec(entity.getId()), new ObjectObjExec(list));

        return new LinkedHashSet<EntityEquipmentPacket>() {{
            add(new EntityEquipmentPacket(packet));
        }};
    }

    @Override
    public void loadClasses() {
        load(V1_16_R1.class, "WatchableObject", new ClassExecutor.BrokenClassExecutor());
        load(V1_16_R1.class, "EnumSkeletonType", new ClassExecutor.BrokenClassExecutor());
        load(V1_16_R1.class, "EnumHorseType", new ClassExecutor.BrokenClassExecutor());
        load(V1_16_R1.class, "EnumZombieType", new ClassExecutor.BrokenClassExecutor());

        load(V1_16_R1.class, "NBTBase", new NBTBase.NBTBaseClass("net.minecraft.server.v1_16_R1.NBTBase"));

        load(V1_16_R1.class, "NBTBase:NBTTagByte", new NBTTagByte.NBTTagByteClass("net.minecraft.server.v1_16_R1.NBTTagByte"));
        load(V1_16_R1.class, "NBTBase:NBTTagByteArray", new NBTTagByteArray.NBTTagByteArrayClass("net.minecraft.server.v1_16_R1.NBTTagByteArray"));
        load(V1_16_R1.class, "NBTBase:NBTTagCompound", new NBTTagCompound.NBTTagCompoundClass("net.minecraft.server.v1_16_R1.NBTTagCompound"));
        load(V1_16_R1.class, "NBTBase:NBTTagDouble", new NBTTagDouble.NBTTagDoubleClass("net.minecraft.server.v1_16_R1.NBTTagDouble"));
        load(V1_16_R1.class, "NBTBase:NBTTagFloat", new NBTTagFloat.NBTTagFloatClass("net.minecraft.server.v1_16_R1.NBTTagFloat"));
        load(V1_16_R1.class, "NBTBase:NBTTagInt", new NBTTagInt.NBTTagIntClass("net.minecraft.server.v1_16_R1.NBTTagInt"));
        load(V1_16_R1.class, "NBTBase:NBTTagIntArray", new NBTTagIntArray.NBTTagIntArrayClass("net.minecraft.server.v1_16_R1.NBTTagIntArray"));
        load(V1_16_R1.class, "NBTBase:NBTTagList", new NBTTagList.NBTTagListClass("net.minecraft.server.v1_16_R1.NBTTagList"));
        load(V1_16_R1.class, "NBTBase:NBTTagLong", new NBTTagLong.NBTTagLongClass("net.minecraft.server.v1_16_R1.NBTTagLong"));
        load(V1_16_R1.class, "NBTBase:NBTTagShort", new NBTTagShort.NBTTagShortClass("net.minecraft.server.v1_16_R1.NBTTagShort"));
        load(V1_16_R1.class, "NBTBase:NBTTagString", new NBTTagString.NBTTagStringClass("net.minecraft.server.v1_16_R1.NBTTagString"));
        //

        // Packets
        load(V1_16_R1.class, "Packet", new Packet.PacketClass("net.minecraft.server.v1_16_R1.Packet"));
        load(V1_16_R1.class, "PacketPlayOutSpawnEntity", new EntitySpawnPacket.EntitySpawnPacketClass("net.minecraft.server.v1_16_R1.PacketPlayOutSpawnEntity"));
        load(V1_16_R1.class, "PacketPlayOutEntityDestroy", new EntityDestroyPacket.EntityDestroyPacketClass("net.minecraft.server.v1_16_R1.PacketPlayOutEntityDestroy"));
        load(V1_16_R1.class, "PacketPlayOutAnimation", new EntityAnimationPacket.EntityAnimationPacketClass("net.minecraft.server.v1_16_R1.PacketPlayOutAnimation"));
        load(V1_16_R1.class, "PacketPlayOutSpawnEntityLiving", new EntityLivingSpawnPacket.EntityLivingSpawnPacketClass("net.minecraft.server.v1_16_R1.PacketPlayOutSpawnEntityLiving"));
        load(V1_16_R1.class, "PacketPlayOutEntityMetadata", new EntityMetadataPacket.EntityMetadataPacketClass("net.minecraft.server.v1_16_R1.PacketPlayOutEntityMetadata"));
        load(V1_16_R1.class, "PacketPlayOutNamedEntitySpawn", new EntityNamedSpawnPacket.EntityNamedSpawnPacketClass("net.minecraft.server.v1_16_R1.PacketPlayOutNamedEntitySpawn"));
        load(V1_16_R1.class, "PacketPlayOutPlayerInfo", new PlayerInfoPacket.PlayerInfoPacketClass("net.minecraft.server.v1_16_R1.PacketPlayOutPlayerInfo"));
        load(V1_16_R1.class, "PacketPlayOutPlayerInfo:EnumPlayerInfoAction", new EnumPlayerInfoActionEnum.EnumPlayerInfoActionClass("net.minecraft.server.v1_16_R1.PacketPlayOutPlayerInfo$EnumPlayerInfoAction"));
        load(V1_16_R1.class, "PacketPlayOutScoreboardTeam", new ScoreboardTeamPacket.ScoreboardTeamPacketClass("net.minecraft.server.v1_16_R1.PacketPlayOutScoreboardTeam"));
        load(V1_16_R1.class, "PacketPlayOutEntityEquipment", new EntityEquipmentPacket.EntityEquipmentPacketClass("net.minecraft.server.v1_16_R1.PacketPlayOutEntityEquipment"));
        load(V1_16_R1.class, "PacketPlayOutEntityTeleport", new EntityTeleportPacket.EntityTeleportPacketClass("net.minecraft.server.v1_16_R1.PacketPlayOutEntityTeleport"));
        load(V1_16_R1.class, "PacketPlayOutEntityHeadRotation", new EntityHeadRotationPacket.EntityHeadRotationPacketClass("net.minecraft.server.v1_16_R1.PacketPlayOutEntityHeadRotation"));
        load(V1_16_R1.class, "PacketPlayOutEntityLook", new EntityLookPacket.EntityLookPacketClass("net.minecraft.server.v1_16_R1.PacketPlayOutEntity$PacketPlayOutEntityLook"));

        load(V1_16_R1.class, "PacketPlayInUseEntity", new EntityUseInPacket.EntityUseInPacketClass("net.minecraft.server.v1_16_R1.PacketPlayInUseEntity"));
        load(V1_16_R1.class, "PacketPlayInUseEntity:EnumEntityUseAction", new EntityUseInPacket.ActionEnum.ActionClass("net.minecraft.server.v1_16_R1.PacketPlayInUseEntity$EnumEntityUseAction"));
        //

        // Server
        load(V1_16_R1.class, "MinecraftServer", new MinecraftServer.MinecraftServerClass("net.minecraft.server.v1_16_R1.MinecraftServer"));
        load(V1_16_R1.class, "WorldServer", new WorldServer.WorldServerClass("net.minecraft.server.v1_16_R1.WorldServer"));
        load(V1_16_R1.class, "CraftServer", new CraftServer.CraftServerClass("org.bukkit.craftbukkit.v1_16_R1.CraftServer"));
        //

        // Entity
        load(V1_16_R1.class, "EntityTypes", new EntityTypes.EntityTypesClass("net.minecraft.server.v1_16_R1.EntityTypes"));

        load(V1_16_R1.class, "Entity", new Entity.EntityClass("net.minecraft.server.v1_16_R1.Entity"));
        load(V1_16_R1.class, "EntityLiving", new EntityLiving.EntityLivingClass("net.minecraft.server.v1_16_R1.EntityLiving"));
        load(V1_16_R1.class, "Entity:Human", new Entity.EntityClass("net.minecraft.server.v1_16_R1.EntityHuman"));
        load(V1_16_R1.class, "CraftPlayer", new CraftPlayer.CraftPlayerClass("org.bukkit.craftbukkit.v1_16_R1.entity.CraftPlayer"));
        load(V1_16_R1.class, "EntityPlayer", new EntityPlayer.EntityPlayerClass("net.minecraft.server.v1_16_R1.EntityPlayer"));

        load(V1_16_R1.class, "Entity:ArmorStand", new ArmorStand.ArmorStandClass("net.minecraft.server.v1_16_R1.EntityArmorStand"));
        load(V1_16_R1.class, "Entity:Pig", new Pig.PigClass("net.minecraft.server.v1_16_R1.EntityPig"));
        load(V1_16_R1.class, "Entity:Cow", new Cow.CowClass("net.minecraft.server.v1_16_R1.EntityCow"));
        load(V1_16_R1.class, "Entity:Ocelot", new Ocelot.OcelotClass("net.minecraft.server.v1_16_R1.EntityOcelot"));
        load(V1_16_R1.class, "Entity:Bat", new Bat.BatClass("net.minecraft.server.v1_16_R1.EntityBat"));
        load(V1_16_R1.class, "Entity:Egg", new Egg.EggClass("net.minecraft.server.v1_16_R1.EntityEgg"));
        load(V1_16_R1.class, "Entity:Chicken", new Chicken.ChickenClass("net.minecraft.server.v1_16_R1.EntityChicken"));
        load(V1_16_R1.class, "Entity:Horse", new AbstractHorse.AbstractHorseClass("net.minecraft.server.v1_16_R1.EntityHorse"));
        load(V1_16_R1.class, "Entity:IronGolem", new IronGolem.IronGolemClass("net.minecraft.server.v1_16_R1.EntityIronGolem"));
        load(V1_16_R1.class, "Entity:Rabbit", new Rabbit.RabbitClass("net.minecraft.server.v1_16_R1.EntityRabbit"));
        load(V1_16_R1.class, "Entity:Sheep", new Sheep.SheepClass("net.minecraft.server.v1_16_R1.EntitySheep"));
        load(V1_16_R1.class, "Entity:Snowman", new Snowman.SnowmanClass("net.minecraft.server.v1_16_R1.EntitySnowman"));
        load(V1_16_R1.class, "Entity:Squid", new Squid.SquidClass("net.minecraft.server.v1_16_R1.EntitySquid"));
        load(V1_16_R1.class, "Entity:Wolf", new Wolf.WolfClass("net.minecraft.server.v1_16_R1.EntityWolf"));
        load(V1_16_R1.class, "Entity:ItemFrame", new ItemFrame.ItemFrameClass("net.minecraft.server.v1_16_R1.EntityItemFrame"));
        load(V1_16_R1.class, "Entity:LeashKnot", new LeashKnot.LeashKnotClass("net.minecraft.server.v1_16_R1.EntityLeash"));
        load(V1_16_R1.class, "Entity:FallingBlock", new FallingBlock.FallingBlockClass("net.minecraft.server.v1_16_R1.EntityFallingBlock"));
        load(V1_16_R1.class, "Entity:Item", new Item.ItemClass("net.minecraft.server.v1_16_R1.EntityItem"));
        load(V1_16_R1.class, "Entity:EnderDragon", new EnderDragon.EnderDragonClass("net.minecraft.server.v1_16_R1.EntityEnderDragon"));
        load(V1_16_R1.class, "Entity:EnderSignal", new EnderSignal.EnderSignalClass("net.minecraft.server.v1_16_R1.EntityEnderSignal"));
        load(V1_16_R1.class, "Entity:Wither", new Wither.WitherClass("net.minecraft.server.v1_16_R1.EntityWither"));
        load(V1_16_R1.class, "Entity:WitherSkull", new WitherSkull.WitherSkullClass("net.minecraft.server.v1_16_R1.EntityWitherSkull"));
        load(V1_16_R1.class, "Entity:Blaze", new Blaze.BlazeClass("net.minecraft.server.v1_16_R1.EntityBlaze"));
        load(V1_16_R1.class, "Entity:Creeper", new Creeper.CreeperClass("net.minecraft.server.v1_16_R1.EntityCreeper"));
        load(V1_16_R1.class, "Entity:Enderman", new Enderman.EndermanClass("net.minecraft.server.v1_16_R1.EntityEnderman"));
        load(V1_16_R1.class, "Entity:Ghast", new Ghast.GhastClass("net.minecraft.server.v1_16_R1.EntityGhast"));
        load(V1_16_R1.class, "Entity:Guardian", new Guardian.GuardianClass("net.minecraft.server.v1_16_R1.EntityGuardian"));
        load(V1_16_R1.class, "Entity:Silverfish", new Silverfish.SilverfishClass("net.minecraft.server.v1_16_R1.EntitySilverfish"));
        load(V1_16_R1.class, "Entity:Skeleton", new Skeleton.SkeletonClass("net.minecraft.server.v1_16_R1.EntitySkeleton"));
        load(V1_16_R1.class, "Entity:Slime", new Slime.SlimeClass("net.minecraft.server.v1_16_R1.EntitySlime"));
        load(V1_16_R1.class, "Entity:Spider", new Spider.SpiderClass("net.minecraft.server.v1_16_R1.EntitySpider"));
        load(V1_16_R1.class, "Entity:Witch", new Witch.WitchClass("net.minecraft.server.v1_16_R1.EntityWitch"));
        load(V1_16_R1.class, "Entity:Zombie", new Zombie.ZombieClass("net.minecraft.server.v1_16_R1.EntityZombie"));
        load(V1_16_R1.class, "Entity:Villager", new Villager.VillagerClass("net.minecraft.server.v1_16_R1.EntityVillager"));
        load(V1_16_R1.class, "Entity:Shulker", new Shulker.ShulkerClass("net.minecraft.server.v1_16_R1.EntityShulker"));
        load(V1_16_R1.class, "Entity:PolarBear", new PolarBear.PolarBearClass("net.minecraft.server.v1_16_R1.EntityPolarBear"));
        load(V1_16_R1.class, "Entity:Boat", new Boat.BoatClass("net.minecraft.server.v1_16_R1.EntityBoat"));
        load(V1_16_R1.class, "Entity:CaveSpider", new CaveSpider.CaveSpiderClass("net.minecraft.server.v1_16_R1.EntityCaveSpider"));

        load(V1_16_R1.class, "Entity:Ageable", new AgeableEntityLiving.AgeableEntityLivingClass("net.minecraft.server.v1_16_R1.EntityAgeable"));
        load(V1_16_R1.class, "Entity:Tameable", new TameableEntityLiving.TameableEntityLivingClass("net.minecraft.server.v1_16_R1.EntityTameableAnimal"));
        // EntityPlayer
        load(V1_16_R1.class, "GameProfile", new GameProfile.GameProfileClass("com.mojang.authlib.GameProfile"));
        load(V1_16_R1.class, "PropertyMap", new PropertyMap.PropertyMapClass("com.mojang.authlib.properties.PropertyMap"));
        load(V1_16_R1.class, "Property", new Property.PropertyClass("com.mojang.authlib.properties.Property"));
        //

        // Managers
        load(V1_16_R1.class, "PlayerInteractManager", new PlayerInteractManager.PlayerInteractManagerClass("net.minecraft.server.v1_16_R1.PlayerInteractManager"));
        //

        // DataWatcher
        load(V1_16_R1.class, "DataWatcher", new DataWatcher.DataWatcherClass("net.minecraft.server.v1_16_R1.DataWatcher"));
        load(V1_16_R1.class, "DataWatcherObject", new DataWatcherObject.DataWatcherObjectClass("net.minecraft.server.v1_16_R1.DataWatcherObject"));
        load(V1_16_R1.class, "DataWatcher:Item", new DataWatcherItem.DataWatcherItemClass("net.minecraft.server.v1_16_R1.DataWatcher$Item"));
        //

        // Scoreboard
        load(V1_16_R1.class, "CraftScoreboard", new CraftScoreboard.CraftScoreboardClass("org.bukkit.craftbukkit.v1_16_R1.scoreboard.CraftScoreboard"));
        load(V1_16_R1.class, "Scoreboard", new Scoreboard.ScoreboardClass("net.minecraft.server.v1_16_R1.Scoreboard"));

        load(V1_16_R1.class, "ScoreboardTeam", new ScoreboardTeam.ScoreboardTeamClass("net.minecraft.server.v1_16_R1.ScoreboardTeam"));
        load(V1_16_R1.class, "ScoreboardTeam:EnumTeamPush", new EnumTeamPushEnum.EnumTeamPushClass("net.minecraft.server.v1_16_R1.ScoreboardTeamBase$EnumTeamPush"));

        load(V1_16_R1.class, "ScoreboardTeamBase:EnumNameTagVisibility", new EnumNameTagVisibilityEnum.EnumNameTagVisibilityClass("net.minecraft.server.v1_16_R1.ScoreboardTeamBase$EnumNameTagVisibility"));
        //

        // Others
        load(V1_16_R1.class, "PlayerConnection", new PlayerConnection.PlayerConnectionClass("net.minecraft.server.v1_16_R1.PlayerConnection"));
        load(V1_16_R1.class, "NetworkManager", new NetworkManager.NetworkManagerClass("net.minecraft.server.v1_16_R1.NetworkManager"));

        load(V1_16_R1.class, "EnumChatFormat", new EnumChatFormatEnum.EnumChatFormatClass("net.minecraft.server.v1_16_R1.EnumChatFormat"));
        load(V1_16_R1.class, "EnumColor", new EnumColorEnum.EnumColorClass("net.minecraft.server.v1_16_R1.EnumColor"));
        load(V1_16_R1.class, "EnumItemSlot", new EnumItemSlotEnum.EnumItemSlotClass("net.minecraft.server.v1_16_R1.EnumItemSlot"));
        load(V1_16_R1.class, "EnumDirection", new EnumDirectionEnum.EnumDirectionClass("net.minecraft.server.v1_16_R1.EnumDirection"));
        //

        // Chat
        load(V1_16_R1.class, "IChatBaseComponent", new IChatBaseComponent.IChatBaseComponentClass("net.minecraft.server.v1_16_R1.IChatBaseComponent"));
        load(V1_16_R1.class, "ChatSerializer", new IChatBaseComponent.ChatSerializerClass("net.minecraft.server.v1_16_R1.IChatBaseComponent$ChatSerializer"));
        //

        // Objects
        load(V1_16_R1.class, "CraftWorld", new CraftWorld.CraftWorldClass("org.bukkit.craftbukkit.v1_16_R1.CraftWorld"));
        load(V1_16_R1.class, "World", new World.WorldClass("net.minecraft.server.v1_16_R1.World"));
        load(V1_16_R1.class, "Vector3f", new Vector3f.Vector3fClass("net.minecraft.server.v1_16_R1.Vector3f"));
        load(V1_16_R1.class, "Vec3D", new Vec3D.Vec3DClass("net.minecraft.server.v1_16_R1.Vec3D"));
        load(V1_16_R1.class, "BlockPosition", new BlockPosition.BlockPositionClass("net.minecraft.server.v1_16_R1.BlockPosition"));
        load(V1_16_R1.class, "CraftBlock", new CraftBlock.CraftBlockClass("org.bukkit.craftbukkit.v1_16_R1.block.CraftBlock"));
        load(V1_16_R1.class, "IBlockData", new IBlockData.IBlockDataClass("net.minecraft.server.v1_16_R1.IBlockData"));
        load(V1_16_R1.class, "Block", new Block.BlockClass("net.minecraft.server.v1_16_R1.Block"));
        load(V1_16_R1.class, "CraftMagicNumbers", new ClassExecutor("org.bukkit.craftbukkit.v1_16_R1.util.CraftMagicNumbers"));
        load(V1_16_R1.class, "Pair", new Pair.PairClass("com.mojang.datafixers.util.Pair"));

        load(V1_16_R1.class, "InventorySubcontainer", new InventorySubcontainer.InventorySubcontainerClass("net.minecraft.server.v1_16_R1.InventorySubcontainer"));
        //

        // Items
        load(V1_16_R1.class, "ItemStack", new ItemStack.ItemStackClass("net.minecraft.server.v1_16_R1.ItemStack"));
        load(V1_16_R1.class, "CraftItemStack", new CraftItemStack.CraftItemStackClass("org.bukkit.craftbukkit.v1_16_R1.inventory.CraftItemStack"));
        //

        // Entity horse
        load(V1_16_R1.class, "Entity:Horse:Abstract", new AbstractHorse.AbstractHorseClass("net.minecraft.server.v1_16_R1.EntityHorseAbstract"));
        load(V1_16_R1.class, "Entity:Horse:Abstract:Chested", new AbstractChestedHorse.AbstractChestedHorseClass("net.minecraft.server.v1_16_R1.EntityHorseChestedAbstract"));
        load(V1_16_R1.class, "Entity:Horse:Donkey", new HorseDonkey.HorseDonkeyClass("net.minecraft.server.v1_16_R1.EntityHorseDonkey"));
        load(V1_16_R1.class, "Entity:Horse:Mule", new HorseMule.HorseMuleClass("net.minecraft.server.v1_16_R1.EntityHorseMule"));
        load(V1_16_R1.class, "Entity:Horse:Skeleton", new HorseSkeleton.HorseSkeletonClass("net.minecraft.server.v1_16_R1.EntityHorseSkeleton"));
        load(V1_16_R1.class, "Entity:Horse:Zombie", new HorseZombie.HorseZombieClass("net.minecraft.server.v1_16_R1.EntityHorseZombie"));
        // Entity skeleton
        load(V1_16_R1.class, "Entity:Skeleton:Wither", new SkeletonWither.SkeletonWitherClass("net.minecraft.server.v1_16_R1.EntitySkeletonWither"));
        load(V1_16_R1.class, "Entity:Skeleton:Stray", new SkeletonStray.SkeletonStrayClass("net.minecraft.server.v1_16_R1.EntitySkeletonStray"));
        // Entity zombie
        load(V1_16_R1.class, "Entity:Zombie:Villager", new ZombieVillager.ZombieVillagerClass("net.minecraft.server.v1_16_R1.EntityZombieVillager"));
        load(V1_16_R1.class, "Entity:Zombie:Husk", new ZombieHusk.ZombieHuskClass("net.minecraft.server.v1_16_R1.EntityZombieHusk"));
        load(V1_16_R1.class, "Entity:Zombie:Drowned", new ZombieDrowned.ZombieDrownedClass("net.minecraft.server.v1_16_R1.EntityDrowned"));
        // Entity vindicator
        load(V1_16_R1.class, "Entity:Vindicator", new Vindicator.VindicatorClass("net.minecraft.server.v1_16_R1.EntityVindicator"));
        // Entity evoker
        load(V1_16_R1.class, "Entity:Evoker", new Evoker.EvokerClass("net.minecraft.server.v1_16_R1.EntityEvoker"));
        // Entity vex
        load(V1_16_R1.class, "Entity:Vex", new Vex.VexClass("net.minecraft.server.v1_16_R1.EntityVex"));
        // Entity llama
        load(V1_16_R1.class, "Entity:Llama", new Llama.LlamaClass("net.minecraft.server.v1_16_R1.EntityLlama"));
        // Entity illager illusioner
        load(V1_16_R1.class, "Entity:Illusioner", new Illusioner.IllusionerClass("net.minecraft.server.v1_16_R1.EntityIllagerIllusioner"));
        // Entity illager wizard
        load(V1_16_R1.class, "Entity:IllagerWizard", new IllagerWizard.IllagerWizardClass("net.minecraft.server.v1_16_R1.EntityIllagerWizard"));
        load(V1_16_R1.class, "Entity:IllagerWizard:Spell", new EnumSpellEnum.EnumSpellClass("net.minecraft.server.v1_16_R1.EntityIllagerWizard$Spell"));
        // Entity parrot
        load(V1_16_R1.class, "Entity:Parrot", new Parrot.ParrotClass("net.minecraft.server.v1_16_R1.EntityParrot"));
        // Entity dolphin
        load(V1_16_R1.class, "Entity:Dolphin", new Dolphin.DolphinClass("net.minecraft.server.v1_16_R1.EntityDolphin"));
        // Entity fish
        load(V1_16_R1.class, "Entity:Fish", new Fish.FishClass("net.minecraft.server.v1_16_R1.EntityFish"));
        load(V1_16_R1.class, "Entity:Cod", new Cod.CodClass("net.minecraft.server.v1_16_R1.EntityCod"));
        load(V1_16_R1.class, "Entity:Salmon", new Salmon.SalmonClass("net.minecraft.server.v1_16_R1.EntitySalmon"));
        load(V1_16_R1.class, "Entity:PufferFish", new Pufferfish.PufferfishClass("net.minecraft.server.v1_16_R1.EntityPufferFish"));
        load(V1_16_R1.class, "Entity:TropicalFish", new Tropicalfish.TropicalfishClass("net.minecraft.server.v1_16_R1.EntityTropicalFish"));
        // Entity phantom
        load(V1_16_R1.class, "Entity:Phantom", new Phantom.PhantomClass("net.minecraft.server.v1_16_R1.EntityPhantom"));
        // Entity turtle
        load(V1_16_R1.class, "Entity:Turtle", new Turtle.TurtleClass("net.minecraft.server.v1_16_R1.EntityTurtle"));
        // Entity cat
        load(V1_16_R1.class, "Entity:Cat", new Cat.CatClass("net.minecraft.server.v1_16_R1.EntityCat"));
        // Entity villager
        load(V1_16_R1.class, "VillagerData", new VillagerData.VillagerDataClass("net.minecraft.server.v1_16_R1.VillagerData"));
        load(V1_16_R1.class, "VillagerProfession", new VillagerProfessionExec.VillagerProfessionExecClass("net.minecraft.server.v1_16_R1.VillagerProfession"));
        load(V1_16_R1.class, "VillagerType", new VillagerType.VillagerTypeClass("net.minecraft.server.v1_16_R1.VillagerType"));
        //
    }

    @Override
    public void loadFields() {
        super.loadFields();

        load(V1_16_R1.class, "Entity:loc", new FieldExecutor(getClassExec("Entity"), getClassExec("Vec3D"), "loc", "Gets the Vec3D loc of an entity"));
    }

    @Override
    public void loadTexts() {
        super.loadTexts();


        super.getTexts().put("EntityTypes:ARMOR_STAND", "ARMOR_STAND");
        super.getTexts().put("EntityTypes:BAT", "BAT");
        super.getTexts().put("EntityTypes:EGG", "EGG");
        super.getTexts().put("EntityTypes:BLAZE", "BLAZE");
        super.getTexts().put("EntityTypes:BOAT", "BOAT");
        super.getTexts().put("EntityTypes:CAT", "CAT");
        super.getTexts().put("EntityTypes:CAVE_SPIDER", "CAVE_SPIDER");
        super.getTexts().put("EntityTypes:CHICKEN", "CHICKEN");
        super.getTexts().put("EntityTypes:COD", "COD");
        super.getTexts().put("EntityTypes:COW", "COW");
        super.getTexts().put("EntityTypes:CREEPER", "CREEPER");
        super.getTexts().put("EntityTypes:DONKEY", "DONKEY");
        super.getTexts().put("EntityTypes:DOLPHIN", "DOLPHIN");
        super.getTexts().put("EntityTypes:DRAGON_FIREBALL", "DRAGON_FIREBALL");
        super.getTexts().put("EntityTypes:DROWNED", "DROWNED");
        super.getTexts().put("EntityTypes:ELDER_GUARDIAN", "ELDER_GUARDIAN");
        super.getTexts().put("EntityTypes:END_CRYSTAL", "END_CRYSTAL");
        super.getTexts().put("EntityTypes:ENDER_DRAGON", "ENDER_DRAGON");
        super.getTexts().put("EntityTypes:ENDERMAN", "ENDERMAN");
        super.getTexts().put("EntityTypes:ENDERMITE", "ENDERMITE");
        super.getTexts().put("EntityTypes:EVOKER_FANGS", "EVOKER_FANGS");
        super.getTexts().put("EntityTypes:EVOKER", "EVOKER");
        super.getTexts().put("EntityTypes:EYE_OF_ENDER", "EYE_OF_ENDER");
        super.getTexts().put("EntityTypes:FALLING_BLOCK", "FALLING_BLOCK");
        super.getTexts().put("EntityTypes:FOX", "FOX");
        super.getTexts().put("EntityTypes:GHAST", "GHAST");
        super.getTexts().put("EntityTypes:GIANT", "GIANT");
        super.getTexts().put("EntityTypes:GUARDIAN", "GUARDIAN");
        super.getTexts().put("EntityTypes:HORSE", "HORSE");
        super.getTexts().put("EntityTypes:HUSK", "HUSK");
        super.getTexts().put("EntityTypes:ILLUSIONER", "ILLUSIONER");
        super.getTexts().put("EntityTypes:ITEM", "ITEM");
        super.getTexts().put("EntityTypes:ITEM_FRAME", "ITEM_FRAME");
        super.getTexts().put("EntityTypes:FIREBALL", "FIREBALL");
        super.getTexts().put("EntityTypes:LEASH_KNOT", "LEASH_KNOT");
        super.getTexts().put("EntityTypes:LLAMA", "LLAMA");
        super.getTexts().put("EntityTypes:LLAMA_SPIT", "LLAMA_SPIT");
        super.getTexts().put("EntityTypes:MAGMA_CUBE", "MAGMA_CUBE");
        super.getTexts().put("EntityTypes:MINECART", "MINECART");
        super.getTexts().put("EntityTypes:CHEST_MINECART", "CHEST_MINECART");
        super.getTexts().put("EntityTypes:COMMAND_BLOCK_MINECART", "COMMAND_BLOCK_MINECART");
        super.getTexts().put("EntityTypes:FURNACE_MINECART", "FURNACE_MINECART");
        super.getTexts().put("EntityTypes:HOPPER_MINECART", "HOPPER_MINECART");
        super.getTexts().put("EntityTypes:SPAWNER_MINECART", "SPAWNER_MINECART");
        super.getTexts().put("EntityTypes:TNT_MINECART", "TNT_MINECART");
        super.getTexts().put("EntityTypes:MULE", "MULE");
        super.getTexts().put("EntityTypes:MOOSHROOM", "MOOSHROOM");
        super.getTexts().put("EntityTypes:OCELOT", "OCELOT");
        super.getTexts().put("EntityTypes:PAINTING", "PAINTING");
        super.getTexts().put("EntityTypes:PANDA", "PANDA");
        super.getTexts().put("EntityTypes:PARROT", "PARROT");
        super.getTexts().put("EntityTypes:PIG", "PIG");
        super.getTexts().put("EntityTypes:PUFFERFISH", "PUFFERFISH");
        super.getTexts().put("EntityTypes:ZOMBIE_PIGMAN", "ZOMBIFIED_PIGLIN");
        super.getTexts().put("EntityTypes:POLAR_BEAR", "POLAR_BEAR");
        super.getTexts().put("EntityTypes:TNT", "TNT");
        super.getTexts().put("EntityTypes:RABBIT", "RABBIT");
        super.getTexts().put("EntityTypes:SALMON", "SALMON");
        super.getTexts().put("EntityTypes:SHEEP", "SHEEP");
        super.getTexts().put("EntityTypes:SHULKER", "SHULKER");
        super.getTexts().put("EntityTypes:SHULKER_BULLET", "SHULKER_BULLET");
        super.getTexts().put("EntityTypes:SILVERFISH", "SILVERFISH");
        super.getTexts().put("EntityTypes:SKELETON", "SKELETON");
        super.getTexts().put("EntityTypes:SKELETON_HORSE", "SKELETON_HORSE");
        super.getTexts().put("EntityTypes:SLIME", "SLIME");
        super.getTexts().put("EntityTypes:SMALL_FIREBALL", "SMALL_FIREBALL");
        super.getTexts().put("EntityTypes:SNOW_GOLEM", "SNOW_GOLEM");
        super.getTexts().put("EntityTypes:SNOWBALL", "SNOWBALL");
        super.getTexts().put("EntityTypes:SPIDER", "SPIDER");
        super.getTexts().put("EntityTypes:SQUID", "SQUID");
        super.getTexts().put("EntityTypes:STRAY", "STRAY");
        super.getTexts().put("EntityTypes:TRADER_LLAMA", "TRADER_LLAMA");
        super.getTexts().put("EntityTypes:TROPICAL_FISH", "TROPICAL_FISH");
        super.getTexts().put("EntityTypes:TURTLE", "TURTLE");
        super.getTexts().put("EntityTypes:ENDER_PEARL", "ENDER_PEARL");
        super.getTexts().put("EntityTypes:VEX", "VEX");
        super.getTexts().put("EntityTypes:VILLAGER", "VILLAGER");
        super.getTexts().put("EntityTypes:IRON_GOLEM", "IRON_GOLEM");
        super.getTexts().put("EntityTypes:VINDICATOR", "VINDICATOR");
        super.getTexts().put("EntityTypes:PILLAGER", "PILLAGER");
        super.getTexts().put("EntityTypes:WANDERING_TRADER", "WANDERING_TRADER");
        super.getTexts().put("EntityTypes:WITCH", "WITCH");
        super.getTexts().put("EntityTypes:WITHER", "WITHER");
        super.getTexts().put("EntityTypes:WITHER_SKELETON", "WITHER_SKELETON");
        super.getTexts().put("EntityTypes:WITHER_SKULL", "WITHER_SKULL");
        super.getTexts().put("EntityTypes:WOLF", "WOLF");
        super.getTexts().put("EntityTypes:ZOMBIE", "ZOMBIE");
        super.getTexts().put("EntityTypes:ZOMBIE_HORSE", "ZOMBIE_HORSE");
        super.getTexts().put("EntityTypes:ZOMBIE_VILLAGER", "ZOMBIE_VILLAGER");
        super.getTexts().put("EntityTypes:PHANTOM", "PHANTOM");
        super.getTexts().put("EntityTypes:RAVAGER", "RAVAGER");
    }

    @Override
    public @NotNull String getName() {
        return "v1_16_R1";
    }

}
