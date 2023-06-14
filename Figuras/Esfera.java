package Figuras;

public class Esfera extends FiguraGeometrica {
    private double radio;

    public Esfera(double radio) {
        this.radio = radio;
        this.setVolumen(this.calcularVolumen());
        this.setSuperficie(this.calcularSuperficie());
    }

    public double calcularVolumen() {
        double volumen = 4.187743007235194 * Math.pow(this.radio, 3.0);
        return volumen;
    }

    public double calcularSuperficie() {
        double superficie = 12.566370614359172 * Math.pow(this.radio, 2.0);
        return superficie;
    }
}