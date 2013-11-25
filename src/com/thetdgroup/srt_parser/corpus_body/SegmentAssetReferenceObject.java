package com.thetdgroup.srt_parser.corpus_body;

import org.json.JSONObject;

public class SegmentAssetReferenceObject
{
 private String segmentReferenceAsset = "";
 
 //
 SegmentAssetReferenceObject(String segmentAsset)
 {
 	this.segmentReferenceAsset = segmentAsset;
 }
 
 //
	public JSONObject toJSON() throws Exception
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("segment_asset", segmentReferenceAsset);
		
		return jsonObject;
	}
}
