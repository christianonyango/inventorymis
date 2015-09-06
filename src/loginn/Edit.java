

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Edit extends JFrame{

private JFrame frame;
private JTextField stockname,stockid,stocktype,stockprice,productid;
private JLabel lbname,lbid,lbtype,lbprice;
private JButton update,cancel;
private JPanel panel1,panel2;
private JLabel lab,lab1,label,pid;
//private JComboBox box;
private JTextField searchtxt;
    private String selection;



public Edit(){
    
frame=new JFrame();
frame.setSize(700, 500);
frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
frame.setLocation(300, 80);
frame.setVisible(true);
frame.setLayout(new FlowLayout(FlowLayout.CENTER,2,50));
frame.getContentPane().setBackground(Color.GRAY);
pid=new JLabel("Product Id");
lbname=new JLabel("Stock Name:");
lbid=new JLabel("Stock Id:");
lbtype=new JLabel("Stock Type:");
lbprice=new JLabel("Selling Price");
stockname=new JTextField(15);
stockname.addKeyListener(new KeyAdapter(){
 public void keyTyped(KeyEvent e){
     char ch=e.getKeyChar();
     if(Character.isDigit(ch)){
         stockname.setText("");
     JOptionPane.showMessageDialog(null,"NAME MUST BE LETTERS ONLY!!!");
     
     }
 }   
    
});

searchtxt=new JTextField();
        searchtxt.setPreferredSize(new Dimension(150,25));

stockid=new JTextField(15);
productid=new JTextField(15);
stocktype=new JTextField(15);
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
/*String[]criteria={"p001","p002","p003","p004","p005","p006","p007","p008","p009","p010","p011","p012","p013","p014","p015","p016"};
box=new JComboBox(criteria);
box.setPreferredSize(new Dimension(170,20));
box.setBackground(Color.WHITE);*/
label=new JLabel("Product Id:");
update=new JButton("Add");
update.setPreferredSize(new Dimension(80,30));
lab1=new JLabel("Nothing is done yet");
lab1.setFont(new Font("serif",Font.BOLD,38));
lab1.setForeground(Color.BLUE);
update.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent evt){
        if(stockid.getText().equals("")){
            lab1.setText("please enter the correct details");
            JOptionPane.showMessageDialog((Component)null,"please enter the correct details","Login error",JOptionPane.ERROR_MESSAGE);
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
panel1.add(productid,gb);
gb.gridx=0;
gb.gridy=3;
panel1.add(lbname,gb);
gb.gridx=1;
gb.gridy=3;
panel1.add(stockname,gb);
gb.gridx=0;
gb.gridy=4;
panel1.add(lbtype,gb);
gb.gridx=1;
gb.gridy=4;
panel1.add(stocktype,gb);
gb.gridx=0;
gb.gridy=5;
panel1.add(lbprice,gb);
gb.gridx=1;
gb.gridy=5;
panel1.add(stockprice,gb);
gb.gridx=0;
gb.gridy=7;
panel1.add(update,gb);
gb.gridx=1;
gb.gridy=7;
panel1.add(cancel,gb);
       
frame.add(panel1);
frame.add(panel2);

       
}
 public static void main(String[]args){ 
    AddStock addStock = new AddStock();
}
 void verifyregistration(){
        Connection conn =null;
        Statement st=null;
        
             searchtxt.addKeyListener(new KeyAdapter() {
                 @Override
		 public void keyReleased(KeyEvent ke) {
			
			 try{
				 String id=searchtxt.getText();
				 
				 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/inventory1","root","1nv3ntory");

				 String query="select stock_id,product_id,product_name ,product_type,selling_price from product where "+searchtxt+"=?";
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
	 );
            
            //String selection=(String)box.getSelectedItem();
            String val1=stockid.getText();
            val1=val1.trim();
            String val2=productid.getText();
            val2=val2.trim();
            String val3=stockname.getText();
            val3=val3.trim();
            String val4=stocktype.getText();
            val4=val4.trim();
            String val5=stockprice.getText();
            val5=val5.trim();
           
            try {
            Class.forName("com.mysql.jdbc.Driver");
            throw new ClassNotFoundException("Class Not Found");
            }catch (ClassNotFoundException e) {
           //     try {
          //  conn=DriverManager.getConnection("jdbc:mysql://localhost/inventory1","root","");
          //  st=conn.createStatement();
            
           // int i=st.executeUpdate("insert into stock values('"+val1+"','"+ selection +"','"+val2+"','"+val3+"','"+val4+"')");
           // throw new SQLException("SQL");
               // }catch (Exception e){
           int i =0;     
            if(i>0){
                stockid.setText("");
                stockname.setText("");
                stocktype.setText("");
                stockprice.setText("");
                
  JOptionPane.showMessageDialog((Component)null,"product added successfully","success",JOptionPane.INFORMATION_MESSAGE );
                
            }else{
               
  JOptionPane.showMessageDialog((Component)null,"product does not exist","please enter the details",JOptionPane.INFORMATION_MESSAGE ); 
            }
            
          
        }
        //try {
            //throw new SQLException("SQL");
            
            ActionListener listener=(ActionEvent e) -> {
                // TODO Auto-generated method stub
                 
                String s=e.getActionCommand();
                if(s.equalsIgnoreCase("update")){
                    
                    String i = stockid.getText();
                    String id = pid.getText();
                    String n = stockname.getText();
                    String d = stocktype.getText();
                    String p = stockprice.getText();
                    
                    // if (isNumber(p)) {
                    String sql = "update items set itemname='"+n+"', description = '" + d
                            + "', sellingprice = '" + p + "' where itemid = '"
                            + i + "'";
                    /*if(0 != Database.InsertQuery(sql)){
                    Date date = new Date();
                    String dat = date.toString();
                    String Sql = "insert into users_activity values('"
                    + login.Loggedin.userid
                    + "','Edited Items', now() )";*/
                    //Database.insertData(Sql);
                    //Myfunctions.setStatus("Records Update successfully", "mess");
                    //reset.doClick();
                   
                }else{
                    JOptionPane.showMessageDialog(null,"Error in updating");
                    //Myfunctions.setStatus("Update error", "error");
                    
                }
                //}else {
                JOptionPane.showMessageDialog(null,"Price and quantity must be numbers");
            };
        
       // } catch(SQLException e){
            System.out.println("unable to connect to db"+e);
             JOptionPane.showMessageDialog(null,e.getMessage(),"unable to connect to db",JOptionPane.INFORMATION_MESSAGE);
        }
       // catch(ClassNotFoundException cnfe){
            System.out.println("class not found"+cnfe);
             JOptionPane.showMessageDialog(null,cnfe.getMessage(),"class not found",JOptionPane.INFORMATION_MESSAGE);
            
       // }catch(Exception a){
            System.out.println("you have raised the exception"+a);
             JOptionPane.showMessageDialog(null,a.getMessage(),"you have raised the exception",JOptionPane.INFORMATION_MESSAGE);
        
            
        
    }



 }
 
}

    

    

