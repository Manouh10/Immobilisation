
package spring.web.mvc.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
 
@Entity
@Table(name="responsable")
public class Responsable extends BaseModel{
    
     
    
    @Column(name="nom_responsable")
    private String nom_responsable;

    public Responsable() {
    }

    public Responsable( String nom_responsable) {
        
        this.nom_responsable = nom_responsable;
    }

     

    public String getNom_responsable() {
        return nom_responsable;
    }

    public void setNom_responsable(String nom_responsable) {
        this.nom_responsable = nom_responsable;
    }

    
    
   
}
