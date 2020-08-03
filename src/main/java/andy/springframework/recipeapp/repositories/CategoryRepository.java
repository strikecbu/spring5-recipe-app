package andy.springframework.recipeapp.repositories;

import andy.springframework.recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author AndyChen
 * @version <ul>
 * <li>2020/8/3 AndyChen,new
 * </ul>
 * @since 2020/8/3
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByName(String name);
}
