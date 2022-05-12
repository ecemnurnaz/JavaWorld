package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mnOpen;
	private JMenuItem mnSave;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JMenu mnNewMenu_1;
	private JMenuItem mnýtmNewMenuItem;

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
	}
	private void initGUI() {
		setTitle("Ecem's NotePad");
		setBackground(Color.WHITE);
		setForeground(Color.DARK_GRAY);
		setFont(new Font("Times New Roman", Font.BOLD, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		
		menuBar = new JMenuBar();
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(Color.DARK_GRAY);
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("File");
		mnNewMenu.setBackground(Color.WHITE);
		mnNewMenu.setForeground(Color.WHITE);
		mnNewMenu.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menuBar.add(mnNewMenu);
		
		mnOpen = new JMenuItem("Open");
		mnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mnOpen_actionPerformed(e);
			}
		});
		mnOpen.setBackground(Color.WHITE);
		mnOpen.setForeground(Color.DARK_GRAY);
		mnOpen.setFont(new Font("Times New Roman", Font.BOLD, 15));
		mnNewMenu.add(mnOpen);
		
		mnSave = new JMenuItem("Save");
		mnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mnSave_actionPerformed(e);
			}
		});
		mnSave.setForeground(Color.DARK_GRAY);
		mnSave.setFont(new Font("Times New Roman", Font.BOLD, 15));
		mnNewMenu.add(mnSave);
		
		mnNewMenu_1 = new JMenu("Help");
		mnNewMenu_1.setBackground(Color.WHITE);
		mnNewMenu_1.setForeground(Color.WHITE);
		mnNewMenu_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menuBar.add(mnNewMenu_1);
		
		mnýtmNewMenuItem = new JMenuItem("About");
		mnýtmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mnýtmNewMenuItem_actionPerformed(e);
			}
		});
		mnýtmNewMenuItem.setForeground(Color.DARK_GRAY);
		mnýtmNewMenuItem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		mnNewMenu_1.add(mnýtmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel, BorderLayout.SOUTH);
		
		lblNewLabel = new JLabel("Plain Text");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("SimSun", Font.BOLD, 12));
		panel.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(textArea);
	}

	protected void do_mnOpen_actionPerformed(ActionEvent e) {
		
		JFileChooser fileChooser = new JFileChooser();
		if(fileChooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
			File fileSelected = fileChooser.getSelectedFile();
			
			List<String> lines;
			try {
				lines = Files.readAllLines(Paths.get(fileSelected.getAbsolutePath()));
				lines.forEach(line->textArea.setText(textArea.getText()+"\n"+line ));
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else {
			//do nothing
		}
	}
	protected void do_mnSave_actionPerformed(ActionEvent e) {
		
		JFileChooser fileChooser = new JFileChooser();
		if(fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(selectedFile.getAbsolutePath()), StandardOpenOption.CREATE)){
				
				writer.write(textArea.getText());
				JOptionPane.showMessageDialog(this, "File is saved");
			}catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	protected void do_mnýtmNewMenuItem_actionPerformed(ActionEvent e) {
		
		JOptionPane.showMessageDialog(this,"Ecem's NotePad 1.0 \n© 2022 Ecemnur Naz. All Rights Reserved \n\n\n", "Not Defteri Hakkýnda", JOptionPane.INFORMATION_MESSAGE, null);
		
	}
}
