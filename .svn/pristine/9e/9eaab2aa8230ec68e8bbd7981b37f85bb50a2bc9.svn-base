/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.CellEditor;

import java.awt.Component;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import sistec.bean.produto.GradeProduto;

/**
 *
 * @author SERVIDOR
 */
public class gradeProdutoCellEditor extends AbstractCellEditor implements TableCellEditor {

    private List<GradeProduto> lstGrade;
    int column = 0;
    int row = 0;
    private JTextField jTextField;

    public gradeProdutoCellEditor(List<GradeProduto> lstGrade) {
        super();
        this.lstGrade = lstGrade;
    }

    @Override
    public Object getCellEditorValue() {
        if (column ==0) {
            return jTextField.getText();
        }
        if (column ==1) {
            return jTextField.getText();
        }
        if (column ==2) {
            return jTextField.getText();
        }
        if (column ==3) {
            return jTextField.getText();
        }
        if (column ==4) {
            return jTextField.getText();
        }

        return null;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.column = column;
        this.row = row;
        if (value == null) {
            value = "";
        }
        switch (column) {
            case 0:
                jTextField = new JTextField();
                jTextField.setText(value.toString());
                return jTextField;
            case 1:
                jTextField = new JTextField();
                jTextField.setText(value.toString());
                return jTextField;
            case 2:
                jTextField = new JTextField();
                jTextField.setText(value.toString());
                return jTextField;
            case 3:
                jTextField = new JTextField();
                jTextField.setText(value.toString());
                return jTextField;
            case 4:
                jTextField = new JTextField();
                jTextField.setText(value.toString());
                return jTextField;
        }
        return null;
    }

}
