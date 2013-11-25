package com.thetdgroup.srt_parser.corpus_metadata;

import org.json.JSONObject;

import comThetdgroupSchemaTdgSrtV1.ContentType.TemporalCoverages.TemporalCoverage;

public class TemporalCoverageObject
{
	private String startDate = "";
	private String endDate = "";
	private String periodDescription = "";
	
	//
	TemporalCoverageObject(TemporalCoverage temporalCoverage)
	{
		startDate = temporalCoverage.getStartDate();
		endDate = temporalCoverage.getEndDate();
		periodDescription = temporalCoverage.getPeriodDescription();
	}
	
	//
	JSONObject toJSON() throws Exception
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("start_date", startDate);
		jsonObject.put("end_date", endDate);
		jsonObject.put("period_description", periodDescription);
		
		return jsonObject;
	}
}
