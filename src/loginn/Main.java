package loginn;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Main extends JFrame implements ActionListener{
private JFrame fr;
  private JMenu product,supplier,stock,report,help;
  private JMenuItem addproduct,viewproduct,updateproduct,searchproduct,deleteproduct;
  private JMenuItem addsupplier,viewsupplier,updatesupplier,searchsupplier,deletesupplier;
  private JMenuItem addstock,viewstock,deletestock;
  private JMenuItem viewreport;
  private JMenuItem viewhelp;
  private JMenuItem text;
  public JPanel panel;
  private JButton logout;
  public Main(){
      fr=new JFrame();
  fr.setSize(1366,750);
  fr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
  fr.setLocation(1, 1);
  fr.setVisible(true);
  fr.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
  fr.getContentPane().setBackground(new Color(159,182,205));
  panel=new JPanel();
  panel.setPreferredSize(new Dimension(1355,680));
  panel.setBackground(new Color(159,182,205));
  panel.setBorder( new TitledBorder(
new LineBorder( Color.BLUE,5 ), "ELECTRONICS INVENTORY MANAGEMENT SYSTEM" ) );
  logout=new JButton("LOGOUT");
  logout.setFont(new Font("serif",Font.BOLD,14));
  logout.setForeground(Color.BLUE);
  logout.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
          Loginn l=new Loginn();
          fr.dispose();
      }
  });
  product=new JMenu("Product");
  product.setPreferredSize(new Dimension(100,50));
  product.setFont(new Font("serif",Font.BOLD,18));
 JMenuBar bar=new JMenuBar();
 setJMenuBar(bar);
  bar.add(product);
  addproduct=new JMenuItem("addProduct");
  
  addproduct.addActionListener(this);
   
  product.add(addproduct);
  viewproduct=new JMenuItem("viewProduct");
  viewproduct.addActionListener(this);
  product.add(viewproduct);
  updateproduct=new JMenuItem("updateProduct");
  product.add(updateproduct);
  searchproduct=new JMenuItem("searchProduct");
  searchproduct.addActionListener(this);
  product.add(searchproduct);
  deleteproduct=new JMenuItem("deleteProduct");
  product.add(deleteproduct);
  supplier=new JMenu("Supplier");
   supplier.setPreferredSize(new Dimension(100,50));
   supplier.setFont(new Font("serif",Font.BOLD,18));
  bar.add(supplier);
  addsupplier=new JMenuItem("addSupplier");
  addsupplier.addActionListener(this);
  supplier.add(addsupplier);
  viewsupplier=new JMenuItem("viewSupplier");
  viewsupplier.addActionListener(this);
  supplier.add(viewsupplier);
  updatesupplier=new JMenuItem("updateSupplier");
  supplier.add(updateproduct);
  searchsupplier=new JMenuItem("searchSupplier");
  searchsupplier.addActionListener(this);
  supplier.add(searchsupplier);
  deletesupplier=new JMenuItem("deleteSupplier");
  supplier.add(deletesupplier);
  text=new JMenuItem("SendText");
  text.setMnemonic('S');
       text.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               SendSms sm=new SendSms();
               
       }});
       
      supplier.add(text);
  
  stock=new JMenu("Stock");
   stock.setPreferredSize(new Dimension(100,50));
   stock.setFont(new Font("serif",Font.BOLD,18));
  bar.add(stock);
   addstock=new JMenuItem("addStock");
   addstock.addActionListener(this);
  stock.add(addstock);
  viewstock=new JMenuItem("viewStock");
  viewstock.addActionListener(this);
  stock.add(viewstock);
  deletestock=new JMenuItem("deleteStock");
  stock.add(deletestock);
  report=new JMenu("Report");
   report.setPreferredSize(new Dimension(100,50));
   report.setFont(new Font("serif",Font.BOLD,18));
  bar.add(report);
 viewreport=new JMenuItem("viewReport");
 viewreport.addActionListener(this);
  report.add(viewreport);
  help=new JMenu("Help");
   help.setPreferredSize(new Dimension(100,50));
   help.setFont(new Font("serif",Font.BOLD,18));
  bar.add(help);
  viewhelp=new JMenuItem("viewHelp");
  viewhelp.addActionListener(this);
  help.add(viewhelp);
  panel.add(bar);
  panel.add(logout);
  fr.add(panel);
  
  
  
      
  }
  public static void main(String[]args){
      new Main();
  }
  @Override
  public void actionPerformed(ActionEvent evt){
      Object s=evt.getSource();
      if(s==addproduct){
         new AddProducts();
         
         }
   Object t=evt.getSource();
  if(t==addsupplier){
     new AddSupplier();
          }
  Object q=evt.getSource();
  if(q==addstock){
      new AddStock();
  }
   Object r=evt.getSource();
  if(r==viewhelp){
      new Helps();
  }
  Object p=evt.getSource();
  if(p==viewproduct){
      ViewProduct v=new ViewProduct();
      v.createUI();
      fr.dispose();
      
      
  }
  Object w=evt.getSource();
  if(w==searchproduct){
  new SearchProducts();
  fr.dispose();
  }
 Object l=evt.getSource();
 if(l==searchsupplier){
     new SearchSupplier();
     fr.dispose();
 }
 Object k=evt.getSource();
  if(k==viewstock){
      ViewStock vi=new ViewStock();
      vi.createUI();
      fr.dispose();
  
 }
  Object b=evt.getSource();
  if(b==viewsupplier){
      ViewSupplier c=new ViewSupplier();
      c.createUI();
      fr.dispose();
  }
  Object a=evt.getSource();
  if(a==viewsupplier){
      ViewSupplier c=new ViewSupplier();
      c.createUI();
      fr.dispose();
  }
  Object z=evt.getSource();
 if(z==viewreport){
     new Report1();
     fr.dispose(); 
 }
}}