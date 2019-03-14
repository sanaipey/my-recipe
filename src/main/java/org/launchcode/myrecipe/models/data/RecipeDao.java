package org.launchcode.myrecipe.models.data;

import org.launchcode.myrecipe.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface RecipeDao extends CrudRepository<Recipe, Integer> {

}
