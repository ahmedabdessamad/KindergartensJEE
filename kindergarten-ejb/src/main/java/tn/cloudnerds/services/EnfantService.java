package tn.cloudnerds.services;


import java.util.List;
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
import tn.cloudnerds.entities.Gender;

@LocalBean
@Stateless
public class EnfantService {
	/*

	
	//@Override
	public Long getnbFemme() {
		Gender nom=Gender.Femme;
		TypedQuery <Long> query1 =em.createQuery("SELECT COUNT(e) FROM Enfant e WHERE e.Gender=:Femme", Long.class);
		 query1.setParameter("Femme", nom);
		long nbr=query1.getSingleResult();
		return nbr;
	}
	
	public Long getnbHomme() {
		Gender nom=Gender.Homme;
		TypedQuery <Long> query1 =em.createQuery("SELECT COUNT(e) FROM Enfant e WHERE e.Gender=:Homme", Long.class);
		 query1.setParameter("Homme", nom);
		long nbr=query1.getSingleResult();
		return nbr;
	}
	
	public Long getnbOther() {
		Gender nom=Gender.Other;
		TypedQuery <Long> query1 =em.createQuery("SELECT COUNT(e) FROM Enfant e WHERE e.Gender=:Other", Long.class);
		 query1.setParameter("Other", nom);
		long nbr=query1.getSingleResult();
		return nbr;
	} 
	public Long getnbPrefer() {
		Gender nom=Gender.Homme;
		TypedQuery <Long> query1=(TypedQuery<Long>) getall().stream().filter(t->t.getGender().equals("Homme"));

		
		//TypedQuery <Long> query1 =em.createQuery("SELECT COUNT(e) FROM Enfant e WHERE e.Gender=:PreferNotToSay", Long.class);
		 query1.setParameter("Homme", nom);
		long nbr=query1.getSingleResult();
		return nbr;
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

public List<Enfant>getall () {
		List<Enfant> quiiz = new ArrayList<Enfant>();

		System.out.println("***** get all Enfant *****");
    	Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://localhost:1958/api/Enfantweb"); 
		Invocation.Builder invocationBuilder =  target.request(MediaType.APPLICATION_JSON);

//		WebTarget hello = target.path("Enfant"); 

//    	Response res=(Response) hello.request().get();
		Response response = invocationBuilder.get();

    	// mosh ena System.out.println(res.readEntity(String.class));
	//	ArrayList<Enfant> post = res.readEntity(new GenericType<ArrayList<Enfant>>() {});
	
		
		
		Enfant[] listQuestion =  response.readEntity(Enfant[].class);
		for (Enfant p:listQuestion){
				quiiz.add(p);
		}
	System.out.println("size of list is : "+quiiz.size()+quiiz);

		return quiiz;
		
		
		
		 
	//	return post;
}
	

    public Enfant getById(int id) {
    	System.out.println("***** get condidate *****");
    	Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://localhost:1958/api/Enfantweb/"+id); 
		Invocation.Builder invocationBuilder =  target.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
    	Enfant condi = response.readEntity(Enfant.class);
		System.out.println("*** ref ****"+condi);
		return condi;
    }

    
    public void DeleteById(int id) {
    	//System.out.println("***** get condidate *****");
		List<Enfant> quiiz = new ArrayList<Enfant>();

    	Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://localhost:1958/api/Enfantweb/"+id); 
		//WebTarget t = target.path("Enfant"+id);     	
		
		Invocation.Builder invocationBuilder =  target.request(MediaType.APPLICATION_JSON);

		Response response = invocationBuilder.delete();
		
//    	Response res=(Response) t.request().delete();
		
    	Enfant cond = response.readEntity(Enfant.class);

    	

    }
    
   
	
    public Response EditById(int id, Enfant u) {
    	System.out.println("***** update enfant *****");
    	Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://localhost:1958/api/Enfantweb/"+id); 
		 Invocation.Builder invocationBuilder =  target.request(MediaType.APPLICATION_JSON);
			Response response = invocationBuilder.put(Entity.json(u));
    	return response;
    }
    
    public void AddEnfant(Enfant u) {
    	//System.out.println("***** get condidate *****");
    	//Condidate c;
    	Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://localhost:1958/api/Enfantweb"); 
		 WebTarget hello = target.path("Enfant");     	

    	Response res=(Response) hello.request().post(Entity.json(u));
		//System.out.println(res.readEntity(String.class));

    	// pa moi System.out.println(res.getStatusInfo().getStatusCode());
    	// p moi System.out.println(res.readEntity(String.class));
    	// p moi Condidate cond = res.readEntity(Condidate.class);

    } 
	
	
    
   
	

}
