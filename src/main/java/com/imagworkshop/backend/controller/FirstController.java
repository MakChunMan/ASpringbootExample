package com.imagworkshop.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.imagworkshop.backend.repository.*;
import com.imagworkshop.backend.model.*;
import java.util.List;

@RestController
@RequestMapping("test")
public class FirstController {

  private final UserRepository userRepository;

  @Autowired
  public FirstController(UserRepository userRepository) {
      this.userRepository = userRepository;
  }

	@RequestMapping(value="/", produces = "application/json")
	public String index() {
    List<User> userList = (List<User>)userRepository.findAll();
    userList.forEach((u) -> {
            System.out.println("|"+u.getId()+"|"+u.getName()+"|"+u.getEmail()+"|");
    });
		return "Greetings from Spring Boot! - userList size:"+ userList.size();
	}

}