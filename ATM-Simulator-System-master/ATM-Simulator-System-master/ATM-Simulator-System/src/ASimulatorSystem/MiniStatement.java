package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
 
    JTable t1;
    JButton b1,b2;
    String x[] = {"Deposit","Withdraw","Balance"};
    String y[][] = new String[2000][3];
    int i=0, j=0;
    
    MiniStatement(){
        super("Account Statement");
        setSize(1200,650);
        setLocation(200,90);
     		 String pinn = JOptionPane.showInputDialog("Enter PIN");

        
        try{
            conn c1  = new conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '" + pinn + "'");
          //  String s1 = "select * from bank";
          //  ResultSet rs  = c1.s.executeQuery(s1);
            while(rs.next()){
        //        y[i][j++]=rs.getString("customer_name");
         //      y[i][j++]=rs.getString("date");
                y[i][j++]=rs.getString("deposit");
                y[i][j++]=rs.getString("withdraw");
                y[i][j++]=rs.getString("balance");
                i++;
                j=0;
            }
            t1 = new JTable(y,x);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        b1 = new JButton("Print");
        b2 = new JButton("Back");
        add(b2,"West");
        add(b1,"South");
        JScrollPane sp = new JScrollPane(t1);
        add(sp);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        try{
        	if(ae.getSource()==b1)
        	{
            t1.print();
        	}
        	else if(ae.getSource()==b2)
        	{
         		new Transcations().setVisible(true);
         		setVisible(false);
        	}
        		
        }catch(Exception e){}
    }
    
    public static void main(String[] args){
        new MiniStatement().setVisible(true);
    }
    
}
