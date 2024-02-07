package monprojet.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    @NonNull
    private String nom;

    @NonNull
    private LocalDate debut;

    @Nullable
    private LocalDate fin;

    @ToString.Exclude
    @OneToMany(mappedBy = "affectation")
    private java.util.List<Participation> partipations;
}
