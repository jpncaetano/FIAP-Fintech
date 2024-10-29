package br.com.fintech.dao;

import br.com.fintech.model.Usuario;
import br.com.fintech.util.ConnectionFactory;
import br.com.fintech.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // Método para adicionar um novo usuário (CREATE)
    public void insert(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO T_FIN_USUARIO (ID_USUARIO, NM_COMPLETO, CPF, EMAIL, DT_CADASTRO, SENHA) VALUES (usuario_seq.NEXTVAL, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNmCompleto());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getEmail());
            stmt.setDate(4, usuario.getDtCadastro());
            stmt.setString(5, usuario.getSenha());
            stmt.executeUpdate();
        }
    }

    // Método para buscar todos os usuários (READ)
    public List<Usuario> getAll() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM T_FIN_USUARIO";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
                usuario.setNmCompleto(rs.getString("NM_COMPLETO"));
                usuario.setCpf(rs.getString("CPF"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setDtCadastro(rs.getDate("DT_CADASTRO"));
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    // Método para atualizar informações de um usuário (UPDATE)
    public void update(Usuario usuario) throws SQLException {
        String sql = "UPDATE T_FIN_USUARIO SET NM_COMPLETO = ?, CPF = ?, EMAIL = ? WHERE ID_USUARIO = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNmCompleto());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getEmail());
            stmt.setInt(4, usuario.getIdUsuario());
            stmt.executeUpdate();
        }
    }

    // Método para excluir um usuário (DELETE)
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM T_FIN_USUARIO WHERE ID_USUARIO = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
