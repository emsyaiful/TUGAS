/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    
    public static String opef(String Filepath){
        String kk="";
        byte[] buffer = new byte[10];
        BufferedInputStream bis;
        try {
            bis = new BufferedInputStream(new FileInputStream(Filepath));
            while(true){
                buffer=new byte[10];
            int olol=bis.read(buffer);
            kk=kk+new String(buffer);
            if(olol==-1){
                break;
            }
            }
            bis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kk;
    }
    
    
    
      public static String readdir(String directoryName){
        File folder = new File(directoryName);
        File[] listOfFiles = folder.listFiles();
        String wawa=null;
        if(listOfFiles.length!=0){
            wawa = listOfFiles[0].getName();
        for(int i = 1;i<listOfFiles.length;i++){
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
              BufferedInputStream is = new BufferedInputStream(sock.getInputStream());
              BufferedOutputStream os = new BufferedOutputStream(sock.getOutputStream());
              String dir = "D:/UUL/";
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
                  papa=readdir(dir) + '\n';
                  System.out.println(papa);
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
                            dir=dir+"/"+kk.substring(3)+ '\n';
                         }
                  papa=dir;
              }
              else if("m".equals(kk.substring(0,1))){
                  String[] split = kk.split("\\s+");
                  //split[1] = split[1].substring(0,split[1].length()-1);
                  dir=dir+kk.substring(6,9);
                  System.out.print(dir);
                  papa=makedir(dir);
              }
              else if("o".equals(kk.substring(0,1))){
                  String haha=dir+kk.substring(5);
                  papa=opef(haha) + '\n';
              }
              else if("e".equals(kk.substring(0,1))){
                  os.close();
                  is.close();
                  sock.close();
                  ss.close();
                  break;
              }
              else{
                  papa="Error::Command not found\n";
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
