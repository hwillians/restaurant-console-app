package dev.dao;

import java.util.List;

import dev.entite.Plat;

public interface IPlatDao {
	List<Plat> listerPlats();

	void ajouterPlat(String nomPlat, Integer prixPlat);

}
