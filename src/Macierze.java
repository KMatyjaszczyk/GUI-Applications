import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Macierze {
    private static final JFrame ramka = new JFrame("Macierze");
    private JTextArea textAreaPrzyklad;
    private JButton buttonObliczMacierz;
    private JPanel panel;
    private JTextArea textAreaMacierz;
    private JFormattedTextField fTextFieldRozmiarMacierzy;

    public Macierze() {

        Icon img = new ImageIcon(Macierze.class.getResource("iconBig.png"));

        buttonObliczMacierz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int rozmiar = Integer.parseInt(fTextFieldRozmiarMacierzy.getText()); //ustalenie rozmiaru macierzy (liczbny niewiadomych)
                    //obrabianie danych
                    String dane = textAreaMacierz.getText();
                    double [][] macierz = utworzMacierz(rozmiar, dane);
                    //obliczanie macierzy metodą eliminacji Gaussa
                    double []wyniki = gaussPodstawowy(rozmiar, macierz);
                    //tworzenie wynikow
                    StringBuilder wynikBuilder = new StringBuilder();
                    if (wyniki != null) {
                        for (int i = 0; i < wyniki.length; i++) {
                            wynikBuilder.append("x").append(i + 1).append(" = ").append(String.format("%.2f", wyniki[i])).append("\n");
                        }
                    }
                    //wyswietlanie wynikow
                    String wynik = wynikBuilder.toString();
                    JOptionPane.showMessageDialog(ramka, wynik, "Rozwiązanie", JOptionPane.INFORMATION_MESSAGE, img);

                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ramka, "Nie podałeś liczby niewiadomych!", "Błąd", JOptionPane.ERROR_MESSAGE, img);
                } catch (Exception exception) {
                    exception.printStackTrace();
                    JOptionPane.showMessageDialog(ramka, "Program napotkał błąd...", "Błąd", JOptionPane.ERROR_MESSAGE, img);
                }
            }
        });

    }

    public static double[][] utworzMacierz(int n, String dane) {
        double [][]macierz = new double[n][n+1];
        String []tabN = dane.split("\n");

        for (int i = 0; i < tabN.length; i++) {
            String []rob = tabN[i].split(";");
            for (int j = 0; j < rob.length; j++) {
                macierz[i][j] = Double.parseDouble(rob[j]);
            }
        }
        /*
        //wyswietlanie
        for (int i = 0; i < macierz.length; i++) {
            for (int j = 0; j < macierz[i].length; j++) {
                System.out.print(macierz[i][j] + "  ");
            }
            System.out.println();
        }
        */
        return macierz;
    }

    public static double[] gaussPodstawowy(int n, double [][]macierz) {
        double []wyniki = new double[n];
        //utworzenie macierzy trojkatnej gornej
        for (int k = 0; k < n-1; k++) {
            if (Math.abs(macierz[k][k]) < 1e-7) {
                JOptionPane.showMessageDialog(ramka, "Zero na głównej przekątnej macierzy,\nnie policzę wyniku...", "Gauss nieudany", JOptionPane.WARNING_MESSAGE, new ImageIcon(Macierze.class.getResource("iconBig.png")));
                return null;
            }
            for (int i = k; i < n-1; i++) {
                double p = macierz[i+1][k] / macierz[k][k];
                for (int j = k; j < n+1; j++) {
                    macierz[i+1][j] = macierz[i+1][j] - (p * macierz[k][j]);
                }
            }
        }
        //postepowanie odwrotne
        wyniki[n-1] = macierz[n-1][n] / macierz[n-1][n-1];
        if (Math.abs(wyniki[n-1]) < 1e-7) wyniki[n-1] = 0; //zaokraglanie do 0
        for (int k = n-2; k >=0; k--) {
            double suma = 0;
            for (int j = k+1; j < n; j++) {
                suma += wyniki[j] * macierz[k][j];
            }
            wyniki[k] = (macierz[k][n] - suma) / macierz[k][k];
            if (Math.abs(wyniki[k]) < 1e-7) wyniki[k] = 0; //zaokraglanie do 0
        }

        return wyniki;
    }

    public static void main(String[] args) {
        ramka.setContentPane(new Macierze().panel);
        ramka.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ramka.setIconImage(new ImageIcon(Kalkulator.class.getResource("icon.png")).getImage());
        ramka.setMinimumSize(new Dimension(350, 250));
        ramka.pack();
        ramka.setVisible(true);
    }
}
