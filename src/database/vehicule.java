package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.vhc;

public class vehicule extends BD{
	public static void ajouter(String mat,String marque,String model,String type)//rahi temchi
	{
		
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("insert into vehicule (mat,marque,model,type) values(?,?,?,?)");
				){
			pr.setString(1, mat);
			pr.setString(2, marque);
			pr.setString(3, model);
			pr.setString(4, type);
			
			pr.execute();
			System.out.println("ok !!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public static void supprimer(String mat)//rahi temchi
	{
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("delete from vehicule where mat=?");
				){
			pr.setString(1, mat);
			
			pr.execute();
			System.out.println("ok !!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public static void modifier(String marque,String model,String type,String mat)
	{
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("update vehicule set marque=? ,model=? ,type=? where mat=?");
				){
			pr.setString(1, marque);
			pr.setString(2, model);
			pr.setString(3, type);
			pr.setString(4, mat);
			
			pr.execute();
			System.out.println("ok !!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public static ArrayList<vhc> get_all()//rahi temchi
	{
		ArrayList<vhc> arr=new ArrayList<vhc>();
		
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("select * from vehicule");
				){
			ResultSet rs=pr.executeQuery();
			while(rs.next())
			{
				arr.add(new vhc(rs.getString("mat"), rs.getString("marque"), rs.getString("model"), rs.getString("type")));
			}
			
			System.out.println("ok !!!");
			return arr;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return null;
	}
	public static ArrayList<vhc> recherche(String catégorie,Date date_D,Date date_F)
	{
		ArrayList<vhc> arr=new ArrayList<vhc>();
		
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("select * from vehicule where (not mat IN(select matV from contra where (? BETWEEN date_D_A and date_R) or (? BETWEEN date_D_A and date_R) or (date_D_A BETWEEN ? and ?)) and (type=?)) ");
				){
			pr.setDate(1, date_D);
			pr.setDate(2, date_F);
			pr.setDate(3, date_D);
			pr.setDate(4, date_F);
			pr.setString(5, catégorie);
			
			ResultSet rs=pr.executeQuery();
			while(rs.next())
			{
				arr.add(new vhc(rs.getString("mat"), rs.getString("marque"), rs.getString("model"), rs.getString("type")));
			}
			
			System.out.println( arr.size()+"\nok !!!");
			return arr;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return null;
	}
	public static int nbr_V()
	{
		
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("select count(mat) from vehicule");
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
