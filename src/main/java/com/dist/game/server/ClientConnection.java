package com.dist.game.server;

import com.dist.game.server.controller.GameController;
import com.dist.game.server.controller.MatchMakingController;
import com.dist.game.share.exception.GameMaxUsersException;
import com.dist.game.share.exception.GameNotFoundException;
import com.dist.game.share.exception.GameUserAlreadyJoinedException;
import com.dist.game.share.model.GameAction;
import com.dist.game.share.model.GameType;
import com.dist.game.share.model.User;

import java.io.*;
import java.net.Socket;

public class ClientConnection extends Thread {
    private final Socket socket;

    private User user;
    private GameController gc;

    private InputStream is = null;
    private OutputStream os = null;

    private ObjectInputStream ois = null;
    private ObjectOutputStream oos = null;


    public ClientConnection(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            os = socket.getOutputStream();
            is = socket.getInputStream();

            oos = new ObjectOutputStream(os);
            ois = new ObjectInputStream(is);

            System.out.println("# Esperando Nickname");
            // Get Nickname
            String nickname = (String) ois.readObject();
            System.out.println("# Nickname: "+nickname);

            // Return user
            this.user = new User(nickname);
            oos.writeObject(this.user);
            oos.flush();
            System.out.println("# User enviado");

            // Create or Join
            this.createOrJoin();

            // Play


        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: IOException");
            e.printStackTrace();
        }
    }

    private void createOrJoin() throws IOException, ClassNotFoundException {
        try {
            System.out.println("# Esperando Accion");
            // Get game action
            GameAction action = (GameAction) ois.readObject();
            System.out.println("# Accion: "+action.toString());
            if (action.equals(GameAction.JOIN)) {
                String gameId =(String) ois.readObject();
                this.gc = MatchMakingController.getInstance().getGame(gameId);
            } else {
                System.out.println("# Creando juego");
                GameType gameType = (GameType) ois.readObject();
                this.gc = MatchMakingController.getInstance().createGame(gameType);
                // Send game id
                this.oos.writeObject(this.gc.getId());
            }
            System.out.println("# Uniendose");
            this.gc.join(this.user);
            // Send Action Joined
            this.oos.writeObject(GameAction.JOINED);
            // Send Game Type
            this.oos.writeObject(this.gc.getType());
        } catch (GameNotFoundException | GameMaxUsersException | GameUserAlreadyJoinedException e) {
            this.oos.writeObject(e);
            this.createOrJoin();
        }
    }
}
