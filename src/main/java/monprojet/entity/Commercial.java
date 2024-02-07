package monprojet.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity
public class Commercial extends Employe {

    @NonNull
    private float pourcentage;
}
