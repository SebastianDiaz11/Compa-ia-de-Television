package compania_de_television;

public class Canal {
    private int numero;
    private String nombre;
    private String tipo;
    private String clasificacion;

    public Canal(int numero, String nombre, String tipo, String clasificacion) {
        this.numero = numero;
        this.nombre = nombre;
        this.tipo = tipo;
        this.clasificacion = clasificacion;
    }

    // Getters and Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
}

