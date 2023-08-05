package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener {
    String pinnumber;
    String cardNumber;
    JButton change,back;
    JPasswordField pin,repin;

    public PinChange(String pinnumber, String cardNumber) {
        this.pinnumber = pinnumber;
        this.cardNumber = cardNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Change Your PIN");
        text.setBounds(200, 330, 180, 25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 18));
        image.add(text);
        
        JLabel pintext = new JLabel("Enter New PIN");
        pintext.setBounds(165, 380, 180, 25);
//        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(pintext);
        
         pin = new JPasswordField();
        pin.setBounds(165, 420, 180, 25);
//        pin.setForeground(Color.WHITE);
        pin.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(pin);

        JLabel repintext = new JLabel("Re-Enter New PIN");
        repintext.setBounds(165, 460, 180, 20);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(repintext);

         repin = new JPasswordField();
        repin.setBounds(165, 490, 180, 25);
        repin.setForeground(Color.WHITE);
        repin.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(repin);

        change=new JButton("CHANGE");
        change.setBounds(355, 420, 150, 30);
        change.addActionListener(this);
		image.add(change);
		
		back=new JButton("Back");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== change) {
			try {
				String npin=pin.getText();
				String rpin=repin.getText();
				if(npin.length()!=4) {
					JOptionPane.showMessageDialog(null, "PIN Should be of length 4");
					return;
				}
				if(!npin.equals(rpin)) {
					JOptionPane.showMessageDialog(null, "PIN Does not MATCH");
					return;
				}
				
				Conn conn=new Conn();
				String updateQuery = "UPDATE login SET pin = ? WHERE cardnumber = ?";

		        PreparedStatement pstmt = conn.prepareStatement(updateQuery);
		        pstmt.setString(1, npin);
		        pstmt.setString(2, cardNumber);

		        int rowsUpdated = pstmt.executeUpdate();

		        if (rowsUpdated > 0) {
		            JOptionPane.showMessageDialog(null, "PIN Updated Successfully");
		            // Perform any additional actions or UI updates here
		        } else {
		            JOptionPane.showMessageDialog(null, "Failed to Update PIN");
		        }

		        pstmt.close();
				
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}else if(ae.getSource()== back) {
			setVisible(false);
//			System.out.println(cardNumber+" inside with");
			new Transactions(pinnumber,cardNumber).setVisible(true);
		}
	}
    
    public static void main(String[] args) {
         new PinChange("", "");
    }
}



