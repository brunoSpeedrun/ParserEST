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
    
    /**
     * Inicializa uma nova instância de FileContext.
     */
    public FileContext () {
        this.currentFile = null;
        this.fileSaved = false;
    }
    
    /**
     * Método que testa se o arquivo foi definido.
     * @return true, se o arquivo foi definido, caso contrátio false.
     */
    public boolean isFileDefined(){
        return !(currentFile == null);
    }
    
    /**
     * Retorna o nome do arquivo atual.
     * @return O nome do arquivo atual, ou uma string vazia caso o arquivo não esteja definido.
     */
    public String getCurrentFileName() {
        return isFileDefined() ? currentFile.getName() : "";
    }
    
    
    /**
     * Obtém o arquivo atual.
     * @return the currentFile
     */
    public File getCurrentFile() {
        return currentFile;
    }

    /**
     * Define o arquivo atual.
     * @param currentFile the currentFile to set
     */
    public void setCurrentFile(File currentFile) {
        this.currentFile = currentFile;
    }

    /**
     * Método que testa se o arquivo atual está salvo.
     * @return true, se o arquivo estiver salvo, caso contrário false.
     */
    public boolean isFileSaved() {
        return fileSaved;
    }

    /**
     * Define se o arquivo atual esta salvo ou não
     * @param fileSaved the fileSaved to set
     */
    public void setFileSaved(boolean fileSaved) {
        this.fileSaved = fileSaved;
    }
    
    
}
