package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.user;

public class users extends BD{
	public static void ajouter(String nom,String prenom,String motP,Date dateN,String adress,boolean directeur)//rahi temchi
	{
		
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("insert into user(nom,prenom,mot_pass,dateN,adress,directeur) values(?,?,?,?,?,?)");
				){
			
			pr.setString(1, nom);
			pr.setString(2, prenom);
			pr.setString(3, motP);
			pr.setDate(4, dateN);
			pr.setString(5,adress);
			pr.setBoolean(6, directeur);
			
			pr.execute();
			System.out.println("ok !!!");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public static void supprimer(int id)//rahi temchi
	{
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("delete from user where ID=?");
				){
			pr.setInt(1, id);
			
			pr.execute();
			System.out.println("ok !!!");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public static void modifier(int ID,String nom,String prenom,String motP,Date dateN,String adress,boolean directeur)//rahi temchi
	{
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("update user set nom=?,prenom=?,mot_pass=?,dateN=?,adress=?,directeur=? where ID=?");
				){
			
			pr.setString(1, nom);
			pr.setString(2, prenom);
			pr.setString(3, motP);
			pr.setDate(4, dateN);
			pr.setString(5,adress);
			pr.setBoolean(6, directeur);
			pr.setInt(7, ID);
			
			pr.execute();
			System.out.println("ok !!!");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public static int inscrire(String nom,String motP)//rahi temchi
	{
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("select * from user where nom=? and mot_pass=?");
				){
			
			pr.setString(1, nom);
			pr.setString(2, motP);
			
			ResultSet rs=pr.executeQuery();
			if(rs.next())
			{
				if(rs.getBoolean("directeur"))
				{
					return 2;// acces mode directeur
				}
				else
				{
					return 1;//acces normal
				}
			}
			else
			{
				return 0;//ne peut pas acces
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return 0;
	}
	public static ArrayList<user> get_all()//rahi temchi
	{
		ArrayList<user> arr=new ArrayList<user>();
		
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("select * from user");
				){
			ResultSet rs=pr.executeQuery();
			
			while(rs.next())
			{
				arr.add(new user(rs.getInt("ID"), rs.getString("nom"),rs.getString("prenom"), rs.getString("mot_pass"), rs.getString("adress"), rs.getDate("dateN"), rs.getBoolean("directeur")));
			}
			return arr;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return null;
	}
	public static int nbr_user()
	{
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("select count(ID) from user");
				){
			ResultSet rs=pr.executeQuery();
			
			if(rs.next())
			{
				return rs.getInt(1);
			}
			return 0;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return 0;
	}
}
