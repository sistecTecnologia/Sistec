/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.Cadastro.Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistec.bean.Usuario;
import sistec.dao.usuarioDao;
import sistec.visao.UsuarioCadastro;
import sistec.visao.UsuarioCons;

/**
 *
 * @author CASSIO JUNIOR
 */
public class usuariosControler implements ActionListener {

    Usuario usuario = new Usuario();
    UsuarioCons usuCons = new UsuarioCons(new javax.swing.JFrame(), true);
    UsuarioCadastro usoCad = new UsuarioCadastro(new javax.swing.JFrame(), true);
    private List<Usuario> lstUsuario = new ArrayList<>();

    public usuariosControler() throws Exception {
        consultarUsuarios();
        usuCons.addActionLister(this);
        usuCons.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "NovoUsuario":
                novoUsuario();
                break;
            case "salvarUsuario": {
                try {
                    salvarUsuario();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                break;
            }
            case "Alterar": {
                try {
                    alterarUsuario();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            break;
        }
    }

    private void alterarUsuario() throws Exception {
        usuario = new Usuario();
        usuario = usuCons.getUsuarioSelecionado();
        usoCad.setUsuario(usuario);
        usoCad.setVisible(true);

    }

    private void consultarUsuarios() throws Exception {
        lstUsuario.clear();
        new usuarioDao().getListaUsuario(lstUsuario);
        usuCons.setList(lstUsuario);
    }

    private void salvarUsuario() throws Exception {
        usuario = new Usuario();
        usuario = usoCad.getUsuario();
        new usuarioDao().salvarUsuario(usuario);
        usoCad.dispose();
        consultarUsuarios();

    }

    private void novoUsuario() {
        usoCad.addActionListener(this);
        usoCad.limparCampos();
        usoCad.setVisible(true);
    }

}
