package edu.hw6.Task6;

import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PortScanner {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static int MAX_PORT_COUNT = 49151;
    private final static Map<Integer, String> PORTS_AND_APPS = Map.of(
        135, "EPMAP",
        137, "NetBIOS Name Service",
        138, "NetBIOS Datagram Service",
        139, "NetBIOS Session Service",
        445, "Microsoft-DS (Active Directory)",
        843, "Adobe Flash",
        1900, "Simple Service Discovery Protocol (SSDP)",
        3702, "Dynamic Web Services Discovery"
    );

    private PortScanner() {

    }

    public static void checkAllPorts() {
        LOGGER.info("Port" + "     App");
        for (int port = 0; port <= MAX_PORT_COUNT; ++port) {
            if (isPortOpen(port)) {
                LOGGER.info(port + " Open");
            } else {
                LOGGER.info(port + " Closed" + (PORTS_AND_APPS.getOrDefault(port, "")));
            }
        }
    }

    public static boolean isPortOpen(int port) {
        try (ServerSocket tcpSocket = new ServerSocket(port)) {
            try (DatagramSocket udpSocket = new DatagramSocket(port)) {
                return true;
            } catch (Exception ex) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
