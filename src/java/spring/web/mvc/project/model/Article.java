
package spring.web.mvc.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
 
@Entity
@Table(name="article")
public class Article extends BaseModel{
   
    
    @Column(name="nom_artcile")
    private String nom_artcile;

    public Article() {
    }

    public String getNom_artcile() {
        return nom_artcile;
    }

    public void setNom_artcile(String nom_artcile) {
        this.nom_artcile = nom_artcile;
    }

    
     
}
