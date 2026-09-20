package cl.automatizacion.pruebas;

public class ServicioCalculo {

    private final Calculadora calculadora;

    public ServicioCalculo(Calculadora calculadora) {
        this.calculadora = calculadora;
    }

    public double calcularPromedio(int a, int b) {
        int suma = calculadora.sumar(a, b);
        return calculadora.dividir(suma, 2);
    }

    public int calcularTotalConCantidad(int valor, int cantidad) {
        return calculadora.multiplicar(valor, cantidad);
    }
}