package cep.gouv.ht.Models;


import javax.persistence.*;

// this class is a centre-vote for on year

@Entity
@Table(name = "electioncentrevote")
@IdClass(ElectionCentreVoteId.class)
public class ElectionCentreVote {

    @Id
    private Integer id_centre_vote;
    @Id
    private Integer id_election;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_election", nullable = false,insertable = false, updatable = false)
    private Election election;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_centre_vote", nullable = false,insertable = false, updatable = false)
    private CentreVote centreVote;


    public ElectionCentreVote() {
    }

    public ElectionCentreVote(Long id, Election election, CentreVote centreVote) {

        this.election = election;
        this.centreVote = centreVote;
    }


    public Integer getId_centre_vote() {
        return id_centre_vote;
    }

    public void setId_centre_vote(Integer id_centre_vote) {
        this.id_centre_vote = id_centre_vote;
    }

    public Integer getId_election() {
        return id_election;
    }

    public void setId_election(Integer id_election) {
        this.id_election = id_election;
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    public CentreVote getCentreVote() {
        return centreVote;
    }

    public void setCentreVote(CentreVote centreVote) {
        this.centreVote = centreVote;
    }

}
