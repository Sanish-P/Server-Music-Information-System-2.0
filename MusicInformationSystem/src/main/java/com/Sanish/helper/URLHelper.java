package com.Sanish.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.Sanish.entity.Track;

public class URLHelper {
	
	 public static String get(Track track) {

	        try {
	            URL url = getTrackURL(track);
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            connection.setDoOutput(true);

	            BufferedReader bufferedReader = null;
	            try {
	                bufferedReader = new BufferedReader(
	                        new InputStreamReader(
	                                connection.getInputStream()));
	            } catch (IOException ex) {
	                System.out.println("Error");
	            }
	            String line = "";
	            StringBuilder sb = new StringBuilder();

	            while ((line = bufferedReader.readLine()) != null) {
	                sb.append(line);
	            }
	            
	            System.out.println("JSONHelper"+sb.toString());

	            return sb.toString();
	        } catch (IOException e) { //catch (IOException e) {
	            System.out.println(e.getCause());
	        }
	        return null;
	    }

	    public static URL getTrackURL(Track track) throws MalformedURLException {
	        final String BASE_URL = "https://ws.audioscrobbler.com/2.0/?method=track.search";
	        final String TRACK_PARAM = "&track=";
	        final String ARTIST_PARAM = "&artist=";
	        final String API_KEY_PARAM = "&api_key=";
	        final String API_KEY = "7a920857049bbc6781fc0545d845d684";
	        final String FORMAT_PARAM = "&format=";
	        final String FORMAT = "json";
	        final String LIMIT_PARAM = "&limit=";
	        final String LIMIT = "1";

	        String TRACK = track.getTrackTitle();
	        String ARTIST = track.getArtist();

	        StringBuilder builder = new StringBuilder();

	        builder.append(BASE_URL
	                + API_KEY_PARAM + API_KEY
	                + TRACK_PARAM + TRACK
	               + ARTIST_PARAM + ARTIST
	                + FORMAT_PARAM + FORMAT
	                + LIMIT_PARAM + LIMIT);
	        
	        System.out.println(builder.toString());

	        return new URL(builder.toString());

	} 

}
