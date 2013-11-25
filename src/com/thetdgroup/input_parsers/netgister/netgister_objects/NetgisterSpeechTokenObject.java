package com.thetdgroup.input_parsers.netgister.netgister_objects;

public final class NetgisterSpeechTokenObject
{
 private String tokenID = "";
 private String fragmentID = "";
 private String originalFragmentID = "";
 
 private String startOffset = "";
 private String baseStartOffset = "";
 private String baseDuration = "";
 
 private String duration = "";
 private String tokenType = "";
 
 private String sentenceID = "";
 private String sentenceType = "";
 private String sentenceBoundary = "";
 
 private String speakerID = "";
 private String speakerGender = "";
 private String speakerName = "";
 private String speakerBoundary = "";
 
 private String sessionID = "";
 private String baseForm = "";
 private String printForm = "";
 
 //
 public String getFragmentID()
 {
  return fragmentID;
 }
 
 public void setFragmentID(String fragmentID)
 {
  this.fragmentID = fragmentID;
 }
 
 public String getTokenID()
 {
  return tokenID;
 }
 
 public void setTokenID(String tokenID)
 {
  this.tokenID = tokenID;
 }
 
 public String getStartOffset()
 {
  return startOffset;
 }
 
 public void setStartOffset(String startOffset)
 {
  this.startOffset = startOffset;
 }
 
 public String getBaseStartOffset()
 {
  return baseStartOffset;
 }
 
 public void setBaseStartOffset(String baseStartOffset)
 {
  this.baseStartOffset = baseStartOffset;
 }
 
 public String getBaseDuration()
 {
  return baseDuration;
 }
 
 public void setBaseDuration(String baseDuration)
 {
  this.baseDuration = baseDuration;
 }
 
 public String getDuration()
 {
  return duration;
 }
 
 public void setDuration(String duration)
 {
  this.duration = duration;
 }
 
 public String getTokenType()
 {
  return tokenType;
 }
 
 public void setTokenType(String tokenType)
 {
  this.tokenType = tokenType;
 }
 
 public String getSentenceID()
 {
  return sentenceID;
 }
 
 public void setSentenceID(String sentenceID)
 {
  this.sentenceID = sentenceID;
 }
 
 public String getSentenceType()
 {
  return sentenceType;
 }
 
 public void setSentenceType(String sentenceType)
 {
  this.sentenceType = sentenceType;
 }
 
 public String getSentenceBoundary()
 {
  return sentenceBoundary;
 }
 
 public void setSentenceBoundary(String sentenceBoundary)
 {
  this.sentenceBoundary = sentenceBoundary;
 }
 
 public String getSpeakerID()
 {
  return speakerID;
 }
 
 public void setSpeakerID(String speakerID)
 {
  this.speakerID = speakerID;
 }
 
 public String getSpeakerGender()
 {
  return speakerGender;
 }
 
 public void setSpeakerGender(String speakerGender)
 {
  this.speakerGender = speakerGender;
 }
 
 public String getSpeakerName()
 {
  return speakerName;
 }
 
 public void setSpeakerName(String speakerName)
 {
  this.speakerName = speakerName;
 }
 
 public String getSpeakerBoundary()
 {
  return speakerBoundary;
 }
 
 public void setSpeakerBoundary(String speakerBoundary)
 {
  this.speakerBoundary = speakerBoundary;
 }
 
 public String getSessionID()
 {
  return sessionID;
 }
 
 public void setSessionID(String sessionID)
 {
  this.sessionID = sessionID;
 }
 
 public String getBaseForm()
 {
  return baseForm;
 }
 
 public void setBaseForm(String baseForm)
 {
  this.baseForm = baseForm;
 }
 
 public String getPrintForm()
 {
  return printForm;
 }
 
 public void setPrintForm(String printForm)
 {
  this.printForm = printForm;
 }

	public String getOriginalFragmentID()
	{
	return originalFragmentID;
	}

	public void setOriginalFragmentID(String originalFragmentID)
	{
	this.originalFragmentID = originalFragmentID;
	}
}
