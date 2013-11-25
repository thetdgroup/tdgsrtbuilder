package com.thetdgroup.srt_parser.corpus_metadata;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import comThetdgroupSchemaTdgSrtV1.ReferencedAssetsType;
import comThetdgroupSchemaTdgSrtV1.ReferencedAssetsType.Asset;

public class ReferenceAssetsObject
{
	private List<ReferenceAssetObject> referenceAssetArray = new ArrayList<ReferenceAssetObject>();
		
	public void parse(ReferencedAssetsType referenceAssetsType)
	{
		//
		// Parse Alternate Titles
		Asset[] assetArray = referenceAssetsType.getAssetArray();
		
		for(int iIndex = 0; iIndex < assetArray.length; iIndex++)
		{
			referenceAssetArray.add(new ReferenceAssetObject(assetArray[iIndex]));
		}
	}
	
	//
	public JSONObject toJSON() throws Exception
	{
 	//
 	JSONArray jsonReferenceAssetArray = new JSONArray();
 	
 	for(ReferenceAssetObject object : referenceAssetArray)
 	{
 		jsonReferenceAssetArray.put(object.toJSON());
 	}
 	
		//
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("reference_assets", jsonReferenceAssetArray);
		
		return jsonObject;
	}
}
