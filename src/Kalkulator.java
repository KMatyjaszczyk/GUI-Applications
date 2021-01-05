import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Kalkulator {
    private static final JFrame ramka = new JFrame("Kalkulator");
    private JPanel panel;
    private JTextArea textA;
    private JTextArea textB;
    private JButton buttonPlus;
    private JButton buttonMinus;
    private JTextArea textWynik;
    private JButton buttonMnozenie;
    private JButton buttonDzielenie;
    private JButton buttonPotega;
    private JButton buttonPierwiastek;
    private JFormattedTextField fTextStopnie;
    private JFormattedTextField fTextRadiany;
    private JButton buttonStR;
    private JButton buttonRSt;
    private JFormattedTextField fTextDziesietny;
    private JFormattedTextField fTextBinarny;
    private JButton buttonDzNaBin;
    private JButton buttonBinNaDz;

    public Kalkulator() {

        Icon img = new ImageIcon(Kalkulator.class.getResource("iconBig.png"));

        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(textA.getText());
                    double b = Double.parseDouble(textB.getText());
                    textWynik.setText(String.valueOf( a + b ));
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ramka, "Nie wprowadziłeś liczb(y)!", "Błąd", JOptionPane.ERROR_MESSAGE, img);
                }
            }
        });

        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(textA.getText());
                    double b = Double.parseDouble(textB.getText());
                    textWynik.setText(String.valueOf( a - b ));
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ramka, "Nie wprowadziłeś liczb(y)!", "Błąd", JOptionPane.ERROR_MESSAGE, img);
                }
            }
        });

        buttonMnozenie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(textA.getText());
                    double b = Double.parseDouble(textB.getText());
                    textWynik.setText(String.valueOf( a * b ));
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ramka, "Nie wprowadziłeś liczb(y)!", "Błąd", JOptionPane.ERROR_MESSAGE, img);
                }
            }
        });

        buttonDzielenie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(textA.getText());
                    double b = Double.parseDouble(textB.getText());
                    if (b == 0) throw new ArithmeticException("Błąd dzielenia przez 0!");
                    textWynik.setText(String.valueOf( a / b ));
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ramka, "Nie wprowadziłeś liczb(y)!", "Błąd", JOptionPane.ERROR_MESSAGE, img);
                } catch (ArithmeticException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ramka, ex.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE, img);
                }
            }
        });

        buttonPotega.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(textA.getText());
                    double b = Double.parseDouble(textB.getText());
                    textWynik.setText(String.valueOf( Math.pow(a, b) ));
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ramka, "Nie wprowadziłeś liczb(y)!", "Błąd", JOptionPane.ERROR_MESSAGE, img);
                }
            }
        });
        buttonPierwiastek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(textA.getText());
                    if (a < 0 ) throw new ArithmeticException("Nie można pierwiastkować liczny ujemnej!\nPrzynajmniej w dziedzinie liczb rzeczywistych");
                    textWynik.setText(String.valueOf( Math.sqrt(a) ));
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ramka, "Nie wprowadziłeś liczby!", "Błąd", JOptionPane.ERROR_MESSAGE, img);
                } catch (ArithmeticException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ramka, ex.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE, img);
                }
            }
        });

        buttonPlus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Random rn = new Random();
                buttonPlus.setBackground(new Color(rn.nextInt(256), rn.nextInt(256), rn.nextInt(256)));
            }
        });

        buttonMinus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Random rn = new Random();
                buttonMinus.setBackground(new Color(rn.nextInt(256), rn.nextInt(256), rn.nextInt(256)));
            }
        });

        buttonMnozenie.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Random rn = new Random();
                buttonMnozenie.setBackground(new Color(rn.nextInt(256), rn.nextInt(256), rn.nextInt(256)));
            }
        });

        buttonDzielenie.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Random rn = new Random();
                buttonDzielenie.setBackground(new Color(rn.nextInt(256), rn.nextInt(256), rn.nextInt(256)));
            }
        });

        buttonPotega.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Random rn = new Random();
                buttonPotega.setBackground(new Color(rn.nextInt(256), rn.nextInt(256), rn.nextInt(256)));
            }
        });

        buttonPierwiastek.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Random rn = new Random();
                buttonPierwiastek.setBackground(new Color(rn.nextInt(256), rn.nextInt(256), rn.nextInt(256)));
            }
        });

        buttonStR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double stopnie = Double.parseDouble(fTextStopnie.getText());
                    fTextRadiany.setText(String.valueOf( Math.toRadians(stopnie) ));
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ramka, "Nie podałeś liczby stopni!", "Błąd", JOptionPane.ERROR_MESSAGE, img);
                }
            }
        });

        buttonRSt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double radiany = Double.parseDouble(fTextRadiany.getText());
                    fTextStopnie.setText(String.valueOf( Math.toDegrees(radiany) ));
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ramka, "Nie podałeś liczby radianów!", "Błąd", JOptionPane.ERROR_MESSAGE, img);
                }
            }
        });

        buttonDzNaBin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int dziesietny = Integer.parseInt(fTextDziesietny.getText());
                    fTextBinarny.setText( Integer.toBinaryString(dziesietny) );
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ramka, "Nie podałeś liczby całkowitej!", "Błąd", JOptionPane.ERROR_MESSAGE, img);
                }
            }
        });

        buttonBinNaDz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String binarny = fTextBinarny.getText();
                    fTextDziesietny.setText(String.valueOf( Integer.parseInt(binarny, 2) ));
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ramka, "Nie podałeś liczby binarnej!", "Błąd", JOptionPane.ERROR_MESSAGE, img);
                }
            }
        });

    }

    public static void main(String[] args) {
        ramka.setContentPane(new Kalkulator().panel);
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setMinimumSize(new Dimension(350, 250));
        ramka.setIconImage(new ImageIcon(Kalkulator.class.getResource("icon.png")).getImage());
        ramka.pack();
        ramka.setVisible(true);
    }
}
