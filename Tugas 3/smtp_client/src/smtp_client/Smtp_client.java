/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smtp_client;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author UUL
 */
public class Smtp_client {

    /**
     * @param args the command line arguments
     */
            
    public static void main(String[] args) throws IOException {
        GUI_client gClient = new GUI_client();
        gClient.setVisible(true);
    }
}
