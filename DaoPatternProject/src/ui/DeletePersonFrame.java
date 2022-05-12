package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Person;
import service.AppService;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeletePersonFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblDouYouWant;
	private JButton btnYes;
	private JButton btnCancel;

	private Person person;
	
	PersonListener listener;
	AppService srv = new AppService();
	
	public DeletePersonFrame(PersonListener listener, Person selectedPerson) {
		person=selectedPerson;
		this.listener=listener;
		initGUI();
	}
	private void initGUI() {
		setResizable(false);
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 217);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setLayout(null);
		contentPane.add(panel, BorderLayout.CENTER);
		
		lblDouYouWant = new JLabel("Are you sure you want to delete info?");
		lblDouYouWant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDouYouWant.setBounds(87, 32, 239, 23);
		panel.add(lblDouYouWant);
		
		btnYes = new JButton("Yes");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnYes_actionPerformed(e);
			}
		});
		btnYes.setBounds(106, 75, 89, 23);
		panel.add(btnYes);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCancel_actionPerformed(e);
			}
		});
		btnCancel.setBounds(205, 75, 89, 23);
		panel.add(btnCancel);
	}

	protected void do_btnYes_actionPerformed(ActionEvent e) {
	
		srv.deletePerson(person);
		listener.personDeleted();
		this.dispose();
	
	}
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
	
		this.dispose();
	}
}
