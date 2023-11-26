
package bibliotecaapp;
import bibliotecaapp.Exceptions.DevolucionFueraDePlazoException;
import javax.swing.JOptionPane;


public class BibliotecaApp {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "1. Agregar libro\n2. Eliminar libro\n3. Mostrar libros\n" +
                    "4. Agregar usuario\n5. Ver libros alquilados por usuario\n" +
                    "6. Alquilar libro\n7. Devolver libro\n8. Salir");

            switch (opcion) {
                case "1":
                    // Lógica para agregar un libro
                    String titulo = JOptionPane.showInputDialog("Ingrese el título del libro:");
                    String autor = JOptionPane.showInputDialog("Ingrese el autor del libro:");
                    String genero = JOptionPane.showInputDialog("Ingrese el género del libro:");
                    Libro nuevoLibro = new Libro(titulo, autor, genero);
                    biblioteca.agregarLibro(nuevoLibro);
                    break;
                case "2":
                    // Lógica para eliminar un libro
                    String tituloEliminar = JOptionPane.showInputDialog("Ingrese el título del libro a eliminar:");
                    Libro libroEliminar = biblioteca.buscarLibro(tituloEliminar);
                    if (libroEliminar != null) {
                        biblioteca.eliminarLibro(libroEliminar);
                        JOptionPane.showMessageDialog(null, "Libro eliminado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Libro no encontrado.");
                    }
                    break;
                case "3":
                    biblioteca.mostrarLibros();
                    break;
                case "4":
                    // Lógica para agregar un usuario
                    String nombreUsuario = JOptionPane.showInputDialog("Ingrese el nombre del usuario:");
                    Usuario nuevoUsuario = new Usuario(nombreUsuario);
                    biblioteca.agregarUsuario(nuevoUsuario);
                    break;
                case "5":
                    // Lógica para ver libros alquilados por usuario
                    String nombreUsuarioConsulta = JOptionPane.showInputDialog("Ingrese el nombre del usuario:");
                    Usuario usuarioConsulta = biblioteca.buscarUsuario(nombreUsuarioConsulta);
                    if (usuarioConsulta != null) {
                        String mensaje = usuarioConsulta.getLibrosAlquilados().isEmpty() ?
                                "El usuario no tiene libros alquilados." :
                                "Libros alquilados por el usuario:\n";
                        for (Libro libro : usuarioConsulta.getLibrosAlquilados()) {
                            mensaje += "- " + libro.getTitulo() + "\n";
                        }
                        JOptionPane.showMessageDialog(null, mensaje);
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
                    }
                    break;
                case "6":
                    // Lógica para alquilar un libro
                    String nombreUsuarioAlquiler = JOptionPane.showInputDialog("Ingrese el nombre del usuario:");
                    Usuario usuarioAlquiler = biblioteca.buscarUsuario(nombreUsuarioAlquiler);
                    if (usuarioAlquiler != null) {
                        String tituloLibroAlquiler = JOptionPane.showInputDialog("Ingrese el título del libro a alquilar:");
                        Libro libroAlquiler = biblioteca.buscarLibro(tituloLibroAlquiler);
                        if (libroAlquiler != null) {
                            usuarioAlquiler.alquilarLibro(libroAlquiler);
                            JOptionPane.showMessageDialog(null, "Libro alquilado correctamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Libro no encontrado.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
                    }
                    break;
                case "7":
                    // Lógica para devolver un libro
                    String nombreUsuarioDevolucion = JOptionPane.showInputDialog("Ingrese el nombre del usuario:");
                    Usuario usuarioDevolucion = biblioteca.buscarUsuario(nombreUsuarioDevolucion);
                    if (usuarioDevolucion != null) {
                        String tituloLibroDevolucion = JOptionPane.showInputDialog("Ingrese el título del libro a devolver:");
                        Libro libroDevolucion = biblioteca.buscarLibro(tituloLibroDevolucion);
                        if (libroDevolucion != null) {
                            try {
                                usuarioDevolucion.devolverLibro(libroDevolucion);
                                JOptionPane.showMessageDialog(null, "Libro devuelto correctamente.");
                            } catch (DevolucionFueraDePlazoException e) {
                                JOptionPane.showMessageDialog(null, "Devolución fuera de plazo.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Libro no encontrado.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
                    }
                    break;
                case "8":
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        }
    }
}
