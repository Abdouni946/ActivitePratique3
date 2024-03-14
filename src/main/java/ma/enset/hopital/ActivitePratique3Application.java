package ma.enset.hopital;

import ma.enset.hopital.entities.patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ma.enset.hopital.repository.PatientRepository;

import java.util.Date;

@SpringBootApplication
public class ActivitePratique3Application implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository ;

    public static void main(String[] args)  {
        SpringApplication.run(ActivitePratique3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new patient(null,"zakariae","abdouni",new Date(),false,15));
        patientRepository.save(new patient(null,"mohammed","ahram",new Date(),true,10));
        patientRepository.save(new patient(null,"zineb","ahlam",new Date(),true,19));
    }
}
