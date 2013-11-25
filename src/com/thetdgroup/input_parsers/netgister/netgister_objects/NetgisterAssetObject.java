package com.thetdgroup.input_parsers.netgister.netgister_objects;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.thetdgroup.srt_parser.corpus_segment.CorporaSegment;
import com.thetdgroup.srt_parser.timestamp.TimeStampObject;

import comThetdgroupClLanguageIso639V1.LanguageCodeIso6392Type;

public class NetgisterAssetObject
{
 private String sessionID = "";
 private String assetName = "";
 private String uploadTime = "";
 private String lastModifiedTime = "";
 private String mediaURI = "";
 private String mediaType = "";
 private String targetLanguage = "";
 private String sourceName = "";
 private String userName = "";
 private String duration = "";
 private String encoding = "";
 
 //
 private ArrayList<LanguageObject> sourceLanguageArray = new ArrayList<LanguageObject>();
 private ArrayList<NetgisterMultiLingualSpeechObject> speechObjectList = new ArrayList<NetgisterMultiLingualSpeechObject>();
 private ArrayList<NetgisterMultiLingualTextObject> textObjectList = new ArrayList<NetgisterMultiLingualTextObject>();
 
 //
 private NetgisterNamedEntityObject namedEntityObject = new NetgisterNamedEntityObject();
 
 //
 //
 public String getSessionID()
 {
  return sessionID;
 }
 
 public void setSessionID(String sessionID)
 {
  this.sessionID = sessionID;
 }
 
 public String getAssetName()
 {
  return assetName;
 }
 
 public void setAssetName(String assetName)
 {
  this.assetName = assetName;
 }
 
 public String getUploadTime()
 {
  return uploadTime;
 }
 
 public void setUploadTime(String uploadTime)
 {
  this.uploadTime = uploadTime;
 }
 
 public String getLastModifiedTime()
 {
  return lastModifiedTime;
 }
 
 public void setLastModifiedTime(String lastModifiedTime)
 {
  this.lastModifiedTime = lastModifiedTime;
 }
 
 public String getMediaURI()
 {
  return mediaURI;
 }
 
 public void setMediaURI(String mediaURI)
 {
  this.mediaURI = mediaURI;
 }
 
 public String getMediaType()
 {
  return mediaType;
 }
 
 public void setMediaType(String mediaType)
 {
  this.mediaType = mediaType;
 }
 
 public ArrayList<LanguageObject> getSourceLanguages()
 {
  return sourceLanguageArray;
 }
 
 public void setSourceLanguage(JSONArray jsonLanguageObjects) throws JSONException
 {
	 for(int iIndex = 0; iIndex < jsonLanguageObjects.length(); iIndex++)
	 {
	 	JSONObject jsonLanguageObject = jsonLanguageObjects.getJSONObject(iIndex);
	 	
	 	LanguageObject language = new LanguageObject();
	 	language.setLanguageISO2(jsonLanguageObject.getString("language_iso2"));
	 	language.setLanguageISO3(jsonLanguageObject.getString("language_iso3"));
	 	language.setLanguageName(jsonLanguageObject.getString("language_name"));
	 	language.setLanguageProbability(jsonLanguageObject.getDouble("probability"));

	 	//
	 	sourceLanguageArray.add(language);
	 }
 }
 
 //
 public LanguageObject getHighestProbabilitySourceLanguage()
 {
  double probability = 0.0;
  LanguageObject selectedLanguage = null;
  
  //
  for(LanguageObject language : sourceLanguageArray)
  {
  	if(language.getLanguageProbability() > probability)
  	{
  		probability = language.getLanguageProbability();
  		selectedLanguage = language;
  	}
  }
  
  //
  return selectedLanguage;
 }
 
 //
 public String getTargetLanguage()
 {
  if(targetLanguage.length() == 0)
  {
   return LanguageCodeIso6392Type.ENG.toString();
  }

  //
  return targetLanguage;
 }
  
 public String getSourceName()
 {
  return sourceName;
 }
 
