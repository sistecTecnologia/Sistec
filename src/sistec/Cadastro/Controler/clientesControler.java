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
import sistec.bean.Pessoa;
import sistec.dao.inicializarDao;
import sistec.dao.pessoaDao;
import sistec.visao.ClientesCadastro;
import sistec.visao.ClientesCons;
import uteis.MetodosDeControler;

/**
 *
 * @author CASSIO JUNIOR
 */
public class clientesControler extends MetodosDeControler implements ActionListener {

    private ClientesCons clienteCons = new ClientesCons(new javax.swing.JFrame(), true);
    private ClientesCadastro clienteCad = new ClientesCadastro(new javax.swing.JFrame(), true);
    private Pessoa pessoa;
    private List<Pessoa> lstPessoa;

    public clientesControler() throws Exception {
        getClientes();
        clienteCons.addActionListener(this);
        clienteCons.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()) {
            case "NovoCliente":
                novoCliente();
                break;
            case "consultaCidade": {
                try {
                    consultaCidade();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            break;
            case "SalvarCliente": {
                try {
                    salvarCliente();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            break;
            case "EditarPessoa": {
                try {
                    editarPessoa();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            break;
            case "ExcluirPessoa": {
                try {
                    excluirPessoa();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            break;
        }
    }

    private void excluirPessoa() throws Exception {
        pessoa = new Pessoa();
        pessoa = clienteCons.getPessoaSelecionado();
        int dialogButton = JOptionPane.showConfirmDialog(null, "Deseja excluir " + pessoa.getNomeRazaoSocial() + " ?", "WARNING", JOptionPane.YES_NO_OPTION);
        if (dialogButton == JOptionPane.YES_OPTION) {
            inicializarConexaoBD();
            new pessoaDao().excluirPessoa(pessoa, conn);
            finalizarConexao();
            lstPessoa.remove(pessoa);
            clienteCons.setList(lstPessoa);
        }
    }

    

    private void editarPessoa() throws Exception {
        pessoa = new Pessoa();
        pessoa = clienteCons.getPessoaSelecionado();
        clienteCad.addActionListener(this);
        clienteCad.setCliente(pessoa);
        clienteCad.setVisible(true);

    }

    private void getClientes() throws Exception {
        lstPessoa = new ArrayList<>();
        inicializarConexaoBD();
        new pessoaDao().getListaPessoa(lstPessoa, conn);
        finalizarConexao();
        clienteCons.setList(lstPessoa);
    }

    private void salvarCliente() throws Exception {
        pessoa = new Pessoa();
        clienteCad.getCliente(pessoa);
        inicializarConexaoBD();
        new pessoaDao().salvar(pessoa, conn);
        finalizarConexao();
        clienteCad.dispose();
        lstPessoa.add(pessoa);
        clienteCons.setList(lstPessoa);

    }

    private void consultaCidade() throws Exception {
        Cidade cidade = new Cidade();
        new cidadeControler(cidade);
        clienteCad.setCidade(cidade);

    }

    private void novoCliente() {
        clienteCad = new ClientesCadastro(new javax.swing.JFrame(), true);
        clienteCad.addActionListener(this);
        clienteCad.setVisible(true);
    }
}
