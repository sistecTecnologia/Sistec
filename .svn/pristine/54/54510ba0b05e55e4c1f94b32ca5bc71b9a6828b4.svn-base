/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sistec.bean.Login;

/**
 *
 * @author CASSIO JUNIOR
 */
public class loginDao {

    String nome;
    String senha;

    public boolean existeLogin(Login login, Connection con) throws SQLException {
        String sql = "select usuario,senha from usuario where usuario=? and senha = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, login.getUsuario());
            pstm.setString(2, login.getSenha());
            try (ResultSet dados = pstm.executeQuery()) {
                while (dados.next()) {
                    return true;
                }
            }

        }
        return false;
    }
}
