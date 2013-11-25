package com.thetdgroup.srt_parser.corpus_metadata;

import org.json.JSONObject;

import comThetdgroupSchemaTdgSrtV1.GeoSpatialInformationType.Country;

public class CountryObject
{
	private String countryISO = "";
	private String countryName = "";
	private String geonameID = "";

	//
 public CountryObject(Country country)
 {
 	countryISO = country.getCountryISO();
 	countryName = country.getCountryName();
 	geonameID = country.getGeonameID();
 }
 
	//
	JSONObject toJSON() throws Exception
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("geoname_id", geonameID);
		jsonObject.put("country_iso", countryISO);
		jsonObject.put("country_name", countryName);
		
		return jsonObject;
	}
}
