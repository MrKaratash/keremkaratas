package pack1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtSurname;
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentForm frame = new StudentForm();
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
	public StudentForm() {
		setTitle("Student Form");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtSurname = new JTextField();
		txtSurname.setColumns(10);
		txtSurname.setBounds(66, 78, 86, 20);
		contentPane.add(txtSurname);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(66, 37, 86, 20);
		contentPane.add(txtName);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 40, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(10, 81, 64, 14);
		contentPane.add(lblSurname);
		
		DefaultComboBoxModel<String> cbModel = new DefaultComboBoxModel<String>();
		MainPage.departments.forEach(d -> cbModel.addElement(d.getTitle()));

		JComboBox cbDept = new JComboBox(cbModel);
		cbDept.setBounds(66, 134, 86, 22);
		contentPane.add(cbDept);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Student stu = new Student();
				stu.setName(txtName.getText());
				stu.setSurname(txtSurname.getText());
				stu.setDepartment(cbDept.getSelectedItem().toString());
				
				MainPage.students.add(stu);
				JOptionPane.showMessageDialog(cbDept, "Student Saved");
				txtName.setText("");
				txtSurname.setText("");
				cbDept.setSelectedIndex(0);
				
				
				
				
			}
		});
		btnSave.setBounds(63, 178, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(63, 212, 89, 23);
		contentPane.add(btnBack);
	}
}
