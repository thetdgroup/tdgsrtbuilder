package com.thetdgroup.srt_parser;

import java.io.File;

import org.json.JSONObject;

import com.thetdgroup.TDGSRTBuilder;;

public final class TdgSRTDocumentParser
{
	private String terminologyOriginalAuthor = "";
	private String terminologyParentPath = "";
	private String terminologyName = "";
	private String terminologyStatus = "";
	private String terminologyDate = "";
	
	private String terminologySchema = "";
	private String terminologySchemaName = "";
	
	private TdgSRTCorpusObject ompcParallelCorpusObject = new TdgSRTCorpusObject();
	
	//
	public void parse(JSONObject jsonInputTerminology) throws Exception
	{
		terminologyOriginalAuthor = jsonInputTerminology.getString("terminology_original_author");
		terminologyParentPath = jsonInputTerminology.getString("parent_node_path");
		terminologyName = jsonInputTerminology.getString("node_name");
		terminologyStatus = jsonInputTerminology.getString("terminology_status");
		terminologyDate = jsonInputTerminology.getString("node_created_date");
		
		if(jsonInputTerminology.has("terminology_supporting_schema_data"))
		{
		 terminologySchema = jsonInputTerminology.getString("terminology_supporting_schema_name");
		}
		
		if(jsonInputTerminology.has("terminology_supporting_schema_data"))
		{
	 	terminologySchemaName = jsonInputTerminology.getString("terminology_supporting_schema_data");
		}
		
		//
		// Convert input json to an OMPC Object
		TDGSRTBuilder corporaBuilder = new TDGSRTBuilder();
		corporaBuilder.loadDocument(jsonInputTerminology.getString("content_data"));
		
		ompcParallelCorpusObject.parse(corporaBuilder);
	}
	
	//
	public void parse(String corporaDocument) throws Exception
	{
		//
		// Convert input file to an OMPC Object
	TDGSRTBuilder corporaBuilder = new TDGSRTBuilder();
		corporaBuilder.loadDocument(new File(corporaDocument));
		
		ompcParallelCorpusObject.parse(corporaBuilder);
	}
	
	//
	public JSONObject toJSON() throws Exception
	{
		JSONObject jsonObject = new JSONObject();
		
		//
		jsonObject.put("terminology_original_author", terminologyOriginalAuthor);
		jsonObject.put("terminology_folder", terminologyParentPath);
		jsonObject.put("terminology_name", terminologyName);
		jsonObject.put("terminology_status", terminologyStatus);
		jsonObject.put("terminology_date", terminologyDate);
		jsonObject.put("terminology_schema_name", terminologySchemaName);
		jsonObject.put("transcription_document", ompcParallelCorpusObject.toJSON());
		
		//
		return jsonObject;
	}
}
