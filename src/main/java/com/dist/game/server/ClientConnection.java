package com.dist.game.server;

import com.dist.game.share.model.User;
import com.dist.game.share.model.dto.UserDTO;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientConnection extends Thread {
    private final Socket socket;

    private User user;

    public ClientConnection(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        InputStream is = null;
        OutputStream os = null;

        ObjectInputStream ois = null;
        try {
            is = socket.getInputStream();
            os = socket.getOutputStream();

            ois = new ObjectInputStream(is);

            // Get Nickname
            UserDTO userDto = (UserDTO) ois.readObject();

            // Create or join
            // Play

        } catch (IOException e) {
            System.out.println("Error: IOException");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Error: ClassNotFoundException");
            e.printStackTrace();
        }
    }
}
