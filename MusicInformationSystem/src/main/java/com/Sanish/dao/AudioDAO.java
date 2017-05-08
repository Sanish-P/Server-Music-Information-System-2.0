package com.Sanish.dao;

import java.util.List;

import com.Sanish.entity.Audio;

public interface AudioDAO {
	
	int insert(Audio audio);
	Audio getById(int id);
	int update(Audio audio);
	int delete(Audio audio);
	
	List<Audio> getAll();

}
