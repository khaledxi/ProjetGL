package model;

public class vhc {
	private String mat,marque,model,type;

	public vhc(String mat, String marque, String model, String type) {
		super();
		this.mat = mat;
		this.marque = marque;
		this.model = model;
		this.type = type;
	}
	//set et get
	public String getMat() {
		return mat;
	}

	public void setMat(String mat) {
		this.mat = mat;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
