package andy.springframework.recipeapp.repositories;

import andy.springframework.recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * @author AndyChen
 * @version <ul>
 * <li>2020/7/29 AndyChen,new
 * </ul>
 * @since 2020/7/29
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
