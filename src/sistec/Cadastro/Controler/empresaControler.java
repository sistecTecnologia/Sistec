/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.Cadastro.Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistec.bean.Empresa;
import sistec.dao.empresaDao;
import sistec.dao.inicializarDao;
import sistec.visao.EmpresaFrm;
import uteis.MetodosDeControler;

/**
 *
 * @author CASSIO JUNIOR
 */
public class empresaControler extends MetodosDeControler implements ActionListener {

    EmpresaFrm empresaFrm = new EmpresaFrm(new javax.swing.JFrame(), true);
    int idempresa = 0;

    public empresaControler() throws Exception {
        empresaFrm.addActionListener(this);
//        getEmpresa();
        empresaFrm.setEmpresa(getEmpresa());
        empresaFrm.setVisible(true);
    }

    public empresaControler(boolean novaEmpresa) {
        empresaFrm.addActionListener(this);
        empresaFrm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "SalvarEmpresa": {
                try {
                    salvarEmpresa();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            break;

        }
    }

    private void salvarEmpresa() throws Exception {

        Empresa empresa = new Empresa();
        empresa.setIdEmpresa(idempresa);
        empresaFrm.getEmpresa(empresa);
        inicializarConexaoBD();
        new empresaDao().salvarEmpresa(empresa, conn);
        finalizarConexao();
        empresaFrm.dispose();
    }

    protected void getEmpresas() throws Exception {
        Empresa empresa = new Empresa();
        inicializarConexaoBD();
        new empresaDao().getEmpresa(empresa, conn);
        finalizarConexao();
        idempresa = empresa.getIdEmpresa();
        empresaFrm.setEmpresa(empresa);

    }
}
