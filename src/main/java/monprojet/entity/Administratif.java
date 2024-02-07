package monprojet.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity
public class Administratif extends Employe {

    @NonNull
    private String diplome;
}
