
package br.com.mosaicosolutions.ParserEST;

import java.io.File;
import javax.swing.filechooser.FileFilter;


/**
 * Classe que representa um filtro para os arquivos .txt e .est 
 * @author BrunoXavier
 */
public class ESTFileFilter extends FileFilter{

    @Override
    public boolean accept(File f){
       return (f.getName().endsWith(".txt")) || f.getName().endsWith(".est") || f.isDirectory();
    }
    
    @Override
    public String getDescription(){
        return ".est | .txt";
    }
}
