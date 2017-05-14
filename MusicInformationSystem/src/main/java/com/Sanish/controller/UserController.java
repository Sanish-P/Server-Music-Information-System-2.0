package com.Sanish.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Sanish.dao.UserDAO;
import com.Sanish.entity.User;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserDAO userDAO;

	@RequestMapping(method = RequestMethod.GET)
	public List<User> getAll(){
		
		
		return userDAO.getAll();
		
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public User getbyId(@PathVariable("id")int id){
		
		return userDAO.getById(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public User insertUser(
			@RequestParam int userId,
			@RequestParam String username,
            @RequestParam String password,
            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam String role
	){
		
		User user = new User(username,password,firstname,lastname,role);
		
		userDAO.insert(user);
		
		return user;

	}
	
	
	@RequestMapping(value="/{id}",method={RequestMethod.PUT})
	public User updateTrack(
			@PathVariable("id") int userId,
			@RequestParam String username,
            @RequestParam String password,
            @RequestParam String firstname,
            @RequestParam String lastname
	){
		
		User user = new User(userId,username,password,firstname,lastname);
		
		userDAO.update(user);
		
		return user;
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
