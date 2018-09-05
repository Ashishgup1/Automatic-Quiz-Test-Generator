import java.io.*;
import java.awt.*;    
import java.awt.event.*; 
import javax.swing.*; 
import java.util.*;
public class GenerateQuiz extends JFrame implements ActionListener
{
    String subject;
    JLabel l1;
    JButton b1, b2, b3;
    JTextField text1;
    JTextArea text2;
    JPanel p1;
    JScrollPane scroll;
    FileWriter fw1, fw2;
    BufferedWriter bw1, bw2;
    ArrayList<String> AL;
    public GenerateQuiz(String s)
    {
        p1=new JPanel();
        subject = s;
        setTitle("Generate "+subject+" Quiz");
        setLayout(null);
        setSize(600,600);  
        setLocationRelativeTo(null);
        setVisible(true);   
        
        l1 = new JLabel("Number of questions: ");
        l1.setBounds(100, 50, 200, 30);
        add(l1);
        
        text1 = new JTextField(12);
        text1.setBounds(250, 50, 100, 30);
        add(text1);
        
        text2= new JTextArea();
        text2.setBounds(50,100, 450,350);
        
        scroll = new JScrollPane(text2);
        //scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        scroll.setBounds(50,100, 450,350);
        add(scroll);
        
        b1 = new JButton("Generate Quiz");  
        b2 = new JButton("Back");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        add(b1);
        add(b2);
        
        b1.setBounds(200,450, 200,30); 
        b2.setBounds(200,500,200,30);
    }
    public void actionPerformed(ActionEvent e)
    {
        AL=new ArrayList<>();
        try
        {
            if(e.getSource()==b1)
            {
                String numberofques=text1.getText();
                FileReader fr=new FileReader(subject + ".txt");
                BufferedReader br= new BufferedReader(fr);
                String s=br.readLine();
                int counter=0;
                while(s!=null)
                {
                    String sa=s;
                    String sb=br.readLine();
                    String sc=br.readLine();
                    AL.add(sa+"~\n"+sb+"~\n"+sc+"~");
                    counter++;
                    s=br.readLine();
                }
                fr.close();
                br.close();
                Collections.shuffle(AL);
                if(counter<Integer.parseInt(numberofques)||Integer.parseInt(numberofques)<=0)
                    throw new Exception();
                else
                {
                    if(subject.equals("Physics"))
                    {
                        fw1 = new FileWriter("PhysicsQuizQuestions.txt");
                        fw2 = new FileWriter("PhysicsQuizAnswers.txt");
                    }
                    else if(subject.equals("Chemistry"))
                    {
                        fw1 = new FileWriter("ChemistryQuizQuestions.txt");
                        fw2 = new FileWriter("ChemistryQuizAnswers.txt");
                    }
                    else 
                    {
                        fw1 = new FileWriter("MathematicsQuizQuestions.txt");
                        fw2 = new FileWriter("MathematicsQuizAnswers.txt");
                    }
                    bw1=new BufferedWriter(fw1);   
                    bw2=new BufferedWriter(fw2);
                    StringBuffer display=new StringBuffer();
                    for(int i=0;i<Integer.parseInt(numberofques);i++)
                    {
                       String ss= AL.get(i);
                       int j =0;
                       String ques="";
                       String s1="";
                       String s2="";
                       while(ss.charAt(j)!='~')
                       {
                           s1+=ss.charAt(j);
                           j++;
                       }
                       ques+=s1+"\n";
                       bw1.write(s1);
                       bw1.newLine();
                       j++;
                       s1="";
                       while(ss.charAt(j)!='~')
                       {
                           s1+=ss.charAt(j);
                           j++;
                       }
                       ques+=s1;
                       j++;
                       bw1.write(s1);
                       bw1.newLine();
                       while(ss.charAt(j)!='~')
                       {
                           s2+=ss.charAt(j);
                           j++;
                       }
                       bw2.write(s2);
                       bw2.newLine();
                       display=display.append(ques);
                       display=display.append("\n");
                       display=display.append("\n");
                    }
                    text2.setText(display.toString());
                    bw1.close();
                    bw2.close();
                    fw1.close();
                    fw2.close();
                    JOptionPane.showMessageDialog(this,"Generation successful");
                    text1.setText("");
                }
            }
        }
        catch(Exception e1)
        {
            JOptionPane.showMessageDialog(this, "Unable to generate quiz");  
        }
        if(e.getSource()==b2)
        {
            dispose();
            try
            {
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
            catch(Exception e1)
            {
                System.out.println(e1);
            }
        }
    }
}