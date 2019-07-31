package guru.springframework.bootstrap;

import guru.springframework.domain.*;
import guru.springframework.repositories.CategoryRepo;
import guru.springframework.repositories.RecepieRepo;
import guru.springframework.repositories.UnitOfMesureRepo;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class RecepieBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    public final CategoryRepo categoryRepo;
    public final RecepieRepo recepieRepo;
    public final UnitOfMesureRepo unitOfMesureRepo;

    public RecepieBootstrap(CategoryRepo categoryRepo, RecepieRepo recepieRepo, UnitOfMesureRepo unitOfMesureRepo) {
        this.categoryRepo = categoryRepo;
        this.recepieRepo = recepieRepo;
        this.unitOfMesureRepo = unitOfMesureRepo;
    }

    @Override //implemented from interface
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recepieRepo.saveAll(getRecepies());
    }

    private List<Recepie> getRecepies() {
        List<Recepie> recepies = new ArrayList<>(2);
        //get units
        Set<UnitOfMeasure> unitOfMeasuresSet = new HashSet<>();
        Optional<UnitOfMeasure> unitOfMesureRipeOptional = unitOfMesureRepo.findByUnitOfMeasure("ripe");
        if (!unitOfMesureRipeOptional.isPresent()) throw new RuntimeException("Unit of mesure not exists");
        Optional<UnitOfMeasure> unitOfMesureTeaspoonOptional = unitOfMesureRepo.findByUnitOfMeasure("teaspoon");
        if (!unitOfMesureRipeOptional.isPresent()) throw new RuntimeException("Unit of mesure not exists");
        Optional<UnitOfMeasure> unitOfMesureTablespoonOptional = unitOfMesureRepo.findByUnitOfMeasure("tablespoon");
        if (!unitOfMesureRipeOptional.isPresent()) throw new RuntimeException("Unit of mesure not exists");
        Optional<UnitOfMeasure> unitOfMesureDashOptional = unitOfMesureRepo.findByUnitOfMeasure("dash");
        if (!unitOfMesureRipeOptional.isPresent()) throw new RuntimeException("Unit of mesure not exists");

        UnitOfMeasure unitRipe = unitOfMesureRipeOptional.get();
        UnitOfMeasure unitTeaspoon = unitOfMesureTeaspoonOptional.get();
        UnitOfMeasure unitTablespoon = unitOfMesureTablespoonOptional.get();
        UnitOfMeasure unitDash = unitOfMesureDashOptional.get();

        //get categories
        Optional<Category> categoryAmericanOptional = categoryRepo.findByDescription("American");
        if (!categoryAmericanOptional.isPresent()) throw new RuntimeException("category not present");
        Optional<Category> categoryVeganOptional = categoryRepo.findByDescription("Vegan");
        if (!categoryVeganOptional.isPresent()) throw new RuntimeException("category not present");
        Optional<Category> categoryMexicanOptional = categoryRepo.findByDescription("Mexican");
        if (!categoryMexicanOptional.isPresent()) throw new RuntimeException("category not present");
        Category mexicanCategory = categoryMexicanOptional.get();
        Category veganCategory = categoryVeganOptional.get();
        Category americanCategory=categoryAmericanOptional.get();


        //make recepie guacamole
        Recepie guacamoleRecepie = new Recepie();
        guacamoleRecepie.setDescription("Perfect Guacamole");
        guacamoleRecepie.setCookTime(0);
        guacamoleRecepie.setDifficulty(Difficulty.EASY);
        guacamoleRecepie.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with " +
                "a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.");
        guacamoleRecepie.setPrepTime(10);
        guacamoleRecepie.setServings(4);
        guacamoleRecepie.setSource("super recepies");
        guacamoleRecepie.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        //set categories
        guacamoleRecepie.getCategories().add(veganCategory);
        guacamoleRecepie.getCategories().add(mexicanCategory);
        // set ingredients
        guacamoleRecepie.getIngredients().add(new Ingredient("avocados", new BigDecimal(2), unitRipe));
        guacamoleRecepie.getIngredients().add(new Ingredient("Kosher salt", new BigDecimal(0.52), unitTeaspoon));
        guacamoleRecepie.getIngredients().add(new Ingredient("eggs", new BigDecimal(4), unitRipe));
        guacamoleRecepie.getIngredients().add(new Ingredient("sugar", new BigDecimal(2), unitTablespoon));
        guacamoleRecepie.getIngredients().add(new Ingredient("coconut milk", new BigDecimal(0.44), unitDash));
        //add notes
//        Notes guacamoleNotes=new Notes("best served with potatos");
//        guacamoleRecepie.setNotes(guacamoleNotes);
        recepies.add(guacamoleRecepie);


        //recepie chicken dumplings
        Recepie dumplingsRecepie=new Recepie();
        dumplingsRecepie.setDescription("American dumplings");
        dumplingsRecepie.setCookTime(50);
        dumplingsRecepie.setDifficulty(Difficulty.HARD);
        dumplingsRecepie.setDirections("Don’t be fooled by the fancy name: Sous vide is simpler than you think." +
                " Here are the basic steps: Season the steak (with salt and pepper or additional rub)." +
                "after it’s cooked, to give it a tasty crust.");
        dumplingsRecepie.setPrepTime(12);
        dumplingsRecepie.setServings(8);
        dumplingsRecepie.setSource("super recepies");
        dumplingsRecepie.setUrl("https://www.simplyrecipes.com/recipes/dumplings/");
        //set categories
        dumplingsRecepie.getCategories().add(americanCategory);
        // set ingredients
        dumplingsRecepie.getIngredients().add(new Ingredient("meat", new BigDecimal(2), unitRipe));
        dumplingsRecepie.getIngredients().add(new Ingredient("Kosher salt", new BigDecimal(0.2), unitTeaspoon));
        dumplingsRecepie.getIngredients().add(new Ingredient("sugar", new BigDecimal(1), unitTablespoon));
        // set notes
//        Notes dumplingNotes= new Notes("dont use old green meat");
//        dumplingsRecepie.setNotes(dumplingNotes);
        recepies.add(dumplingsRecepie);


        return recepies;
    }


}
