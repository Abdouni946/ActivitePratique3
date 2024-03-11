package ma.enset.hopital.web;

import org.springframework.ui.Model;
import lombok.AllArgsConstructor;
import ma.enset.hopital.entities.patient;
import ma.enset.hopital.repository.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository;

    @GetMapping("/index")

    public String index( Model model){
        List<patient> patientList = patientRepository.findAll();
        model.addAttribute("listPatients", patientList);

        return "patient";
    }

}
