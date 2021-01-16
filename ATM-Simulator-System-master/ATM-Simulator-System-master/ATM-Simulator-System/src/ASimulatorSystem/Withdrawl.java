
package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    
    Withdrawl(){
        
        setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("WITHDRAWAL");
        int y = fm.stringWidth(" ");
        int z = getWidth() - (3*x);
        int w = z/y;
        String pad ="";
        //for (int i=0; i!=w; i++) pad +=" ";   
        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"WITHDRAWAL");
        
        
        l1 = new JLabel("MAXIMUM DAILY WITHDRAWAL");
        l1.setBackground(new Color(255, 215, 0));
        l1.setForeground(new Color(255, 255, 0));
        l1.setFont(new Font("System", Font.BOLD, 40));
        
        l2 = new JLabel("IS RS.10,000");
        l2.setForeground(Color.YELLOW);
        l2.setFont(new Font("System", Font.BOLD, 40));
        
        l3 = new JLabel("PLEASE ENTER YOUR AMOUNT:");
        l3.setForeground(new Color(0, 0, 0));
        l3.setFont(new Font("Dialog", Font.BOLD, 30));
        
        l4 = new JLabel("Enter Pin");
        l4.setForeground(new Color(255, 0, 0));
        l4.setFont(new Font("Dialog", Font.BOLD, 16));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        t2 = new JTextField(); //pin
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        
        b1 = new JButton("WITHDRAW");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
    
        b2 = new JButton("BACK");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("EXIT");
        b3.setFont(new Font("System", Font.BOLD, 18));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        
        getContentPane().setLayout(null);
        
        l4.setBounds(620,10,80,30);
        getContentPane().add(l4);
        
        t2.setBounds(700,10,52,30);
        getContentPane().add(t2);
        
        l1.setBounds(90,100,800,60);
        getContentPane().add(l1);
        
        l2.setBounds(270,160,800,60);
        getContentPane().add(l2);
        
        l3.setBounds(10,298,800,60);
        getContentPane().add(l3);
        
        t1.setBounds(516,314,222,35);
        getContentPane().add(t1);
        
        b1.setBounds(220,400,160,50);
        getContentPane().add(b1);
        
        b2.setBounds(400,400,160,50);
        getContentPane().add(b2);
        
        b3.setBounds(300,550,200,50);
        getContentPane().add(b3);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        
        getContentPane().setBackground(new Color(0, 206, 209));
        
        setSize(790,680);
        setLocation(380,90);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
       
        try{        
           
            String a = t1.getText();
            String b = t2.getText();
            
            
            
            
            if(ae.getSource()==b1){
                if(t1.getText().equals("") || t2.getText().equals("")){
                    
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw and Pin");
                
                }
                else{
                    
                    conn c1 = new conn();
                    
                    
                    
                    ResultSet rs = c1.s.executeQuery(" select * from bank where pin = '"+b+"' ");
                    
                    double balance = 0;
                    if(rs.next()){
                        String pin = rs.getString("pin");
                        while(rs.next())
                        balance = rs.getDouble("balance");
                        
                        double d = Double.parseDouble(a);
                        if(balance > d)
                        {
                        balance-=d;
                        String q1= "insert into bank values('"+pin+"',null,'"+d+"','"+balance+"')";
                    
                        c1.s.executeUpdate(q1);
                        JOptionPane.showMessageDialog(null, "Rs. "+a+" Debited Successfully");
                       // System.out.println("Amount entered successfully");
                        new Transcations().setVisible(true);
                        setVisible(false);
                        }
                        else
                        {
                        	JOptionPane.showMessageDialog(this, "Please Enter a valid amount");
                        	//System.out.println("Amount not entered");
                        }
                    }
                    
                    
                    
                    
                    
                    
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
        new Withdrawl().setVisible(true);
    }
}
