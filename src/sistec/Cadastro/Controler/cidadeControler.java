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
import sistec.bean.Cidade;
import sistec.dao.cidadeDao;
import sistec.dao.inicializarDao;
import sistec.visao.CidadeCons;
import uteis.MetodosDeControler;

/**
 *
 * @author CASSIO JUNIOR
 */
public class cidadeControler extends MetodosDeControler implements ActionListener {

    CidadeCons cidadeCons = new CidadeCons(new javax.swing.JFrame(), true);
    private Cidade cidade;
    private List<Cidade> lsCidade = new ArrayList<>();
    private final Cidade cidadeSelecionado;

    public cidadeControler(Cidade cidade) throws Exception {
        this.cidadeSelecionado = cidade;
        cidadeCons.addActionListener(this);
        cidadeCons.desabilitarCampos(false, false);
        cidadeCons.desabilitarBotes(true, false, true, false);
        getListaCidade();

        cidadeCons.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()) {
            case "novaCidade":
                novaCidade();
                break;
            case "salvarCidade": {
                try {
                    salvarCidade();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            break;
            case "alterarCidade": {
                try {
                    alterarCidade();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            break;
            case "selecionarCidade": {
                try {
                    selecionarCidade();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());

                }
            }
            break;
        }
    }

    private void selecionarCidade() throws Exception {
        cidadeSelecionado.setIdCidade(cidadeCons.getCidadeSelecionado().getIdCidade());
        inicializarConexaoBD();

        new cidadeDao().getCidadeSelecionada(cidadeSelecionado, conn);
        finalizarConexao();
        cidadeCons.dispose();

    }

    private void alterarCidade() throws Exception {
        cidade = new Cidade();
        cidade = cidadeCons.getCidadeSelecionado();
        cidadeCons.setCidade(cidade);
        cidadeCons.desabilitarCampos(true, true);
        cidadeCons.desabilitarBotes(false, false, true, true);

    }

    private void salvarCidade() throws Exception {
        cidade = new Cidade();
        cidadeCons.getCidade(cidade);
        inicializarConexaoBD();

        new cidadeDao().salvarCidade(cidade, conn);
        lsCidade.add(cidade);
        finalizarConexao();
        cidadeCons.limparCampos();
//        cidadeCons.setList(lsCidade);
        getListaCidade();
        cidadeCons.desabilitarCampos(false, false);
        cidadeCons.desabilitarBotes(true, false, true, false);

    }

    private void getListaCidade() throws Exception {
        inicializarConexaoBD();
        lsCidade = new cidadeDao().getListaCiadade(conn);
        finalizarConexao();
        cidadeCons.setList(lsCidade);
    }

    private void novaCidade() {
        cidadeCons.desabilitarBotes(true, false, true, true);
        cidadeCons.desabilitarCampos(true, true);
    }
}
