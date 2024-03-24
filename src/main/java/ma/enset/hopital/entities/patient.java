package ma.enset.hopital.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder

public class patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    @DateTimeFormat (pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    private boolean malade;
    private int score;
}
