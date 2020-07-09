package tn.cloudnerds.services;

import java.sql.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.cloudnerds.entities.Categorie;
import tn.cloudnerds.entities.Imporatance;
import tn.cloudnerds.entities.ReunionPrive;




@Remote
public interface IReunionPriveServiceRemote {

	List<ReunionPrive> GetAllReunionPrive();
	ReunionPrive GetReunionPrivetById(int Id) ;
	void DeleteReunionpriveById(int id);
    void AddReunionPrive(Date dateRdvP, String lieuRdvP, String motifRdvP, Categorie categories,
			Imporatance imporatances);
	
}
