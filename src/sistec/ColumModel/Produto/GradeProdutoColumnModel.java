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
public class GradeProdutoColumnModel extends SisTecColumnModel {

    public GradeProdutoColumnModel() {
        addColumn(criaColuna(110, "REF"));
        addColumn(criaColuna(110, "GTIN"));
        addColumn(criaColuna(80, "R$ AVISTA"));
        addColumn(criaColuna(80, "R$ APRAZO"));
        addColumn(criaColuna(50, "VL"));
        addColumn(criaColuna(50, "UN"));

    }

}
