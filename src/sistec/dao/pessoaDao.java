/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import sistec.bean.Pessoa;
import uteis.MetodosDeControler;

/**
 *
 * @author SERVIDOR
 */
public class pessoaDao extends MetodosDeControler {

    private Connection con;
    private Pessoa pessoa;

    public void salvar(Pessoa pessoa, Connection con) throws Exception {
        this.con = con;
        this.pessoa = pessoa;
        if (pessoa.getIdPessoa() == 0) {
            salvar();
        } else {
            alterar();
        }
    }

    private void salvar() throws SQLException, Exception {
        String sql = "insert into pessoa(nomeRazaoSocial,cpfCnpj,inscricaoEstadual,nomeFantasia,"
                + "telefone,endereco,bairro,quadra,lote,cidade,idCidade,idEmpresa,status,cep)values(?,?,?,?,?,?,?,?,?,?,?,?,'A',?) ";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            int i = 1;

            pstm.setString(i++, pessoa.getNomeRazaoSocial());
            pstm.setString(i++, pessoa.getCpfCnpj());
            pstm.setString(i++, pessoa.getInscricaoEstadual());
            pstm.setString(i++, pessoa.getNomeFantasia());
            pstm.setString(i++, pessoa.getTelefone());
            pstm.setString(i++, pessoa.getEndereco());
            pstm.setString(i++, pessoa.getBairro());
            pstm.setString(i++, pessoa.getQuadra());
            pstm.setString(i++, pessoa.getLote());
            pstm.setString(i++, pessoa.getCidade());
            pstm.setInt(i++, pessoa.getIdCidade());
            pstm.setInt(i++, getEmpresa().getIdEmpresa());
            pstm.setString(i++, pessoa.getCep());
            pstm.execute();
            pessoa.setIdPessoa(new SistecDao().getUltimoPrimaryKey("pessoa", "idpessoa", conn));

        }
    }

    public void excluirPessoa(Pessoa pessoa, Connection conn) throws SQLException {
        String sql = "update pessoa set status='I' where idpessoa=?";
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setInt(1, pessoa.getIdPessoa());
            pstm.execute();

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private void alterar() throws SQLException, Exception {
        String sql = "Update pessoa set "
                + "nomeRazaoSocial=?,"
                + "cpfCnpj=?,"
                + "inscricaoEstadual=?,"
                + "nomeFantasia=?,"
                + "telefone=?,"
                + "endereco=?,"
                + "bairro=?,"
                + "quadra=?,"
                + "lote=?,"
                + "cidade=?,"
                + "idCidade=?,"
                + "cep=?"
                + " where idpessoa=?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, pessoa.getNomeRazaoSocial());
            pstm.setString(2, pessoa.getCpfCnpj());
            pstm.setString(3, pessoa.getInscricaoEstadual());
            pstm.setString(4, pessoa.getNomeFantasia());
            pstm.setString(5, pessoa.getTelefone());
            pstm.setString(6, pessoa.getEndereco());
            pstm.setString(7, pessoa.getBairro());
            pstm.setString(8, pessoa.getQuadra());
            pstm.setString(9, pessoa.getLote());
            pstm.setString(10, pessoa.getCidade());
            pstm.setInt(11, pessoa.getIdCidade());
            pstm.setString(12, pessoa.getCep());
            pstm.setInt(13, pessoa.getIdPessoa());
            pstm.execute();

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }

    }

    public void getListaPessoa(List<Pessoa> lstPessoa, Connection conn) throws SQLException, Exception {
        String sql = "select * from pessoa where status='A' and idempresa=?";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setInt(1, getEmpresa().getIdEmpresa());
            try (ResultSet dados = pstm.executeQuery()) {
                while (dados.next()) {
                    Pessoa pessoa = new Pessoa();
                    pessoa.setBairro(dados.getString("bairro"));
                    pessoa.setCidade(dados.getString("cidade"));
                    pessoa.setCpfCnpj(dados.getString("cpfCnpj"));
                    pessoa.setEndereco(dados.getString("endereco"));
                    pessoa.setIdCidade(dados.getInt("idcidade"));
                    pessoa.setIdEmpresa(dados.getInt("idempresa"));
                    pessoa.setIdPessoa(dados.getInt("idpessoa"));
                    pessoa.setInscricaoEstadual(dados.getString("inscricaoEstadual"));
                    pessoa.setLote(dados.getString("lote"));
                    pessoa.setNomeFantasia(dados.getString("nomeFantasia"));
                    pessoa.setQuadra(dados.getString("quadra"));
                    pessoa.setTelefone(dados.getString("telefone"));
                    pessoa.setNomeRazaoSocial(dados.getString("nomeRazaoSocial"));

                    lstPessoa.add(pessoa);

                }
            } catch (SQLException e) {
                throw new SQLException(e.getMessage());
            }
        }

    }
}
