  package spring.web.mvc.project.service;

import java.util.List;
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
}
