import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Login extends JFrame
{
    JTextField username;
    JPasswordField password;
    JButton login;
    JLabel userName, passWord;
    JPanel p1, p2, p3, p4 ,p5;
    JTabbedPane t1=new JTabbedPane();
    Container c1;
    
    public Login()
    {
        setup();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void setup()
    {
        //Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setTitle("Login Page");
        setSize(500, 500);
        setLayout(new GridLayout(5, 1));
        setLocationRelativeTo(null);
        
        p1=new JPanel();
        p1.setBackground(Color.DARK_GRAY);
        p2=new JPanel();
        p2.setBackground(Color.DARK_GRAY);
        p3=new JPanel();
        p3.setBackground(Color.DARK_GRAY);
        p4=new JPanel();
        p4.setBackground(Color.DARK_GRAY);
        p5=new JPanel();
        p5.setBackground(Color.DARK_GRAY);
        //c1=getContentPane();
        
        userName=new JLabel("Username:");
        userName.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        userName.setForeground(Color.lightGray);
        username = new JTextField(10);
        username.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        
        passWord=new JLabel("Password:");
        passWord.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        passWord.setForeground(Color.lightGray);
        password = new JPasswordField(10);
        password.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        
        
        login=new JButton("Login");
        login.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        
        //c1.add(p1);
        
        p2.add(userName);
        p2.add(username);
        p3.add(passWord);
        p3.add(password);
        p4.add(login);
        
        String user="Ashish";
        String pass="ashish";
        
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        
        setVisible(true);
        
        password.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                char[] temp_pwd = password.getPassword();
                String pwd=String.copyValueOf(temp_pwd);
                if(user.equals(username.getText()) && pass.equals(pwd))
                {
                    dispose();
                    new MenuPage();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Wrong Password", "Error", JOptionPane.WARNING_MESSAGE);
                }
                username.setText("");
                password.setText("");
            }
        });
        
        login.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                char[] temp_pwd = password.getPassword();
                String pwd=String.copyValueOf(temp_pwd);
                if(user.equals(username.getText()) && pass.equals(pwd))
                {
                    dispose();
                    new MenuPage();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Wrong Password", "Error", JOptionPane.WARNING_MESSAGE);
                }
                username.setText("");
                password.setText("");
            }
        });
    
    }
    
    public static void main(String args[])
    {
        new Login();
    }
}