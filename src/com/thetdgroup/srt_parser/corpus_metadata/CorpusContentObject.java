package com.thetdgroup.srt_parser.corpus_metadata;

import org.json.JSONObject;

import comThetdgroupSchemaTdgSrtV1.CorpusContentType;

public class CorpusContentObject
{
	private ContentObject contentObject = new ContentObject();
	private LinguisticObject linguisticObject = new LinguisticObject();
	private FormatObject formatObject = new FormatObject();
	
	//
	public void parse(CorpusContentType corpusContentType) throws Exception
	{
	 if(corpusContentType.getContent() != null)
	 	contentObject.parse(corpusContentType.getContent());
		
		if(corpusContentType.getLinguistic() != null)
		 linguisticObject.parse(corpusContentType.getLinguistic());

		if(corpusContentType.getFormat() != null)
		 formatObject.parse(corpusContentType.getFormat());
	}
	
	//
	public JSONObject toJSON() throws Exception
	{
		//
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("content", contentObject.toJSON());
		jsonObject.put("linguistic", linguisticObject.toJSON());
		jsonObject.put("format", formatObject.toJSON());
		
		return jsonObject;
	}
}
