package com.thetdgroup.srt_parser.corpus_body;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import comThetdgroupSchemaTdgSrtV1.CorpusBodyType;
import comThetdgroupSchemaTdgSrtV1.CorpusBodyType.CorpusUnit;

public class CorpusBodyObject
{
 private List<CorpusUnitObject> corpusUnitObject = new ArrayList<CorpusUnitObject>();
	
	//
	public void parse(CorpusBodyType corpusBody)
	{
		//
		// Parse Segment Attributes
		if(corpusBody.getCorpusUnitArray() != null)
		{
			CorpusUnit[] corpusUnitArray = corpusBody.getCorpusUnitArray();
	
			for(int iAttributeIndex = 0; iAttributeIndex < corpusUnitArray.length; iAttributeIndex++)
			{
				corpusUnitObject.add(new CorpusUnitObject(corpusUnitArray[iAttributeIndex]));
			}
		}
	}
	
	//
	public JSONObject toJSON() throws Exception
	{
 	//
 	JSONArray jsonUnitsArray = new JSONArray();
 	
 	for(CorpusUnitObject corpusObject : corpusUnitObject)
 	{
 		jsonUnitsArray.put(corpusObject.toJSON());
 	}
 	
		//
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("corpus_units", jsonUnitsArray);
		
		return jsonObject;
	}
}
