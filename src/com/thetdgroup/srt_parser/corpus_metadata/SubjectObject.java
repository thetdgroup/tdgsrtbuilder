package com.thetdgroup.srt_parser.corpus_metadata;

import org.json.JSONObject;

import comThetdgroupSchemaTdgSrtV1.ContentType.Subjects.Subject;

public class SubjectObject
{
	private String subjectID = "";
	private String subjectName = "";
	
	//
	SubjectObject(Subject subject)
	{
		subjectID = subject.getMetaDataID();
		subjectName = subject.getText();
	}
	
	//
	JSONObject toJSON() throws Exception
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("subject_id", subjectID);
		jsonObject.put("subject_name", subjectName);
		
		return jsonObject;
	}
}
