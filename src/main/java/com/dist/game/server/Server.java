package com.dist.game.server;

import com.dist.game.server.controller.MatchMakingController;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static final int PORT = 16543;

    //TODO: Create a socket pool
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        // First time to create new MatchMakingController
        MatchMakingController.getInstance();

        try {
            System.out.println("Iniciando servidor");
            serverSocket = new ServerSocket(PORT);
            while (true) {
                try {
                    System.out.println("Esperando");
                    Socket socket = serverSocket.accept();
                    new ClientConnection(socket).start();
                    System.out.println("Usuario conectado");
                } catch (IOException e) {
                    System.out.println("Error: Cant accept connection " + e);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
