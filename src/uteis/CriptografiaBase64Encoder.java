/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uteis;

import java.util.Base64;

/**
 *
 * @author Dev
 */
public class CriptografiaBase64Encoder {

    public static String criptografiaBase64Encoder(String textoValor) {
        return new String(Base64.getEncoder().encode(textoValor.getBytes()));
    }

    public static String descriptografiaBase64Decode(String textoValor) {
        return new String(Base64.getDecoder().decode(textoValor.getBytes()));
    }
}
