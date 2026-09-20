package cl.automatizacion.pruebas.acceptance;

import cl.automatizacion.pruebas.Calculadora;
import cl.automatizacion.pruebas.ServicioCalculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraAcceptanceTest {

    @Test
    void usuarioPuedeCalcularPromedio() {
        Calculadora calculadora = new Calculadora();
        ServicioCalculo servicio = new ServicioCalculo(calculadora);

        double resultado = servicio.calcularPromedio(10, 20);

        assertEquals(15.0, resultado);
    }

    @Test
    void usuarioPuedeCalcularTotalSegunCantidad() {
        Calculadora calculadora = new Calculadora();
        ServicioCalculo servicio = new ServicioCalculo(calculadora);

        int resultado = servicio.calcularTotalConCantidad(100, 3);

        assertEquals(300, resultado);
    }
}