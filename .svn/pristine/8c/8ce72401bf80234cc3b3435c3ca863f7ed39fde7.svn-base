/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.tableModel.Produto;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sistec.bean.produto.Marca;

/**
 *
 * @author SERVIDOR
 */
public class MarcaTableModel extends AbstractTableModel {

    private List<Marca> lstMarca;

    public MarcaTableModel(List<Marca> lstMarca) {
        this.lstMarca = lstMarca;

    }

    public int getRowCount() {
        return lstMarca.size();
    }

    @Override
    public int getColumnCount() {

        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Marca marca = lstMarca.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return marca.getIdMarca();
            case 1:
                return marca.getNomeMarca();
        }
        return null;
    }

    public Marca getValorCidade(int rowIndex) {
        return lstMarca.get(rowIndex);
    }

}
