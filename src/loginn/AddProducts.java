package loginn;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
public class AddProducts extends JFrame{
private JFrame frame;
private JTextField productname,productid,producttype,productprice;
private JLabel lbname,lbid,lbtype,lbprice;
private JButton submit,cancel;
private JPanel panel1,panel2,panel3;
private JLabel lab,lab1;

public AddProducts(){
frame=new JFrame();
frame.setSize(700, 500);
frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
frame.setLocation(300, 80);
frame.setVisible(true);
frame.setLayout(new FlowLayout(FlowLayout.CENTER,2,50));
frame.getContentPane().setBackground(Color.GRAY);
lbname=new JLabel("Product Name:");
lbid=new JLabel("Product Id:");
lbtype=new JLabel("Product Type:");
lbprice=new JLabel("Buying Price");
productname=new JTextField(15);
productname.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isDigit(ch)){
        productname.setText("");
         JOptionPane.showMessageDialog(null, " NAME MUST BE LETTERS ONLY!!!");
                }
            }            
        });
productid=new JTextField(15);
producttype=new JTextField(15);
producttype.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isDigit(ch)){
        producttype.setText("");
         JOptionPane.showMessageDialog(null, " TYPE MUST BE LETTERS ONLY!!!");
                }
            }            
        });
productprice=new JTextField(15);
lab1=new JLabel();
lab1.setFont(new Font("serif",Font.BOLD,38));
lab1.setForeground(Color.BLUE);
submit=new JButton("Add");
submit.setPreferredSize(new Dimension(80,30));
submit.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent evt){
    if(productid.getText().equals("")){
    lab1.setText("please enter the correct details");
    //JOptionPane.showMessageDialo  g((Component)null,"please enter the correct details","Add error",JOptionPane.ERROR_MESSAGE);
    }
    else{
    verifyregistration();
    }}
});
cancel=new JButton("Reset");
cancel.setPreferredSize(new Dimension(80,30));
cancel.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent evt){
        productid.setText("");
        productname.setText("");
        producttype.setText("");
        productprice.setText("");
        
        
    }}
);
//lab=new JLabel("ADD PRODUCT DETEILS");
//lab.setHorizontalAlignment(SwingConstants.CENTER);


panel1=new JPanel();
panel1.setPreferredSize(new Dimension(500,300));
panel1.setBackground(new Color(159,182,205));
panel1.setBorder( new TitledBorder(
new LineBorder( Color.BLUE,5 ), "PRODUCT INFORMATION" ) );
panel1.setLayout(new GridBagLayout());
GridBagConstraints gb=new GridBagConstraints();
panel2=new JPanel();
panel2.setPreferredSize(new Dimension(500,50));
panel2.setBackground(Color.GRAY);
panel2.setForeground(Color.BLUE);
panel2.add(lab1);
panel3=new JPanel();
panel3.setPreferredSize(new Dimension(680,450));
panel3.setBackground(Color.GRAY);
//panel3.setBorder(new TitledBorder(new LineBorder(Color.BLUE,5),"INVENTORY MANAGEMENT SYSTEM"));
//panel1.add(lab);
gb.insets=new Insets(5,5,5,5);
gb.gridx=0;
gb.gridy=1;
panel1.add(lbid,gb);
gb.gridx=1;
gb.gridy=1;
panel1.add(productid,gb);
gb.gridx=0;
gb.gridy=2;
panel1.add(lbname,gb);
gb.gridx=1;
gb.gridy=2;
panel1.add(productname,gb);
gb.gridx=0;
gb.gridy=3;
panel1.add(lbtype,gb);
gb.gridx=1;
gb.gridy=3;
panel1.add(producttype,gb);
gb.gridx=0;
gb.gridy=4;
panel1.add(lbprice,gb);
gb.gridx=1;
gb.gridy=4;
panel1.add(productprice,gb);
gb.gridx=0;
gb.gridy=7;
panel1.add(submit,gb);
gb.gridx=1;
gb.gridy=7;
panel1.add(cancel,gb);
 panel3.add(panel1);
panel3.add(panel2);
frame.add(panel3);
       
}
 public static void main(String[]args){ 
     new AddProducts();
}
 void verifyregistration(){
        Connection conn=null;
        Statement st=null;
        try{
            String val1=productid.getText();
            val1=val1.trim();
            String val2=productname.getText();
            val2=val2.trim();
            String val3=producttype.getText();
            val3=val3.trim();
            String val4=productprice.getText();
            val4=val4.trim();
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/inventory1","root","1nv3ntory");
            st=conn.createStatement();
            int i=st.executeUpdate("insert into product values('"+val1+"','"+val2+"','"+val3+"','"+val4+"')");
            if(i>0){
                productid.setText("");
                productname.setText("");
                producttype.setText("");
                productprice.setText("");
      lab1.setText("product added successfully");
  //JOptionPane.showMessageDialog((Component)null,"product added successfully","success",JOptionPane.INFORMATION_MESSAGE );
                
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

    


