package pack2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	static ArrayList<User> users = new ArrayList<User>();
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtNewUsername;
	private JTextField txtNewPassword;

	public boolean validateUser(String username, String password) {
		
		return !users.stream()
			 .filter( u -> u.username.equals(username) && u.password.equals(password))
			 .findFirst()
			 .isEmpty();
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
					users.add(new User("Mark","Walker","mwalker","mwalker123"));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 210, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(10, 30, 75, 14);
		contentPane.add(lblNewLabel);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(92, 27, 86, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 58, 75, 14);
		contentPane.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(92, 55, 86, 20);
		contentPane.add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = txtUsername.getText(); 
				String password = txtPassword.getText();
				
				if(validateUser(username, password)){
					MainFrame mf = new MainFrame();
					mf.setVisible(true);
					String userData = users.stream()
										   .filter(u -> u.username.equals(username) && u.password.equals(password))
										   .findFirst()
										   .get().name;
					mf.setLabel(userData);
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "Login Failed!");
				}
				
			}
		});
		btnLogin.setBounds(10, 196, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnNewUser = new JButton("New User");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setBounds(100, 100, 450, 300);
				
			}
		});
		btnNewUser.setBounds(10, 230, 89, 23);
		contentPane.add(btnNewUser);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(220, 11, 204, 242);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User newUser = new User(txtName.getText(),
						txtSurname.getText(),
						txtNewUsername.getText(),
						txtNewPassword.getText());

				users.add(newUser);
				JOptionPane.showMessageDialog(contentPane, "User Saved!");
				setBounds(100, 100, 210, 300);
			}
		});
		btnSave.setBounds(105, 208, 89, 23);
		panel.add(btnSave);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(10, 26, 46, 14);
		panel.add(lblNewLabel_1);
		
		txtName = new JTextField();
		txtName.setText("");
		txtName.setBounds(93, 23, 86, 20);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setText("");
		txtSurname.setColumns(10);
		txtSurname.setBounds(93, 51, 86, 20);
		panel.add(txtSurname);
		
		JLabel lblNewLabel_1_1 = new JLabel("Surname");
		lblNewLabel_1_1.setBounds(10, 54, 73, 14);
		panel.add(lblNewLabel_1_1);
		
		txtNewUsername = new JTextField();
		txtNewUsername.setText("");
		txtNewUsername.setColumns(10);
		txtNewUsername.setBounds(93, 82, 86, 20);
		panel.add(txtNewUsername);
		
		JLabel lblNewLabel_1_2 = new JLabel("Username");
		lblNewLabel_1_2.setBounds(10, 85, 78, 14);
		panel.add(lblNewLabel_1_2);
		
		txtNewPassword = new JTextField();
		txtNewPassword.setText("");
		txtNewPassword.setColumns(10);
		txtNewPassword.setBounds(93, 113, 86, 20);
		panel.add(txtNewPassword);
		
		JLabel lblNewLabel_1_3 = new JLabel("Password");
		lblNewLabel_1_3.setBounds(10, 116, 78, 14);
		panel.add(lblNewLabel_1_3);
	}
}
