/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siste.Controler;

import sistec.Cadastro.Controler.usuariosControler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sistec.Cadastro.Controler.clientesControler;
import sistec.Cadastro.Controler.empresaControler;
import sistec.Produto.Controler.produtosControler;
import sistec.bean.Empresa;
import sistec.visao.Menu;
import uteis.MetodosDeControler;

/**
 *
 * @author SERVIDOR
 */
public class menuControler extends MetodosDeControler implements ActionListener {

    Menu menuFrm = new Menu();
    Empresa empresa = new Empresa();

    public menuControler() throws Exception {

        menuFrm.addActionListtener(this);
        menuFrm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Usuario": {
                try {
                    usuarios();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            break;
            case "Produtos":
            {
                try {
                    produtos();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
                break;

            case "Empresa": {
                try {
                    empresa();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            break;
            case "Clientes":
        {
            try {
                clientes();
            } catch (Exception ex) {
                 JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
                break;
        }
    }

    private void clientes() throws Exception {
        new clientesControler();
    }

    private void empresa() throws Exception {
        new empresaControler();
    }

    private void usuarios() throws Exception {
        new usuariosControler();
    }

    private void produtos() throws SQLException {
        new produtosControler();
    }
}
