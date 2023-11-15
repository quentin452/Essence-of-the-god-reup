package net.essence.util;

import net.minecraft.inventory.*;
import net.minecraft.entity.player.*;

public class ContainerEmpty extends Container
{
    public boolean canInteractWith(final EntityPlayer var1) {
        return true;
    }
}
