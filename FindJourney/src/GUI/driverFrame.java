package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import MainAndSystem.TransportationSystem;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class driverFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField ratingField;
	private JTextField companyField;
	
	TransportationGUI tg;
	

	
	public driverFrame(TransportationGUI tg) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name: ");
		lblNewLabel.setBounds(10, 11, 74, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Rating");
		lblNewLabel_1.setBounds(10, 36, 74, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCoimpany = new JLabel("Company");
		lblCoimpany.setBounds(10, 61, 74, 14);
		contentPane.add(lblCoimpany);
		
		nameField = new JTextField();
		nameField.setBounds(94, 8, 214, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		ratingField = new JTextField();
		ratingField.setColumns(10);
		ratingField.setBounds(94, 33, 214, 20);
		contentPane.add(ratingField);
		
		companyField = new JTextField();
		companyField.setColumns(10);
		companyField.setBounds(94, 58, 214, 20);
		contentPane.add(companyField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 414, 134);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("Add Driver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String name = nameField.getText();
                String ratingText = ratingField.getText();
                String company = companyField.getText();
                try {
                    double rating = Double.parseDouble(ratingText);
                    if (rating<0 || rating > 5)
                    	throw new NumberFormatException();
                    TransportationSystem.addDriver(name, rating, company);
                    textArea.append("Driver added: " + name + "\n");
                } catch (NumberFormatException ex) {
                    textArea.append("Invalid input format.\n");
                }
                nameField.setText("");
                ratingField.setText("");
                companyField.setText("");
			}
		});
		btnNewButton.setBounds(10, 231, 96, 23);
		contentPane.add(btnNewButton);
		
		JButton btnDisplaydrivers = new JButton("Display Drivers");
		btnDisplaydrivers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String drivers = TransportationSystem.displayDrivers();
                if (drivers.isEmpty()) {
                    textArea.append("No drivers found.\n");
                } else {
                    textArea.append("Drivers:" + drivers + "\n");
                }
			}
		});
		btnDisplaydrivers.setBounds(104, 231, 108, 23);
		contentPane.add(btnDisplaydrivers);
		
		JButton btnSearchDriver = new JButton("Search Driver");
		btnSearchDriver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String name = nameField.getText();
                String result = TransportationSystem.searchDriver(name);
                if (result == null) {
                    textArea.append("Driver not found: " + name + "\n");
                } else {
                    textArea.append("Driver found:" + result + "\n");
                }
                nameField.setText("");
			}
		});
		btnSearchDriver.setBounds(210, 231, 108, 23);
		contentPane.add(btnSearchDriver);
		
		JButton close = new JButton("Close");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tg.setVisible(true);
				textArea.setText("");
				dispose();
			}
		});
		close.setBounds(350, 7, 74, 23);
		contentPane.add(close);
		
		JButton delete = new JButton("Delete Driver");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
                if (name.isEmpty()) {
                    textArea.setText("Please enter a name to delete.\n");
                    return;
                }
                if(TransportationSystem.deleteDriver(name)) {
                	textArea.setText("Deleted driver: " + name + "\n");
                	nameField.setText("");
                }
                else
                {
                	textArea.setText("Driver not found");
                	nameField.setText("");
                }
			}
		});
		delete.setBounds(316, 231, 108, 23);
		contentPane.add(delete);
	}
}
