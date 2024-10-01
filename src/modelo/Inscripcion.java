/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Nedisane
 */
public class Inscripcion {
    
    public int idInscripto;
    public int nota;
    public int idAlumno;
    public int idMateria;

    public Inscripcion() {
    }

    public Inscripcion(int nota, int idAlumno, int idMateria) {
        this.nota = nota;
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
    }

    public Inscripcion(int idInscripto, int nota, int idAlumno, int idMateria) {
        this.idInscripto = idInscripto;
        this.nota = nota;
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
    }

    public int getIdInscripto() {
        return idInscripto;
    }

    public int getNota() {
        return nota;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdInscripto(int idInscripto) {
        this.idInscripto = idInscripto;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    @Override
    public String toString() {
        return "idInscripto: " + idInscripto + ", nota: " + nota + ", idAlumno: " + idAlumno + ", idMateria: " + idMateria;
    }
    
}
