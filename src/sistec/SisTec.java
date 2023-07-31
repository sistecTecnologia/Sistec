/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import sistec.visao.LoginFrm;

/**
 *
 * @author SERVIDOR
 */
public class SisTec {

    public String ip;

    public String getIp() {
        try {
            String curDir = System.getProperty("user.dir");
            // diretorio do arquivo
            File arquivo = new File(curDir + "\\Options.txt");

            if (!arquivo.exists()) {
                int dialogButton = JOptionPane.showConfirmDialog(null, "Este e o servidor ?", "WARNING", JOptionPane.YES_NO_OPTION);
                if (dialogButton == JOptionPane.YES_OPTION) {

                    FileWriter fileWriter = new FileWriter(arquivo, false);
                    BufferedWriter escrever = new BufferedWriter(fileWriter);

                    arquivo.createNewFile();
                    escrever.write("127.0.0.1");
                    escrever.close();
                    fileWriter.close();
                } else {
                    String ip = JOptionPane.showInputDialog("Digite o Ip do Servidor:");

                    FileWriter fileWriter = new FileWriter(arquivo, false);
                    BufferedWriter escrever = new BufferedWriter(fileWriter);

                    arquivo.createNewFile();
                    escrever.write(ip);
                    escrever.close();
                    fileWriter.close();
                }
            }
//            File arquivo = new File("arquivo.txt");

            FileReader ler = new FileReader(arquivo);

            BufferedReader lerb = new BufferedReader(ler);

            String linha = lerb.readLine();

            while (linha != null) {
                ip = linha;
                linha = lerb.readLine();
            }

            //escrever aqruivo
//            FileWriter fileWriter = new FileWriter(arquivo);
//            BufferedWriter escrever = new BufferedWriter(fileWriter);
//            escrever.write(x + "");
//            escrever.close();
//            fileWriter.close();
//            try {
//                x = 1;
//                escrever.write(x + "");
//                escrever.close();
//                fileWriter.close();
//            } catch (Exception e) {
//                System.out.println("");
//            }
//            s = new ServerSocket(9581);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler Arquivo de Configuração ");
        }
        return ip;

    }

}
