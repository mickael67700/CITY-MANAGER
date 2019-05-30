package CITY.MANAGER.repository;

import CITY.MANAGER.entity.Quartier;
import CITY.MANAGER.entity.Ville;

import java.util.List;

public interface ManagerRepository {
    // Liste des villes
    public List<Ville>getAllVilles();

    // Liste des Quartiers
    public List<Quartier> getAllQuartiers();

    //Liste des Quatiers d'une Ville
    public List<Quartier>getAllQuartiers(int id);

    // Trouver Ville identifié par son Id
    public Ville getVilleById(int id);

    //Trouver un quartier par son Id
    public Quartier getQuartierById(int id);
}
