package cep.gouv.ht.Models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "candidatee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidatee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero")
    private String numero;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "parti")
    private String parti;

    @Column(name = "sexe")
    private String sexe;

    @Column(name = "departement")
    private String departement;

    @Column(name = "commune")
    private String commune;

    @Column(name = "section")
    private String section;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "creataDate")
    private LocalDateTime creataDate;


    @Column(name = "updateDate")
    private LocalDateTime updateDate;

    @Column(name = "createBy")
    private Long createBy;

    @Column(name = "updateBy")
    private Long updateBy;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_image", nullable = false)
    private Images images;

    public Candidatee(Candidatee candidatee) {
        this.creataDate=candidatee.getCreataDate();
        this.nom = candidatee.getNom();
        this.prenom = candidatee.getPrenom();
        this.parti = candidatee.getParti();
        this.sexe = candidatee.getSexe();
        this.departement = candidatee.getDepartement();
        this.commune = candidatee.getCommune();
        this.section = candidatee.getSection();
        this.telephone = candidatee.getTelephone();
        this.email = candidatee.getEmail();
        this.address = candidatee.getAddress();
    }

    public Candidatee(String nom, String prenom, String sexe, String departement) {
        this.nom=nom;
        this.prenom=prenom;
        this.sexe=sexe;
        this.departement=departement;
    }

    public Candidatee(LocalDateTime creataDate,String nom, String prenom, String parti, String sexe, String departement, String commune, String section, String telephone, String email, String address,Images images) {
        this.creataDate=creataDate;
        this.nom = nom;
        this.prenom = prenom;
        this.parti = parti;
        this.sexe = sexe;
        this.departement = departement;
        this.commune = commune;
        this.section = section;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.images=images;
    }
}
