package compania_de_television;

public abstract class Plan {
    protected String id;
    protected String nombre;

    public Plan(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract double calcularPrecio();
}

