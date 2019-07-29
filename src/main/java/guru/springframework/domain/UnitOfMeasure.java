package guru.springframework.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UnitOFMesure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String unitOfMesure;

}
