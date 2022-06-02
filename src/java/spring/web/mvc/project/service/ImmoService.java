  package spring.web.mvc.project.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.web.mvc.project.dao.HibernateDAO; 
import spring.web.mvc.project.model.Immobilisation;
import spring.web.mvc.project.model.ViewImmo;
 
@Service
public class ImmoService {
    
    @Autowired
    private HibernateDAO hibernateDao;
    
    public void insertImmo(Immobilisation i) throws Exception{ 
        hibernateDao.insert(i);
    }
    
    public List<ViewImmo> getAllImmo() throws Exception{
        ViewImmo i= new ViewImmo();
       return hibernateDao.find(i);
    }
    
    public ViewImmo findById(ViewImmo immo,int id)throws Exception{ 
        ViewImmo vi= new ViewImmo();
      vi= (ViewImmo) hibernateDao.findById(immo,id);
      return vi;
    }
    
    public void updateService(Immobilisation immo)
    {
        hibernateDao.updateService(immo);
    }
    
    public static String nullToString(String date_service)
    {
        String retour=null;
        if(date_service==null)
        {
            retour="No service";
        }
        else
        {
            retour = date_service;
        }
        return retour;
    }
    public float prorata(int prixAcqui,int dureAmortisement,int jourRest){
        float valiny=(prixAcqui*jourRest)/(dureAmortisement*360);
        return valiny;
    }
    public static Long jourRest(){
        Date datedebut=new Date(2022,01,01);
        Date datefin=new Date(2022,06,07);
        Long datemin=datedebut.getTime();
        Long datefinmin=datefin.getTime();
        
        Long dateDiff=Math.abs(datemin-datefinmin);
        Long daysDiff=TimeUnit.DAYS.convert(dateDiff, TimeUnit.MILLISECONDS);
        
        return daysDiff;
    }
}
