package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import service.AppService;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Person;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;

public class MainFrame extends JFrame implements PersonListener, CategoryListener {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnNewCategory;
	private JButton btnNewPerson;
	private JButton btnUpdateCategory;
	private JButton btnUpdatePerson;
	private JSplitPane splitPane;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JList list;
	private JTable tblPeople;

	private AppService appService = new AppService();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		initGUI();
		people = appService.getAllContacts();
		refreshCategories();
		refreshPeople();
	}

	private List<Category> categories = new ArrayList<Category>();

	public void refreshCategories() {

		categories = appService.getAllCategories();

		DefaultComboBoxModel<Category> model = new DefaultComboBoxModel<Category>(
				categories.toArray(new Category[categories.size()]));

		list.setModel(model);

	}

	List<Person> people = new ArrayList<Person>();
	private JButton btnDelete;

	public void refreshPeople() {

		String[] columns = { "id", "name", "lastname", "work", "address", "home", "email", "city", "birthdate" };

		Object[][] data = new Object[people.size()][];
		for (int i = 0; i < people.size(); i++) {
			Person current = people.get(i);
			data[i] = new Object[] { current.getId(), current.getName(), current.getLastname(), current.getWorkphone(),
					current.getAddress(), current.getHomephone(), current.getEmail(), current.getCity(),
					current.getBirthdate() };

		}

		DefaultTableModel tblModel = new DefaultTableModel(data, columns);
		tblPeople.setModel(tblModel);

	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		btnNewCategory = new JButton("New Category");
		btnNewCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewCategory_actionPerformed(e);
			}
		});
		panel.add(btnNewCategory);

		btnNewPerson = new JButton("New Person");
		btnNewPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewPerson_actionPerformed(e);
			}
		});
		panel.add(btnNewPerson);

		btnUpdateCategory = new JButton("Update Category");
		btnUpdateCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnUpdateCategory_actionPerformed(e);
			}
		});
		panel.add(btnUpdateCategory);

		btnUpdatePerson = new JButton("Update Person");
		btnUpdatePerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnUpdatePerson_actionPerformed(e);
			}
		});
		panel.add(btnUpdatePerson);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnDelete_actionPerformed(e);
			}
		});
		panel.add(btnDelete);

		splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);

		scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);

		list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				do_list_valueChanged(e);
			}
		});
		scrollPane.setViewportView(list);

		scrollPane_1 = new JScrollPane();
		splitPane.setRightComponent(scrollPane_1);

		tblPeople = new JTable();
		scrollPane_1.setViewportView(tblPeople);
	}

	protected void do_btnUpdateCategory_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	protected void do_list_valueChanged(ListSelectionEvent e) {

		if (!e.getValueIsAdjusting()) {

			people = appService.getContactsByCategoryId(((Category) list.getSelectedValue()).getId());
			refreshPeople();

		}
	}

	protected void do_btnNewPerson_actionPerformed(ActionEvent e) {

		AddPersonFrame frm = new AddPersonFrame(this);
		frm.setVisible(true);

	}

	@Override
	public void personAdded() {

		if (list.getSelectedIndex() == -1) {
			// nothing is selected
			people = appService.getAllContacts();
			refreshPeople();

		} else {
			people = appService.getContactsByCategoryId(((Category) list.getSelectedValue()).getId());
			refreshPeople();

		}
	}

	protected void do_btnNewCategory_actionPerformed(ActionEvent e) {

		AddCategoryFrame frm = new AddCategoryFrame(this);
		frm.setVisible(true);
	}

	@Override
	public void categoryAdded() {

		categories = appService.getAllCategories();
		refreshCategories();

	}

	@Override
	public void personUpdated() {

		if (list.getSelectedIndex() == -1) {
			// nothing is selected
			people = appService.getAllContacts();
			refreshPeople();

		} else {
			people = appService.getContactsByCategoryId(((Category) list.getSelectedValue()).getId());
			refreshPeople();
		}

	}

	protected void do_btnUpdatePerson_actionPerformed(ActionEvent e) {

		if (tblPeople.getSelectedRow() != -1) {
			Person selectedPerson = new Person();
			selectedPerson = people.get(tblPeople.getSelectedRow());
			UpdatePersonFrame frm = new UpdatePersonFrame(this, selectedPerson);
			frm.setVisible(true);
			refreshPeople();
		} else {
			JOptionPane.showMessageDialog(btnUpdatePerson, "Please, select a person.");
		}
	}

	@Override
	public void personDeleted() {
		
		if(list.getSelectedIndex()==-1) {
			//nothing is selected
			people = appService.getAllContacts();
			refreshPeople();
			
		}else {
			people = appService.getContactsByCategoryId(((Category)list.getSelectedValue()).getId());
			refreshPeople();	
		}
		
	}

	protected void do_btnDelete_actionPerformed(ActionEvent e) {
	
		if (tblPeople.getSelectedRow()!=-1) {
			Person current = new Person();
			current = people.get(tblPeople.getSelectedRow());
			DeletePersonFrame frm = new DeletePersonFrame(this, current);
			frm.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(btnUpdatePerson, "Please, select a person.");
		}
	}
}
