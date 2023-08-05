package bankManagement;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class SignupThree extends JFrame implements ActionListener{

	JRadioButton r1,r2,r3,r4;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton submit,cancel;
	String formno;
	SignupThree(String formno){
		this.formno=formno;
		setLayout(null);
		JLabel h1=new JLabel("Page 3:Account Details");
		h1.setFont(new Font("Raleway", Font.BOLD, 22));
		h1.setBounds(280,40,400,40);
		add(h1);
		
		JLabel l1=new JLabel("Account Type");
		l1.setFont(new Font("Raleway", Font.BOLD, 18));
		l1.setBounds(100,140,200,30);
		add(l1);
		
		r1=new JRadioButton("Saving Account");
		r1.setFont(new Font("Raleway", Font.BOLD, 16));		
		r1.setBackground(Color.white);
		r1.setBounds(100,180,250,20);
		add(r1);
		
		r2=new JRadioButton("FD Account");
		r2.setFont(new Font("Raleway", Font.BOLD, 16));		
		r2.setBackground(Color.white);
		r2.setBounds(350,180,250,20);
		add(r2);
		
		r3=new JRadioButton("Current Account");
		r3.setFont(new Font("Raleway", Font.BOLD, 16));		
		r3.setBackground(Color.white);
		r3.setBounds(100,220,250,20);
		add(r3);
		
		r4=new JRadioButton("RD Account");
		r4.setFont(new Font("Raleway", Font.BOLD, 16));		
		r4.setBackground(Color.white);
		r4.setBounds(350,220,250,20);
		add(r4);
		
		ButtonGroup groupAccount=new ButtonGroup();
		groupAccount.add(r1);
		groupAccount.add(r2);
		groupAccount.add(r3);
		groupAccount.add(r4);
		
		JLabel card=new JLabel("Card Number");
		card.setFont(new Font("Raleway", Font.BOLD, 18));
		card.setBounds(100,300,200,30);
		add(card);
		
		JLabel number=new JLabel("XXXX-XXXX-XXXX");
		number.setFont(new Font("Raleway", Font.BOLD, 18));
		number.setBounds(330,300,300,30);
		add(number);
		JLabel cardinfo=new JLabel("Your 12 digit Card Number");
		cardinfo.setFont(new Font("Raleway", Font.BOLD, 12));
		cardinfo.setBounds(100,330,200,30);
		add(cardinfo);
		
		JLabel pin=new JLabel("PIN Number");
		pin.setFont(new Font("Raleway", Font.BOLD, 18));
		pin.setBounds(100,370,200,30);
		add(pin);
		
		JLabel pnumber=new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway", Font.BOLD, 18));
		pnumber.setBounds(330,370,300,30);
		add(pnumber);
		
		JLabel services=new JLabel("Services Required");
		services.setFont(new Font("Raleway", Font.BOLD, 18));
		services.setBounds(100,450,200,30);
		add(services);
		
		c1=new JCheckBox("ATM card");
		c1.setBackground(new Color(144, 238, 144));
		c1.setFont(new Font("Raleway", Font.BOLD, 18));
		c1.setBounds(100,500,200,30);
		add(c1);
		
//		 c1 = new JCheckBox("ATM card"); //c1 made diff for testing
		 c2 = new JCheckBox("Internet Banking");
         c3 = new JCheckBox("Mobile Banking");
         c4 = new JCheckBox("E-Statement");
         c5 = new JCheckBox("Cheque Book");
         c6 = new JCheckBox("SMS & Email Alerts");
        

        // Set background color and font for all JCheckBoxes
        Color backgroundColor = new Color(144, 238, 144);
        Font checkBoxFont = new Font("Raleway", Font.BOLD, 18);
//        c1.setBackground(backgroundColor);
        c2.setBackground(backgroundColor);
        c3.setBackground(backgroundColor);
        c4.setBackground(backgroundColor);
        c5.setBackground(backgroundColor);
        c6.setBackground(backgroundColor);
        

//        c1.setFont(checkBoxFont);
        c2.setFont(checkBoxFont);
        c3.setFont(checkBoxFont);
        c4.setFont(checkBoxFont);
        c5.setFont(checkBoxFont);
        c6.setFont(checkBoxFont);
       
        // Set the positions of the JCheckBoxes
        int x = 100;
        int y = 500;
        int width = 200;
        int height = 30;
//        c1.setBounds(x, y, width, height);
        c2.setBounds(x+width+50, y , width, height);
        c3.setBounds(x, y+40, width, height);
        c4.setBounds(x+width+50, y + 40, width, height);
        c5.setBounds(x, y + 80, width, height);
        c6.setBounds(x+width+50, y + 80, width, height);
        
        JCheckBox c7 = new JCheckBox("I hearby declare all info filled is correct");
        c7.setBackground(backgroundColor);
        c7.setBounds(x, y + 140, 300, height);
        c1.setFont(new Font("Raleway", Font.BOLD, 15));
        
        add(c2);
        add(c3);
        add(c4);
        add(c5);
        add(c6);
        add(c7);
//        add(c1);
        submit=new JButton("Submit");
        submit.setBackground(Color.white);
        submit.setBounds(250,720, 100, 30);
        submit.setFont(new Font("Raleway", Font.BOLD, 15));
        add(submit);
        submit.addActionListener(this);
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.white);
        cancel.setBounds(420,720, 100, 30);
        cancel.setFont(new Font("Raleway", Font.BOLD, 15));
        add(cancel);
        cancel.addActionListener(this);
		
        getContentPane().setBackground(new Color(144, 238, 144));
		setSize(850,820);
		setLocation(350,0);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== submit) {
			String accountType=null;
			if(r1.isSelected()){
				accountType="SavingAccount";
			}else if(r2.isSelected()){
				accountType="FDAccount";
			}else if(r3.isSelected()){
				accountType="CurrentAccount";
			}else if(r4.isSelected()){
				accountType="RDAccount";
			}
			
			Random random=new Random();
			String cardNumber=""+Math.abs(random.nextLong()%90000000L)+850000000000L;
			String pinNumber=""+Math.abs(random.nextLong()%9000L)+1000L;
			StringBuilder facillity=new  StringBuilder();
			if(c1.isSelected()) {
				facillity.append("ATM Card");
			}
			if(c2.isSelected()) {
				facillity.append("Internet Banking");
			}
			if(c3.isSelected()) {
				facillity.append("Mobile Banking");
			}
			if(c4.isSelected()) {
				facillity.append("E-Statement");
			}
			if(c5.isSelected()) {
				facillity.append("Cheque Book");
			}
			if(c6.isSelected()) {
				facillity.append("SMS & Email Alerts");
			}
			String cardno="!23123";
			String pin="12321";
			String facilitys=facillity.toString();
			try {
				if(accountType==null) {
					JOptionPane.showMessageDialog(null,"Account type is required");
				}else {
					Conn conn = new Conn();
                    String q1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardno+"','"+pin+"','"+facilitys+"')";  
                    String q2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                    conn.s.executeUpdate(q1);
                    conn.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:"+ pin);
                    
                    setVisible(false);
                    new Deposit(pinNumber,cardNumber).setVisible(true);
				}
			}catch(Exception e){
				System.out.println(e);
			}			
		}
		else if(ae.getSource()== cancel) {
			setVisible(false);
			new Login().setVisible(true);
		}
	}
	public static void main(String[] args) {
		new SignupThree("");	

	}

}
