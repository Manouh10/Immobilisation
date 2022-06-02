
package spring.web.mvc.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
 
@Entity
@Table(name="employe")
public class Employe extends BaseModel{
    
    @Column(name="nom")
    private String nom;
    
    @Column(name="prenom")
    private String prenom;

    public Employe() {
    }

    
    
    public Employe(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    } 
}
