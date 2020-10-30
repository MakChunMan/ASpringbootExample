package com.imagworkshop.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.imagworkshop.backend.repository.*;
import com.imagworkshop.backend.model.*;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

  private final UserRepository userRepository;

  @Autowired
  public UserController(UserRepository userRepository) {
      this.userRepository = userRepository;
  }

	@RequestMapping(value="/")
	public List<User> index() {
    List<User> userList = userRepository.findByName("test");
    User a;
    for (int x = 0; x < 10; x++){
        a = new User();
        a.setName("User Name "+ x);
        a.setEmail("username"+x+"@email.com");
        userRepository.save(a);
        System.out.println("User created:"+ "User Name "+ x);
    }
		//return "Greetings from Spring Boot! - userList size:"+ userList.size();
    return userList;
	}

  @GetMapping(value="/{id}", produces = "application/json")
  public User getUserById(@PathVariable int id) {
      return userRepository.findById(id);
  }


}