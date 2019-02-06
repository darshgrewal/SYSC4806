package Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

    @Autowired
    BuddyInfoRepository br;

    @GetMapping("/hello")
    public String homePage(Model model){
        model.addAttribute("buddies", br.findAll());
        System.out.println("Hello"+br.findAll());
        return "index";
    }
}
