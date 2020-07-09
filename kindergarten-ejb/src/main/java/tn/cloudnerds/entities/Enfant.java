package tn.cloudnerds.entities;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

//import managedBean.Enumerated;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Enfant {
	

	
//	private static final ObjectMapper objectMapper = 
	//	    new ObjectMapper()
		//        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	
	
	@JsonProperty("id")
    public int id ;

	@JsonProperty("name")
    public String name ;
	
	@JsonProperty("birthDate")
    public Date birthDate; 

	
	@JsonProperty("gender")
	@Enumerated(EnumType.ORDINAL)
	public Gender gender; 
   
//	@JsonIgnore
	@JsonProperty("parentId")

    public int parentId;

	@JsonProperty("image")
    public String image;

	//@JsonProperty("profilJardinId")
//	@JsonIgnore
	@JsonProperty("profilJardinId")
    public int profilJardinId;
	
	
//	@JsonProperty("parent")
	@JsonIgnore
	public Profil_Parent parent;
	
//	@JsonProperty("profilJardin")
	@JsonIgnore
	public Profil_Jardin profilJardin;

	public Profil_Parent getParent() {
		return parent;
	}

	public void setParent(Profil_Parent parent) {
		this.parent = parent;
	} 
	public Profil_Jardin getProfilJardin() {
		return profilJardin;
	}

	public void setProfilJardin(Profil_Jardin profilJardin) {
		this.profilJardin = profilJardin;
	} 
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate =  birthDate;
	}

	public Gender getGender() {
		return gender;
	}
	
	

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getProfilJardinId() {
		return profilJardinId;
	}

	public void setProfilJardinId(int profilJardinId) {
		this.profilJardinId = profilJardinId;
	} 



	@Override
	public String toString() {
		return "Enfant [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", gender=" + gender + ", parentId=" + parentId
				+  ", image=" + image + ", profilJardinId="+ profilJardinId+"]";
	}
	
	
	

	/*
	public Enfant(int id, String name, Date birthDate, Gender gender, int parentId, String image, int profilJardinId) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.gender = gender;
		this.parentId = parentId;
		this.image = image;
		this.profilJardinId = profilJardinId;
	}
	
	*/
	
	
}


