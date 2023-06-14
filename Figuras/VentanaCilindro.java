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

public class VentanaCilindro extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radio;
    private JLabel altura;
    private JLabel volumen;
    private JLabel superficie;
    private JTextField campoRadio;
    private JTextField campoAltura;
    private JButton calcular;

    public VentanaCilindro() {
        this.inicio();
        this.setTitle("Cilindro");
        this.setSize(280, 210);
        this.setLocationRelativeTo((Component)null);
        this.setResizable(false);
    }

    private void inicio() {
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout((LayoutManager)null);
        this.radio = new JLabel();
        this.radio.setText("Radio (cms):");
        this.radio.setBounds(20, 20, 135, 23);
        this.campoRadio = new JTextField();
        this.campoRadio.setBounds(100, 20, 135, 23);
        this.altura = new JLabel();
        this.altura.setText("Altura (cms):");
        this.altura.setBounds(20, 50, 135, 23);
        this.campoAltura = new JTextField();
        this.campoAltura.setBounds(100, 50, 135, 23);
        this.calcular = new JButton();
        this.calcular.setText("Calcular");
        this.calcular.setBounds(100, 80, 135, 23);
        this.calcular.addActionListener(this);
        this.volumen = new JLabel();
        this.volumen.setText("Volumen (cm3):");
        this.volumen.setBounds(20, 110, 135, 23);
        this.superficie = new JLabel();
        this.superficie.setText("Superficie (cm2):");
        this.superficie.setBounds(20, 140, 135, 23);
        this.contenedor.add(this.radio);
        this.contenedor.add(this.campoRadio);
        this.contenedor.add(this.altura);
        this.contenedor.add(this.campoAltura);
        this.contenedor.add(this.calcular);
        this.contenedor.add(this.volumen);
        this.contenedor.add(this.superficie);
    }

    public void actionPerformed(ActionEvent event) {
        boolean error = false;
        double radio = 0.0;
        double altura = 0.0;

        try {
            radio = Double.parseDouble(this.campoRadio.getText());
            altura = Double.parseDouble(this.campoAltura.getText());
            Cilindro cilindro = new Cilindro(radio, altura);
            JLabel var10000 = this.volumen;
            Object[] var10002 = new Object[]{cilindro.calcularVolumen()};
            var10000.setText("Volumen (cm3): " + String.format("%.2f", var10002));
            var10000 = this.superficie;
            var10002 = new Object[]{cilindro.calcularSuperficie()};
            var10000.setText("Superficie (cm2): " + String.format("%.2f", var10002));
        } catch (Exception var11) {
            error = true;
        } finally {
            if (error) {
                JOptionPane.showMessageDialog((Component)null, "Campo nulo o error en el formato de numero", "Error", 0);
            }

        }

    }
}
