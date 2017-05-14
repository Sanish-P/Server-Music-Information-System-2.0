package com.Sanish.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Sanish.dao.UserDAO;
import com.Sanish.entity.User;
import com.Sanish.json.view.View;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserDAO userDAO;

	@RequestMapping(method = RequestMethod.GET)
	@JsonView(View.Summary.class)
	public List<User> getAll(){
		
		
		return userDAO.getAll();
		
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public User getbyId(@PathVariable("id")int id){
		
		return userDAO.getById(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public User insertUser(
			@RequestParam String username,
            @RequestParam String password,
            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam String role,
            @RequestParam String email
	){
		
		User user = new User(username,password,firstname,lastname,role,email);
		
		List<User> users = userDAO.getByUsername(username);
		
		if(!users.isEmpty()){
			for(User existingUser : users){
				
				if(existingUser.getUsername().equals(username)
						&& existingUser.getPassword().equals(password))
					return new User();
				
			}
		}
		userDAO.insert(user);
		
		return user;

	}
	
	
	@RequestMapping(value="/update",method={RequestMethod.POST})
	public User updateTrack(
			@RequestParam String oldUsername,
            @RequestParam String oldPassword,
            @RequestParam String newUsername,
            @RequestParam String newPassword
	) {
		List<User> users = userDAO.getByUsername(oldUsername);
		
		if(!users.isEmpty()){
			for(User existingUser : users){
				
				if(existingUser.getUsername().equals(oldUsername)
						&& existingUser.getPassword().equals(oldPassword)){
					
					existingUser.setPassword(newPassword);
					existingUser.setUsername(newUsername);
					
					userDAO.update(existingUser);
					
					return existingUser;
				}
					
				
			}
		}
		
		return new User();
	}
	
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteTrack(
            @PathVariable("id") int id
    ){
        
        User user = userDAO.getById(id);
        
        userDAO.delete(user);
        
        return "Deleted user with id ="+ id;
        
    
    }
    
    @RequestMapping(value="/authenticate",method = RequestMethod.POST)
    public String authenticate(
    		@RequestParam String username,
    		@RequestParam String password
    ){
    	
    	List<User> users = userDAO.getByUsername(username);
    	
    	for(User user : users){
    		
    		if(user.getUsername().equals(username)& user.getPassword().equals(password)){
    			
    			return "authenticated_"+user.getUserRole();
    		}
    		
    	}
    	
		return "Invalid Login";
    	
    }
	
	
	
}
