package com.thetdgroup.srt_parser.corpus_segment;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.thetdgroup.languages.LanguageConvert;
import com.thetdgroup.srt_parser.timestamp.TimeStampObject;

import comThetdgroupClLanguageIso639V1.LanguageCodeIso6392Type;
import comThetdgroupClLanguageIso639V1.LanguageCodeIso6392Type.Enum;

//
public class CorporaSegment
{
	private static Pattern SOURCEORG_PATTERN = Pattern.compile("\\(.+?\\)");
	
 private String rdfDescriptionIndex = "";
 private ArrayList<CorporaSegmentAttribute> segmentProperties = new ArrayList<CorporaSegmentAttribute>();
 private ArrayList<TimeStampObject> timeStampsList = new ArrayList<TimeStampObject>();
 
 private String startTime = "";
 private String endTime = "";
 private String audioLength = "";
 private String audioURL = "";
 
 private String segmentLanguage;
 private String segmentText = "";
 private String segmentAssets[];
 
 //
 public CorporaSegment(String rdfDescriptionIndex)
 {
  this.rdfDescriptionIndex = rdfDescriptionIndex;
 }
 
 public CorporaSegment(String language, String segment)
 {
 	setSegmentLanguage(language);
 	setSegmentText(segment);
 }
 
 public CorporaSegment(String language, String segment, String[] assets)
 {
 	setSegmentLanguage(language);
 	this.segmentText = segment;
		this.segmentAssets = assets;
 }
 
 //
 public void setSegmentLanguage(String language)
 {
  this.segmentLanguage = language;
 }
 
 public String getSegmentIndex()
 {
  return this.rdfDescriptionIndex;
 }
 
 public void setSegmentText(String text)
 {
 	this.segmentText = text;
 }
 
 public void setTimedSegment(String text)
 {
  String[] splitText = text.split("\\)");
  
  //
  for(String split : splitText)
  {
  	String fu = split.concat(")");
  	Matcher matcher = SOURCEORG_PATTERN.matcher(fu);
  	
 	 while(matcher.find()) 
 	 {
 	 	String textContent = fu.substring(0, matcher.start());
 	 	String[] timeStamps = fu.substring(matcher.start(), matcher.end()).split(",");
 	 	
 	 	TimeStampObject timeStamp = new TimeStampObject(timeStamps[0].substring(1),
 	 	                                                timeStamps[1].substring(0, timeStamps[1].length() - 1), 
 	 	                                                textContent);
 	 	
 	 	timeStampsList.add(timeStamp);
 	 }
  }
 }

 public void setStartTime(String text)
 {
  this.startTime = text;
  addSegmentAttribute("start_time", text);
 }
 
 public void setEndTime(String text)
 {
  this.endTime = text;
  addSegmentAttribute("end_time", text);
 }
 
 public void setAudioLength(String text)
 {
  this.audioLength = text;
  addSegmentAttribute("audio_length", text);
 }
 
 public void setAudioURL(String text)
 {
  this.audioURL = text;
  addSegmentAttribute("audio_url", text);
 }
 
	public String getLanguage()
	{
		return this.segmentLanguage;
	}

	public String getSegmentText()
	{
		return this.segmentText;
	}
	
	public void addSegmentAssets(final String[] assets)
	{
		this.segmentAssets = assets;
	}
	
	public String[] getSegmentAssets()
	{
		return	this.segmentAssets;
	}
	
	public void addSegmentAttribute(final String attributeKey, final String attributeValue)
	{
		CorporaSegmentAttribute property = new CorporaSegmentAttribute(attributeKey, attributeValue);
		this.segmentProperties.add(property);
	}
	
	public List<CorporaSegmentAttribute> getSegmentProperties()
	{
		return	this.segmentProperties;
	}

 public List<TimeStampObject> getSegmentTimeStamps()
 {
  return this.timeStampsList;
 }
 
 public String getSegmentStartTime()
 {
  return this.startTime;
 }
 
 public String getSegmentEndTime()
 {
  return this.endTime;
 }
}
