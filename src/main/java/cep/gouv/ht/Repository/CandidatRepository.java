package cep.gouv.ht.Repository;

import cep.gouv.ht.Models.Candidate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatRepository extends JpaRepository<Candidate, Long> {
}
