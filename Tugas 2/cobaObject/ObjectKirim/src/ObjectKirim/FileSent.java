package ObjectKirim;


import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class FileSent implements Serializable {
    private String NamaFile;
    private String Ukuran;
    private byte[] File;
    private String command;
    private String argument;
    private ArrayList<String> AllFiles;
    /**
     * @return the NamaFile
     */
    public String getNamaFile() {
        return NamaFile;
    }

    /**
     * @param NamaFile the NamaFile to set
     */
    public void setNamaFile(String NamaFile) {
        this.NamaFile = NamaFile;
    }

    /**
     * @return the Ukuran
     */
    public String getUkuran() {
        return Ukuran;
    }

    /**
     * @param Ukuran the Ukuran to set
     */
    public void setUkuran(String Ukuran) {
        this.Ukuran = Ukuran;
    }

    /**
     * @return the File
     */
    public byte[] getFile() {
        return File;
    }

    /**
     * @param File the File to set
     */
    public void setFile(byte[] File) {
        this.File = File;
    }

    /**
     * @return the command
     */
    public String getCommand() {
        return command;
    }

    /**
     * @param command the command to set
     */
    public void setCommand(String command) {
        this.command = command;
    }

    /**
     * @return the argument
     */
    public String getArgument() {
        return argument;
    }

    /**
     * @param argument the argument to set
     */
    public void setArgument(String argument) {
        this.argument = argument;
    }

    /**
     * @return the AllFiles
     */
    public ArrayList<String> getAllFiles() {
        return AllFiles;
    }

    /**
     * @param AllFiles the AllFiles to set
     */
    public void setAllFiles(ArrayList<String> AllFiles) {
        this.AllFiles = AllFiles;
    }
}

