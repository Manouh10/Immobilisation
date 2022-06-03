 
package spring.web.mvc.project.controller;

import com.lowagie.text.DocumentException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;
import spring.web.mvc.project.model.ViewImmo;
import spring.web.mvc.project.service.EmployeService; 
import spring.web.mvc.project.model.Article;
import spring.web.mvc.project.model.Immobilisation;
import spring.web.mvc.project.model.Responsable; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.RequestParam;
import spring.web.mvc.project.model.PDFGenerator;
 import spring.web.mvc.project.service.ArticleService; 
import spring.web.mvc.project.service.ImmoService;
import spring.web.mvc.project.service.ResponsableService;

@Controller
public class MainController {
    
    @Autowired
    private EmployeService employeService;
    
    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private ImmoService immoService;
    
    @Autowired
    private ResponsableService responsableService; 
    
    @RequestMapping(value="/")
    public String index() throws Exception{ 
        return "index";
    }
    
    @RequestMapping(value="listInfo",method=RequestMethod.GET)
    public String listInfo(Model m,@RequestParam("id") int id) throws Exception{ 
        ViewImmo immo=new ViewImmo();
        ViewImmo i= immoService.findById(immo,id); 
        m.addAttribute("singleImmo",i);
       // m.addAttribute("daty",ImmoService.getJourRestant());
        return "listInfo";
    }
    
    @RequestMapping(value="forms",method=RequestMethod.GET)
    public String forms() throws Exception{ 
        return "forms";
    } 
    
    @RequestMapping(value="newImmo",method=RequestMethod.GET)
    public String newImmo(Model m) throws Exception{           
        m.addAttribute("listArticle",articleService.getAllArticle());
        m.addAttribute("listResponsable",responsableService.getAllResponsable());
        m.addAttribute("listImmobilisation",immoService.getAllImmo()); 
        return  "listImmo";
    }
    
    @RequestMapping(value="updateService",method=RequestMethod.GET)
    public String updateService(@RequestParam("id") int id,Model m) throws Exception{  
        Immobilisation i=new Immobilisation();
        i.setId(id);
        ViewImmo immo=new ViewImmo();
        ViewImmo singleImmo= immoService.findById(immo,id); 
         m.addAttribute("singleImmo",singleImmo);
        //immoService.updateService(i);
        return  "miseEnService";
    }
    
    @RequestMapping(value="updateDate_service",method=RequestMethod.POST)
    public String updateDate_service(@RequestParam("id") int id,@RequestParam("date_service") String date_service) throws Exception{  
        Immobilisation im= new Immobilisation();
        im.setId(id); im.setDate_service(date_service);
        immoService.updateService(im);
        return  "redirect:newImmo";
    }
    
    @RequestMapping(value="insertImmob",method=RequestMethod.POST)
    public String insertImmo(@ModelAttribute Immobilisation i) throws Exception{  
        //System.out.println(i.getNom());
       immoService.insertImmo(i);
        return "redirect:newImmo";
    }   
    
    @RequestMapping(value="exportPdf",method=RequestMethod.GET)
    public void generatePdf(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
      //  String currentDateTime = dateFormat.format(new Date());
        String headerkey = "Content-Disposition";
        //String headervalue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        String headervalue = "attachment; filename=pdf_TEST.pdf";
        response.setHeader(headerkey, headervalue);  
        PDFGenerator generator = new PDFGenerator();  
        generator.generate(response);
}
     
}