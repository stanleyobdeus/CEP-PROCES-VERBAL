package cep.gouv.ht.Models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "superviseurcentrevote")
@IdClass(SuperviseurCentreVoteId.class)
public class SuperviseurCentreVote implements Serializable {
    @Id
    private Integer id_election;

    @Id
    private Integer id_centre_vote;

    @Id
    private Integer id_superviseur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_superviseur", nullable = false,insertable = false, updatable = false)
    private Superviseur superviseur;

    public SuperviseurCentreVote() {
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

    public Superviseur getSuperviseur() {
        return superviseur;
    }

    public void setSuperviseur(Superviseur superviseur) {
        this.superviseur = superviseur;
    }

    public Integer getId_superviseur() {
        return id_superviseur;
    }

    public void setId_superviseur(Integer id_superviseur) {
        this.id_superviseur = id_superviseur;
    }
}
