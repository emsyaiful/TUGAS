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
    
    public void beginGame(Player p1, Player p2, Player p3,Player p4)
    {
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
        if(command.equals("move"))
        {
            System.out.println("choose which player to move");
            int order = commandReader.nextInt();
            rollDice(PlayerOrder.get(order-1));
            
        }
        
        else if (command.equalsIgnoreCase("stop"))
        {
            break;
        }
        }
    }
}
