package CITY.MANAGER.controller;

import CITY.MANAGER.entity.Quartier;
import CITY.MANAGER.entity.Ville;
import CITY.MANAGER.repository.VilleRepository;
import antlr.collections.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;

@Controller
@RequestMapping("/villes/")
public class VilleController {
    private final VilleRepository villeRepository;

    @Autowired
    public VilleController(VilleRepository villeRepository){
        this.villeRepository = villeRepository;
    }

    @GetMapping("listeville")
    public String listeVille(Model model){
        model.addAttribute ("villes",villeRepository.findAll ());
        return "listeville";
    }

    @GetMapping("addville")
    public String addVille(Ville ville){
        return "addville";
    }

    @PostMapping("addville")
    @ResponseBody
    public String addVille(@Valid Ville ville, BindingResult result, Model model){
        if(result.hasErrors ()){return "addville";
        }
        model.addAttribute ("nomVille",ville.getNomVille ());
        model.addAttribute ("hauteur", ville.getHauteur ());
        model.addAttribute ("largeur",ville.getLargeur ());
        model.addAttribute ("valeurMin",ville.getValeurMin ());
        model.addAttribute ("valeurMax",ville.getValeurMax ());

        villeRepository.save (ville);
        return "listeville";
    }

    @GetMapping("editville/{id}")
    public String showEditVille(@PathVariable("id") int id,Model model){
        Ville ville = villeRepository.findById (id).
                orElseThrow (()-> new IllegalArgumentException ("Id ville invalide: "+ id));
        model.addAttribute ("ville", ville);
        return "editville"; }

    @PostMapping("editville/{id}")  // créer une nouvelle ville. Problème à régler.

    public String updateVille(@PathVariable("id")int id,@Valid Ville ville, BindingResult result, Model model){
        if(result.hasErrors ()){
            ville.setId (id);
            return "editville";
        }
        villeRepository.save (ville);
       return "listeville";
    }

    @GetMapping("delete/{id}")
    public String deleteVille(@PathVariable("id")int id, Model model){
        Ville ville = villeRepository.findById (id).
                orElseThrow (()->new IllegalArgumentException ("Id ville invalide: "+ id));
        villeRepository.delete (ville);
        model.addAttribute ("villes",villeRepository.findAll ());
        return "listeville";
    }

}
     /*
    public void updateVille(@PathVariable("id")int id,
                            @PathVariable("nomVille")String nomVille,
                            @PathVariable("hauteur")int hauteur,
                            @PathVariable("largeur")int largeur,
                            @PathVariable("valeurMin")int valeurMin,
                            @PathVariable("valeurMax")int valeurMax,
                            @Valid Ville ville, BindingResult result, Model model){
       ville.setNomVille (nomVille);
       ville.setHauteur (hauteur);
       ville.setLargeur (largeur);
       ville.setValeurMin (valeurMin);
       ville.setValeurMax (valeurMax);

       villeRepository.save (ville); */


