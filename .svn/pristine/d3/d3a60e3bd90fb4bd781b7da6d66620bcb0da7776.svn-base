
package uteis;

import sistec.ColumModel.JComponentTableCellRenderer;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicPopupMenuUI;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;


public class SisTecColumnModel extends DefaultTableColumnModel {

    protected short seq = 0;//numero da coluna que os registros serão ordenados
    protected int ordem = 0;//numero da coluna que os registros serão ordenados
    protected Font fontSistema = new Font("Arial", 1, 12);
    private final Color corHeader = new Color(160, 180, 172);

    protected TableColumn criaColuna(int columnIndex, int largura, FontMetrics fm, boolean resizeable, String titulo) {


        return criaColuna(largura, resizeable, titulo);
    }

    protected TableColumn criaColuna(int largura, boolean resizeable, String titulo) {

        Border headerBorder = UIManager.getBorder("TableHeader.cellBorder");
        JButton jBtnTitulo = new JButton(titulo);
        TableCellRenderer renderer = new JComponentTableCellRenderer();
        jBtnTitulo.setBorder(headerBorder);
        jBtnTitulo.setForeground(Color.white);
        jBtnTitulo.setBackground(corHeader);
        jBtnTitulo.setFont(fontSistema);
        TableColumn col = new TableColumn(this.getColumnCount());
        if (ordem == this.getColumnCount()) {
            jBtnTitulo.setForeground(Color.black);
        }

        col.setHeaderRenderer(renderer);
        col.setHeaderValue(jBtnTitulo);
        col.setPreferredWidth(largura);
        if (!resizeable) {
            col.setMaxWidth(largura);
            col.setMinWidth(largura);
        }
        col.setResizable(resizeable);
        return col;
    }

    protected TableColumn criaColuna(int largura, String titulo) {
        return criaColuna(largura, true, titulo);
    }

    protected TableColumn criaCheckBox(int columnIndex, int largura, FontMetrics fm, boolean resizeable, String titulo) {

        Border headerBorder = UIManager.getBorder("TableHeader.cellBorder");
        final JCheckBox jChkBox = new JCheckBox(titulo);
        TableCellRenderer renderer = new JComponentTableCellRenderer();
        jChkBox.setBorder(headerBorder);
        jChkBox.setForeground(Color.white);
        jChkBox.setEnabled(true);
        jChkBox.setBackground(corHeader);

        jChkBox.setFont(fontSistema);

        TableColumn col = new TableColumn(columnIndex);

        if (ordem == columnIndex) {
            jChkBox.setForeground(Color.black);
        }

        col.setHeaderRenderer(renderer);
        col.setHeaderValue(jChkBox);
        col.setPreferredWidth(largura);
        if (!resizeable) {
            col.setMaxWidth(largura);
            col.setMinWidth(largura);
        }
        col.setResizable(resizeable);
        return col;
    }

    protected TableColumn criaCheckBox(int largura, String titulo) {
        Border headerBorder = UIManager.getBorder("TableHeader.cellBorder");
        final JCheckBox jChkBox = new JCheckBox(titulo);
        TableCellRenderer renderer = new JComponentTableCellRenderer();
        jChkBox.setBorder(headerBorder);
        jChkBox.setForeground(Color.white);
        jChkBox.setEnabled(true);
        jChkBox.setBackground(corHeader);

        jChkBox.setFont(fontSistema);

        TableColumn col = new TableColumn(this.getColumnCount());

        if (ordem == this.getColumnCount()) {
            jChkBox.setForeground(Color.black);
        }
        col.setHeaderRenderer(renderer);
        col.setHeaderValue(jChkBox);
        col.setPreferredWidth(largura);
        col.setResizable(true);
        return col;
    }

    protected TableColumn criaComboBox(int columnIndex, int largura, FontMetrics fm, boolean resizeable, String titulo) {

        Border headerBorder = UIManager.getBorder("TableHeader.cellBorder");
        final JComboBox jBtnTitulo = new JComboBox();
        jBtnTitulo.addItem(titulo);
        jBtnTitulo.addItem("IPORA");
        jBtnTitulo.addItem("GOIANIA");
        jBtnTitulo.addItem("SAO LUIS");
        jBtnTitulo.addItem("FIRMINOPOLIS");
        TableCellRenderer renderer = new JComponentTableCellRenderer();
        jBtnTitulo.setBorder(headerBorder);
        jBtnTitulo.setPrototypeDisplayValue(new BasicPopupMenuUI());
        jBtnTitulo.setForeground(Color.white);
        jBtnTitulo.setEnabled(true);
        jBtnTitulo.setBackground(corHeader);

        jBtnTitulo.setFont(fontSistema);

        TableColumn col = new TableColumn(columnIndex);

        if (ordem == columnIndex) {
            jBtnTitulo.setForeground(Color.black);
        }

        col.setHeaderRenderer(renderer);
//        col.setHeaderValue(jBtnTitulo);
        col.setHeaderValue(jBtnTitulo);
        col.setPreferredWidth(largura);
        if (!resizeable) {
            col.setMaxWidth(largura);
            col.setMinWidth(largura);
        }
        col.setResizable(resizeable);
        return col;
    }

    protected JButton getButton(int index) {
        return (JButton) getColumn(index).getHeaderValue();
    }

    protected JComboBox getComboBox(int index) {
        return (JComboBox) getColumn(index).getHeaderValue();
    }

    protected JCheckBox getCheckBox(int index) {
        return (JCheckBox) getColumn(index).getHeaderValue();
    }

    protected List<String> getNomeColunas() {
        List<String> novaLista = new ArrayList<>();
        for (int i = 0; i < getColumnCount(); i++) {
            novaLista.add(getButton(i).getText());
        }
        return novaLista;
    }

    protected void voltarCor() {
        for (int index = 0; index < this.getColumnCount(); index++) {
            getButton(index).setForeground(Color.white);
        }
    }
}
