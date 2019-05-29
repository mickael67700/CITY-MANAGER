package CITY.MANAGER.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name="QUARTIER")
public class Quartier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private int id;

    @Column(name = "TYPE_QUARTIER", length = 64, nullable = false)
    private String typeQuartier;


    @Column(name="VALEUR",length = 64, nullable = true)
    private int valeur;

    @Column(name = "X",length = 10, nullable = false)
    private int abscisse;

    @Column(name = "Y",length = 10, nullable = false)
    private int ordonnee;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})

    private Ville ville;
    public Quartier(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public int getAbscisse() {
        return abscisse;
    }

    public void setAbscisse(int abscisse) {
        this.abscisse = abscisse;
    }

    public int getOrdonnee() {
        return ordonnee;
    }

    public void setOrdonnee(int ordonnee) {
        this.ordonnee = ordonnee;
    }

    public String getTypeQuartier() {
        return typeQuartier;
    }

    public void setTypeQuartier(String typeQuartier) {
        this.typeQuartier = typeQuartier;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public Quartier(String typeQuartier, int valeur, int abscisse, int ordonnee, Ville ville) {
        this.typeQuartier = typeQuartier;
        this.valeur = valeur;
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
        this.ville = ville;
    }
}
