/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.tableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sistec.bean.Cidade;

/**
 *
 * @author SERVIDOR
 */
public class CidadeTableModel extends AbstractTableModel {

    private List<Cidade> lsCidade;

    public CidadeTableModel(List<Cidade> lsCidade) {
        this.lsCidade = lsCidade;
    }

    @Override
    public int getRowCount() {
        return lsCidade.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cidade cidade = lsCidade.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cidade.getIdCidade();
            case 1:
                return cidade.getNome();
            case 2:
                return cidade.getIbge();
        }
        return null;
    }

    public Cidade getValorCidade(int rowIndex) {
        return lsCidade.get(rowIndex);
    }

}
