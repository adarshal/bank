package bankManagement;
import javax.swing.* ;//for .etc. Jframe
import java.awt.*; //for .etc. img
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
	
	JButton deposit,withdrawal,fastcash, ministatement,pinChange,balanceEnquiry,back ;
	String pinnumber;
	String cardNumber;
	FastCash(String pinnumber, String cardNumber){
		this.pinnumber=pinnumber;
		this.cardNumber=cardNumber;
		setLayout(null);	
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,900);//so that img starts from top left start
		add(image);
		
		JLabel text=new JLabel("Select Withdraw amount");
		text.setBounds(210, 300, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway", Font.BOLD, 18));
		image.add(text); // image.add because we want text above image
		
		//buttons
		 deposit=new JButton("Rs. 100");
		deposit.setBounds(170, 417, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		 withdrawal=new JButton("Rs. 500");
		withdrawal.setBounds(355, 415, 150, 30);
		withdrawal.addActionListener(this);
		image.add(withdrawal);
		
		 fastcash=new JButton("Rs. 1000");
		fastcash.setBounds(170, 450, 150, 30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		 ministatement=new JButton("Rs. 2500");
		ministatement.setBounds(355, 450, 150, 30);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		 pinChange=new JButton("Rs. 5000");
		pinChange.setBounds(170, 485, 150, 30);
		pinChange.addActionListener(this);
		image.add(pinChange);
		
		 balanceEnquiry=new JButton("Rs. 10000");
		balanceEnquiry.setBounds(355, 485, 150, 30);
		balanceEnquiry.addActionListener(this);
		image.add(balanceEnquiry);
		
		 back=new JButton("back");
//		exit.setBounds(250, 520, 150, 30);
		 back.setBounds(355, 520, 150, 30);
		 back.addActionListener(this);
		image.add(back);
		
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== back) {
			setVisible(false);
			new Transactions(pinnumber,cardNumber).setVisible(true);
			dispose();
		}else {
			String amt1=((JButton) ae.getSource() ).getText().substring(3);
			 double amt=Double.parseDouble(amt1);
			 Conn conn=new Conn();
			 try {
				 String query1 = "SELECT SUM(amount) FROM bank WHERE cardnumber = '" + cardNumber + "' AND type = 'Deposit'";
				 String query2= "SELECT SUM(amount) FROM bank WHERE cardnumber = '" + cardNumber + "' AND type = 'Withdraw'";
//	                
				 double totalDeposits = 0;
				 try {
				        ResultSet rs1 = conn.s.executeQuery(query1);
				        if (rs1.next()) {
				        	totalDeposits += rs1.getDouble(1);
				        }
				    } catch (SQLException e) {
				        e.printStackTrace();
				    }

				    try {
				        ResultSet rs2 = conn.s.executeQuery(query2);
				        if (rs2.next()) {
				        	totalDeposits -= rs2.getDouble(1);
				        }
				    } catch (SQLException e) {
				        e.printStackTrace();
				    }
	                if(totalDeposits>=amt) {
	                	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	                    String formattedDate = dateFormat.format(new Date());

	                    String query = "INSERT INTO bank VALUES ('" + cardNumber +"','" + pinnumber + "', '" + formattedDate + "', 'Withdraw', '-" + amt + "' )";
	   	                conn.s.executeUpdate(query);
	   	               JOptionPane.showMessageDialog(null, "Success!! : Rs " + amt + " Withdrawn");
	   	               new Transactions(pinnumber,cardNumber).setVisible(true);
	   	               dispose(); // Close the current window
	                } else {
	                    JOptionPane.showMessageDialog(null, "Insufficient balance for withdrawal");
	                }
				 }catch(SQLException e) {
					 e.printStackTrace();
				}catch(Exception e) {
					System.out.println(e);
				}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FastCash("","");
	}

}

