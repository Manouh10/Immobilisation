package spring.web.mvc.project.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.web.mvc.project.dao.HibernateDAO; 
import spring.web.mvc.project.model.Immobilisation;
import spring.web.mvc.project.model.Tableau;
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
    
    public ViewImmo findById(ViewImmo vi,int id)throws Exception
    {
        ViewImmo immo= new ViewImmo();
        immo=(ViewImmo)hibernateDao.findById(vi,id);
        return immo;
    }
    
    public void updateService(Immobilisation immo)
    {
        hibernateDao.updateService(immo);
    }
    public static int getJourRestant(int i,int duree_amortissement)
    { 
        Long retour=Long.valueOf(0);
        Date dateDebut = new Date(2022,01,01);
        Date dateFin = new Date(2022,06,07);
        Long dateDebutMin = dateDebut.getTime();
        Long dateFinMin = dateFin.getTime();
        Long timeDiff = Math.abs(dateFinMin - dateDebutMin); 
        Long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
        if(i==0)
        { 
        retour=daysDiff;
        }
        else if(i==duree_amortissement)
        { 
        retour=360-daysDiff;
        }
        else{
            retour=Long.valueOf(360);
        } 
       return retour.intValue();
    }
    
    public static int getExercice(int PA,int duree_amortissement,int jour)
    {
        return ((PA*jour)/(360*duree_amortissement));
    } 
    public static List<Tableau> getJourRestant_Exercice(ViewImmo immo)
    {
        List<Tableau> list= new ArrayList<Tableau>();
        for(int i=0;i<immo.getDuree_ammortissement()+1;i++)
        {
            Tableau t= new Tableau();
            t.setJour(getJourRestant(i,immo.getDuree_ammortissement()));
            t.setExercice(getExercice(immo.getPrix_aquisation(),immo.getDuree_ammortissement(),t.getJour())); 
            list.add(t);
        }
        return list;
    }
    public static List<Tableau> getAnterieure_Cumul(ViewImmo immo)
    {
        List<Tableau> listExercice= getJourRestant_Exercice(immo);
        for(int i=0;i<listExercice.size();i++)
        {
            if(i==0)
            {
                listExercice.get(i).setAnterieure(0);
                listExercice.get(i).setCumul(listExercice.get(i).getAnterieure()+listExercice.get(i).getExercice());
            }
            else if(i==listExercice.size()-1)
            {
                 listExercice.get(i).setAnterieure(listExercice.get(i-1).getCumul());
               listExercice.get(i).setCumul(immo.getPrix_aquisation());
            }
            else{
                listExercice.get(i).setAnterieure(listExercice.get(i-1).getCumul());
               listExercice.get(i).setCumul(listExercice.get(i).getAnterieure()+listExercice.get(i).getExercice());
            } 
        }
        return listExercice;
    }
    public  static List<Tableau> getTableau_amortissement(ViewImmo immo)
    {
        List<Tableau>list= getAnterieure_Cumul(immo);
        for(int i=0;i<list.size();i++)
        {
            if(i==list.size()-1)
            {
                list.get(i).setVnc(0);
            }
            else{
            list.get(i).setVnc(immo.getPrix_aquisation()-list.get(i).getCumul());
            }
        }
        return list;
    }
         public static String showDate(Date d)
    {
        String date_to_string=d.toString();
        return date_to_string.split(" ")[0];
    }     
    public static String nullToString(Date date_service)
    {
        String retour=null;
        
        if(date_service==null)
        {
            retour="No service";
        }
        else
        {
            retour = showDate(date_service);
        }
        return retour;
    }
  
}
