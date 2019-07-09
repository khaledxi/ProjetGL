package usthb.projet.gl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import database.typeV;
import database.vehicule;
import javafx.scene.control.SelectionMode;
import model.V_type;
import model.vhc;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

public class Vehicule extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_2;
	private JComboBox<String> comboBox_1;
	private JComboBox<String> comboBox;
	private DefaultTableModel model; 
	private JLabel label_1;
	private ArrayList<vhc> arr;

	
	public Vehicule(boolean directeur) {
		setTitle("Gestion des v\u00E9hicules");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 493);
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
		btnRetour.setBounds(747, 405, 89, 23);
		contentPane.add(btnRetour);
		
		JLabel lblMarque = new JLabel("Marque");
		lblMarque.setBounds(10, 59, 60, 14);
		contentPane.add(lblMarque);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setBounds(10, 104, 46, 14);
		contentPane.add(lblModel);
		
		textField = new JTextField();
		textField.setBounds(103, 101, 106, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCategorie = new JLabel("Categorie");
		lblCategorie.setBounds(10, 145, 60, 22);
		contentPane.add(lblCategorie);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(103, 144, 106, 23);
		contentPane.add(comboBox_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(229, 11, 612, 332);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		vider_tab();
	
		table.setForeground(Color.red);
		table.setFont(new Font("",1,22));
		table.setRowHeight(20);
		remplire_champs();
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vehicule.ajouter(textField_1.getText(), textField_3.getText(), textField.getText(),(String) comboBox_1.getSelectedItem());
				JOptionPane.showMessageDialog(null,"l'ajoute a été effectuer !!!");
				dispose();
				new Vehicule(directeur);
			}
		});
		btnAjouter.setBounds(10, 190, 106, 23);
		contentPane.add(btnAjouter);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vehicule.supprimer(label_1.getText());
				JOptionPane.showMessageDialog(null,"la supprition a été effectuer !!!");
				dispose();
				new Vehicule(directeur);
			}
		});
		btnSupprimer.setBounds(10, 224, 106, 23);
		contentPane.add(btnSupprimer);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				vehicule.modifier(textField_3.getText(), textField.getText(),(String) comboBox_1.getSelectedItem(),textField_1.getText());
				JOptionPane.showMessageDialog(null,"la modification a été effectuer !!!");
				dispose();
				new Vehicule(directeur);
				
				
				
			}
		});
		btnModifier.setBounds(10, 258, 106, 23);
		contentPane.add(btnModifier);
		
		textField_1 = new JTextField();
		textField_1.setBounds(103, 11, 106, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMatricule = new JLabel("Matricule");
		lblMatricule.setBounds(11, 14, 59, 14);
		contentPane.add(lblMatricule);
		
		JButton btnSequentiellemnt = new JButton("Sequentiellemnt");
		btnSequentiellemnt.setBounds(324, 354, 164, 23);
		contentPane.add(btnSequentiellemnt);
		btnSequentiellemnt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				remplire_tab();
			}
		});
		
		JButton btnParCategorie = new JButton("Par categorie");
		btnParCategorie.setBounds(498, 354, 133, 23);
		contentPane.add(btnParCategorie);
		btnParCategorie.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				remplire_tab((String)comboBox.getSelectedItem());
			}
		});
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setBounds(10, 334, 106, 23);
		contentPane.add(btnRechercher);
		btnRechercher.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				remplire_tab(Integer.parseInt(textField_2.getText()));
			}
		});
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(103, 56, 106, 20);
		contentPane.add(textField_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(112, 368, 106, 20);
		contentPane.add(textField_2);
		
		JLabel label = new JLabel("Matricule");
		label.setBounds(20, 371, 59, 14);
		contentPane.add(label);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(641, 354, 118, 23);
		contentPane.add(comboBox);
		
		JButton btnVider = new JButton("vider");
		btnVider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vider_tab();
			}
		});
		btnVider.setBounds(457, 388, 89, 23);
		contentPane.add(btnVider);
		
		label_1 = new JLabel("");
		label_1.setBounds(127, 224, 66, 23);
		contentPane.add(label_1);
		
		arr=vehicule.get_all();
		
		remplire_combo();
		remplire_tab();
     
		setResizable(false);
		setVisible(true);
	
	}
	private void remplire_champs()
	{
		ListSelectionModel list= table.getSelectionModel();
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				textField_1.setText((String)model.getValueAt(table.getSelectedRow(), 0));//mat
				label_1.setText((String)model.getValueAt(table.getSelectedRow(), 0));//mat
				textField_3.setText((String)model.getValueAt(table.getSelectedRow(), 1));//marque
				textField.setText((String)model.getValueAt(table.getSelectedRow(), 2));//model
				comboBox_1.setSelectedItem((String)model.getValueAt(table.getSelectedRow(), 3));//catégorie
			}
		});
	}
	private void remplire_combo()
	{
		ArrayList<V_type> arr=typeV.get_all();
		for (int i = 0; i < arr.size(); i++) {
			comboBox.addItem(arr.get(i).getNom());
			comboBox_1.addItem(arr.get(i).getNom());
		}
	}
	private void remplire_tab()
	{
		vider_tab();
		System.out.println("rahou l7a9 l la boocle");
		for(int i=0;i<arr.size();i++)
		{
			String[] row= {arr.get(i).getMat(),arr.get(i).getMarque(),arr.get(i).getModel(),arr.get(i).getType()};
			model.addRow(row);
			System.out.println("rahou l7a9 l la boocle "+i);
		}
	}
	private void remplire_tab(int mat)
	{
		vider_tab();
		for(int i=0;i<arr.size();i++)
		{
			if(arr.get(i).getMat().equals(mat+""))
			{
				String[] row= {arr.get(i).getMat(),arr.get(i).getMarque(),arr.get(i).getModel(),arr.get(i).getType()};
				model.addRow(row);
			}
		}
	}
	private void remplire_tab(String categorie)
	{
		vider_tab();
		for(int i=0;i<arr.size();i++)
		{
			if(arr.get(i).getType().equals(categorie))
			{
				String[] row= {arr.get(i).getMat(),arr.get(i).getMarque(),arr.get(i).getModel(),arr.get(i).getType()};
				model.addRow(row);
			}
		}
	}
	private void vider_tab()
	{
		String[] columns ={"Matricule","Marque","Model","Categorie"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		/*
		 * model.getDataVector().removeAllElements();
		 * model.getDataVector().clear();
		 */
	}
}

