import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class AddFIB extends JFrame implements ActionListener
{
    JPanel p1, p2, p3;
    JLabel l1, l2;
    JTextField t1, t2;
    JButton b1, b2;
    String subject;
    public AddFIB(String s)
    {
        subject=s;
        setup(s);
        setVisible(true);
        subject=s;
    }
    public void setup(String s)
    {
        setTitle(subject + ": Fill in the Blank");
        setSize(500, 500);
        setLayout(new GridLayout(6, 1));
        setLocationRelativeTo(null);
        
        l1=new JLabel("Enter Question:");
        t1=new JTextField(30);
        
        add(l1);
        add(t1);
        
        l2=new JLabel("Enter Answer:");
        t2=new JTextField(30);
        
        add(l2);
        add(t2);
        
        b1=new JButton("Add");
        b2=new JButton("Back");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        add(b1);
        add(b2);
        
        /*add(p1);
        add(p2);
        add(p3);*/
    }
    public void actionPerformed(ActionEvent e)
    {
        String s=e.getActionCommand();
        
        if(s.equals("Add"))
        {
            try
            {
                String question=t1.getText();
                String answer=t2.getText();
                
                if(question.equals("")||answer.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "One of the fields is empty", "Error", JOptionPane.WARNING_MESSAGE);
                }
                
                else
                {
                    t1.setText("");
                    t2.setText("");
                    String file=subject+".txt";
                    FileWriter fout=new FileWriter(file, true);
                    
                    BufferedReader br=new BufferedReader(new FileReader(subject+"Counter.txt"));
                    
                    int count=Integer.parseInt(br.readLine());
                    
                    count++;
                    
                    FileWriter fout2=new FileWriter((subject+"Counter.txt"));
                    fout2.write(count+"\n");
                    
                    fout.write("Question "+count +": "+question+"\n");
                    fout.write("________\n");
                    fout.write("Answer: "+answer+"\n");
                    
                    fout.close();
                    fout2.close();
                    
                    JOptionPane.showMessageDialog(null, "Question added successfully", "Information", JOptionPane.PLAIN_MESSAGE);
                }
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
        }
        else
        {
            dispose();
            new AddQuestion(subject);
        }
    }
    public void main(String args[])
    {
        new AddFIB(subject);
    }
}