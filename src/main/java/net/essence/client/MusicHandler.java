package net.essence.client;

import cpw.mods.fml.relauncher.*;
import java.lang.reflect.*;
import net.minecraft.client.*;
import net.minecraft.client.resources.*;
import net.minecraft.util.*;
import net.minecraft.client.audio.*;
import java.util.*;

@SideOnly(Side.CLIENT)
public class MusicHandler implements IResourceManagerReloadListener
{
    private static Map getMap(final SoundRegistry reg) {
        final Field[] fields = reg.getClass().getDeclaredFields();
        try {
            for (final Field f : fields) {
                if (f.getType() == Map.class) {
                    f.setAccessible(true);
                    return (Map)f.get(reg);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private static SoundRegistry getSoundRegistry() {
        if (Minecraft.getMinecraft().getSoundHandler() != null) {
            final Field[] fields = Minecraft.getMinecraft().getSoundHandler().getClass().getDeclaredFields();
            try {
                for (final Field f : fields) {
                    if (f.getType() == SoundRegistry.class) {
                        f.setAccessible(true);
                        return (SoundRegistry)f.get(Minecraft.getMinecraft().getSoundHandler());
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    public void onResourceManagerReload(final IResourceManager var1) {
    }
    
    public void clearMusic() {
        final SoundRegistry reg = getSoundRegistry();
        if (reg == null) {
            return;
        }
        final Map soundMap = getMap(reg);
        for (final Map.Entry<ResourceLocation, SoundEventAccessorComposite> entry : soundMap.entrySet()) {
            final SoundEventAccessorComposite sound = entry.getValue();
            if (sound.getSoundCategory() == SoundCategory.MUSIC) {
                final List soundPool = this.getSoundPool(entry.getValue());
                for (int j = 0; j < soundPool.size(); ++j) {
                    if (soundPool.get(j) instanceof SoundEventAccessor) {
                        final SoundEventAccessor remSound = soundPool.get(j);
                        if (remSound.func_148720_g().getSoundPoolEntryLocation().getResourceDomain().equals("minecraft")) {
                            soundPool.remove(j);
                            --j;
                        }
                    }
                }
            }
        }
    }
    
    private List getSoundPool(final SoundEventAccessorComposite value) {
        final Field[] fields = value.getClass().getDeclaredFields();
        try {
            for (final Field f : fields) {
                if (f.getType() == List.class) {
                    f.setAccessible(true);
                    return (List)f.get(value);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
