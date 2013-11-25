package com.thetdgroup.srt_parser.corpus_body;

import org.json.JSONObject;

public class CorpusUnitAssetReferenceObject
{
 private String unitReferenceAsset = "";
 
 //
 CorpusUnitAssetReferenceObject(String unitReferenceAsset)
 {
 	this.unitReferenceAsset = unitReferenceAsset;
 }
 
 //
	public JSONObject toJSON() throws Exception
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("unit_asset", unitReferenceAsset);
		
		return jsonObject;
	}
}
