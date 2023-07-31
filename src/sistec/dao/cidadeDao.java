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
import java.util.ArrayList;
import java.util.List;
import sistec.bean.Cidade;
import uteis.MetodosDeControler;

/**
 *
 * @author SERVIDOR
 */
public class cidadeDao extends MetodosDeControler {

    Connection con;

    public void salvarCidade(Cidade cidade, Connection con) throws SQLException, Exception {
        this.con = con;
        if (cidade.getIdCidade() == 0) {
            salvarCidade(cidade);
        } else {
            alterarCidade(cidade);
        }
    }

    private void salvarCidade(Cidade cidade) throws SQLException, Exception {
        String sql = "insert into cidade(cidade,ibge,idEmpresa,status)values(?,?,?,'A')";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            int i = 1;
            pstm.setString(i++, cidade.getNome());
            pstm.setInt(i++, cidade.getIbge());
            pstm.setInt(i++, getEmpresa().getIdEmpresa());
            pstm.execute();
            cidade.setIdCidade(new SistecDao().getUltimoPrimaryKey("cidade", "idcidade", conn));
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    private void alterarCidade(Cidade cidade) throws SQLException, Exception {
        String sql = "update cidade set cidade = ? ,ibge = ? where idcidade = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            int i = 1;
            pstm.setString(i++, cidade.getNome());
            pstm.setInt(i++, cidade.getIbge());
            pstm.setInt(i++, cidade.getIdCidade());
            pstm.execute();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Cidade> getListaCiadade(Connection conn) throws SQLException, Exception {
        List<Cidade> lstCidade = new ArrayList<>();

        String sql = "Select * from cidade where idempresa = ?";
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setInt(1, getEmpresa().getIdEmpresa());
            try (ResultSet dados = pstm.executeQuery()) {
                while (dados.next()) {
                    Cidade cidade = new Cidade();
                    cidade.setIbge(dados.getInt("ibge"));
                    cidade.setNome(dados.getString("cidade"));
                    cidade.setIdCidade(dados.getInt("idcidade"));
                    lstCidade.add(cidade);
                }

                return lstCidade;
            } catch (SQLException e) {
                throw new Exception(e.getMessage());
            }
        }

    }

    public void getCidadeSelecionada(Cidade cidade, Connection con) throws SQLException, Exception {
        String sql = "Select * from cidade where idcidade = ? and idempresa = ? and status='A'";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            int i = 1;
            pstm.setInt(i++, cidade.getIdCidade());
            pstm.setInt(i++, getEmpresa().getIdEmpresa());
            try (ResultSet dados = pstm.executeQuery()) {
                while (dados.next()) {
                    cidade.setIbge(dados.getInt("ibge"));
                    cidade.setNome(dados.getString("cidade"));
                }
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }
}
