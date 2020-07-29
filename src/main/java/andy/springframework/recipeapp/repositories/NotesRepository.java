package andy.springframework.recipeapp.repositories;

import andy.springframework.recipeapp.domain.Notes;
import org.springframework.data.repository.CrudRepository;

/**
 * @author AndyChen
 * @version <ul>
 * <li>2020/7/29 AndyChen,new
 * </ul>
 * @since 2020/7/29
 */
public interface NotesRepository extends CrudRepository<Notes, Long> {
}
