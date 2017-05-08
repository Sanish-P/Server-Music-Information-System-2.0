package com.Sanish.helper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.Sanish.entity.Track;

public class JSONHelper {
	

    public static Track getTrackDetails(String json) throws JSONException {

        System.out.println("JOSN" + json);

        JSONObject resultantJson = new JSONObject(json);

        JSONObject results = resultantJson.getJSONObject("results");

        JSONObject trackMatches = results.getJSONObject("trackmatches");

        JSONArray tracks = trackMatches.getJSONArray("track");

        Track tr = new Track();

        JSONObject trackInfo = tracks.getJSONObject(0);

        tr.setArtist(trackInfo.getString("artist"));

        JSONArray images = trackInfo.getJSONArray("image");

        JSONObject image = images.getJSONObject(3);

        tr.setAlbumArtURL(image.getString("#text"));

        return tr;

    }


}
