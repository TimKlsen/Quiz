import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quizfenster {
    public static int o=0;
    public Quizfenster()
    {
        JFrame frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JTextArea frage = new JTextArea();
        frage.setSize(600, 300);
        frame.add(frage, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(0,3));
        frame.add(panel, BorderLayout.PAGE_END);
        panel.setPreferredSize(new Dimension(600,100));
        JButton antwort1 = new JButton();
        JButton antwort2 = new JButton();
        JButton antwort3 = new JButton();
        JButton antwort4 = new JButton();
        JButton exit = new JButton("Beenden");
        JButton next = new JButton("Neue Frage");
        exit.addActionListener(ActionListener  -> System.exit(0)); //Das Spiel wird sofort beendet

        next.addActionListener(new ActionListener() { //Die Felder werden solange aktualisiert mit neuen Fragen, bis alle Objekte aus der Liste verwendet wurden.
            @Override

            public void actionPerformed(ActionEvent e) {


                if(o<Frage.Fragen.size())
                {
                    Frage.neueFrage(frage,antwort1,antwort2,antwort3,antwort4,Frage.Fragen.get(o));
                    o++;
                } else if (Frage.Fragen.isEmpty()) { //Sind keine Fragen verfügbar bzw. ist die Liste leer, wird ein Pop-Up Fenster erstellt und der Anwender darüber informiert.
                    JFrame popup = new JFrame("Hinweis!");
                    popup.setLocationRelativeTo(null);
                    popup.setLayout(new GridLayout(0,1));
                    popup.setSize(300,100);
                    JLabel info = new JLabel("Keine Fragen verfügbar!");
                    JButton close = new JButton("Schließen");
                    close.addActionListener(ActionListener -> popup.dispose());
                    popup.add(info,0);
                    popup.add(close,1);
                    popup.setVisible(true);
                } else // Sind keine Fragen mehr verfügbar ist das Spiel beendet und der Anwender wird darüber in einem Pop-Up Fenster darüber informiert.
                {
                    JFrame popup = new JFrame("Hinweis!");
                    popup.setLocationRelativeTo(null);
                    popup.setSize(300,100);
                    popup.setLayout(new GridLayout(0,1));
                    JLabel info = new JLabel("Es sind keine Fragen mehr verfügbar!");
                    JButton close = new JButton("Schließen");
                    close.addActionListener(ActionListener -> popup.dispose());
                    popup.add(info,0);
                    popup.add(close,1);
                    popup.setVisible(true);
                }

            }
        });

        antwort1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i=0;
                if(Frage.getRichtigeAntwort(frage.getText(), i))
                {
                    frage.append("\nRichtige Antwort");
                }
                else
                {
                    frage.append("\nFalsche Antwort");
                }
            }
        });
        antwort2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i=1;
                if(Frage.getRichtigeAntwort(frage.getText(), i))
                {
                    frage.append("\nRichtige Antwort");
                }
                else
                {
                    frage.append("\nFalsche Antwort");
                }
            }
        });
        antwort3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i=2;
                if(Frage.getRichtigeAntwort(frage.getText(), i))
                {
                    frage.append("\nRichtige Antwort");
                }
                else
                {
                    frage.append("\nFalsche Antwort");
                }
            }
        });
        antwort4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i=3;
                if(Frage.getRichtigeAntwort(frage.getText(), i))
                {
                    frage.append("\nRichtige Antwort");
                }
                else
                {
                    frage.append("\nFalsche Antwort");
                }
            }
        });

        panel.add(antwort1);
        panel.add(antwort2);
        panel.add(antwort3);
        panel.add(antwort4);
        panel.add(exit);
        panel.add(next);

        frame.setVisible(true);
    }
}
