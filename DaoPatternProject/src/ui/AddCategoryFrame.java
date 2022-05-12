package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Category;
import service.AppService;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.security.auth.login.AppConfigurationEntry;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCategoryFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtCategory;
	private JButton btnSave;

	CategoryListener listener;
	AppService srv = new AppService();

	public AddCategoryFrame(CategoryListener listener) {
		initGUI();
		this.listener = listener;
	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Category:");
		lblNewLabel.setBounds(27, 44, 60, 23);
		contentPane.add(lblNewLabel);

		txtCategory = new JTextField();
		txtCategory.setBounds(97, 46, 171, 19);
		contentPane.add(txtCategory);
		txtCategory.setColumns(10);

		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSave_actionPerformed(e);
			}
		});
		btnSave.setBounds(183, 86, 85, 21);
		contentPane.add(btnSave);
	}

	protected void do_btnSave_actionPerformed(ActionEvent e) {

		Category c = new Category(-1, txtCategory.getText());

		srv.saveCategory(c);

		listener.categoryAdded();

		this.dispose();

	}
}
