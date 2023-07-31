/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.tableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sistec.bean.Usuario;

/**
 *
 * @author SERVIDOR
 */
public class UsuarioTableModel extends AbstractTableModel {

    private List<Usuario> lsUsuario;

    public UsuarioTableModel(List<Usuario> lsUsuarios) {
        this.lsUsuario = lsUsuarios;
    }

    @Override
    public int getRowCount() {
        return lsUsuario.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario = lsUsuario.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return usuario.getIdUsuario();
            case 1:
                return usuario.getNome();
            case 2:
                return usuario.getUsuario();
            case 3:
                return "*********";
        }
        return null;
    }

    public Usuario getUsuarioSelecionado(int rowIndex) {
        return lsUsuario.get(rowIndex);
    }

    public Usuario getValoresUsuario(int rowIndex) {
        return lsUsuario.get(rowIndex);
    }

}
