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
    
      public static String readdir(String directoryName){
        File folder = new File(directoryName);
        File[] listOfFiles = folder.listFiles();
        String wawa=null;
        if(listOfFiles.length!=0){
            wawa=listOfFiles[0].getName();
        for(int i= 1;i<listOfFiles.length;i++){
            wawa=wawa+"\n"+listOfFiles[i].getName();//belum diubah ke Output Stream
        }
        return wawa;
        }
        else{
            return "None";
        }
    }
    
    public static String makedir(String directoryName){
        File dir = new File(directoryName);
        dir.mkdir();
        return "Directory has been built";
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
              String papa=null;
              os.write("Program Started".getBytes());
              os.flush();
              
              
              while(true){
                  buf=new byte[64];
                  is.read(buf);
                 String kk= new String(buf);
                 System.out.print(kk);
                  if("l".equals(kk.substring(0,1))){
                  papa=readdir(dir);
              }
            else if("c".equals(kk.substring(0,1))){
                        if(":".equals(kk.substring(4,5))){
                            dir=kk.substring(3);
                        }
                        else if("..".equals(kk.substring(3,5))){
                            int aaa=dir.lastIndexOf("/");
                            dir=dir.substring(0,aaa);
                        }
                        else{
                            dir=dir+"/"+kk.substring(3);
                         }
                  papa=dir;
              }
              else if("m".equals(kk.substring(0,1))){
                  dir=dir+kk.substring(6);
                  papa=makedir(dir);
              }
              else if("e".equals(kk.substring(0,1))){
                  os.close();
                  is.close();
                  sock.close();
                  ss.close();
                  break;
              }
              else{
                  papa="Error::Command not found";
              }
              System.out.print(papa);
              os.write(papa.getBytes());
              os.flush();
        
              }
          } catch (IOException ex) {
              Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    }
    
}
