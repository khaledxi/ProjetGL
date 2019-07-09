package usthb.projet.gl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import com.toedter.calendar.JYearChooser;

import database.client;
import database.reservation;
import database.users;
import database.vehicule;

import javax.swing.JLabel;

public class Statistique extends JFrame {

	private JPanel contentPane;

	
	public Statistique(boolean directeur) {
		setTitle("Gestion des statistiques des reservations");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new LocDZ(directeur);
				dispose();
			}
		});
		btnRetour.setBounds(605, 303, 89, 23);
		contentPane.add(btnRetour);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(605, 31, 89, 23);
		contentPane.add(yearChooser);
		
		JLabel lblEntrerLanne = new JLabel("entrer l'ann\u00E9e :");
		lblEntrerLanne.setBounds(498, 31, 97, 23);
		contentPane.add(lblEntrerLanne);
		
		JButton btnValider = new JButton("valider");
		
		btnValider.setBounds(605, 269, 89, 23);
		contentPane.add(btnValider);
		
		JLabel lblNumroDesDemande = new JLabel("nombre des demande :");
		lblNumroDesDemande.setBounds(40, 60, 253, 23);
		contentPane.add(lblNumroDesDemande);
		
		JLabel label = new JLabel("");
		label.setBounds(303, 60, 89, 23);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(306, 110, 86, 23);
		contentPane.add(label_1);
		
		JLabel lblNumroDesReservation = new JLabel("nombre des reservation :");
		lblNumroDesReservation.setBounds(40, 110, 253, 23);
		contentPane.add(lblNumroDesReservation);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(306, 165, 86, 23);
		contentPane.add(label_2);
		
		JLabel lblNumroDesClient = new JLabel("nombre des client total:");
		lblNumroDesClient.setBounds(40, 165, 253, 23);
		contentPane.add(lblNumroDesClient);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(306, 218, 86, 23);
		contentPane.add(label_3);
		
		JLabel lblNumroDesVhicule = new JLabel("nombre des v\u00E9hicule total:");
		lblNumroDesVhicule.setBounds(40, 218, 253, 23);
		contentPane.add(lblNumroDesVhicule);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(306, 269, 86, 23);
		contentPane.add(label_4);
		
		JLabel lblNumroDesUtilisateur = new JLabel("nombre des utilisateur total :");
		lblNumroDesUtilisateur.setBounds(40, 269, 253, 23);
		contentPane.add(lblNumroDesUtilisateur);
		
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label.setText(reservation.nbr_dem(yearChooser.getYear())+"");
				label_1.setText(reservation.nbr_res(yearChooser.getYear())+"");
				label_2.setText(client.nbr_client()+"");
				label_3.setText(vehicule.nbr_V()+"");
				label_4.setText(users.nbr_user()+"");
			}
		});
		
		setVisible(true);
		setResizable(false);
	}
}
