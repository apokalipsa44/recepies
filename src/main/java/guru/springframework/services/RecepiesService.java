package guru.springframework.services;

import guru.springframework.domain.Recepie;

import java.util.Set;

public interface RecepiesService {
    Set<Recepie> getRecepies();
}
