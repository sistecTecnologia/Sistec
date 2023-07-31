/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteis;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sistec.SisTec;
import sistec.bean.Empresa;
import sistec.dao.empresaDao;

/**
 *
 * @author CASSIO JUNIOR
 */
public class MetodosDeControler {

    Empresa empresa = new Empresa();
    protected static Connection conn;
    public final String ip = new sistec.SisTec().getIp();

    protected void inicializarConexaoBD() {
        try {
            if (conn == null || conn.isClosed()) {
//                conn = ConexaoBD.getConexao();
                conn = new conexoes.ConexaoMySql().conectar();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao conectar com banco de dados:" + ex.getMessage());
        }
    }

    protected void finalizarConexao() {
        try {
            if (conn != null) {
                if (!conn.isClosed()) {
                    conn.close();
                    System.gc();
                }
                conn = null;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao conectar com banco de dados:" + ex.getMessage());
        }
    }

    protected Empresa getEmpresa() throws Exception {
        inicializarConexaoBD();
        new empresaDao().getEmpresa(empresa, conn);
//        finalizarConexao();
        return empresa;
    }

    public String getIpServidor() {
        return ip;
    }
}
