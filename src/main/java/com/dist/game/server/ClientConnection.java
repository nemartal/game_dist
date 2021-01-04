package com.dist.game.server;

import com.dist.game.share.model.User;

import java.net.Socket;

public class ClientConnection extends Thread {
    private final Socket socket;

    private User user;

    public ClientConnection(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        // GET nickname
        // Create or join
        // Play

    }
}
