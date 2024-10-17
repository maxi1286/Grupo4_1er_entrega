package persistencia;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.Conexion;
import modelo.Inscripcion;
import modelo.Materia;

public class InscripcionData {

    private Connection con = null;

    private materiaData md = new materiaData();
    private AlumnoData ad = new AlumnoData();

    public InscripcionData() {
        this.con = Conexion.getConexion();

    }

    public void GuardarIncripcion(Inscripcion insc) {
        String sql = "INSERT INTO inscripcion(idInscripcion,nota, idAlumno, idMateria) VALUES (null,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getId());
            ps.setInt(3, insc.getMateria().getIdMateria());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                insc.setIdInscripto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "incripcion aceptada");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error ");
        }

    }

    public void ActualizarNota(int idAlumno, int idMateria, int nota) {
        String sql = "Update inscripcion set  nota= ? where idAlumno = ? and idMateria=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error ");
        }
    }

    public void BorrarInscripcion(int idAlumno, int idMateria) {
        String sql = "DELETE from inscripcion Where idAlumno = ? and idMateria = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "incripcion borrada");

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error ");
        }
    }

    public ArrayList<Inscripcion> ObtenerInscripciones() {

        ArrayList<Inscripcion> cursada = new ArrayList();

        String sql = "SELECT * FROM inscripcion";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Inscripcion insc = new Inscripcion();
                insc.setIdInscripto(rs.getInt("idInscripcion"));
                Alumno alu = ad.buscarAlumno(rs.getInt("idAlumno"));
                Materia mate = md.BuscarMateria(rs.getInt("idMateria"));
                insc.setAlumno(alu);
                insc.setMateria(mate);
                insc.setNota(rs.getInt("nota"));

                cursada.add(insc);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error ");
        }
        return cursada;

    }

    public ArrayList<Inscripcion> ObtenerInscripcionesporAlumno(int idAlumno) {

        ArrayList<Inscripcion> cursada = new ArrayList();

        String sql = "SELECT * FROM inscripcion WHERE idAlumno = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Inscripcion insc = new Inscripcion();
                insc.setIdInscripto(rs.getInt("idInscripcion"));
                Alumno alu = ad.buscarAlumno(rs.getInt("idAlumno"));
                Materia mate = md.BuscarMateria(rs.getInt("idMateria"));
                insc.setAlumno(alu);
                insc.setMateria(mate);
                insc.setNota(rs.getInt("nota"));

                cursada.add(insc);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error ");
        }
        return cursada;

    }

    public ArrayList<Materia> obternerMateriasCursadas(int idAlumno) {

        ArrayList<Materia> materias = new ArrayList();
        String sql = "SELECT materia.idMateria, materia.nombre, materia.anio FROM inscripcion join materia ON inscripcion.idMateria = materia.idMateria  WHERE idAlumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Materia mate = new Materia();
                mate.setIdMateria(rs.getInt("idMateria"));
                mate.setNombre(rs.getString("nombre"));
                mate.setAnio(rs.getInt("anio"));
                materias.add(mate);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error");
        }
        return materias;
    }

    public ArrayList<Materia> obtenerMateriasNoCursadas(int idAlumno) {

        ArrayList<Materia> materias = new ArrayList();

        String sql = " SELECT * FROM materia WHERE estado= 1 AND idMateria not in "
                + " (SELECT idMateria FROM inscripcion WHERE idAlumno = ?) ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia mate = new Materia();
                mate.setIdMateria(rs.getInt("idMateria"));
                mate.setNombre(rs.getString("nombre"));
                mate.setAnio(rs.getInt("anio"));
                materias.add(mate);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error ");
        }
        return materias;
    }

    public ArrayList<Alumno> obtenerAlumnoXMateria(int idMateria) {

        ArrayList<Alumno> alumnoMateria = new ArrayList();
        String sql = "SELECT a.idAlumno, dni, nombre, apellido, fechaNacimiento, estado "
            + "FROM inscripcion i, alumno a WHERE i.idAlumno = a.idAlumno AND idMateria = ? AND a.estado = 1";
       
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setId(rs.getInt("idAlumno"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                alumnoMateria.add(alumno);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error ");

        }
        return alumnoMateria;
    }

    public ArrayList<Integer> obtenerNotas(int id) {

        ArrayList<Integer> notas = new ArrayList();
        String sql = "SELECT idMateria,nota FROM inscripcion WHERE idAlumno=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return notas;
    }
}
