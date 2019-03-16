package org.launchcode.myrecipe.models.data;

import org.launchcode.myrecipe.models.RecipeTypes;
import org.springframework.data.repository.CrudRepository;

public interface RecipeTypesDao extends CrudRepository<RecipeTypes, Integer> {
}
