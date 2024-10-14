package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.Conexion;
import modelo.Inscripcion;

public class IncripcionData {

    private Connection con = null;

    public IncripcionData() {
        this.con = Conexion.getConexion();

    }

    public void GuardarIncripcion(Inscripcion insc) {
        String sql = "INSERT INTO Inscripcion (IdAlumno , IdMateria, nota) VALUES ?,?;?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, insc.getAlumno().getId());
            ps.setInt(2, insc.getMateria().getIdMateria());
            ps.setInt(3, insc.getNota());
            ps.executeLargeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                insc.setIdInscripto(rs.getInt(sql));
                JOptionPane.showMessageDialog(null, "incripcion aceptada");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla incripciones");
        }

    }

}
