package cep.gouv.ht.Repository;

import cep.gouv.ht.Models.ProcesVerbal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcesVerbalRepository  extends JpaRepository<ProcesVerbal, Long> {
    @Query("SELECT COUNT(u) FROM ProcesVerbal u")
    Long getCountProcesVerbal();


   /* @Query("SELECT p.file_image FROM ProcesVerbal p WHERE p.code_bare=:code_bare")
    ProcesVerbal getProcesVerbalsByCode_bare(String code_bare);*/

    @Query("SELECT p.file_image FROM ProcesVerbal p WHERE p.code_bare=:code_bare")
    ProcesVerbal getProcesVerbalsByCodebare(String code_bare);

//
//    @Query("SELECT p.code_bare,p.candidate,p.centre_vote,p.commune FROM ProcesVerbal p")
    @Query("select new cep.gouv.ht.Models.ProcesVerbal(p.id,p.derpartement, p.commune,p.section,p.centre_vote,p.office_open,p.nombre_bulttin,p.office_close,p.number_bultin_ok,p.number_bultin_faild,p.number_bultin_not_use,p.number_bultin_null,p.office_code,p.code_bare,p.code_bureau) from ProcesVerbal p")
    List<ProcesVerbal> getAllProcesVerbals();

}
