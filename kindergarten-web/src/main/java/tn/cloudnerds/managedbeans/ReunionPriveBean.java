package tn.cloudnerds.managedbeans;

import java.io.FileOutputStream;
import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.*;
import java.util.Properties;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import tn.cloudnerds.entities.Categorie;
import tn.cloudnerds.entities.Imporatance;
import tn.cloudnerds.entities.Profil_Directeur;
import tn.cloudnerds.entities.Profil_Parent;
import tn.cloudnerds.entities.ReunionPrive;

import tn.cloudnerds.services.ReunionPriveService;

@ManagedBean(name = "ReunionPriveBean", eager = true)
@SessionScoped
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReunionPriveBean {

	
	String skills="";
	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	
	List<ReunionPrive> mstCode;
	List<ReunionPrive> Listpr;
	int ParentFk;
	int DirecteurFk;
	int search ;
	String searchdate ;
	ReunionPrive ReunionP1;
	ReunionPrive ReunionP2;
	ReunionPrive ReunionP3;
    int id ;
    Profil_Directeur Directeur ;
    Profil_Parent Parent ;	
    String DateRdvP;
	String LieuRdvP;
	String MotifRdvP;
	
	
	String Imporatances; 
	
	
	String Categories;
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	



	public int getSearch() {
		return search;
	}

	public void setSearch(int search) {
		this.search = search;
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

	public String getDateRdvP() {
		return DateRdvP;
	}

	public void setDateRdvP(String dateRdvP) {
		DateRdvP = dateRdvP;
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

	
	public List<ReunionPrive> getMstCode() {
		return mstCode;
	}

	public void setMstCode(List<ReunionPrive> mstCode) {
		this.mstCode = mstCode;
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

	public ReunionPrive getReunionP1() {
		return ReunionP1;
	}

	public void setReunionP1(ReunionPrive reunionP1) {
		ReunionP1 = reunionP1;
	}

	public ReunionPrive getReunionP2() {
		return ReunionP2;
	}

	public void setReunionP2(ReunionPrive reunionP2) {
		ReunionP2 = reunionP2;
	}

	public ReunionPrive getReunionP3() {
		return ReunionP3;
	}

	public void setReunionP3(ReunionPrive reunionP3) {
		ReunionP3 = reunionP3;
	}


	
	
	
	public List<ReunionPrive> getListpr() {
		return Listpr;
	}

	public void setListpr(List<ReunionPrive> listpr) {
		Listpr = listpr;
	}

	

	public String getSearchdate() {
		return searchdate;
	}

	public void setSearchdate(String searchdate) {
		this.searchdate = searchdate;
	}

	public List<String> getNamedirec() {
		return namedirec;
	}

	public void setNamedirec(List<String> namedirec) {
		this.namedirec = namedirec;
	}

	
	public Imporatance[] getImporatanceses() {
        return Imporatance.values();
    }
	
	public Categorie[] getCategorieses() {
        return Categorie.values();
    }
	
	

	@EJB
	ReunionPriveService ReunionPr;
	
	public List<ReunionPrive> GetAll() {
		System.out.println(ReunionPr.GetAllReunionPrive());

		return ReunionPr.GetAllReunionPrive();
	}

	
	public List<Profil_Parent> GetAllPR() {
		System.out.println(ReunionPr.GetAllProfilParents());

		return ReunionPr.GetAllProfilParents();
	}

	
	
	
	
	public String IndexGetAllReunionprive() {
		return "ListReunionprive.xhtml?faces-redirect=true";
	}
	public String RedirectSearchReunionprive() {
		return "ReunionPriveRecherche.xhtml?faces-redirect=true";
	}
	public String RedirectAjoutReunionprive() {
		return "AjoutReunionPrive.xhtml?faces-redirect=true";
	}
	
	
	
	
    public String AjoutReunionPrive(){
    
    	ReunionPrive rp = new ReunionPrive();
   // ajout.setId(id);
 
    rp.setMotifRdvP(MotifRdvP);
    rp.setDateRdvP(DateRdvP);
    rp.setLieuRdvP(LieuRdvP);
  rp.setCategories(Categories);
   rp.setImporatances(Imporatances);
    rp.setParentFk(ParentFk);
    rp.setDirecteurFk(2);
     ReunionPr.AddReunionPrive(rp);
     

   	return "ListReunionprive.xhtml?faces-redirect=true";
    	// TODO Auto-generated catch block
    }
    
    
    public String DeleteReunionprive(int id) {
		System.out.println("delete is here !");
		ReunionPr.DeleteReunionpriveById(id);
		return "ListReunionprive.xhtml?faces-redirect=true"; }
    
    
    
    
    
    public String redirectUpdate(int id )
	{
    	ReunionP1 = ReunionPr.GetReunionPrivetById(id);
        setId(ReunionP1.getId());		   

        setMotifRdvP(ReunionP1.getMotifRdvP());		   

		  
		setDateRdvP(ReunionP1.getDateRdvP());
        setImporatances(ReunionP1.getImporatances());
        setCategories(ReunionP1.getCategories());
        setLieuRdvP(ReunionP1.getLieuRdvP());
        setParentFk(ReunionP1.getParentFk());
        setDirecteurFk(2);
        setDirecteur(ReunionP1.getDirecteur());
        setParent(ReunionP1.getParent());
		return "UpdateReunionprive.xhtml?faces-redirect=true";
	}
    
    
    public String UpdateReunionprive(int Id) {

    	ReunionPrive RP = new ReunionPrive();
    	RP.setId(Id);
    	RP.setMotifRdvP(MotifRdvP);
		    
		 
			// TODO Auto-generated catch block
		    System.out.println("masaréech update");
		    System.out.println("masaréech update");
		    System.out.println("masaréech update");
		 
		   RP.setDateRdvP(DateRdvP);
		   RP.setLieuRdvP(LieuRdvP);
		   RP.setCategories(Categories);
		   RP.setImporatances(Imporatances);
		   RP.setParentFk(ParentFk);
		   RP.setDirecteurFk(2);
		   
		    System.out.println("ahmeeeeeeeeeeeeeeeeeeeed"+RP);
		 
		    ReunionPr.EditReunionpriveById(Id, RP);
		    System.out.println("aaaaaaaaaa");
		    System.out.println("aaaaaaaaaa");
		    System.out.println("aaaaaaaaaa");
		return "ListReunionprive.xhtml?faces-redirect=true";
	}
    
    
    
	public String Get() {	
   		
   		mstCode = GetAll();
   		System.out.println("-----------------------------------------------");
   		System.out.println(search);
   		Listpr = new ArrayList<ReunionPrive>();
   		for (ReunionPrive pr: mstCode) {
   	
		if ((pr.getParentFk() == search)){
			ReunionPrive pr1 = pr;
			    System.out.println("afficheeeee wa7da" + pr1);
			    Listpr.add(pr1); 
		}
   		
   		}	
   		return "ResultatDeRecherche.xhtml?faces-redirect=true";
   	
    
    
   	}


	List<String> namedirec ;
	
public List<String> getname() {	
   		
   		mstCode = GetAll();
   		System.out.println("-----------------------------------------------");
   		System.out.println(search);
   		Listpr = new ArrayList<ReunionPrive>();
   		for (ReunionPrive pr: mstCode) {
   			
   			
   			namedirec.add(pr.getDirecteur().getName().toString());
		
   		
   		}	
   		return namedirec;
   	
    
    
   	}
	
	
	
	
	
	
	
	public void generatorMail()  { 
		
		System.out.println(searchdate); 
		
		
		
		
		mstCode = GetAll();
   		
   		
   		Listpr = new ArrayList<ReunionPrive>();
   		for (ReunionPrive pr: mstCode) {
   			
   			if ((pr.getDateRdvP().toString().equals(searchdate))){
   				Properties props = new Properties();

   				props.put("mail.smtp.host", "smtp.gmail.com");
   				props.put("mail.smtp.port", 587);
   				props.put("mail.smtp.user", "techevent5013@gmail.com");
   				props.put("mail.smtp.auth", "true");
   				props.put("mail.smtp.starttls.enable", "true");
   				props.put("mail.smtp.debug", "true");
   				props.put("mail.smtp.socketFactory.port", 587);
   				// props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
   				props.put("mail.smtp.socketFactory.fallback", "false");
   				props.put("mail.smtp.starttls.enable", "true");
   				props.put("mail.smtp.ssl.trust", "smtp.gmail.com");


   				try {
   					Session session = Session.getDefaultInstance(props, null);
   					session.setDebug(true);
   					MimeMessage message = new MimeMessage(session);
   					message.setText("Bonjour Monsieur "+pr.getParent().getName().toString() +" Vous avez une Réunion Le "+pr.getDateRdvP().toString() + "\n Directuer :"+pr.getDirecteur().getName().toString()+"\n Email Directeur : "+pr.getDirecteur().getEmail().toString()
   							+"\n Contenu: "+pr.getMotifRdvP().toString()+" \n Categories: "+pr.getCategories().toString()+" \n Importance: "+pr.getImporatances().toString());
   					message.setSubject(" Vous Avez une Reunion Le: "+searchdate);
   					message.setFrom(new InternetAddress("techevent5013@gmail.com"));
   					message.addRecipient(RecipientType.TO, new InternetAddress(pr.getParent().getEmail().toString()));
   					message.saveChanges();
   					javax.mail.Transport transport = session.getTransport("smtp");
   					transport.connect("smtp.gmail.com", 587 , "techevent5013@gmail.com", "50135013");
   					transport.sendMessage(message, message.getAllRecipients());
   					transport.close();


   				} catch (MessagingException e) {
   					e.printStackTrace(); 
   				}
   				
   			}
   			
   		}
		
		

}
	
	

}
