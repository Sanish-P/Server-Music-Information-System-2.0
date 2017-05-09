package com.Sanish.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.Sanish.json.view.View;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "tbl_Track")
@JsonIgnoreProperties("audio")
public class Track {
	
	@Id
	@Column(name = "track_id")
	private Integer trackId;

	@Column(name = "track_title")
	@JsonView(View.Summary.class)
	private String trackTitle;
	
	@Column(name = "track_source")
	private String trackSource;
	
	@Column(name = "track_stream_url")
	private String streamURL="http://192.168.1.101:8081/listen/";
	
	@Column(name = "track_album_art_url")
	@JsonView(View.Summary.class)
	private String albumArtURL;
	
	@Column(name = "track_artist")
	private String artist;
	
	@OneToOne(mappedBy = "track")
	private Audio audio;
	

	public Track(Integer trackId, String trackTitle, String trackSource, String streamURL, String albumArtURL,
			String artist) {
		
		this.trackId = trackId;
		this.trackTitle = trackTitle;
		this.trackSource = trackSource;
		this.streamURL = streamURL;
		this.albumArtURL = albumArtURL;
		this.artist = artist;
	}
	

	public Track(Integer trackId, String trackTitle, String trackSource, String artist) {
		this.trackId = trackId;
		this.trackTitle = trackTitle;
		this.trackSource = trackSource;
		this.artist = artist;
	}


	public Track(){
		
		
	}



	public Integer getTrackId() {
		return trackId;
	}



	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
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



	public String getStreamURL() {
		return streamURL;
	}



	public void setStreamURL(String streamURL) {
		this.streamURL = streamURL;
	}



	public String getAlbumArtURL() {
		return albumArtURL;
	}



	public void setAlbumArtURL(String albumArtURL) {
		this.albumArtURL = albumArtURL;
	}



	public String getArtist() {
		return artist;
	}



	public void setArtist(String artist) {
		this.artist = artist;
	}



	public Audio getAudio() {
		return audio;
	}



	public void setAudio(Audio audio) {
		this.audio = audio;
	}



	@Override
	public String toString() {
		return "Track [trackId=" + trackId + ", trackTitle=" + trackTitle + ", trackSource=" + trackSource
				+ ", streamURL=" + streamURL + ", albumArtURL=" + albumArtURL + ", artist=" + artist + ", audio="
				+ audio + "]";
	}


}
