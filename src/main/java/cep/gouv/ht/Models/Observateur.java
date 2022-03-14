package cep.gouv.ht.Models;


import javax.persistence.*;

@Entity
@Table(name = "observateur")
public class Observateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String full_name;
     //combo box
    private String organisation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_proces_verbale", nullable = false)
    private ProcesVerbal procesVerbal;

    public Long getId() {
        return id;
    }

    public ProcesVerbal getProcesVerbal() {
        return procesVerbal;
    }

    public void setProcesVerbal(ProcesVerbal procesVerbal) {
        this.procesVerbal = procesVerbal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }
}
