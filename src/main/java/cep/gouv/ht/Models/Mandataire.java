package cep.gouv.ht.Models;

import javax.persistence.*;

@Entity
@Table(name = "mandataire")
public class Mandataire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String full_name;
    private String parti;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_proces_verbale", nullable = false)
    private ProcesVerbal procesVerbal;

    public Long getId() {
        return id;
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

    public ProcesVerbal getProcesVerbal() {
        return procesVerbal;
    }

    public void setProcesVerbal(ProcesVerbal procesVerbal) {
        this.procesVerbal = procesVerbal;
    }

    public String getParti() {
        return parti;
    }

    public void setParti(String parti) {
        this.parti = parti;
    }
}
