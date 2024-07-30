package compania_de_television;

public class PlanBasico extends Plan {
    private static final double PRECIO_BASE = 5000;

    public PlanBasico(String id, String nombre) {
        super(id, nombre);
    }

    @Override
    public double calcularPrecio() {
        return PRECIO_BASE;
    }
}

