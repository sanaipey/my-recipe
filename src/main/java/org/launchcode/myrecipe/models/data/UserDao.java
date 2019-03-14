package org.launchcode.myrecipe.models.data;

import org.launchcode.myrecipe.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

//Data Access Object - interface by which we interact with DB
@Repository
@Transactional  //every method should be wrapped by this
public interface UserDao extends CrudRepository<User, Integer> {//stores User objects and its keys are integers


}
