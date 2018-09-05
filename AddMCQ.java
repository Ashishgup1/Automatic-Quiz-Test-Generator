import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class AddMCQ extends JFrame implements ActionListener
{
    JPanel p1, p2, p3, p4, p5, p6;
    JLabel l1, l2, l3, l4, l5, l6;
    JTextField t1, t2, t3, t4, t5, t6;
    JButton b1, b2;
    String subject;
    public AddMCQ(String s)
    {
        subject=s;
        setup(s);
        setVisible(true);
        subject=s;
    }
    public void setup(String s)
    {
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p4=new JPanel();
        p5=new JPanel();
        p6=new JPanel();
        
        setTitle(subject + ": Multiple Choice Question");
        setSize(500, 500);
        setLayout(new GridLayout(6, 1));
        setLocationRelativeTo(null);
        
        l1=new JLabel("Enter Question:");
        t1=new JTextField(30);
        
        p1.add(l1);
        p1.add(t1);
        
        l2=new JLabel("A)");
        t2=new JTextField(10);
        
        l3=new JLabel("B)");
        t3=new JTextField(10);
        
        p2.add(l2);
        p2.add(t2);
        p2.add(l3);
        p2.add(t3);
        
        l4=new JLabel("C)");
        t4=new JTextField(10);
        
        l5=new JLabel("D)");
        t5=new JTextField(10);
        
        p3.add(l4);
        p3.add(t4);
        p3.add(l5);
        p3.add(t5);
        
        l6=new JLabel("Enter correct option:");
        t6=new JTextField(10);
        
        p4.add(l6);
        p4.add(t6);
        
        b1=new JButton("Add");
        b2=new JButton("Back");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        p5.add(b1);
        p6.add(b2);
        
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        add(p6);
    }
    public void actionPerformed(ActionEvent e)
    {
        String s=e.getActionCommand();
        
        if(s.equals("Add"))
        {
            try
            {
                String question=t1.getText();
                String optionA=t2.getText();
                String optionB=t3.getText();
                String optionC=t4.getText();
                String optionD=t5.getText();
                String answer=t6.getText();
                
                if(question.equals("")||answer.equals("")||optionA.equals("")||optionB.equals("")||optionC.equals("")||optionD.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "One of the fields is empty", "Error", JOptionPane.WARNING_MESSAGE);
                }
                else if(!(answer.equals(optionA)||answer.equals(optionB)||answer.equals(optionC)||answer.equals(optionD)))
                {
                    JOptionPane.showMessageDialog(null, "Answer does not match any of the options", "Error", JOptionPane.WARNING_MESSAGE);
                }
                else if(optionA.equals(optionB)||optionA.equals(optionC)||optionA.equals(optionD)||optionB.equals(optionC)||optionB.equals(optionD)||optionC.equals(optionD))
                {
                    JOptionPane.showMessageDialog(null, "Two of the options are same", "Error", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                    
                    String file=subject+".txt";
                    FileWriter fout=new FileWriter(file, true);
                    
                    BufferedReader br=new BufferedReader(new FileReader(subject+"Counter.txt"));
                    
                    int count=Integer.parseInt(br.readLine());
                    
                    count++;
                    
                    FileWriter fout2=new FileWriter((subject+"Counter.txt"));
                    fout2.write(count+"\n");
                    
                    fout.write("Question "+count +": "+question+"\n");
                    fout.write("A)" + optionA+" ");
                    fout.write("B)" + optionB+" ");
                    fout.write("C)" + optionC+" ");
                    fout.write("D)" + optionD+" \n");
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
        new AddMCQ(subject);
    }
}