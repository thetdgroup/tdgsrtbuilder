package com.thetdgroup.srt_parser.corpus_body;

import org.json.JSONObject;

import comThetdgroupSchemaTdgSrtV1.CorpusBodyType.CorpusUnit.Segment.SegmentAttribute;

public class SegmentAttributeObject
{
 private String attributeKey = "";
 private String attributeValue = "";
 
 //
 SegmentAttributeObject(String attributeKey, String attributeValue)
 {
 	this.attributeKey = attributeKey;
 	this.attributeValue = attributeValue;
 }
 
 //
 SegmentAttributeObject(SegmentAttribute segmentAttribute)
 {
 	this.attributeKey = segmentAttribute.getAttributeKey();
 	this.attributeValue = segmentAttribute.getAttributeValue();
 }
 
 //
	public String getAttributeKey()
	{
		return attributeKey;
	}
	
	public void setAttributeKey(String attributeKey)
	{
		this.attributeKey = attributeKey;
	}
	
	public String getAttributeValue()
	{
		return attributeValue;
	}
	
	public void setAttributeValue(String attributeValue)
	{
		this.attributeValue = attributeValue;
	}
 
 //
	public JSONObject toJSON() throws Exception
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("attribute_key", attributeKey);
		jsonObject.put("attribute_value", attributeValue);
		
		return jsonObject;
	}
}
