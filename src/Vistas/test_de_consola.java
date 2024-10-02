package Vistas;


import java.time.LocalDate;
import modelo.Alumno;
import persistencia.AlumnoData;

public class test_de_consola {

    public static void main(String[] args) {
        AlumnoData con = new AlumnoData();
        if (con != null) {
          //pruebaGuardarAlumnos(con); //Cada vez que se vuelva a guardar reiniciar el autoIncremental a 1 en la parte de operaciones
          //pruebaBorrarAlumno(con);
          //pruebaBajaLogica(con);
          //pruebaAltaLogica(con);
          //pruebaListarAlumnos(con);
        } else {
            System.out.println("Error: No se pudo establecer la conexión con la base de datos.");
        }
    }

    public static void pruebaGuardarAlumnos( AlumnoData con) {
        con.GuardarAlumno(new Alumno(43072929, "Zalazar", "Fabricio", LocalDate.of(2000, 10, 9), true));
        con.GuardarAlumno(new Alumno(32676125, "Macia", "Maximiliano", LocalDate.of(1986, 12, 12), false));
        con.GuardarAlumno(new Alumno(36681811, "Abregu", "Juan", LocalDate.of(1994, 4, 20), true));
        con.GuardarAlumno(new Alumno(20454568, "Lozada", "Christian", LocalDate.of(1996, 8, 9), true));
        con.GuardarAlumno(new Alumno(12384855, "Amieva", "Diego", LocalDate.of(1989, 10, 9), true));
    }
    public static void pruebaBorrarAlumno(AlumnoData con) {
         con.BorrarAlumno(1);
         con.BorrarAlumno(2);
         con.BorrarAlumno(3);
         con.BorrarAlumno(4);
         con.BorrarAlumno(5);
     }
    public static void pruebaBajaLogica(AlumnoData con) {
         con.bajaLogica(1);
         con.bajaLogica(2);
         con.bajaLogica(3);
         con.bajaLogica(4);
         con.bajaLogica(5);
     }
    public static void pruebaAltaLogica(AlumnoData con) {
         con.altaLogica(1);
         con.altaLogica(2);
         con.altaLogica(3);
         con.altaLogica(4);
         con.altaLogica(5);
      }
    public static void pruebaListarAlumnos(AlumnoData con){
        for (Alumno alumno : con.listaAlumno()) {
            System.out.println(alumno.toString());
        }
      
      
    }
     
}
