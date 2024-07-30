package compania_de_television;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class CompaniaTest {
    private Compania compania;

    @Before
    public void setUp() {
        compania = new Compania();
    }

    @Test
    public void dadoQueExisteUnaCompaniaSePuedeAgregarUnCliente() throws ClienteExistenteException {
        Cliente cliente = new Cliente("12345678", "Juan", "Perez", 30);
        compania.agregarCliente(cliente);
        assertTrue(compania.listarClientesOrdenadosPorDni().contains(cliente));
    }

    @Test(expected = ClienteExistenteException.class)
    public void dadoQueExisteUnaCompaniaAlAgregarUnClienteExistenteSeLanzaUnaClienteExistenteException() throws ClienteExistenteException {
        Cliente cliente = new Cliente("12345678", "Juan", "Perez", 30);
        compania.agregarCliente(cliente);
        compania.agregarCliente(cliente);
    }

    @Test
    public void dadoQueExisteUnaCompaniaConUnPlanBasicoYUnPlanPremiumCuandoSeObtieneElPrecioDeUnPlanPremiumDevuelve6000() {
        Plan planBasico = new PlanBasico("1", "Basico");
        Plan planPremium = new PlanPremium("2", "Premium");
        compania.agregarPlan(planBasico);
        compania.agregarPlan(planPremium);
        assertEquals(6000, compania.obtenerPrecioPlan("2"), 0.01);
    }

    @Test
    public void dadoQueExisteUnaCompaniaConClientesSePuedenListarLosClientesOrdenadosDeManeraAscendentePorSuDni() throws ClienteExistenteException {
        Cliente cliente1 = new Cliente("12345678", "Juan", "Perez", 30);
        Cliente cliente2 = new Cliente("87654321", "Ana", "Lopez", 25);
        compania.agregarCliente(cliente1);
        compania.agregarCliente(cliente2);
        List<Cliente> clientesOrdenados = compania.listarClientesOrdenadosPorDni();
        assertEquals(cliente1, clientesOrdenados.get(0));
        assertEquals(cliente2, clientesOrdenados.get(1));
    }

    @Test
    public void dadoQueExisteUnaCompaniaConSuscripcionesAPlanesBasicosYPremiumSePuedenListarLasSuscripcionesAPlanesPremium() {
        Plan planBasico = new PlanBasico("1", "Basico");
        Plan planPremium = new PlanPremium("2", "Premium");
        Cliente cliente = new Cliente("12345678", "Juan", "Perez", 30);
        List<Canal> canales = new ArrayList<>();
        Suscripcion suscripcion = new Suscripcion("1", cliente, planPremium, canales);
        compania.agregarPlan(planBasico);
        compania.agregarPlan(planPremium);
        compania.agregarSuscripcion(suscripcion);
        assertTrue(compania.listarSuscripcionesAPremium().contains(suscripcion));
    }

    @Test
    public void dadoQueExisteUnaCompaniaConSuscripcionesAPlanesBasicosYPremiumSePuedenListarLosClientesSuscritosAPlanesBasicos() {
        Plan planBasico = new PlanBasico("1", "Basico");
        Plan planPremium = new PlanPremium("2", "Premium");
        Cliente cliente = new Cliente("12345678", "Juan", "Perez", 30);
        List<Canal> canales = new ArrayList<>();
        Suscripcion suscripcion = new Suscripcion("1", cliente, planBasico, canales);
        compania.agregarPlan(planBasico);
        compania.agregarPlan(planPremium);
        compania.agregarSuscripcion(suscripcion);
        assertTrue(compania.listarClientesConPlanBasico().contains(cliente));
    }

    @Test
    public void dadoQueExisteUnaCompaniaConSuscripcionesAPlanesBasicosYPremiumSePuedeMostrarElTotalDePrecioParaUnPlanBasicoOPremium() {
        Plan planBasico = new PlanBasico("1", "Basico");
        Plan planPremium = new PlanPremium("2", "Premium");
        compania.agregarPlan(planBasico);
        compania.agregarPlan(planPremium);
        assertEquals(5000, compania.obtenerPrecioPlan("1"), 0.01);
        assertEquals(6000, compania.obtenerPrecioPlan("2"), 0.01);
    }

    @Test
    public void dadoQueExisteUnCompaniaConClientesSuscritosAPlanesBasicosOPremiumSePuedeObtenerUnMapaConElPlanComoClaveYUnaListaDeClientesOrdenadosDeManeraDescendentePorDniDelClienteComoValores() {
        Plan planBasico = new PlanBasico("1", "Basico");
        Plan planPremium = new PlanPremium("2", "Premium");
        Cliente cliente1 = new Cliente("12345678", "Juan", "Perez", 30);
        Cliente cliente2 = new Cliente("87654321", "Ana", "Lopez", 25);
        List<Canal> canales = new ArrayList<>();
        Suscripcion suscripcion1 = new Suscripcion("1", cliente1, planBasico, canales);
        Suscripcion suscripcion2 = new Suscripcion("2", cliente2, planPremium, canales);
        compania.agregarPlan(planBasico);
        compania.agregarPlan(planPremium);
        compania.agregarSuscripcion(suscripcion1);
        compania.agregarSuscripcion(suscripcion2);
        Map<Plan, List<Cliente>> mapa = compania.obtenerMapaDeClientesPorPlan();
        assertEquals(cliente1, mapa.get(planBasico).get(0));
        assertEquals(cliente2, mapa.get(planPremium).get(0));
    }
}