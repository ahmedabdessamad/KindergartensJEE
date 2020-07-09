package tn.cloudnerds.services;

import javax.ejb.Local;

import tn.cloudnerds.entities.ApplicationUser;

@Local
public interface UserServiceLocal {
	public ApplicationUser login(String email, String password);
}