 public void setSourceName(String sourceName)
 {
  this.sourceName = sourceName;
 }
 
 public String getUserName()
 {
  return userName;
 }
 
 public void setUserName(String userName)
 {
  this.userName = userName;
 }
 
 public String getDuration()
 {
  return duration;
 }
 
 public void setDuration(String duration)
 {
  this.duration = duration;
 }
  
 public String getEncoding()
 {
  return encoding;
 }

 public void setEncoding(String encoding)
 {
  this.encoding = encoding;
 }

 //
 //
 public void addTextFragments(String sourceFragment, String mtFragment)
 {
  NetgisterMultiLingualTextObject textObject = new NetgisterMultiLingualTextObject();
  textObject.addSourceFragment(sourceFragment);
  textObject.addTargetFragment(mtFragment);
  
  this.textObjectList.add(textObject);
 }
 
 //
 public void addSourceFragments(String sourceFragment)
 {
  NetgisterMultiLingualTextObject textObject = new NetgisterMultiLingualTextObject();
  textObject.addSourceFragment(sourceFragment);
  
  this.textObjectList.add(textObject);
 }
 
 //
 public void addTargetFragments(String mtFragment)
 {
  NetgisterMultiLingualTextObject textObject = new NetgisterMultiLingualTextObject();
  textObject.addTargetFragment(mtFragment);
  
  this.textObjectList.add(textObject);
 }
 
 //
 public void addSpeechFragments(NetgisterSpeechObject sourceFragment, NetgisterSpeechObject mtFragment)
 {
  NetgisterMultiLingualSpeechObject speechObject = new NetgisterMultiLingualSpeechObject();
  speechObject.addSourceFragment(sourceFragment);
  speechObject.addTargetFragment(mtFragment);
  
  this.speechObjectList.add(speechObject);
 }
 
 //
 // Named Entities
 //
 public void addNamedEntityObject(NetgisterNamedEntityObject neObject)
 {
  namedEntityObject = neObject;
 }
 
 //
 public NetgisterNamedEntityObject getNamedEntityObject()
 {
  return namedEntityObject;
 }
 
 //
 // Text Fragments
 // 
 public List<CorporaSegment> getSourceText()
 {
  ArrayList<CorporaSegment> corporaSegmentList = new ArrayList<CorporaSegment>();
  String language = getHighestProbabilitySourceLanguage().getLanguageISO3();
  
  //
  for(NetgisterMultiLingualTextObject multiLingualObject : textObjectList)
  {
   if(multiLingualObject.getSourceFragment().length() > 0)
   {
    CorporaSegment segment = new CorporaSegment(language, multiLingualObject.getSourceFragment());
    corporaSegmentList.add(segment);
   }
  }
  
  //
  return corporaSegmentList;
 }
 
 //
 public List<CorporaSegment> getTargetText()
 {
  ArrayList<CorporaSegment> corporaSegmentList = new ArrayList<CorporaSegment>();
  
  for(NetgisterMultiLingualTextObject multiLingualObject : textObjectList)
  {
   if(multiLingualObject.getTargetFragment().length() > 0)
   {
    CorporaSegment segment = new CorporaSegment(this.getTargetLanguage(), multiLingualObject.getTargetFragment());
    corporaSegmentList.add(segment);
   }
  }
  
  //
  return corporaSegmentList;
 }
 
 //
 // Speech Fragments
 // 
 public List<CorporaSegment> getSourceSpeechText()
 {
  ArrayList<CorporaSegment> corporaSegmentList = new ArrayList<CorporaSegment>();
  String language = getHighestProbabilitySourceLanguage().getLanguageISO3();
  
  //
  for(NetgisterMultiLingualSpeechObject multiLingualObject : speechObjectList)
  {
   CorporaSegment segment = new CorporaSegment(language, multiLingualObject.getSourceSpeechObject().getSpeechFragment());
   corporaSegmentList.add(segment);
   
   //
   segment.addSegmentAttribute("fragment_id", multiLingualObject.getSourceSpeechObject().getFragmentID());
   segment.addSegmentAttribute("fragment_duration", multiLingualObject.getSourceSpeechObject().getFragmentDuration());
   segment.addSegmentAttribute("fragment_offset", multiLingualObject.getSourceSpeechObject().getFragmentStartOffset());
   segment.addSegmentAttribute("fragment_start_time", multiLingualObject.getSourceSpeechObject().getFragmentStartTime());
  }
  
  //
  return corporaSegmentList;
 }
 
