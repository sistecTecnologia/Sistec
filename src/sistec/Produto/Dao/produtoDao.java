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
        String sql = "select gp.idproduto,gp.referencia,gp.gtin,p.descricao,gp.valoravista,gp.valorAprazo,p.estoque,gp.unidade,gp.volume from gradeproduto gp inner join produto p on (gp.idproduto=p.idproduto) where gp.status='A'";
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
                gp.setUnidade(dados.getString("unidade"));
                gp.setVolume(dados.getDouble("volume"));
                p.setDescricaoProduto(dados.getString("descricao"));
                p.setEstoque(dados.getDouble("estoque"));
                p.getLstGradeProduto().add(gp);
                lstProduto.add(p);
                
            }
        }
    }
    
    private void consultaProdutoCompleto(Produto p, Connection con) throws SQLException {
        String sql = "select p.idProduto,p.descricao,p.marca,p.idmarca,p.cest,p.ncm,p.estoque,p.precoCusto,p.idAliquota,"
                + "p.aliquota ,gp.idproduto,gp.referencia,gp.gtin,gp.valoravista,gp.valorAprazo,gp.volume,gp.unidade from gradeProduto gp "
                + "inner join produto p on(p.idproduto=gp.idproduto) where gp.status='A' and p.idProduto=?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, p.getIdProduto());
            ResultSet dados = pstm.executeQuery();
            while (dados.next()) {
                p.setDescricaoProduto(dados.getString("descricao"));
                p.getMarca().setIdMarca(dados.getInt("idmarca"));
                p.getMarca().setNomeMarca(dados.getString("marca"));
                p.setCest(dados.getString("cest"));
                p.setNcm(dados.getString("ncm"));
                p.setPrecoCusto(dados.getDouble("precoCusto"));
                p.getAliquota().setIdAliquota(dados.getInt("idAliquota"));
                p.getAliquota().setAliquota(dados.getString("aliquota"));
                
                
                
            }
            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    private void consultaGradeProdutoPorId(int idProduto,Connection con){
        
    }
    
}
