
package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    
    Deposit(){
        
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
        l1.setForeground(new Color(255, 255, 0));
        l1.setFont(new Font("System", Font.BOLD, 35));
        
        l2 = new JLabel("TO DEPOSIT:");
        l2.setForeground(new Color(255, 255, 0));
        l2.setFont(new Font("System", Font.BOLD, 35));
        
        l3 = new JLabel("Enter Pin");
        l3.setForeground(new Color(255, 0, 0));
        l3.setFont(new Font("System", Font.BOLD, 14));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        
        b1 = new JButton("DEPOSIT");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(new Color(0, 0, 0));
        b1.setForeground(new Color(255, 255, 255));
    
        b2 = new JButton("BACK");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(new Color(255, 255, 255));
        
        b3 = new JButton("EXIT");
        b3.setFont(new Font("System", Font.BOLD, 18));
        b3.setBackground(Color.BLACK);
        b3.setForeground(new Color(0, 0, 0));
        
        
        getContentPane().setLayout(null);
        
        l3.setBounds(620,10,80,30);
        getContentPane().add(l3);
        
        t2.setBounds(700,10,40,30);
        getContentPane().add(t2);
        
        l1.setBounds(10,119,800,60);
        getContentPane().add(l1);
        
        l2.setBounds(20,189,800,60);
        getContentPane().add(l2);
        
        t1.setBounds(280,201,310,41);
        getContentPane().add(t1);
        
        b1.setBounds(141,380,174,50);
        getContentPane().add(b1);
        
        b2.setBounds(484,380,174,50);
        getContentPane().add(b2);
        
        b3.setBounds(234,487,332,50);
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
                if(t1.getText().equals("") || t2.getText().equals("")){
                    
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Deposit and Pin");
                
                }else{
                    
                    conn c1 = new conn();
                    
                    
                    
                    ResultSet rs = c1.s.executeQuery(" select * from bank where pin = '"+b+"' ");
                    
                    double balance = 0;
                    if(rs.next()){
                        String pin = rs.getString("pin");
 						while(rs.next()) {                       
                        balance = rs.getDouble("balance");
                        }
                        
                        double d = Double.parseDouble(a);
                        balance+=d;
                        String q1= "insert into bank values('"+pin+"','"+d+"',null,'"+balance+"')";
                    
                        c1.s.executeUpdate(q1);
                    }
                    
                    
                    
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
        new Deposit().setVisible(true);
    }

    
}
