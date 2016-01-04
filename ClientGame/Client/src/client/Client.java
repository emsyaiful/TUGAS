/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
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
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Player player1= new Player("p1",500,0);
        Player player2= new Player("p2",500,0);
        Player player3= new Player("p3",500,0);
        Player player4= new Player("p4",500,0);
        GameControl GC = new GameControl();
        // loading Map

        //Loading map
        GC.beginGame(player1, player2, player3, player4);
        
    }
    
}
