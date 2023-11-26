package bibliotecaapp;

import java.util.Objects;

public class Libro {
    private String titulo;
    private String autor;
    private String genero;
    private boolean disponible;

    // Constructor
    public Libro(String titulo, String autor, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.disponible = true; // Por defecto, el libro está disponible al crearse.
    }

    // Getters y setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    //  método para marcar el libro como prestado/devuelto, etc.
    public void marcarComoPrestado() {
        this.disponible = false;
    }

    public void marcarComoDevuelto() {
        this.disponible = true;
    }

    // Sobrescribir el método equals para comparar objetos Libro
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(titulo, libro.titulo) &&
               Objects.equals(autor, libro.autor) &&
               Objects.equals(genero, libro.genero);
    }

    // Sobrescribir el método hashCode para comparar objetos Libro
    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, genero);
    }
}
