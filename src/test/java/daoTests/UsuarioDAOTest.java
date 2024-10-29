package daoTests;

import br.com.fintech.dao.UsuarioDAO;
import br.com.fintech.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public class UsuarioDAOTest {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
            // Teste de inserção
            Usuario novoUsuario = new Usuario();
//            novoUsuario.setIdUsuario(1);
//            novoUsuario.setNmCompleto("João Silva");
//            novoUsuario.setCpf("12345678900");
//            novoUsuario.setEmail("joao.silva@email.com");
//            java.util.Date utilDate = new java.util.Date();
//            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//            novoUsuario.setDtCadastro(sqlDate);
//            novoUsuario.setSenha("senha123");
//            usuarioDAO.insert(novoUsuario);
//            System.out.println("Usuário inserido com sucesso!");

            // Teste de leitura
            List<Usuario> usuarios = usuarioDAO.getAll();
            System.out.println("Lista de usuários:");
            for (Usuario u : usuarios) {
                System.out.println(u);
            }

            // Teste de atualização
            novoUsuario.setNmCompleto("João Silva Atualizado");
            novoUsuario.setCpf("28837997210");
            usuarioDAO.update(novoUsuario);
            System.out.println("Usuário atualizado com sucesso!");

            // Teste de exclusão
            int idParaExcluir = 1;
            usuarioDAO.delete(idParaExcluir);
            System.out.println("Usuário excluído com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
