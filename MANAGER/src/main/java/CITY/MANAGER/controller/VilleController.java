package CITY.MANAGER.controller;

import CITY.MANAGER.entity.Ville;
import CITY.MANAGER.entity.Quartier;
import CITY.MANAGER.controller.controller;
import CITY.MANAGER.repository.VilleRepository;
import CITY.MANAGER.repository.QuartierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/villes/")
public class VilleController {
    private final VilleRepository villeRepository;
    private final QuartierRepository quartierRepository;

    @Autowired
    public VilleController(VilleRepository villeRepository, QuartierRepository quartierRepository){
        this.villeRepository = villeRepository;
        this.quartierRepository = quartierRepository;
    }

    @GetMapping("listeville")
    public String listeVille(Model model){
        model.addAttribute ("villes",villeRepository.findAll ());
        return "listeville";
    }

    @GetMapping("addville")
    public String addVille(Ville ville,Quartier quartier){
        return "addville";
    }

    @PostMapping("addville")
    @ResponseBody
    public String addVille(@Valid Ville ville, BindingResult result, Model model , BindingResult resultat){
        if(result.hasErrors ()){return "addville";
        }

        model.addAttribute ("nomVille",ville.getNomVille ());
        model.addAttribute ("hauteur", ville.getHauteur ());
        model.addAttribute ("largeur",ville.getLargeur ());
        model.addAttribute ("valeurMin",ville.getValeurMin ());
        model.addAttribute ("valeurMax",ville.getValeurMax ());
        model.addAttribute ("rivDmax",ville.getRivDmax ());
        model.addAttribute ("rivPmax",ville.getRivPmax ());
        model.addAttribute ("forMax",ville.getForDmax ());
        model.addAttribute ("forPmax",ville.getForPmax ());
        model.addAttribute ("eclDmax",ville.getEclDmax ());
        model.addAttribute ("eclPmax",ville.getEclPmax ());
        model.addAttribute ("eglDmax",ville.getEglDmax ());
        model.addAttribute ("eglPmax",ville.getEglPmax ());
        model.addAttribute ("comDmax",ville.getComDmax ());
        model.addAttribute ("comPmax",ville.getComPmax ());
        model.addAttribute ("polDmax",ville.getPolDmax ());
        model.addAttribute ("polPmax",ville.getPolPmax ());
        model.addAttribute ("rtbDmax",ville.getRtbDmax ());
        model.addAttribute ("rtbPmax",ville.getRtbPmax ());
        villeRepository.save(ville);
        ArrayList<Quartier> quartiers = new ArrayList<>();
        for(int i=0;i<ville.getLargeur();i++) {
            for (int j = 0; j < ville.getHauteur(); j++) {

                Quartier quar =new Quartier();
                quar.setAbscisse(i);
                quar.setOrdonnee(j);
                quar.setTypeQuartier("RTE");
                quar.setVille(ville);
               // quartiers.add(quar);
                quartierRepository.save(quar);

            }
        }
        return "addville";

    }

    @GetMapping("editville/{id}")
    public String showEditVille(@PathVariable("id") int id,Model model){
        Ville ville = villeRepository.findById (id).

                orElseThrow (()-> new IllegalArgumentException ("Id ville invalide: "+ id));
        model.addAttribute ("ville", ville);

        return "editville"; }

    /*
    @PostMapping("editville/{id}")  // créer une nouvelle ville. Problème à régler.
    //@RequestMapping(value = "editville/{id}",method = RequestMethod.PUT)
    public String updateVille(@PathVariable("id")int id,@Valid Ville ville, BindingResult result, Model model){
        if(result.hasErrors ()){
            ville.setId (id);
            return "editville";
        }
        villeRepository.save (ville);
       return "listeville";
    }
    */
    @PutMapping("editville/{id}")
    public String saveVille(@RequestBody Ville ville, @PathVariable ("id") int id){
        villeRepository.save(ville);
        return "Modifications enregistrées";
    }

    @GetMapping("delete/{id}")
    public String deleteVille(@PathVariable("id")int id, Model model){
        Ville ville = villeRepository.findById (id).
                orElseThrow (()->new IllegalArgumentException ("Id ville invalide: "+ id));
        villeRepository.delete (ville);
        model.addAttribute ("villes",villeRepository.findAll ());
        return "listeville";
    }

    @GetMapping("viewville/{id}")
    public String viewVille(@PathVariable("id") int id,Model model){
        List<Quartier> quartier = quartierRepository.findByVilleId(id);
        model.addAttribute ("quartier", quartier);
        return "city"; }



    public void updateVille(@PathVariable("id")int id,
                            @PathVariable("nomVille")String nomVille,
                            @PathVariable("hauteur")int hauteur,
                            @PathVariable("largeur")int largeur,
                            @PathVariable("valeurMin")int valeurMin,
                            @PathVariable("valeurMax")int valeurMax,
                            @Valid Ville ville, BindingResult result, Model model) {
        ville.setNomVille(nomVille);
        ville.setHauteur(hauteur);
        ville.setLargeur(largeur);
        ville.setValeurMin(valeurMin);
        ville.setValeurMax(valeurMax);
        villeRepository.save(ville);

    }

    @GetMapping("generate/{id}")
    public String generate(@PathVariable("id") int id,Model model){
        Ville ville = villeRepository.findById (id).

                orElseThrow (()-> new IllegalArgumentException ("Id ville invalide: "+ id));
        model.addAttribute ("ville", ville);
        return "generate"; }
}


