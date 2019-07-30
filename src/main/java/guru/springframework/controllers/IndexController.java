package guru.springframework.controllers;


import guru.springframework.bootstrap.RecepieBootstrap;
import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepo;
import guru.springframework.repositories.RecepieRepo;
import guru.springframework.repositories.UnitOfMesureRepo;
import guru.springframework.services.RecepiesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {
   private final RecepiesService recepiesService;

    public IndexController(RecepiesService recepiesService) {
        this.recepiesService = recepiesService;
    }

    @RequestMapping({"/index", "/"})
    public String getIndexPage(Model model){
//        Optional<Category> categoryFromDb= categoryRepo.findByDescription("American");
//        Optional<UnitOfMeasure> unitOfMesureFromDb=unitOfMesureRepo.findByUnitOfMeasure("spoon");
//        System.out.println(categoryFromDb.get().getId()+" "+ categoryFromDb.get().getDescription());
//        System.out.println(unitOfMesureFromDb.get().getId()+" "+unitOfMesureFromDb.get().getUnitOfMeasure());

        model.addAttribute("recepies", recepiesService.getRecepies());

        return "index";
    }
}
