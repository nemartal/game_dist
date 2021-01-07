package com.dist.game.client;

import com.dist.game.share.model.GameAction;
import com.dist.game.share.model.User;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static final int PORT = 16543;
    public String nick;
    public String codeRoom;

    public void jugar() {
        Socket socket = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        OutputStream os = null;
        PrintStream printStream = null;
        BufferedWriter bf = null;
        String yesNo = null;

        try {
            socket = new Socket();

            System.out.println("Write a nick");
            Scanner entrada = new Scanner(System.in);
            nick = entrada.nextLine();

            bf = new BufferedWriter(new OutputStreamWriter(os));
            bf.write(nick);

            User user = null;

            user = (User) ois.readObject();

            System.out.println("Do you want to join a game? yes o no");
            yesNo = entrada.nextLine();
            GameAction gameAction = null;
            if (yesNo.equalsIgnoreCase("yes")) {
                JoinRoom(bf,entrada,oos);
            }

            System.out.println("Do you want to create a new game? yes o no");
            yesNo = entrada.nextLine();
            if (yesNo.equalsIgnoreCase("yes")) {
                CreateRoom(oos);
            }


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void JoinRoom(BufferedWriter bf, Scanner entrada, ObjectOutputStream oos) throws IOException {
        GameAction gameAction = GameAction.JOIN;
        System.out.println("Write the code of the room");
        codeRoom = entrada.nextLine();
        bf.write(codeRoom);
        oos.writeObject(gameAction);

    }

    public void CreateRoom(ObjectOutputStream oos){
        GameAction gameAction = GameAction.CREATE;
        oos.writeObject(gameAction);
    }
}
