package com.dist.game.client;

import com.dist.game.share.exception.GameMaxUsersException;
import com.dist.game.share.exception.GameNotFoundException;
import com.dist.game.share.exception.GameUserAlreadyJoinedException;
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

    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;

    public void jugar() {
        Socket socket = null;
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

    public void JoinRoom(BufferedWriter bf, Scanner entrada, ObjectOutputStream oos) throws IOException, ClassNotFoundException {
        GameAction gameAction = GameAction.JOIN;
        oos.writeObject(gameAction);
        oos.flush();
        System.out.println("Write the code of the room");
        codeRoom = entrada.nextLine();
        oos.writeObject(codeRoom);
        oos.flush();

        // GameAction.JOINED
        //GameNotFoundException | GameMaxUsersException | GameUserAlreadyJoinedException
        Object inp = ois.readObject();

        if(inp instanceof GameAction){

        }

        if(inp instanceof GameNotFoundException){
            System.out.println("No se encuentra el juego");
        }

        if(inp instanceof GameMaxUsersException){
            System.out.println("El juego está lleno");
        }

        if(inp instanceof GameUserAlreadyJoinedException){
            System.out.println("Ya estás dentro del juego");
        }
    }

    public void CreateRoom(ObjectOutputStream oos) throws IOException {
        GameAction gameAction = GameAction.CREATE;
        oos.writeObject(gameAction);
        oos.flush();
        System.out.println();
    }
}
