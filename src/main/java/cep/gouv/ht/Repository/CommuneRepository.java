package cep.gouv.ht.Repository;

import cep.gouv.ht.Models.Commune;
import cep.gouv.ht.Models.CommuneId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommuneRepository extends JpaRepository<Commune, CommuneId> {

    @Query("SELECT c FROM Commune c WHERE c.code_dep=:code_dep")
    public List<Commune> getAllCommuneByIdDepartement(String code_dep);
}
