package CITY.MANAGER.dao;
import java.util.List;

import CITY.MANAGER.entity.Ville;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import CITY.MANAGER.entity.Ville;

@Repository
public interface VilleDao extends CrudRepository<Ville, Integer>{
    public Ville findVilleByNomVille(String nomVille);
    public List<Ville>findAll();
    public Ville findVilleById(int id);
    public Ville save(Ville ville);
}


