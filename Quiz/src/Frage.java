import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Frage {

    String frage;
    int richtigeAntwort;
    String[] antworten = new String[4];
    public static List <Frage> Fragen =new ArrayList<>();
    public Frage(String frage, String[] antworten,int richtigeAntwort)
    {
        this.frage=frage;
        this.richtigeAntwort=richtigeAntwort;
        this.antworten=antworten;
    }

    public static boolean getRichtigeAntwort(String frage, int i)
    {
        boolean antwort = false;

        for (int n=0; n<Fragen.size();n++)
        {
            if(Fragen.get(n).frage.equals(frage))
            {
                if(Fragen.get(n).richtigeAntwort==i)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        return false;
    }

    public static void frageHinzufuegen ()
    {
        JFrame frame = new JFrame();
        frame.setLocationRelativeTo(null);
        BorderLayout borderLayout = new BorderLayout();
        frame.setLayout(borderLayout);
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel headliner = new JLabel("Frage Antwort Input");
        frame.add(headliner, BorderLayout.NORTH);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));
        JTextArea frage = new JTextArea("Bitte hier die Frage eingeben");
        frage.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(frage.getText().equals("Bitte hier die Frage eingeben"))
                {
                    frage.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (frage.getText().isEmpty())
                {
                    frage.setText("Bitte hier die Frage eingeben");
                }
            }

        });
        JLabel labelfrage = new JLabel("Frage:");
        JTextArea antwort1 = new JTextArea("Bitte hier die erste Antwort eingeben");
        antwort1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (antwort1.getText().equals("Bitte hier die erste Antwort eingeben"))
                {
                    antwort1.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (antwort1.getText().isEmpty())
                {
                    antwort1.setText("Bitte hier die erste Antwort eingeben");
                }
            }
        });
        JLabel labelantwort1 = new JLabel("Antwort 1: ");
        JTextArea antwort2 = new JTextArea("Bitte hier die zweite Antwort eingeben");
        antwort2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (antwort2.getText().equals("Bitte hier die zweite Antwort eingeben"))
                {
                    antwort2.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (antwort2.getText().isEmpty())
                {
                    antwort2.setText("Bitte hier die zweite Antwort eingeben");
                }
            }
        });
        JLabel labelantwort2 = new JLabel("Antwort 2: ");
        JTextArea antwort3 = new JTextArea("Bitte hier die dritte Antwort eingeben");
        antwort3.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (antwort3.getText().equals("Bitte hier die dritte Antwort eingeben"))
                {
                    antwort3.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (antwort3.getText().isEmpty())
                {
                    antwort3.setText("Bitte hier die dritte Antwort eingeben");
                }
            }
        });
        JLabel labelantwort3 = new JLabel("Antwort 3: ");
        JTextArea antwort4 = new JTextArea("Bitte hier die vierte Antwort eingeben");
        antwort4.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (antwort4.getText().equals("Bitte hier die vierte Antwort eingeben"))
                {
                    antwort4.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (antwort4.getText().isEmpty())
                {
                    antwort4.setText("Bitte hier die vierte Antwort eingeben");
                }
            }
        });
        JLabel labelantwort4 = new JLabel("Antwort 4: ");
        JTextArea richtig = new JTextArea();
        JLabel richtigLabel = new JLabel("Richtige Antwort (0-3)");
        panel.add(labelfrage,0);
        panel.add(frage,1);
        panel.add(labelantwort1,2);
        panel.add(antwort1,3);
        panel.add(labelantwort2,4);
        panel.add(antwort2,5);
        panel.add(labelantwort3,6);
        panel.add(antwort3,7);
        panel.add(labelantwort4,8);
        panel.add(antwort4,9);
        panel.add(richtigLabel,10);
        panel.add(richtig, 11);
        frame.add(panel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        frame.add(buttonPanel, BorderLayout.PAGE_END);
        JButton safe = new JButton("Speichern");
        buttonPanel.add(safe);
        safe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    String question = frage.getText();
                    String[] answers = new String[4];
                    answers[0] = antwort1.getText();
                    answers[1] = antwort2.getText();
                    answers[2] = antwort3.getText();
                    answers[3] = antwort4.getText();
                    int richtigeantwort = Integer.parseInt(richtig.getText());
                    Fragen.add(new Frage(question, answers, richtigeantwort));
                    frage.setText("");
                    antwort1.setText("");
                    antwort2.setText("");
                    antwort3.setText("");
                    antwort4.setText("");
                    richtig.setText("");

            }
        });
        JButton beginnGame = new JButton("Spiel beginnen");
        buttonPanel.add(beginnGame);
        beginnGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Quizfenster quizfenster = new Quizfenster();
            }
        });
        JButton exit = new JButton("Schließen");
        buttonPanel.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }


    public static void neueFrage(JTextArea text, JButton button, JButton button1, JButton button2, JButton button3, Frage frageAntwort)
    {
        text.setText(frageAntwort.frage);
        button.setText(frageAntwort.antworten[0]);
        button1.setText(frageAntwort.antworten[1]);
        button2.setText(frageAntwort.antworten[2]);
        button3.setText(frageAntwort.antworten[3]);
    }
    public static void spielStarten ()
    {
        frageHinzufuegen();
    }
}
