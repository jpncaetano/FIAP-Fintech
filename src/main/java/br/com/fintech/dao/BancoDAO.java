package br.com.fintech.dao;

import br.com.fintech.util.ConnectionFactory;
import br.com.fintech.model.Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BancoDAO {

    // getAll para buscar todos os bancos
    public List<Banco> getAll() {
        List<Banco> bancos = new ArrayList<>();
        String sql = "SELECT ID_BCO, NOME_BANCO FROM T_FIN_BCO";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                Banco banco = new Banco();
                banco.setIdBco(rs.getInt("ID_BCO"));
                banco.setNomeBanco(rs.getString("NOME_BANCO"));
                bancos.add(banco);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bancos;
    }

    // Insert para inserir um novo banco
    public void insert(Banco banco) {
        String sql = "INSERT INTO T_FIN_BCO (ID_BCO, NOME_BANCO) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, banco.getIdBco());
            pstmt.setString(2, banco.getNomeBanco());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
