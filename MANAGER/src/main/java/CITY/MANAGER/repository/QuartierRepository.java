package CITY.MANAGER.repository;

import CITY.MANAGER.entity.Quartier;
import CITY.MANAGER.entity.Ville;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.List;
import java.util.Optional;
@Repository
public interface QuartierRepository extends JpaRepository<Quartier, Integer> {
    @Override
    Page<Quartier> findAll(Pageable pageable);
    Optional<Quartier> findByVilleId(Integer integer);
    Optional<Quartier> findByIdAndVilleId(Integer integer ,int villeId);

    Page<Quartier> findByVilleId(int villeId, Pageable pageable);
}
