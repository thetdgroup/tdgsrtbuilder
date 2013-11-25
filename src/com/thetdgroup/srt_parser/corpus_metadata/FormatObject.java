package com.thetdgroup.srt_parser.corpus_metadata;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import comThetdgroupSchemaTdgSrtV1.FormatType;
import comThetdgroupMetadataControlledvocabularyV1.DataType;
import comThetdgroupMetadataControlledvocabularyV1.Encoding;

public class FormatObject
{
	private String extent = "";
	
	private List<String> dataTypesArray = new ArrayList<String>();
	private List<String> encodingArray = new ArrayList<String>();
	private List<String> mediumArray = new ArrayList<String>();
	
	//
 public void parse(FormatType format)
 {
 	extent = format.getExtent();

  //
		DataType.Enum[] dataTypes = format.getDataTypeArray();
		
		for(int iIndex = 0; iIndex < dataTypes.length; iIndex++)
		{
			dataTypesArray.add(dataTypes[iIndex].toString());
		}	 	
 	
		//
		Encoding.Enum[] formatTypes = format.getEncodingArray();
		
		for(int iIndex = 0; iIndex < formatTypes.length; iIndex++)
		{
			encodingArray.add(formatTypes[iIndex].toString());
		}

		//
  String[] mediums = format.getMediumArray();

		for(int iIndex = 0; iIndex < mediums.length; iIndex++)
		{
			mediumArray.add(mediums[iIndex]);
		}
 }
 
	//
	public JSONObject toJSON() throws Exception
	{
 	//
 	JSONArray jsonDataTypesArray = new JSONArray();
 	
 	for(String object : dataTypesArray)
 	{
 		jsonDataTypesArray.put(object);
 	}
 	
 	//
 	JSONArray jsonEncodingArray = new JSONArray();
 	
 	for(String object : encodingArray)
 	{
 		jsonEncodingArray.put(object);
 	}
 	
 	//
 	JSONArray jsonMediumArray = new JSONArray();
 	
 	for(String object : mediumArray)
 	{
 		jsonMediumArray.put(object);
 	}
 	
		//
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("extent", extent);
		jsonObject.put("data_types", jsonDataTypesArray);
		jsonObject.put("encodings", jsonEncodingArray);
		jsonObject.put("mediums", jsonMediumArray);
		
		return jsonObject;
	}
}
