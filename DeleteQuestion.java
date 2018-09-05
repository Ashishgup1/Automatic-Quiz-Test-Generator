import java.io.*;
import java.awt.*;    
import java.awt.event.*; 
import javax.swing.*; 
import java.util.*;
public class DeleteQuestion extends JFrame implements ActionListener
{
    String subject;
    JLabel l1;
    JButton b1, b2, b3;
    JTextField text1;
    FileWriter fw;
    FileReader frcnt, fr;
    BufferedWriter bw;
    BufferedReader brcnt, br;
    Scanner sc;
    FileWriter fwcnt;
    BufferedWriter bwcnt;
    ArrayList<String>quesal, typeal, ansal;
    public DeleteQuestion(String s)
    {
        subject = s;
        setTitle("Choose the question to delete");

        l1 = new JLabel("Enter question number");
        l1.setBounds(50,50,150,30);
        add(l1);

        text1 = new JTextField();
        text1.setBounds(200,50, 100,30);
        add(text1);

        b1 = new JButton("Click to delete"); 
        b1.setBounds(100,170, 200,30); 
        b1.addActionListener(this); 
        add(b1); 

        b2 = new JButton("Click to view");
        b2.setBounds(100,220,200,30);
        b2.addActionListener(this);
        add(b2); 

        b3 = new JButton("Go back");
        b3.setBounds(100,300,200,30);
        b3.addActionListener(this);
        add(b3);

        setSize(400,400);    
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);   
    }

    public void actionPerformed(ActionEvent e)
    {
        quesal=new ArrayList<>();
        typeal=new ArrayList<>();
        ansal=new ArrayList<>();
        if(e.getSource()==b1)
        {
            try
            {
                String numbertodelete=text1.getText();

                frcnt=new FileReader(subject+"Counter.txt");

                int quesnumber=0;
                brcnt = new BufferedReader(frcnt);
                String qu=brcnt.readLine();

                quesnumber=Integer.parseInt(qu);
                quesnumber--;

                brcnt.close();
                frcnt.close();

                fr=new FileReader(subject+".txt");
                br= new BufferedReader(fr);

                int quescounter=1;
                int flag =0;
                String s=br.readLine();

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
                    String sa=s.substring(0, 9)+add+s.substring(digitsofques+9);
                    String sb=br.readLine();
                    String sc=br.readLine();
                    if(Integer.parseInt(curr)==Integer.parseInt(numbertodelete)&&flag==0)
                    {
                        flag=1;
                        s=br.readLine();
                        continue;
                    }
                    quesal.add(sa);
                    typeal.add(sb);
                    ansal.add(sc);

                    quescounter++;
                    s=br.readLine();
                }
                if(flag==0)
                {
                    throw new Exception();
                }

                fr.close();
                br.close();

                fw=new FileWriter(subject+".txt", false);
                bw=new BufferedWriter(fw);

                for (int i = 0; i < quesal.size(); i++) 
                {
                    bw.write(quesal.get(i));
                    bw.newLine();
                    bw.write(typeal.get(i));
                    bw.newLine();
                    bw.write(ansal.get(i));
                    bw.newLine();
                }

                fwcnt=new FileWriter(subject+"Counter.txt", false);
                bwcnt = new BufferedWriter(fwcnt);
                bwcnt.write(Integer.toString(quesnumber));

                JOptionPane.showMessageDialog(this,"Deletion successful");

                bwcnt.close();
                fwcnt.close();
                bw.close();
                fw.close();
            }
            catch(Exception e1)
            {
                System.out.println("Unable to delete question");
            }
            text1.setText("");
        }

        if(e.getSource()==b2)
        {
            try
            {
                String numbertodelete=text1.getText();

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
                    int i =9;
                    String curr="";
                    while((int)s.charAt(i)>=48&&(int)s.charAt(i)<=57)
                    {
                        digitsofques++;
                        curr+=s.charAt(i);
                        i++;
                    }
                    String add=Integer.toString(quescounter);
                    String sa=s.substring(0, 9)+add+s.substring(digitsofques+9);
                    String sb=br.readLine();
                    String sc=br.readLine();
                    if(Integer.parseInt(curr)==Integer.parseInt(numbertodelete)&&flag==0)
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
                else
                    JOptionPane.showMessageDialog(this, ans1+"\n"+ans2+"\n"+ans3);
                fr.close();
                br.close();   
            }
            catch(Exception e1)
            {
                JOptionPane.showMessageDialog(this, "Unable to find question");
            }
            text1.setText("");
        }
        if(e.getSource()==b3)
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
                System.out.println(e1);
            }
        }
    }
}