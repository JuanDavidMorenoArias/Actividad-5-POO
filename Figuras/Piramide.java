package Figuras;

public class Piramide extends FiguraGeometrica {
    private double base;
    private double altura;
    private double apotema;

    public Piramide(double base, double altura, double apotema) {
        this.base = base;
        this.altura = altura;
        this.apotema = apotema;
        this.setVolumen(this.calcularVolumen());
        this.setSuperficie(this.calcularSuperficie());
    }

    public double calcularVolumen() {
        double volumen = Math.pow(this.base, 2.0) * this.altura / 3.0;
        return volumen;
    }

    public double calcularSuperficie() {
        double areaBase = Math.pow(this.base, 2.0);
        double areaLado = 2.0 * this.base * this.apotema;
        return areaBase + areaLado;
    }
}