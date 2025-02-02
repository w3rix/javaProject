package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainAndSystem.TransportationSystem;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class TripFrame extends JFrame {

	private JPanel contentPane;
	private JTextField baseRate;
	private JTextField fee;
	private JTextField discount;

	TransportationGUI tg;
	
	
	public TripFrame(TransportationGUI tg) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Company Name");
		lblNewLabel.setBounds(32, 24, 84, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Base Rate");
		lblNewLabel_1.setBounds(32, 61, 84, 14);
		contentPane.add(lblNewLabel_1);
		
		baseRate = new JTextField();
		baseRate.setBounds(145, 58, 86, 20);
		contentPane.add(baseRate);
		baseRate.setColumns(10);
		
		fee = new JTextField();
		fee.setBounds(145, 96, 86, 20);
		contentPane.add(fee);
		fee.setColumns(10);
		
		JLabel lblfee = new JLabel("Surge Multiplier");
		lblfee.setBounds(32, 99, 101, 14);
		contentPane.add(lblfee);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String selectedCompany = comboBox.getSelectedItem().toString();
		        switch (selectedCompany) {
		            case "Uber":
		                lblfee.setText("Surge Multiplier");
		                break;
		            case "Lyft":
		            	lblfee.setText("Trip Fee");
		                break;
		            case "Cabify":
		            	lblfee.setText("Luxury Fee");
		                break;
		           
		        }
		    }
		});

		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Uber", "Lyft", "Cabify"}));
		comboBox.setBounds(145, 20, 84, 22);
		contentPane.add(comboBox);
		
		JLabel discounttetxt = new JLabel("Discount Rate");
		discounttetxt.setBounds(32, 139, 84, 14);
		contentPane.add(discounttetxt);
		
		discount = new JTextField();
		discount.setBounds(145, 136, 86, 20);
		contentPane.add(discount);
		discount.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 164, 380, 211);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton dispaly = new JButton("Display");
		dispaly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(TransportationSystem.calculateFee(comboBox.getSelectedItem().toString(), Double.parseDouble(baseRate.getText()), Double.parseDouble(fee.getText()), Double.parseDouble(discount.getText())));
				} catch (NumberFormatException ex) {
					textArea.setText("Invalid input");
				}
				
			}
		});
		dispaly.setBounds(323, 95, 89, 23);
		contentPane.add(dispaly);
		
		JButton close = new JButton("Close");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tg.setVisible(true);
				textArea.setText("");
				dispose();
			}
		});
		close.setBounds(323, 20, 89, 23);
		contentPane.add(close);
		
		JButton btnNewButton = new JButton("Display All Trips");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( TransportationSystem.compArr.isEmpty())
					textArea.setText("There are no trips");
				else
					textArea.setText(TransportationSystem.displayTrips());
			}
		});
		btnNewButton.setBounds(285, 135, 127, 23);
		contentPane.add(btnNewButton);
		
		
	}
}
