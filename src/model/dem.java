package model;

import java.sql.Date;

public class dem {
	private int ID;
	private Date dateD,dateF;
	private String numC,typeV;
	public dem(int iD, Date dateD, Date dateF, String numC, String typeV) {
		super();
		ID = iD;
		this.dateD = dateD;
		this.dateF = dateF;
		this.numC = numC;
		this.typeV = typeV;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Date getDateD() {
		return dateD;
	}
	public void setDateD(Date dateD) {
		this.dateD = dateD;
	}
	public Date getDateF() {
		return dateF;
	}
	public void setDateF(Date dateF) {
		this.dateF = dateF;
	}
	public String getNumC() {
		return numC;
	}
	public void setNumC(String numC) {
		this.numC = numC;
	}
	public String getTypeV() {
		return typeV;
	}
	public void setTypeV(String typeV) {
		this.typeV = typeV;
	}
	
	
	
}
