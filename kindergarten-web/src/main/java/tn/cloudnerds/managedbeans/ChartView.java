package tn.cloudnerds.managedbeans;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import org.primefaces.model.charts.pie.PieChartModel;
//import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.pie.PieChartDataSet;
import tn.cloudnerds.entities.Enfant;
import tn.cloudnerds.entities.Gender;
import tn.cloudnerds.entities.Profil_Parent;
import tn.cloudnerds.services.EnfantService;

@ManagedBean(name = "ChartView", eager = true)
//@RequestScoped
@SessionScoped
@ViewScoped
public class ChartView implements Serializable {
   
	
    private static final int DEFAULT_BUFFER_SIZE = 10240; // 10KB.

	
	
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
	public Profil_Parent getParent() {
		return parent;
	}

	public void setParent(Profil_Parent parent) {
		this.parent = parent;
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
	
	
	
	
	
	
	

	
	   private static final long serialVersionUID = 253762400419864192L;  
	    private PieChartModel pieModel;
	   // private BarChartModel barModel;
	    //private GChartModel chartModel = null;    
	  
	  @EJB
	  EnfantService cs;
	//    public GChartModel getChart() {  
	  //      return chartModel;  
	   //}  
	  
	    @PostConstruct  
	    public void generateModel() {  
	
        System.out.println("hahah");

createPieModel();

	    }  
	   
	    public PieChartModel getPieModel() {
	    	
	    	    return pieModel;
		}

		public void setPieModel(PieChartModel pieModel) {
			this.pieModel = pieModel;
		}
		 private void createPieModel      () {
		        pieModel = new PieChartModel();
		       ChartData data = new ChartData();
				
		       List<Enfant> Fm=new ArrayList<>();
		       List<Enfant> Hm=new ArrayList<>();
		       List<Enfant> Oth=new ArrayList<>();
		       List<Enfant> Prf=new ArrayList<>();
		   	 Fm=cs.getall().stream().filter(t->t.getGender().equals(Gender.Femme)).collect(Collectors.toList());
		   	 Hm=cs.getall().stream().filter(t->t.getGender().equals(Gender.Homme)).collect(Collectors.toList());
		   	 Oth=cs.getall().stream().filter(t->t.getGender().equals(Gender.Other)).collect(Collectors.toList());
		   	 Prf=cs.getall().stream().filter(t->t.getGender().equals(Gender.PreferNotToSay)).collect(Collectors.toList());

		   	int nbFm=Fm.size();
		  // 	System.out.println(nbFm);
		   	int nbHm=Hm.size();
		   	int nbOth=Oth.size();
		   	int nbPrf=Prf.size();
		  /* 	

		   	pieModel.set("Femme",nbFm);
		   	pieModel.set("Homme",nbHm);
	        pieModel.set("Other",nbPrf);
	        pieModel.set("PreferNotToSay",nbOth);

	// System.out.println(nbrpending);
	        pieModel.setTitle("% of Femme/Homme/Other/Prf Applications");
	        pieModel.setLegendPosition("w");
	        pieModel.setShadow(false);  
	    
		   	
		   	*/
	        PieChartDataSet dataSet = new PieChartDataSet();
		        List<Number> values = new ArrayList<>();
		        
		        values.add(nbFm);
		        values.add(nbHm);
		        values.add(nbPrf);
		        values.add(nbOth);
		        dataSet.setData(values);
		         
		        List<String> bgColors = new ArrayList<>();
		        bgColors.add("rgb(255, 99, 132)");
		        bgColors.add("rgb(54, 162, 235)");
		        bgColors.add("rgb(255, 205, 86)");
		        bgColors.add("rgb(75, 192, 192)");
		        dataSet.setBackgroundColor(bgColors);
		         
		        data.addChartDataSet(dataSet);
		        List<String> labels = new ArrayList<>();
		        labels.add("Femme");
		        labels.add("Homme");
		        labels.add("Others");
		        labels.add("PreferNotToSay");
		        data.setLabels(labels);
		      
		        pieModel.setData(data);
		    
		    }
		
		 ////////////////////////// Pdf /////////////////////
		 
				    

		    }
