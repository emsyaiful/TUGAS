/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NARK
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    
      public static void readdir(String directoryName){
        File folder = new File(directoryName);
        File[] listOfFiles = folder.listFiles();
        
        for(int i= 0;i<listOfFiles.length;i++){
            System.out.println(listOfFiles[i].getName());//belum diubah ke Output Stream
        }
    }
    
    public static void makedir(String directoryName){
        File dir = new File(directoryName);
        dir.mkdir();
    }
    
    public static void main(String[] args) {
          try {
              // TODO code application logic here
              
              ServerSocket ss= new ServerSocket(5000);
              Socket sock=ss.accept();
              InputStream is=sock.getInputStream();
              OutputStream os=sock.getOutputStream();
              String dir = "C:/";
              byte[] buf=new byte[64];
              
              
              
              while(true){
                  buf=new byte[64];
                  is.read(buf);
                 String kk= new String(buf);
              if("cd ".equals(kk.substring(0,3))){
                  if(":/".equals(kk.substring(5,6))){
                      dir=kk;
                  }
                  else{
                      dir=dir+kk;
                  }
              }
              else if("ls ".equals(kk.substring(0,3))){
                  readdir(dir);
              }
              else if("mkdir ".equals(kk.substring(0,5))){
                  dir=dir+kk.substring(6);
                  makedir(dir);
              }
              else if("exit".equals(kk.substring(0,3))){
                  break;
              }
  
              }
          } catch (IOException ex) {
              Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    }
    
}
