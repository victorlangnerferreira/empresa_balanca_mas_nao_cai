package dao;


import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataSource {
    private String hostname;
    private int porta;
    private String database;
    private String username;
    private String password;
    
    //variavél de conexão
    private Connection connection;
    
    //pedido/abre de conexão
    public DataSource(){
        try{
            //seta valores nas variavéis
            hostname = "192.168.20.5";
            porta = 3306;
            database = "balanca_mas_nao_cai";
            username = "root";
            password = "12345";
            
            //String de conexão
            String url = "jdbc:mysql://"+hostname+":"+porta+"/"+database+"?userTimezone=true&serverTimezone=UTC";
            
//            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            
            //faz a conexão
            connection = (Connection) DriverManager.getConnection(url, username, password);
        }
        catch (SQLException ex){
//            System.err.println("ERRO na conexão"+ex.getMessage());
            JOptionPane.showMessageDialog(null, "ERRO na conexão"+ex.getMessage());
        }
        catch (Exception ex){
//            System.err.println("ERRO geral"+ex.getMessage());
            JOptionPane.showMessageDialog(null, "ERRO geral"+ex.getMessage());
        }
    }


    //pega a conexão ativa
    public Connection getConnection(){
        return this.connection;
    }
    
    public void closeDataSource(){
        try{
            connection.close();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null,"ERRO ao desconectar"+ex.getMessage());
        }
   }
}