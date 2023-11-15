package net.slayer.api;

import cpw.mods.fml.common.gameevent.*;

public interface ITickHandler
{
    void renderTick(final TickEvent.RenderTickEvent p0);
    
    void playerTick(final TickEvent.PlayerTickEvent p0);
    
    void serverTick(final TickEvent.ServerTickEvent p0);
    
    void worldTick(final TickEvent.WorldTickEvent p0);
}
