/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mosaicosolutions.ParserEST;

import br.com.mosaicosolutions.ParserEST.UI.JFontChooser;
import br.com.mosaicosolutions.parser.ParseException;
import br.com.mosaicosolutions.parser.Parser;
import br.com.mosaicosolutions.parser.TokenMgrError;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/**
 * JFrame Principal do programa.
 * @author BrunoXavier
 */
public class MainJFrame extends javax.swing.JFrame {

    //Sobre
    private About about;
    //Armazena o arquivo atual do editor.
    private FileContext fileContext;
    //Dialogo para abrir arquivo.
    private JFileChooser fileChooserOpenFile;
    //Dialogo para salvar arquivo.
    private JFileChooser fileChooserSaveFile;
    
    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();
        initFields();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneTextEditor = new javax.swing.JScrollPane();
        textEditor = new br.com.mosaicosolutions.ParserEST.UI.JTextEditor();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemNewFile = new javax.swing.JMenuItem();
        jMenuItemOpenFile = new javax.swing.JMenuItem();
        jMenuItemSaveFile = new javax.swing.JMenuItem();
        jMenuItemSaveFileAs = new javax.swing.JMenuItem();
        jSeparator = new javax.swing.JPopupMenu.Separator();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMenuEdit = new javax.swing.JMenu();
        jMenuItemEditFont = new javax.swing.JMenuItem();
        jMenuParser = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuHelp = new javax.swing.JMenu();
        jMenuAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parser EST");
        setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        setMinimumSize(null);
        setSize(new java.awt.Dimension(625, 465));

