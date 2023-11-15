package net.essence.event;

import java.io.*;
import java.util.*;
import java.net.*;

public class UpdateChecker
{
    public static boolean isUpdateAvailable() throws IOException, MalformedURLException {
        final BufferedReader versionFile = new BufferedReader(new InputStreamReader(new URL("https://raw.github.com/TheSlayerMC/Essence/master/Version.txt").openStream()));
        final String curVersion = versionFile.readLine();
        versionFile.close();
        return !curVersion.contains("1.7");
    }
    
    public static boolean isOnline() throws SocketException {
        final Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            final NetworkInterface interf = interfaces.nextElement();
            if (interf.isUp() && !interf.isLoopback()) {
                final List<InterfaceAddress> adrs = interf.getInterfaceAddresses();
                for (final InterfaceAddress adr : adrs) {
                    final InetAddress inadr = adr.getAddress();
                    if (inadr instanceof Inet4Address) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
