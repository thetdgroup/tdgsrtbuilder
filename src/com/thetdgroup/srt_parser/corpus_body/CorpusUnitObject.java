package com.thetdgroup.srt_parser.corpus_body;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import comThetdgroupSchemaTdgSrtV1.CorpusBodyType.CorpusUnit;
import comThetdgroupSchemaTdgSrtV1.CorpusBodyType.CorpusUnit.Segment;

public class CorpusUnitObject
{
	private List<SegmentObject> segments = new ArrayList<SegmentObject>();
	private List<CorpusUnitAssetReferenceObject> unitReferenceAssets = new ArrayList<CorpusUnitAssetReferenceObject>();
	
	//
	CorpusUnitObject(CorpusUnit corpusUnit)
	{
		//
		// Parse Unit Segments
		Segment[] segmentsArray = corpusUnit.getSegmentArray();
		
		for(int iIndex = 0; iIndex < segmentsArray.length; iIndex++)
		{
			SegmentObject segmentObject = new SegmentObject();
			segmentObject.parse(segmentsArray[iIndex]);
			
			segments.add(segmentObject);
		}
		
		//
		// Parse Unit Assets
		String[] corpusUnits = corpusUnit.getCorpusUnitAssetArray();
		
		for(int iIndex = 0; iIndex < corpusUnits.length; iIndex++)
		{
			CorpusUnitAssetReferenceObject unitAssetObject = new CorpusUnitAssetReferenceObject(corpusUnits[iIndex]);
			unitReferenceAssets.add(unitAssetObject);
		}
	}
	
	//
	//
	public JSONObject toJSON() throws Exception
	{
 	//
 	JSONArray jsonSegmentArray = new JSONArray();
 	
 	for(SegmentObject segmentObject : segments)
 	{
 		jsonSegmentArray.put(segmentObject.toJSON());
 	}
 	
 	//
 	JSONArray jsonUnitAssetArray = new JSONArray();
 	
 	for(CorpusUnitAssetReferenceObject unitAssetObject : unitReferenceAssets)
 	{
 		jsonUnitAssetArray.put(unitAssetObject.toJSON());
 	}
 	
		//
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("unit_segments", jsonSegmentArray);
		jsonObject.put("unit_assets", jsonUnitAssetArray);
		
		return jsonObject;
	}
}
