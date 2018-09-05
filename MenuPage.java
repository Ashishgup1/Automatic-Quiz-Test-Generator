import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MenuPage extends JFrame implements ActionListener
{
    JButton b1, b2, b3, b4;
    
    public MenuPage()
    {
        setup();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void setup()
    {
        setTitle("Select Subject");
        setSize(500, 500);
        setLayout(new GridLayout(4, 1));
        setLocationRelativeTo(null);
        
        b1=new JButton("Physics");
        b2=new JButton("Chemistry");
        b3=new JButton("Mathematics");
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
        if(s.equals("Physics"))
        {
            dispose();
            new Physics();
        }
        else if(s.equals("Chemistry"))
        {
            dispose();
            new Chemistry();
        }
        else if(s.equals("Mathematics"))
        {
            dispose();
            new Mathematics();
        }
        else
        {
            dispose();
            new Login();
        }
    }
    public static void main(String args[])
    {
        new MenuPage();
    }
}