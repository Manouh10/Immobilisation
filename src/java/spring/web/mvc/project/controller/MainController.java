 
package spring.web.mvc.project.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;
import spring.web.mvc.project.model.Employe;
import spring.web.mvc.project.service.EmployeService; 
import spring.web.mvc.project.model.Article;
import spring.web.mvc.project.model.Immobilisation;
import spring.web.mvc.project.model.Responsable; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.RequestParam;
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
    public String listInfo() throws Exception{ 
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
    public String updateService(@RequestParam("id") int id) throws Exception{  
        Immobilisation i=new Immobilisation();
        i.setId(id);
        immoService.updateService(i);
        return  "redirect:newImmo";
    }
    
    @RequestMapping(value="insertImmo",method=RequestMethod.POST)
    public String insertImmo(@ModelAttribute Immobilisation i) throws Exception{  
        immoService.insertImmo(i);
        return "redirect:newImmo";
    }  
     
}