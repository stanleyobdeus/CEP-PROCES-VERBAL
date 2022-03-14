package cep.gouv.ht.Repository;

import cep.gouv.ht.Models.CentreVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentreVoteRepository extends JpaRepository<CentreVote, Long> {
}
