package pack1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormOne extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					FormOne frame = new FormOne();
					frame.setVisible(true);
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormOne() {
		setTitle("Form Page 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnExit.setBounds(335, 227, 89, 23);
		contentPane.add(btnExit);
		
		JButton btnForm3 = new JButton("Form 3");
		btnForm3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FormThree f3 = new FormThree();
				f3.setVisible(true);
			}
		});
		btnForm3.setBounds(335, 202, 89, 23);
		contentPane.add(btnForm3);
		
		JButton btnForm2 = new JButton("Form 2");
		btnForm2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FormTwo f2 = new FormTwo();
				f2.setVisible(true);
				
			}
		});
		btnForm2.setBounds(335, 176, 89, 23);
		contentPane.add(btnForm2);
	}
}
