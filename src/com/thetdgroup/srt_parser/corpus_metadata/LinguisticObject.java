package com.thetdgroup.srt_parser.corpus_metadata;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import comThetdgroupSchemaTdgSrtV1.LanguageType;
import comThetdgroupSchemaTdgSrtV1.LinguisticType;

import comThetdgroupClLanguageIso639V1.LanguageCodeIso6392Type;

public class LinguisticObject
{
	private String alignment = "";
	private String corpusType = "";
	
	private List<String> annotationTypesArray = new ArrayList<String>();
	private List<String> sourceLanguagesArray = new ArrayList<String>();
	private List<String> sourceDialectsArray = new ArrayList<String>();
	private List<String> targetLanguagesArray = new ArrayList<String>();
	
	//
	public void parse(LinguisticType linguisticType) throws Exception
	{
		alignment = linguisticType.getAlignment().toString();
		corpusType = linguisticType.getCorpusType().toString();
		
		//
		if(linguisticType.getSourceLanguageDialectArray() != null)
		{
			String[] sourceDialects = linguisticType.getSourceLanguageDialectArray();
			
			for(int iIndex = 0; iIndex < sourceDialects.length; iIndex++)
			{
				sourceDialectsArray.add(sourceDialects[iIndex]);
			}
		}
		
		//
		if(linguisticType.getSourceLanguages() != null)
		{
			LanguageType[] sourceLanguages = linguisticType.getSourceLanguages().getLanguageArray();
			
			for(int iIndex = 0; iIndex < sourceLanguages.length; iIndex++)
			{
				sourceLanguagesArray.add(sourceLanguages[iIndex].getLanguageIso3());
			}
		}
		
		//
		if(linguisticType.getTargetLanguages() != null)
		{
			LanguageCodeIso6392Type.Enum[] targetLanguages = linguisticType.getTargetLanguages().getLanguageArray();
			
			for(int iIndex = 0; iIndex < targetLanguages.length; iIndex++)
			{
				targetLanguagesArray.add(targetLanguages[iIndex].toString());
			}		
		}
	}
	
 //
	public JSONObject toJSON() throws Exception
	{
 	//
 	JSONArray jsonAnnotationTypesArray = new JSONArray();
 	
 	for(String object : annotationTypesArray)
 	{
 		jsonAnnotationTypesArray.put(object);
 	}
 	
 	//
 	JSONArray jsonSourceLanguagesArray = new JSONArray();
 	
 	for(String object : sourceLanguagesArray)
 	{
 		jsonSourceLanguagesArray.put(object);
 	}
 	
 	//
 	JSONArray jsonSourceDialectsArray = new JSONArray();
 	
 	for(String object : sourceDialectsArray)
 	{
 		jsonSourceDialectsArray.put(object);
 	}
 	
 	//
 	JSONArray jsonTargetLanguagesArray = new JSONArray();
 	
 	for(String object : targetLanguagesArray)
 	{
 		jsonTargetLanguagesArray.put(object);
 	}
		
		//
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("alignment", alignment);
		jsonObject.put("corpus_type", corpusType);
		jsonObject.put("source_languages", jsonSourceLanguagesArray);
		jsonObject.put("target_languages", jsonTargetLanguagesArray);
		jsonObject.put("annotation_types", jsonAnnotationTypesArray);
		jsonObject.put("source_dialects", jsonSourceDialectsArray);
		
		return jsonObject;
	}
}
