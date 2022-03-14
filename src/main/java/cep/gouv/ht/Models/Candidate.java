package cep.gouv.ht.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "candidate")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "no")
    private String no;


    @Column(name = "kandidat")
    private String  kandidat;

    @Column(name = "parti")
    private String  parti;

    @Column(name = "en_chif")
    private String en_chif;

    @Column(name = "creataDate")
    private LocalDateTime creataDate;


    @Column(name = "updateDate")
    private LocalDateTime updateDate;

    @Column(name = "createBy")
    private Long createBy;

    @Column(name = "updateBy")
    private Long updateBy;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_proces_verbale", nullable = false)
    private ProcesVerbal procesVerbal;

  /*  public ProcesVerbal getProcesVerbal() {
        return procesVerbal;
    }

    public void setProcesVerbal(ProcesVerbal procesVerbal) {
        this.procesVerbal = procesVerbal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public LocalDateTime getCreataDate() {
        return creataDate;
    }

    public void setCreataDate(LocalDateTime creataDate) {
        this.creataDate = creataDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getKandidat() {
        return kandidat;
    }

    public void setKandidat(String kandidat) {
        this.kandidat = kandidat;
    }

    public String getParti() {
        return parti;
    }

    public void setParti(String parti) {
        this.parti = parti;
    }

    public String getEn_chif() {
        return en_chif;
    }

    public void setEn_chif(String en_chif) {
        this.en_chif = en_chif;
    }*/
}
