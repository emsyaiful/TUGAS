/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverfile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author baskoro
 */
public class ServerFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket servsock = new ServerSocket(9988);
            System.out.println("Server mau berjalan ....");
            while(true) {
                Socket socket;
                socket = servsock.accept();
                ThreadFile tc = new ThreadFile(socket);
                Thread t = new Thread(tc);
                t.start();
            }
            //servsock.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
