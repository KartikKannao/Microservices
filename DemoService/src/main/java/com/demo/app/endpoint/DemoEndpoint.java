package com.demo.app.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.app.model.User;

@RestController
public class DemoEndpoint {
	
	
	
	
	@Autowired
	RestTemplate restTemplate;
	
	

	@RequestMapping(value = "${getusers}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<Object> getUsers() {
		
		//RestTemplate restTemplate = new RestTemplate();
		
		//ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8082/userservice/users", List.class);
		
		ResponseEntity<List> response = restTemplate.getForEntity("http://userserver/userservice/users", List.class);
		
		
		List<User> lstUser = response.getBody();
		System.out.println("lstUser:"+lstUser);
		
		return new ResponseEntity<Object>(lstUser, HttpStatus.OK);
	}

}
