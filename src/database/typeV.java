package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.V_type;

public class typeV extends BD{
	public static void ajouter(String nom,int prixK,int prixJ)
	{
		
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("insert into typeV(nom,prixK,prixJ) values(?,?,?)");
				){
			pr.setString(1, nom);
			pr.setInt(2, prixK);
			pr.setInt(3, prixJ);
			
			pr.execute();
			System.out.println("ok !!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public static int calcuer(String typeV,int kilo,Date dateD,Date dateF)
	{
		
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("select prixK,prixJ from typeV where nom=?");
				){
			
			pr.setString(1, typeV);
			
			ResultSet rs=pr.executeQuery();
			if(rs.next())
			{
				int n=(dayBetween(dateD, dateF)*rs.getInt("prixJ")+(kilo*rs.getInt("prixK")));
				return n>0?n:-n;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "catégorie pas trouvé !!!");
				return 0;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return 0;
	}
	private static int dayBetween(Date D,Date F)
	{
		return (int)(F.getTime()-D.getTime())/(1000*60*60*24);
	}
	public static void supprimer(String nom)
	{
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("delete from typeV where nom=?");
				){
			pr.setString(1, nom);
			
			pr.execute();
			System.out.println("ok !!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public static ArrayList<V_type> get_all()
	{
		ArrayList<V_type> arr=new ArrayList<V_type>();
		
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("select * from typeV");
				){
			ResultSet rs=pr.executeQuery();
			while(rs.next())
			{
				arr.add(new V_type(rs.getString("nom"), rs.getInt("prixK"), rs.getInt("prixJ")));
			}
			System.out.println("ok !!!");
			return arr;
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		return null;
	}
	public static String get_type(String matV)
	{
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("select type from vehicule where mat=?");
				){
			pr.setString(1,matV);
			ResultSet rs=pr.executeQuery();
			
			if(rs.next())
				return rs.getString("type");
			else
			{
				System.out.println("problem");
				return "";
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return "";
	}
}
