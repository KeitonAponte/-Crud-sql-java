package modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class ConsultasProducto extends conexion {

    public boolean registar(Producto pro) {
        //preparando consutla 
        PreparedStatement ps = null;
        //vamos por la conexion 
        Connection con = (Connection) getConexion();
        //creamos un variable para hacer la consulta 
        String sql = "INSERT INTO producto (codigo,nombre,precio,cantidad)  VALUES (?,?,?,?)";

        //enviamos los dato
        try {
           // ps =con.prepareStatement(sql);
             ps = (PreparedStatement) con.prepareStatement(sql);
            //eviamos lo datos e interactuamos con los datos del modelo
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getCantidad());
            //ejecutamos
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } 
        finally {
            //cerrar conexion 
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

    }

    public boolean modificar(Producto pro) {
        //preparando consutla 
        PreparedStatement ps = null;
        //vamos por la conexion 
        Connection con = (Connection) getConexion();
        //creamos un variable para hacer la consulta 
        String sql = "UPDATE producto SET codigo=?, nombre=?, precio=?, cantidad=? WHERE id=?";

        //enviamos los dato
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            //eviamos lo datos e interactuamos con los datos del modelo
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getCantidad());
            ps.setInt(5, pro.getId());
            //ejecutamos
            ps.execute();
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            //cerrar conexion 
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public boolean eliminar(Producto pro) {
        //preparando consutla 
        PreparedStatement ps = null;
        //vamos por la conexion 
        Connection con = (Connection) getConexion();
        //creamos un variable para hacer la consulta 
        String sql = "DELETE FROM producto WHERE id=?";

        //enviamos los dato
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            //eviamos lo datos e interactuamos con los datos del modelo
            ps.setInt(1, pro.getId());
            //ejecutamos
            ps.execute();
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            //cerrar conexion 
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public boolean buscar(Producto pro) {
        //preparando consutla 
        PreparedStatement ps = null;

        ResultSet rs = null;
        //vamos por la conexion 
        Connection con = (Connection) getConexion();
        //creamos un variable para hacer la consulta 
        String sql = "SELECT * FROM producto WHERE codigo=?";

        //enviamos los dato
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            //eviamos lo datos e interactuamos con los datos del modelo
            ps.setString(1, pro.getCodigo());
            //ejecutamos
            //rs nos trae la informacion --> filas
            rs = ps.executeQuery();
            if (rs.next()) {
                pro.setId(Integer.parseInt(rs.getString("id")));
                pro.setNombre(rs.getString("codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setPrecio(Double.parseDouble(rs.getString("precio")));
                pro.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                return true;
            }
            return false;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            //cerrar conexion 
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
}
