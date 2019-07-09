package usthb.projet.gl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import database.reservation;
import model.dem;
import model.res;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Facture extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private int mode;
	private DefaultTableModel model;

	
	public Facture(int mode,boolean directeur) {
		this.mode=mode;
		setTitle("Gestion des clients");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				if(mode==0)
					new Contrat(directeur);
				if(mode==1)
					new Reservation(directeur);
			}
		});
		btnRetour.setBounds(687, 364, 104, 23);
		contentPane.add(btnRetour);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 666, 387);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("",1,18));
		table.setRowHeight(20);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				supprimer(Integer.parseInt((String) model.getValueAt(table.getSelectedRow(), 0)));
				JOptionPane.showMessageDialog(null, "supprimé !!!");
				dispose();
				new Facture(mode, directeur);
			}
		});
		btnSupprimer.setBounds(686, 317, 105, 23);
		contentPane.add(btnSupprimer);
		
		
		remplire_tab();
		setVisible(true);
		setResizable(false);
	}
	private void remplire_tab()
	{
		model = new DefaultTableModel();
		if(mode==0)// des factuers
		{
			Object[] columns = {"NumF","NPermis","Tarif","dateD","dateF"};
			model.setColumnIdentifiers(columns);
			ArrayList<res> arr=reservation.get_f();
			for (int i = 0; i < arr.size(); i++) {
				String[] row= {arr.get(i).getNumC()+"",arr.get(i).getNumP(),arr.get(i).getPrix()+"",arr.get(i).getDateD()+"",arr.get(i).getDateF()+""};
				model.addRow(row);
			}
		}
		if(mode==1)//demande
		{
			Object[] columns = {"NumD","NPermis","dateD","dateF","typeV"};
			model.setColumnIdentifiers(columns);
			ArrayList<dem> arr=reservation.get_dem();
			for (int i = 0; i < arr.size(); i++) {
				String[] row= {arr.get(i).getID()+"",arr.get(i).getNumC(),arr.get(i).getDateD()+"",arr.get(i).getDateF()+"",arr.get(i).getTypeV()};
				model.addRow(row);
			}
			
		}
		table.setModel(model);
	}
	private void supprimer(int num)
	{
		if(mode==0)//factuer
		{
			reservation.supprimer(num);
		}
		if(mode==1)//demande
		{
			reservation.supprimer_D(num);
		}
	}

}
