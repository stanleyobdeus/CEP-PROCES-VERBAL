/*
package cep.gouv.ht.Models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "candidatsForOnProcesVerbal")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidatsForOnProcesVerbal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "en_chif")
    private String en_chif;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_proces_verbale", nullable = false)
    private ProcesVerbal procesVerbal;
}
*/
