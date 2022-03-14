package cep.gouv.ht.Repository;


import cep.gouv.ht.Models.Candidatee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidatee, Long> {

    @Query("SELECT new Candidatee(o) FROM Candidatee o ")
    List<Candidatee> getCandidatWithoutImage();
}
