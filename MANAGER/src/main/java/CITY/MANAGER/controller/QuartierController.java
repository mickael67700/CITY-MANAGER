package CITY.MANAGER.controller;

import CITY.MANAGER.entity.Quartier;
import CITY.MANAGER.repository.QuartierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import CITY.MANAGER.repository.VilleRepository;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/villes/")
public class QuartierController {
    @Autowired
    private QuartierRepository quartierRepository;
    private VilleRepository villeRepository;


    @GetMapping("/villes/{villeId}/quartiers")
    public List<Quartier> getAllQuartiersByVilleId(@PathVariable(value = "villeId") int villeId) {
        return quartierRepository.findByVilleId(villeId);
    }


    @GetMapping("quartiers")
    public Page<Quartier> getAllQuartiers(Pageable pageable) {
        return quartierRepository.findAll(pageable);
    }

    @PostMapping("Quartiers")
    public @Valid Quartier createPost(@Valid @RequestBody Quartier quartier) {
        return quartierRepository.save(quartier);
    }


   /* @PutMapping("/{villeId}/quartiers/editquartier/{id}")
    public Quartier updateQuartier(@PathVariable(value = "villeId") int villeId,
                                   @PathVariable(value = "quartierId") int quartierId,
                                   @Valid @RequestBody Quartier quartierRequest) {
        if (!villeRepository.existsById(villeId)) {
            throw new ResourceNotFoundException("VilleId " + villeId + " not found");
        }

        return quartierRepository.findById(quartierId).map(quartier -> {
            quartier.setTypeQuartier(quartierRequest.getTypeQuartier());
            return quartierRepository.save(quartier);
        }).orElseThrow(() -> new ResourceNotFoundException("QuartierId " + quartierId + "not found"));  */


    }



