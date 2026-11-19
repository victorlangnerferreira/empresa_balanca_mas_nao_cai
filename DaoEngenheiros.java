package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Engenheiros;


public class DaoEngenheiros {
    
    private DataSource dataSource;
    
    public DaoEngenheiros(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public ArrayList<Engenheiros> consulta() {
        ArrayList<Engenheiros> lista = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            String SQL = "SELECT * FROM engenheiros";
            ps = dataSource.getConnection().prepareStatement(SQL);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Engenheiros cat = new Engenheiros();
                cat.setIdEngenheiro(rs.getInt("idEngenheiro"));
                cat.setDsNome(rs.getString("dsNome"));
                cat.setNrCrea(rs.getString("nrCREA"));
                cat.setDtAdmissao(rs.getString("dtAdmissao"));
                
                lista.add(cat);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO na conexão: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO geral: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista; // Nunca retorna null
    }
    
    public ArrayList<Engenheiros> seleciona(String descricao) {
        ArrayList<Engenheiros> lista = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            String SQL = "SELECT * FROM engenheiros WHERE (dsNome LIKE ?)";
            ps = dataSource.getConnection().prepareStatement(SQL);
            ps.setString(1, "%" + descricao + "%");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Engenheiros cat = new Engenheiros();
                cat.setIdEngenheiro(rs.getInt("idEngenheiro"));
                cat.setDsNome(rs.getString("dsNome"));
                cat.setNrCrea(rs.getString("nrCREA"));
                cat.setDtAdmissao(rs.getString("dtAdmissao"));
                
                lista.add(cat);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO na conexão: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO geral: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista; // Nunca retorna null
    }
    
    public void incluir(Engenheiros eng) {
        Connection con = dataSource.getConnection();
        PreparedStatement ps = null;
        
        try {
            String SQL = "INSERT INTO engenheiros (idEngenheiro, dsNome, nrCREA, dtAdmissao) VALUES (?, ?, ?, ?)";
            
            ps = con.prepareStatement(SQL);
            ps.setInt(1, eng.getIdEngenheiro());
            ps.setString(2, eng.getDsNome());
            ps.setString(3, eng.getNrCrea());
            ps.setString(4, eng.getDtAdmissao());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!\n" + ex.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void alterar(Engenheiros eng) {
        Connection con = dataSource.getConnection();
        PreparedStatement ps = null;
        
        try {
            String SQL = "UPDATE engenheiros "
                    + "SET dsNome=?, nrCREA=?, dtAdmissao=? "
                    + "WHERE idEngenheiro=?";
            
            ps = con.prepareStatement(SQL);
            ps.setString(1, eng.getDsNome());
            ps.setString(2, eng.getNrCrea());
            ps.setString(3, eng.getDtAdmissao());
            ps.setInt(4, eng.getIdEngenheiro()); // Corrigido: ID é o 4º parâmetro
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar!\n" + ex.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void excluir(String codigo) {
        Connection con = dataSource.getConnection();
        PreparedStatement ps = null;
        
        try {
            String SQL = "DELETE FROM engenheiros WHERE idEngenheiro=?"; 
            
            ps = con.prepareStatement(SQL);
            ps.setInt(1, Integer.parseInt(codigo)); // Convertido para int para bater com o tipo da coluna
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!\n" + ex.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}