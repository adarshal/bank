package bankManagement;

import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //for ActionListener
import java.sql.*;
public class Login extends JFrame implements ActionListener{
   
	JButton clear,signup,login;
	JTextField cardTextField;
	JPasswordField pinTextField;
	Login(){
		setTitle("ATM");
		setLayout(null);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bankLogo.jpg"));
		Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT) ;// Image class in awt
		ImageIcon i3=new ImageIcon(i2);//converted to ImageIcon because Jlabel takes ImageIcon
		JLabel label=new JLabel(i3);
		label.setBounds(70,10,100,100);
		add(label);
		
		JLabel text=new JLabel("Welcome to ATM");
		text.setFont(new Font("Oswald", Font.BOLD,38));
		text.setBounds(200,40,400,40); // from left ,top,wdth, height, 
		add(text);
		
		JLabel cardno=new JLabel("Card No.");
		cardno.setFont(new Font("Oswald", Font.BOLD,28));
		cardno.setBounds(120,150,150,30); // from left ,top,wdth, height, width
		add(cardno);
		
		 cardTextField=new JTextField();
		cardTextField.setBounds(300,150,230,30);
		cardTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(cardTextField);
		
		JLabel pin=new JLabel("PIN");
		pin.setFont(new Font("Oswald", Font.BOLD,28));
		pin.setBounds(120,220,400,30); // from left ,top,wdth, height, width
		add(pin);
		
		 pinTextField=new JPasswordField();
		pinTextField.setBounds(300,220,230,30);
		pinTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(pinTextField);
		
		 login=new JButton("Sign In");
		login.setBounds(300,300,100,30);
		login.setBackground(Color.white);
		login.setForeground(Color.black);
		login.addActionListener(this);
		add(login);
		
		 signup=new JButton("Signup");
		signup.setBounds(430,300,100,30);
		signup.setBackground(Color.white);
		signup.setForeground(Color.black);
		signup.addActionListener(this);
		add(signup);
		
		 clear=new JButton("Clear");
		clear.setBounds(300,350,230,30);
		clear.setBackground(Color.white);
		clear.setForeground(Color.black);
		clear.addActionListener(this);
		add(clear);
		
		
		
		
		getContentPane().setBackground(new Color(144, 238, 144));
		
		setSize(800,480);
		setVisible(true);//set vis will show window
		setLocation(350,200); //default open loc top left
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== clear) {
			cardTextField.setText("");
			pinTextField.setText("");
		}else if(ae.getSource()== login) {
			System.out.println("logg");
			Conn conn=new Conn();
			String cardnumber=cardTextField.getText();
			String pinnumber=pinTextField.getText();
			String query = "SELECT * FROM login WHERE cardnumber='" + cardnumber + "' AND pin='" + pinnumber + "'";
		    try {
				ResultSet rs= conn.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
//					System.out.println(cardnumber+" inside login");
					new Transactions(pinnumber,cardnumber).setVisible(true);
				}
			}catch(Exception e){
				System.out.println(e);
			}
		}else if(ae.getSource()== signup) {
			setVisible(false);
			new SignupOne().setVisible(true);
		}
	}
	public static void main(String[] args) {
    new Login();
	}

}
