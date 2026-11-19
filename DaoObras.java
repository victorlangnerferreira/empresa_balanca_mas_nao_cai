package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Obras;

public class DaoObras {
    private DataSource dataSource;

    public DaoObras(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ArrayList<Obras> readAll() {
        String sql = "SELECT * FROM obras ORDER BY idObra ASC";
        ArrayList<Obras> lista = new ArrayList<>();

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Obras o = new Obras();
                o.setIdObra(rs.getInt("idObra"));
                o.setDescricao(rs.getString("Descricao"));
                o.setDtInicio(rs.getString("dtInicio"));
                o.setDtFim(rs.getString("dtFim"));
                o.setIdEngenheiro(rs.getInt("idEngenheiro"));
                o.setNrCrea(rs.getString("nrCrea"));
                o.setDtDdmissaoEngenheiro(rs.getString("dtDdmissaoEngenheiro"));
                lista.add(o);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar obras: " + ex.getMessage());
        }
        return lista;
    }

    public void create(Obras o) {
        String sql = "INSERT INTO obras (Descricao, dtInicio, dtFim, idEngenheiro, nrCrea, dtDdmissaoEngenheiro) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, o.getDescricao());
            ps.setString(2, o.getDtInicio());
            ps.setString(3, o.getDtFim());
            ps.setInt(4, o.getIdEngenheiro());
            ps.setString(5, o.getNrCrea());
            ps.setString(6, o.getDtDdmissaoEngenheiro());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Obra cadastrada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar obra: " + ex.getMessage());
        }
    }

    public void update(Obras o) {
        String sql = "UPDATE obras SET Descricao = ?, dtInicio = ?, dtFim = ?, idEngenheiro = ?, nrCrea = ?, dtDdmissaoEngenheiro = ? WHERE idObra = ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, o.getDescricao());
            ps.setString(2, o.getDtInicio());
            ps.setString(3, o.getDtFim());
            ps.setInt(4, o.getIdEngenheiro());
            ps.setString(5, o.getNrCrea());
            ps.setString(6, o.getDtDdmissaoEngenheiro());
            ps.setInt(7, o.getIdObra());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Obra atualizada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar obra: " + ex.getMessage());
        }
    }

    public void delete(int idObra) {
        String sql = "DELETE FROM obras WHERE idObra = ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idObra);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Obra excluída com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir obra: " + ex.getMessage());
        }
    }
}