package pack1;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPage extends JFrame {

	private JPanel contentPane;

	public static ArrayList<Department> departments = new ArrayList<Department>();
	public static ArrayList<Student> students = new ArrayList<Student>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		setTitle("Main Page");
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
		
		JButton btnDepartment = new JButton("Department Form");
		btnDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DepartmentForm depForm = new DepartmentForm();
				depForm.setVisible(true);
				
			}
		});
		btnDepartment.setBounds(132, 46, 142, 61);
		contentPane.add(btnDepartment);
		
		JButton btnStudentForm = new JButton("Student Form");
		btnStudentForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StudentForm stuForm = new StudentForm();
				stuForm.setVisible(true);
				
			}
		});
		btnStudentForm.setBounds(132, 125, 142, 61);
		contentPane.add(btnStudentForm);
	}
}
