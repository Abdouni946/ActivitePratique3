package ma.enset.hopital.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("notAuthorized")
    String notAuthorized(){
        return "notAuthorized";
    }
}
