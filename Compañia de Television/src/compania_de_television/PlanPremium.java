package compania_de_television;

public class PlanPremium extends Plan {
    private static final double PRECIO_BASE = 5000;
    private static final double RECARGO = 0.2;

    public PlanPremium(String id, String nombre) {
        super(id, nombre);
    }

    @Override
    public double calcularPrecio() {
        return PRECIO_BASE * (1 + RECARGO);
    }
}

