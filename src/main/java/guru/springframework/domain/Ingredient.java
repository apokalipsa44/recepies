package guru.springframework.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

//@Data
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal amount;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure unitOFMeasure;

    @ManyToOne
    private Recepie recepie;

    public Ingredient() {
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOFMeasure, Recepie recepie) {
        this.description = description;
        this.amount = amount;
        this.unitOFMeasure = unitOFMeasure;
        this.recepie = recepie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public UnitOfMeasure getUnitOFMeasure() {
        return unitOFMeasure;
    }

    public void setUnitOFMeasure(UnitOfMeasure unitOFMeasure) {
        this.unitOFMeasure = unitOFMeasure;
    }

    public Recepie getRecepie() {
        return recepie;
    }

    public void setRecepie(Recepie recepie) {
        this.recepie = recepie;
    }
}
