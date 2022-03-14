package cep.gouv.ht.Models;

import java.io.Serializable;

public class ElectionCentreVoteId implements Serializable {

    private Integer id_election;
    private Integer id_centre_vote;

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
}

