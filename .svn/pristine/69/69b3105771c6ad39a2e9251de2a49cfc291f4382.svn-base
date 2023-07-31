/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.tableModel.Produto;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sistec.bean.produto.Aliquota;

/**
 *
 * @author SERVIDOR
 */
public class AliquotaTableModel extends AbstractTableModel {

    private List<Aliquota> lstAliquota;

    public AliquotaTableModel(List<Aliquota> lstAliq) {
        this.lstAliquota = lstAliq;
    }

    @Override
    public int getRowCount() {

        return lstAliquota.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aliquota aliq = lstAliquota.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return aliq.getIdAliquota();

            case 1:
                return aliq.getAliquota();

        }
        return null;

    }

    public Aliquota getValorAliquota(int rowIndex) {
        return lstAliquota.get(rowIndex);

    }

}
