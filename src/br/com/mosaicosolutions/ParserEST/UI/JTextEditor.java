/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mosaicosolutions.ParserEST.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

/**
 * 
 * @author BrunoXavier
 */
public class JTextEditor extends javax.swing.JTextPane {
    
    public static final Font DEFAULT_FONT = new Font("Consolas", Font.PLAIN, 18);

    private UndoManager undoManager;

    public JTextEditor() {
        super();
        initComponents();
    }

    private void initComponents() {
        this.undoManager = new UndoManager();
        setDocument(new SyntaxHighlighterDocument(undoManager));
        
        InputMap  inputMap  = getInputMap(JComponent.WHEN_FOCUSED);
        ActionMap actionMap = getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "Undo");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Y, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "Redo");

        actionMap.put("Undo", new UndoAction());
        
        actionMap.put("Redo", new RedoAction());
        
        setFont(JTextEditor.DEFAULT_FONT);
    }
    
    class SyntaxHighlighterDocument extends DefaultStyledDocument{

        public SyntaxHighlighterDocument(UndoManager undoManager) {
            this.undoManager = undoManager;
            addUndoableEditListener((e) -> { this.undoManager.addEdit(e.getEdit()); });
        }
    
        @Override
        public void insertString (int offset, String str, AttributeSet a) throws BadLocationException {
        super.insertString(offset, str, a);

        String text = getText(0, getLength());
        int before = findLastNonWordChar(text, offset);
        if (before < 0) before = 0;
        int after = findFirstNonWordChar(text, offset + str.length());
        int wordL = before;
        int wordR = before;

        while (wordR <= after) {
            if (wordR == after || String.valueOf(text.charAt(wordR)).matches("\\W")) {
                if (text.substring(wordL, wordR).matches("(\\W)*(procedure|is|real|code|endcode)"))
                    setCharacterAttributes(wordL, wordR - wordL, attr, false);
                else
                    setCharacterAttributes(wordL, wordR - wordL, attrBlack, false);
                wordL = wordR;
            }
            wordR++;
        }
    }

        @Override
        public void remove (int offs, int len) throws BadLocationException {
        super.remove(offs, len);

        String text = getText(0, getLength());
        int before = findLastNonWordChar(text, offs);
        if (before < 0) before = 0;
        int after = findFirstNonWordChar(text, offs);

        if (text.substring(before, after).matches("(\\W)*(procedure|is|real|code|endcode)")) {
            setCharacterAttributes(before, after - before, attr, false);
        } else {
            setCharacterAttributes(before, after - before, attrBlack, false);
        }
    }
    
        private int findLastNonWordChar (String text, int index) {
            while (--index >= 0) {
                if (String.valueOf(text.charAt(index)).matches("\\W")) {
                    break;
                }
            }
            return index;
        }

        private int findFirstNonWordChar (String text, int index) {
            while (index < text.length()) {
                if (String.valueOf(text.charAt(index)).matches("\\W")) {
                    break;
                }
                index++;
            }
            return index;
        }
    
        final StyleContext styleContext = StyleContext.getDefaultStyleContext();
        final AttributeSet attr = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, Color.BLUE);
        final AttributeSet attrBlack = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, Color.BLACK);
        final UndoManager undoManager;
    }
    
    class UndoAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (undoManager.canUndo()) 
                    undoManager.undo();
                    
            } catch (CannotUndoException exp) {
            }
        }
        
    }
    
    class RedoAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (undoManager.canRedo()) 
                    undoManager.redo();
                
            } catch (CannotUndoException exp) {
            }
        }
        
    }
    
}
