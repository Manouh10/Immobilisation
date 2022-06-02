 
package spring.web.mvc.project.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.web.mvc.project.dao.HibernateDAO;
import spring.web.mvc.project.model.Article;
 
@Service
public class ArticleService {
    
    @Autowired
    private HibernateDAO hibernateDao;
    
    public List<Article> getAllArticle() throws Exception{
        Article article= new Article();
       return hibernateDao.find(article);
    }
}
