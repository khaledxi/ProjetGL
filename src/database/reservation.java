package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.dem;
import model.res;

public class reservation extends BD{
	public static void ajouter_contra(String numP,String matV,Date date_D,Date date_F)
	{
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("insert into contra(numP,matV,date_D_A,date_R) values(?,?,?,?)");
				){
			pr.setString(1, numP);
			pr.setString(2, matV);
			pr.setDate(3, date_D);
			pr.setDate(4, date_F);
			
			pr.execute();
			System.out.println("ok !!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public static void set_km_D(int contra,int km,Date dateD_R)
	{
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("update contra set kiloD=?,date_D_A=? where numC=?");
				){
			
			pr.setInt(1, km);
			pr.setDate(2, dateD_R);
			pr.setInt(3, contra);
			
			pr.execute();
			System.out.println("ok !!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public static void completer(int numC,Date date_R,int kilo_R,int prix,boolean payer)
	{
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("update contra set date_R=? ,kiloF=?,prix=?,paiement=? where numC=?");
				){
			pr.setDate(1, date_R);
			pr.setInt(2, kilo_R);
			pr.setInt(3, prix);
			pr.setBoolean(4, payer);
			pr.setInt(5, numC);
			
			pr.execute();
			System.out.println("ok !!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public static void payer(int numC)
	{
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("update contra set paiement=? where numC=?");
				){
			
			pr.setBoolean(1, true);
			pr.setInt(2, numC);
			
			pr.execute();
			System.out.println("ok !!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public static void ajouter_demande(String client,Date date_D,Date date_F,String typeV)
	{
		
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("insert into demande(numClient,date_D,date_F,type_V) values(?,?,?,?)");
				){
			pr.setString(1, client);
			pr.setDate(2, date_D);
			pr.setDate(3, date_F);
			pr.setString(4, typeV);
			
			pr.execute();
			System.out.println("ok !!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	public static ArrayList<res> get_C_N_D()//contra non début
	{
		ArrayList<res> arr=new ArrayList<res>();
		
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("select * from contra where kiloD=-1");
				){
			ResultSet rs=pr.executeQuery();
			
				while(rs.next())
				{
					arr.add(new res(rs.getInt("numC"), rs.getInt("kiloD"), rs.getString("numP"), rs.getString("matV"), rs.getDate("date_D_A"), rs.getDate("date_R")));
				}
			
			
			System.out.println(arr.size()+"    ok !!!");
			
			return arr;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return null;
	}
	public static void supprimer(int contra) {
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("delete from contra where numC=?");
				){
			pr.setInt(1, contra);
			
			pr.execute();
			System.out.println("ok !!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public static ArrayList<res> get_C_D()//contra début
	{
		ArrayList<res> arr=new ArrayList<res>();
		
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("select * from contra where (not kiloD=-1) and (not paiement) ");
				){
			ResultSet rs=pr.executeQuery();
			
				while(rs.next())
				{
					arr.add(new res(rs.getInt("numC"), rs.getInt("kiloD"), rs.getString("numP"), rs.getString("matV"), rs.getDate("date_D_A"), rs.getDate("date_R")));
				}
			
			
			System.out.println(arr.size()+"    ok !!!");
			
			return arr;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return null;
	}
	public static ArrayList<res> get_f()//contra début
	{
		ArrayList<res> arr=new ArrayList<res>();
		
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("select * from contra where (not kiloD=-1) and (paiement) ");
				){
			ResultSet rs=pr.executeQuery();
			
				while(rs.next())
				{
					arr.add(new res(rs.getInt("numC"), rs.getInt("kiloD"), rs.getString("numP"), rs.getString("matV"), rs.getDate("date_D_A"), rs.getDate("date_R")));
				}
			
			
			System.out.println(arr.size()+"    ok !!!");
			
			return arr;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return null;
	}
	public static ArrayList<dem> get_dem()
	{
         ArrayList<dem> arr=new ArrayList<dem>();
		
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("select * from demande ");
				){
			ResultSet rs=pr.executeQuery();
			
				while(rs.next())
				{
					arr.add(new dem(rs.getInt("ID"), rs.getDate("date_D"), rs.getDate("date_F"), rs.getString("numClient"), rs.getString("type_V")));
				}
			
			
			System.out.println(arr.size()+"    ok !!!");
			
			return arr;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return null;
	}
	public static void supprimer_D(int numD) {
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("delete from demande where ID=?");
				){
			pr.setInt(1, numD);
			
			pr.execute();
			System.out.println("ok !!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public static int nbr_res(int année)
	{
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("select count(numC) from contra where date_D_A between ? and ?");
				){
			
			pr.setDate(1, new Date(année-1900,0,1));
			pr.setDate(2, new Date(année-1900+1,0,1));
			
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
	public static int nbr_dem(int année)
	{
		try (
				Connection con=connect();
				PreparedStatement pr=con.prepareStatement("select count(ID) from demande where date_D between ? and ?");
				){
			
			pr.setDate(1, new Date(année-1900,0,1));
			pr.setDate(2, new Date(année-1900+1,0,1));
			
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
