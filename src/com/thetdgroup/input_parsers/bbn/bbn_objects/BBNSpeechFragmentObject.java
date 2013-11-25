package com.thetdgroup.input_parsers.bbn.bbn_objects;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections.map.MultiValueMap;

import com.thetdgroup.srt_parser.timestamp.TimeStampObject;

public final class BBNSpeechFragmentObject
{
 private String sessionID = "";
 private String fragmentStartOffset = "";
 private String fragmentDuration = "";
 private String programID = "";
 private String fragmentID = "";
 private String fragmentStartTime = "";
 
 //
 private TreeMap<Integer, BBNTokenObject> tokenMap = new TreeMap<Integer, BBNTokenObject>();
 private MultiValueMap namedEntityMap = MultiValueMap.decorate(new TreeMap<Integer, ArrayList<BBNNamedEntityObject>>());
 
 //
 public String getSessionID()
 {
  return sessionID;
 }
 
 public void setSessionID(final String sessionID)
 {
  this.sessionID = sessionID;
 }
 
 public String getFragmentStartOffset()
 {
  return fragmentStartOffset;
 }
 
 public void setFragmentStartOffset(final String fragmentStartOffset)
 {
  this.fragmentStartOffset = fragmentStartOffset;
 }
 
 public String getFragmentDuration()
 {
  return fragmentDuration;
 }
 
 public void setFragmentDuration(final String fragmentDuration)
 {
  this.fragmentDuration = fragmentDuration;
 }
 
 public String getProgramID()
 {
  return programID;
 }
 
 public void setProgramID(final String programID)
 {
  this.programID = programID;
 }
 
 public String getFragmentID()
 {
  return fragmentID;
 }
 
 public void setFragmentID(final String fragmentID)
 {
  this.fragmentID = fragmentID;
 }
 
 public String getFragmentStartTime()
 {
  return fragmentStartTime;
 }
 
 public void setFragmentStartTime(final String fragmentStartTime)
 {
  this.fragmentStartTime = fragmentStartTime;
 }
 
 //
 public void addToken(final String tokenID, final BBNTokenObject token)
 {
  this.tokenMap.put(Integer.parseInt(tokenID), token);
 }
 
 //
 public void addNamedEntity(final BBNNamedEntityObject token)
 {
  this.namedEntityMap.put(Integer.parseInt(token.getNamedEntityID()), token);
 }
 
 //
 public String getSpeechFragment()
 {
  StringBuffer stringBuffer = new StringBuffer();
  
  for(Map.Entry<Integer, BBNTokenObject> entry : this.tokenMap.entrySet())
  {
   stringBuffer.append(this.tokenMap.get(entry.getKey()).getPrintForm() + " ");
  }

  //
  return stringBuffer.toString();
 }
 
 //
 public String getAnnotatedSpeechFragment()
 {
  StringBuffer stringBuffer = new StringBuffer();
	 
	 //
	 for(Map.Entry<Integer, BBNTokenObject> entry : this.tokenMap.entrySet())
	 {
	 	BBNTokenObject bbnTokenObject = this.tokenMap.get(entry.getKey());
	 	ArrayList<BBNNamedEntityObject> neObjects = getNamedEntity(bbnTokenObject.getNamedEntityID());

	 	//
	 	if(neObjects != null)
	 	{
	 		boolean neProcessed = false;
	 		boolean neTypeSet = false;
	 		
	 		//
	 		for(BBNNamedEntityObject neObject : neObjects)
	 		{
		 		if(neProcessed == false)
	 			{
	 			 if(neObject.getNameEntityValue() != null)
	 			 {
	 				 stringBuffer.append("<tdg:" + neObject.getNamedEntityType() + ">");
	 				 neTypeSet = true;
	 			 }

	 			 neProcessed = true;
	 			}
	 			
     //
	 			if(neObject.getNameEntityValue() != null)
	 			{
	 			 stringBuffer.append((neObject.getNameEntityValue() + " "));
	 			}
	 			
	 			//
	 			neObject.setNameEntityValue(null);
	 		}
	 		
	 		//
	 	 if(neTypeSet == true)
	 	 {
	 	 	stringBuffer.append("</tdg:" + neObjects.get(0).getNamedEntityType() + ">");
	 	 	neTypeSet = false;
	 	 }
	 	}
	  else
	  {
	  	stringBuffer.append(bbnTokenObject.getPrintForm() + " ");
	  }
	 }
	
	 //
	 return stringBuffer.toString();
 }
 
 //
 public ArrayList<TimeStampObject> getTimedSpeechFragments()
 {
  ArrayList<TimeStampObject> stampsList = new ArrayList<TimeStampObject>();
  
  //
  for(Map.Entry<Integer, BBNTokenObject> entry : this.tokenMap.entrySet())
  {
   BBNTokenObject bbnTokenObject = this.tokenMap.get(entry.getKey());
   
   if(bbnTokenObject.getStartOffset().isEmpty() == false && bbnTokenObject.getDuration().isEmpty() == false)
   {
    TimeStampObject timeStamp = new TimeStampObject(bbnTokenObject.getStartOffset(), bbnTokenObject.getDuration(), bbnTokenObject.getPrintForm());
    stampsList.add(timeStamp);
   }
  }
 
  //
  return stampsList;  
 }
 
 //
 @SuppressWarnings("unchecked")
	private ArrayList<BBNNamedEntityObject> getNamedEntity(final String namedEntityID)
 {
  if(namedEntityID.length() > 0)
  {
  	return (ArrayList<BBNNamedEntityObject>) this.namedEntityMap.getCollection(Integer.parseInt(namedEntityID));
  }
  
  //
  return null;
 }
}
