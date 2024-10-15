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

public class IncripcionData {

    private Connection con = null;
  
    private materiaData md = new materiaData();
    private AlumnoData ad = new AlumnoData();

    public IncripcionData() {
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
        String sql = "update inscripcion set  nota= ? where idAlumno = ? and idMateria=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "nota actualizada");
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

}
