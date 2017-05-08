package com.Sanish.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_Audio")
public class Audio {
	
    @Id
    @Column(name = "audio_id")
    private Integer audioId;
    
    
    @Column(name = "audio_bpm")
    private double audioBpm;
    
    
    @Column(name = "audio_dancebility")
    private double audioDancebility;
    
    
    @Column(name = "audio_energy")
    private double audioEnergy;
    
    
    @Column(name = "audio_loudness")
    private double audioLoudness;
    
    @Column(name = "lyrics_valence")
    private Double lyricsValence;
    
    @Column(name = "lyrics_arousal")
    private Double lyricsArousal;
    
   @OneToOne
   @JoinColumn(name = "track_id", referencedColumnName="track_id")
   private Track track;
    

	public Audio(Integer audioId, double audioBpm, double audioDancebility, double audioEnergy, double audioLoudness,
			Double lyricsValence, Double lyricsArousal) {
		
		this.audioId = audioId;
		this.audioBpm = audioBpm;
		this.audioDancebility = audioDancebility;
		this.audioEnergy = audioEnergy;
		this.audioLoudness = audioLoudness;
		this.lyricsValence = lyricsValence;
		this.lyricsArousal = lyricsArousal;
	}

	public Audio() {
		
	}

	public Integer getAudioId() {
		return audioId;
	}

	public void setAudioId(Integer audioId) {
		this.audioId = audioId;
	}

	public double getAudioBpm() {
		return audioBpm;
	}

	public void setAudioBpm(double audioBpm) {
		this.audioBpm = audioBpm;
	}

	public double getAudioDancebility() {
		return audioDancebility;
	}

	public void setAudioDancebility(double audioDancebility) {
		this.audioDancebility = audioDancebility;
	}

	public double getAudioEnergy() {
		return audioEnergy;
	}

	public void setAudioEnergy(double audioEnergy) {
		this.audioEnergy = audioEnergy;
	}

	public double getAudioLoudness() {
		return audioLoudness;
	}

	public void setAudioLoudness(double audioLoudness) {
		this.audioLoudness = audioLoudness;
	}

	public Double getLyricsValence() {
		return lyricsValence;
	}

	public void setLyricsValence(Double lyricsValence) {
		this.lyricsValence = lyricsValence;
	}

	public Double getLyricsArousal() {
		return lyricsArousal;
	}

	public void setLyricsArousal(Double lyricsArousal) {
		this.lyricsArousal = lyricsArousal;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}
	
	
 
}