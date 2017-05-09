package com.Sanish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Sanish.dao.AudioDAO;
import com.Sanish.entity.Audio;

@RestController
@RequestMapping("/audio")
public class AudioController {
	
	@Autowired
	AudioDAO audioDAO;
	
	@RequestMapping(method = {RequestMethod.GET})
	public List<Audio> getAll(){
		
		return audioDAO.getAll();
	}
	
	@RequestMapping(value = "/{id}",method = {RequestMethod.GET})
	public Audio getById(
			@PathVariable("id")int id
			){
		
		return audioDAO.getById(id);
		
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
