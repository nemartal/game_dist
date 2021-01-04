package com.dist.game.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static final int PORT = 16543;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    new ClientConnection(socket).start();
                } catch (IOException e) {
                    System.out.println("Error: Cant accept connection " + e);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