 //
 public List<CorporaSegment> getTargetSpeechText()
 {
  ArrayList<CorporaSegment> corporaSegmentList = new ArrayList<CorporaSegment>();
  
  for(NetgisterMultiLingualSpeechObject multiLingualObject : speechObjectList)
  {
   CorporaSegment segment = new CorporaSegment(this.getTargetLanguage(), multiLingualObject.getTargetSpeechObject().getSpeechFragment());
   corporaSegmentList.add(segment);
   
   //
   segment.addSegmentAttribute("fragment_id", multiLingualObject.getTargetSpeechObject().getFragmentID());
   segment.addSegmentAttribute("fragment_duration", multiLingualObject.getTargetSpeechObject().getFragmentDuration());
   segment.addSegmentAttribute("fragment_offset", multiLingualObject.getTargetSpeechObject().getFragmentStartOffset());
   segment.addSegmentAttribute("fragment_start_time", multiLingualObject.getTargetSpeechObject().getFragmentStartTime());
  }
  
  //
  return corporaSegmentList;
 }
 
 //
 public List<CorporaSegment> getSourceSpeechAnnotatedText()
 {
  ArrayList<CorporaSegment> corporaSegmentList = new ArrayList<CorporaSegment>();
  String language = getHighestProbabilitySourceLanguage().getLanguageISO3();
  
  //
  for(NetgisterMultiLingualSpeechObject multiLingualObject : speechObjectList)
  {
   CorporaSegment segment = new CorporaSegment(language, multiLingualObject.getSourceSpeechObject().getAnnotatedSpeechFragment());
   corporaSegmentList.add(segment);
  }
  
  //
  return corporaSegmentList;
 }
 
 //
 public List<CorporaSegment> getTargetSpeechAnnotatedText()
 {
  ArrayList<CorporaSegment> corporaSegmentList = new ArrayList<CorporaSegment>();
  
  for(NetgisterMultiLingualSpeechObject multiLingualObject : speechObjectList)
  {
   CorporaSegment segment = new CorporaSegment(this.getTargetLanguage(), multiLingualObject.getTargetSpeechObject().getAnnotatedSpeechFragment());
   corporaSegmentList.add(segment);
  }
  
  //
  return corporaSegmentList;
 }
 
 //
 public List<TimeStampObject> getTimestampSourceSpeechList(final String fragmentID)
 {
  ArrayList<TimeStampObject> corporaSegmentList = new ArrayList<TimeStampObject>();
  
  for(NetgisterMultiLingualSpeechObject multiLingualObject : speechObjectList)
  {
   if(multiLingualObject.getSourceSpeechObject().getFragmentID().equals(fragmentID))
   {
    corporaSegmentList.addAll(multiLingualObject.getSourceSpeechObject().getTimedSpeechFragments());
   }
  }
  
  //
  return corporaSegmentList;
 }
 
 //
 public List<TimeStampObject> getTimestampTargetSpeechList(final String fragmentID)
 {
  ArrayList<TimeStampObject> corporaSegmentList = new ArrayList<TimeStampObject>();
  
  for(NetgisterMultiLingualSpeechObject multiLingualObject : speechObjectList)
  {
   if(multiLingualObject.getTargetSpeechObject().getFragmentID().equals(fragmentID))
   {
    corporaSegmentList.addAll(multiLingualObject.getTargetSpeechObject().getTimedSpeechFragments());
   }
  }
  
  //
  return corporaSegmentList;
 }
}