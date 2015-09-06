package loginn;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class StockReport implements ActionListener{
   
    	private JTable table;
	private JScrollPane scrollPane;
	private JPanel main;
	private JFrame jf;
        private static String FILE = "C:\\Users\\GEORGECAROL\\reports\\report.pdf";
        public static final String RESOURCE = "D:\\LUNA ECLIPSE\\images\\company.png";
	private JButton print;
	
        
	public StockReport(){
            try{
        pdfgeneratorss();
        openers();
        }catch (Exception e){
            
        }
        }

        public static void main(String [] args){
            new StockReport();
        }
        
        public  void pdfgeneratorss()throws ClassNotFoundException,SQLException,DocumentException,IOException 	{
	  Font blueFont = FontFactory.getFont(FontFactory.HELVETICA, 18, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
	  Font yellowFont = FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 255, 0));
	  Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.BOLD);
	  Font catFont1 = new Font(Font.FontFamily.TIMES_ROMAN, 13,Font.BOLD);
	  
	   // Rectangle pageSize = new Rectangle(900, 720);
	    //pageSize.setBackgroundColor(new BaseColor(0xFF, 0xFF, 0xDE));
	    
		 
    int rowno=0;		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/inventory1","root","1nv3ntory");
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs=st.executeQuery("select * from stock");
		ResultSetMetaData rsd=rs.getMetaData();
		int colmno=rsd.getColumnCount();
		
		while(rs.next()){
			rowno=rowno+1; 
		}
		rs.first();
		//System.out.print(""+rs.getString(1));
	
	Document document=new Document();
	PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream(FILE));
	writer.setCompressionLevel(9);
	PdfPTable pt=new PdfPTable(colmno);
	
	
float[] columnWidths = new float[] { 70f,70f, 80f, 100f};
pt.setWidths(columnWidths);
pt.setWidthPercentage(100);
pt.setSpacingBefore(10f); //Space before table
pt.setSpacingAfter(10f); //Space after table

PdfPCell StockId=new PdfPCell(new Paragraph("Stock id"));
StockId.setBorderColor(BaseColor.RED);
StockId.setPaddingLeft(0);
StockId.setHorizontalAlignment(Element.ALIGN_CENTER);
StockId.setVerticalAlignment(Element.ALIGN_MIDDLE);
StockId.setBackgroundColor(new BaseColor(159,182,205));

PdfPCell cell1 = new PdfPCell(new Paragraph("Product id"));
cell1.setBorderColor(BaseColor.RED);
cell1.setPaddingLeft(0);
cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
cell1.setBackgroundColor(new BaseColor(159,182,205));   //sets BG color to yellow.



PdfPCell FirstName = new PdfPCell(new Paragraph("Productname"));
FirstName.setBorderColor(BaseColor.RED);
FirstName.setPaddingLeft(0);
FirstName.setHorizontalAlignment(Element.ALIGN_CENTER);
FirstName.setVerticalAlignment(Element.ALIGN_MIDDLE);
FirstName.setBackgroundColor(new BaseColor(159,182,205));   //sets BG color to yellow.


PdfPCell LastName = new PdfPCell(new Paragraph("product type"));
LastName.setBorderColor(BaseColor.RED);
LastName.setPaddingLeft(0);
LastName.setHorizontalAlignment(Element.ALIGN_LEFT);
LastName.setVerticalAlignment(Element.ALIGN_MIDDLE);
LastName.setBackgroundColor(new BaseColor(159,182,205));   //sets BG color to yellow.


