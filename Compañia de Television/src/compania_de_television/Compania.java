package compania_de_television;

import java.util.*;
import java.util.stream.Collectors;

public class Compania {
    private Map<String, Cliente> clientes;
    private Map<String, Plan> planes;
    private Map<String, Suscripcion> suscripciones;

    public Compania() {
        this.clientes = new HashMap<>();
        this.planes = new HashMap<>();
        this.suscripciones = new HashMap<>();
    }

    // Métodos de gestión
    public void agregarCliente(Cliente cliente) throws ClienteExistenteException {
        if (clientes.containsKey(cliente.getDni())) {
            throw new ClienteExistenteException("El cliente con DNI " + cliente.getDni() + " ya existe.");
        }
        clientes.put(cliente.getDni(), cliente);
    }

    public void agregarPlan(Plan plan) {
        planes.put(plan.getId(), plan);
    }

    public void agregarSuscripcion(Suscripcion suscripcion) {
        suscripciones.put(suscripcion.getId(), suscripcion);
    }

    public double obtenerPrecioPlan(String planId) {
        Plan plan = planes.get(planId);
        if (plan != null) {
            return plan.calcularPrecio();
        }
        return 0;
    }

    public List<Cliente> listarClientesOrdenadosPorDni() {
        return clientes.values().stream()
                .sorted(Comparator.comparing(Cliente::getDni))
                .collect(Collectors.toList());
    }

    public List<Suscripcion> listarSuscripcionesAPremium() {
        return suscripciones.values().stream()
                .filter(s -> s.getPlan() instanceof PlanPremium)
                .collect(Collectors.toList());
    }

    public List<Cliente> listarClientesConPlanBasico() {
        return suscripciones.values().stream()
                .filter(s -> s.getPlan() instanceof PlanBasico)
                .map(Suscripcion::getCliente)
                .collect(Collectors.toList());
    }

    public Map<Plan, List<Cliente>> obtenerMapaDeClientesPorPlan() {
        return suscripciones.values().stream()
                .collect(Collectors.groupingBy(Suscripcion::getPlan,
                        Collectors.mapping(Suscripcion::getCliente,
                                Collectors.toList())));
    }

    // Getters and Setters
    public Map<String, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Map<String, Cliente> clientes) {
        this.clientes = clientes;
    }

    public Map<String, Plan> getPlanes() {
        return planes;
    }

    public void setPlanes(Map<String, Plan> planes) {
        this.planes = planes;
    }

    public Map<String, Suscripcion> getSuscripciones() {
        return suscripciones;
    }

    public void setSuscripciones(Map<String, Suscripcion> suscripciones) {
        this.suscripciones = suscripciones;
    }
}

