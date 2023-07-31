/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistecIniti;

import javax.swing.JOptionPane;
import siste.Controler.loginControler;
import sistec.Cadastro.Controler.empresaControler;
import sistec.bean.Empresa;
import sistec.dao.inicializarDao;
import uteis.MetodosDeControler;

/**
 *
 * @author CASSIO JUNIOR
 */
public class main extends MetodosDeControler {

    public static void main(String args[]) {

        int versaoSistema = 1;
        System.out.println("teste");
        try {
//            new inicializarDao().criarBanco();
//            new sistec.SisTec();
            //verifica se existe o banco de dados
            if (!new inicializarDao().sistecIsExiste()) {
                new inicializarDao().criarBanco();

                new empresaControler();
                System.exit(0);
                return;
            }
            new inicializarDao().criaUsuario();
            // verifica se existe empresa cadastrada
            if (!new inicializarDao().empresaExiste()) {
                new empresaControler(true);
                System.exit(0);
            } else {
                // atualizaca o sistema
                new inicializarDao().atualizarTabela();
                // inicia o sistema
                new loginControler();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

}