        textEditor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textEditorKeyPressed(evt);
            }
        });
        jScrollPaneTextEditor.setViewportView(textEditor);

        jMenuFile.setText("File");

        jMenuItemNewFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemNewFile.setText("New");
        jMenuItemNewFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNewFileActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemNewFile);

        jMenuItemOpenFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemOpenFile.setText("Open");
        jMenuItemOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenFileActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemOpenFile);

        jMenuItemSaveFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSaveFile.setText("Save");
        jMenuItemSaveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveFileActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemSaveFile);

        jMenuItemSaveFileAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSaveFileAs.setText("Save As...");
        jMenuItemSaveFileAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveFileAsActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemSaveFileAs);
        jMenuFile.add(jSeparator);

        jMenuItemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemExit.setText("Exit");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemExit);

        jMenuBar.add(jMenuFile);

        jMenuEdit.setText("Edit");

        jMenuItemEditFont.setText("Font");
        jMenuItemEditFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditFontActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemEditFont);

        jMenuBar.add(jMenuEdit);

        jMenuParser.setText("Parser");
        jMenuParser.setName("jMenuParser"); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Start Parser");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuParserActionPerformed(evt);
            }
        });
        jMenuParser.add(jMenuItem1);

        jMenuBar.add(jMenuParser);

        jMenuHelp.setText("Help");
        jMenuHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuHelpActionPerformed(evt);
            }
        });

        jMenuAbout.setText("About");
        jMenuAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAboutActionPerformed(evt);
            }
        });
        jMenuHelp.add(jMenuAbout);

        jMenuBar.add(jMenuHelp);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneTextEditor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneTextEditor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textEditorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textEditorKeyPressed
        // TODO add your handling code here:
        setUnsavedFileTitle();
        fileContext.setFileSaved(false);
    }//GEN-LAST:event_textEditorKeyPressed

    private void jMenuItemNewFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNewFileActionPerformed
        // TODO add your handling code here:
        main(null);    
    }//GEN-LAST:event_jMenuItemNewFileActionPerformed

    private void jMenuParserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuParserActionPerformed
        // TODO add your handling code here:
        try{
            if(textEditor.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Você não digitou nada", "atencão", JOptionPane.WARNING_MESSAGE);
            }else{
                this.startParser();
                JOptionPane.showMessageDialog(this, "Parser executado com sucesso !", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(ParseException | TokenMgrError ex){
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuParserActionPerformed

    private void jMenuItemEditFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditFontActionPerformed
        // TODO add your handling code here:
        JFontChooser fontChooser = new JFontChooser();
        int result = fontChooser.showDialog(this);
        if (result == JFontChooser.OK_OPTION)
        {
           textEditor.setFont(fontChooser.getSelectedFont());
        }
    }//GEN-LAST:event_jMenuItemEditFontActionPerformed

    private void jMenuHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuHelpActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenuHelpActionPerformed

    private void jMenuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAboutActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, about.toString(), "About", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuAboutActionPerformed

    private void jMenuItemOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenFileActionPerformed
        // TODO add your handling code here:
        try{
            if(fileContext.isFileSaved() || isTextEditorEmpty()){
               
               openFile();
               
            }else{
                
                saveBeforeOpeningTheFile();
                openFile();
            }
        }catch (IOException ex){
            JOptionPane.showMessageDialog(this, "Erro ao tentar carregar o arquivo", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemOpenFileActionPerformed

    private void jMenuItemSaveFileAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveFileAsActionPerformed
        // TODO add your handling code here:
        try{                                   
            saveAs();
                
        }catch (IOException ex){
            JOptionPane.showMessageDialog(this, "Erro ao salvar o arquivo.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemSaveFileAsActionPerformed

    private void jMenuItemSaveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveFileActionPerformed
        // TODO add your handling code here:
        try {
            if(fileContext.isFileDefined()){
                saveCurrentFile();
            }else{
                saveAs();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar o arquivo.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemSaveFileActionPerformed

    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
        // TODO add your handling code here:
        try {
            if(isTextEditorEmpty() || fileContext.isFileSaved()){
                exit();
            }else{
                if(fileContext.isFileDefined()){
                   saveCurrentFile();
                }else{
                   saveAs(); 
                }                
                exit();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar o arquivo.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemExitActionPerformed

    /**
     * Ponto de entrada do programa.
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainJFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuAbout;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemEditFont;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemNewFile;
    private javax.swing.JMenuItem jMenuItemOpenFile;
    private javax.swing.JMenuItem jMenuItemSaveFile;
    private javax.swing.JMenuItem jMenuItemSaveFileAs;
    private javax.swing.JMenu jMenuParser;
    private javax.swing.JScrollPane jScrollPaneTextEditor;
    private javax.swing.JPopupMenu.Separator jSeparator;
    private br.com.mosaicosolutions.ParserEST.UI.JTextEditor textEditor;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Inicializa os atributos.
     */
    private void initFields() {
        about = new About();
        fileContext = new FileContext();
        setTitle(about.getProgramName() + " - " + FileContext.DEFAUL_FILE_NAME);
        
        fileChooserOpenFile = new JFileChooser();
        fileChooserOpenFile.setDialogType(JFileChooser.OPEN_DIALOG);
        fileChooserOpenFile.setFileFilter(new ESTFileFilter());
        
        fileChooserSaveFile = new JFileChooser(new File("/home/me/Documents"));
        fileChooserSaveFile.setDialogType(JFileChooser.SAVE_DIALOG);
    }
    
    /**
     * Define o título como não salvo.
     */
    private void setUnsavedFileTitle() {
        if(fileContext.isFileDefined()){
            setTitle(about.getProgramName() + " - " + fileContext.getCurrentFileName() + " *");
        }else{
            setTitle(about.getProgramName() + " - " + FileContext.DEFAUL_FILE_NAME + " *");
        }
    }
    
    /**
     * Inicializa a análise sintatica com o texto do {@link MainJFrame#textEditor}
     * @throws TokenMgrError  Se for encontrado algum token iválido durante a análise.
     * @throws ParseException Se ocorrer algum erro durante a análise.
     */
    private void startParser() throws TokenMgrError, ParseException {
        Parser parser = new Parser(new StringReader(textEditor.getText()));
        parser.Start();
    }

    /**
     * Carrega o editor de texto a partir de um arquivo.
     * @param selectedFile O arquivo que será carregado no editor.
     * @throws IOException Se o arquivo não existir.
     */
    private void loadTextEditor(File selectedFile) throws IOException {
        try(BufferedReader buffer = new BufferedReader(new FileReader(selectedFile))){
            StringBuilder result = new StringBuilder();
            while(buffer.ready()){
                result.append(buffer.readLine());
            }
            textEditor.setText(result.toString());
        }
    }
    
    /**
     * Método chamado antes do dialogo abrir arquivo. Este método é chamado quando
     * o programa vai abrir o arquivo, porém o arquivo atual não esta salvo.
     * @throws IOException Se o arquivo não existir.
     */
    private void saveBeforeOpeningTheFile() throws IOException {
        
        int dialogResult = JOptionPane.showConfirmDialog(this, "Deseja Salvar o arquivo Atual");
        
        if(dialogResult == JOptionPane.YES_OPTION){
            if(fileContext.isFileDefined()) {
                saveCurrentFile();
                fileContext.setFileSaved(true);
                updateTitle();
            }
            else {
                saveAs(); 
            }
        }
    }
    
    /**
     * Salva o arquivo atual.
     * @throws IOException Se o arquivo não existir.
     */
    private void saveCurrentFile() throws IOException {
        saveInFile(fileContext.getCurrentFile());
        fileContext.setFileSaved(true);
        updateTitle();
    }
    
    /**
     * Salvar Como...
     * @throws IOException Se o arquivo não existir.
     */
    private void saveAs() throws IOException {
        if(fileChooserSaveFile.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
            saveInFile(fileChooserSaveFile.getSelectedFile());
            fileContext.setCurrentFile(fileChooserSaveFile.getSelectedFile());
            fileContext.setFileSaved(true);
            updateTitle();
        }   
    }
    
    /**
     * Salva o texto do editor no arquivo especificado.
     * @param selectedFile O arquivo onde será salvo o texto do editor.
     * @throws IOException Se o arquivo não existir.
     */
    private void saveInFile(File selectedFile) throws IOException {
        try(BufferedWriter buffer = new BufferedWriter(new PrintWriter(new FileWriter(selectedFile)))){
            buffer.write(textEditor.getText());
        }
    }
    
    /**
     * Abre o arquivo e carrega seu conteúdo no editor.
     * @throws IOException 
     */
    private void openFile() throws IOException {
        if(fileChooserOpenFile.showDialog(this, "Open") == JFileChooser.APPROVE_OPTION){
            loadTextEditor(fileChooserOpenFile.getSelectedFile());
            fileContext.setCurrentFile(fileChooserOpenFile.getSelectedFile());
            fileContext.setFileSaved(true);
            updateTitle();
        }
    }
    
    /**
     * Testa se o editor está vazio.
     * @return true, se não houver nada no escrito no editor, caso contrário false.
     */
    private boolean isTextEditorEmpty() {
        return textEditor.getText().isEmpty();
    }
    
    /**
     * Atualiza o título do programa. 
     */
    private void updateTitle() {
        setTitle(about.getProgramName() + " - " + fileContext.getCurrentFileName());
    }
    private void exit() {
        int result = JOptionPane.showConfirmDialog(this,
        "Você realmente quer sair ?",
        "Confirm Quit", JOptionPane.YES_NO_CANCEL_OPTION);
        System.exit(0);
    }
}
