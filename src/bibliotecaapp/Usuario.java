package bibliotecaapp;


import bibliotecaapp.Exceptions.DevolucionFueraDePlazoException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Usuario {
    private String nombre;
    private List<Libro> librosAlquilados;

    // Constructor
    public Usuario(String nombre) {
        this.nombre = nombre;
        this.librosAlquilados = new ArrayList<>();
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libro> getLibrosAlquilados() {
        return librosAlquilados;
    }

    public void setLibrosAlquilados(List<Libro> librosAlquilados) {
        this.librosAlquilados = librosAlquilados;
    }

    // Otros métodos según sea necesario

    public void alquilarLibro(Libro libro) {
        librosAlquilados.add(libro);
        libro.setDisponible(false);
    }

    public void devolverLibro(Libro libro) throws DevolucionFueraDePlazoException {
        if (libro.isDisponible()) {
            throw new DevolucionFueraDePlazoException();
        }
        librosAlquilados.remove(libro);
        libro.setDisponible(true);
    }

    // Sobrescribir el método equals para comparar objetos Usuario
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return nombre.equals(usuario.nombre);
    }

    // Sobrescribir el método hashCode para comparar objetos Usuario
    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}
