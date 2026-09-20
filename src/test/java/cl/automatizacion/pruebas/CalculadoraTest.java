package cl.automatizacion.pruebas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraTest {

    private final Calculadora calculadora = new Calculadora();

    @Test
    void deberiaSumarDosNumeros() {
        assertEquals(8, calculadora.sumar(5, 3));
    }

    @Test
    void deberiaRestarDosNumeros() {
        assertEquals(6, calculadora.restar(10, 4));
    }

    @Test
    void deberiaMultiplicarDosNumeros() {
        assertEquals(20, calculadora.multiplicar(5, 4));
    }

    @Test
    void deberiaDividirDosNumeros() {
        assertEquals(5.0, calculadora.dividir(10, 2));
    }

    @Test
    void deberiaLanzarErrorAlDividirPorCero() {
        assertThrows(
            IllegalArgumentException.class,
            () -> calculadora.dividir(10, 0)
        );
    }
}