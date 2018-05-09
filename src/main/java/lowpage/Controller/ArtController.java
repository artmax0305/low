package lowpage.Controller;

import lowpage.model.User;
import lowpage.service.ArtService;
import lowpage.model.Article;
import lowpage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class ArtController {
    @Autowired
    private ArtService artService;
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String mainPage(Model model){
        model.addAttribute("articles",artService.getAll());
        return "main";
    }
    @RequestMapping("/add")
    public String articelPage(Model model){
        model.addAttribute("article", new Article());
        return "editor";
    }
    @RequestMapping(value = "/add/submit",method = RequestMethod.POST)
    public String submit(@ModelAttribute Article article){
        artService.save(article);
        return "redirect:/";
    }
    @RequestMapping(value = "/login")
    public String loginPage(){
        return "login";
    }
    @RequestMapping(value = "register")
    public String regPage(Model model){
        model.addAttribute("userForm",new User());
        return "registration";
    }
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String regPage(@ModelAttribute("userForm")User userForm, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "registration";
        }
        userService.save(userForm);

        return "redirect:/";
    }
}
