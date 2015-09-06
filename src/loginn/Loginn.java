
package loginn;
// import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
// import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;

public class Loginn extends JFrame{
    private final JLabel lbuser,lbpass,title;
    private JTextField username;
    private JPasswordField pass;
    private final JPanel panel,pan;
    private JFrame jfr;
    private final JButton login,exit;
    Connection conn=null;
    public Loginn(){
        jfr=new JFrame();
        jfr.setSize(700,500);
        jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfr.setVisible(true);
        jfr.setLocation(300, 80);
        jfr.setLayout(new FlowLayout(FlowLayout.CENTER, 20,20));
        jfr.getContentPane().setBackground(Color.GRAY);
        lbuser=new JLabel("UserName");
        lbpass=new JLabel("Password");
        title=new JLabel("Welcome to Electronic Inventory Management System (EIMS)");
        title.setFont(new Font("serif",Font.BOLD,20));
        username=new JTextField(15);
        pass=new JPasswordField(15);
        login=new JButton("Login");
         login.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            try{
					 Class.forName("com.mysql.jdbc.Driver");
				        conn=DriverManager.getConnection("jdbc:mysql://localhost/inventory1","root","1nv3ntory");
					String query="select * from login2 where UserName=? and Password=?";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1,username.getText());
					pst.setString(2,pass.getText());

				ResultSet rs=pst.executeQuery();
				if(rs.next())
				{ 
					JOptionPane.showMessageDialog(null, "Login is sucessful");
					Main page=new Main();
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "UserName or Password is not correct Try Again");
				}
				
				rs.close();
				pst.close();
				}
				catch(Exception en)
				{
					JOptionPane.showMessageDialog(null,en);
				}
				finally{
					try{
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, ex);
					}
				}
			}
		}
    );
   
    
        //new Main();
        exit=new JButton("cancel");
        exit.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            jfr.dispose();
          }
    });
        panel=new JPanel();
        pan=new JPanel();
        pan.add(title);
        jfr.add(pan);
        pan.setPreferredSize(new Dimension(700,100));
        panel.add(lbuser);
        panel.add(username);
        panel.add(lbpass);
        panel.add(pass);
        panel.add(login);
        panel.add(exit);
        jfr.add(panel);
        
        panel.setPreferredSize(new Dimension(300,150));
        panel.setBackground(Color.GRAY);
       
    
        
    }

    public static void main(String[]args){
       Loginn lg =new Loginn();
    }
    
}
