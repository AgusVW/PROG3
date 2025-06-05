package tp6_greedy;

public class Cancion implements Comparable<Cancion>{
    private String nombre,genero;
    private int peso,duracion;
    
    public Cancion(String nombre, String genero, int peso, int duracion) {
        this.nombre = nombre;
        this.genero = genero;
        this.peso = peso;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public int compareTo(Cancion o) {
        return Integer.compare(this.getPeso(), o.getPeso());
    }

    @Override
    public String toString() {
        return "Cancion [nombre=" + nombre + ", genero=" + genero + ", peso=" + peso + ", duracion=" + duracion + "]";
    }
}
