package monprojet.entity;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public abstract class Employe {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer matricule;

    @NonNull
    private String nom;

    @Email
    private String email;

    @ToString.Exclude
    @OneToMany(mappedBy = "superieur", fetch = FetchType.LAZY)
    private List<Employe> subordonnes;

    @ManyToOne(optional = true)
    private Employe superieur;

    @ToString.Exclude
    @OneToMany(mappedBy = "contributeur", fetch = FetchType.LAZY)
    private List<Participation> participations;
}
