/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.Produto.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import sistec.bean.produto.Marca;
import sistec.dao.SistecDao;
import uteis.MetodosDeControler;

/**
 *
 * @author SERVIDOR
 */
public class marcaDao extends MetodosDeControler {

    Connection con;

    public void salvarMarca(Marca marca, Connection con) throws SQLException {
        this.con = con;
        if (marca.getIdMarca() == 0) {
            incluir(marca);
        } else {
            alterar();
        }

    }

    private void incluir(Marca marca) throws SQLException {
        String sql = "insert into marca(nome,status)values (?,'A')";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, marca.getNomeMarca());
            pstm.execute();
            marca.setIdMarca(new SistecDao().getUltimoPrimaryKey("marca", "idmarca", conn));

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

    }

    private void alterar() {

    }

    public void getLista(List<Marca> lstMarca, Connection con) throws SQLException {
        String sql = "Select * from marca where status='A'";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            try (ResultSet dados = pstm.executeQuery()) {
                while (dados.next()) {
                    Marca marca = new Marca();
                    marca.setIdMarca(dados.getInt("idmarca"));
                    marca.setNomeMarca(dados.getString("nome"));
                    lstMarca.add(marca);
                }
            }

        }
    }

    public void getMarcaSelecionada(Marca marca, Connection con) throws SQLException, Exception {
        String sql = "select * from marca where idmarca = ?";

        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, marca.getIdMarca());
            try (ResultSet dados = pstm.executeQuery()) {
                while (dados.next()) {
                    marca.setNomeMarca(dados.getString("nome"));

                }

            }

        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());

        }
    }

    public void excluirMarca(int idmarca, Connection con) throws Exception {
        String sql = "update marca set status='I' where idMarca=? ";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, idmarca);
            pstm.execute();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }
}
