/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.Produto.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sistec.bean.produto.GradeProduto;
import sistec.bean.produto.Produto;

/**
 *
 * @author SERVIDOR
 */
public class gradeProdutoDao {

    Connection con;

    public void salvarGrade(Produto p, Connection con) throws SQLException {
        this.con = con;
        for (GradeProduto gp : p.getLstGradeProduto()) {
            gp.setIdProduto(p.getIdProduto());
            if (gp.getIdGradeProduto() == 0) {
                incluir(gp);
            } else {
                alterar(gp);
            }
        }
    }

    private void incluir(GradeProduto gp) throws SQLException {
        String sql = "insert into gradeProduto(idproduto,referencia,gtin,valorAvista,valorAprazo,volume,unidade,status)values(?,?,?,?,?,?,?,?)";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, gp.getIdProduto());
            pstm.setString(2, gp.getReferencia());
            pstm.setString(3, gp.getGtin());
            pstm.setDouble(4, gp.getValorAvista());
            pstm.setDouble(5, gp.getValorAvista());
            pstm.setDouble(6, gp.getVolume());
            pstm.setString(7, gp.getUnidade());
            pstm.setString(8, "A");
            pstm.execute();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private void alterar(GradeProduto gp) {

    }
}
