package ma.enset.hopital.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import lombok.AllArgsConstructor;
import ma.enset.hopital.entities.patient;
import ma.enset.hopital.repository.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository;

    @GetMapping("/index")

    public String index(Model model, @RequestParam(name = "page" , defaultValue = "0" ) int page,
                                     @RequestParam(name = "size" , defaultValue = "4" ) int size){
        Page<patient> patientPage = patientRepository.findAll(PageRequest.of(page, size));
        model.addAttribute("listPatients", patientPage.getContent());
        model.addAttribute("pages", new int[patientPage.getTotalPages()]);
        model.addAttribute("currentPage", page);
        return "patient";
    }

}
