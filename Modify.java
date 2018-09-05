import java.io.*;
import java.awt.*;    
import java.awt.event.*; 
import javax.swing.*; 
import java.util.*;
public class Modify extends JFrame implements ActionListener
{
    String subject;
    JLabel l1;
    JButton b1, b2;
    JTextField text1;
    FileWriter fw1, fw2;
    BufferedWriter bw1, bw2;
    FileReader fr, frcnt;
    BufferedReader br, brcnt;
    ArrayList<String>al;
    public Modify(String s)
    {
        subject = s;
        
        setTitle("Choosing the question to modify");
        setSize(400,400);    
        setLayout(null);  
        setLocationRelativeTo(null);
        setVisible(true);  
        
        l1 = new JLabel("Enter question number");
        l1.setBounds(50,50,150,30);
        add(l1);
        
        text1 = new JTextField();
        text1.setBounds(200,50, 100,30); 
        add(text1);
        
        b1 = new JButton("Click to view and modify"); 
        b1.setBounds(100,250, 200,30);  
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Go back");
        b2.setBounds(100,300,200,30);
        b2.addActionListener(this);
        add(b2); 
    }
    public void actionPerformed(ActionEvent e)
    {
        al=new ArrayList<>();
        if(e.getSource()==b1)
         {
             try
             {
                String ques=text1.getText();
                
                frcnt= new FileReader(subject+"Counter.txt");
                int quesnumber=0;
                brcnt = new BufferedReader(frcnt);
                String qu=brcnt.readLine();
                quesnumber=Integer.parseInt(qu);
                if(Integer.parseInt(ques)>quesnumber||Integer.parseInt(ques)<1)
                {
                    throw new Exception();
                }
                else
                {
                    String numbertomodify=text1.getText();
                    fr= new FileReader(subject+".txt");
                    br= new BufferedReader(fr);
                    int quescounter=1;
                    int flag =0;
                    String s=br.readLine();
                    String ans1="";
                    String ans2="";
                    String ans3="";
                    while(s!=null)
                    {
                        int digitsofques=0;
                        int i=9;
                        String curr="";
                        while((int)s.charAt(i)>=48&&(int)s.charAt(i)<=57)
                        {
                            digitsofques++;
                            curr+=s.charAt(i);
                            i++;
                        }
                        String add=Integer.toString(quescounter);
                        String sa=s.substring(0,9)+add+s.substring(digitsofques+9);
                        String sb=br.readLine();
                        String sc=br.readLine();
                        if(Integer.parseInt(curr)==Integer.parseInt(numbertomodify)&&flag==0)
                        {
                            flag=1;
                            ans1=sa;
                            ans2=sb;
                            ans3=sc;
                            break;
                        }
                        quescounter++;
                        s=br.readLine();
                    }
                    if(flag==0)
                        throw new Exception();
                    fr.close();
                    br.close();
                    text1.setText("");
                    ModifyQuestion m1 = new  ModifyQuestion(subject,ans1,ans2,ans3,Integer.parseInt(ques));
                }
            }
            catch(Exception e1)
            {
                JOptionPane.showMessageDialog(this,"Question not available");
                text1.setText("");   
            }
        }   
        if(e.getSource()==b2)
        {
            dispose();
            try
            {
                if(subject.equals("Physics"))
                {
                    dispose();
                    new Physics();
                }
                else if(subject.equals("Chemistry"))
                {
                    dispose();
                    new Chemistry();
                }
                else
                {
                    dispose();
                    new Mathematics();
                }
            }
            catch(Exception e1)
            {
                
                
            }
        }
    }
}