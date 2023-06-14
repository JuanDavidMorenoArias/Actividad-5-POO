package Figuras;

public class Cilindro extends FiguraGeometrica {
    private double radio;
    private double altura;

    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
        this.setVolumen(this.calcularVolumen());
        this.setSuperficie(this.calcularSuperficie());
    }

    public double calcularVolumen() {
        double volumen = Math.PI * this.altura * Math.pow(this.radio, 2.0);
        return volumen;
    }

    public double calcularSuperficie() {
        double areaLadoA = 6.283185307179586 * this.radio * this.altura;
        double areaLadoB = 6.283185307179586 * Math.pow(this.radio, 2.0);
        return areaLadoA + areaLadoB;
    }
}
