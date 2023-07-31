/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteis;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author SERVIDOR
 */
public class UpperCaseParaNumerico extends PlainDocument {

    int maximo;

    public UpperCaseParaNumerico(int max) {
        maximo = max;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if ((getLength() + str.length()) <= maximo) {
            super.insertString(offs, isNumericos(str.toUpperCase()), a);
        }
    }

    private String isNumericos(String valores) {
        try {
            Integer.parseInt(valores.substring((valores.length() - 1), valores.length()));
        } catch (NumberFormatException ex) {
            valores = valores.substring(0, (valores.length() - 1));
        }
        return valores;
    }
}
