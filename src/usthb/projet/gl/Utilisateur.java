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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import database.users;
import model.user;

import javax.swing.JCheckBox;

public class Utilisateur extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblPrenom;
	private JLabel lblDateDeNaissance;
	private JLabel lblSalaire;
	private JTextField textField_3;
	private JButton btnAjouter;
	private JButton btnSupprimer;
	private JButton btnModifier;
	private JButton btnRetour;
	private JTextField textField_2;
	private DefaultTableModel model;
	private JLabel label;
	private JDateChooser dateChooser ;
	private JCheckBox chckbxDirecteur;
	private ArrayList<user> arr;

	
	public Utilisateur(boolean directeur) {
		setTitle("Gestion des utilisateurs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1146, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(319, 25, 801, 366);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		remplire();
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("",1,18));
		table.setRowHeight(20);
		
		
		JLabel lblIdentificateur = new JLabel("Nom");
		lblIdentificateur.setBounds(24, 50, 89, 17);
		contentPane.add(lblIdentificateur);
		
		textField = new JTextField();
		textField.setText(" ");
		textField.setBounds(144, 50, 149, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText(" ");
		textField_1.setBounds(144, 81, 149, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblPrenom = new JLabel("Prénom");
		lblPrenom.setBounds(24, 81, 110, 17);
		contentPane.add(lblPrenom);
		
		lblDateDeNaissance = new JLabel("Date de Naissance :");
		lblDateDeNaissance.setBounds(24, 186, 118, 20);
		contentPane.add(lblDateDeNaissance);
		
		lblSalaire = new JLabel("ADRESSE :");
		lblSalaire.setBounds(24, 158, 110, 17);
		contentPane.add(lblSalaire);
		
		textField_3 = new JTextField();
		textField_3.setText(" ");
		textField_3.setBounds(144, 157, 149, 17);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("rahou dkhel !!!");
				users.ajouter(textField.getText(), textField_1.getText(), textField_2.getText(), new java.sql.Date(dateChooser.getDate().getTime()), textField_3.getText(), chckbxDirecteur.isSelected());
			    JOptionPane.showMessageDialog(null, "l'ajoute a été effectuer !!!");
			    //remplire();
			    dispose();
				new Utilisateur(directeur);
			    }
		});
		btnAjouter.setBounds(90, 293, 108, 23);
		contentPane.add(btnAjouter);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				users.supprimer(Integer.parseInt(label.getText()));
				JOptionPane.showMessageDialog(null, "la supprition a été effectuer !!!");
			    //remplire();
				dispose();
				new Utilisateur(directeur);
			}
		});
		btnSupprimer.setBounds(90, 327, 108, 23);
		contentPane.add(btnSupprimer);
		
		btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				users.modifier(Integer.parseInt(label.getText()),textField.getText(), textField_1.getText(), textField_2.getText(), new java.sql.Date(dateChooser.getDate().getTime()), textField_3.getText(), chckbxDirecteur.isSelected());
				JOptionPane.showMessageDialog(null, "la modification a été effectuer !!!");
			    //remplire();
				dispose();
				new Utilisateur(directeur);
			}
		});
		btnModifier.setBounds(90, 361, 108, 23);
		contentPane.add(btnModifier);
		
		btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				new LocDZ(directeur);
				
			}
		});
		btnRetour.setBounds(917, 402, 89, 23);
		contentPane.add(btnRetour);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(144, 186, 149, 20);
		contentPane.add(dateChooser);
		
		textField_2 = new JTextField();
		textField_2.setText(" ");
		textField_2.setColumns(10);
		textField_2.setBounds(144, 112, 149, 17);
		contentPane.add(textField_2);
		
		JLabel lblMotDePasse = new JLabel("MOT DE PASSE :");
		lblMotDePasse.setBounds(24, 113, 110, 17);
		contentPane.add(lblMotDePasse);
		
		chckbxDirecteur = new JCheckBox("Directeur");
		chckbxDirecteur.setBounds(144, 231, 97, 23);
		contentPane.add(chckbxDirecteur);
		
		label = new JLabel("");
		label.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 14));
		label.setBounds(73, 11, 47, 28);
		contentPane.add(label);
		setResizable(false);
		setVisible(true);
	}
	private void remplire()//rahi temchi
	{
		model = new DefaultTableModel();
		String[] columns = {"Id","Nom","Prénom","MOT DE PASSE","Date de Naissance","Adresse","Directeur"};
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		
		arr=users.get_all();
		for (int i = 0; i < arr.size(); i++) {
			String[] row= {arr.get(i).getID()+"",arr.get(i).getNom(),arr.get(i).getPrenom(),arr.get(i).getMotp(),arr.get(i).getDateN().toString(),arr.get(i).getAdress(),arr.get(i).isDirecteur()+""};
			model.addRow(row);
		}
		//vider les champs
		/*label.setText("");
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		chckbxDirecteur.setSelected(false);*/
		// hadi la fonction ta3 ki yselectionner un ligne dans le tableau
		rows_selection();
	}
	private void rows_selection()// hadi la fonction ta3 ki yselectionner un ligne dans le tableau
	{
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				
				label.setText(table.getModel().getValueAt(table.getSelectedRow(), 0)+"");
				textField.setText(table.getModel().getValueAt(table.getSelectedRow(), 1)+"");
				textField_1.setText(table.getModel().getValueAt(table.getSelectedRow(), 2)+"");
				textField_2.setText(table.getModel().getValueAt(table.getSelectedRow(), 3)+"");
				textField_3.setText(table.getModel().getValueAt(table.getSelectedRow(), 5)+"");
				dateChooser.setDate(arr.get(table.getSelectedRow()).getDateN());
				chckbxDirecteur.setSelected((new String(table.getModel().getValueAt(table.getSelectedRow(), 6)+"").equals(new String("true"))?true:false));
				System.out.println("new selection");
			}
		});
	}
}
