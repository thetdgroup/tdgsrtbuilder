package com.thetdgroup.srt_parser.corpus_metadata;

import org.json.JSONObject;

import comThetdgroupSchemaTdgSrtV1.ContentType.Genres.Genre;

public class GenreObject
{
	private String genreID = "";
	private String genreName = "";
	
	//
	GenreObject(Genre genre)
	{
		genreID = genre.getMetaDataID();
		genreName = genre.getText();
	}
	
	//
	JSONObject toJSON() throws Exception
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("genre_id", genreID);
		jsonObject.put("genre_name", genreName);
		
		return jsonObject;
	}
}
