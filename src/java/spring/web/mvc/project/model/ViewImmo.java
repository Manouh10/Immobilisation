 
package spring.web.mvc.project.model;
  
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
 import java.util.Date;
import spring.web.mvc.project.model.BaseModel;
 
@Entity
@Table(name="viewImmo")
public class ViewImmo extends BaseModel{
    @Column(name="nom")
    private String nom; 
    
    @Column(name="nom_artcile")
    private String nom_artcile;
    
    @Column(name="prix_aquisation")
    private int prix_aquisation;
            
    @Column(name="date_achat")
    private Date  date_achat;
            
    @Column(name="date_service")    
    private Date date_service;
    
    @Column(name="nom_responsable")  
    private String nom_responsable;
    
    @Column(name="duree_ammortissement")  
    private int duree_ammortissement;

    public ViewImmo(String nom, String nom_artcile, int prix_aquisation, Date date_achat, Date date_service, String nom_responsable, int duree_ammortissement) {
        this.nom = nom;
        this.nom_artcile = nom_artcile;
        this.prix_aquisation = prix_aquisation;
        this.date_achat = date_achat;
        this.date_service = date_service;
        this.nom_responsable = nom_responsable;
        this.duree_ammortissement = duree_ammortissement;
    }

    

    public ViewImmo() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom_artcile() {
        return nom_artcile;
    }

    public void setNom_artcile(String nom_artcile) {
        this.nom_artcile = nom_artcile;
    } 
    public int getPrix_aquisation() {
        return prix_aquisation;
    }

    public void setPrix_aquisation(int prix_aquisation) {
        this.prix_aquisation = prix_aquisation;
    }

    public Date getDate_achat() {
        return date_achat;
    }

    public void setDate_achat(Date date_achat) {
        this.date_achat = date_achat;
    }

    public Date getDate_service() {
        return date_service;
    }

    public void setDate_service(Date date_service) {
        this.date_service = date_service;
    }

   

    public String getNom_responsable() {
        return nom_responsable;
    }

    public void setNom_responsable(String nom_responsable) {
        this.nom_responsable = nom_responsable;
    }

    public int getDuree_ammortissement() {
        return duree_ammortissement;
    }

    public void setDuree_ammortissement(int duree_ammortissement) {
        this.duree_ammortissement = duree_ammortissement;
    }

  

    
}
