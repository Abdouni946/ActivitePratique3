package ma.enset.hopital.web;

import jakarta.validation.Valid;
import lombok.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import lombok.AllArgsConstructor;
import ma.enset.hopital.entities.patient;
import ma.enset.hopital.repository.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model, @RequestParam(name = "page" , defaultValue = "0" ) int page,
                                     @RequestParam(name = "size" , defaultValue = "4" ) int size,
                                     @RequestParam(name = "keyword" , defaultValue = "" ) String kw){

        Page<patient> patientPage = patientRepository.findByNomContains(kw,PageRequest.of(page,size));
        model.addAttribute("listPatients", patientPage.getContent());
        model.addAttribute("pages", new int[patientPage.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword",kw);
        return "patient";
    }

    @GetMapping("/delete")
    public String delete(Long id, String keyword, int page ){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword ;
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }

    @GetMapping("/formPatient")
    public String formPatient(Model model){
        model.addAttribute("patient", new patient());
        return "formPatient";
    }

    @PostMapping("/save")
    public String save(Model model, @Valid patient Patient, BindingResult bindingResult,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String keyword){
        if(bindingResult.hasErrors())
            return "formPatient";
        patientRepository.save(Patient);
            return "redirect:/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/editPatient")
    public String editPatient(Model model, Long id, int page, String keyword){
       patient Patient = patientRepository.findById(id).orElse(null);
       if(Patient==null) throw new RuntimeException("Patient not found");
       model.addAttribute("patient", Patient);
        model.addAttribute("page", page);
        model.addAttribute("keyword", keyword);
        return "editPatient";
    }
}
