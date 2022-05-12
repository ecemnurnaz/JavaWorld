package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Category;
import model.Person;
import service.AppService;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class UpdatePersonFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtUpdateName;
	private JLabel lblNewLabel;
	private JTextField txtUpdateLastname;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtUpdateWork;
	private JTextField txtUpdateAddress;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField txtUpdateHome;
	private JTextField txtUpdateEmail;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField txtUpdateCity;
	private JTextField txtUpdateBirth;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JComboBox cmbUpdateCategory;
	private JButton btnUpdate;
	private Person person;

	PersonListener listener;
	AppService srv = new AppService();
	List<Category> categories = new ArrayList<Category>();

	public UpdatePersonFrame(PersonListener listener, Person selectedPerson) {

		person = selectedPerson;
		initGUI(person);
		this.listener = listener;

		categories = srv.getAllCategories();

		DefaultComboBoxModel<Category> model = new DefaultComboBoxModel<Category>(
				categories.toArray(new Category[categories.size()]));
		cmbUpdateCategory.setModel(model);
		cmbUpdateCategory.setSelectedIndex(0);
	}

	private void initGUI(Person selectedPerson) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtUpdateName = new JTextField();
		txtUpdateName.setText(person.getName());
		txtUpdateName.setColumns(10);
		txtUpdateName.setBounds(157, 75, 193, 26);
		contentPane.add(txtUpdateName);

		lblNewLabel = new JLabel("name:");
		lblNewLabel.setBounds(46, 80, 61, 16);
		contentPane.add(lblNewLabel);

		txtUpdateLastname = new JTextField();
		txtUpdateLastname.setText(person.getLastname());
		txtUpdateLastname.setColumns(10);
		txtUpdateLastname.setBounds(157, 113, 193, 26);
		contentPane.add(txtUpdateLastname);

		lblNewLabel_1 = new JLabel("Last Name:");
		lblNewLabel_1.setBounds(46, 120, 61, 16);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Work Phone:");
		lblNewLabel_2.setBounds(46, 155, 61, 16);
		contentPane.add(lblNewLabel_2);

		txtUpdateWork = new JTextField();
		txtUpdateWork.setText(person.getWorkphone());
		txtUpdateWork.setColumns(10);
		txtUpdateWork.setBounds(157, 148, 193, 26);
		contentPane.add(txtUpdateWork);

		txtUpdateAddress = new JTextField();
		txtUpdateAddress.setText(person.getAddress());
		txtUpdateAddress.setColumns(10);
		txtUpdateAddress.setBounds(157, 183, 193, 26);
		contentPane.add(txtUpdateAddress);

		lblNewLabel_3 = new JLabel("Address:");
		lblNewLabel_3.setBounds(46, 190, 61, 16);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Home phone:");
		lblNewLabel_4.setBounds(46, 228, 61, 16);
		contentPane.add(lblNewLabel_4);

		txtUpdateHome = new JTextField();
		txtUpdateHome.setText(person.getHomephone());
		txtUpdateHome.setColumns(10);
		txtUpdateHome.setBounds(157, 221, 193, 26);
		contentPane.add(txtUpdateHome);

		txtUpdateEmail = new JTextField();
		txtUpdateEmail.setText(person.getEmail());
		txtUpdateEmail.setColumns(10);
		txtUpdateEmail.setBounds(157, 259, 193, 26);
		contentPane.add(txtUpdateEmail);

		lblNewLabel_5 = new JLabel("Email:");
		lblNewLabel_5.setBounds(46, 266, 61, 16);
		contentPane.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("City");
		lblNewLabel_6.setBounds(46, 312, 61, 16);
		contentPane.add(lblNewLabel_6);

		txtUpdateCity = new JTextField();
		txtUpdateCity.setText(person.getCity());
		txtUpdateCity.setColumns(10);
		txtUpdateCity.setBounds(157, 305, 193, 26);
		contentPane.add(txtUpdateCity);

		txtUpdateBirth = new JTextField();
		txtUpdateBirth.setText(person.getBirthdate());
		txtUpdateBirth.setColumns(10);
		txtUpdateBirth.setBounds(157, 343, 193, 26);
		contentPane.add(txtUpdateBirth);

		lblNewLabel_7 = new JLabel("Birthdate");
		lblNewLabel_7.setBounds(46, 350, 61, 16);
		contentPane.add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("Category:");
		lblNewLabel_8.setBounds(46, 389, 61, 16);
		contentPane.add(lblNewLabel_8);

		cmbUpdateCategory = new JComboBox();
		cmbUpdateCategory.setBounds(157, 381, 193, 27);
		contentPane.add(cmbUpdateCategory);

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnUpdate_actionPerformed(e);
			}
		});
		btnUpdate.setBounds(233, 419, 117, 29);
		contentPane.add(btnUpdate);
	}

	protected void do_btnUpdate_actionPerformed(ActionEvent e) {
		int cat_id = ((Category) cmbUpdateCategory.getSelectedItem()).getId();

		Person p = new Person(person.getId(), txtUpdateName.getText(), txtUpdateLastname.getText(),
				txtUpdateWork.getText(), txtUpdateAddress.getText(), txtUpdateHome.getText(), txtUpdateEmail.getText(),
				txtUpdateCity.getText(), txtUpdateBirth.getText(), cat_id);

		srv.updatePerson(p);

		listener.personUpdated();

		this.dispose();
	}
}
