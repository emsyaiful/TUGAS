/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author asus
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
    import java.io.IOException;
    import java.io.DataInputStream;
    import java.net.Socket;
    import java.io.InputStream;
    import java.io.OutputStream;
    import java.lang.Exception;
    import java.util.Scanner;
/**/
public class Client {


     /* @param args the command line arguments
     */

    /**
     *
     * @param args
     * @throws IOException
     */
    
    public static void main(String[] args) throws IOException
    {
        DataInputStream is = new DataInputStream(System.in);
        try
        {
            Scanner scan=new Scanner(System.in);
            byte[] buf=new byte[200];
        Socket Listener = new Socket("localhost",5000);
        
        BufferedInputStream istr= new BufferedInputStream(Listener.getInputStream());
        BufferedOutputStream ostr = new BufferedOutputStream(Listener.getOutputStream()) ;
        String kak;
            istr.read(buf);
            System.out.println(new String(buf));
            
            while(true){
                int len;
                kak=scan.nextLine();
                System.out.println(kak);
                ostr.write(kak.getBytes());
                ostr.flush();
                if("exit".equals(kak)){
                    ostr.close();
                    istr.close();
                    Listener.close();
                            
                    break;
                }
                buf = new byte[200];
                while ((len = istr.read(buf)) > 0) {
                    System.out.println(len);
                    System.out.print(new String(buf));
                }
                //System.out.println(len);
                //System.out.println("exit loop read");
            }
        }
        catch(Exception e)
                {
                    System.out.println(e);
        }
    }//
}