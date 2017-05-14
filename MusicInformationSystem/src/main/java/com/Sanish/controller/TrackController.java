package com.Sanish.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Sanish.dao.AudioDAO;
import com.Sanish.dao.TrackDAO;
import com.Sanish.entity.TestTrack;
import com.Sanish.entity.Track;
import com.Sanish.helper.JSONHelper;
import com.Sanish.helper.URLHelper;
import com.Sanish.helper.recomender.ClusterAlgorithm;
import com.Sanish.json.view.View;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin
@RestController
@RequestMapping(value = "/track")
public class TrackController {
	
	@Autowired
	TrackDAO trackDAO;
	
	@Autowired
	AudioDAO audioDAO;
	
	
	@RequestMapping(method = {RequestMethod.GET})
	@JsonView(View.Summary.class)
	public List<Track> getAll(){
		
		return trackDAO.getAll();
	}
	
	@RequestMapping(value="/{id}",method = {RequestMethod.GET})
	public Track getById(@PathVariable("id")int id){
		
		return trackDAO.getById(id);
		
		
	}
	
	@RequestMapping(method={RequestMethod.POST})
	public Track insertTrack(
			@RequestPart MultipartFile trackSource,
			@RequestParam String trackTitle,
			@RequestParam String artist){
		
		try {
			trackSource.transferTo(new File("/home/gandoff/Documents/nodejsProjects/songs/"+trackSource.getOriginalFilename()));
		} catch (IllegalStateException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		Track track = new Track(trackTitle,trackSource.getOriginalFilename(),artist);
		
		Track detailTrack = JSONHelper.getTrackDetails(URLHelper.get(track));

        track.setAlbumArtURL(detailTrack.getAlbumArtURL());

        track.setStreamURL(detailTrack.getStreamURL());
        
		int generatedId = trackDAO.insert(track);
		
		track.setTrackId(generatedId);
		
		return track;
	}
	
	@RequestMapping(value="/{id}",method={RequestMethod.PUT})
	public String updateTrack(
			HttpServletRequest req
	) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String line = "";
		while((line = br.readLine()) != null){
			
			System.out.println(line);
		}
		
		/*Track track = new Track(id,trackTitle,trackSource,artist);
		
		Track detailTrack = JSONHelper.getTrackDetails(URLHelper.get(track));

        track.setArtist(detailTrack.getArtist());

        track.setAlbumArtURL(detailTrack.getAlbumArtURL());

        track.setStreamURL(detailTrack.getStreamURL());
		
		trackDAO.update(track);*/
		
		return "Done";
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
    
    @RequestMapping(value ="/recom/{id}",method= RequestMethod.GET)
    public List<Track> getRecomendation(
    		@PathVariable("id") int id
    		){
        List<Integer> cluster = ClusterAlgorithm.getCluster(id, audioDAO.getAll());
        List<Track> recomTrackList = new ArrayList();

        for (Integer trackId : cluster) {

            Track track = trackDAO.getById(trackId);

            recomTrackList.add(track);

        }
        
        return recomTrackList;
    	
    }
}
