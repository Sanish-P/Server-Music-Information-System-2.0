package com.Sanish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Sanish.dao.AudioDAO;
import com.Sanish.dao.TrackDAO;
import com.Sanish.entity.Audio;
import com.Sanish.entity.Track;

@RestController
@RequestMapping("/audio")
@CrossOrigin
public class AudioController {
	
	@Autowired
	AudioDAO audioDAO;
	
	@Autowired
	TrackDAO trackDAO;
	
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
	
	@RequestMapping(method={RequestMethod.POST})
	public Audio insert(
			@RequestParam double audioBpm,
			@RequestParam double audioDanceability,
			@RequestParam double audioEnergy,
			@RequestParam double audioLoudness,
			@RequestParam double lyricalValence,
			@RequestParam double lyricalArousal,
			@RequestParam int trackId
			){
		
		Audio audio = new Audio(audioBpm,audioDanceability,
				audioEnergy,audioLoudness,lyricalValence,lyricalArousal);
		
		Track track = trackDAO.getById(trackId);
		
		audio.setTrack(track);
		
		audioDAO.insert(audio);
		
		return audio;
		
		
	}
	
	
	@RequestMapping(value ="/{id}",method = {RequestMethod.DELETE})
	public Audio deleteAudio(
			@PathVariable("id") int id
			){
		
		Audio audio = audioDAO.getById(id);
		
		
		audioDAO.delete(audio);
		
		return audio;
	}
	

}
