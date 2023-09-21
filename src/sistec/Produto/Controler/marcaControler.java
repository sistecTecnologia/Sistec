/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.Produto.Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistec.bean.produto.Marca;
import sistec.Produto.Dao.marcaDao;
import sistec.visao.Produto.MarcaCons;
import uteis.MetodosDeControler;

/**
 *
 * @author SERVIDOR
 */
public class marcaControler extends MetodosDeControler implements ActionListener {

    MarcaCons marcaCons = new MarcaCons(new javax.swing.JFrame(), true);
    Marca marca;
    List<Marca> lstMarca;
    private final Marca marcaSelecionada;

    public marcaControler(Marca marca) throws SQLException {
        this.marcaSelecionada = marca;
        getListaMarca();
        marcaCons.desabilitarBotes(true, false, true, false);
        marcaCons.addActionListener(this);
        marcaCons.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {

            case "novaMarca":
                novaMarca();
                break;
            case "salvarMarca": {
                try {
                    salvarMarca();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            break;
            case "alterarMarca": {
                try {
                    alterarMarca();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            break;
            case "selecionarMarca": {
                try {
                    selecionarMarca();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            break;
            case "Excluir": {
                try {
                    excluirMarca();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }

    }

    private void excluirMarca() throws Exception {
        Marca marca = marcaCons.getMarcaSelecionado();
        inicializarConexaoBD();
        new marcaDao().excluirMarca(marca.getIdMarca(), conn);
        finalizarConexao();
        getListaMarca();
    }

    private void selecionarMarca() throws Exception {
        marcaSelecionada.setIdMarca(marcaCons.getMarcaSelecionado().getIdMarca());
        inicializarConexaoBD();
        new marcaDao().getMarcaSelecionada(marcaSelecionada, conn);
        finalizarConexao();
        marcaCons.dispose();

    }

    private void alterarMarca() throws Exception {
        marca = new Marca();
        marca = marcaCons.getMarcaSelecionado();
        marcaCons.desabilitarCampos(true);
        marcaCons.desabilitarBotes(false, true, false, true);
        marcaCons.setMarca(marca);
    }

    private void novaMarca() {
        marcaCons.desabilitarBotes(true, false, true, true);
        marcaCons.desabilitarCampos(true);
    }

    private void salvarMarca() throws SQLException {
        marca = new Marca();
        marcaCons.getMarca(marca);
        inicializarConexaoBD();
        new marcaDao().salvarMarca(marca, conn);
        finalizarConexao();
        getListaMarca();
    }

    private void getListaMarca() throws SQLException {
        lstMarca = new ArrayList<>();
        inicializarConexaoBD();
        new marcaDao().getLista(lstMarca, conn);
        finalizarConexao();
        marcaCons.setList(lstMarca);
    }

}
