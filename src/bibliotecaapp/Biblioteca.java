package bibliotecaapp;



import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Biblioteca {
    private List<Libro> libros;
    private List<Usuario> usuarios;

    public Biblioteca() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
        // Inicializar libros y usuarios si es necesario
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void eliminarLibro(Libro libro) {
        libros.remove(libro);
    }

    // operaciones de gestión de libros y usuarios...

    public void mostrarLibros() {
        StringBuilder listaLibros = new StringBuilder("Lista de libros:\n");
        for (Libro libro : libros) {
            listaLibros.append(libro.getTitulo()).append("\n");
        }
        JOptionPane.showMessageDialog(null, listaLibros.toString(), "Lista de Libros", JOptionPane.INFORMATION_MESSAGE);
    }

 

     public Libro buscarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null; // Retorna null si el libro no se encuentra
     }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

     public Usuario buscarUsuario(String nombre) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                return usuario;
            }
        }
        return null; // Retorna null si el usuario no se encuentra

}}