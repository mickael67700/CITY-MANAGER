package CITY.MANAGER.repository;
import java.util.List;

import CITY.MANAGER.entity.Ville;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepository extends CrudRepository<Ville, Integer>{
    public Ville findVilleByNomVille(String nomVille);
    public List<Ville>findByNomVille(String nomVille);
    public Ville findVilleById(int id);
    public Ville save(Ville ville);

}


