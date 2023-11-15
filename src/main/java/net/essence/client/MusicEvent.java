package net.essence.client;

import java.util.*;
import net.minecraft.client.*;
import cpw.mods.fml.common.gameevent.*;
import net.minecraft.util.*;
import net.minecraft.client.audio.*;
import cpw.mods.fml.common.eventhandler.*;

public class MusicEvent
{
    private final Random rand;
    private final Minecraft mc;
    private ISound curMusic;
    private int ticks;
    
    public MusicEvent() {
        this.rand = new Random();
        this.ticks = MathHelper.getRandomIntegerInRange(this.rand, 2000, 10000);
        this.mc = Minecraft.getMinecraft();
    }
    
    @SubscribeEvent
    public void update(final TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            final MusicTicker.MusicType musictype = this.mc.func_147109_W();
            if (this.curMusic == null && this.ticks-- <= 0) {
                final ResourceLocation resource = musictype.getMusicTickerLocation();
                String name = "";
                switch (this.rand.nextInt(6)) {
                    case 0: {
                        name = "underwaterWorld";
                        break;
                    }
                    case 1: {
                        name = "blueWater";
                        break;
                    }
                    case 2: {
                        name = "compBegins";
                        break;
                    }
                    case 3: {
                        name = "deepBlue";
                        break;
                    }
                    case 4: {
                        name = "raceShore";
                        break;
                    }
                    case 5: {
                        name = "raceStar";
                        break;
                    }
                }
                final ResourceLocation musicLocation = new ResourceLocation("eotg:music." + name);
                this.curMusic = (ISound)PositionedSoundRecord.func_147673_a(musicLocation);
                this.mc.getSoundHandler().playSound(this.curMusic);
                this.ticks = MathHelper.getRandomIntegerInRange(this.rand, 2000, 10000);
            }
        }
    }
}
