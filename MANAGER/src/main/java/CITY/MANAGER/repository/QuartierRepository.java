package CITY.MANAGER.repository;

import CITY.MANAGER.entity.Quartier;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuartierRepository extends CrudRepository<Quartier, Integer> {
    public List<Quartier>findAll();

    public Quartier findQuartierById(int id);
    public Quartier save(Quartier quartier);
}
