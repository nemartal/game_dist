package com.dist.game.server;

import com.dist.game.server.controller.GameController;
import com.dist.game.server.controller.MatchMakingController;
import com.dist.game.server.model.Player;
import com.dist.game.share.exception.GameMaxUsersException;
import com.dist.game.share.exception.GameNotFoundException;
import com.dist.game.share.exception.GameUserAlreadyJoinedException;
import com.dist.game.share.model.GameAction;
import com.dist.game.share.model.GameType;

import java.io.*;
import java.net.Socket;

public class ClientConnection extends Thread {
    private final Socket socket;

    private Player player;
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

            // Login
            this.login();

            // Create or Join
            this.createOrJoin();

            this.gc.play(player);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: IOException");
            e.printStackTrace();
        } finally {
            try {
                if (socket != null)
                    socket.close();
                if (is != null)
                    is.close();
                if (os != null)
                    os.close();
            } catch (IOException e) {
            }
            if (this.gc != null && this.player != null) {
                this.gc.exit(player);
            }
        }
    }

    private void login() throws IOException, ClassNotFoundException {
        System.out.println("# Esperando Nickname");
        // Get Nickname
        String nickname = (String) ois.readObject();
        System.out.println("# Nickname: " + nickname);

        // Return user
        this.player = new Player(nickname, this.oos, this.ois);
        System.out.println("# User enviado");
    }

    private void createOrJoin() throws IOException, ClassNotFoundException {
        try {
            System.out.println("# Esperando Accion");
            // Get game action
            GameAction action = (GameAction) ois.readObject();
            System.out.println("# Accion: " + action.toString());
            if (action.equals(GameAction.JOIN)) {
                String gameId = (String) ois.readObject();
                this.gc = MatchMakingController.getInstance().getGame(gameId);
            } else {
                System.out.println("# Creando juego");
                GameType gameType = (GameType) ois.readObject();
                this.gc = MatchMakingController.getInstance().createGame(gameType);
                // Send game id
                this.oos.writeObject(this.gc.getId());
            }
            this.oos.writeObject(this.gc.getType());
            System.out.println("# Uniendose");
            this.gc.join(this.player);
        } catch (GameNotFoundException | GameMaxUsersException | GameUserAlreadyJoinedException e) {
            this.oos.writeObject(e);
            this.createOrJoin();
        }
    }
}
