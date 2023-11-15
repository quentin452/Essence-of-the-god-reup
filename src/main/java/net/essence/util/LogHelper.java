package net.essence.util;

import org.apache.logging.log4j.*;
import cpw.mods.fml.common.*;
import java.io.*;

public class LogHelper
{
    private static BufferedWriter writer;
    
    private static void log(final Level level, final Object msg) {
        FMLLog.log("Essence Of The Gods", level, "[Essence of the gods] " + msg.toString(), new Object[0]);
        System.err.println(msg);
        writeFile(msg);
    }
    
    public static void debug(final Object msg) {
    }
    
    public static void error(final Object msg) {
        log(Level.ERROR, "[Essence of the gods] " + msg);
    }
    
    public static void info(final Object msg) {
        log(Level.INFO, "[Essence of the gods] " + msg);
    }
    
    public static void warn(final Object msg) {
        log(Level.WARN, "[Essence of the gods] " + msg);
    }
    
    public static void dev(final Object msg) {
        log(Level.INFO, "[Essence of the gods] [DEVELOPMENT] " + msg);
    }
    
    public static void writeFile(final Object msg) {
        try {
            LogHelper.writer.write(msg + "\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void closeFile() {
        try {
            LogHelper.writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    static {
        File dir = new File("./EssenceOfTheGods");
        dir.mkdir();
        dir = new File("./EssenceOfTheGods/debug.log");
        try {
            LogHelper.writer = new BufferedWriter(new FileWriter(dir));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
