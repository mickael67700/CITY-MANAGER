package CITY.MANAGER.entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="QUARTIER")
public class Quartier_version2 implements Serializable {
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

    @Column(name = "INFLUENCE",length =10,nullable = true)
    private int influence;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})

    private Ville ville;
   

    public int getIdQuartier() {
        return id;
    }

    public int getValeur() {
    	return valeur;
    }

    public int getAbscisse() {
        return abscisse;
    }
 
    public int getOrdonnee() {
        return ordonnee;
    }
    
    public String getTypeQuartier() {
        return typeQuartier;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public int getId() { 
    	return id; 
    }

    public int getInfluence() {
    	return influence; 
    }
    
     public Ville getVille() {
        return ville;
    }
    
     
     /**
      * une fois la classe initialisée on lui ajoute une ville puis une coordonnée
      * ex: new QuartierVersion2()._setVille(new Ville())._setAbscisse(1)
      * @param ville
      * @return
      */ 
    public Quartier_version2 _setAbscisse(int abscisse) {
        this.abscisse = abscisse;
		return this;
    }

    public Quartier_version2 _setOrdonnee(int ordonnee) {
        this.ordonnee = ordonnee;
		return this;
    }

    public Quartier_version2 _setTypeQuartier(String typeQuartier) {
        this.typeQuartier = typeQuartier;
		return this;
    }

    
    public Quartier_version2 _setInfluence(int influence) { 
    	this.influence = influence;
		return this; 
    }

    /**
     * une fois la classe initialisée on lui ajoute une ville
     * ex: new QuartierVersion2()._setVille(new Ville())
     * @param ville
     * @return
     */
    public Quartier_version2 _setVille(Ville ville) {
        this.ville = ville;
		return this;
    }

    /**
     * ici on a une simple initialisation de la classe
     */
    public Quartier_version2() {
    	super();
    }

}

