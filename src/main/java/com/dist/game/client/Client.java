package com.dist.game.client;

import com.dist.game.client.gui.IntroNickCode;
import com.dist.game.share.exception.GameMaxUsersException;
import com.dist.game.share.exception.GameNotFoundException;
import com.dist.game.share.exception.GameUserAlreadyJoinedException;
import com.dist.game.share.model.GameAction;
import com.dist.game.share.model.GameType;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Serializable{

    public static final int PORT = 16543;
    public String nick = "";
    public String codeRoom = "";

    public ObjectInputStream ois = null;
    public ObjectOutputStream oos = null;
    public Socket socket = null;
    public InputStream is = null;
    public OutputStream os = null;
    public String yesNo = null;

    public Scanner entrada = null;

    public void jugar() {


        try {
            socket = new Socket("localhost", PORT);

            os = socket.getOutputStream();
            is = socket.getInputStream();

            ois = new ObjectInputStream(is);
            oos = new ObjectOutputStream(os);

            IntroNickCode introNickCode = new IntroNickCode(ois, oos);
            introNickCode.introNick(nick);
            introNickCode.showInterface();

            //nick = introNickCode.getNick();
            //System.out.println(nick);

            //oos.writeObject(nick);
            //oos.flush();



            /*System.out.println("Do you want to join or create a game? join or create");
            yesNo = entrada.nextLine();
            GameAction gameAction = null;
            if (yesNo.equalsIgnoreCase("join")) {
                joinRoom();
            }
            else if (yesNo.equalsIgnoreCase("create")) {
                createRoom();
            }*/


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void joinRoom() throws IOException, ClassNotFoundException {
        //Send game action type
        GameAction gameAction = GameAction.JOIN;
        oos.writeObject(gameAction);
        oos.flush();

        //Get room code
        System.out.println("Write the code of the room");
        codeRoom = entrada.nextLine();
        oos.writeObject(codeRoom);
        oos.flush();

        // GameAction.JOINED
        //GameNotFoundException | GameMaxUsersException | GameUserAlreadyJoinedException
        Object joined = ois.readObject();

        if(joined instanceof GameAction){
            Object gameTipeObj = ois.readObject();
            if(gameTipeObj instanceof GameType){
                GameType gameType = (GameType) gameTipeObj;
                if(gameType.equals(GameType.PARTY)){
                    //Acede a pantalla party
                    System.out.println();
                    //20 preguntas bucle
                    //Recojo pregunta
                    //Envio pregunta

                    //Recibo stats

                }else{
                    //20 preguntas bucle
                    //Recojo pregunta
                    //Envio pregunta

                    //Recibo stats

                }
            }
        }

        if(joined instanceof GameNotFoundException){
            System.out.println("No se encuentra el juego");
        }

        if(joined instanceof GameMaxUsersException){
            System.out.println("El juego está lleno");
        }

        if(joined instanceof GameUserAlreadyJoinedException){
            System.out.println("Ya estás dentro del juego");
        }
    }

    public void createRoom() throws IOException {
        //Send game action tipe
        GameAction gameAction = GameAction.CREATE;
        oos.writeObject(gameAction);
        oos.flush();
        System.out.println();
    }
}
