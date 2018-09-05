import java.io.*;
import java.awt.*;    
import java.awt.event.*; 
import javax.swing.*; 
import java.util.*;
public class ModifyQuestion extends JFrame implements ActionListener
{
    String subject;
    JLabel l1;
    JButton b1, b2;
    JTextArea text1, text2, text3;
    FileWriter fw;
    BufferedWriter bw;
    FileReader fr;
    BufferedReader br;
    ArrayList<String>alques, altype, alans;
    int quesnumber;
    int flag=0;
    String type="";
    public ModifyQuestion(String s, String que, String typ, String answr, int number)
    {
        type=typ;
        subject = s;
        quesnumber=number;

        setTitle("Modify");
        setSize(700,700);    
        setLayout(null);  
        setVisible(true);   
        setLocationRelativeTo(null);

        l1 = new JLabel("Correct the question");
        l1.setBounds(50,50,150,30);
        add(l1);

        text1 = new JTextArea(que);
        text1.setBounds(50,100,500,100); 
        add(text1);

        text2 = new JTextArea(typ);
        text2.setBounds(2000,20000,500,100); 
        add(text2);

        text3 = new JTextArea(answr);
        text3.setBounds(50,400,500,100); 
        add(text3);

        if(typ.charAt(0)=='A'&&typ.charAt(1)==')')
        {
            flag=1;
            text2.setBounds(50,250,500,100); 
        }

        b1 = new JButton("Click to save changes");
        b1.setBounds(100,500, 200,30); 
        b1.addActionListener(this);
        add(b1); 

        b2 = new JButton("Back");
        b2.setBounds(100,550,200,30);
        b2.addActionListener(this);
        add(b2); 
    }

    public void actionPerformed(ActionEvent e)
    {
        alques=new ArrayList<>();
        altype=new ArrayList<>();
        alans=new ArrayList<>();
        if(e.getSource()==b1)
        {
            try
            {
                String correctedquestion=text1.getText();
                String correctedtype="";
                if(flag==1)
                    correctedtype=text2.getText();
                else
                    correctedtype=type;

                String correctedanswer=text3.getText();
                fr= new FileReader(subject + ".txt");
                br= new BufferedReader(fr);
                int flag =0;
                String s=br.readLine();

                while(s!=null)
                {
                    String sa=s;
                    String sb=br.readLine();
                    String sc=br.readLine();
                    alques.add(sa);
                    altype.add(sb);
                    alans.add(sc);
                    s=br.readLine();
                }
                br.close();
                fr.close();

                fw= new FileWriter(subject+".txt", false);
                bw=new BufferedWriter(fw);

                alques.remove(quesnumber-1);
                altype.remove(quesnumber-1);
                alans.remove(quesnumber-1);

                alques.add(quesnumber-1,correctedquestion);
                altype.add(quesnumber-1,correctedtype);
                alans.add(quesnumber-1,correctedanswer);

                for (int i = 0; i < alques.size(); i++) 
                {
                    bw.write(alques.get(i));
                    bw.newLine();
                    bw.write(altype.get(i));
                    bw.newLine();
                    bw.write(alans.get(i));
                    bw.newLine();
                }

                bw.close();
                fw.close();
                JOptionPane.showMessageDialog(this,"Modification successful");
            }

            catch(Exception e1)
            {
                System.out.println(e1);
            }
            text1.setText("");
            text2.setText("");
            text3.setText("");
        }

        if(e.getSource()==b2)
        {
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