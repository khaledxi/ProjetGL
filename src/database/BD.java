package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public abstract class BD {
	public static Connection connect()//rahi temchi
	{
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			return DriverManager.getConnection("jdbc:ucanaccess://GLprojet.accdb");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return null;
	}
}
