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
public class ListaProdutoColumModel extends SisTecColumnModel {

    public ListaProdutoColumModel() {
        addColumn(criaColuna(10, "Codigo"));
        addColumn(criaColuna(20, "Referencia"));
        addColumn(criaColuna(20, "Cod. Barras"));
        addColumn(criaColuna(100, "Descrição"));
        addColumn(criaColuna(10, "Estoque"));
        addColumn(criaColuna(10, "UN"));
        addColumn(criaColuna(10, "VL"));
        addColumn(criaColuna(15, "Valor Avista"));
        addColumn(criaColuna(15, "Valor APrazo"));
    }
}