PdfPCell datee = new PdfPCell(new Paragraph("product price"));
datee.setBorderColor(BaseColor.RED);
datee.setPaddingLeft(0);
datee.setHorizontalAlignment(Element.ALIGN_LEFT);
datee.setVerticalAlignment(Element.ALIGN_MIDDLE);
datee.setBackgroundColor(new BaseColor(159,182,205));   //sets BG color to yellow.


 
        pt.addCell(StockId);
         pt.addCell(cell1);
	pt.addCell(FirstName);
	pt.addCell(LastName );
	pt.addCell(datee);
	//pt.addCell(Address);
	//pt.addCell(email);
	//pt.addCell(desig);
	//pt.addCell(dep);
	
	
	
	 document.open();
	 
	 
	/*try {
		Image  image1 = Image.getInstance(RESOURCE);
		 image1.scaleAbsolute(50f, 50f);
	     image1.setAbsolutePosition(415f, 770f);
	     document.add(image1);
	     
	    
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   */
	 
	 Paragraph address=new Paragraph("arrow developers",catFont);
	 address.setAlignment(Element.ALIGN_RIGHT);
	 //addEmptyLine(title, 1);
	 Paragraph address1= new Paragraph("P.O Box 190 Kakamega",catFont);
	 address1.setAlignment(Element.ALIGN_RIGHT);
	
	 Paragraph address2= new Paragraph("Tel:0727430028",catFont);
	 address2.setAlignment(Element.ALIGN_RIGHT);
	 
	 Paragraph address3= new Paragraph("Email:arrowdevelopers@gmail.com",catFont);
	 address3.setAlignment(Element.ALIGN_RIGHT);
	   
	 Paragraph address4= new Paragraph("website:www.arrowdevelopers.com",catFont);
	 address4.setAlignment(Element.ALIGN_RIGHT);
		
	 
	 Paragraph subtitle= new Paragraph(" STOCK REPORT",catFont1);
	 subtitle.setAlignment(Element.ALIGN_CENTER);
	 subtitle.setSpacingAfter(50);
	 
	// Paragraph date=new Paragraph(new Paragraph(new Date().toString(),catFont)); 
	 //date.setAlignment(Element.ALIGN_RIGHT);
	 	 
	 
	 Paragraph comments=new Paragraph("Assistant Manager ...........................................................................................................................................................");
	 comments.setAlignment(Element.ALIGN_LEFT);
	 
   
	 Paragraph comment1=new Paragraph("............................................................................................................................................................");
	 comment1.setAlignment(Element.ALIGN_LEFT);


		Paragraph managercomments=new Paragraph("Manager");
		Paragraph managercomments1=new Paragraph("............................................................................................................................................................");
		 managercomments1.setAlignment(Element.ALIGN_LEFT);
		 
		Paragraph managercomments2 = new Paragraph(".............................................................................................................................................................");
		managercomments2.setAlignment(Element.ALIGN_LEFT);
		managercomments2.setSpacingAfter(50);
		 
		Paragraph sig=new Paragraph("Manager's Signature........................................      Office Stamp.............................................");
		sig.setAlignment(Element.ALIGN_LEFT);
		
	 // Paragraph stamp=new Paragraph("Stamp.....................................");
	// Paragraph doc= new Paragraph("---------------------------------------------------------------------------------------------------------------------------------");
	
	for(int i=0;i<rowno;i++){
		pt.addCell(rs.getString(1));
		pt.addCell(rs.getString(2));
		pt.addCell(rs.getString(3));
		pt.addCell(rs.getString(4));
               pt.addCell(rs.getString(5));
		//pt.addCell(rs.getString(5));
		//pt.addCell(rs.getString(6));
		//pt.addCell(rs.getString(7));
	//	pt.addCell(rs.getString(8));
		//pt.addCell(rs.getString(9));
		//pt.addCell(rs.getString(10));
		//pt.addCell(rs.getString(11));
		//pt.addCell(rs.getString(12));
		//pt.addCell(rs.getString(13));
		rs.next();
			
	}
	
	
	
  document.add(address);
  document.add(address1);
  document.add(address2);
  document.add(address3);
  document.add(address4);
  
  //document.add(date);
  document.add(subtitle);
  
  //document.add(doc); 
	
  
	document.add(pt);
	
	document.add(new Paragraph(""));
	document.add(comments);
	document.add(comment1);
	document.add(new Paragraph(""));
	document.add(managercomments);
	document.add(managercomments1);
	document.add(managercomments2);
	document.add(sig);
	//document.add(stamp);
	document.close();
	JOptionPane.showMessageDialog(null, "Report produced");

}

        
public void openers(){
	
	JFileChooser filechooser = new JFileChooser(new File("C:\\Users\\GEORGECAROL\\reports"));
 
int a=filechooser.showOpenDialog(null);
if(a==JFileChooser.APPROVE_OPTION){
	File filetoOpen=filechooser.getSelectedFile();
	try{
		Desktop.getDesktop().open(filetoOpen);
	}catch(Exception e){
		System.out.print(e.getMessage());
	}
}
}

        
        public void actionPerformed(ActionEvent evt) {
	Object source=evt.getSource();
	  
	if(source==print){
	
		
			   try {
				pdfgeneratorss();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	             openers();
	}
}

}

