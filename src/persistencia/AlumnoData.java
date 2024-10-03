/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import modelo.Alumno;
import modelo.Conexion;
import org.mariadb.jdbc.Statement;

/**
 *
 * @author mmaci
 */
public class AlumnoData {

    private Connection con = null;

    public AlumnoData() {
        con = Conexion.getConexion();
    }

    public void GuardarAlumno(Alumno alumno) {

        String sql = "INSERT INTO alumno(dni,apellido,nombre,fechaNacimiento,estado) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alumno.setId(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "alumno guardado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla alumnos");

        }

    }

    public void bajaLogica(int id) {
        String sql = "UPDATE `alumno` SET estado=0 WHERE idAlumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "El alumno fue dado de baja");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void altaLogica(int id) {
        String sql = "UPDATE `alumno` SET estado=1 WHERE idAlumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "El alumno fue dado de alta");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void BorrarAlumno(int id) {
        try {
            String sql = "DELETE FROM `alumno` WHERE  idAlumno = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "el alumno fue eliminado correctamente");

            }

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Alumno buscarAlumno(int id) {
        Alumno alumno = new Alumno();
        try {
            String query = "SELECT * FROM `alumno` WHERE idAlumno= ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                alumno.setId(resultado.getInt("idAlumno"));
                alumno.setApellido(resultado.getString("apellido"));
                alumno.setNombre(resultado.getString("nombre"));
                alumno.setDni(resultado.getInt("dni"));
                alumno.setFechaNacimiento(resultado.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(resultado.getBoolean("estado"));
            }
            ps.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al devolver el alumno" + ex);
        }
        return alumno;
    }
    public ArrayList<Alumno> listaAlumno() {
        ArrayList<Alumno> listaAlumnos = new ArrayList();
        try {
            String query = "SELECT * FROM alumno";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                Alumno alumno = new Alumno();
                alumno.setId(resultado.getInt("idAlumno"));
                alumno.setApellido(resultado.getString("apellido"));
                alumno.setNombre(resultado.getString("nombre"));
                alumno.setDni(resultado.getInt("dni"));
                alumno.setFechaNacimiento(resultado.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(resultado.getBoolean("estado"));
                listaAlumnos.add(alumno);
            }
            ps.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al devolver la lista de alumnos" + ex);
        }
        return listaAlumnos;
    }

    public void actualizarAlumno(Alumno alumno) {

        String query = "UPDATE alumno SET dni = ?, apellido = ?, nombre = ?, fechaNacimiento = ?, estado = ? WHERE idAlumno = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            //Recibe los parametros de la clase objeto
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.isEstado());
            ps.setInt(6, alumno.getId());
            //Ejecuta la consulta
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alumno actualizado");
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el alumno: " + ex.getMessage());
        }

    }

}
