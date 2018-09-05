import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class AddTF extends JFrame implements ActionListener
{
    JButton b1, b2;
    JTextField t1, t2;
    JLabel l1, l2;
    String subject;
    JRadioButton r1, r2;
    int Selected=0;
    AddTF(String s)
    {
        subject=s;
        setTitle(subject);
        setSize(500,500);
        setLayout(new GridLayout(8,1));
        setLocationRelativeTo(null);
        setVisible(true);
        
        l1=new JLabel("Enter your question:");
        add(l1);
        
        t1=new JTextField(200);
        add(t1);
        
        l2=new JLabel("Enter the answer:");
        add(l2);
        
        r1=new JRadioButton("True");
        r2=new JRadioButton("False");
        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        add(r1);
        add(r2);
        
        b1=new JButton("Add this question");
        add(b1);
        
        b2=new JButton("Back");
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        r1.addActionListener(this);
        r2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        String s=e.getActionCommand();
        if(s.equals("Add this question"))
        {
            try
            {
                String question =t1.getText();
                
                if(question.equals("")||Selected==0)
                {
                    JOptionPane.showMessageDialog(null, "One of the fields is empty", "Error", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    t1.setText("");
                    Selected=0;
                    
                    String file=subject+".txt";
                    
                    FileWriter fout=new FileWriter(file, true);
                    BufferedReader br=new BufferedReader(new FileReader(subject+"Counter.txt"));
                    
                    int count=Integer.parseInt(br.readLine());
                    count++;
                    
                    FileWriter fout2=new FileWriter((subject+"Counter.txt"));
                    fout2.write(count+"\n");
                    
                    fout.write("Question "+count+":"+question+"\n");
                    fout.write("True/False"+"\n");
                    
                    if(Selected==1)
                    {
                        fout.write("Answer: "+"True"+"\n");
                    }            
                    else if(Selected==-1)
                    {
                        fout.write("Answer: "+"False"+"\n");                   
                    }
                
                    fout.close();
                    fout2.close();
                    JOptionPane.showMessageDialog(null, "Question added successfully", "Information", JOptionPane.PLAIN_MESSAGE);
                }
            }
            catch(Exception k)
            {
                System.out.println(k);
            }
        }
        else if(s.equals("True"))
        {
            Selected=1;
        }
        else if(s.equals("False"))
        {
            Selected=-1;
        }
        else if(s.equals("Back"))
        {
            dispose();
            new AddQuestion(subject);
        }
    }
}