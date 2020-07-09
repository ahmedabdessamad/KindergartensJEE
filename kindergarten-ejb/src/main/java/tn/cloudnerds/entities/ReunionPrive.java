package tn.cloudnerds.entities;

import java.util.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReunionPrive {
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	public int id ;
	
	
	@JsonProperty("ParentFk")
	int ParentFk;
	
	@JsonProperty("DirecteurFk")
	int DirecteurFk;
	
	@JsonProperty("Directeur")
	Profil_Directeur Directeur ;
	
	@JsonProperty("Parent")
    Profil_Parent Parent ;	
    
	@JsonProperty("DateRdvP")
	public	String DateRdvP;
	
	@JsonProperty("LieuRdvP")
	public	String LieuRdvP;
	
	@JsonProperty("MotifRdvP")
	public	String MotifRdvP;
	

	@JsonProperty("Imporatances")
	public String Imporatances; 
	
	
	@JsonProperty("Categories")
	public String Categories;

	

	public ReunionPrive() {
		super();
	}


	public int getParentFk() {
		return ParentFk;
	}



	public void setParentFk(int parentFk) {
		ParentFk = parentFk;
	}


	public int getDirecteurFk() {
		return DirecteurFk;
	}



	public void setDirecteurFk(int directeurFk) {
		DirecteurFk = directeurFk;
	}




	public Profil_Directeur getDirecteur() {
		return Directeur;
	}





	public void setDirecteur(Profil_Directeur directeur) {
		Directeur = directeur;
	}




	public Profil_Parent getParent() {
		return Parent;
	}



	public void setParent(Profil_Parent parent) {
		Parent = parent;
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	
	

	public String getLieuRdvP() {
		return LieuRdvP;
	}


	public void setLieuRdvP(String lieuRdvP) {
		LieuRdvP = lieuRdvP;
	}


	public String getMotifRdvP() {
		return MotifRdvP;
	}


	public void setMotifRdvP(String motifRdvP) {
		MotifRdvP = motifRdvP;
	}


	

	
	public String getImporatances() {
		return Imporatances;
	}


	public void setImporatances(String imporatances) {
		Imporatances = imporatances;
	}


	public String getCategories() {
		return Categories;
	}


	public void setCategories(String categories) {
		Categories = categories;
	}


	public String getDateRdvP() {
		return DateRdvP;
	}


	public void setDateRdvP(String dateRdvP) {
		DateRdvP = dateRdvP;
	}


	@Override
	public String toString() {
		return "ReunionPrive [id=" + id + ", ParentFk=" + ParentFk + ", DirecteurFk=" + DirecteurFk + ", Directeur="
				+ Directeur + ", Parent=" + Parent + ", DateRdvP=" + DateRdvP + ", LieuRdvP=" + LieuRdvP
				+ ", MotifRdvP=" + MotifRdvP + ", Imporatances=" + Imporatances + ", Categories=" + Categories + "]";
	}


	


	




	



	//public ReunionPrive(int parentFk, int directeurFk, Date dateRdvP, String lieuRdvP, String motifRdvP,
	//		Imporatance imporatances, Categorie categories) {
		
	//	ParentFk = parentFk;
	//	DirecteurFk = directeurFk;
	//	DateRdvP = dateRdvP;
	//	LieuRdvP = lieuRdvP;
	//	MotifRdvP = motifRdvP;
	//	Imporatances = imporatances;
	//	Categories = categories;
//	}

	
	

	




	


	
	
	
	
	
	
}
