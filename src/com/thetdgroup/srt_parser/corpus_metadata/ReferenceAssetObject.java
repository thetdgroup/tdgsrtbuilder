package com.thetdgroup.srt_parser.corpus_metadata;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import comThetdgroupSchemaTdgSrtV1.ReferencedAssetsType.Asset;
import comThetdgroupSchemaTdgSrtV1.ReferencedAssetsType.Asset.Prop;

public class ReferenceAssetObject
{
	private String assetID = "";
	private List<PropertyObject> propertyObjectArray = new ArrayList<PropertyObject>();
	
	//
	ReferenceAssetObject(Asset asset)
	{
		assetID = asset.getId();
		
		//
		Prop[] properties = asset.getPropArray();
		
		for(int iIndex = 0; iIndex < properties.length; iIndex++)
		{
			propertyObjectArray.add(new PropertyObject(properties[iIndex]));
		}
	}
	
	//
	JSONObject toJSON() throws Exception
	{
 	//
 	JSONArray jsonPropertyArray = new JSONArray();
 	
 	for(PropertyObject object : propertyObjectArray)
 	{
 		jsonPropertyArray.put(object.toJSON());
 	}
 	
 	//
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("asset_id", assetID);
		jsonObject.put("asset_properties", jsonPropertyArray);
		
		return jsonObject;
	}
}
