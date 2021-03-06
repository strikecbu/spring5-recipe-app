package andy.springframework.recipeapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author AndyChen
 * @version <ul>
 * <li>2020/7/29 AndyChen,new
 * </ul>
 * @since 2020/7/29
 */
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}
