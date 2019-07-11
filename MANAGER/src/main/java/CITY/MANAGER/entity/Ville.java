package CITY.MANAGER.entity;

import org.springframework.web.bind.annotation.RequestParam;
import org.ujmp.core.collections.list.ArrayIndexList;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import CITY.MANAGER.entity.Quartier;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import CITY.MANAGER.entity.Quartier;
import CITY.MANAGER.controller.QuartierController;
@Entity
@Table(name = "VILLE")
public class Ville implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private int id;

    public List<Quartier> getQuartiers() {
        return quartiers;
    }

    public void setQuartiers(List<Quartier> quartiers) {
        this.quartiers = quartiers;
    }

    @OneToMany
    private List<Quartier> quartiers;


    @Column(unique = true, name = "NOM_VILLE", length = 64, nullable = true)
    private String nomVille;

    @Column(name = "VALEUR_MIN", length = 64, nullable = true)
    private int valeurMin;
    @Column(name = "VALEUR_MAX", length = 64, nullable = true)
    private int valeurMax;

    @Column(name = "LARGEUR", length = 64, nullable = true)
    private int largeur;
    @Column(name = "HAUTEUR", length = 64, nullable = true)
    private int hauteur;

    //distance max d'interaction sur le prix
    @Column(name = "RIV_DMAX", length = 5, nullable = true)
    private float rivDmax;
    //Pourcentage max
    @Column(name = "RIV_PMAX", length = 5, nullable = true)
    private float rivPmax;

    @Column(name = "FOR_DMAX", length = 5, nullable = true)
    private float forDmax;
    @Column(name = "FOR_PMAX", length = 5, nullable = true)
    private float forPmax;

    @Column(name = "ECL_DMAX", length = 5, nullable = true)
    private float eclDmax;
    @Column(name = "ECL_PMAX", length = 5, nullable = true)
    private float eclPmax;

    @Column(name = "EGL_DMAX", length = 5, nullable = true)
    private float eglDmax;
    @Column(name = "EGL_PMAX", length = 5, nullable = true)
    private float eglPmax;

    @Column(name = "COM_DMAX", length = 5, nullable = true)
    private float comDmax;
    @Column(name = "COM_PMAX", length = 5, nullable = true)
    private float comPmax;

    @Column(name = "POL_DMAX", length = 5, nullable = true)
    private float polDmax;
    @Column(name = "POL_PMAX", length = 5, nullable = true)
    private float polPmax;

    @Column(name = "RTB_DMAX", length = 5, nullable = true)
    private float rtbDmax;
    @Column(name = "RTB_PMAX", length = 5, nullable = true)


    private float rtbPmax;

    public int getValeurMin() {
        return valeurMin;
    }

    public void setValeurMin(int valeurMin) {
        this.valeurMin = valeurMin;
    }

    public int getValeurMax() {
        return valeurMax;
    }

    public void setValeurMax(int valeurMax) {
        this.valeurMax = valeurMax;
    }





    public Ville() {
        super ();
    }

    /* L'attribut[fetch=FetchType.LAZY] indique que lorsqu'on demande une entité [Quartier] au contexte de persistance et que celle-ci doit être cherchée
    dans la base de données, alors l'entité [Ville] n'est pas ramenée avec elle. L'intérêt de ce mode est
    que l'entité [Ville] n'est cherchée que si on le demande. On économise ainsi la mémoire et on gagne enperformances  */

    public int getId() {
        return id;
    }

    public void setId(int idVille) {
        this.id = id;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public float getRivDmax() {
        return rivDmax;
    }

    public void setRivDmax(float rivDmax) { this.rivDmax = rivDmax; }

    public float getRivPmax() { return rivPmax; }

    public void setRivPmax(float rivPmax) { this.rivPmax = rivPmax; }

    public float getForDmax() { return forDmax; }

    public void setForDmax(float forDmax) { this.forDmax = forDmax; }

    public float getForPmax() { return forPmax; }

    public void setForPmax(float forPmax) { this.forPmax = forPmax; }

    public float getEclDmax() { return eclDmax; }

    public void setEclDmax(float eclDmax) { this.eclDmax = eclDmax; }

    public float getEclPmax() { return eclPmax; }

    public void setEclPmax(float eclPmax) { this.eclPmax = eclPmax; }

    public float getEglDmax() { return eglDmax; }

    public void setEglDmax(float eglDmax) { this.eglDmax = eglDmax; }

    public float getEglPmax() { return eglPmax; }

    public void setEglPmax(float eglPmax) { this.eglPmax = eglPmax; }

    public float getComDmax() { return comDmax; }

    public void setComDmax(float comDmax) { this.comDmax = comDmax; }

    public float getComPmax() { return comPmax; }

    public void setComPmax(float comPmax) { this.comPmax = comPmax; }

    public float getPolDmax() { return polDmax; }

    public void setPolDmax(float polDmax) { this.polDmax = polDmax; }

    public float getPolPmax() { return polPmax; }

    public void setPolPmax(float polPmax) { this.polPmax = polPmax; }

    public float getRtbDmax() { return rtbDmax; }

    public void setRtbDmax(float rtbDmax) { this.rtbDmax = rtbDmax; }

    public float getRtbPmax() { return rtbPmax; }

    public void setRtbPmax(float rtbPmax) { this.rtbPmax = rtbPmax; }

    public Ville(String nomVille, int valeurMin, int valeurMax, int largeur, int hauteur) {
        this.nomVille = nomVille;
        this.valeurMin = valeurMin;
        this.valeurMax = valeurMax;
        this.largeur = largeur;
        this.hauteur = hauteur;

    }


    public Ville(String nomVille, int valeurMin, int valeurMax, int largeur, int hauteur, Quartier quartier) {
        this.nomVille = nomVille;
        this.valeurMin = valeurMin;
        this.valeurMax = valeurMax;
        this.largeur = largeur;
        this.hauteur = hauteur;
    }
    public Ville(@RequestParam String nomVille, @RequestParam int valeurMin, @RequestParam int valeurMax, @RequestParam int largeur, @RequestParam int hauteur,
                 @RequestParam float rivDmax, @RequestParam float rivPmax, @RequestParam float forDmax,
                 @RequestParam float forPmax, @RequestParam float eclDmax, @RequestParam float eclPmax, @RequestParam float eglDmax,
                 float eglPmax, @RequestParam float comDmax, @RequestParam float comPmax, @RequestParam float polDmax,
                 @RequestParam float polPmax, @RequestParam float rtbDmax, @RequestParam float rtbPmax, List<Quartier>quartiers
    ) {
        this.nomVille = nomVille;
        this.valeurMin = valeurMin;
        this.valeurMax = valeurMax;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.rivDmax = rivDmax;
        this.rivPmax = rivPmax;
        this.forDmax = forDmax;
        this.forPmax = forPmax;
        this.eclDmax = eclDmax;
        this.eclPmax = eclPmax;
        this.eglDmax = eglDmax;
        this.eglPmax = eglPmax;
        this.comDmax = comDmax;
        this.comPmax = comPmax;
        this.polDmax = polDmax;
        this.polPmax = polPmax;
        this.rtbDmax = rtbDmax;
        this.rtbPmax = rtbPmax;
    }

    @Override
    public String toString() {
        return "Ville{" +
                "nomVille='" + nomVille + '\'' +
                ", valeurMin=" + valeurMin +
                ", valeurMax=" + valeurMax +
                ", largeur=" + largeur +
                ", hauteur=" + hauteur +

                '}';
    }


}