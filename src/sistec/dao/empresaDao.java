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
import sistec.bean.Empresa;

/**
 *
 * @author SERVIDOR
 */
public class empresaDao {

    Empresa empresa = new Empresa();

    public void salvarEmpresa(Empresa empresa, Connection conn) throws SQLException, Exception {
        this.empresa = empresa;
        if (empresa.getIdEmpresa() == 0) {

            salvarEmpresa(conn);
        } else {
            alterarEmpresa(conn);
        }

    }

    private void salvarEmpresa(Connection conn) throws SQLException, Exception {
        String sql = "insert into empresa (razaoSocial,cnpj,inscricaoEstadual,nomeFantasia,telefone,endereco,bairro,quadra,lote,atualizacao)"
                + "values(?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            int i = 1;
            pstm.setString(i++, empresa.getRazaoSocial());
            pstm.setString(i++, empresa.getCnpj());
            pstm.setString(i++, empresa.getInscricaoEstadual());
            pstm.setString(i++, empresa.getNomeFantasia());
            pstm.setString(i++, empresa.getTelefone());
            pstm.setString(i++, empresa.getEndereco());
            pstm.setString(i++, empresa.getBairro());
            pstm.setString(i++, empresa.getQuadra());
            pstm.setString(i++, empresa.getLote());
            pstm.setInt(i++, 0);
            pstm.execute();
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }

    }

    private void alterarEmpresa(Connection conn) throws SQLException, Exception {
        String sql = "update empresa set razaoSocial = ?,"// 1
                + "inscricaoEstadual = ?,"//2
                + "nomeFantasia = ?,"//3
                + "telefone = ?,"//4
                + "endereco = ?,"//5
                + "bairro = ?,"//6
                + "quadra = ?,"//7
                + "lote= ?, "
                + "cnpj = ? "//8
                + "where idEmpresa = ?";//9
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            int i = 1;
            pstm.setString(i++, empresa.getRazaoSocial());
            pstm.setString(i++, empresa.getInscricaoEstadual());
            pstm.setString(i++, empresa.getNomeFantasia());
            pstm.setString(i++, empresa.getTelefone());
            pstm.setString(i++, empresa.getEndereco());
            pstm.setString(i++, empresa.getBairro());
            pstm.setString(i++, empresa.getQuadra());
            pstm.setString(i++, empresa.getLote());
            pstm.setString(i++, empresa.getCnpj());
            pstm.setInt(i++, empresa.getIdEmpresa());
            pstm.execute();

        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public void getEmpresa(Empresa empresa, Connection con) throws SQLException, Exception {
        String sql = "Select * from empresa ";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            try (ResultSet dados = pstm.executeQuery()) {
                while (dados.next()) {
                    empresa.setIdEmpresa(dados.getInt("idEmpresa"));
                    empresa.setCnpj(dados.getString("cnpj"));
                    empresa.setNomeFantasia(dados.getString("nomeFantasia"));
                    empresa.setRazaoSocial(dados.getString("razaoSocial"));
                    empresa.setEndereco(dados.getString("endereco"));
                    empresa.setBairro(dados.getString("bairro"));
                    empresa.setLote(dados.getString("lote"));
                    empresa.setQuadra(dados.getString("quadra"));
                    empresa.setTelefone(dados.getString("telefone"));
                    empresa.setInscricaoEstadual(dados.getString("inscricaoEstadual"));
                }
            }

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }
}
