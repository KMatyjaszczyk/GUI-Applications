import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class Testowy {
    private static final JFrame ramka = new JFrame("Testujemy");
    private JButton buttonKopiuj;
    private JTextField textDoWpisania;
    private JLabel labelTytul;
    private JPanel panel;
    private JComboBox<String> comboBoxKoncowka;
    private JScrollBar scrollBarHor;
    private JLabel wartoscPaskaHor;
    private JScrollBar scrollBarVer;
    private JLabel wartoscPaskaVer;
    private JTextArea textAreaWynik;

    public Testowy() {

        comboBoxKoncowka.addItem("");
        comboBoxKoncowka.addItem("XD");
        comboBoxKoncowka.addItem("JD");
        comboBoxKoncowka.addItem("ale jajca");

        buttonKopiuj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indexComboBoxa = comboBoxKoncowka.getSelectedIndex();
                textAreaWynik.setText(textDoWpisania.getText() + " " + comboBoxKoncowka.getItemAt(indexComboBoxa));
            }
        });

        scrollBarHor.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                wartoscPaskaHor.setText("" + scrollBarHor.getValue());
                ramka.setSize(scrollBarHor.getValue(), scrollBarVer.getValue());
                textAreaWynik.setSize(scrollBarHor.getValue()-800, 400);
            }
        });
        scrollBarVer.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                wartoscPaskaVer.setText("" + scrollBarVer.getValue());
                ramka.setSize(scrollBarHor.getValue(), scrollBarVer.getValue());
            }
        });
    }

    public static void main(String[] args) {
        ramka.setContentPane(new Testowy().panel);
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setMinimumSize(new Dimension(900, 400));
        ramka.setMaximumSize(new Dimension(1200, 800));
        ramka.pack();
        ramka.setVisible(true);
    }

}
