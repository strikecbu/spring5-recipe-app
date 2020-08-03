package andy.springframework.recipeapp.service;

import andy.springframework.recipeapp.domain.Recipe;
import andy.springframework.recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author AndyChen
 * @version <ul>
 * <li>2020/8/3 AndyChen,new
 * </ul>
 * @since 2020/8/3
 */
@Service
public class RecipeServiceImpl implements RecipeService{

    final private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> findAll() {
        final Iterable<Recipe> all = recipeRepository.findAll();
        return StreamSupport.stream(all.spliterator(), false).collect(Collectors.toSet());
    }
}
