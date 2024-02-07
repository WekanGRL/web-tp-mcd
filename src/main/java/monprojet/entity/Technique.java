package monprojet.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity
public class Technique extends Employe {

    @NonNull
    private float montantPrime;
}
