
package modelo;


public class Alumno {
     private int id;
     private String nombre;
     private String apellido;

    public Alumno( String nombre, String apellido) {
       
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "alumno{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }
     
     
}
