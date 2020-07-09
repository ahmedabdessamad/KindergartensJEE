package tn.cloudnerds.entities;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Profil_Directeur {
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	@JsonProperty("reunionPrives")
	public ArrayList<ReunionPrive> reunionPrives ;
	
	
	@JsonProperty("reunions")
	public ArrayList<Reunion> reunions ;
	
	@JsonProperty("rdvs")
	public ArrayList<RDV> rdvs ;
	
	@JsonProperty("products")
	public ArrayList<Product> products ;
	
	
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

	public ArrayList<ReunionPrive> getReunionPrives() {
		return reunionPrives;
	}

	public void setReunionPrives(ArrayList<ReunionPrive> reunionPrives) {
		this.reunionPrives = reunionPrives;
	}

	public ArrayList<Reunion> getReunions() {
		return reunions;
	}

	public void setReunions(ArrayList<Reunion> reunions) {
		this.reunions = reunions;
	}

	public ArrayList<RDV> getRdvs() {
		return rdvs;
	}

	public void setRdvs(ArrayList<RDV> rdvs) {
		this.rdvs = rdvs;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	
	
	
}
