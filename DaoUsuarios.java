package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Usuarios;

public class DaoUsuarios {
    private DataSource dataSource;

    public DaoUsuarios(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ArrayList<Usuarios> readAll() {
        String sql = "SELECT * FROM usuarios ORDER BY idUsuario ASC";
        ArrayList<Usuarios> lista = new ArrayList<>();

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuarios u = new Usuarios();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNome(rs.getString("Nome"));
                u.setEmail(rs.getString("Email"));
                u.setSenha(rs.getString("Senha"));
                lista.add(u);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar usuários: " + ex.getMessage());
        }
        return lista;
    }

    public Usuarios autenticar(String email, String senha) {
        String sql = "SELECT * FROM usuarios WHERE Email = ? AND Senha = ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, senha);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Usuarios u = new Usuarios();
                    u.setIdUsuario(rs.getInt("idUsuario"));
                    u.setNome(rs.getString("Nome"));
                    u.setEmail(rs.getString("Email"));
                    u.setSenha(rs.getString("Senha"));
                    return u;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na autenticação: " + ex.getMessage());
        }
        return null;
    }

    public void create(Usuarios u) {
        String sql = "INSERT INTO usuarios (Nome, Email, Senha) VALUES (?, ?, ?)";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getSenha());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário: " + ex.getMessage());
        }
    }

    public void update(Usuarios u) {
        String sql = "UPDATE usuarios SET Nome = ?, Email = ?, Senha = ? WHERE idUsuario = ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getSenha());
            ps.setInt(4, u.getIdUsuario());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar usuário: " + ex.getMessage());
        }
    }

    public void delete(int idUsuario) {
        String sql = "DELETE FROM usuarios WHERE idUsuario = ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir usuário: " + ex.getMessage());
        }
    }
}