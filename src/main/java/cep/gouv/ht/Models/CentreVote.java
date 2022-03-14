package cep.gouv.ht.Models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "centrevote")
public class CentreVote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "close")
    private LocalDateTime close;

    @Column(name = "code_departement")
    private String code_departement;

    @Column(name = "code_commune")
    private String code_commune;

    @Column(name = "code_section")
    private String code_section;

    @Column(name = "code_centre_vote")
    private String code_centre_vote;

    @Column(name = "description")
    private String description;

    @Column(name = "address")
    private String address;

    @Column(name = "bureau_vote")
    private String bureau_vote;

    @OneToMany(mappedBy = "centreVote", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ElectionCentreVote> electionCentreVote;

    public List<ElectionCentreVote> getElectionCentreVote() {
        return electionCentreVote;
    }

    public void setElectionCentreVote(List<ElectionCentreVote> electionCentreVote) {
        this.electionCentreVote = electionCentreVote;
    }

    public CentreVote(String code_departement, String code_commune, String code_section, String code_centre_vote, String description, String address,String bureau_vote) {
        this.code_departement = code_departement;
        this.code_commune = code_commune;
        this.code_section = code_section;
        this.code_centre_vote = code_centre_vote;
        this.description = description;
        this.address = address;
        this.bureau_vote=bureau_vote;
    }

    public CentreVote() {
    }

    public String getBureau_vote() {
        return bureau_vote;
    }

    public void setBureau_vote(String bureau_vote) {
        this.bureau_vote = bureau_vote;
    }

    public String getCode_departement() {
        return code_departement;
    }

    public void setCode_departement(String code_departement) {
        this.code_departement = code_departement;
    }

    public String getCode_commune() {
        return code_commune;
    }

    public void setCode_commune(String code_commune) {
        this.code_commune = code_commune;
    }

    public String getCode_section() {
        return code_section;
    }

    public void setCode_section(String code_section) {
        this.code_section = code_section;
    }

    public String getCode_centre_vote() {
        return code_centre_vote;
    }

    public void setCode_centre_vote(String code_centre_vote) {
        this.code_centre_vote = code_centre_vote;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public CentreVote(Long id, LocalDateTime close) {
        this.id = id;
        this.close = close;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getClose() {
        return close;
    }

    public void setClose(LocalDateTime close) {
        this.close = close;
    }
}
