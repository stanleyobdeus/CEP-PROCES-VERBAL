package cep.gouv.ht.Repository;

import cep.gouv.ht.Models.StoreProcesVerbal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreProcessVerbalRepository extends JpaRepository<StoreProcesVerbal, Long> {
}
