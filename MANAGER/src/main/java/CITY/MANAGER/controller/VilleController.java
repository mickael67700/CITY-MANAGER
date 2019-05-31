package CITY.MANAGER.controller;

import CITY.MANAGER.entity.Ville;
import CITY.MANAGER.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.validation.Valid;

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

    @GetMapping("edit/{id}")
    public String updateVille(@PathVariable("id") int id,@Valid Ville ville,BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors ()){
            ville.setId (id);
            return "editville";
        }
        villeRepository.save (ville);
        model.addAttribute("villes",villeRepository.findAll ());
        return "index";
    }
}
