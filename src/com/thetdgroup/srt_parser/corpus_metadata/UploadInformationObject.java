package com.thetdgroup.srt_parser.corpus_metadata;

import org.json.JSONObject;

import comThetdgroupSchemaTdgSrtV1.UploadInformationType;

public class UploadInformationObject
{
	private String ipAddress = "";
	private String port = "";
	private String protocol = "";
	private String date = "";
	private UserObject userObject = new UserObject();
	
 public void parse(UploadInformationType uploadInformationType)
 {
 	ipAddress = uploadInformationType.getIPAddress();
 	port = uploadInformationType.getPort();
 	protocol = uploadInformationType.getProtocol();
 	date = uploadInformationType.getDate();
 	userObject.parse(uploadInformationType.getUserInfo());
 }
 
	//
	public JSONObject toJSON() throws Exception
	{
		//
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("ip_address", ipAddress);
		jsonObject.put("port", port);
		jsonObject.put("protocol", protocol);
		jsonObject.put("date", date);
		jsonObject.put("user_info", userObject.toJSON());
		
		return jsonObject;
	}
}
