/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverfile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ObjectKirim.*;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 *
 * @author baskoro
 */
public class ThreadFile implements Runnable {
    private final Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    
    public ThreadFile(Socket socket) throws IOException {
        this.oos = new ObjectOutputStream(socket.getOutputStream());
        this.ois = new ObjectInputStream(socket.getInputStream());
        this.socket = socket;
        System.out.println("objek created");
        
    }
    
    @Override
    public void run() {
        Object o;
        //Thread t=new Thread(new Runnable);
        String dir = "D:/UUL/Kuliah/Progjar/";
        FileSent FileMasuk = new FileSent();
        try {
            System.out.println("Klien baru datang ....");
            byte[] buf = new byte[50];
            String strbuf = new String(buf);
            FileOutputStream fos =null;
            byte[] bytefile;
            while((o = this.ois.readObject())!=null) {
                if (o instanceof FileSent) {
                    FileMasuk = (FileSent) o;
                    FileSent FileKeluar = new FileSent();
                    if (FileMasuk.getCommand().equals("download")) {
                        String temp = dir+FileMasuk.getNamaFile();
                        File fFile = new File(temp);
                        bytefile= new byte[1024];
                        int byteread;
                        FileInputStream fis=new FileInputStream(fFile);
                        FileKeluar.setArgument("START");
                        FileKeluar.setNamaFile(FileMasuk.getNamaFile());
                        FileKeluar.setCommand("downloadStarted");
                        while((byteread=fis.read(bytefile))>=0)
                        {
                            FileKeluar.setFile(bytefile);
                            oos.writeObject(FileKeluar);
                            oos.flush();
                            oos.reset();
                            System.out.println(bytefile);
                            FileKeluar.setArgument("running");
                        }
                        FileKeluar.setArgument("FIN");
                        oos.writeObject(FileKeluar);
                        oos.flush();
                        oos.reset();
                    }else if (FileMasuk.getCommand().equals("upload")) {
                        if (FileMasuk.getArgument().equals("START")) {
                            String temp = dir+FileMasuk.getNamaFile();
                            File fFile = new File(temp);
                            bytefile= new byte[1024];
                            fos = new FileOutputStream(fFile);
                            fos.write(FileMasuk.getFile());
                        }else if (FileMasuk.getArgument().equals("FIN")) {
                            fos.close();
                        } else{
                            fos.write(FileMasuk.getFile());
                        }
                    }else if (FileMasuk.getCommand().equals("list")) {
                        ArrayList<String> dummy = new ArrayList<>();
                        File folder = new File(dir);
                        File[] listOfFiles = folder.listFiles();
                            for (int i = 0; i < listOfFiles.length; i++) {
                              if (listOfFiles[i].isFile()) {
                                //System.out.println("File " + listOfFiles[i].getName());
                                dummy.add(listOfFiles[i].getName());
                              } else if (listOfFiles[i].isDirectory()) {
                                //System.out.println("Directory " + listOfFiles[i].getName());
                              }
                            }
                        FileKeluar.setAllFiles(dummy);
                        FileKeluar.setCommand("responseList");
                        oos.writeObject(FileKeluar);
                        oos.flush();
                        oos.reset();
                    }
                }
            }
            
            oos.close();
            ois.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ThreadFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThreadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
