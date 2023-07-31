/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.ColumModel;

import javax.swing.table.TableColumn;
import uteis.SisTecColumnModel;

/**
 *
 * @author SERVIDOR
 */
public class CidadeColumnModel extends SisTecColumnModel {

    public CidadeColumnModel(int ordem) {
        addColumn(criaColuna(20, "Codigo"));
        addColumn(criaColuna(100, "Nome"));
        addColumn(criaColuna(50, "Ibge"));
    }

}
