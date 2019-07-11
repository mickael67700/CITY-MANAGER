package CITY.MANAGER.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.dom4j.tree.AbstractEntity;
import org.elasticsearch.common.recycler.Recycler;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="QUARTIER")
public class Quartier  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name="VILLE_ID")
    public Ville ville ;

    @Column(name = "TYPE_QUARTIER", length = 64, nullable = true)
    public String typeQuartier;


    @Column(name = "VALEUR", length = 10, nullable = true)
    public int valeur;

    @Column(name = "X", length = 10, nullable = true)
    public int abscisse;

    @Column(name = "Y", length = 10, nullable = true)
    public int ordonnee;

    @Column(name = "INFLUENCE_MAX", length = 10, nullable = true)
    public int influence;

    @Column(name = "ZONE_INFLUENCE", length = 5, nullable = true)
    public int zoneInfluence;

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public Quartier(String rte, int i, int x, int y, int i1, int i2, Ville ville) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  String getTypeQuartier() {
        return typeQuartier;
    }

    public void setTypeQuartier(String typeQuartier) {
        this.typeQuartier = typeQuartier;
    }

    public  int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public  int getAbscisse() {
        return abscisse;
    }

    public  void setAbscisse(int abscisse) {
        this.abscisse = abscisse;
    }

    public int getOrdonnee() {
        return ordonnee;
    }

    public  void setOrdonnee(int ordonnee) {
        this.ordonnee = ordonnee;
    }

    public  int getInfluence() {
        return influence;
    }

    public void setInfluence(int influence) {
        this.influence = influence;
    }

    public  float getZoneInfluence() {
        return zoneInfluence;
    }

    public void setZoneInfluence(int zoneInfluence) {
        this.zoneInfluence = zoneInfluence;
    }



    public Quartier(){}
    public Quartier(String typeQuartier, int valeur, int abscisse, int ordonnee, int influence, int zoneInfluence) {
        this.typeQuartier = typeQuartier;
        this.valeur = valeur;
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
        this.influence = influence;
        this.zoneInfluence = zoneInfluence;
    }
    public Quartier(String typeQuartier, int abscisse, int ordonnee, int influence) {
        this.typeQuartier = typeQuartier;
        this.valeur = 0;
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
        this.influence = influence;
        this.zoneInfluence = 0;

    }
    public Quartier(String typeQuartier, int abscisse, int ordonnee, Ville ville){
        this.typeQuartier = typeQuartier;
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }
    @Override
    public String toString() {
        return typeQuartier;
    }

}


