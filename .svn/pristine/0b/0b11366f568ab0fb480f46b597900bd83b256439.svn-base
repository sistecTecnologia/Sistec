/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author CASSIO JUNIOR
 */
public class inicializarDao extends uteis.MetodosDeControler {

    private int atualizacao = 1;

    public boolean sistecIsExiste() throws SQLException, Exception {
        Connection conTeste = new conexoes.ConexaoBancoTeste().conectar();
        String sql = " show schemas ";
        try (PreparedStatement pstm = conTeste.prepareStatement(sql)) {
            try (ResultSet dados = pstm.executeQuery()) {
                while (dados.next()) {
                    if (dados.getString("Database").equals("sistec")) {
                        return true;
                    }
                }
            }
            return false;
        } catch (SQLException e) {
            throw new Exception("Erro ao  consultar bd " + e.getMessage());
        } finally {
            conTeste.close();
        }

    }

    public void criaUsuario() throws SQLException {
        if (!getIpServidor().equals("127.0.0.1")) {
            return;
        }
        String Sql = "select * from mysql.user where user='sistec'";
        boolean usuarioCriado = false;
        inicializarConexaoBD();
        try (PreparedStatement pstm = conn.prepareStatement(Sql)) {
            try (ResultSet dados = pstm.executeQuery()) {
                while (dados.next()) {

                    if (dados.getString("user").equals("sistec")) {
                        usuarioCriado = true;
                        System.out.println("usuario mysql ok");
                    } else {
                        String sqlUser = "CREATE USER sistec IDENTIFIED BY '" + "sistec999" + "';";
                        PreparedStatement pstm1 = conn.prepareStatement(sqlUser);
                        pstm1.execute();
                        String sqlPermi = "GRANT ALL PRIVILEGES ON sistec.* TO 'sistec'@'%' WITH GRANT OPTION;";
                        PreparedStatement pstm2 = conn.prepareStatement(sqlPermi);
                        pstm2.execute();
                    }
                }
                if (usuarioCriado != true) {

                    String sqlUser = "CREATE USER sistec IDENTIFIED BY '" + "sistec999" + "';";
                    PreparedStatement pstm1 = conn.prepareStatement(sqlUser);
                    pstm1.execute();
                    String sqlPermi = "GRANT ALL PRIVILEGES ON sistec.* TO 'sistec'@'%' WITH GRANT OPTION;";
                    PreparedStatement pstm2 = conn.prepareStatement(sqlPermi);
                    pstm2.execute();
                }

            }
        }
    }

    public boolean empresaExiste() throws Exception {
        if (getEmpresa().getIdEmpresa() > 0) {
            return true;
        }
        return false;
    }

    public void criarBanco() throws SQLException {
        Connection conTeste = new conexoes.ConexaoBancoTeste().conectar();
        executaSql("create database sistec", conTeste);
        inicializarConexaoBD();
        criarTabela("usuario", "idUsuario", 0);
        criarColuna("usuario", "nome varchar(50)");
        criarColuna("usuario", "usuario varchar(50)");
        criarColuna("usuario", "senha varchar(50)");
        criarColuna("usuario", "idempresa int");
        criarTabela("empresa", "idEmpresa", 0);
        criarColuna("empresa", "razaoSocial varchar(200)");
        criarColuna("empresa", "Cnpj varchar(50)");
        criarColuna("empresa", "inscricaoEstadual varchar(50)");
        criarColuna("empresa", "nomeFantasia varchar(200)");
        criarColuna("empresa", "telefone varchar(25)");
        criarColuna("empresa", "endereco varchar(200)");
        criarColuna("empresa", "bairro varchar(50)");
        criarColuna("empresa", "quadra varchar(10)");
        criarColuna("empresa", "lote varchar(10)");
        criarColuna("empresa", "atualizacao INTEGER DEFAULT 0");
        criarTabela("cidade", "idCidade", 0);
        criarColuna("cidade", "cidade varchar(50)");
        criarColuna("cidade", "ibge varchar(20)");
        criarColuna("cidade", "idEmpresa int");
        criarTabela("pessoa", "idpessoa", 0);
        criarColuna("pessoa", "nomeRazaoSocial varchar(200)");
        criarColuna("pessoa", "cpfCnpj varchar(20)");
        criarColuna("pessoa", "inscricaoEstadual varchar(20)");
        criarColuna("pessoa", "nomeFantasia varchar(100)");
        criarColuna("pessoa", "telefone varchar(20)");
        criarColuna("pessoa", "endereco varchar(200)");
        criarColuna("pessoa", "bairro varchar(50)");
        criarColuna("pessoa", "quadra varchar(50)");
        criarColuna("pessoa", "lote varchar(50)");
        criarColuna("pessoa", "cidade varchar(100)");
        criarColuna("pessoa", "idCidade int");
        criarColuna("pessoa", "idEmpresa int");
        criarColuna("cidade", "status char(1)");
        criarColuna("pessoa", "status char(1)");
        criarColuna("pessoa", "cep varchar(15)");
        criarTabela("marca", "idMarca", 0);
        criarColuna("marca", "nome varchar(50)");
        criarColuna("marca", "status char(1)");
        criarTabela("produto", "idproduto", 0);
        criarColuna("produto", "descricao varchar(80)");
        criarColuna("produto", "marca varchar(50)");
        criarColuna("produto", "idMarca int(11)");
        criarColuna("produto", "cest varchar(15)");
        criarColuna("produto", "ncm varchar(15)");
        criarColuna("produto", "estoque float(15)");
        criarColuna("produto", "precoCusto float(15)");
        criarColuna("produto", "idAliquota int(11)");
        criarColuna("produto", "aliquota varchar(50)");
        criarColuna("produto", "status char(1)");
        criarTabela("gradeProduto", "idGradeProduto", 0);
        criarColuna("gradeProduto", "idproduto int");
        criarColuna("gradeProduto", "referencia varchar(20)");
        criarColuna("gradeProduto", "gtin varchar(20)");
        criarColuna("gradeProduto", "valorAvista double");
        criarColuna("gradeProduto", "valorAprazo double");
        criarColuna("gradeProduto", "volume double");
        criarColuna("gradeProduto", "unidade varchar(10)");
        criarColuna("gradeProduto", "status char(1)");

    }

