package tn.cloudnerds.entities;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Profil_Jardin {

	//@JsonIgnore
	@JsonProperty("enfants")
    public ArrayList<Enfant> enfants ;

	
	
	public ArrayList<Enfant> getEnfants() {
		return enfants;
	}

	
	
	
	public void setEnfants(ArrayList<Enfant> enfants) {
		this.enfants = enfants;
	}
	
	@JsonProperty("reclamations")
    public ArrayList<Reclamation> reclamations ;

	public ArrayList<Reclamation> getReclamations() {
		return reclamations;
	}
	public void setReclamations(ArrayList<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}
	
	@JsonProperty("cartePaiements")
    public ArrayList<Carte_Paiement> cartePaiements ;

	public ArrayList<Reclamation> getCartePaiements() {
		return reclamations;
	}
	public void setCartePaiements(ArrayList<Carte_Paiement> cartePaiements) {
		this.cartePaiements = cartePaiements;
	}
	
	
	
	
	
	@JsonIgnore
    public Profil_Directeur directeur;

	public Profil_Directeur getDirecteur() {
		return directeur;
	}

	public void setDirecteur(Profil_Directeur directeur) {
		this.directeur = directeur;
	} 

	
//	@JsonProperty("directeurId")
	@JsonIgnore
    public int directeurId;
	
	
	
	
	
	@JsonProperty("desciption")
public String desciption ;

	@JsonProperty("dateCreation")
      public Date dateCreation ;
	
	@JsonProperty("nbreEmployees")
      public int nbreEmployees ;
	
	@JsonProperty("localisation")
      public String localisation ;
	
	@JsonProperty("prix")
      public Double prix ;
	
	@JsonProperty("repas")
	@Enumerated(EnumType.ORDINAL)
	public Repas repas; 
	
	@JsonProperty("id")
	  public int id ;
	
	@JsonProperty("statut")
      public Statut statut ;
	
	@JsonProperty("calendar")
      public Date calendar; 
	
	@JsonProperty("email")
      public String email ;
	
	@JsonProperty("username")
      public String username ;
	
	@JsonProperty("password")
      public String password ;
	
	@JsonProperty("confirmPassword")
      public String confirmPassword;
	
	@JsonProperty("name")
      public String name; 
	
	@JsonProperty("gender")
	@Enumerated(EnumType.ORDINAL)
	public Gender gender; 

	@JsonProperty("phone")	
	 public String phone;
	
	@JsonProperty("image")
     public String image ;

	@JsonIgnore
	public Adresse adresse;

	public int getDirecteurId() {
		return directeurId;
	}

	public void setDirecteurId(int directeurId) {
		this.directeurId = directeurId;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public int getNbreEmployees() {
		return nbreEmployees;
	}

	public void setNbreEmployees(int nbreEmployees) {
		this.nbreEmployees = nbreEmployees;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Repas getRepas() {
		return repas;
	}

	public void setRepas(Repas repas) {
		this.repas = repas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Date getCalendar() {
		return calendar;
	}

	public void setCalendar(Date calendar) {
		this.calendar = calendar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
