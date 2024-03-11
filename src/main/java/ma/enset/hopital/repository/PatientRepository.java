package ma.enset.hopital.repository;

import ma.enset.hopital.entities.patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<patient, Long> {

}