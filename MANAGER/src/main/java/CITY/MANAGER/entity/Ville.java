package CITY.MANAGER.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "VILLE")
public class Ville implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private int id;

    @Column(unique = true,name = "NOM_VILLE", length = 64, nullable = false)
    private String nomVille;

    @Column(name = "VALEUR_MIN", length = 64, nullable = false)
    private int valeurMin;

    @Column(name = "VALEUR_MAX", length = 64, nullable = false)
    private int valeurMax;

    @Column(name = "LARGEUR", length = 64, nullable = false)
    private int largeur;

    @Column(name = "HAUTEUR", length = 64, nullable = false)
    private int hauteur;

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

    public Collection<Quartier> getQuartiers() {
        return quartiers;
    }

    public void setQuartiers(Collection<Quartier> quartiers) {
        this.quartiers = quartiers;
    }


    public Ville() {
        super();
    }

    /* L'attribut[fetch=FetchType.LAZY] indique que lorsqu'on demande une entité [Quartier] au contexte de persistance et que celle-ci doit être cherchée
    dans la base de données, alors l'entité [Ville] n'est pas ramenée avec elle. L'intérêt de ce mode est
    que l'entité [Ville] n'est cherchée que si on le demande. On économise ainsi la mémoire et on gagne enperformances  */
    @OneToMany(mappedBy = "ville", fetch = FetchType.LAZY)
    private Collection<Quartier> quartiers;

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

    public Ville(String nomVille, int valeurMin, int valeurMax, int largeur, int hauteur) {
        this.nomVille = nomVille;
        this.valeurMin = valeurMin;
        this.valeurMax = valeurMax;
        this.largeur = largeur;
        this.hauteur = hauteur;

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

