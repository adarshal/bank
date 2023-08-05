package bankManagement;
import javax.swing.* ;//for .etc. Jframe
import java.awt.*; //for .etc. img
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
	
	JButton deposit,withdrawal,fastcash, ministatement,pinChange,balanceEnquiry,exit ;
	String pinnumber;
	String cardNumber;
	Transactions(String pinnumber, String cardNumber){
		this.pinnumber=pinnumber;
		this.cardNumber=cardNumber;
		setLayout(null);	
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,900);//so that img starts from top left start
		add(image);
		
		JLabel text=new JLabel("Please select your Transaction");
		text.setBounds(210, 300, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway", Font.BOLD, 18));
		image.add(text); // image.add because we want text above image
		
		//buttons
		 deposit=new JButton("Deposit");
		deposit.setBounds(170, 417, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		 withdrawal=new JButton("Withdrawal");
		withdrawal.setBounds(355, 415, 150, 30);
		withdrawal.addActionListener(this);
		image.add(withdrawal);
		
		 fastcash=new JButton("Fastcash");
		fastcash.setBounds(170, 450, 150, 30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		 ministatement=new JButton("Mini Statement");
		ministatement.setBounds(355, 450, 150, 30);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		 pinChange=new JButton("PIN Change");
		pinChange.setBounds(170, 485, 150, 30);
		pinChange.addActionListener(this);
		image.add(pinChange);
		
		 balanceEnquiry=new JButton("Balance Enquiry");
		balanceEnquiry.setBounds(355, 485, 150, 30);
		balanceEnquiry.addActionListener(this);
		image.add(balanceEnquiry);
		
		 exit=new JButton("Exit");
//		exit.setBounds(250, 520, 150, 30);
		exit.setBounds(355, 520, 150, 30);
		exit.addActionListener(this);
		image.add(exit);
		
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== exit) {
			System.exit(0);
		}else if(ae.getSource()== deposit) {
			setVisible(false);
//			System.out.println(cardNumber+" inside tran de");
			new Deposit(pinnumber,cardNumber).setVisible(true);
		}else if(ae.getSource()== withdrawal) {
			setVisible(false);
//			System.out.println(cardNumber+" inside tran with");
			new Withdrawal(pinnumber,cardNumber).setVisible(true);
		}else if(ae.getSource()== fastcash) {
		  setVisible(false);
		  new FastCash(pinnumber,cardNumber).setVisible(true);
	    }else if(ae.getSource()== pinChange) {
			  setVisible(false);
			  new PinChange(pinnumber,cardNumber).setVisible(true);
		    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Transactions("","");
	}

}
