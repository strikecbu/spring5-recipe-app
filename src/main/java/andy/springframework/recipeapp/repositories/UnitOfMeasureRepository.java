package andy.springframework.recipeapp.repositories;

import andy.springframework.recipeapp.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author AndyChen
 * @version <ul>
 * <li>2020/7/29 AndyChen,new
 * </ul>
 * @since 2020/7/29
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);
}
