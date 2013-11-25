package com.thetdgroup.srt_parser.corpus_body;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import comThetdgroupSchemaTdgSrtV1.CorpusBodyType.CorpusUnit.Segment;
import comThetdgroupSchemaTdgSrtV1.CorpusBodyType.CorpusUnit.Segment.SegmentAttribute;

public class SegmentObject
{
	private String segmentLanguageISO = "";
	private String segmentContent = "";
	
	private List<SegmentAttributeObject> segmentAttributes = new ArrayList<SegmentAttributeObject>();
	private List<SegmentAssetReferenceObject> segmentReferenceAssets = new ArrayList<SegmentAssetReferenceObject>();
	
	//
	public void parse(Segment segment)
	{
		segmentLanguageISO = segment.getLanguage().toString();
		segmentContent = segment.getSegmentContent();
		
		//
		// Parse Segment Attributes
		SegmentAttribute[] attributesArray = segment.getSegmentAttributeArray();
		
		for(int iAttributeIndex = 0; iAttributeIndex < attributesArray.length; iAttributeIndex++)
		{
			segmentAttributes.add(new SegmentAttributeObject(attributesArray[iAttributeIndex]));
		}
		
		//
		// Parse Segment Assets
		String[] assetsArray = segment.getSegmentAssetArray();
		
		for(int iAssetIndex = 0; iAssetIndex < assetsArray.length; iAssetIndex++)
		{
			segmentReferenceAssets.add(new SegmentAssetReferenceObject(assetsArray[iAssetIndex]));
		}
	}
	
	//
	public JSONObject toJSON() throws Exception
	{
 	//
 	JSONArray jsonAttributeArray = new JSONArray();
 	
 	for(SegmentAttributeObject attributeObject : segmentAttributes)
 	{
 		jsonAttributeArray.put(attributeObject.toJSON());
 	}
 	
 	//
 	JSONArray jsonAssetArray = new JSONArray();
 	
 	for(SegmentAssetReferenceObject assetObject : segmentReferenceAssets)
 	{
 		jsonAssetArray.put(assetObject.toJSON());
 	}
		
		//
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("segment_language", segmentLanguageISO);
		jsonObject.put("segment_content", segmentContent);
		jsonObject.put("segment_attributes", jsonAttributeArray);
		jsonObject.put("segment_assets", jsonAssetArray);
		
		return jsonObject;
	}
}
