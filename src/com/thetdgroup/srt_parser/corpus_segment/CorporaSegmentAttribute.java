package com.thetdgroup.srt_parser.corpus_segment;

public class CorporaSegmentAttribute
{
 private String propertyKey = "";
 private String propertyValue = "";
 
 //
 public CorporaSegmentAttribute(String attributeKey, String attributeValue)
 {
 	this.propertyKey = attributeKey;
 	this.propertyValue = attributeValue;
 }
 
	public String getPropertyKey()
	{
		return propertyKey;
	}
	
	public void setPropertyKey(String propertyKey)
	{
		this.propertyKey = propertyKey;
	}
	
	public String getPropertyValue()
	{
		return propertyValue;
	}
	
	public void setPropertyValue(String propertyValue)
	{
		this.propertyValue = propertyValue;
	}
}
