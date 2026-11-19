package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Fases;

public class DaoFases {
    private DataSource dataSource;

    public DaoFases(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ArrayList<Fases> readAll() {
        String sql = "SELECT * FROM fases ORDER BY idFase ASC";
        ArrayList<Fases> lista = new ArrayList<>();

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Fases f = new Fases();
                f.setIdFase(rs.getInt("idFase"));
                f.setDsFase(rs.getString("dsFase"));
                lista.add(f);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar fases: " + ex.getMessage());
        }
        return lista;
    }

    public void create(Fases f) {
        String sql = "INSERT INTO fases (dsFase) VALUES (?)";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, f.getDsFase());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Fase cadastrada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar fase: " + ex.getMessage());
        }
    }

    public void update(Fases f) {
        String sql = "UPDATE fases SET dsFase = ? WHERE idFase = ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, f.getDsFase());
            ps.setInt(2, f.getIdFase());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Fase atualizada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar fase: " + ex.getMessage());
        }
    }

    public void delete(int idFase) {
        String sql = "DELETE FROM fases WHERE idFase = ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idFase);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Fase excluída com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir fase: " + ex.getMessage());
        }
    }
}