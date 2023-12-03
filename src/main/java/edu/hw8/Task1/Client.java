package edu.hw8.Task1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    private static final int PORT = 1599;

    private static final int BUFFER_CAPACITY = 256;

    private final SocketChannel client;

    private ByteBuffer buffer;

    public Client() throws IOException {
        client = SocketChannel.open(new InetSocketAddress("localhost", PORT));
        buffer = ByteBuffer.allocate(BUFFER_CAPACITY);
    }

    public String sendMessage(String msg) throws IOException {
        buffer.put(msg.getBytes());
        buffer.flip();
        buffer.clear();
        client.write(buffer);
        buffer.clear();
        client.read(buffer);
        return new String(buffer.array()).trim();
    }

    public void stop() throws IOException {
        client.close();
        buffer = null;
    }
}
