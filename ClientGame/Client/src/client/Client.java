/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author asus
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    
    public static void game(){
        Player player1= new Player("p1",1000,0);
        Player player2= new Player("p2",1000,0);
        Player player3= new Player("p3",1000,0);
        Player player4= new Player("p4",1000,0);
       
        GameControl GC = new GameControl();
        
        // loading Map

        //Loading map
        GC.beginGame(player1, player2, player3, player4);
    }
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
//        Socket socket = new Socket("localhost", 9988);
//        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
//        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        game();
        
        
    }
    
}
