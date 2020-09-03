package dev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.entite.Plat;

public interface PlatRepository extends JpaRepository<Plat, Integer> {

	List<Plat> findByPrixEnCentimesEuros(Integer prixEnCentimesEuros);

	@Query("select avg(p.prixEnCentimesEuros) from Plat p where p.prixEnCentimesEuros > :prix")
	Double findByAvgPrixSuppA(@Param("prix") int i);

	@Query("select p from Plat p join fetch p.ingredients where p.nom = ?1")
	Optional<Plat> findByNomWithIngredients(String string);

	@Modifying
	@Query("update Plat p set p.nom = :newNom WHERE p.nom = :oldNom")
	void updateNomPlat(@Param("oldNom") String ancienNom, @Param("newNom") String nouveauNom);

}
