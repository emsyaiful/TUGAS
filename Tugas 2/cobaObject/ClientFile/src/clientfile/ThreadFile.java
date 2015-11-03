/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientfile;

import ObjectKirim.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Administrator
 */
public class ThreadFile implements Runnable{
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private FileSent FileMasuk;
    private String dir = "D:/UUL/Kuliah/Progjar/Download/";
    private DefaultListModel listModel;
    public ThreadFile(Socket socket, DefaultListModel listModel) throws IOException {
        this.ois = new ObjectInputStream(socket.getInputStream());
        this.listModel = listModel;
    }
    
    @Override
    public void run() {
        try {
            File fFile;
            FileOutputStream fos = null;
            byte[] bytefile;
            Object o;
            while((o = this.ois.readObject())!=null) {
                if (o instanceof FileSent) {
                    FileMasuk = (FileSent) o;
                    if (FileMasuk.getCommand().equals("downloadStarted")) {
                        if (FileMasuk.getArgument().equals("START")) {
                            String temp = dir+FileMasuk.getNamaFile();
                            fFile=new File(temp);
                            bytefile= new byte[10240];
                            fos = new FileOutputStream(fFile);
                            fos.write(FileMasuk.getFile());
                            System.out.println(FileMasuk.getFile());
                        }else if (FileMasuk.getArgument().equals("FIN")) {
                            fos.close();
                        }  else {
                            fos.write(FileMasuk.getFile());
                            System.out.println(FileMasuk.getFile());
                        }
                    }
                    else if (FileMasuk.getCommand().equals("responseList")) {
                        for (int i = 0; i < FileMasuk.getAllFiles().size() ; i++) {
                            listModel.addElement(FileMasuk.getAllFiles().get(i));
                        }
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ThreadFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThreadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
