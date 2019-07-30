package guru.springframework.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recepie>recepies = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Recepie> getRecepies() {
        return recepies;
    }

    public void setRecepies(Set<Recepie> recepies) {
        this.recepies = recepies;
    }
}
