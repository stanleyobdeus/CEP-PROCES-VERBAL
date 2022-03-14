package cep.gouv.ht.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "superviseur")
public class Superviseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @OneToMany(mappedBy = "superviseur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SuperviseurCentreVote> superviseurCentreVote;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<SuperviseurCentreVote> getSuperviseurCentreVote() {
        return superviseurCentreVote;
    }

    public void setSuperviseurCentreVote(List<SuperviseurCentreVote> superviseurCentreVote) {
        this.superviseurCentreVote = superviseurCentreVote;
    }
}
