package com.thetdgroup.srt_parser.corpus_metadata;

import org.json.JSONObject;

import comThetdgroupSchemaTdgSrtV1.ReferencedAssetsType.Asset.Prop;

public class PropertyObject
{
 private String propertyKey = "";
 private String propertyValue = "";
 
 //
 PropertyObject(Prop property)
 {
 	this.propertyKey = property.getType();
 	this.propertyValue = property.getValue();
 }
 
 //
	public JSONObject toJSON() throws Exception
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("property_key", propertyKey);
		jsonObject.put("property_value", propertyValue);
		
		return jsonObject;
	}
}
