package andy.springframework.recipeapp.service;

import andy.springframework.recipeapp.domain.Recipe;

import java.util.Set;

/**
 * @author AndyChen
 * @version <ul>
 * <li>2020/8/3 AndyChen,new
 * </ul>
 * @since 2020/8/3
 */
public interface RecipeService {
    Set<Recipe> findAll();
}
