package com.Sanish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Sanish.dao.AudioDAO;
import com.Sanish.entity.Audio;

@Controller
@RequestMapping("/audio")
public class AudioController {
	
	@Autowired
	AudioDAO audioDAO;
	
	
	@RequestMapping(method = {RequestMethod.GET})
	@ResponseBody
	public String getAll(){
		
		return audioDAO.getAll().toString();
	}
	
	@RequestMapping(value = "/{id}",method = {RequestMethod.GET})
	@ResponseBody
	public String getById(
			@PathVariable("id")int id
			){
		
		return audioDAO.getById(id).toString();
		
	}
	
	
	@RequestMapping(value ="/{id}",method = {RequestMethod.DELETE})
	@ResponseBody
	public String deleteAudio(
			@PathVariable("id") int id
			){
		
		Audio audio = audioDAO.getById(id);
		
		audioDAO.delete(audio);
		
		return audio.toString();
	}
	

}
