package loginn;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class AddStock extends JFrame{
    private JFrame frame;
private JTextField stockname,stockid,stocktype,stockprice;
private JLabel lbname,lbid,lbtype,lbprice;
private JButton submit,cancel;
private JPanel panel1,panel2;
private JLabel lab,lab1,label;
private JComboBox box,box1,box2;
private JTextField searchtxt;



public AddStock(){
    
frame=new JFrame();
frame.setSize(700, 500);
frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
frame.setLocation(300, 80);
frame.setVisible(true);
frame.setLayout(new FlowLayout(FlowLayout.CENTER,2,50));
frame.getContentPane().setBackground(Color.GRAY);
stockname=new JTextField(15);
box1=new JComboBox();
try{
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/inventory1","root","1nv3ntory");
    Statement st=con.createStatement();
    String querry="select product_name from stock";
    ResultSet rs=st.executeQuery(querry);
    while(rs.next()){
        
        box1.addItem(rs.getString("product_name"));
         System.out.printf(rs.getString("product_name"));
   
    }
    
}catch(Exception e){
    System.out.print(e.getMessage());
}
box1.setPreferredSize(new Dimension(170,20));
box1.setBackground(Color.WHITE);
lbname=new JLabel("Stock Name:");
lbid=new JLabel("Stock Id:");
stocktype=new JTextField(15);
box2=new JComboBox();
try{
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/inventory1","root","1nv3ntory");
    Statement st=con.createStatement();
    String querry="select product_type from stock";
    ResultSet rs=st.executeQuery(querry);
    while(rs.next()){
        
        box2.addItem(rs.getString("product_type"));
         System.out.printf(rs.getString("product_type"));
   
    }
    
}catch(Exception e){
    System.out.print(e.getMessage());
}
box2.setPreferredSize(new Dimension(170,20));
box2.setBackground(Color.WHITE);
lbtype=new JLabel("Stock Type:");
lbprice=new JLabel("Selling Price");

stockname.addKeyListener(new KeyAdapter(){
 public void keyTyped(KeyEvent e){
     char ch=e.getKeyChar();
     if(Character.isDigit(ch)){
         stockname.setText("");
     JOptionPane.showMessageDialog(null,"NAME MUST BE LETTERS ONLY!!!");
     
     }
 }   
    
});

//searchtxt=new JTextField();
        //searchtxt.setPreferredSize(new Dimension(150,25));

stockid=new JTextField(15);

stocktype.addKeyListener(new KeyAdapter(){
 public void keyTyped(KeyEvent e){
     char ch=e.getKeyChar();
     if(Character.isDigit(ch)){
         stocktype.setText("");
     JOptionPane.showMessageDialog(null,"YTPE MUST BE LETTERS ONLY!!!");
     }
 }   
    
});
stockprice=new JTextField(15);
//String[]criteria={"p001","p002","p003","p004","p005","p006","p007","p008","p009","p010","p011","p012","p013","p014","p015","p016"};
box=new JComboBox();
try{
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/inventory1","root","1nv3ntory");
    Statement st=con.createStatement();
    String querry="select product_id from stock";
    ResultSet rs=st.executeQuery(querry);
    while(rs.next()){
        
        box.addItem(rs.getString("product_id"));
         System.out.printf(rs.getString("product_id"));
   
    }
    
}catch(Exception e){
    System.out.print(e.getMessage());
}
box.setPreferredSize(new Dimension(170,20));
box.setBackground(Color.WHITE);
label=new JLabel("Product Id:");
submit=new JButton("Update");     
submit.setPreferredSize(new Dimension(80,30));
lab1=new JLabel();
lab1.setFont(new Font("serif",Font.BOLD,38));
lab1.setForeground(Color.BLUE);
lab1.setBackground(Color.BLUE);
submit.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent evt){
        if(stockid.getText().equals("")){
            lab1.setText("please enter the correct details");
           // JOptionPane.showMessageDialog((Component)null,"please enter the correct details","Login error",JOptionPane.ERROR_MESSAGE);
        }
        else{
       verifyregistration();
        }
}});
cancel=new JButton("Reset");
cancel.setPreferredSize(new Dimension(80,30));
cancel.addActionListener(new ActionListener(){
   @Override
   public void actionPerformed(ActionEvent evt){
       stockid.setText("");
       stockname.setText("");
       stocktype.setText("");
       stockprice.setText("");
   }
});
//lab=new JLabel("ADD PRODUCT DETEILS");
//lab.setHorizontalAlignment(SwingConstants.CENTER);


panel1=new JPanel();
panel1.setPreferredSize(new Dimension(500,300));
panel1.setBackground(new Color(159,182,205));
panel1.setBorder( new TitledBorder(
new LineBorder( Color.BLUE,5 ), "ADDITION OF A NEW STOCK" ) );
panel1.setLayout(new GridBagLayout());
panel2=new JPanel();
panel2.setPreferredSize(new Dimension(500,50));
panel2.add(lab1);
panel2.setBackground(Color.GRAY);
GridBagConstraints gb=new GridBagConstraints();
//panel1.add(lab);
gb.insets=new Insets(5,5,5,5);
gb.gridx=0;
gb.gridy=1;
panel1.add(lbid,gb);
gb.gridx=1;
gb.gridy=1;
panel1.add(stockid,gb);
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
panel1.add(box1,gb);
gb.gridx=0;
gb.gridy=4;
panel1.add(lbtype,gb);
gb.gridx=1;
gb.gridy=4;
panel1.add(box2,gb);
gb.gridx=0;
gb.gridy=5;
panel1.add(lbprice,gb);
gb.gridx=1;
gb.gridy=5;
panel1.add(stockprice,gb);
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
     new AddStock();
}
 void verifyregistration(){
        Connection conn=null;
        Statement st=null;
        try{
            /* searchtxt.addKeyListener(new KeyAdapter() {
		 public void keyReleased(KeyEvent ke) {
			
			 try{
				 String id=searchtxt.getText();
				 
				 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/inventory1","root","");

				 String query="select product_id,product_name ,product_type,buying_price from product where "+searchtxt+"=?";
				 System.out.print(query);
				 PreparedStatement pst=connection.prepareStatement(query);
				 pst.setString(1, searchtxt.getText());
				 ResultSet rs=pst.executeQuery();
				 
		//table.setModel(DbUtils.resultSetToTableModel(rs));
				 
				 
			 }catch(Exception e){
				 System.out.print(e.getMessage());
			 }
			 
			 
			 
			}

	
		    }
	 );*/
            
            String selection=(String)box.getSelectedItem();
            String val1=stockid.getText();
            val1=val1.trim();
             String selection1=(String)box1.getSelectedItem();
            //val2=val2.trim();
             String selection2=(String)box2.getSelectedItem();
            //val3=val3.trim();
             String val4=stockprice.getText();
            val4=val4.trim();
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/inventory1","root","1nv3ntory");
            st=conn.createStatement();
            int i=st.executeUpdate("update stock set stock_id='"+val1+"',product_id='"+selection+"',product_name='"+selection1+"',product_type='"+selection2+"',selling_price='"+val4+"' where product_id = '"+ selection + "'");
            if(i>0){
                stockid.setText("");
                stockname.setText("");
                stocktype.setText("");
                stockprice.setText("");
               lab1.setText("product is added successfully");
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

    
