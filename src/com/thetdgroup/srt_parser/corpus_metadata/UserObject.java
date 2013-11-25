package com.thetdgroup.srt_parser.corpus_metadata;

import org.json.JSONObject;

import comThetdgroupSchemaTdgSrtV1.UploadInformationType.UserInfo;

public class UserObject
{
	private String userID = "";
	private String userName = "";
	private String userEmail = "";
				
	//
 public void parse(UserInfo userInfo)
 {
 	userID = userInfo.getUserID();
 	userName = userInfo.getName();
 	userEmail = userInfo.getEmail();
 }
 
	//
	public JSONObject toJSON() throws Exception
	{
		//
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("user_id", userID);
		jsonObject.put("user_name", userName);
		jsonObject.put("user_email", userEmail);
		
		return jsonObject;
	}
}
