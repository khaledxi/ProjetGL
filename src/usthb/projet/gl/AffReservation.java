package usthb.projet.gl;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import com.toedter.calendar.JDateChooser;

import database.reservation;
import database.typeV;
import model.res;

import javax.swing.JCheckBox;

public class AffReservation extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_1;
	private ArrayList<res> arr;
	private DefaultTableModel model;
	private JDateChooser dateChooser;
	private JButton btnSupprimer,btnModifier;

	public AffReservation(boolean directeur) {
		setTitle("Consuler les reservations");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 0, 640, 330);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		model = new DefaultTableModel();
		Object[] columns = {"NumReserv","N°Permis","MatVeh","Categorie","DateReserv"};
		
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("",1,18));
		table.setRowHeight(20);
		
		btnModifier = new JButton("Début Réception");
		btnModifier.setEnabled(false);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reservation.set_km_D(Integer.parseInt((String) model.getValueAt(table.getSelectedRow(), 0)), Integer.parseInt(textField_1.getText()),new Date(dateChooser.getDate().getTime()));
				JOptionPane.showMessageDialog(null, "Début Réception");
				dispose();
				new AffReservation(directeur);
			}
		});
		btnModifier.setBounds(724, 240, 159, 23);
		contentPane.add(btnModifier);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setEnabled(false);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reservation.supprimer(Integer.parseInt((String) model.getValueAt(table.getSelectedRow(), 0)));
				JOptionPane.showMessageDialog(null, "supprimé !!!");
				dispose();
				new AffReservation(directeur);
			}
		});
		btnSupprimer.setBounds(723, 270, 160, 23);
		contentPane.add(btnSupprimer);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Reservation(directeur);
			}
		});
		btnRetour.setBounds(727, 341, 103, 23);
		contentPane.add(btnRetour);
		
		JButton btnNewButton = new JButton("Afficher");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Contrat(directeur);
			}
		});
		btnNewButton.setBounds(346, 341, 103, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblAfficherLesReservations = new JLabel("Afficher les contrats des reservations satisfaites");
		lblAfficherLesReservations.setBounds(44, 345, 292, 14);
		contentPane.add(lblAfficherLesReservations);
		
		JLabel lblKilometerDeVhicule = new JLabel("kilometer de v\u00E9hicule au d\u00E9but :");
		lblKilometerDeVhicule.setBounds(684, 162, 186, 20);
		contentPane.add(lblKilometerDeVhicule);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setText("000");
		textField_1.setColumns(10);
		textField_1.setBounds(745, 193, 106, 20);
		contentPane.add(textField_1);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(694, 113, 189, 20);
		contentPane.add(dateChooser);
		dateChooser.setEnabled(false);
		
		JLabel lblDateRelDe = new JLabel("date R\u00E9el de d\u00E9but de reservation :");
		lblDateRelDe.setBounds(684, 72, 199, 32);
		contentPane.add(lblDateRelDe);
		
		remplire_tab();
		
		setVisible(true);
		setResizable(false);
	}
	
	private void remplire_tab()
	{
		arr=reservation.get_C_N_D();
		for (int i = 0; i < arr.size(); i++) {
			String[] row= {arr.get(i).getNumC()+"",arr.get(i).getNumP(),arr.get(i).getMatV(),typeV.get_type(arr.get(i).getMatV()),arr.get(i).getDateD()+""};
			model.addRow(row);
		}
		ListSelectionModel list= table.getSelectionModel();
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				dateChooser.setEnabled(true);
				textField_1.setEnabled(true);
				btnModifier.setEnabled(true);
				btnSupprimer.setEnabled(true);
				
				//remplire les champs
				int n=table.getSelectedRow();
				textField_1.setText(""+arr.get(n).getKiloF());
				dateChooser.setDate(arr.get(n).getDateF());
			}
		});
	}
}
