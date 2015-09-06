

package loginn;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Helps extends JFrame{
   
 
    private JLabel lab1;
    private JLabel lab2;
    private JLabel lab3;
    private JLabel lab4;
    private JLabel lab5;
    private JLabel lab6;
    private JLabel lab7;
    private JLabel lab8;
    private JLabel lab9;
    private JLabel lab10;
    private JButton back;
    
    //private JPanel pan;
    Container cn;
    
    public Helps(){
        cn=getContentPane();
        cn.setLayout(null);
       
         lab1=new JLabel("After you are in the login page, enter the correct details and then press on the Login button "
                +"in order to go to the main page. ");
        lab1.setBounds(0, 100, 1000, 60);
        lab1.setBackground(Color.GRAY);
        lab1.setForeground(Color.BLUE);
       lab1.setFont(new Font("serif",Font.BOLD,18));
        lab1.setBorder(null);
        //lab1.setText();
        //cn=new JPanel();
        cn.add(lab1);
        
        lab2=new JLabel("Remember that if you put a wrong username or password or both then you will not be able to move to the next page "
                + "so be carefull. ");
        lab2.setBounds(0, 150, 1050, 60);
        lab2.setBackground(Color.GRAY);
        lab2.setForeground(Color.BLUE);
        lab2.setFont(new Font("serif",Font.BOLD,18));
        lab2.setBorder(null);
        //lab1.setText();
        //cn=new JPanel();
        cn.add(lab2);
        
         lab3=new JLabel( "When you move to the home page, you can navigate through the Menus and Menu items to move to any page you "
                 +"want and carry out the operation you want");
        lab3.setBounds(0, 200, 1300, 60);
        lab3.setBackground(Color.GRAY);
        lab3.setForeground(Color.BLUE);
        lab3.setFont(new Font("serif",Font.BOLD,18));
        lab3.setBorder(null);
        //lab1.setText();
        //cn=new JPanel();
        cn.add(lab3);
        
        
         lab4=new JLabel( "Once you are in the main page,yuo can use the menus to navigate through the system where each menu is having the menu_item of add products and view product");
        lab4.setBounds(30, 250, 1300, 60);
        lab4.setBackground(Color.GRAY);
        lab4.setForeground(Color.BLUE);
        lab4.setFont(new Font("serif",Font.BOLD,18));
        lab4.setBorder(null);
        //lab1.setText();
        //cn=new JPanel();
        cn.add(lab4);
        
        lab5=new JLabel( "The other menus all have the view and add options which you can use to view existing information or add a new information");
        lab5.setBounds(30, 300, 1000, 60);
        lab5.setBackground(Color.GRAY);
        lab5.setForeground(Color.BLUE);
        lab5.setFont(new Font("serif",Font.BOLD,18));
        lab5.setBorder(null);
        //lab1.setText();
        //cn=new JPanel();
        cn.add(lab5);
        
        lab6=new JLabel( "for complicated problems, contact me on::: 0729141103");
        lab6.setBounds(30, 350, 1000, 60);
        lab6.setBackground(Color.GRAY);
        lab6.setForeground(Color.BLUE);
        lab6.setFont(new Font("serif",Font.BOLD,18));
        lab6.setBorder(null);
        //lab1.setText();
        //cn=new JPanel();
        cn.add(lab6);
        
        lab7=new JLabel( "Welcome To the help page");
        lab7.setBounds(300, 10, 1000, 60);
        lab7.setBackground(Color.GRAY);
        lab7.setForeground(Color.BLUE);
        lab7.setFont(new Font("serif",Font.BOLD,34));
        lab7.setBorder(null);
        //lab1.setText();
        //cn=new JPanel();
        cn.add(lab7);
        
        back=new JButton( "BACK");
        back.setBounds(500, 450, 80, 40);
        back.setBackground(Color.RED);
        back.setForeground(Color.BLUE);
        //lab7.setFont(new Font("serif",Font.BOLD,34));
        back.setBorder(null);
        //lab1.setText();
        //cn=new JPanel();
        back.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent evt){
        setVisible(false);
        Main h =new Main();
    }
});
        cn.add(back);
        //add (pan);
        pack();
       setSize(1320,700);
       setLocation(1,1);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       setVisible(true);
    }
    public static void main(String[]args){
        Helps h=new Helps();
    }
    
}

        
    
    


    

