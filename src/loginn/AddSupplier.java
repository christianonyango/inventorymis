package loginn;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class AddSupplier extends JFrame {
    private JFrame frame;
private JTextField suppliername,supplierid,phonenumber;
private JLabel lbname,lbid,lbphone;
private JButton submit,cancel;
private JPanel panel1,panel2;
private JLabel lab,lab1,label;
private JComboBox box;
public AddSupplier(){
frame=new JFrame();
frame.setSize(700, 500);

frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
frame.setLocation(300, 80);
frame.setVisible(true);
frame.setLayout(new FlowLayout(FlowLayout.CENTER,2,50));
frame.getContentPane().setBackground(Color.GRAY);
lab1=new JLabel("Nothing done yet");
lab1.setFont(new Font("serif",Font.BOLD,38));
lab1.setForeground(Color.BLUE);
lbname=new JLabel("Supplier Name:");
lbid=new JLabel("Supplier Id:");
lbphone=new JLabel("Phone Number:");
suppliername=new JTextField(15);
suppliername.addKeyListener(new KeyAdapter(){
 public void keyTyped(KeyEvent e){
 char ch=e.getKeyChar();
 if(Character.isDigit(ch)){
 suppliername.setText("");
 JOptionPane.showMessageDialog(null,"NAME MUST BE LETTERS ONLY!!!");
 }
     
 }
    
});
supplierid=new JTextField(15);
String[]criteria={"p001","p002","p003","p004","p005","p006","p007","p008","p009","p010","p011","p012","p013","p014","p015","p016"};
box=new JComboBox(criteria);
 
box.setPreferredSize(new Dimension(170,20));
box.setBackground(Color.WHITE);
phonenumber=new JTextField(15);
phonenumber.addKeyListener(new KeyAdapter(){
 public void keyTyped(KeyEvent e){
 char ch=e.getKeyChar();
 if(Character.isLetter(ch)){
 phonenumber.setText("");
 JOptionPane.showMessageDialog(null,"CONTACT MUST BE NUMBERS ONLY!!!");
 }
 }});
label=new JLabel("Product Id:");
submit=new JButton("Add");
submit.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent evt){
   if(supplierid.getText().equals("")){
    lab1.setText("please enter the correct details");
JOptionPane.showMessageDialog((Component)null,"please enter the correct details","Login error",JOptionPane.ERROR_MESSAGE);
   }
   else{
   verifyregistration();
   }
}});
cancel=new JButton("Reset");
panel1=new JPanel();
panel1.setPreferredSize(new Dimension(500,300));
panel1.setBackground(new Color(159,182,205));
panel1.setBorder( new TitledBorder(
new LineBorder( Color.BLUE,5 ), "ADDITION OF A NEW SUPPLIER" ) );

panel1.setLayout(new GridBagLayout());
panel2=new JPanel();
panel2.setPreferredSize(new Dimension(500,50));
panel2.add(lab1);
GridBagConstraints gb=new GridBagConstraints();
//panel1.add(lab);
gb.insets=new Insets(5,5,5,5);
gb.gridx=0;
gb.gridy=1;
panel1.add(lbid,gb);
gb.gridx=1;
gb.gridy=1;
panel1.add(supplierid,gb);
gb.gridx=0;
gb.gridy=2;
panel1.add(label,gb);
gb.gridx=1;
gb.gridy=2;
panel1.add(box,gb);
gb.gridx=0;
gb.gridy=3;
panel1.add(lbname,gb);
gb.gridx=1;
gb.gridy=3;
panel1.add(suppliername,gb);
gb.gridx=0;
gb.gridy=4;
panel1.add(lbphone,gb);
gb.gridx=1;
gb.gridy=4;
panel1.add(phonenumber,gb);
gb.gridx=0;
gb.gridy=7;
panel1.add(submit,gb);
gb.gridx=1;
gb.gridy=7;
panel1.add(cancel,gb);
       
frame.add(panel1);
frame.add(panel2);
       
}
 public static void main(String[]args){ 
     new AddSupplier();
}
 void verifyregistration(){
        Connection conn=null;
        Statement st=null;
        try{
            String selection=(String)box.getSelectedItem();
            String val1=supplierid.getText();
            val1=val1.trim();
            String val2=suppliername.getText();
            val2=val2.trim();
            String val3=phonenumber.getText();
            val3=val3.trim();
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/inventory1","root","1nv3ntory");
            st=conn.createStatement();
            int i=st.executeUpdate("insert into supplier values('"+val1+"','"+selection+"','"+val2+"','"+val3+"')");
            if(i>0){
                supplierid.setText("");
                suppliername.setText("");
                phonenumber.setText("");
      lab1.setText("product added successfully");
  JOptionPane.showMessageDialog((Component)null,"product added successfully","success",JOptionPane.INFORMATION_MESSAGE );
                
            }else{
               
  JOptionPane.showMessageDialog((Component)null,"product does not exist","please enter the details",JOptionPane.INFORMATION_MESSAGE ); 
            }
            
            
        }catch(SQLException e){
            System.out.println("unable to connect to db"+e);
             JOptionPane.showMessageDialog(null,e.getMessage(),"unable to connect to db",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(ClassNotFoundException cnfe){
            System.out.println("class not found"+cnfe);
             JOptionPane.showMessageDialog(null,cnfe.getMessage(),"class not found",JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception a){
            System.out.println("you have raised the exception"+a);
             JOptionPane.showMessageDialog(null,a.getMessage(),"you have raised the exception",JOptionPane.INFORMATION_MESSAGE);
        
            
        
    }



 }
}

    

