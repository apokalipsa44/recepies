package guru.springframework.services;

import guru.springframework.domain.Recepie;
import guru.springframework.repositories.RecepieRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class RecepiesServiceImpl implements RecepiesService {
    public final RecepieRepo recepieRepo;

    public RecepiesServiceImpl(RecepieRepo recepieRepo) {
        this.recepieRepo = recepieRepo;
    }

    @Override
    public Set<Recepie> getRecepies() {
        Set<Recepie>recepies=new HashSet<>();
        recepieRepo.findAll().iterator().forEachRemaining(recepies::add);
        return recepies;

    }
}
