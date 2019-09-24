package com.user.app.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.user.app.model.User;

@RestController
public class UserEndpoint {

	@RequestMapping(value = "${getusers}", method = RequestMethod.GET)
	public HttpEntity<List<User>> getAllUsers() {

		List<User> lstUser = new ArrayList<>();
		lstUser.add(new User("Kartik", "Wardha"));
		lstUser.add(new User("Ketan", "Wardha"));
		lstUser.add(new User("Himanshu", "Gwalior"));
		lstUser.add(new User("Jimmy", "Dhamtari"));

		return new ResponseEntity<List<User>>(lstUser, HttpStatus.OK);
	}

}
