package cep.gouv.ht.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "election")
public class Election {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "close")
    private String close;

    @Column(name = "year")
    private String year;

    @Column(name = "slogan")
    private String slogan;

    @OneToMany(mappedBy = "election", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ElectionCentreVote> electionCentreVote;

    public Election() {
    }

    public Election(Long id, String close, String year, String slogan) {
        this.id = id;
        this.close = close;
        this.year = year;
        this.slogan = slogan;
    }

    public List<ElectionCentreVote> getElectionCentreVote() {
        return electionCentreVote;
    }

    public void setElectionCentreVote(List<ElectionCentreVote> electionCentreVote) {
        this.electionCentreVote = electionCentreVote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }
}
