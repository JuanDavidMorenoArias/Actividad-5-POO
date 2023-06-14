package Figuras;

import java.awt.Component;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VentanaPiramide extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel base;
    private JLabel altura;
    private JLabel apotema;
    private JLabel volumen;
    private JLabel superficie;
    private JTextField campoBase;
    private JTextField campoAltura;
    private JTextField campoApotema;
    private JButton calcular;

    public VentanaPiramide() {
        this.inicio();
        this.setTitle("Piramide");
        this.setSize(280, 240);
        this.setLocationRelativeTo((Component)null);
        this.setResizable(false);
    }

    private void inicio() {
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout((LayoutManager)null);
        this.base = new JLabel();
        this.base.setText("Base (cms):");
        this.base.setBounds(20, 20, 135, 23);
        this.campoBase = new JTextField();
        this.campoBase.setBounds(120, 20, 135, 23);
        this.altura = new JLabel();
        this.altura.setText("Altura (cms):");
        this.altura.setBounds(20, 50, 135, 23);
        this.campoAltura = new JTextField();
        this.campoAltura.setBounds(120, 50, 135, 23);
        this.apotema = new JLabel();
        this.apotema.setText("Apotema (cms):");
        this.apotema.setBounds(20, 80, 135, 23);
        this.campoApotema = new JTextField();
        this.campoApotema.setBounds(120, 80, 135, 23);
        this.calcular = new JButton();
        this.calcular.setText("Calcular");
        this.calcular.setBounds(120, 110, 135, 23);
        this.calcular.addActionListener(this);
        this.volumen = new JLabel();
        this.volumen.setText("Volumen (cm3):");
        this.volumen.setBounds(20, 140, 135, 23);
        this.superficie = new JLabel();
        this.superficie.setText("Superficie (cm2):");
        this.superficie.setBounds(20, 170, 135, 23);
        this.contenedor.add(this.base);
        this.contenedor.add(this.campoBase);
        this.contenedor.add(this.altura);
        this.contenedor.add(this.campoAltura);
        this.contenedor.add(this.apotema);
        this.contenedor.add(this.campoApotema);
        this.contenedor.add(this.calcular);
        this.contenedor.add(this.volumen);
        this.contenedor.add(this.superficie);
    }

    public void actionPerformed(ActionEvent event) {
        boolean error = false;
        double base = 0.0;
        double altura = 0.0;
        double apotema = 0.0;

        try {
            base = Double.parseDouble(this.campoBase.getText());
            altura = Double.parseDouble(this.campoAltura.getText());
            apotema = Double.parseDouble(this.campoApotema.getText());
            Piramide pirámide = new Piramide(base, altura, apotema);
            JLabel var10000 = this.volumen;
            Object[] var10002 = new Object[]{pirámide.calcularVolumen()};
            var10000.setText("Volumen (cm3): " + String.format("%.2f", var10002));
            var10000 = this.superficie;
            var10002 = new Object[]{pirámide.calcularSuperficie()};
            var10000.setText("Superficie (cm2): " + String.format("%.2f", var10002));
        } catch (Exception var14) {
            error = true;
        } finally {
            if (error) {
                JOptionPane.showMessageDialog((Component)null, "Campo nulo o error en formato de número", "Error", 0);
            }

        }

    }
}