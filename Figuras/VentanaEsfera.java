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

public class VentanaEsfera extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radio;
    private JLabel volumen;
    private JLabel superficie;
    private JTextField campoRadio;
    private JButton calcular;

    public VentanaEsfera() {
        this.inicio();
        this.setTitle("Esfera");
        this.setSize(280, 200);
        this.setLocationRelativeTo((Component)null);
        this.setResizable(false);
    }

    private void inicio() {
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout((LayoutManager)null);
        this.radio = new JLabel();
        this.radio.setText("Radio (cms): ");
        this.radio.setBounds(20, 20, 135, 23);
        this.campoRadio = new JTextField();
        this.campoRadio.setBounds(100, 20, 135, 23);
        this.calcular = new JButton();
        this.calcular.setText("Calcular");
        this.calcular.setBounds(100, 50, 135, 23);
        this.calcular.addActionListener(this);
        this.volumen = new JLabel();
        this.volumen.setText("Volumen (cm3):");
        this.volumen.setBounds(20, 90, 135, 23);
        this.superficie = new JLabel();
        this.superficie.setText("Superficie (cm2):");
        this.superficie.setBounds(20, 120, 135, 23);
        this.contenedor.add(this.radio);
        this.contenedor.add(this.campoRadio);
        this.contenedor.add(this.calcular);
        this.contenedor.add(this.volumen);
        this.contenedor.add(this.superficie);
    }

    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.calcular) {
            boolean error = false;

            try {
                double radio = Double.parseDouble(this.campoRadio.getText());
                Esfera esfera = new Esfera(radio);
                JLabel var10000 = this.volumen;
                Object[] var10002 = new Object[]{esfera.calcularVolumen()};
                var10000.setText("Volumen (cm3):" + String.format("%.2f", var10002));
                var10000 = this.superficie;
                var10002 = new Object[]{esfera.calcularSuperficie()};
                var10000.setText("Superficie (cm2):" + String.format("%.2f", var10002));
            } catch (Exception var9) {
                error = true;
            } finally {
                if (error) {
                    JOptionPane.showMessageDialog((Component)null, "Campo nulo o error en formato de numero", "Error", 0);
                }

            }
        }

    }
}
