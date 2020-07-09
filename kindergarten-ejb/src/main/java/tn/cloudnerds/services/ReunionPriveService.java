package tn.cloudnerds.services;

import java.util.List;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import tn.cloudnerds.entities.Enfant;
import tn.cloudnerds.entities.Profil_Directeur;
import tn.cloudnerds.entities.Profil_Parent;
import tn.cloudnerds.entities.ReunionPrive;

@LocalBean
@Stateless
public class ReunionPriveService {

	
	
	
	
	 public List<ReunionPrive> GetAllReunionPrive(){
		
		
	List<ReunionPrive> ReunionP = new ArrayList<ReunionPrive>();
	
	System.out.println("---- list of private Reunion ------");
	Client cl = ClientBuilder.newClient();
	WebTarget target = cl.target("http://192.168.1.111/api/Reunionprive"); 
	Invocation.Builder invocationBuilder =  target.request(MediaType.APPLICATION_JSON);

//	WebTarget hello = target.path("ReunionPrive"); 

//	Response res=(Response) hello.request().get();
	Response response = invocationBuilder.get();

	//  System.out.println(res.readEntity(String.class));
//	ArrayList<ReunionPrive> post = res.readEntity(new GenericType<ArrayList<ReunionPrive>>() {});

	
	
	ReunionPrive[] listQuestion =  response.readEntity(ReunionPrive[].class);
	for (ReunionPrive p:listQuestion){
		ReunionP.add(p);
	}
System.out.println("size of list is : "+ReunionP.size()+ReunionP);

	return ReunionP;
}
	
	
	
	 public List<Profil_Parent> GetAllProfilParents(){
			
			
			List<Profil_Parent> Profil_Parents = new ArrayList<Profil_Parent>();
			
			System.out.println("---- list of private Reunion ------");
			Client cl = ClientBuilder.newClient();
			WebTarget target = cl.target("http://192.168.1.111/api/ProfilDirecteur"); 
			Invocation.Builder invocationBuilder =  target.request(MediaType.APPLICATION_JSON);

//			WebTarget hello = target.path("ReunionPrive"); 

//			Response res=(Response) hello.request().get();
			Response response = invocationBuilder.get();

			//  System.out.println(res.readEntity(String.class));
//			ArrayList<ReunionPrive> post = res.readEntity(new GenericType<ArrayList<ReunionPrive>>() {});

			
			
			Profil_Parent[] listQuestion =  response.readEntity(Profil_Parent[].class);
			for (Profil_Parent p:listQuestion){
				Profil_Parents.add(p);
			}
		System.out.println("size of list is : "+Profil_Parents.size()+Profil_Parents);

			return Profil_Parents;
		}
	 
	 
	 
	 
	 
	 
	 
	 
	
	
	  public ReunionPrive GetReunionPrivetById(int id) {
	    	System.out.println("***** get Reunion Prive *****");
	    	
	    	Client cl = ClientBuilder.newClient();
			WebTarget target = cl.target("http://192.168.1.111/api/Reunionprive/"+id); 
			Invocation.Builder invocationBuilder =  target.request(MediaType.APPLICATION_JSON);
			Response response = invocationBuilder.get();
			ReunionPrive ReunionPrive = response.readEntity(ReunionPrive.class);
			System.out.println("*** ref ****"+ReunionPrive);
			return ReunionPrive;
	    }
	
	  
	  
	  
	  public void DeleteReunionpriveById(int id) {
	    	//System.out.println("***** get ReunionPrives *****");
			List<ReunionPrive> ReunionPrives = new ArrayList<ReunionPrive>();

	    	Client cl = ClientBuilder.newClient();
			WebTarget target = cl.target("http://192.168.1.111/api/Reunionprive/"+id); 
			//WebTarget t = target.path("ReunionPrive"+id);     	
			
			Invocation.Builder invocationBuilder =  target.request(MediaType.APPLICATION_JSON);

			Response response = invocationBuilder.delete();
			
//	    	Response res=(Response) t.request().delete();
			
			ReunionPrive ReunionPrive = response.readEntity(ReunionPrive.class);

	    	
			
	    }
	
	  
	  
	  public Response EditReunionpriveById(int id, ReunionPrive R) {
	    	System.out.println("---- update ReunionPrive ----");
	    	Client cl = ClientBuilder.newClient();
			WebTarget target = cl.target("http://192.168.1.111/api/Reunionprive/"+id); 
			 Invocation.Builder invocationBuilder =  target.request(MediaType.APPLICATION_JSON);
				Response response = invocationBuilder.put(Entity.json(R));
	    	return response;
	    }
	  
	  
	  
	  
	  public void AddReunionPrive (ReunionPrive R) {
	    	//System.out.println("***** get ReunionPrive *****");
	    	//ReunionPrive c;
	    	Client cl = ClientBuilder.newClient();
			WebTarget target = cl.target("http://192.168.1.111/api/Reunionprive"); 
			 WebTarget hello = target.path("ReunionPrive");     	

	    	Response res=(Response) hello.request().post(Entity.json(R));
			//System.out.println(res.readEntity(String.class));

	    	// pa moi System.out.println(res.getStatusInfo().getStatusCode());
	    	// p moi System.out.println(res.readEntity(String.class));
	    	// p moi Condidate cond = res.readEntity(Condidate.class);

	    }
	  
	

	  
	  
	  
}