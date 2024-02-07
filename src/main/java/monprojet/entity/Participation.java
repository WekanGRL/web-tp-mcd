package monprojet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity
public class Participation {

    @Id @GeneratedValue
    private Integer id;

    @NonNull
    private String role;

    @NonNull
    private float pourcentage;
}
