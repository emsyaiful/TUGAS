/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
/**
 *
 * @author asus
 */
public class GameControl {
    private ArrayList<Player> PlayerOrder;
    private ArrayList<Nation> Map;
    private Player other;
   
    private void loadMap()
    {   
        other= new Player();
        Nation Start = new Nation("Start Panel",0,0,other);
        Nation Jakarta = new Nation("Jakarta",1,50,null);
        Nation Bandung = new Nation("Bandung",2,75,null);
        Nation Banten = new Nation("Banten",3,100,null);
        Nation Prison1 = new Nation("Prison",4,0,other);
        Nation Semarang = new Nation("Semarang",5,120,null);
        Nation Solo = new Nation("Solo",6,140,null);
        Nation Jogja = new Nation("Jogja",7,160,null);
        Nation FreeToGo = new Nation("Free To Go Panel",8,0,other);
        Nation Surabaya = new Nation("Surabaya",9,175,null);
        Nation Madura = new Nation("Madura",10,190,null);
        Nation Malang = new Nation ("Malang",11,200,null);
        Nation Prison2 = new Nation ("Prison",12,0,other);
        Nation Bali = new Nation ("Bali",13,230,null);
        Nation Lombok = new Nation ("Lombok",14,250,null);
        Nation Kupang = new Nation ("Kupang",15,300,null);
        Map.add(Start);
        Map.add(Jakarta);
        Map.add(Bandung);
        Map.add(Banten);
        Map.add(Prison1);
        Map.add(Semarang);
        Map.add(Solo);
        Map.add(Jogja);
        Map.add(FreeToGo);
        Map.add(Surabaya);
        Map.add(Madura);
        Map.add(Malang);
        Map.add(Prison2);
        Map.add(Bali);
        Map.add(Lombok);
        Map.add(Kupang);
    }
    
    private void rollDice(Player p)
    {
        int rd= Math.abs(new Random().nextInt());
        rd= (rd % 12)+1;
        p.move(rd);
        System.out.println("Player " + p.getName()+" Rolls "+rd +" position :"+p.getPosition());

        
    }
    
    private void Auction()
    {
        
    }
    
    public void beginGame(Player p1, Player p2, Player p3, Player p4)
    {
        Map = new ArrayList<>();
        this.loadMap();
        PlayerOrder = new ArrayList<>();
        PlayerOrder.add(p1);
        PlayerOrder.add(p2);
        PlayerOrder.add(p3);
        PlayerOrder.add(p4);
        
        //prototype fungsi
        while(true)
        {
        String command = new String();
        Scanner commandReader = new Scanner(System.in);
        command = commandReader.nextLine();
        if(command.equalsIgnoreCase("move"))
        {
            System.out.println("choose which player to move");
            int order = commandReader.nextInt();
            rollDice(PlayerOrder.get(order-1));
            Nation currentPosition = Map.get(PlayerOrder.get(order-1).getPosition());
            System.out.println("You Arrived in "+currentPosition.getName());
            if(currentPosition.getOwner() !=other)
            {
                
            System.out.print("Owner: ");
            if(currentPosition.getOwner()== null)
            {
            System.out.println("None");
            System.out.println("Want to buy(y/n)?");
            command = commandReader.nextLine();
            if(command.equalsIgnoreCase("y"))
            {
               currentPosition.buy(PlayerOrder.get(order-1));
               System.out.println("You buy "+currentPosition.getName()+ " Remaining Money: " + PlayerOrder.get(order-1).getCash());
            }
            }

            }
        }
        
        else if (command.equalsIgnoreCase("stop"))
        {
            break;
        }
        }
    }
}
