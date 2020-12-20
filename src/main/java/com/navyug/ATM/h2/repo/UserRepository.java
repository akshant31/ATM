package com.navyug.ATM.h2.repo;
import org.springframework.data.repository.CrudRepository;

import com.navyug.ATM.h2.models.User;


public interface UserRepository extends CrudRepository<User, Long>{

}
