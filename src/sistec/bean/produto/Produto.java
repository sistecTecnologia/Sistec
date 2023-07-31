/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.bean.produto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SERVIDOR
 */
public class Produto {

    private int idProduto;
    private List<GradeProduto> lstGradeProduto = new ArrayList<>();
    private String descricaoProduto;
    private String ncm;
    private String cest;
    private Marca marca = new Marca();
    private Aliquota aliquota = new Aliquota();
    private double precoCusto;
    private double estoque;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public List<GradeProduto> getLstGradeProduto() {
        return lstGradeProduto;
    }

    public void setLstGradeProduto(List<GradeProduto> lstProduto) {
        this.lstGradeProduto = lstProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getCest() {
        return cest;
    }

    public void setCest(String cest) {
        this.cest = cest;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Aliquota getAliquota() {
        return aliquota;
    }

    public void setAliquota(Aliquota aliquota) {
        this.aliquota = aliquota;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getEstoque() {
        return estoque;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }
}
