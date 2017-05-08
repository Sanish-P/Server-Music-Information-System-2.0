package com.Sanish.dao;

import java.util.List;

import com.Sanish.entity.Track;

public interface TrackDAO {
	
	int insert(Track track);
	Track getById(int id);
	int update(Track track);
	int delete(Track track);
	
	List<Track> getAll();

}
