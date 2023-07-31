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
import sistec.Produto.Dao.produtoDao;
import sistec.bean.produto.Aliquota;
import sistec.bean.produto.GradeProduto;
import sistec.bean.produto.Marca;
import sistec.bean.produto.Produto;
import sistec.dao.inicializarDao;
import sistec.visao.Produto.ProdutosCadastro;
import sistec.visao.Produto.ProdutosCons;
import uteis.MetodosDeControler;

/**
 *
 * @author CASSIO JUNIOR
 */
public class produtosControler extends MetodosDeControler implements ActionListener {

    ProdutosCadastro produtoCad = new ProdutosCadastro(new javax.swing.JFrame(), true);
    ProdutosCons produtoCons = new ProdutosCons(new javax.swing.JFrame(), true);
//    ProdutosCadastro produtoCad = new ProdutosCadastro(new javax.swing.JFrame(), true);
    List<GradeProduto> lstGrade = new ArrayList<>();

    public produtosControler() throws SQLException {
        getListaProduto();
        produtoCons.addActionListener(this);
        produtoCons.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()) {
            case "NovoProduto":
                novoProduto();
                break;
            case "marca": {
                try {
                    consultaMarca();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            break;
            case "ConsultaAliquota":
                ConsultaAliquota();
                break;
            case "addGrade":
                addGrade();
                break;
            case "removeGrade": {
                try {
                    removeGrade();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            break;
            case "salvarProduto": {
                try {
                    salvarProduto();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());

                }
            }
            break;
        }
    }

    private void salvarProduto() throws SQLException {
        Produto produto = new Produto();
        produtoCad.getProduto(produto);
        try {

            inicializarConexaoBD();
            new produtoDao().salvarProduto(produto, conn);
            finalizarConexao();
            produtoCad.dispose();
        } catch (Exception e) {

        }
    }

    private void removeGrade() throws Exception {
        GradeProduto gp = new GradeProduto();
        gp = produtoCad.getGradeProdutoSelecionado();
        lstGrade.remove(gp);
        produtoCad.setlistGrade(lstGrade);
    }

    private void addGrade() {
        GradeProduto gp = new GradeProduto();
        lstGrade.add(gp);
        produtoCad.setlistGrade(lstGrade);
        produtoCad.setCellEditor();
    }

    private void ConsultaAliquota() {
        Aliquota aliquota = new Aliquota();
        new aliquotaControler(aliquota);
        produtoCad.setAliquota(aliquota);
    }

    private void consultaMarca() throws SQLException {
        Marca marca = new Marca();
        new marcaControler(marca);
        produtoCad.setMarca(marca);
    }

    private void novoProduto() {
        produtoCad = new ProdutosCadastro(new javax.swing.JFrame(), true);
        produtoCad.addActionListene(this);
        produtoCad.setVisible(true);
    }

    private void getListaProduto() throws SQLException {
        List<Produto> lstProduto = new ArrayList<>();
        inicializarConexaoBD();
        new produtoDao().getListaSimplesProduto(lstProduto, conn);
        finalizarConexao();

    }
}
