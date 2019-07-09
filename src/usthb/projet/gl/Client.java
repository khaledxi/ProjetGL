package usthb.projet.gl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import database.client;
import model.client_M;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Client extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnSupprimer;
	private JButton btnModifier;
	private ArrayList<client_M> arr;

	public Client(boolean directeur) {
		setTitle("Gestion des clients");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 849, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 2, 669, 355);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("",1,18));
		table.setRowHeight(20);
		
		
		
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setEnabled(false);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				client.supprimer((String)model.getValueAt(table.getSelectedRow(), 0));
				JOptionPane.showMessageDialog(null, "la suppretion a été effectuer !!!");
				dispose();
				new Client(directeur);
			}
		});
		btnSupprimer.setBounds(679, 242, 128, 23);
		contentPane.add(btnSupprimer);
		
		btnModifier = new JButton("selectionner");
		btnModifier.setEnabled(false);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Reservation(arr.get(table.getSelectedRow()),directeur);
			}
		});
		btnModifier.setBounds(679, 211, 128, 23);
		contentPane.add(btnModifier);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Reservation(directeur);
				dispose();
				
			}
		});
		btnRetour.setBounds(679, 313, 128, 23);
		contentPane.add(btnRetour);
		
		arr=client.get_all();
		
		remplire_tab();
		setVisible(true);
		setResizable(false);
	}
	private void remplire_tab()
	{
		
		model= new DefaultTableModel();
		Object[] columns = {"N°Permis","Nom","Prénom","Date de Naissance","Lieu de Naissance"};
		
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		for (int i = 0; i < arr.size(); i++) {
			client_M c=arr.get(i);
			String[] row= {c.getNumP(),c.getNom(),c.getPrenom(),c.getDateN()+"",c.getLieuN()};
			model.addRow(row);
		}
		ListSelectionModel list=table.getSelectionModel();
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				btnModifier.setEnabled(true);
				btnSupprimer.setEnabled(true);
			}
		});
	}

}
