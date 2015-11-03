/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NARK
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            
            Scanner scan=new Scanner(System.in);
            
            Socket so=new Socket("localhost",5001);
            
            InputStream is=so.getInputStream();
            OutputStream os=so.getOutputStream();
            
            System.out.println("Connected to Server");
            
            while(true){               
                String command;
                command=scan.nextLine();
                
                if(command.substring(0,2)=="dl"){
                    String name=command.substring(3);
                    command=command+"\t\r\n";
                    os.write(command.getBytes());
                    os.flush();
                    byte[] buff=new byte[10];
                    
                    String paket="";
                    int k=0;
                    while(true){
                        buff=new byte[10];
                        is.read(buff);
                        String m=new String(buff);
                        paket=paket+m;
                        if(paket.indexOf("\t\r\n")>0){
                            break;
                        }
                    }
                    
                    int n=paket.indexOf("\t\n");
                    String lenght=paket.substring(0,n);
                    int length=Integer.parseInt(lenght);
                    
                    String data=paket.substring(n+2,length+2);
                    
                    
                    FileOutputStream write=new FileOutputStream(name);
                    write.write(data.getBytes());
                    write.close();
                }
                
                else if(command.substring(0,2)=="up"){
                    String name=command.substring(3);
                    int n=name.length();
                    String paket=n+"\t\n"+name+"\t\n";
                    
                    byte[] buff=new byte[10240];
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(name));
                    bis.read(buff);
                    bis.close();
                    
                    String data=new String(buff);
                    int m=data.length();
                    paket=paket+m+"\t\n"+data+"\t\r\n";
                    os.write(paket.getBytes());
                    os.flush();
                }
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
