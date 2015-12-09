/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplebrowser;

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
public class SimpleBrowser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int redirect=0;
        String address="";
        while(true){
            try {
                if(redirect==0){
                Scanner scan=new Scanner(System.in);
                address=scan.nextLine();
                }
                System.out.println(address);
                int a=address.indexOf("//");
                String address2=address.substring(a+2);
                a=0; a=address2.indexOf("/");
                String file=address2.substring(a);
                address2=address2.substring(0,a);
                
                Socket s=new Socket(address2,80);
                InputStream is=s.getInputStream();
                OutputStream os=s.getOutputStream();
            
                String header=
                        "GET "+file+" HTTP/1.1\r\n" +
                        "Host: "+address2+"\r\n"+"\r\n";
                
                os.write(header.getBytes());
                os.flush();
                String isi="";
                int aa=0;
                while(aa!=-1){
                    byte[] buff=new byte[30];
                    aa=is.read(buff);
                    isi=isi + new String(buff);
                }
                String[] ha=isi.split("\r\n\r\n", 2);
                
                if(ha[0].indexOf("location ")!=-1){
                    System.out.println(ha[0]);
                    a=0;a=ha[0].indexOf("location ");
                    String la=ha[0].substring(a+9);
                    String[] newfile=la.split("\r\n",2);
                    address=address+newfile[0];
                    //System.out.println(newfile[0]);
                    redirect=1;
                }
                else if(ha[0].indexOf("url=")!=-1){
                    System.out.println(ha[0]);
                    a=0;a=ha[0].indexOf("url=");
                    String la=ha[0].substring(a+4);
                    String[] newaddress=la.split("\r\n",2);
                    address=newaddress[0];
                    redirect=1;
                }
                else{
                    System.out.println(ha[1]);
                    redirect=0;
                }
                
                is.close();
                os.close();
                s.close();
            } catch (IOException ex) {
                Logger.getLogger(SimpleBrowser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
