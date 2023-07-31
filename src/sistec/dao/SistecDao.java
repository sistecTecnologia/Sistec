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

/**
 *
 * @author SERVIDOR
 */
public class SistecDao {

    public int getUltimoPrimaryKey(String tabela, String campo, Connection conn) throws SQLException {
        String sql = "select " + campo + " from " + tabela + " ORDER BY "+campo+" desc limit 1";
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            try (ResultSet dados = pstm.executeQuery()) {
                while (dados.next()) {
                    return dados.getInt(campo);
                }
            }
        }
        return 0;

    }

}
