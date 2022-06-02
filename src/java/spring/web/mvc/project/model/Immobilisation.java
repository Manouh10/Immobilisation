
package spring.web.mvc.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
 
@Entity
@Table(name="immobilisation")
public class Immobilisation extends BaseModel{
    
    @Column(name="nom")
    private String nom; 
    
    @Column(name="article")
    private int article;
    
    @Column(name="prix_aquisation")
    private int prix_aquisation;
            
    @Column(name="date_achat")
    private String date_achat;
            
    @Column(name="date_service")    
    private String date_service;
    
    @Column(name="responsable")  
    private int responsable;
    
    @Column(name="duree_ammortissement")  
    private int duree_ammortissement;

    public Immobilisation() {
    }

    public Immobilisation(String nom, int article, int prix_aquisation, String date_achat, String date_service, int responsable, int duree_ammortissement) {
        this.nom = nom;
        this.article = article;
        this.prix_aquisation = prix_aquisation;
        this.date_achat = date_achat;
        this.date_service = date_service;
        this.responsable = responsable;
        this.duree_ammortissement = duree_ammortissement;
    }

    
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    

    public int getArticle() {
        return article;
    }

    public void setArticle(int article) {
        this.article = article;
    }

    public int getPrix_aquisation() {
        return prix_aquisation;
    }

    public void setPrix_aquisation(int prix_aquisation) {
        this.prix_aquisation = prix_aquisation;
    }

    public String getDate_achat() {
        return date_achat;
    }

    public void setDate_achat(String date_achat) {
        this.date_achat = date_achat;
    }

    public String getDate_service() {
        return date_service;
    }

    public void setDate_service(String date_service) {
        this.date_service = date_service;
    }

    public int getResponsable() {
        return responsable;
    }

    public void setResponsable(int responsable) {
        this.responsable = responsable;
    }

    public int getDuree_ammortissement() {
        return duree_ammortissement;
    }

    public void setDuree_ammortissement(int duree_ammortissement) {
        this.duree_ammortissement = duree_ammortissement;
    }
    
    
    
   
}
