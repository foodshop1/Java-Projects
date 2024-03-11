import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class WordCheck extends JFrame implements ActionListener
{
    JButton showButton;
    JTextArea textArea;
    JButton button, button2;
    JLabel label, label2, label3;
    JTextField textfield;

    public static void main (String[] args)
    {
        new WordCheck ();
    }


    public WordCheck ()
    {
        JFrame frame = new JFrame ("Flow Layout Example");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setSize (500, 500);

        JPanel panel = new JPanel ();
        panel.setLayout (new FlowLayout ());

        textArea = new JTextArea (10, 40); // 10 rows, 40 columns
        JScrollPane scrollPane = new JScrollPane (textArea);
        panel.add (scrollPane);

        button = new JButton ("COUNT");
        button.addActionListener (this);
        panel.add (button);

        label = new JLabel ("word count");
        panel.add (label);

        label2 = new JLabel ("                                                                                         ");
        panel.add (label2);

        label3 = new JLabel (" Enter word length to count ");
        panel.add (label3);


        textfield = new JTextField ("", 10);
        panel.add (textfield);



        frame.getContentPane ().add (panel); // Using getContentPane().add() instead of add()

        frame.setVisible (true);
    }


    public void actionPerformed (ActionEvent evt)
    {
        String word = textfield.getText ();
        int wordcount = Integer.parseInt (word);
        String input;
        int checker = 0;
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        if (evt.getActionCommand ().equals ("COUNT"))
        {

            input = textArea.getText ();
            String currentWord = "";
            for (int i = 0 ; i < input.length () ; i++)
            {
                char c = input.charAt (i);
                if (c != ' ')
                {
                    currentWord += c;
                }
                else
                {
                    if (currentWord.length () >= wordcount)
                    {
                        checker++;
                    }
                    currentWord = "";
                }
            }

            if (currentWord.length () >= wordcount)
            {
                checker++;
            }

            label.setText (checker + "words");
            checker = 0;

        }




    }
}
