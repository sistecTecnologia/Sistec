/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.ColumModel;

import javax.swing.table.TableColumn;
import sistec.ColumModel.JComponentTableCellRenderer;
import uteis.SisTecColumnModel;

/**
 *
 * @author SERVIDOR
 */
public class UsuariosColumnModel extends SisTecColumnModel {

    public UsuariosColumnModel(int ordem) {
        addColumn(criaColuna(10, "Codigo"));
        addColumn(criaColuna(190, "Nome"));
        addColumn(criaColuna(40, "Usuario"));
        addColumn(criaColuna(40, "Senha"));
    }

}
