package edu.hw6;

import edu.hw6.Task6.PortScanner;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.ServerSocket;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task6Test {
    @Test
    public void test() throws IOException {
        ServerSocket serverSocket = new ServerSocket(1061);
        assertFalse(PortScanner.isPortOpen(1061));
        serverSocket.close();
        assertTrue(PortScanner.isPortOpen(1061));
    }
}
