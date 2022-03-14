package cep.gouv.ht.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JsonCandidat implements Serializable {
    private String no;
    private String  kandidat;
    private String  parti;
    private String en_chif;
}