    private void executaSql(String sql, Connection conn) throws SQLException {
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.execute();
            System.out.println(sql);
        }
    }

    private void criarColuna(String tabela, String coluna) {
        System.out.println("\n Criando Coluna :");
        inicializarConexaoBD();
        String sql = "ALTER TABLE " + tabela + " ADD COLUMN " + coluna;
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.execute();
            System.out.println(tabela + " " + coluna + "- OK!!");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar coluns" + coluna + "\n Erro " + ex.getMessage());
        } finally {
            finalizarConexao();
        }

    }

    private void criarTabela(String tabela, String colunaInicial, int incrementoInicial) {

        inicializarConexaoBD();

        String sql = "CREATE TABLE " + tabela + " ( " + colunaInicial + " INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,"
                + "  PRIMARY KEY (" + colunaInicial + ") "
                + ") ENGINE=InnoDB AUTO_INCREMENT=" + incrementoInicial + " DEFAULT CHARSET=latin1;";
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.execute();
            System.out.println(tabela + "-> Criada com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar coluns" + tabela + "\n Erro " + ex.getMessage());
        } finally {
            finalizarConexao();
        }
    }

    public int getAtualizacao() throws SQLException, Exception {
        inicializarConexaoBD();
        String sql = "select atualizacao from empresa ";
        try (PreparedStatement pstm = conn.prepareCall(sql)) {
            try (ResultSet dados = pstm.executeQuery()) {
                while (dados.next()) {
                    return dados.getInt("atualizacao");
                }

            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            finalizarConexao();
        }
        return 0;
    }

    public void setAtualiacao(int atualizacao) throws SQLException {
        inicializarConexaoBD();
        String sql = "Update empresa set atualizacao = ?";
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setInt(1, atualizacao);
            pstm.execute();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        } finally {
            finalizarConexao();
        }
    }

    private void executarMetodo(String nomeMetodo) {
        try {
            Method m = this.getClass().getMethod(nomeMetodo);
            m.invoke(this);
//            atualizaVersaoSistemaNoBanco();
        } catch (NoSuchMethodException | SecurityException ex) {
            JOptionPane.showMessageDialog(null, "Metodo não encontrado !" + ex.getMessage());
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            JOptionPane.showMessageDialog(null, "erro ao executar metodo:" + ex.getMessage());
        }
    }

    public void atualizarTabela() throws Exception {
        if (new inicializarDao().getAtualizacao() >= atualizacao) {
            return;
        }
        for (int i = new inicializarDao().getAtualizacao(); i < atualizacao; i++) {
            executarMetodo("atualizacao" + atualizacao);
        }

    }

    public void atualizacao1() throws SQLException {
        criarColuna("pessoa", "status char(1)");
        criarColuna("pessoa", "cep varchar(15)");
        criarColuna("pessoa", "cep varchar(15)");
        criarTabela("marca", "idMarca", 0);
        criarColuna("marca", "nome varchar(50)");
        criarColuna("marca", "status char(1)");

        criarTabela("produto", "idproduto", 0);
        criarColuna("produto", "descricao varchar(80)");
        criarColuna("produto", "marca varchar(50)");
        criarColuna("produto", "idMarca int(11)");
        criarColuna("produto", "cest varchar(15)");
        criarColuna("produto", "ncm varchar(15)");
        criarColuna("produto", "estoque float(15)");
        criarColuna("produto", "precoCusto float(15)");
        criarColuna("produto", "idAliquota int(11)");
        criarColuna("produto", "aliquota varchar(50)");
        criarTabela("gradeProduto", "idGradeProduto", 0);
        criarColuna("gradeProduto", "status char(1)");
        criarColuna("produto", "status char(1)");
        setAtualiacao(1);

    }

}
