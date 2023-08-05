package bankManagement;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class MiniStatement extends JFrame {
	String pinnumber;
	String cardNumber;
	MiniStatement(String pinnumber, String cardNumber){
		
		this.pinnumber=pinnumber;
		this.cardNumber=cardNumber;
	
		setTitle("Mini Statement");
		setLayout(null);
		JLabel bankname=new JLabel("IMPERIAL BANK,LTD");
		bankname.setBounds(150,20,200,20);
		add(bankname);
		JLabel mn=new JLabel("MINI-Statement");
		mn.setBounds(160,40,100,20);
		add(mn);
		
		JLabel mini=new JLabel();
		mini.setBounds(20,140,400,200);
		add(mini);
		
		JLabel text=new JLabel();
		add(text);
		
		String strReplacement = "********";   
		if(cardNumber=="") {
			cardNumber="######notfound###";
		}
        String newString = strReplacement + cardNumber.substring(6);
        
		JLabel card=new JLabel();
		card.setBounds(20,80,300,20);
		card.setText(newString);
		add(card);
		
		//show available balance 
		JLabel balance=new JLabel();
		balance.setBounds(20,400,300,20);
		add(balance);
		
		Conn conn=new Conn();
		try {		
	        
	        String query = "SELECT * FROM bank WHERE cardnumber = ? ORDER BY date DESC LIMIT 5";
	        
	        PreparedStatement pstmt = conn.prepareStatement(query);
	        pstmt.setString(1, cardNumber);

	        ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	        	System.out.println("23");
	            Date date = rs.getDate("date");
	            String type = rs.getString("type");
	            double amount = rs.getDouble("amount");
	            mini.setText(mini.getText()+"<html>"+ date+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ type+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ amount+"<br><br><html>" );
	            
	        }
	        rs.close();
	        pstmt.close();
	        
	        
		}catch(Exception e){
			System.out.println(e);
		}
		
		double amt = 0;
		String query1 = "SELECT SUM(amount) FROM bank WHERE cardnumber = '" + cardNumber + "' AND type = 'Deposit'";
		String query2= "SELECT SUM(amount) FROM bank WHERE cardnumber = '" + cardNumber + "' AND type = 'Withdraw'";
		
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
		balance.setText("Your balance is :"+amt);
		
		
		setSize(400,600);
		setLocation(20,20);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MiniStatement("","");
	}

}
