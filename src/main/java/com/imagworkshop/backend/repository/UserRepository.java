package com.imagworkshop.backend.repository;

import java.util.List;
import com.imagworkshop.backend.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
    List<User> findByName(String name);
    
    User findById(long id);

    @Override
    public List<User> findAll();
}