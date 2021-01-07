package com.dist.game.client;

import com.dist.game.share.model.User;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final int PORT = 16543;
    private String nick;

    public void jugar(){
      Socket socket = null;
      ObjectInputStream ois = null;
      ObjectOutputStream oos= null;
      OutputStream os = null;
      PrintStream printStream = null;
      BufferedWriter bf = null;
      String yesNo = null;

      try{
          socket = new Socket();

          System.out.println("Write a nick");
          Scanner entrada=new Scanner(System.in);
          nick=entrada.nextLine();

          bf = new BufferedWriter(new OutputStreamWriter(os));
          bf.write(nick);

          User user = null;

          user = (User) ois.readObject();

          System.out.println("Do you want to join a game? yes o no");
          yesNo = entrada.nextLine();
          if (yesNo.equalsIgnoreCase("yes")){

          }





      } catch (IOException | ClassNotFoundException e) {
          e.printStackTrace();
      }
    }
}
