package org.launchcode.myrecipe.models.data;

import org.launchcode.myrecipe.models.RecipeTypes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RecipeTypesDao extends CrudRepository<RecipeTypes, Integer> {
}
