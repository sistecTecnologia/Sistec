/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteis;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JTextField;

/**
 *
 * @author SERVIDOR
 */
public class Uteis {

    public static void main(String[] args) {
        System.out.println(getDouble2Decimais(11.00));
    }

    public void validarJtxfield(JTextField jtextField, String nomeCampo) throws Exception {
        if (jtextField.getText() == null || jtextField.getText().equals("")) {
            throw new Exception(nomeCampo + " Obrigatorio");

        }
    }

    public static double getFloat4Decimais(double valor) {
        return Float.valueOf(String.format("%.4f", valor).replaceAll("\\.", "").replaceAll(",", "\\."));
    }

    public static double getDouble3Decimais(double valor) {
        return Double.valueOf(String.format("%.3f", valor).replaceAll("\\.", "").replaceAll(",", "\\."));

    }

    public static double getDouble2Decimais(double valor) {
        return Double.valueOf(String.format("%.2f", valor).replaceAll("\\.", "").replaceAll(",", "\\."));
    }

    public static double getDouble2Decimais(String valor) {
        return Double.valueOf(String.format("%.2f", Uteis.parseDouble(valor)).replaceAll("\\.", "").replaceAll(",", "\\."));
    }

    public static double parseDouble(String valor) {
        if (valor == null) {
            return 0.00;
        }
        if (valor.isEmpty()) {
            return 0.00;
        }
        valor = validaIsNumerico(valor);
        if (!valor.contains(",")) {
            return Double.valueOf(valor);
        }
        return Double.parseDouble(valor.replaceAll("\\.", "").replaceAll(",", "."));
    }

    public static String formatarMoeda(double valor) {
        if (Double.isNaN(valor) || Double.isInfinite(valor)) {
            valor = 0;
        }

        final Locale BRAZIL = new Locale("pt", "BR");
        final DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);
        final DecimalFormat DINHEIRO_REAL = new DecimalFormat("###,###,##0.00", REAL);

        return DINHEIRO_REAL.format(valor);
    }

    public static String validaIsNumerico(String dados) {
        if (dados.contains(",")) {
            dados = dados.replaceAll("\\.", "").replaceAll(",", ".");
        }
        try {
            Double.parseDouble(dados);
        } catch (NumberFormatException ex) {
            dados = "0.00";
        }
        return dados.replaceAll(",", "").replaceAll("\\.", ",");

    }

}
