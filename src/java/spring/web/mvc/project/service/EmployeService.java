 
package spring.web.mvc.project.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.web.mvc.project.dao.HibernateDAO;
import spring.web.mvc.project.model.Employe;
 
@Service
public class EmployeService {
    
    @Autowired
    private HibernateDAO hibernateDao;
    
    public void insertEmploye(Employe employe) throws Exception{
        hibernateDao.insert(employe);
    }
}
