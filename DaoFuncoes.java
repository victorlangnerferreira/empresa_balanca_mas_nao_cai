package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Funcoes;

public class DaoFuncoes {
    private DataSource dataSource;

    public DaoFuncoes(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ArrayList<Funcoes> readAll() {
        String sql = "SELECT * FROM funcoes ORDER BY idFuncao ASC";
        ArrayList<Funcoes> lista = new ArrayList<>();

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Funcoes fn = new Funcoes();
                fn.setIdFuncao(rs.getInt("idFuncao"));
                fn.setDsFuncao(rs.getString("dsFuncao"));
                lista.add(fn);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar funções: " + ex.getMessage());
        }
        return lista;
    }

    public void create(Funcoes fn) {
        String sql = "INSERT INTO funcoes (dsFuncao) VALUES (?)";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, fn.getDsFuncao());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Função cadastrada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar função: " + ex.getMessage());
        }
    }

    public void update(Funcoes fn) {
        String sql = "UPDATE funcoes SET dsFuncao = ? WHERE idFuncao = ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, fn.getDsFuncao());
            ps.setInt(2, fn.getIdFuncao());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Função atualizada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar função: " + ex.getMessage());
        }
    }

    public void delete(int idFuncao) {
        String sql = "DELETE FROM funcoes WHERE idFuncao = ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idFuncao);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Função excluída com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir função: " + ex.getMessage());
        }
    }
}