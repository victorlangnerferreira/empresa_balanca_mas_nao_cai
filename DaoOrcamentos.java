package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Orcamentos;

public class DaoOrcamentos {
    private DataSource dataSource;

    public DaoOrcamentos(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ArrayList<Orcamentos> readAll() {
        String sql = "SELECT * FROM orcamentos ORDER BY idOrcamento ASC";
        ArrayList<Orcamentos> lista = new ArrayList<>();

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Orcamentos orc = new Orcamentos();
                orc.setIdOrcamento(rs.getInt("idOrcamento"));
                orc.setDtAprovacao(rs.getString("dtAprovacao"));
                orc.setIdEngenheiroResponsavel(rs.getInt("idEngenheiroResponsavel"));
                lista.add(orc);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar orçamentos: " + ex.getMessage());
        }
        return lista;
    }

    public void create(Orcamentos orc) {
        String sql = "INSERT INTO orcamentos (dtAprovacao, idEngenheiroResponsavel) VALUES (?, ?)";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, orc.getDtAprovacao());
            ps.setInt(2, orc.getIdEngenheiroResponsavel());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Orçamento cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar orçamento: " + ex.getMessage());
        }
    }

    public void update(Orcamentos orc) {
        String sql = "UPDATE orcamentos SET dtAprovacao = ?, idEngenheiroResponsavel = ? WHERE idOrcamento = ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, orc.getDtAprovacao());
            ps.setInt(2, orc.getIdEngenheiroResponsavel());
            ps.setInt(3, orc.getIdOrcamento());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Orçamento atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar orçamento: " + ex.getMessage());
        }
    }

    public void delete(int idOrcamento) {
        String sql = "DELETE FROM orcamentos WHERE idOrcamento = ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idOrcamento);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Orçamento excluído com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir orçamento: " + ex.getMessage());
        }
    }
}