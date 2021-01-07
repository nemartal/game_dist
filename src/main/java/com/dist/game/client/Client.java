package com.dist.game.client;

import com.dist.game.share.model.GameAction;
import com.dist.game.share.model.User;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Serializable{

    public static final int PORT = 16543;
    public String nick;
    public String codeRoom;
    public User user = null;

    public void jugar() {
        Socket socket = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        InputStream is = null;
        OutputStream os = null;
        PrintStream printStream = null;
        BufferedWriter bf = null;
        String yesNo = null;

        try {
            socket = new Socket("localhost", PORT);

            os = socket.getOutputStream();
            is = socket.getInputStream();

            ois = new ObjectInputStream(is);
            oos = new ObjectOutputStream(os);

            System.out.println("Write a nick");
            Scanner entrada = new Scanner(System.in);
            nick = entrada.nextLine();

            oos.writeObject(nick);
            oos.flush();

            user = (User) ois.readObject();

            System.out.println(user.getId());


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
        oos.writeObject(codeRoom);
        oos.flush();
        oos.writeObject(gameAction);
        oos.flush();

    }

    public void CreateRoom(ObjectOutputStream oos) throws IOException {
        GameAction gameAction = GameAction.CREATE;
        oos.writeObject(gameAction);
        oos.flush();
        System.out.println();
    }
}
