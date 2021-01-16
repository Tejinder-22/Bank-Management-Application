package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Online_Transactions extends JFrame implements ActionListener {
	JLabel j11,j12,j13,j14,j15;
	JTextField t11,t12,t13,t14;
	JButton b11,b12;
	Online_Transactions(){
		getContentPane().setBackground(new Color(0, 206, 209));
		j11 = new JLabel("ONLINE TRANSACTIONS");
		j11.setFont(new Font("System",Font.BOLD,40));
		j11.setBounds(130, 10, 500, 91);
		j11.setForeground(Color.YELLOW);
		getContentPane().add(j11);
		
		j12 = new JLabel("Reciever's Card Number ");
		j12.setBounds(20,135,400,100);
		j12.setFont(new Font("Dialog", Font.BOLD, 27));
		j12.setForeground(new Color(255, 255, 255));
		getContentPane().add(j12);
		
		t11 = new JTextField();
		t11.setBounds(400, 165, 250, 30);
		getContentPane().add(t11);
		
		j13 = new JLabel("Enter The Amount ");
		j13.setBounds(20, 205, 400, 100);
		j13.setFont(new Font("Dialog", Font.BOLD, 27));
		j13.setForeground(new Color(255, 255, 255));
		getContentPane().add(j13);
		
		t12 = new JTextField();
		t12.setBounds(400, 235, 250, 32);
		getContentPane().add(t12);
		
		j14 = new JLabel("ReEnter The Amount ");
		j14.setBounds(20, 277, 400, 100);
		j14.setFont(new Font("Dialog", Font.BOLD, 27));
		j14.setForeground(new Color(255, 255, 255));
		getContentPane().add(j14);

		t13 = new JTextField();
		t13.setBounds(400, 305, 250, 30);
		getContentPane().add(t13);
		
		b11 = new JButton("ENTER");
		b11.setBounds(420, 480, 200, 40);
		b11.setBackground(Color.BLACK);
		b11.setForeground(Color.WHITE);
		getContentPane().add(b11);
		
		b12 = new JButton("BACK");
		b12.setBounds(50, 480, 200, 40);
		b12.setBackground(Color.BLACK);
		b12.setForeground(Color.WHITE);
		getContentPane().add(b12);
		
		j15 = new JLabel("Enter The Pin ");
		j15.setBounds(20, 345, 400, 100);
		j15.setFont(new Font("Dialog", Font.BOLD, 27));
		j15.setForeground(new Color(255, 255, 255));
		getContentPane().add(j15);
		
		t14 = new JTextField();
		t14.setBounds(400, 375, 250, 30);
		getContentPane().add(t14);

		b12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Transcations().setVisible(true);
				setVisible(false);
			}
		});
		
		b11.addActionListener(this);
		setSize(730,600);
		setLocation(385,100);
		getContentPane().setLayout(null);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String str = t12.getText();
			String str1 =t14.getText();
			String str2 =t11.getText();
			
			int b = (int)Double.parseDouble(str1);
			int w = (int)Double.parseDouble(str2);
		if(e.getSource()==b11) {
			conn za = new conn();
			if(t11.getText()==null || t12.getText()==null || t13.getText()==null || t14.getText()==null)
			{
				JOptionPane.showMessageDialog(this,"PLEASE COMPLETELY FILL ALL THE BLANKS");
			}
			else
			{
				ResultSet rs = za.s.executeQuery(" select * from bank where pin = '"+b+"'");
				double balance=0;
				double a = Double.parseDouble(str);
				if(rs.next())
				{
					String pin = rs.getString("pin");
					while(rs.next())
					balance=rs.getDouble("balance");
					balance-=a;
                    String q1= "insert into bank values('"+pin+"',null,'"+a+"','"+balance+"')";
                    
                    za.s.executeUpdate(q1);
                    ResultSet fs=za.s.executeQuery("select * from login where cardno = '"+str2+"'");
                    if(fs.next())
                    {
                    	String pino = fs.getString("pin");
                    	ResultSet gs=za.s.executeQuery(" select * from bank where pin = '"+pino+"'");
                    	double balancey=0;                    	
                    	if(gs.next())
                    	{
                    	String pins=gs.getString("pin");
                    	balancey=gs.getDouble("balance");
                    	balancey+=a;
                    	String stadf="insert into bank values('"+pins+"','"+a+"',null,'"+balancey+"')";
                    	za.s.executeUpdate(stadf);
                    	System.out.println("9");
                    }
                    }
				}

                JOptionPane.showMessageDialog(null, "TRANSACTION OF RS."+ a +"SUCCESSFULLY COMPLETED");
                
                new Transcations().setVisible(true);
                setVisible(false);				
			} 
		}
		}
		catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this,"PLEASE COMPLETELY FILL ALL THE BLANKS");
			}
			
		}
	
	public static void main(String[] args)
	{
		new Online_Transactions().setVisible(true);
	}
}
