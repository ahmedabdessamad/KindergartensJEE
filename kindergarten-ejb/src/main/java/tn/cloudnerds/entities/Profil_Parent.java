package tn.cloudnerds.entities;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Profil_Parent {
	
	@JsonProperty("id")
	public int id ;	
	
  
	
	
	@JsonProperty("calendar")
    public String calendar ;
	@JsonProperty("email")
    public String email ;
	@JsonProperty("username")
    public String username ;
	@JsonProperty("password")
    public String password ;
	@JsonProperty("confirmPassword")
	 public String confirmPassword ;
	
	@JsonProperty("name")
    public String name ;
	
	@JsonProperty("phone")
    public String phone ;
	@JsonProperty("image")
    public String image ;
	@JsonProperty("adresse")
    public Adresse adresse ;

	

	
	
	//@JsonIgnore
	@JsonProperty("enfants")
    public ArrayList<Enfant> enfants ;
	
	@JsonProperty("reclamations")
    public ArrayList<Reclamation> reclamations ;
	
	@JsonProperty("reunionPrives")
	public ArrayList<ReunionPrive> reunionPrives ;

	@JsonProperty("reunions")
    public ArrayList<Enfant> reunions ;
	
	@JsonProperty("productComments")
    public ArrayList<Enfant> productComments ;
	
	@JsonProperty("rdv")
    public ArrayList<Enfant> rdv ;
	
	public ArrayList<Enfant> getEnfants() {
		return enfants;
	}

	public void setEnfants(ArrayList<Enfant> enfants) {
		this.enfants = enfants;
	}
	
	public ArrayList<ReunionPrive> getReunionPrive() {
		return reunionPrives;
	}
	
	public void setReunionPrive(ArrayList<ReunionPrive> reunionPrives) {
		this.reunionPrives = reunionPrives;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getCalendar() {
		return calendar;
	}

	public void setCalendar(String calendar) {
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

	public ArrayList<Reclamation> getReclamations() {
		return reclamations;
	}

	public void setReclamations(ArrayList<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	public ArrayList<ReunionPrive> getReunionPrives() {
		return reunionPrives;
	}

	public void setReunionPrives(ArrayList<ReunionPrive> reunionPrives) {
		this.reunionPrives = reunionPrives;
	}

	public ArrayList<Enfant> getReunions() {
		return reunions;
	}

	public void setReunions(ArrayList<Enfant> reunions) {
		this.reunions = reunions;
	}

	public ArrayList<Enfant> getProductComments() {
		return productComments;
	}

	public void setProductComments(ArrayList<Enfant> productComments) {
		this.productComments = productComments;
	}

	public ArrayList<Enfant> getRdv() {
		return rdv;
	}

	public void setRdv(ArrayList<Enfant> rdv) {
		this.rdv = rdv;
	}
	
	
}
