package compania_de_television;

import java.util.List;

import java.util.List;

public class Suscripcion {
    private String id;
    private Cliente cliente;
    private Plan plan;
    private List<Canal> canales;

    public Suscripcion(String id, Cliente cliente, Plan plan, List<Canal> canales) {
        this.id = id;
        this.cliente = cliente;
        this.plan = plan;
        this.canales = canales;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public List<Canal> getCanales() {
        return canales;
    }

    public void setCanales(List<Canal> canales) {
        this.canales = canales;
    }
}

