package tn.cloudnerds.managedbeans;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
//import org.codehaus.jackson.annotate.JsonIgnore;
//import org.codehaus.jackson.annotate.JsonIgnoreProperties;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;

import  tn.cloudnerds.entities.Enfant;
import  tn.cloudnerds.entities.Gender;
import tn.cloudnerds.entities.Profil_Jardin;
import tn.cloudnerds.entities.Profil_Parent;
import tn.cloudnerds.services.EnfantService;


@ManagedBean(name = "EnfantBean", eager = true)
@SessionScoped
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnfantBean {
	/*@ManagedProperty(value = "#{PDFManager}")
	PDFManager PDFManager;
	public PDFManager getPDFManager() {
		return PDFManager;
	}

	public void setPDFManager(PDFManager PDFManager) {
		this.PDFManager = PDFManager;
	} */
	String skills="";
	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}
 //   private static final int DEFAULT_BUFFER_SIZE = 10240; // 10KB.

	String txtname;
	String TxtStatus;
	Enfant enf1;
	Enfant enf2;
	Enfant enf3;
	List<Enfant> mstCode;
	List<Enfant> liste2 ;
	int id;
	String name;
	String birthDate;
	/*
	@JsonIgnore
	int parent; 
	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	} 
	*/
	@Enumerated(EnumType.ORDINAL)
	Gender gender;
	
	int parentId;
	String image;
	int profilJardinId;
	Profil_Parent parent;
	 Profil_Jardin profilJardin;
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
	public Enfant getEnf1() {
		return enf1;
	}
	public void setEnf1(Enfant enf1) {
		this.enf1 = enf1;
	}
	public Enfant getEnf2() {
		return enf2;
	}
	public void setEnf2(Enfant enf2) {
		this.enf2 = enf2;
	}
	public Enfant getEnf3() {
		return enf3;
	}
	public void setEnf3(Enfant enf3) {
		this.enf3 = enf3;
	}
	
	public List<Enfant> getListe2() {
		return liste2;
	}
	
	public List<Enfant> getMstCode() {
		return mstCode;
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
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
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
	
	public String getTxtname() {
		return txtname;
	}
	public void setTxtname(String txtname) {
		this.txtname = txtname;
	}
	
	@EJB
	EnfantService enf;
	
	public List<Enfant> doGetAll() {
		System.out.println(enf.getall());

		return enf.getall();
	}

	public String IndexGetAll() {
		return "ListEnfant.xhtml?faces-redirect=true";
	}
	public String RedirectSearchEnf() {
		return "EnfantRecherche.xhtml?faces-redirect=true";
	}
	public String RedirectAjoutEnf() {
		return "AjoutEnfant.xhtml?faces-redirect=true";
	}
	
	
    public String AjouterEnfant(){
    Enfant ajout = new Enfant();
   // ajout.setId(id);
    ajout.setName(name);
    
    try {SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date date1 = sdf.parse(birthDate);
	java.sql.Date sqlStartDate = new java.sql.Date(date1.getTime());
	ajout.setBirthDate(sqlStartDate);

} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	System.out.print("masaréch l'arjout");
}  
    
    ajout.setGender(gender);
    ajout.setParentId(parentId);
    ajout.setImage(image);
    ajout.setProfilJardinId(profilJardinId);

    enf.AddEnfant(ajout);
	return "ListEnfant.xhtml?faces-redirect=true";
	}
	
	
    public String DeleteEnfant(int id) {
		System.out.println("delete is here !");
		enf.DeleteById(id);
		return "ListEnfant.xhtml?faces-redirect=true"; }
    
    
    
    
    
    public String redirectUpdate(int id )
	{
		enf1 = enf.getById(id);
        setId(enf1.getId());		   

        setName(enf1.getName());		   

		   SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
	        String strDate = sdf.format(enf1.getBirthDate());
		setBirthDate(strDate); 
        setGender(enf1.getGender());
        setParentId(enf1.getParentId());		   
        setImage(enf1.getImage());	
        setProfilJardinId(enf1.getProfilJardinId());		   


		return "UpdateEnfant.xhtml?faces-redirect=true";
	}
    
    
    
    
    
    
    
    
    public String UpdateEnfant(int Id) {

		 Enfant  interv1 = new Enfant();
		 interv1.setId(id);
		 interv1.setName(name);
		    
		   try {SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date1 = sdf.parse(birthDate);
			java.sql.Date sqlStartDate = new java.sql.Date(date1.getTime());
			interv1.setBirthDate(sqlStartDate);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

			 interv1.setGender(gender);
			 interv1.setParentId(parentId);
			 interv1.setImage(image);
			 interv1.setProfilJardinId(profilJardinId);

		    System.out.println(interv1);
		    System.out.println("aaaaaaaaaa");
		     enf.EditById(Id, interv1);
		return "ListEnfant.xhtml?faces-redirect=true";
	}
    
    
    
    
    
    
    
   	public String doGet() {	
   		//System.out.println("sdffdffffffffffffffffffffffffffffffffffffffffffffffff"+liste2.size());
   		mstCode = doGetAll();
   		System.out.println("********************************************************************************");
   		System.out.println(txtname);
   		liste2 = new ArrayList<Enfant>();
   		for (Enfant c : mstCode) {
   	
		if ((c.getName().toString().equals(txtname))){
				Enfant c1 = c;
			    System.out.println("afficheeeee wa7da" + c1);
				liste2.add(c1); 
		}
   		
   		}	
   		return "ResultatRecherche.xhtml?faces-redirect=true";
   	
    
    
   	}
   	
   	
   	////////////////////pdf/////////////
   

	public void Accepter(int id)
	{
	//	ps.Accepter(id);
		System.out.println(id);
		Enfant p=enf.getById(id);
		System.out.println(p);
		 PDFManager pdfManager = new PDFManager();
	     pdfManager.setFilePath("C:\\eclipse-workspace\\cloudkids_javaee\\kindergarten-web\\src\\main\\webapp\\template\\EnfantEya\\Pdf"+p.getName());
	     try {
	         String text = pdfManager.toText();
	         String[] arr = text.split("COMPETENCES");

	     if (arr.length==1)
	     {
	     	arr=text.split("Technologies");
	     	if (arr.length==1)
	     	{
	     		arr=text.split("Skills");
	     		if (arr.length==1)
	     		{
		     		arr=text.split("COMPÉTENCES");

	     		}
	     	}
	     	
	     }
	     
	     } 
	      catch (IOException ex) {
	     	
	     }
	    
	 lettredembauche(p.getName(),p.getGender(),p.getBirthDate(),p.getParentId(),p.getProfilJardinId());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
public void lettredembauche(String name,Gender gender,Date birthday,int parentId, int ProfilJardinId)
{
	PDDocument document = new PDDocument();
	PDPage page = new PDPage();
	document.addPage(page);
 try
 {
	 Path path = Paths.get("C:\\eclipse-workspace\\cloudkids_javaee\\kindergarten-web\\src\\main\\webapp\\template\\EnfantEya\\logo.PNG");
		PDPageContentStream contentStream = new PDPageContentStream(document, page);
		
		PDImageXObject image= PDImageXObject.createFromFile(path.toString(), document);	
		contentStream.drawImage(image,20,640);

	contentStream.setFont(PDType1Font.HELVETICA_BOLD, 28);

	contentStream.beginText();
	contentStream.moveTextPositionByAmount(170,640);
	contentStream.showText("Confirmation d'insecription");


	contentStream.endText();
	contentStream.setFont(PDType1Font.HELVETICA, 13);

	 contentStream.beginText();
	 
	// contentStream.newLineAtOffset(, ty);
		contentStream.moveTextPositionByAmount(10,570);


		contentStream.showText("Monsieur/Madame,"+name);
		

		contentStream.endText();
	 contentStream.beginText();
	 
	// contentStream.newLineAtOffset(, ty);
		contentStream.moveTextPositionByAmount(10,550);


		contentStream.showText("Suite à votre insecription   "+" ,Nous avons l'immense plaisir de vous acceillir entre nous  MR ");
		

		contentStream.endText();
		contentStream.setFont(PDType1Font.HELVETICA_BOLD, 13);

		 contentStream.beginText();
		 				contentStream.moveTextPositionByAmount(30,530);


				contentStream.showText("Nom  : "+name);
				contentStream.endText();
				contentStream.beginText();
				contentStream.moveTextPositionByAmount(30,510);


				contentStream.showText("Date de Naissance : "+ birthday);
					
				contentStream.endText();
				contentStream.beginText();
				contentStream.moveTextPositionByAmount(30,490);

		        contentStream.showText("genre : "+gender);
				contentStream.endText();
				contentStream.beginText();
				contentStream.moveTextPositionByAmount(30,470);


								 
								// contentStream.newLineAtOffset(, ty);
									contentStream.moveTextPositionByAmount(10,430);


									contentStream.showText("sa rejointe à l'equipe Levio   ");
									
							
									contentStream.endText();
					contentStream.close();
					//C:\eclipse-workspace\TestJson\TestJson-web\src\main\resources\I
	document.save("C:/eclipse-workspace/cloudkids_javaee/kindergarten-web/src/main/webapp/template/EnfantEya/Pdf/"+name+".pdf");
	document.close();
 }
 catch (Exception e)
 {
	 System.out.println(e.getMessage());
 }
}
	
   	
   	
   	
   	
   	
   	
   	
   	
}
