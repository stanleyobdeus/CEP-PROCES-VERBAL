package cep.gouv.ht.Repository;


import cep.gouv.ht.Models.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, String> {
    @Query("SELECT d FROM Departement d WHERE d.departement=:departement")
    public Departement getDepartementByName(String departement);
}
