/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.ColumModel.Produto;

import uteis.SisTecColumnModel;

/**
 *
 * @author SERVIDOR
 */
public class MarcaColumnModel extends SisTecColumnModel {

    public MarcaColumnModel(int ordem) {

        addColumn(criaColuna(20, "Codigo"));
        addColumn(criaColuna(200, "Nome"));

    }
}
