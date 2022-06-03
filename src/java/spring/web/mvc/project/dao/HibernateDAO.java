 
package spring.web.mvc.project.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import spring.web.mvc.project.model.BaseModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import spring.web.mvc.project.model.Immobilisation; 
import org.hibernate.SQLQuery;
 
public class HibernateDAO{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

   
    public void insert(BaseModel baseModel) throws Exception{
        Session session = null;
        Transaction transaction =  null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(baseModel);
            transaction.commit();
            //System.out.println("Saved!");
        }catch(Exception e){
            if(transaction!=null)
                transaction.rollback();
            throw e;
        }finally{
            if(session!=null)
                session.close();
        }
    }
    
   
    public List find(BaseModel model) throws Exception{
        Session session = null;
        Transaction transaction =  null;
        List<BaseModel> list= new ArrayList<BaseModel>();
        List result = new ArrayList();
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Example example = Example.create(model).enableLike().excludeZeroes().ignoreCase();
            Criteria cr=session.createCriteria(model.getClass()).add(example);
            result=cr.list();
            transaction.commit();
            return result;
        }catch(Exception e){
            if(transaction!=null)
                transaction.rollback();
            throw e;
        }finally{
            if(session!=null)
                session.close();
        }
    }
    
    public BaseModel findById(BaseModel model,int id) throws Exception{
    Session session = null;
        Transaction transaction =  null;
        BaseModel bm= new BaseModel(); 
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            bm = model.getClass().cast(session.get(model.getClass(),id)); 
            Hibernate.initialize(bm);
            transaction.commit();
            return bm;
        }catch(Exception e){
            if(transaction!=null)
                transaction.rollback();
            throw e;
        }finally{
            if(session!=null)
                session.close();
        }
    }
    
   public void updateService(Immobilisation immo )  {
    Transaction transaction = null; 
    Session session = null;
    int result=0;
    try {
        String sqlQuery = "update immobilisation set date_service='"+immo.getDate_service()+"' WHERE id="+immo.getId()+" "; 
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        SQLQuery query = session.createSQLQuery(sqlQuery);
        result = query.executeUpdate();
        transaction.commit();

    } catch (Exception ex) {
        ex.printStackTrace();
        if (transaction != null) {
            transaction.rollback();
        }
    } 
}
}
   
