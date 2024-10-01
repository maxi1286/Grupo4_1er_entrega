package Vistas;

import java.sql.Connection;
import java.sql.SQLException;
import modelo.Alumno;
import modelo.Conexion;
import persistencia.AlumnoData;

public class test_de_consola {
    
    public static void main(String[] args) {
        Connection con = Conexion.getConexion();
        if (con != null) {
            Alumno fernando = new Alumno("fernando", "azurita");
            AlumnoData alu = new AlumnoData();
            alu.GuardarAlumno(fernando);
            Alumno noelia = new Alumno ("Noelia", "merino");
            AlumnoData alu2 = new AlumnoData();
            alu2.GuardarAlumno(noelia);
        } else {
            System.out.println("Error: No se pudo establecer la conexión con la base de datos.");
        }
    }
}
