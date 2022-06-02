 
package spring.web.mvc.project.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.web.mvc.project.dao.HibernateDAO;
import spring.web.mvc.project.model.Responsable;
 
@Service
public class ResponsableService {
    
    @Autowired
    private HibernateDAO hibernateDao;
    
    public List<Responsable> getAllResponsable() throws Exception{
        Responsable r= new Responsable();
       return hibernateDao.find(r);
    }
}
