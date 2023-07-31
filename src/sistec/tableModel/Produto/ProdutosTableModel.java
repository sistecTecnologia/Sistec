/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.tableModel.Produto;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sistec.bean.produto.Produto;

/**
 *
 * @author SERVIDOR
 */
public class ProdutosTableModel extends AbstractTableModel {

    List<Produto> LstProduto;
    private String[] colunas = {"id,ref,gtin,descricao"};

    public ProdutosTableModel(List<Produto> lstProduto) {
        this.LstProduto = lstProduto;

    }

//    @Override
//    public String getColumnName(int column) {
//        return colunas[column];
//    }

    @Override
    public int getRowCount() {
        return LstProduto.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto p = LstProduto.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getLstGradeProduto().get(0).getIdProduto();
            case 1:
                return p.getLstGradeProduto().get(0).getReferencia();
            case 2:
                return p.getLstGradeProduto().get(0).getGtin();
            case 3:
                return p.getDescricaoProduto();

        }
        return null;
    }

}
