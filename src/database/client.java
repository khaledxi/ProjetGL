package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.client_M;

public class client extends BD{
	public static void ajouter(String nom,String prenom,Date dateN,String lieuN,String numP,String adress)//rahi temchi
	{
		
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("insert into client(nom,prenom,dateN,lieuN,numP,adress) values(?,?,?,?,?,?)");
				){
			pr.setString(1, nom);
			pr.setString(2, prenom);
			pr.setDate(3, dateN);
			pr.setString(4, lieuN);
			pr.setString(5, numP);
			pr.setString(6, adress);
			
			pr.execute();
			System.out.println("ok !!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public static void supprimer(String numP)//rahi temchi
	{
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("delete from client where numP=?");
				){
			pr.setString(1, numP);
			pr.execute();
			System.out.println("ok !!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public static void modifier(String nom,String prenom,Date dateN,String lieuN,String numP,String adress)//rahi temchi
	{
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("update client set nom=?, prenom=?, dateN=?,lieuN=?,adress=? where numP=?");
				){
			pr.setString(1, nom);
			pr.setString(2, prenom);
			pr.setDate(3, dateN);
			pr.setString(4, lieuN);
			pr.setString(5, adress);
			pr.setString(6, numP);
			
			pr.execute();
			System.out.println("ok !!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public static ArrayList<client_M> get_all()//rahi temchi
	{
		ArrayList<client_M> arr=new ArrayList<client_M>();
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("select * from client");
				){
			ResultSet rs=pr.executeQuery();
			while(rs.next())
			{
				arr.add(new client_M(rs.getString("nom"), rs.getString("prenom"), rs.getString("lieuN"), rs.getString("numP"), rs.getString("adress"), rs.getDate("dateN")));
			}
			
			System.out.println(arr.size()+"\n ok !!!");
			return arr;
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return null;
	}
	public static int nbr_client()
	{
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("select count(numP) from client");
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
