package pack1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DepartmentForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtFaculty;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentForm frame = new DepartmentForm();
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
	public DepartmentForm() {
		setTitle("Department Form");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Title");
		lblNewLabel.setBounds(10, 40, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(66, 37, 86, 20);
		contentPane.add(txtTitle);
		txtTitle.setColumns(10);
		
		txtFaculty = new JTextField();
		txtFaculty.setColumns(10);
		txtFaculty.setBounds(66, 78, 86, 20);
		contentPane.add(txtFaculty);
		
		JLabel lblFaculty = new JLabel("Faculty");
		lblFaculty.setBounds(10, 81, 64, 14);
		contentPane.add(lblFaculty);
		
		DefaultComboBoxModel<String> cbModel = new DefaultComboBoxModel<String>();
		MainPage.departments.forEach(d -> cbModel.addElement(d.getTitle()));
		
		/*for (Department d : MainPage.departments) {
			cbModel.addElement(d.getTitle());
		}*/
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		JList list = new JList(listModel);
		list.setBounds(259, 80, 89, 156);
		contentPane.add(list);
		
		
		JComboBox cbDept = new JComboBox(cbModel);
		cbDept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.removeAllElements();
				MainPage.students.stream()
								 .filter(s-> 
								 s.getDepartment()
								 .equals( String.valueOf( cbDept.getSelectedItem())))
								 .forEach(s-> listModel.addElement(s.getName()+" "+s.getSurname()));
				
			}
		});
		cbDept.setBounds(259, 36, 89, 22);
		contentPane.add(cbDept);
		
		
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Department dept = new Department();
				dept.setTitle(txtTitle.getText());
				dept.setFaculty(txtFaculty.getText());
				
				MainPage.departments.add(dept);
				JOptionPane.showMessageDialog(contentPane, "Department Saved!");
				txtTitle.setText("");
				txtFaculty.setText("");
				
				cbModel.removeAllElements();
				MainPage.departments.forEach(d-> cbModel.addElement(d.getTitle()));
				
				
			}
		});
		btnSave.setBounds(63, 156, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(63, 201, 89, 23);
		contentPane.add(btnBack);
		
		
	
	}
}
