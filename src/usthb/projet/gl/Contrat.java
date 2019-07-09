package usthb.projet.gl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import com.toedter.calendar.JDateChooser;

import database.reservation;
import database.typeV;
import model.res;

import javax.swing.JCheckBox;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class Contrat extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JDateChooser dateChooser;
	private JButton btnSupprimer,btnModifier,btnCalculer;
	private JCheckBox chckbxPayer;
	private DefaultTableModel model;
	private ArrayList<res> arr;
	private JLabel label_3;

	
	public Contrat(boolean directeur) {
		setTitle("Gestion des contrats");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 906, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new AffReservation(directeur);
				
			}
		});
		btnRetour.setBounds(740, 385, 110, 23);
		contentPane.add(btnRetour);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Facture(0,directeur);
			}
		});
		btnAfficher.setBounds(376, 385, 89, 23);
		contentPane.add(btnAfficher);
		
		JLabel lblAfficherLesFactures = new JLabel("Afficher les factures");
		lblAfficherLesFactures.setBounds(234, 389, 132, 14);
		contentPane.add(lblAfficherLesFactures);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 11, 694, 363);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		model = new DefaultTableModel();
		Object[] columns = {"NumC","NPermis","CatV","Mat","Km D","Date D"};
		
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("",1,18));
		table.setRowHeight(20);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setEnabled(false);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reservation.supprimer(Integer.parseInt((String) model.getValueAt(table.getSelectedRow(), 0)));
				JOptionPane.showMessageDialog(null, "supprition effectuer");
				dispose();
				new Contrat(directeur);
			}
		});
		btnSupprimer.setBounds(740, 351, 110, 23);
		contentPane.add(btnSupprimer);
		
		btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reservation.completer(Integer.parseInt((String) model.getValueAt(table.getSelectedRow(), 0)), new Date(dateChooser.getDate().getTime()), Integer.parseInt(textField.getText()), 0, chckbxPayer.isSelected());
				JOptionPane.showMessageDialog(null, "modification effectuer");
				dispose();
				new Contrat(directeur);
			}
		});
		btnModifier.setEnabled(false);
		btnModifier.setBounds(740, 317, 110, 23);
		contentPane.add(btnModifier);
		
		JLabel label = new JLabel("kilometer a la fin :");
		label.setBounds(734, 11, 146, 20);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setText("000");
		textField.setColumns(10);
		textField.setBounds(744, 42, 136, 23);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("date de remise re\u00E9l :");
		label_1.setBounds(734, 76, 146, 20);
		contentPane.add(label_1);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(744, 107, 136, 23);
		contentPane.add(dateChooser);
		dateChooser.setEnabled(false);
		
		JLabel label_2 = new JLabel("le prix :");
		label_2.setBounds(734, 198, 66, 20);
		contentPane.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setBounds(807, 198, 73, 20);
		contentPane.add(label_3);
		
		chckbxPayer = new JCheckBox("est payer");
		chckbxPayer.setEnabled(false);
		chckbxPayer.setBounds(753, 237, 97, 23);
		contentPane.add(chckbxPayer);
		
		btnCalculer = new JButton("calculer");
		btnCalculer.setEnabled(false);
		btnCalculer.setBounds(747, 164, 89, 23);
		contentPane.add(btnCalculer);
		
		remplire_tab();
		
		setResizable(false);
		setVisible(true);
	}
	private void remplire_tab()//add table listener
	{
		arr=reservation.get_C_D();
		for (int i = 0; i < arr.size(); i++) {
			String[] row= {arr.get(i).getNumC()+"",arr.get(i).getNumP()+"",typeV.get_type(arr.get(i).getMatV()),arr.get(i).getMatV(),arr.get(i).getKiloD()+"",arr.get(i).getDateD()+""};
			model.addRow(row);
		}
		ListSelectionModel list= table.getSelectionModel();
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				dateChooser.setEnabled(true);
				textField.setEnabled(true);
				//btnModifier.setEnabled(true);
				btnSupprimer.setEnabled(true);
				btnCalculer.setEnabled(true);
				chckbxPayer.setEnabled(true);
				
				int n=table.getSelectedRow();
				dateChooser.setDate(arr.get(n).getDateF());
				textField.setText(arr.get(n).getKiloF()+"");
				chckbxPayer.setSelected(false);
				label_3.setText("");
			}
		});
		
		// calculer
		// calcuer text listenet
		btnCalculer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int n=table.getSelectedRow();
				int kilo=Integer.parseInt(textField.getText())-arr.get(n).getKiloD();
				label_3.setText(""+typeV.calcuer(typeV.get_type(arr.get(n).getMatV()), kilo, arr.get(n).getDateD(), arr.get(n).getDateF()));
				btnModifier.setEnabled(true);
				//btnSupprimer.setEnabled(true);
			}
		});
	}
}
