package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Loan extends JFrame implements ActionListener {
	JLabel z,z1,z2,z3,z4;
	JTextField t,t1,t2;
	JRadioButton r1,r2,r3;
	JOptionPane p1;
	JButton bu1,bu2;
	Loan(){
		z = new JLabel("LOAN");
		z.setBounds(254, 10, 150, 156);
		z.setForeground(Color.YELLOW);
		z.setFont(new Font("System",Font.BOLD,50));
		getContentPane().add(z);
	getContentPane().setBackground(new Color(0, 206, 209));
	
	z1 = new JLabel("PLEASE ENTER THE CURRENT SALARY ");
	z1.setBounds(4, 176, 400, 75);
	z1.setFont(new Font("Dialog", Font.BOLD, 20));
	z1.setForeground(new Color(255, 255, 255));
	getContentPane().add(z1);
	
	t = new JTextField();
	t.setBounds(410, 205, 300, 30);
	getContentPane().add(t);

	z4 = new JLabel("ENTER PIN");
	z4.setBounds(560, 10, 400, 75);
	z4.setFont(new Font("Dialog", Font.BOLD, 15));
	z4.setForeground(new Color(255, 0, 0));
	getContentPane().add(z4);

	t2 = new JTextField();
	t2.setBounds(650, 30, 70, 30);
	getContentPane().add(t2);
	
	z2 = new JLabel("PLEASE SELECT THE TYPE OF LOAN");
	z2.setBounds(4, 274, 400, 52);
	z2.setFont(new Font("Dialog", Font.BOLD, 20));
	z2.setForeground(new Color(255, 255, 255));
	getContentPane().add(z2);
	
	r1 = new JRadioButton("A) CAR LOAN");
	r1.setForeground(new Color(0, 0, 205));
	r1.setBounds(410, 287, 300, 30);
	r1.setFont(new Font("Dialog", Font.BOLD, 15));
	r1.setBackground(Color.WHITE);
	r2 = new JRadioButton("B) HOUSE LOAN");
	r2.setForeground(new Color(0, 0, 205));
	r2.setBounds(410, 309, 300, 30);
	r2.setFont(new Font("Dialog", Font.BOLD, 15));
	r2.setBackground(Color.WHITE);
	r3 = new JRadioButton("C) EDUCATION LOAN");
	r3.setForeground(new Color(0, 0, 205));
	r3.setBounds(410, 332, 300, 30);
	r3.setFont(new Font("Dialog", Font.BOLD, 15));
	r3.setBackground(Color.WHITE);
	
	bu1 = new JButton("ENTER");
	bu1.setBounds(380, 490, 250, 40);
	bu1.setBackground(Color.BLACK);
	bu1.setForeground(Color.WHITE);
	bu1.addActionListener(this);
	
	bu2 = new JButton("Back");
	bu2.setBounds(50, 490, 250, 40);
	bu2.setBackground(Color.BLACK);
	bu2.setForeground(Color.WHITE);
	bu2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent a)
		{
            new Transcations().setVisible(true);
            setVisible(false);
		}
	});
	
	z3 = new JLabel("ENTER THE AMOUNT OF LOAN");
	z3.setBounds(4, 374, 400, 52);
	z3.setFont(new Font("Dialog", Font.BOLD, 20));
	z3.setForeground(new Color(255, 255, 255));
	getContentPane().add(z3);
	
	t1= new JTextField();
	t1.setBounds(410, 390, 300, 30);
	
	getContentPane().add(t1);
	getContentPane().add(bu1);
	getContentPane().add(bu2);
	getContentPane().add(r1);
	getContentPane().add(r2);
	getContentPane().add(r3);
	setSize(750,600);
	setLocation(385,100);
	getContentPane().setLayout(null);
	setVisible(true);
	}
	public void actionPerformed(ActionEvent a) {
		try {
		String str = t.getText();
		String str1 = t1.getText();
		String str2 = t2.getText();
		double valu1 = Double.parseDouble(str1);
		double valu = Double.parseDouble(str);
		double cz=valu1/(valu*2);
		double zx=(valu1+((((valu1/(valu*2))*valu1)/100)));
		//System.out.println("0");
		if(r1.isSelected() && valu >30000.00 && valu1<=600000.00)
		{
			int ax =JOptionPane.showConfirmDialog(getContentPane(), "Loan will be granted for 5 years \n At the rate of interest :" + Math.round(cz*100.00)/100.00 + "\n Total loan with rate of interest : " + Math.round(zx*100.00)/100.00);
			if(ax==JOptionPane.YES_OPTION)
			{
			System.out.println("1");
			conn c2 = new conn();
			ResultSet ds = c2.s.executeQuery(" select * from bank where pin = '" + str2 + "' ");
			
			double balance=0;
			if(ds.next())
			{
				//System.out.println("2");
				String pin = ds.getString("pin");
				while(ds.next())
				{
					balance =ds.getDouble("balance");
				}
				//System.out.println("3");
				balance+=valu1;
                String qr1= "insert into bank values('"+pin +"','" + valu1+"',null,'"+balance+"')";
                //System.out.println("5");
                c2.s.executeUpdate(qr1);
                //System.out.println("6");
			}
			JOptionPane.showMessageDialog(this, "CAR LOAN HAS BEEN GRANTED");
			}
		}
		else if(r2.isSelected() && valu >75000.00 && valu1<2000000.00)
		{
			int bx=JOptionPane.showConfirmDialog(getContentPane(), "Loan will be granted for 10 years \n At the rate of interest :" + Math.round(cz*100.00)/100.00 + "\n Total loan with rate of interest : " + Math.round(zx*100.00)/100.00 );
			if(bx==JOptionPane.YES_OPTION)
			{
				//System.out.println("1");
				conn c2 = new conn();
				ResultSet ds = c2.s.executeQuery(" select * from bank where pin = '" + str2 + "' ");
				
				double balance=0;
				if(ds.next())
				{
					//System.out.println("2");
					String pin = ds.getString("pin");
					while(ds.next())
					{
						balance =ds.getDouble("balance");
					}
					//System.out.println("3");
					balance+=valu1;
	                String qr1= "insert into bank values('"+pin +"','" + valu1+"',null,'"+balance+"')";
	               // System.out.println("5");
	                c2.s.executeUpdate(qr1);
	                //System.out.println("6");
				}				
			JOptionPane.showMessageDialog(this, "HOUSE LOAN HAR BEEN GRANTED");
			}
		}
		else if(r3.isSelected() && valu >20000.00 && valu1<1000000.00)
		{
			int cx = JOptionPane.showConfirmDialog(getContentPane(), "Loan will be granted for 7 years\n At the rate of interest :" + Math.round(cz*100.00)/100.00 + "\n Total loan with rate of interest : " + Math.round(zx*100.00)/100.00);
			if(cx==JOptionPane.YES_OPTION)
			{
				//System.out.println("1");
				conn c2 = new conn();
				ResultSet ds = c2.s.executeQuery(" select * from bank where pin = '" + str2 + "' ");
				
				double balance=0;
				if(ds.next())
				{
					//System.out.println("2");
					String pin = ds.getString("pin");
					while(ds.next())
					{
						balance =ds.getDouble("balance");
					}
					//System.out.println("3");
					balance+=valu1;
	                String qr1= "insert into bank values('"+pin +"','" + valu1+"',null,'"+balance+"')";
	                //System.out.println("5");
	                c2.s.executeUpdate(qr1);
	                //System.out.println("6");
				}				
			JOptionPane.showMessageDialog(this, "EDUCATION LOAN HAS BEEN GRANTED");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(this, "SORRY , THE LOAN CANNOT BE GRANTED");
		}
		r1.setSelected(false);
		r2.setSelected(false);
		r3.setSelected(false);
		t.setText("");
		t1.setText("");
		}
	catch(Exception e)
		{
		JOptionPane.showMessageDialog(getContentPane(), "Check If All The Details Are Filled Correctly");
		}
	}
public static void main(String[] args)
{
	new Loan().setVisible(true);
}
}