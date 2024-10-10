/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.Materia;
import org.mariadb.jdbc.Statement;

/**
 *
 * @author Fabricio Zalazar
 */
public class materiaData {
    private Connection con=null;

    public materiaData() {
        con=Conexion.getConexion();
    }
    
    public void GuardarMateria(Materia materia) {

        String sql = "INSERT INTO materia(nombre,anio,estado) VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia guardada");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla materias");

        }

    }
    
    public void borrarMateria(int id) {
        try {
            String sql = "DELETE FROM `materia` WHERE  idMateria = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "La materia fue eliminado correctamente");

            }

        } catch (SQLException ex) {
            Logger.getLogger(materiaData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void altaLogica(int id) {
        String sql = "UPDATE `materia` SET estado=1 WHERE idMateria=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "La materia fue dada de alta");
            }
        } catch (SQLException ex) {
            Logger.getLogger(materiaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void bajaLogica(int id) {
        String sql = "UPDATE `materia` SET estado=0 WHERE idMateria=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "La materia fue dada de baja");
            }
        } catch (SQLException ex) {
            Logger.getLogger(materiaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public ArrayList<Materia> listaMateria() {
        ArrayList<Materia> listaMaterias = new ArrayList();
        try {
            String query = "SELECT * FROM materia";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(resultado.getInt("idMateria"));
                materia.setNombre(resultado.getString("nombre"));
                materia.setAnio(resultado.getInt("anio"));
                materia.setEstado(resultado.getBoolean("estado"));
                listaMaterias.add(materia);
            }
            ps.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al devolver la lista de materias" + ex);
        }
        return listaMaterias;
    }
     
     public Materia BuscarMateria(int id) {
        Materia materia = new Materia();
        try {
            String query = "SELECT * FROM materia WHERE idMateria=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                materia.setIdMateria(resultado.getInt("idMateria"));
                materia.setNombre(resultado.getString("nombre"));
                materia.setAnio(resultado.getInt("anio"));
                materia.setEstado(resultado.getBoolean("estado"));
            }
            ps.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al devolver la lista de materias" + ex);
        }
        return materia;
    }
     
      public void actualizarMateria(Materia materia) {

        String query = "UPDATE materia SET idMateria=?, nombre = ?,anio = ?, estado = ? WHERE idMateria = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            //Recibe los parametros de la clase objeto
            ps.setInt(1, materia.getIdMateria());
            ps.setString(2, materia.getNombre());
            ps.setInt(3, materia.getAnio());
            ps.setBoolean(4, materia.isEstado());
            ps.setInt(5, materia.getIdMateria());
            //Ejecuta la consulta
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Materia actualizada");
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la Materia: " + ex.getMessage());
        }

    }
}
