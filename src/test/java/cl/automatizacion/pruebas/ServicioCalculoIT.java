package cl.automatizacion.pruebas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioCalculoIT {

    @Test
    void deberiaCalcularPromedioIntegrandoCalculadoraYServicio() {
        Calculadora calculadora = new Calculadora();
        ServicioCalculo servicio = new ServicioCalculo(calculadora);

        double resultado = servicio.calcularPromedio(8, 4);

        assertEquals(6.0, resultado);
    }

    @Test
    void deberiaCalcularTotalIntegrandoCalculadoraYServicio() {
        Calculadora calculadora = new Calculadora();
        ServicioCalculo servicio = new ServicioCalculo(calculadora);

        int resultado = servicio.calcularTotalConCantidad(2500, 4);

        assertEquals(10000, resultado);
    }
}