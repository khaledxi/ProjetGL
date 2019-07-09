package usthb.projet.gl;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LocDZ extends JFrame {

	private JPanel contentPane;

	public LocDZ(boolean directeur) {
		setTitle("Gestion de location des v\u00E9hicules");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenuDansLa = new JLabel("Bienvenu dans la gestion de location des véhicules");
		lblBienvenuDansLa.setFont(new Font("Sylfaen", Font.BOLD, 17));
		lblBienvenuDansLa.setBounds(96, 29, 439, 34);
		contentPane.add(lblBienvenuDansLa);
		
		JButton btnGestionDesVhicules = new JButton("Explorer le catalogue des véhicules");
		btnGestionDesVhicules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				new Vehicule(directeur);
			}
		});
		btnGestionDesVhicules.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGestionDesVhicules.setBounds(196, 122, 286, 23);
		contentPane.add(btnGestionDesVhicules);
		
		JButton btnGestionDeReservations = new JButton("Traiter les réservations");
		btnGestionDeReservations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				new Reservation(directeur);
			}
		});
		btnGestionDeReservations.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGestionDeReservations.setBounds(196, 156, 286, 23);
		contentPane.add(btnGestionDeReservations);
		
		JButton btnGestionDesUtilisateurs = new JButton("Gestion des utilisateurs");
		if(!directeur)
		{
			System.out.println(directeur);
			btnGestionDesUtilisateurs.setVisible(false);
		}
			
		btnGestionDesUtilisateurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				new Utilisateur(directeur);
				
			}
		});
		btnGestionDesUtilisateurs.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGestionDesUtilisateurs.setBounds(196, 224, 286, 23);
		contentPane.add(btnGestionDesUtilisateurs);
		
		JButton btnGestion_1 = new JButton("Gestion des statistiques des réservations");
		btnGestion_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Statistique(directeur);
			}
		});
		btnGestion_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGestion_1.setBounds(196, 190, 286, 23);
		contentPane.add(btnGestion_1);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQuitter.setBounds(513, 259, 89, 23);
		contentPane.add(btnQuitter);
		
		setResizable(false);
		setVisible(true);
	}
}
