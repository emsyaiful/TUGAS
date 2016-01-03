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
        Player other= new Player();
        GameControl GC = new GameControl();
        ArrayList<Nation> Map = new ArrayList<>();
        Nation Start = new Nation(0,0,other);
        Nation Jakarta = new Nation(1,50,null);
        Nation Bandung = new Nation(2,75,null);
        Nation Banten = new Nation(3,100,null);
        Nation Prison1 = new Nation(4,0,other);
        Nation Semarang = new Nation(5,120,null);
        Nation Solo = new Nation(6,140,null);
        Nation Jogja = new Nation(7,160,null);
        Nation FreeToGo = new Nation(8,0,other);
        GC.beginGame(player1, player2, player3, player4);
        
    }
    
}
