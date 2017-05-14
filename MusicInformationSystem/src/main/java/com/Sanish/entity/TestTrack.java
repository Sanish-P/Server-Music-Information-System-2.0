package com.Sanish.entity;

public class TestTrack {
	
	private int id;
	
	private String trackTitle;
	
	private String trackSource;
	
	private String artist;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrackTitle() {
		return trackTitle;
	}

	public void setTrackTitle(String trackTitle) {
		this.trackTitle = trackTitle;
	}

	public String getTrackSource() {
		return trackSource;
	}

	public void setTrackSource(String trackSource) {
		this.trackSource = trackSource;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "TestTrack [id=" + id + ", trackTitle=" + trackTitle + ", trackSource=" + trackSource + ", artist="
				+ artist + "]";
	}
}
