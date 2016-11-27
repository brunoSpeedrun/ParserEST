/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mosaicosolutions.ParserEST;

import java.io.File;

/**
 * Class que representa o arquivo que esta sendo manipulado pelo JTextEditor.
 * @author johnnysmartins
 */
public class FileContext {
    private File currentFile;
    private boolean fileSaved;
    public static final String DEFAUL_FILE_NAME = "untitled";
    
    public FileContext () {
        this.currentFile = null;
        this.fileSaved = false;
    }
    
    public boolean isFileDefined(){
        return !(currentFile == null);
    }
    
    public String getCurrentFileName() {
        return currentFile.getName();
    }
    /**
     * @return the currentFile
     */
    public File getCurrentFile() {
        return currentFile;
    }

    /**
     * @param currentFile the currentFile to set
     */
    public void setCurrentFile(File currentFile) {
        this.currentFile = currentFile;
    }

    /**
     * @return the fileSaved
     */
    public boolean isFileSaved() {
        return fileSaved;
    }

    /**
     * @param fileSaved the fileSaved to set
     */
    public void setFileSaved(boolean fileSaved) {
        this.fileSaved = fileSaved;
    }
    
    
}
