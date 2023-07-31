/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import sistec.bean.Usuario;

/**
 *
 * @author CASSIO JUNIOR
 */
public class usuarioDao extends uteis.MetodosDeControler {

    public void salvarUsuario(Usuario usuario) throws SQLException, Exception {
        inicializarConexaoBD();
        String sql = "insert into usuario (nome,usuario,senha)values (?,?,?)";
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getUsuario());
            pstm.setString(3, usuario.getSenha());
            pstm.execute();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            finalizarConexao();
        }
    }

    public void getListaUsuario(List<Usuario> lstUsuario) throws SQLException, Exception {
        String sql = "select * from usuario ";
        inicializarConexaoBD();
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            try (ResultSet dados = pstm.executeQuery()) {
                while (dados.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setIdUsuario(dados.getInt("idusuario"));
                    usuario.setNome(dados.getString("nome"));
                    usuario.setUsuario(dados.getString("usuario"));
                    usuario.setSenha(dados.getString("senha"));
                    lstUsuario.add(usuario);
                }
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            finalizarConexao();
        }
    }
}
