package cep.gouv.ht.Models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "procesverbal")
@Getter
@Setter
@NoArgsConstructor
public class ProcesVerbal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "derpartement")
    private String derpartement;


    @Column(name = "commune")
    private String commune;


    @Column(name = "section")
    private String section;


    @Column(name = "centre_vote")
    private String centre_vote;

    @Column(name = "office_open")
    private String office_open;


    @Column(name = "nombre_bulttin")
    private String nombre_bulttin;


    @Column(name = "office_close")
    private String office_close;


    @Column(name = "number_bultin_ok")
    private String number_bultin_ok;

    @Column(name = "number_bultin_faild")
    private String number_bultin_faild;


    @Column(name = "number_bultin_not_use")
    private String number_bultin_not_use;


    @Column(name = "number_bultin_null")
    private String number_bultin_null;


    @Column(name = "office_code")
    private String office_code;


    @Column(name = "code_bare")
    private String code_bare;

    @Column(name = "code_bureau")
    private String code_bureau;


    @Column(name = "creataDate")
    private LocalDateTime creataDate;


    @Column(name = "updateDate")
    private LocalDateTime updateDate;

    @Column(name = "createBy")
    private Long createBy;

    @Column(name = "updateBy")
    private Long updateBy;


    @Column(name = "file_image")
    private byte[] file_image;


    @Column(name = "file_csv")
    private byte[] file_csv;


    @OneToMany(mappedBy = "procesVerbal", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Mandataire> mandataires;
    @OneToMany(mappedBy = "procesVerbal", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Candidate> candidate;
    @OneToMany(mappedBy = "procesVerbal", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Observateur> observateurs;


    public ProcesVerbal(Long id, String derpartement, String commune, String section, String centre_vote, String office_open, String nombre_bulttin, String office_close, String number_bultin_ok, String number_bultin_faild, String number_bultin_not_use, String number_bultin_null, String office_code, String code_bare, String code_bureau) {
        this.id = id;
        this.derpartement = derpartement;
        this.commune = commune;
        this.section = section;
        this.centre_vote = centre_vote;
        this.office_open = office_open;
        this.nombre_bulttin = nombre_bulttin;
        this.office_close = office_close;
        this.number_bultin_ok = number_bultin_ok;
        this.number_bultin_faild = number_bultin_faild;
        this.number_bultin_not_use = number_bultin_not_use;
        this.number_bultin_null = number_bultin_null;
        this.office_code = office_code;
        this.code_bare = code_bare;
        this.code_bureau = code_bureau;
    }

    public ProcesVerbal(Long id) {
        this.id = id;
    }

    public ProcesVerbal(byte[] bytes) {
        this.file_image = bytes;
    }
}
