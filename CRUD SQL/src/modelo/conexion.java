package modelo;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class conexion {
     
    
    private   Connection con= null;
 public static final String URL = "jdbc:mysql://localhost/tienda";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    public Connection getConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (com.mysql.jdbc.Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            JOptionPane.showMessageDialog(null, "Conexion Exitosa");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error de conexión");
        }
        return con;
    }
}
