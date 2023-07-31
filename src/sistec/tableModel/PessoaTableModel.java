/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.tableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sistec.bean.Pessoa;

/**
 *
 * @author SERVIDOR
 */
public class PessoaTableModel extends AbstractTableModel {

    private List<Pessoa> lstPessoa;

    public PessoaTableModel(List<Pessoa> lstPessoa) {
        this.lstPessoa = lstPessoa;
    }

    @Override
    public int getRowCount() {
        return lstPessoa.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pessoa pessoa = lstPessoa.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pessoa.getIdPessoa();
            case 1:
                return pessoa.getNomeRazaoSocial();
            case 2:
                return pessoa.getNomeFantasia();
            case 3:
                return pessoa.getCpfCnpj();
            case 4:
                return pessoa.getCidade();

        }
        return null;
    }

    public Pessoa getValorPessoa(int rowIndex) {
        return lstPessoa.get(rowIndex);
    }

}
