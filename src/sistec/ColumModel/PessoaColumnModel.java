/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.ColumModel;

import uteis.SisTecColumnModel;

/**
 *
 * @author SERVIDOR
 */
public class PessoaColumnModel extends SisTecColumnModel {

    public PessoaColumnModel(int ordem) {
        addColumn(criaColuna(50, "Codigo"));
        addColumn(criaColuna(300, "Nome / Razão Social"));
        addColumn(criaColuna(300, "Nome Fantasia"));
        addColumn(criaColuna(150, "Cpf / Cnpj"));
        addColumn(criaColuna(200, "Cidade"));

    }
}
