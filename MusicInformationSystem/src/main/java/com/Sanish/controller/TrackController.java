package com.Sanish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Sanish.dao.TrackDAO;
import com.Sanish.entity.Track;
import com.Sanish.helper.JSONHelper;
import com.Sanish.helper.URLHelper;

@Controller
@RequestMapping(value = "/track")
public class TrackController {
	
	@Autowired
	TrackDAO trackDAO;
	
	
	@RequestMapping(method = {RequestMethod.GET})
	@ResponseBody
	public String getAll(){
		
		return trackDAO.getAll().toString();
	}
	
	@RequestMapping(value="/{id}",method = {RequestMethod.GET})
	@ResponseBody
	public String getById(@PathVariable("id")int id){
		
		return trackDAO.getById(id).toString();
		
		
	}
	
	@RequestMapping(method={RequestMethod.POST})
	@ResponseBody
	public String insertTrack(
			@RequestParam("id") int id,
			@RequestParam("trackTitle") String trackTitle,
			@RequestParam("trackSource") String trackSource,
			@RequestParam("artist") String artist
			){
		
		Track track = new Track(id,trackTitle,trackSource,artist);
		
		Track detailTrack = JSONHelper.getTrackDetails(URLHelper.get(track));

        track.setArtist(detailTrack.getArtist());

        track.setAlbumArtURL(detailTrack.getAlbumArtURL());

        track.setStreamURL(detailTrack.getStreamURL());
		
		trackDAO.insert(track);
		
		return track.toString();
	}
	
	@RequestMapping(value="/{id}",method={RequestMethod.PUT})
	public void updateTrack(
			   @PathVariable("id") int id,
	           @RequestParam("trackTitle") String trackTitle,
	           @RequestParam("trackSource") String trackSource,
	           @RequestParam("artist") String artist
	){
		
		Track track = new Track(id,trackTitle,trackSource,artist);
		
		Track detailTrack = JSONHelper.getTrackDetails(URLHelper.get(track));

        track.setArtist(detailTrack.getArtist());

        track.setAlbumArtURL(detailTrack.getAlbumArtURL());

        track.setStreamURL(detailTrack.getStreamURL());
		
		trackDAO.update(track);
	}
	
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteTrack(
            @PathVariable("id") int id
    ){
        
        Track track = trackDAO.getById(id);
        
        trackDAO.delete(track);
        
        return "Deleted track with id ="+ id;
        
    
    }
}
