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
 * @author CASSIO JUNIOR
 */
public class UpperCaseLimitado  extends PlainDocument{
        int maximo;

    public UpperCaseLimitado(int max) { 
        maximo = max;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if ((getLength() + str.length()) <= maximo) {
            super.insertString(offs, removeAcentos(str.toUpperCase()), a);
        }
    }
    public static String removeAcentos(String acentos) {
        return removeAcentosNome(acentos, true);
    }
     private static String removeAcentosNome(String acentos, boolean removerAspas) {
        //letras minusculas
        acentos = acentos.replaceAll("[èéêë]", "e");
        acentos = acentos.replaceAll("[╔]", "e");
        acentos = acentos.replaceAll("[úùûü]", "u");
        acentos = acentos.replaceAll("[ííïîì]", "i");
        acentos = acentos.replaceAll("[àâãáã]", "a");
        acentos = acentos.replaceAll("┴", "a");
        acentos = acentos.replaceAll("ƒ", "");
        acentos = acentos.replaceAll("�", "");
        acentos = acentos.replaceAll("\\┴", "a");
        acentos = acentos.replaceAll("\\┬", "a");
        acentos = acentos.replaceAll("\\├", "a");
        acentos = acentos.replaceAll("\\┤", " ");
        acentos = acentos.replaceAll("[óòõôö]", "o");
        acentos = acentos.replaceAll("[ç‡]", "c");

        //letras maiusculas    
        acentos = acentos.replaceAll("[ÈÉÊË]", "E");
        acentos = acentos.replaceAll("[ÛÙÚ]", "U");
        acentos = acentos.replaceAll("[ÍÏÎÌ]", "I");
        acentos = acentos.replaceAll("[ÀÂÃÁ]", "A");
        acentos = acentos.replaceAll("[ÔÓÕÒ]", "O");
        acentos = acentos.replaceAll("[Ç€‡]", "C");
        acentos = acentos.replaceAll("├O:", "o");
        acentos = acentos.replaceAll("[ºª¹²³£¢¬°]", ":");
        acentos = acentos.replaceAll("Ã", "");
        acentos = acentos.replaceAll("Â", "");
        acentos = acentos.replaceAll("�", "");
        acentos = acentos.replaceAll("´", "");
        if (removerAspas) {
            acentos = acentos.replaceAll("['\"]", "");
        }
        return acentos;
    }
}
