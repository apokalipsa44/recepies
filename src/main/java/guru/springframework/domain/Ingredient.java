package guru.springframework.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descryption;
    private BigDecimal amount;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOFMesure unitOFMesure;

    @ManyToOne
    private Recepie recepie;


}
