package com.Sanish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Sanish.dao.UserDAO;
import com.Sanish.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserDAO userDAO;

	@RequestMapping(method = RequestMethod.GET)
	public String getAll(){
		
		
		return userDAO.getAll().toString();
		
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public String getbyId(@PathVariable("id")int id){
		
		return userDAO.getById(id).toString();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String insertUser(
			@RequestParam("userId") int userId,
			@RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname
	){
		
		User user = new User(userId,username,password,firstname,lastname);
		
		
		userDAO.insert(user);
		
		return user.toString();
	}
	
	
	@RequestMapping(value="/{id}",method={RequestMethod.PUT})
	@ResponseBody
	public String updateTrack(
			@PathVariable("id") int id,
			@RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname
	){
		
		User user = new User(id,username,password,firstname,lastname);
		
		userDAO.update(user);
		
		return user.toString();
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
	
	
	
}
