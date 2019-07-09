package model;

import java.sql.Date;

public class res {
	private int numC,kiloD,kiloF,prix;
	private String numP,matV;
	private Date dateD,dateF;
	private boolean paiment;
	//constructeur
	public res(int numC, int kiloD, String numP, String matV, Date dateD, Date dateF) {
		super();
		this.numC = numC;
		this.kiloD = kiloD;
		this.numP = numP;
		this.matV = matV;
		this.dateD = dateD;
		this.dateF = dateF;
	}
	
	public res(int numC, int kiloD, int kiloF, int prix, String numP, String matV, Date dateD, Date dateF,boolean paiment) {
		super();
		this.numC = numC;
		this.kiloD = kiloD;
		this.kiloF = kiloF;
		this.prix = prix;
		this.numP = numP;
		this.matV = matV;
		this.dateD = dateD;
		this.dateF = dateF;
		this.paiment = paiment;
	}

	// set and get
	public int getNumC() {
		return numC;
	}
	public void setNumC(int numC) {
		this.numC = numC;
	}
	public int getKiloD() {
		return kiloD;
	}
	public void setKiloD(int kiloD) {
		this.kiloD = kiloD;
	}
	public int getKiloF() {
		return kiloF;
	}
	public void setKiloF(int kiloF) {
		this.kiloF = kiloF;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getNumP() {
		return numP;
	}
	public void setNumP(String numP) {
		this.numP = numP;
	}
	public String getMatV() {
		return matV;
	}
	public void setMatV(String matV) {
		this.matV = matV;
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
	public boolean isPaiment() {
		return paiment;
	}
	public void setPaiment(boolean paiment) {
		this.paiment = paiment;
	}
	
	
}