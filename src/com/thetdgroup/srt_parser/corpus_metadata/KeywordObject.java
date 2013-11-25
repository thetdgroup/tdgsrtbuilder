package com.thetdgroup.srt_parser.corpus_metadata;

import org.json.JSONObject;

public class KeywordObject
{
	private String keywordText = "";
	
	//
	KeywordObject(String keyword)
	{
		keywordText = keyword;
	}
	
	//
	JSONObject toJSON() throws Exception
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("keyword_text", keywordText);
		
		return jsonObject;
	}
}
