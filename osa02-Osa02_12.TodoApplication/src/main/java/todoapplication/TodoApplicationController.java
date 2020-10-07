package todoapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TodoApplicationController {
   
    @Autowired
    private ToDoChoreRepository cr;
    
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("items", cr.findAll());
        return "index";
    }
    
    @GetMapping("/{id}")
    public String oneItem(Model model, @PathVariable Long id){
        ToDoChore chore = cr.getOne(id);
        chore.setC(chore.getC()+1);
        cr.save(chore);
        model.addAttribute("item", chore);
        return "todo";
    }
    
    @PostMapping("/")
    public String newTD(@RequestParam String name){
        cr.save(new ToDoChore(name,0));
        return "redirect:/";
    }
    

}
