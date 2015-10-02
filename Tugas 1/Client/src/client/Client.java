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

    import java.io.IOException;
    import java.io.DataInputStream;
    import java.net.Socket;
    import java.lang.Exception;
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
        Socket Listener = new Socket("localhost",5000);
        }
        catch(Exception e)
                {
                    System.out.println(e);
        }
    }
}