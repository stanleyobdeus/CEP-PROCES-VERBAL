package cep.gouv.ht.Models;

import javax.persistence.*;

@Entity
@Table(name = "bureauvote")
public class BureauVote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numberPv")
    private int numberPv;

    public BureauVote() {
    }


    public BureauVote(Long id, int numberPv) {
        this.id = id;
        this.numberPv = numberPv;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberPv() {
        return numberPv;
    }

    public void setNumberPv(int numberPv) {
        this.numberPv = numberPv;
    }
}
