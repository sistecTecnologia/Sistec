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
import sistec.bean.produto.GradeProduto;
import sistec.bean.produto.Produto;
import sistec.dao.SistecDao;

/**
 *
 * @author SERVIDOR
 */
public class produtoDao {

    Connection con;

    public void salvarProduto(Produto p, Connection con) throws SQLException {
        this.con = con;
        if (p.getIdProduto() == 0) {
            incluir(p);
        }

    }

    private void incluir(Produto p) throws SQLException {
        String sql = "insert into produto(descricao,marca,idmarca,cest,ncm,estoque,precoCusto,idAliquota,aliquota,status)values(?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, p.getDescricaoProduto());
            pstm.setString(2, p.getMarca().getNomeMarca());
            pstm.setInt(3, p.getMarca().getIdMarca());
            pstm.setString(4, p.getCest());
            pstm.setString(5, p.getNcm());
            pstm.setDouble(6, p.getEstoque());
            pstm.setDouble(7, p.getPrecoCusto());
            pstm.setInt(8, p.getAliquota().getIdAliquota());
            pstm.setString(9, p.getAliquota().getAliquota());
            pstm.setString(10, "A");
            pstm.execute();
            p.setIdProduto(new SistecDao().getUltimoPrimaryKey("Produto", "idProduto", con));
            new gradeProdutoDao().salvarGrade(p, con);

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void getListaSimplesProduto(List<Produto> lstProduto, Connection con) throws SQLException {
        String sql = "select gp.idproduto,gp.referencia,gp.gtin,p.descricao,gp.valoravista,gp.valorAprazo from gradeproduto gp inner join produto p on (gp.idproduto=p.idproduto) where gp.status='A'";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            ResultSet dados = pstm.executeQuery();
            while (dados.next()) {
                
                Produto p = new Produto();
                GradeProduto gp = new GradeProduto();
                gp.setIdProduto(dados.getInt("idProduto"));
                gp.setReferencia(dados.getString("referencia"));
                gp.setGtin(dados.getString("gtin"));
                gp.setValorAPrazo(dados.getDouble("valorAprazo"));
                gp.setValorAvista(dados.getDouble("valorAvista"));
                p.setDescricaoProduto(dados.getString("descricao"));
                p.getLstGradeProduto().add(gp);
                lstProduto.add(p);

            }
        }
    }

}
