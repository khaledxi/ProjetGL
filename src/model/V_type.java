package model;

public class V_type {
	private String nom;
	private int prixK,prixJ;
	
	// constructeur
	public V_type(String nom, int prixK, int prixJ) {
		super();
		this.nom = nom;
		this.prixK = prixK;
		this.prixJ = prixJ;
	}
	
	//set and get
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getPrixK() {
		return prixK;
	}
	public void setPrixK(int prixK) {
		this.prixK = prixK;
	}
	public int getPrixJ() {
		return prixJ;
	}
	public void setPrixJ(int prixJ) {
		this.prixJ = prixJ;
	}
	
}
