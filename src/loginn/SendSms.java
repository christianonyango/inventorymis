package loginn;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//import login.ozekiserver.sms.Sms;
 public class SendSms implements ActionListener{
    private JFrame jf;
private JPanel panel1,panel2;
private JTextArea area;
private JTextField tfrom;
private JButton submit;	
private JLabel lbl1,lbl2;

public SendSms(){
	jf =new JFrame();
	jf.setLayout(new FlowLayout(FlowLayout.CENTER));
	panel1=new JPanel();
	panel1.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
	panel1.setPreferredSize(new  Dimension(300,300));
	
	lbl2=new JLabel("To");
        
	lbl1=new JLabel("Message:");
        
	tfrom=new JTextField(20);
        tfrom.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isLetter(ch)){
            tfrom.setText("");
                    JOptionPane.showMessageDialog(null, "CONTACT MUST BE NUMBERS ONLY!!!");
                }
            }            
        });
	area=new JTextArea(10,20);
	area.setEditable(true);
	panel1.add(lbl2);
	panel1.add(tfrom);
	panel1.add(lbl1);
	panel1.add(area);
	submit=new JButton("Send");
	submit.addActionListener(this);
	panel1.add(submit);
	jf.setVisible(true);
	jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	jf.setSize(700,500);
	jf.add(panel1);
	jf.getContentPane().setBackground(Color.CYAN);


	
}
public static void main(String[]args){
    SendSms sm=new SendSms();
   
    
}
/*public void help(){
	new Help();
}*/

  public void actionPerformed(ActionEvent e) {
	Object source=e.getSource();
		if(source==submit){
			int x=0;
	try{
			  Class.forName("com.mysql.jdbc.Driver");
	          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory1","root","1nv3ntory");
	          Statement statement=con.createStatement();
	          statement.executeUpdate("insert into ozekimessageout(receiver,msg,status) values('"+tfrom.getText()+"','"+area.getText()+"','send')");
	          System.out.println("insert into ozekimessageout(receiver,msg,status) values('"+tfrom.getText()+"','"+area.getText()+"')");
	          
              
	          x++;
	          
              if (x > 0) 
              {
                  JOptionPane.showMessageDialog(submit, "Text Sent Successfully");
              } 
              
		}catch(Exception ex){
			System.out.println(ex);
		}
	
	}
		else {
			JOptionPane.showMessageDialog(null, "error");
		}
		
                
	}


}

       

