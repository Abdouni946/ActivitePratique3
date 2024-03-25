package ma.enset.hopital;

import ma.enset.hopital.entities.patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ma.enset.hopital.repository.PatientRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class ActivitePratique3Application implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository ;

    public static void main(String[] args)  {
        SpringApplication.run(ActivitePratique3Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new patient(null,"zakariae","abdouni",new Date(),false,150));
            patientRepository.save(new patient(null,"mohammed","ahram",new Date(),true,100));
            patientRepository.save(new patient(null,"zineb","ahlam",new Date(),true,190));
        };
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.findAll().forEach(p -> {
            System.out.println(p.getNom());
        });
    }

    @Bean
     PasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
     }

}
