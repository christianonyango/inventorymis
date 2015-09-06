package loginn;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;



public class SearchProducts implements KeyListener{
  private JFrame jf;
private JPanel jp,menus,mainpanel,viewemployees,textsearch,searchjp,viewleaveapplication;
private JMenuBar mb;
private JMenu m1,m2,m3,m4;
private JMenuItem search,view,leaveapp,leavesett,all,slip,allemp,leaverep;
private JLabel title,label;
private JPanel pn1,pn2,pn3;
private JButton exit;
private JTable table;
private  JScrollPane scrollPane;
private JLabel title1;
private JTextField searchtxt;
private JComboBox select;
public SearchProducts(){
	
	
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
			
	}catch(ClassNotFoundException cnfe){
		System.out.println(cnfe.getMessage());
	}
	
	 ArrayList columnNames = new ArrayList();
     ArrayList data = new ArrayList();

     //  Connect to an MySQL Database, run query, get result set
     String url = "jdbc:mysql://localhost:3306/inventory1";
     String userid = "root";
     String password = "1nv3ntory";
     String sql = "select product_id,product_name ,product_type,buying_price from product";

     // Java SE 7 has try-with-resources
     // This will ensure that the sql objects are closed when the program 
     // is finished with them
     try{ Connection connection = DriverManager.getConnection( url, userid, password );
         Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery( sql );
     {
         ResultSetMetaData md = rs.getMetaData();
         int columns = md.getColumnCount();

         //  Get column names
         for (int i = 1; i <= columns; i++)
         {
             columnNames.add( md.getColumnName(i) );
         }

         //  Get row data
     /*    while (rs.next())
         {
             ArrayList row = new ArrayList(columns);

             for (int i = 1; i <= columns; i++)
             {
                 row.add( rs.getObject(i) );
             }

             data.add( row );
         }*/
     }
     }
     catch (SQLException e)
     {
         System.out.println( e.getMessage() );
     }

     // Create Vectors and copy over elements from ArrayLists to them
     // Vector is deprecated but I am using them in this example to keep 
     // things simple - the best practice would be to create a custom defined
     // class which inherits from the AbstractTableModel class
     Vector columnNamesVector = new Vector();
     Vector dataVector = new Vector();

     for (int i = 0; i < data.size(); i++)
     {
         ArrayList subArray = (ArrayList)data.get(i);
         Vector subVector = new Vector();
         for (int j = 0; j < subArray.size(); j++)
         {
             subVector.add(subArray.get(j));
         }
         dataVector.add(subVector);
     }

     for (int i = 0; i < columnNames.size(); i++ )
         columnNamesVector.add(columnNames.get(i));

     //  Create table with database data    
     table = new JTable(dataVector, columnNamesVector);
     table.setPreferredScrollableViewportSize(new Dimension(1100,200));
     table.setEnabled(false);
     //table.setBackground(new Color(159,182,205));
 	
    /* {
         public Class getColumnClass(int column)
         {
             for (int row = 0; row < getRowCount(); row++)
             {
                 Object o = getValueAt(row, column);

                 if (o != null)
                 {
                     return o.getClass();
                 }
             }

             return Object.class;
         }
     };
*/     
     scrollPane = new JScrollPane( table );
String [] criteria={"product_id","product_name","product_type","buying_price"};
	select =new JComboBox(criteria);
	
	
	
	//panels
        label=new JLabel("Search");
	searchtxt=new JTextField();
        searchtxt.setPreferredSize(new Dimension(150,25));
        exit=new JButton("Exit");
        exit.setPreferredSize(new Dimension(80,30));
        exit.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent evt){
             new Main();
       
         }
        });
   
	
	 searchtxt.addKeyListener(new KeyAdapter() {
		 public void keyReleased(KeyEvent ke) {
			
			 try{
				 String selection=(String)select.getSelectedItem();
				 
				 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/inventory1","root","1nv3ntory");

				 String query="select product_id,product_name ,product_type,buying_price from product where "+selection+"=?";
				 System.out.print(query);
				 PreparedStatement pst=connection.prepareStatement(query);
				 pst.setString(1, searchtxt.getText());
				 ResultSet rs=pst.executeQuery();
				 
		table.setModel(DbUtils.resultSetToTableModel(rs));
				 
				 
			 }catch(Exception e){
				 System.out.print(e.getMessage());
			 }
			 
			 
			 
			}

	
		    }
	 );
	
	
	
	jf=new JFrame();
	jf.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
	jf.setSize(1200,500);
	jf.setVisible(true);;
	jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	jf.getContentPane().setBackground(Color.GRAY);
        jf.add(label);
        jf.add(searchtxt);
        jf.add(select);
        jf.add(exit);
	jf.add(scrollPane);
        
	//jf.add(mainpanel);
}
public static void main(String []args){
	new SearchProducts();
}

@Override
public void keyPressed(KeyEvent arg0) {
	
	
}
@Override
public void keyReleased(KeyEvent arg0) {
	
	
}
@Override
public void keyTyped(KeyEvent arg0) {
	
	
}

}
  

