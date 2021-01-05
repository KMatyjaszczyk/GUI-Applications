import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Testowy {
    private JButton buttonKopiuj;
    private JTextField textDoWpisania;
    private JLabel labelTytul;
    private JLabel labelWyswietlanie;
    private JPanel panel;

    public Testowy() {
        buttonKopiuj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelWyswietlanie.setText(textDoWpisania.getText() + " JD");
            }
        });
    }

    public static void main(String[] args) {
        JFrame ramka = new JFrame("Testujemy");
        ramka.setContentPane(new Testowy().panel);
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ramka.setMinimumSize(new Dimension(400, 400));
        ramka.pack();
        ramka.setVisible(true);
    }

}
