 package usthb.projet.gl;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.users;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class User extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public User() {
		setTitle("LocDZ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLocdz = new JLabel("LocDz");
		lblLocdz.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 24));
		lblLocdz.setBounds(164, 49, 77, 46);
		contentPane.add(lblLocdz);
		
		JLabel lblNewLabel = new JLabel("Nom d'utilisateur");
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 138, 138, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(175, 135, 224, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lblMotDePasse.setBounds(10, 180, 112, 14);
		contentPane.add(lblMotDePasse);
		
		JLabel label = new JLabel("");
		label.setEnabled(false);
		label.setBounds(47, 205, 330, 14);
		contentPane.add(label);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a=users.inscrire(textField.getText(),new String(passwordField.getPassword()));
			if(a>0)
			{
				System.out.println("rahou dkhel !!!");
				dispose();
				new LocDZ(a==2);
			}
			else
			{
				System.out.println("nom :"+textField.getText()+"\n passwored  :"+new String(passwordField.getPassword()));
				label.setText("erreur dans le mot de passe ou le nom d'utilisateur !!!");
			}
		}
	});
		btnConnexion.setBounds(175, 227, 112, 23);
		contentPane.add(btnConnexion);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(175, 177, 224, 20);
		contentPane.add(passwordField);
		
		setResizable(false);
		setVisible(true);
	}
}
