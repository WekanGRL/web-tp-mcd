package monprojet.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity
public class Participation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String role;

    @NonNull
    private float pourcentage;

    @ManyToOne
    private Employe contributeur;

    @ManyToOne
    private Projet affectation;
}
