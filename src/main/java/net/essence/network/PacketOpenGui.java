package net.essence.network;

import io.netty.channel.*;
import io.netty.buffer.*;
import net.minecraft.entity.player.*;
import net.essence.*;

public class PacketOpenGui extends AbstractPacket
{
    private int id;
    
    public PacketOpenGui setID(final int id) {
        this.id = id;
        return this;
    }
    
    public void encodeInto(final ChannelHandlerContext ctx, final ByteBuf buffer) {
        buffer.writeInt(this.id);
    }
    
    public void decodeInto(final ChannelHandlerContext ctx, final ByteBuf buffer) {
        this.id = buffer.readInt();
    }
    
    public void handleClientSide(final EntityPlayer player) {
    }
    
    public void handleServerSide(final EntityPlayer player) {
        player.openGui((Object)Essence.instance, this.id, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
    }
}
