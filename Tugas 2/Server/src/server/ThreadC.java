/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NARK
 */
public class ThreadC implements Runnable{

    private Socket so;
    private InputStream is;
    private OutputStream os;

    public ThreadC(Socket so) throws IOException{
        this.so=so;
        is=so.getInputStream();
        os=so.getOutputStream();
    } 
    public void run(){
        try {
            String data="";
            while(true){
                while(true){
                    byte[] buff=new byte[10];
                    is.read(buff);
                    String z=new String(buff);
                    data=data+z;
                    if(data.indexOf("\t\r\n")>0){
                        break;
                    }
                }
                
                if(data.substring(0,2)=="dl"){
                    byte[] buf=new byte[10240];
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(data.substring(3)));
                    bis.read(buf);
                    bis.close();
                    
                    String paket=new String(buf);
                    int k=paket.length();
                    
                    String ka=k+"\t\n"+paket+"\t\r\n";
                    os.write(ka.getBytes());
                    os.flush();
                }
                
                else{
                    int n=data.indexOf("\t\n");
                    String lenght=data.substring(0,n);
                    int length=Integer.parseInt(lenght);
                    String nama=data.substring(n+2,length+2);
                
                    int m=data.indexOf("\t\n", length+4);
                    lenght=data.substring(length+4, m);
                    length=Integer.parseInt(lenght);
                    String isi=data.substring(m+2,length+2);
                    
                    FileOutputStream write=new FileOutputStream(nama);
                    write.write(isi.getBytes());
                    write.close();
                }
                
                
            }
        } catch (IOException ex) {
            Logger.getLogger(ThreadC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
