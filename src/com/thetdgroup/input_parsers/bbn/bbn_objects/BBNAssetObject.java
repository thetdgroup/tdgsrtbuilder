package com.thetdgroup.input_parsers.bbn.bbn_objects;

import java.util.ArrayList;
import java.util.List;

import com.thetdgroup.languages.LanguageConvert;
import com.thetdgroup.srt_parser.corpus_segment.CorporaSegment;
import com.thetdgroup.srt_parser.timestamp.TimeStampObject;

import comThetdgroupClLanguageIso639V1.LanguageCodeIso6392Type;

public class BBNAssetObject
{
 private String sessionID = "";
 private String assetName = "";
 private String uploadTime = "";
 private String lastModifiedTime = "";
 private String mediaURI = "";
 private String mediaType = "";
 private String sourceLanguage = "";
 private String targetLanguage = "";
 private String sourceName = "";
 private String userName = "";
 private String duration = "";
 
 private ArrayList<BBNMultiLingualObject> fragmentList = new ArrayList<BBNMultiLingualObject>();
 
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
 
 public String getSourceLanguage()
 {
  return sourceLanguage;
 }
 
 public void setSourceLanguage(String sourceLanguage)
 {
  this.sourceLanguage = LanguageConvert.convertFromName(sourceLanguage);
 }
 
 public String getTargetLanguage()
 {
  if(targetLanguage.length() == 0)
  {
   return LanguageCodeIso6392Type.ENG.toString();
  }

  //
  return sourceLanguage;
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
 
 //
 //
 public void addSpeechFragments(BBNSpeechFragmentObject sourceFragment, BBNSpeechFragmentObject mtFragment)
 {
  BBNMultiLingualObject bbnMultiLingualObject = new BBNMultiLingualObject();
  bbnMultiLingualObject.addSourceSpeechFragment(sourceFragment);
  bbnMultiLingualObject.addMTSpeechFragment(mtFragment);
  
  this.fragmentList.add(bbnMultiLingualObject);
 }
 
 //
 public List<CorporaSegment> getSourceText()
 {
  ArrayList<CorporaSegment> corporaSegmentList = new ArrayList<CorporaSegment>();
  
  for(BBNMultiLingualObject multiLingualObject : fragmentList)
  {
   CorporaSegment segment = new CorporaSegment(this.getSourceLanguage(), multiLingualObject.getSourceObject().getSpeechFragment());
   corporaSegmentList.add(segment);
   
   //
   segment.addSegmentAttribute("fragment_id", multiLingualObject.getSourceObject().getFragmentID());
   segment.addSegmentAttribute("fragment_duration", multiLingualObject.getSourceObject().getFragmentDuration());
   segment.addSegmentAttribute("fragment_offset", multiLingualObject.getSourceObject().getFragmentStartOffset());
   segment.addSegmentAttribute("fragment_start_time", multiLingualObject.getSourceObject().getFragmentStartTime());
  }
  
  //
  return corporaSegmentList;
 }
 
 //
 public List<CorporaSegment> getMTText()
 {
  ArrayList<CorporaSegment> corporaSegmentList = new ArrayList<CorporaSegment>();
  
  for(BBNMultiLingualObject multiLingualObject : fragmentList)
  {
   CorporaSegment segment = new CorporaSegment(this.getTargetLanguage(), multiLingualObject.getMTObject().getSpeechFragment());
   corporaSegmentList.add(segment);
   
   //
   segment.addSegmentAttribute("fragment_id", multiLingualObject.getMTObject().getFragmentID());
   segment.addSegmentAttribute("fragment_duration", multiLingualObject.getMTObject().getFragmentDuration());
   segment.addSegmentAttribute("fragment_offset", multiLingualObject.getMTObject().getFragmentStartOffset());
   segment.addSegmentAttribute("fragment_start_time", multiLingualObject.getMTObject().getFragmentStartTime());
  }
  
  //
  return corporaSegmentList;
 }
 
 //
 public List<CorporaSegment> getSourceAnnotatedText()
 {
  ArrayList<CorporaSegment> corporaSegmentList = new ArrayList<CorporaSegment>();
  
  for(BBNMultiLingualObject multiLingualObject : fragmentList)
  {
   CorporaSegment segment = new CorporaSegment(this.getSourceLanguage(), multiLingualObject.getSourceObject().getAnnotatedSpeechFragment());
   corporaSegmentList.add(segment);
  }
  
  //
  return corporaSegmentList;
 }
 
 //
 public List<CorporaSegment> getMTAnnotatedText()
 {
  ArrayList<CorporaSegment> corporaSegmentList = new ArrayList<CorporaSegment>();
  
  for(BBNMultiLingualObject multiLingualObject : fragmentList)
  {
   CorporaSegment segment = new CorporaSegment(this.getTargetLanguage(), multiLingualObject.getMTObject().getAnnotatedSpeechFragment());
   corporaSegmentList.add(segment);
  }
  
  //
  return corporaSegmentList;
 }
 
 //
 public List<TimeStampObject> getTimestampSourceList(final String fragmentID)
 {
  ArrayList<TimeStampObject> corporaSegmentList = new ArrayList<TimeStampObject>();
  
  for(BBNMultiLingualObject multiLingualObject : fragmentList)
  {
   if(multiLingualObject.getSourceObject().getFragmentID().equals(fragmentID))
   {
    corporaSegmentList.addAll(multiLingualObject.getSourceObject().getTimedSpeechFragments());
   }
  }
  
  //
  return corporaSegmentList;
 }
 
 //
 public List<TimeStampObject> getTimestampMTList(final String fragmentID)
 {
  ArrayList<TimeStampObject> corporaSegmentList = new ArrayList<TimeStampObject>();
  
  for(BBNMultiLingualObject multiLingualObject : fragmentList)
  {
   if(multiLingualObject.getMTObject().getFragmentID().equals(fragmentID))
   {
    corporaSegmentList.addAll(multiLingualObject.getMTObject().getTimedSpeechFragments());
   }
  }
  
  //
  return corporaSegmentList;
 }
}