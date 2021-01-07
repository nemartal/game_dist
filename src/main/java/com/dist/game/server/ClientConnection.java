package com.dist.game.server;

import com.dist.game.server.controller.GameController;
import com.dist.game.server.controller.MatchMakingController;
import com.dist.game.share.exception.GameNotFoundException;
import com.dist.game.share.model.GameAction;
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

    private BufferedReader br = null;

    public ClientConnection(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            is = socket.getInputStream();
            os = socket.getOutputStream();

            ois = new ObjectInputStream(is);
            oos = new ObjectOutputStream(os);

            br = new BufferedReader(new InputStreamReader(is));

            // Get Nickname
            String nickname = br.readLine();

            // Return user
            this.user = new User(nickname);
            oos.writeObject(this.user);

            // Create or Join
            this.createOrJoin();

            // Play

        } catch (IOException e) {
            System.out.println("Error: IOException");
            e.printStackTrace();
        }
    }

    private void createOrJoin() throws IOException {
        try {
            String action = br.readLine();
            if (action.equals(GameAction.JOIN)) {
                String gameId = br.readLine();
                this.gc = MatchMakingController.getInstance().getGame(gameId);
            } else {
                this.gc = MatchMakingController.getInstance().createGame();

            }
        } catch (GameNotFoundException e) {
            this.oos.writeObject(e);
            this.createOrJoin();
        }
    }
}
