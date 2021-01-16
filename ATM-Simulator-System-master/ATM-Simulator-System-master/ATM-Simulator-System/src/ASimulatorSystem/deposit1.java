
package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class deposit1 extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    
    
    deposit1(){
        
        setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("DEPOSIT");
        int y = fm.stringWidth(" ");
        int z = getWidth() - (5*x);
        int w = z/y;
        String pad ="";
        //for (int i=0; i!=w; i++) pad +=" ";   
        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"DEPOSIT");
        
        
        l1 = new JLabel("ENTER AMOUNT YOU WANT");
        l1.setForeground(Color.YELLOW);
        l1.setFont(new Font("System", Font.BOLD, 35));
        
        l2 = new JLabel("TO DEPOSIT:");
        l2.setForeground(Color.YELLOW);
        l2.setFont(new Font("System", Font.BOLD, 35));
        
        l3 = new JLabel("Enter Pin");
        l3.setForeground(new Color(255, 0, 0));
        l3.setBackground(Color.WHITE);
        l3.setFont(new Font("Dialog", Font.BOLD, 16));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        
        b1 = new JButton("DEPOSIT");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(new Color(255, 255, 255));
    
        b2 = new JButton("BACK");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(new Color(255, 255, 255));
        
        b3 = new JButton("EXIT");
        b3.setFont(new Font("System", Font.BOLD, 18));
        b3.setBackground(Color.BLACK);
        b3.setForeground(new Color(255, 255, 255));
        
        
        getContentPane().setLayout(null);
        
        l3.setBounds(620,10,80,30);
        getContentPane().add(l3);
        
        t2.setBounds(700,10,40,30);
        getContentPane().add(t2);
        
        l1.setBounds(10,153,800,60);
        getContentPane().add(l1);
        
        l2.setBounds(20,218,800,60);
        getContentPane().add(l2);
        
        t1.setBounds(259,223,300,50);
        getContentPane().add(t1);
        
        b1.setBounds(147,380,207,50);
        getContentPane().add(b1);
        
        b2.setBounds(455,380,200,50);
        getContentPane().add(b2);
        
        b3.setBounds(268,491,268,50);
        getContentPane().add(b3);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        getContentPane().setBackground(new Color(0, 206, 209));
        
        setSize(750,590);
        setLocation(385,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
       
        try{        
           
            String a = t1.getText();
            String b = t2.getText();
            
            
            
            
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                
                }else{
                    
                    conn c1 = new conn();
                    
                   
                    
                    String q1= "insert into bank values('"+b+"','"+a+"',null,'"+a+"')";
                    c1.s.executeUpdate(q1);
                    
                   
                    JOptionPane.showMessageDialog(null, "Rs. "+a+" Deposited Successfully");
                    
                    new Transcations().setVisible(true);
                    setVisible(false);
                    
                    
                    
                }
                
            }else if(ae.getSource()==b2){
                
                new Transcations().setVisible(true);
                setVisible(false);
                
            }else if(ae.getSource()==b3){
                
                System.exit(0);
                
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }
    
    public static void main(String[] args){
        new deposit1().setVisible(true);
    }

    
}
