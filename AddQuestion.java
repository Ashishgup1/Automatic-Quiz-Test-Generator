import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class AddQuestion extends JFrame implements ActionListener
{
    JButton b1, b2, b3, b4, b5;
    String subject;
    public AddQuestion(String s)
    {
        subject=s;
        setup(s);
        setVisible(true);
    }
    public void setup(String s)
    {
        setTitle(subject);
        setSize(500, 500);
        setLayout(new GridLayout(4, 1));
        setLocationRelativeTo(null);
        
        b1=new JButton("Fill in the Blanks");
        b2=new JButton("Multiple Choice Question");
        b3=new JButton("True/False");
        b4=new JButton("Back");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        
        add(b1);
        add(b2);
        add(b3);
        add(b4);   
    }
    public void actionPerformed(ActionEvent e)
    {
        String s=e.getActionCommand();
        
        if(s=="Fill in the Blanks")
        {
            dispose();
            new AddFIB(subject);
        }
        else if(s=="Multiple Choice Question")
        {
            dispose();
            new AddMCQ(subject);
        }
        else if(s=="True/False")
        {
            dispose();
            new AddTF(subject);
        }
        else
        {
            dispose();
            if(subject.equals("Physics"))
            {
                new Physics();
            }
            else if(subject.equals("Chemistry"))
            {
                new Chemistry();
            }
            else
            {
                new Mathematics();
            }
        }
    }
    public void main(String args[])
    {
        new AddQuestion(subject);
    }
}