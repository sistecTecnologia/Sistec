/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.tableModel.Produto;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sistec.bean.produto.GradeProduto;
import uteis.Uteis;

/**
 *
 * @author SERVIDOR
 */
public class GradeProdutoTableModel extends AbstractTableModel {

    private List<GradeProduto> lstGradeProduto;

    public GradeProdutoTableModel(List<GradeProduto> lstGrade) {
        this.lstGradeProduto = lstGrade;

    }

    @Override
    public int getRowCount() {
        return lstGradeProduto.size();

    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GradeProduto gradeProduto = lstGradeProduto.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return gradeProduto.getReferencia();
            case 1:
                return gradeProduto.getGtin();
            case 2:
                return gradeProduto.getValorAvista();
            case 3:
                return gradeProduto.getValorAPrazo();

            case 4:
                return gradeProduto.getVolume();
            case 5:
                return gradeProduto.getUnidade();
        }
        return null;
    }

    public GradeProduto getValorCidade(int rowIndex) {
        return lstGradeProduto.get(rowIndex);
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        GradeProduto gp = lstGradeProduto.get(rowIndex);
        switch (columnIndex) {
            case 0:
                gp.setReferencia(aValue.toString());
                break;
            case 1:
                gp.setGtin(aValue.toString());
                break;
            case 2:
                gp.setValorAvista(Uteis.getDouble2Decimais(aValue.toString()));
                break;
            case 3:
                gp.setValorAPrazo(Uteis.getDouble2Decimais(aValue.toString()));
                break;
            case 4:
                gp.setVolume(Uteis.getDouble2Decimais(aValue.toString()));
                break;
            case 5:
                gp.setUnidade(aValue.toString());
                break;
//a prazo
            // vl 
            //unidadee
        }
    }

}
