package bankManagement;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Withdrawal extends JFrame implements ActionListener{
	JButton withdraw,back;
	JTextField amount;
	String pinnumber;
	String cardNumber;
	Withdrawal(String pinnumber, String cardNumber){
		setLayout(null);
		
		this.pinnumber=pinnumber;
		this.cardNumber=cardNumber;
		System.out.println(cardNumber+" inside ins wi");
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text=new JLabel("Enter Amount you want to Withdraw");
		text.setBounds(160, 300, 420, 20);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway", Font.BOLD, 18));
		image.add(text); 
		
		 amount =new JTextField();
		amount.setBounds(170, 350, 320, 40);
//		amount.setForeground(Color.WHITE);
		amount.setFont(new Font("Raleway", Font.BOLD, 30));
		image.add(amount); 
		
		withdraw=new JButton("Withdraw");
		withdraw.setBounds(355, 485, 150, 30);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		back=new JButton("Back");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== withdraw) {
			String amt1= amount.getText();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = dateFormat.format(new Date());
            
			if(amt1.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter the Amount");		
			}else {
				try {
				 double amt=Double.parseDouble(amt1);
				 Conn conn=new Conn();
				 String query1 = "SELECT SUM(amount) FROM bank WHERE cardnumber = '" + cardNumber + "' AND type = 'Deposit'";
//	               System.out.println("here err?");
				    double totalDeposits = 0;
	                try {
	                    ResultSet rs = conn.s.executeQuery(query1);
	                    if (rs.next()) {
	                        totalDeposits = rs.getDouble(1);
	                    }
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            if (totalDeposits >= amt) {
//				 String query = "INSERT INTO bank VALUES ('" + pinnumber + "', '" + formattedDate + "', 'Deposit', '" + amt + "' )";
				 String query = "INSERT INTO bank VALUES ('" + cardNumber +"','" + pinnumber + "', '" + formattedDate + "', 'Withdraw', '-" + amt + "' )";
	             conn.s.executeUpdate(query);
	             JOptionPane.showMessageDialog(null, "Success!! : Rs " + amt + " Withdrawn");
	             new Transactions(pinnumber,cardNumber).setVisible(true);
	             dispose(); // Close the current window
	            }
	             else {
	                    JOptionPane.showMessageDialog(null, "Insufficient balance for withdrawal");
	                }
	             
				}catch(Exception e) {
					System.out.println(e);
				}
			}
			
		}else if(ae.getSource()== back) {
			setVisible(false);
			System.out.println(cardNumber+" inside with");
			new Transactions(pinnumber,cardNumber).setVisible(true);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Withdrawal("","");

	}

}

