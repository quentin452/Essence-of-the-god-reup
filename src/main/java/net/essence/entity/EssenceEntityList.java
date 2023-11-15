package net.essence.entity;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.essence.util.*;
import java.util.*;

public class EssenceEntityList
{
    public static Map stringToClassMapping;
    public static Map classToStringMapping;
    public static Map IDtoClassMapping;
    private static Map classToIDMapping;
    private static Map stringToIDMapping;
    public static HashMap entityEggs;
    
    public static void addMapping(final Class clazz, final String name, final int id) {
        if (EssenceEntityList.stringToClassMapping.containsKey(name)) {
            throw new IllegalArgumentException("ID is already registered: " + name);
        }
        if (EssenceEntityList.IDtoClassMapping.containsKey(id)) {
            throw new IllegalArgumentException("ID is already registered: " + id);
        }
        EssenceEntityList.stringToClassMapping.put(name, clazz);
        EssenceEntityList.classToStringMapping.put(clazz, name);
        EssenceEntityList.IDtoClassMapping.put(id, clazz);
        EssenceEntityList.classToIDMapping.put(clazz, id);
        EssenceEntityList.stringToIDMapping.put(name, id);
    }
    
    public static void addMapping(final Class clazz, final String name, final int id, final int primary, final int secondary) {
        addMapping(clazz, name, id);
        EssenceEntityList.entityEggs.put(id, new EntityEggInfo(id, primary, secondary));
    }
    
    public static String getStringFromID(final int id) {
        final Class oclass = getClassFromID(id);
        return (oclass != null) ? EssenceEntityList.classToStringMapping.get(oclass) : null;
    }
    
    public static Class getClassFromID(final int id) {
        return EssenceEntityList.IDtoClassMapping.get(id);
    }
    
    public static int getIDFromClass(final Class clazz) {
        return EssenceEntityList.classToIDMapping.get(clazz);
    }
    
    public static Entity createEntityByID(final int id, final World world) {
        Entity entity = null;
        try {
            final Class oclass = getClassFromID(id);
            if (oclass != null) {
                entity = oclass.getConstructor(World.class).newInstance(world);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (entity == null) {
            LogHelper.warn("Entity with ID " + id + " is null, it will be skipped.");
        }
        return entity;
    }
    
    static {
        EssenceEntityList.stringToClassMapping = new HashMap();
        EssenceEntityList.classToStringMapping = new HashMap();
        EssenceEntityList.IDtoClassMapping = new HashMap();
        EssenceEntityList.classToIDMapping = new HashMap();
        EssenceEntityList.stringToIDMapping = new HashMap();
        EssenceEntityList.entityEggs = new LinkedHashMap();
    }
    
    public static class EntityEggInfo
    {
        public final int entityID;
        public final int primaryColor;
        public final int secondaryColor;
        
        public EntityEggInfo(final int id, final int primary, final int secondary) {
            this.entityID = id;
            this.primaryColor = primary;
            this.secondaryColor = secondary;
        }
    }
}
