package com.thetdgroup.srt_parser.corpus_metadata;

import org.json.JSONObject;

public class LanguageObject
{
 private String languageFamily = "";
 private String languageID = "";
 private String languageISO3 = "";
 private String languageName = "";
 private String languageAnalyzer = "";
 
 //
	public String getLanguageFamily()
	{
		return languageFamily;
	}
	
	public void setLanguageFamily(String languageFamily)
	{
		this.languageFamily = languageFamily;
	}
	
	public String getLanguageID()
	{
		return languageID;
	}
	
	public void setLanguageID(String languageID)
	{
		this.languageID = languageID;
	}
	
	public String getLanguageISO3()
	{
		return languageISO3;
	}
	
	public void setLanguageISO3(String languageISO3)
	{
		this.languageISO3 = languageISO3;
	}
	
	public String getLanguageName()
	{
		return languageName;
	}
	
	public void setLanguageName(String languageName)
	{
		this.languageName = languageName;
	}
 
 public String getLanguageAnalyzer()
	{
		return languageAnalyzer;
	}

	public void setLanguageAnalyzer(String languageAnalyzer)
	{
		this.languageAnalyzer = languageAnalyzer;
	}

	//
	public JSONObject toJSON() throws Exception
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("language_id", languageID);
		jsonObject.put("language_name", languageName);
		jsonObject.put("language_iso3", languageISO3);
		jsonObject.put("language_family", languageFamily);
		jsonObject.put("analyzer", languageAnalyzer);
		
		//
		return jsonObject;
	}
}
