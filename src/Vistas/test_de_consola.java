package Vistas;

import java.time.LocalDate;
import modelo.Alumno;
import modelo.Materia;
import persistencia.AlumnoData;
import persistencia.materiaData;

public class test_de_consola {

    public static void main(String[] args) {
        AlumnoData con = new AlumnoData();
        materiaData cone = new materiaData();
        if (con != null) {
            //ALUMNO       
            //pruebaGuardarAlumnos(con); //Cada vez que se vuelva a guardar reiniciar el autoIncremental a 1 en la parte de operaciones
            //pruebaBorrarAlumno(con);
            //pruebaBajaLogicaAlumno(con);
            //pruebaAltaLogicaAlumno(con);
            //pruebaBuscarAlumno(con);
            //pruebaListarAlumnos(con);
            //pruebaActualizarAlumno(con);

            //MATERIA
            //pruebaGuardarMateria(cone);//Cada vez que se vuelva a guardar reiniciar el autoIncremental a 1 en la parte de operaciones
            //pruebaBorrarMateria(cone);
            //pruebaAltaLogicaMateria(cone);
            //pruebaBajaLogicaMateria(cone);
            //pruebaBuscarMateria(cone);
            //pruebaListaMaterias(cone);
            //pruebaActualizarAlumno(cone);

        } else {
            System.out.println("Error: No se pudo establecer la conexión con la base de datos.");
        }
    }

    public static void pruebaGuardarAlumnos(AlumnoData con) {
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

    public static void pruebaBajaLogicaAlumno(AlumnoData con) {
        con.bajaLogica(1);
        con.bajaLogica(2);
        con.bajaLogica(3);
        con.bajaLogica(4);
        con.bajaLogica(5);
    }

    public static void pruebaAltaLogicaAlumno(AlumnoData con) {
        con.altaLogica(1);
        con.altaLogica(2);
        con.altaLogica(3);
        con.altaLogica(4);
        con.altaLogica(5);
    }

    public static void pruebaListarAlumnos(AlumnoData con) {
        for (Alumno alumno : con.listaAlumno()) {
            System.out.println(alumno.toString());
        }
    }
    
    public static void pruebaBuscarAlumno(AlumnoData con){
        System.out.println(con.buscarAlumno(2));
    }
    
    public static void pruebaActualizarAlumno(AlumnoData con) {
        con.actualizarAlumno(new Alumno(3, 36681811, "Abregu", "jose", LocalDate.of(1994, 4, 20), false));
    }

    public static void pruebaGuardarMateria(materiaData con) {
        con.GuardarMateria(new Materia("Matematicas I", 1, true));
        con.GuardarMateria(new Materia("Laboratorio II", 2, false));
        con.GuardarMateria(new Materia("Ingles I", 1, true));
        con.GuardarMateria(new Materia("Ingles III", 3, false));
    }

    public static void pruebaBorrarMateria(materiaData con) {
        con.borrarMateria(1);
        con.borrarMateria(2);
        con.borrarMateria(3);
        con.borrarMateria(4);
    }

    public static void pruebaAltaLogicaMateria(materiaData con) {
        con.altaLogica(1);
        con.altaLogica(2);
        con.altaLogica(3);
        con.altaLogica(4);
    }

    public static void pruebaBajaLogicaMateria(materiaData con) {
        con.bajaLogica(1);
        con.bajaLogica(2);
        con.bajaLogica(3);
        con.bajaLogica(4);
    }

    public static void pruebaBuscarMateria(materiaData con){
        System.out.println(con.BuscarMateria(3));
    }
    
    public static void pruebaListaMaterias(materiaData con) {
        for (Materia materia : con.listaMateria()) {
            System.out.println(materia.toString());
        }
    }
    
    public static void pruebaActualizarAlumno(materiaData con){
        con.actualizarAlumno(new Materia(2,"Labo",2,false));
    }
}
