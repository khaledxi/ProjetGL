package usthb.projet.gl;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import com.toedter.calendar.JDayChooser;

import database.reservation;
import database.typeV;
import database.vehicule;
import model.V_type;
import model.client_M;
import model.vhc;

import com.toedter.calendar.JDateChooser;

public class Reservation extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	private DefaultTableModel model;
	private JDateChooser dateChooser,dateChooser_1,dateChooser_2;
	private JButton btnAjouterClient,btnAfficherLesClients,btnRechercheVhiculesDe;
	private JComboBox<String> comboBox_2;
	private ArrayList<V_type> catg;
	private client_M client;
	
	public Reservation(boolean directeur) {
		this.client=null;
		initaliser(directeur);
	}
	public Reservation(client_M client,boolean directeur) {
		this.client=client;
		initaliser(directeur);
		remplire_champs();
		non_ajoute();
	}
	public void initaliser(boolean directeur)
	{
		setTitle("Gestion des reservations");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRemplirLaDemande = new JLabel("Remplir la demande du client");
		lblRemplirLaDemande.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRemplirLaDemande.setBounds(40, 29, 169, 14);
		contentPane.add(lblRemplirLaDemande);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(40, 84, 46, 14);
		contentPane.add(lblNom);
		
		textField = new JTextField();
		textField.setBounds(186, 81, 167, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prénom");
		lblPrenom.setBounds(40, 134, 46, 14);
		contentPane.add(lblPrenom);
		
		textField_1 = new JTextField();
		textField_1.setBounds(186, 131, 167, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDate = new JLabel("Date de Naissance");
		lblDate.setBounds(40, 186, 114, 14);
		contentPane.add(lblDate);
		
		JLabel lblLieuDeNaissance = new JLabel("Lieu de naissance");
		lblLieuDeNaissance.setBounds(40, 234, 114, 14);
		contentPane.add(lblLieuDeNaissance);
		
		textField_3 = new JTextField();
		textField_3.setBounds(186, 231, 167, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNPermis = new JLabel("N°Permis");
		lblNPermis.setBounds(40, 280, 83, 14);
		contentPane.add(lblNPermis);
		
		textField_4 = new JTextField();
		textField_4.setBounds(186, 277, 167, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label = new JLabel("Adresse");
		label.setBounds(40, 324, 61, 14);
		contentPane.add(label);
		
		textField_5 = new JTextField();
		textField_5.setBounds(186, 321, 167, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		btnAjouterClient = new JButton("Ajouter client");
		btnAjouterClient.setBounds(10, 414, 161, 23);
		contentPane.add(btnAjouterClient);
		
		btnAjouterClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				database.client.ajouter(textField.getText(), textField_1.getText(), new Date(dateChooser.getDate().getTime()), textField_3.getText(), textField_4.getText(), textField_5.getText());
				JOptionPane.showMessageDialog(null, "l'ajoute a été effectuer !!!");
				non_ajoute();
				client=new client_M(textField.getText(), textField_1.getText(), textField_3.getText(), textField_4.getText(), textField_5.getText(), new Date(dateChooser.getDate().getTime()));
				/*client.setNom(textField.getText());
				client.setPrenom(textField_1.getText());
				client.setLieuN(textField_3.getText());
				client.setNumP(textField_4.getText());
				client.setAdress(textField_5.getText());
				client.setDateN(new Date(dateChooser.getDate().getTime()));*/
				
			}
		});
		
		JLabel lblV = new JLabel("Véhicule Interéssé");
		lblV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblV.setBounds(405, 30, 134, 14);
		contentPane.add(lblV);
		
		btnAfficherLesClients = new JButton("Consulter les clients");
		btnAfficherLesClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				new Client(directeur);
			}
		});
		btnAfficherLesClients.setBounds(10, 390, 161, 23);
		contentPane.add(btnAfficherLesClients);
		
		JLabel lblCatgorie = new JLabel("Catégorie");
		lblCatgorie.setBounds(405, 84, 65, 14);
		contentPane.add(lblCatgorie);
		
		comboBox_2 = new JComboBox<String>();
		comboBox_2.setBounds(491, 81, 114, 20);
		contentPane.add(comboBox_2);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reservation.ajouter_contra(client.getNumP(),(String)model.getValueAt(table.getSelectedRow(), 0), new Date(dateChooser_1.getDate().getTime()), new Date(dateChooser_2.getDate().getTime()));
				JOptionPane.showMessageDialog(null,"sauvgarde contra !!!");
				dispose();
				new Reservation(directeur);
			}
		});
		btnEnregistrer.setEnabled(false);
		
		btnEnregistrer.setBounds(181, 390, 195, 23);
		contentPane.add(btnEnregistrer);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new LocDZ(directeur);
				
			}
		});
		btnRetour.setBounds(752, 428, 89, 23);
		contentPane.add(btnRetour);
		
		JButton btnAfficherToutesLes = new JButton("Consulter les reservations");
		btnAfficherToutesLes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				new AffReservation(directeur);
			}
		});
		btnAfficherToutesLes.setBounds(181, 414, 195, 23);
		contentPane.add(btnAfficherToutesLes);
		
		btnRechercheVhiculesDe = new JButton("recherche v\u00E9hicules de la cat\u00E9gorie");
		btnRechercheVhiculesDe.setEnabled(false);
		btnRechercheVhiculesDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				remplire_tab();
				if(model.getRowCount()==0)
				{
					int r=JOptionPane.showConfirmDialog(null, "il n'exist pas des véhicule \n ve pouver sauvgarder la demande ??");
					if(r==0)
					{
						reservation.ajouter_demande(client.getNumP(), new Date(dateChooser_1.getDate().getTime()), new Date(dateChooser_2.getDate().getTime()),(String) comboBox_2.getSelectedItem());
						JOptionPane.showMessageDialog(null, "la demande a été effectuer !!!");
						dispose();
						new Reservation(directeur);
					}
				}
			}
		});
		btnRechercheVhiculesDe.setBounds(405, 182, 320, 23);
		contentPane.add(btnRechercheVhiculesDe);
		
		
		table = new JTable();
		JScrollPane sp=new JScrollPane(table);
		sp.setBounds(405, 216, 441, 122);
		contentPane.add(sp);
		
		ListSelectionModel list=table.getSelectionModel();
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				if(! textField.isEnabled())
				{
					btnEnregistrer.setEnabled(true);
				}
			}
		});
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(186, 186, 167, 20);
		contentPane.add(dateChooser);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(635, 112, 205, 20);
		contentPane.add(dateChooser_1);
		
		dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(635, 144, 205, 20);
		contentPane.add(dateChooser_2);
		
		JLabel lblDateDeDbut = new JLabel("date de d\u00E9but de reservation :");
		lblDateDeDbut.setBounds(405, 112, 200, 20);
		contentPane.add(lblDateDeDbut);
		
		JLabel lblDateDeFin = new JLabel("date de fin de reservation :");
		lblDateDeFin.setBounds(405, 144, 200, 20);
		contentPane.add(lblDateDeFin);
		
		model =new DefaultTableModel();
		String[] column= {"mat","model","marque"};
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		JButton btnVoireDemandes = new JButton("voire demandes");
		btnVoireDemandes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Facture(1,directeur);
			}
		});
		btnVoireDemandes.setBounds(386, 390, 169, 23);
		contentPane.add(btnVoireDemandes);
		
		remplire_combo();
		setResizable(false);
		setVisible(true);
	}
	public void remplire_champs()
	{
		textField.setText(client.getNom());
		textField_1.setText(client.getPrenom());
		textField_3.setText(client.getLieuN());
		textField_4.setText(client.getNumP());
		textField_5.setText(client.getAdress());
		dateChooser.setDate(client.getDateN());
		
	}
	public void non_ajoute()
	{
		textField.setEnabled(false);
		textField_1.setEnabled(false);
		textField_3.setEnabled(false);
		textField_4.setEnabled(false);
		textField_5.setEnabled(false);
		dateChooser.setEnabled(false);
		btnAjouterClient.setEnabled(false);
		btnRechercheVhiculesDe.setEnabled(true);
	}
	private void remplire_combo()
	{
		catg=typeV.get_all();
		for (int i = 0; i < catg.size(); i++) {
			comboBox_2.addItem(catg.get(i).getNom());
		}
	}
	private void remplire_tab()
	{
		// vider le tableau
		model.getDataVector().removeAllElements();
		ArrayList<vhc> arr=vehicule.recherche((String)comboBox_2.getSelectedItem(),new Date( dateChooser_1.getDate().getTime()), new Date( dateChooser_2.getDate().getTime()));
		for (int i = 0; i < arr.size(); i++) {
			String[] row= {arr.get(i).getMat()+"",arr.get(i).getModel(),arr.get(i).getMarque()};
			model.addRow(row);
		}
	}
}
