import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Physics extends JFrame implements ActionListener
{
    JButton b1, b2, b3, b4, b5;
    
    public Physics()
    {
        setup();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void setup()
    {
        setTitle("Physics");
        setSize(500, 500);
        setLayout(new GridLayout(5, 1));
        setLocationRelativeTo(null);
        
        b1=new JButton("Add Question");
        b2=new JButton("Modify Question");
        b3=new JButton("Delete Question");
        b4=new JButton("Generate Quiz");
        b5=new JButton("Back");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
    }
    public void actionPerformed(ActionEvent e)
    {
        String s=e.getActionCommand();
        
        if(s=="Add Question")
        {
            dispose();
            new AddQuestion("Physics");
        }
        else if(s=="Modify Question")
        {
            dispose();
            new Modify("Physics");
        }
        else if(s=="Delete Question")
        {
            dispose();
            new DeleteQuestion("Physics");
        }
        else if(s=="Generate Quiz")
        {
            dispose();
            new GenerateQuiz("Physics");
        }
        else
        {
            dispose();
            new MenuPage();
        }
    }
    public static void main(String args[])
    {
        new Physics();
    }
}