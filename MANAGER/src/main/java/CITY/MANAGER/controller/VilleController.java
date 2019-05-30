package CITY.MANAGER.controller;

import CITY.MANAGER.entity.Ville;
import CITY.MANAGER.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/villes/")
public class VilleController {
    private VilleRepository villeRepository;

    @Autowired
    public VilleController(VilleRepository villeRepository){
        this.villeRepository = villeRepository;
    }

    @GetMapping("nouvelleville")
    public String nouvelleVille(Ville ville){
        return "newcity";
    }

    @GetMapping("listeville")
    public String listeVille(Model model){
        model.addAttribute ("villes",villeRepository.findAll ());
        return "listeville";
    }
}
