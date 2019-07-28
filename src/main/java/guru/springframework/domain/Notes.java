package guru.springframework.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recepie recepie;

    @Lob
    private String notes;
}
