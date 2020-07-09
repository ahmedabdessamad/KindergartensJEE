package tn.cloudnerds.services;

import java.sql.Date;
import java.util.List;

import javax.ejb.Local;

import tn.cloudnerds.entities.Categorie;
import tn.cloudnerds.entities.Imporatance;
import tn.cloudnerds.entities.ReunionPrive;



@Local
public interface IReunionPriveServiceLocal {

	
	List<ReunionPrive> GetAllReunionPrive();
	ReunionPrive GetReunionPrivetById(int Id) ;
	void DeleteReunionpriveById(int id);
    void AddReunionPrive(Date dateRdvP, String lieuRdvP, String motifRdvP, Categorie categories,
			Imporatance imporatances);
    
}
