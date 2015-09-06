package loginn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/*import javax.swing.*;
 import javax.swing.table.DefaultTableModel;
 import java.awt.*;
 import java.sql.*;
 import java.awt.event.*;*/

public class ViewProduct implements ActionListener {

    private JFrame frame, frame1;
    private JTextField textbox;
    private JLabel label;
    private JButton button;
    private JPanel panel;
    static JTable table;
    private JButton exit, delete, viewall;

    String categoryName = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/inventory1";
    String userName = "root";
    String password = "1nv3ntory";
    String[] columnNames = {"product_id", "product_name", "product_type", "buying_price"};

    public void createUI() {
        frame = new JFrame("PRODUCTS INFORMATION");
        frame.setForeground(Color.RED);
        frame.setFont(new Font("serif", Font.BOLD, 24));
        frame.setBackground(Color.BLUE);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setBackground(Color.GRAY);

        textbox = new JTextField();
        textbox.setBounds(150, 30, 150, 30);
        label = new JLabel("ProductId:");
        label.setFont(new Font("serif",Font.BOLD,20));
        label.setBounds(50, 30, 200, 20);

        exit = new JButton("EXIT");
        exit.setBounds(400, 130, 100, 30);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main m = new Main();
            }
        });
        frame.add(exit);

        viewall = new JButton("VIEW ALL");
        viewall.setBounds(550, 130, 120, 30);
        viewall.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String[] columns = {"product_id", "product_name", "product_type", "buying_price"};
                DefaultTableModel model = new DefaultTableModel();
                model.setColumnIdentifiers(columns);
//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
//table = new JTable(model);
                table = new JTable();
                table.setModel(model);
                table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                table.setFillsViewportHeight(true);
                JScrollPane scroll = new JScrollPane(table);
                scroll.setHorizontalScrollBarPolicy(
                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scroll.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//String textvalue = textbox.getText();

                try {
                    /*String val1 = "";
                    String val2 = "";
                    String val3 = "";
                    String val4 = "";*/
                    Class.forName(categoryName);
                    Connection con = DriverManager.getConnection(url, userName, password);
                    String sql = "select * from product";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    int i = 0;
                    while (rs.next()) {

                        /*val1 = rs.getString("product_id");
                        val2 = rs.getString("product_name");
                        val3 = rs.getString("product_type");
                        val4 = rs.getString("buying_price");*/

                        model.addRow(new Object[]{"product_id", "produt_name","product_type", "buying_price"});
                        i++;
                    }
                    /*if (i < 1) {
                        JOptionPane.showMessageDialog(null, "No Record Found", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }*/
                    if (i == 1) {
                        System.out.println(i + " Record Found");
                        showTableData();
                    } else {
                        System.out.println(i + " Records Found");
                        showTableData();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.add(viewall);

        button = new JButton("VIEW DETAILS");
        button.setBounds(50, 130, 120, 30);
        button.addActionListener(this);

        delete = new JButton("DELETE");
        delete.setBounds(250, 130, 100, 30);
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Object source = evt.getSource();

                if (source == delete) {
                    try {
                        int DResult = JOptionPane.showConfirmDialog((Component) null, "Are you sure you want to delete Record?");
                        if (DResult == JOptionPane.NO_OPTION) {
                            textbox.setText("");
                        }
                        if (DResult == JOptionPane.YES_OPTION) {
                            deleterecord();
                            textbox.setText("");

                        }else{
                        JOptionPane.showMessageDialog((Component)null,"The record does not exist");
                        }

                    } catch (Exception e) {

                    }
                }

            }
        });
        frame.add(delete);

        frame.add(textbox);
        frame.add(label);
        frame.add(button);
        frame.setVisible(true);
        frame.setSize(700, 500);
        frame.setLocation(300, 80);
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setFont(new Font("serif", Font.BOLD, 24));
    }

    public void actionPerformed(ActionEvent ae) {
        button = (JButton) ae.getSource();
        System.out.println("Showing The Required Details.......");
        showTableData();
    }
    
    

    public void showTableData() {

        frame1 = new JFrame("PRODUCTS' INFORMATION");
        frame1.setForeground(Color.RED);
        frame1.setBackground(Color.BLUE);

        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.setLayout(new BorderLayout());
        frame1.getContentPane().setBackground(Color.GRAY);

//TableModel tm = new TableModel();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
//table = new JTable(model);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        String textvalue = textbox.getText();
        String val1 = "";
        String val2 = "";
        String val3 = "";
        String val4 = "";

        try {
            Class.forName(categoryName);
            Connection con = DriverManager.getConnection(url, userName, password);
            String sql = "select * from product where product_id= '" + textvalue + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {

                val1 = rs.getString("product_id");
                val2 = rs.getString("product_name");
                val3 = rs.getString("product_type");
                val4 = rs.getString("buying_price");

                model.addRow(new Object[]{val1, val2, val3, val4});
                i++;
            }
            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            if (i == 1) {
                System.out.println(i + " Record Found");
            } else {
                System.out.println(i + " Records Found");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(750, 500);
        frame1.setLocation(300, 80);
    }

    public static void main(String args[]) {
        ViewProduct n = new ViewProduct();
        n.createUI();
    }

    public void deleterecord() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory1", "root", "1nv3ntory");
            Statement stmt = con.createStatement();
            //String num  = (String) jList1.getSelectedValue();
            
             
            String sql2 = "Delete from product where Product_id = '" + textbox.getText() + "'";
            stmt.executeUpdate(sql2);
       JOptionPane.showMessageDialog(null, "Row deleted from the database!");
        
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
