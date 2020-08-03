package andy.springframework.recipeapp.bootstrap;

import andy.springframework.recipeapp.domain.*;
import andy.springframework.recipeapp.repositories.CategoryRepository;
import andy.springframework.recipeapp.repositories.RecipeRepository;
import andy.springframework.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class Bootstrap implements CommandLineRunner {

    final private RecipeRepository recipeRepository;

    final private UnitOfMeasureRepository unitOfMeasureRepository;

    final private CategoryRepository categoryRepository;


    public Bootstrap(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository,
                     CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Start Bootstrap process");


        Recipe recipe = new Recipe();
        recipe.setDescription("RecipeRepository");
        recipe.setCookTime(30);
        recipe.setDifficulty(Difficulty.EASY);
        recipe.setDirections("1 Cut the avocado, remove flesh: Cut the avocados in half.\n");
        Notes notes = new Notes();
        notes.setRecipeNotes("Be careful handling chiles if using. Wash your hands thoroughly after " +
                "handling and do not touch your eyes or the area near your eyes with your hands for several hours.");
        recipe.setNotes(notes);

        recipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");

        Ingredient salt = new Ingredient();
        salt.setAmount(BigDecimal.valueOf(1/4));
        salt.setDescription("Just salt");
        Optional<UnitOfMeasure> cup = unitOfMeasureRepository.findByDescription("Cup");
        salt.setUnitOfMeasure(cup.get());
        salt.setRecipe(recipe);
        Ingredient lemonJuice = new Ingredient();
        lemonJuice.setAmount(BigDecimal.valueOf(1/4));
        lemonJuice.setDescription("lemon juice");
        Optional<UnitOfMeasure> tablespoon = unitOfMeasureRepository.findByDescription("tablespoon");
        lemonJuice.setUnitOfMeasure(tablespoon.get());
        lemonJuice.setRecipe(recipe);
        Set<Ingredient> ingredients = new HashSet<>();
        ingredients.add(salt);
        ingredients.add(lemonJuice);
        recipe.setIngredients(ingredients);

        final Optional<Category> category_chinese = categoryRepository.findByName("Chinese");
        recipe.getCategories().add(category_chinese.get());

        recipeRepository.save(recipe);

        Recipe recipe2 = new Recipe();
        recipe2.setDescription("RecipeRepository_Hello");
        recipe2.setCookTime(30);
        recipe2.setDifficulty(Difficulty.EASY);
        recipe.setDirections("1 Cut the avocado, remove flesh: Cut the avocados in half.\n");
        Notes notes2 = new Notes();
        notes2.setRecipeNotes("Be careful handling chiles if using. Wash your hands thoroughly after " +
                "handling and do not touch your eyes or the area near your eyes with your hands for several hours.");
        recipe2.setNotes(notes2);
        recipe2.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");

//        Ingredient salt1 = new Ingredient();
//        salt1.setAmount(BigDecimal.valueOf(1/4));
//        salt1.setDescription("Just salt");
//        salt1.setUnitOfMeasure(cup.get());
//        Ingredient lemonJuice1 = new Ingredient();
//        lemonJuice1.setAmount(BigDecimal.valueOf(1/4));
//        lemonJuice1.setDescription("lemon juice");
//        lemonJuice1.setUnitOfMeasure(tablespoon.get());
//        recipe2.addIngredient(lemonJuice1);
//
//        category.getRecipes().add(recipe2);
//
//        recipe2.getCategories().add(category);
        recipeRepository.save(recipe2);


    }
}
