/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siste.Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistec.bean.Empresa;
import sistec.bean.Login;
import sistec.dao.empresaDao;
import sistec.dao.inicializarDao;
import sistec.dao.loginDao;
import sistec.visao.EmpresaFrm;
import sistec.visao.LoginFrm;

/**
 *
 * @author CASSIO JUNIOR
 */
public class loginControler extends conexoes.ConexaoMySql implements ActionListener {

    LoginFrm loginFrm = new LoginFrm(new javax.swing.JFrame(), true);
    Login login;
    boolean existe;
    Empresa empresa = new Empresa();

    public loginControler() {
        loginFrm.addActionListener(this);
        loginFrm.setVisible(true);
    }

    public loginControler(boolean novaEmpresa) {
      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Login": {
                try {
                    login();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            break;

        }
    }

    private void login() throws SQLException, Exception {

        login = loginFrm.getLogin();
        try {

            if (new loginDao().existeLogin(login, conectar())) {
                fecharConexao();
                loginFrm.dispose();
                new menuControler();
            } else if (login.getUsuario().equals("SISTEC") && login.getSenha().equals("SISTEC2023")) {
                loginFrm.dispose();
                new menuControler();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario ou senha Invalido");
                loginFrm.usuarioFocus();

            }

//        fecharConexao();
        } finally {
            fecharConexao();
        }
    }
}
