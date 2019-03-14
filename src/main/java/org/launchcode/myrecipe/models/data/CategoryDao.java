package org.launchcode.myrecipe.models.data;

import org.launchcode.myrecipe.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.CrudMethods;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface CategoryDao extends CrudRepository<Category, Integer> {
}
