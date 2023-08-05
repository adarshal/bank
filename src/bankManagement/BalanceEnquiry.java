package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener  {
	
	    String pinnumber;
	    String cardNumber;
	    JButton back;
	    BalanceEnquiry(String pinnumber, String cardNumber) {
	    	this.pinnumber=pinnumber;
	    	this.cardNumber = cardNumber;
	        setLayout(null);

	        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
	        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
	        ImageIcon i3 = new ImageIcon(i2);
	        JLabel image = new JLabel(i3);
	        image.setBounds(0, 0, 900, 900);
	        add(image);

	        JLabel text = new JLabel("Your Available Balance is :");
	        text.setBounds(200, 330, 250, 25);
	        text.setForeground(Color.WHITE);
	        text.setFont(new Font("Raleway", Font.BOLD, 18));
	        image.add(text);
	        
	        Conn conn=new Conn();
			String query1 = "SELECT SUM(amount) FROM bank WHERE cardnumber = '" + cardNumber + "' AND type = 'Deposit'";
			String query2= "SELECT SUM(amount) FROM bank WHERE cardnumber = '" + cardNumber + "' AND type = 'Withdraw'";
			
			double amt = 0;
			try {
			    ResultSet rs1 = conn.s.executeQuery(query1);
			    if (rs1.next()) {
			        amt += rs1.getDouble(1);
			    }
			} catch (SQLException e) {
			    e.printStackTrace();
			}

			try {
			    ResultSet rs2 = conn.s.executeQuery(query2);
			    if (rs2.next()) {
			        amt -= rs2.getDouble(1);
			    }
			} catch (SQLException e) {
			    e.printStackTrace();
			}
            JLabel balance=new JLabel(""+amt);
            balance.setBounds(350, 360, 250, 25);
            balance.setForeground(Color.WHITE);
            balance.setFont(new Font("Raleway", Font.BOLD, 22));
	        image.add(balance);
            
	        
	        back=new JButton("Back");
			back.setBounds(355, 520, 150, 30);
			back.addActionListener(this);
			image.add(back);
			
	        setSize(900, 900);
	        setLocation(300, 0);
	        setUndecorated(true);
	        setVisible(true);
	        
	    }
	    
	    public void actionPerformed(ActionEvent ae) {
			 if(ae.getSource()== back) {
				setVisible(false);
				new Transactions(pinnumber,cardNumber).setVisible(true);
			}
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BalanceEnquiry("","");
	}

}
