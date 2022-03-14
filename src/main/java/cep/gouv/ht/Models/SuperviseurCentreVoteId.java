package cep.gouv.ht.Models;

import java.io.Serializable;

public class SuperviseurCentreVoteId implements Serializable {
    private Integer id_election;
    private Integer id_centre_vote;
    private Integer id_superviseur;

    public Integer getId_election() {
        return id_election;
    }

    public void setId_election(Integer id_election) {
        this.id_election = id_election;
    }

    public Integer getId_centre_vote() {
        return id_centre_vote;
    }

    public void setId_centre_vote(Integer id_centre_vote) {
        this.id_centre_vote = id_centre_vote;
    }

    public Integer getId_superviseur() {
        return id_superviseur;
    }

    public void setId_superviseur(Integer id_superviseur) {
        this.id_superviseur = id_superviseur;
    }
}
