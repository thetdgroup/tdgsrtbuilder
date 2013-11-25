package com.thetdgroup.input_parsers.new_captions;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import com.thetdgroup.srt_parser.corpus_information.CorpusInformation;
import com.thetdgroup.srt_parser.corpus_segment.CorporaSegment;

//
public class NCXMLReader extends DefaultHandler
{
 //
 // Flags
	private boolean isDataDefinition = false;
	private boolean isProjectID = false;
	private boolean isProjectTitle = false;
	private boolean isMediaID = false;
	private boolean isMediaTitle = false;
	private boolean isMediaSubject = false;
	private boolean isMediaKeywords = false;
	private boolean isMediaLength = false;
		
 private boolean isDescription = false;
 private boolean isAudioLength = false;
 private boolean isAudioURL = false;
 private boolean isStartTime = false;
 private boolean isEndTime = false;
 
 private boolean isSourceSegment = false; 
 private boolean isSourceSegmentLanguage = false;
 private boolean isSourceTimedSeg = false;
 private boolean isTargetSegment = false; 
 private boolean isTargetSegmentLanguage = false;
 private boolean isTargetTimedSeg = false;
 
 //
 // Elements
 private static String rdfDataDefinitionTag = "rdf:DataDefinition";
 private static String projectIDTag = "tdg:projectid";
 private static String projectTitleTag = "tdg:projecttitle";
 private static String mediaIDTag = "tdg:mediaid";
 private static String mediaTitleTag = "tdg:mediatitle";
 private static String mediaSubjectTag = "tdg:mediasubject";
 private static String mediaKeywordsTag = "tdg:mediakeyword";
 private static String mediaLengthTag = "tdg:medialength";
  
 private static String rdfDescriptionTag = "rdf:Description";
 private static String segmentAudioLengthTag = "tdg:audiolength";
 private static String segmentAudioURLTag = "tdg:audiourl";
 private static String segmentStartTimeTag = "tdg:starttime";
 private static String segmentEndTimeTag = "tdg:endtime";
 private static String sourceSegmentLanguageTag = "tdg:sourcelang";
 private static String sourceTimedSegmentTag = "tdg:sourceorg";
 private static String sourceSegmentTag = "tdg:sourceseg";
 private static String targetSegmentLanguageTag = "tdg:targetlang";
 private static String targetTimedSegmentTag = "tdg:targetorg";
 private static String targetSegmentTag = "tdg:targetseg";
 
 //
 // Media Information
 private String projectID = "";
 private String projectTitle = "";
 private String mediaID = "";
 private String mediaTitle = "";
 private String mediaSubject = "";
 private ArrayList<String> mediaKeywordsList = new ArrayList<String>();
 private String mediaLength = "";
 
 //
 // Segment Content
 private String currentSourceLanguage = "";
 private String currentSourceSegmentText = "";
 private String currentSourceTimedSegmentText = "";
 private String currentTargetLanguage = "";
 private String currentTargetSegmentText = "";
 private String currentTargetTimedSegmentText = "";
 
 //
 // Segment timing info (and URL)
 private String currentStartTime = "";
 private String currentEndTime = "";
 private String currentAudioLength = "";
 private String currentAudioURL = "";
 
 //
 //
 private ArrayList<CorporaSegment> ncSegments = new ArrayList<CorporaSegment>();
 private CorporaSegment corporaSegment = null;
 private CorpusInformation corpusInformation = null;
 
 //
 //
 public void startDocument()
 {
 }
 
 public void endDocument()
 {
 }
 
 //
 public void startElement(String uri, String localName, String qualifiedName, Attributes attributes)
 {
  if(qualifiedName.equals(rdfDataDefinitionTag))
  {
  	isDataDefinition = true;
  	corpusInformation = new CorpusInformation();
  }
  else if(qualifiedName.equals(projectIDTag))
  {
  	isProjectID = true;
  }
  else if(qualifiedName.equals(projectTitleTag))
  {
  	isProjectTitle = true;
  }
  else if(qualifiedName.equals(mediaIDTag))
  {
  	isMediaID = true;
  }
  else if(qualifiedName.equals(mediaTitleTag))
  {
  	isMediaTitle = true;
  }
  else if(qualifiedName.equals(mediaSubjectTag))
  {
  	isMediaSubject = true;
  }
  else if(qualifiedName.equals(mediaKeywordsTag))
  {
  	isMediaKeywords = true;
  }
  else if(qualifiedName.equals(mediaLengthTag))
  {
  	isMediaLength = true;
  }
  else if(qualifiedName.equals(rdfDescriptionTag))
  {
   isDescription = true;
   corporaSegment = new CorporaSegment(attributes.getValue("tdg:index"));
  }
  else if(qualifiedName.equals(sourceSegmentLanguageTag))
  {
   isSourceSegmentLanguage = true;
  }
  else if(qualifiedName.equals(sourceSegmentTag))
  {
   isSourceSegment = true;
  }
  else if(qualifiedName.equals(sourceTimedSegmentTag))
  {
  	isSourceTimedSeg = true;
  }
  else if(qualifiedName.equals(targetSegmentLanguageTag))
  {
   isTargetSegmentLanguage = true;
  }
  else if(qualifiedName.equals(targetSegmentTag))
  {
   isTargetSegment = true;
  }
  else if(qualifiedName.equals(targetTimedSegmentTag))
  {
   isTargetTimedSeg = true;
  }
  else if(qualifiedName.equals(segmentStartTimeTag))
  {
   isStartTime = true;
  }
  else if(qualifiedName.equals(segmentEndTimeTag))
  {
   isEndTime = true;
  }
  else if(qualifiedName.equals(segmentAudioLengthTag))
  {
   isAudioLength = true;
  }
  else if(qualifiedName.equals(segmentAudioURLTag))
  {
   isAudioURL = true;
  }
 }
 
 public void endElement(String uri, String localName, String qualifiedName)
 {
	 if(qualifiedName.equals(rdfDataDefinitionTag))
	 {
	  // reset
	 	isDataDefinition = false;
	 }
	 else if(qualifiedName.equals(projectIDTag))
	 {
	  corpusInformation.setProjectID(projectID);
	  
   // reset
	 	isProjectID = false;
	 	projectID = "";
	 }
	 else if(qualifiedName.equals(projectTitleTag))
	 {
	//  corpusInformation
	  
   // reset
	  projectTitle = "";
	 	isProjectTitle = false;
	 }
	 else if(qualifiedName.equals(mediaIDTag))
	 {
	 	
   // reset
	  mediaID = "";
	 	isMediaID = false;
	 }
	 else if(qualifiedName.equals(mediaTitleTag))
	 {
	 	
   // reset
	  mediaTitle = "";
	 	isMediaTitle = false;
	 }
	 else if(qualifiedName.equals(mediaSubjectTag))
	 {
	 	
   // reset
	 	isMediaSubject = false;
	 }
	 else if(qualifiedName.equals(mediaKeywordsTag))
	 {
	 	
   // reset
	 	isMediaKeywords = false;
	 }
	 else if(qualifiedName.equals(mediaLengthTag))
	 {
	 	
   // reset
	 	isMediaLength = false;
	 } 
	 else if(qualifiedName.equals(rdfDescriptionTag))
  {
   // save in map
   ncSegments.add(corporaSegment);
   
   // reset
   isDescription = false;
   corporaSegment = null;
  }
  else if(qualifiedName.equals(sourceSegmentLanguageTag))
  {
  	corporaSegment.setSegmentLanguage(currentSourceLanguage);
  	
  	// reset
   isSourceSegmentLanguage = false;
   currentSourceLanguage = "";
  }
  else if(qualifiedName.equals(targetSegmentLanguageTag))
  {
   corporaSegment.setSegmentLanguage(currentTargetLanguage);
   
   // reset
   isTargetSegmentLanguage = false;
   currentTargetLanguage = "";
  }
  else if(qualifiedName.equals(sourceTimedSegmentTag))
  {
  	corporaSegment.setTimedSegment(currentSourceTimedSegmentText);
  	
  	// reset
  	isSourceTimedSeg = false;
  	currentSourceTimedSegmentText = "";
  }
  else if(qualifiedName.equals(targetTimedSegmentTag))
  {
   //corporaSegment.setTimedSegment(currentTargetTimedSegmentText);
   
   // reset
   isTargetTimedSeg = false;
   currentTargetTimedSegmentText = "";
  }
  else if(qualifiedName.equals(sourceSegmentTag))
  {
  	corporaSegment.setSegmentText(currentSourceSegmentText);
   
   // reset
  	isSourceSegment = false;
   currentSourceSegmentText = "";
  }
  else if(qualifiedName.equals(targetSegmentTag))
  {
  // corporaSegment.setSegmentText(currentTargetSegmentText);
   
   // reset
   isTargetSegment = false;
   currentTargetSegmentText = "";
  }
  else if(qualifiedName.equals(segmentStartTimeTag))
  {
   corporaSegment.setStartTime(currentStartTime);
   
   // reset
   isStartTime = false;
   currentStartTime = "";
  }
  else if(qualifiedName.equals(segmentEndTimeTag))
  {
   corporaSegment.setEndTime(currentEndTime);
   
   // reset
   isEndTime = false;
   currentEndTime = "";
  }
  else if(qualifiedName.equals(segmentAudioURLTag))
  {
   corporaSegment.setAudioURL(currentAudioURL);
   
   // reset
   isAudioURL = false;
   currentAudioURL = "";
  }
  else if(qualifiedName.equals(segmentAudioLengthTag))
  {
   corporaSegment.setAudioLength(currentAudioLength);
   
   // reset
   isAudioLength = false;
   currentAudioLength = "";
  }
 }
 
 //
 public void characters(char[] characters, int startIndex, int endIndex)
 {
  if(isProjectID)
  {
  	projectID = new String(characters, startIndex, endIndex).trim();
  }
  else if(isProjectTitle)
  {
  	projectTitle = new String(characters, startIndex, endIndex).trim();
  }
  else if(isMediaID)
  {
  	mediaID = new String(characters, startIndex, endIndex).trim();
  }
  else if(isMediaTitle)
  {
  	mediaTitle = new String(characters, startIndex, endIndex).trim();
  }
  else if(isMediaSubject)
  {
  	mediaSubject = new String(characters, startIndex, endIndex).trim();
  }
  else if(isMediaKeywords)
  {
  	String mediaKeywords = new String(characters, startIndex, endIndex).trim();
  	String[] keywords = mediaKeywords.split(",");
  	
  	for(String keyword : keywords)
  	{
  	 mediaKeywordsList.add(keyword);
  	}
  }
  else if(isMediaLength)
  {
  	mediaLength = new String(characters, startIndex, endIndex).trim();
  }
  else if(isSourceSegment)
  {
   currentSourceSegmentText = new String(characters, startIndex, endIndex).trim();
  }
  else if(isSourceTimedSeg)
  {
  	currentSourceTimedSegmentText = new String(characters, startIndex, endIndex).trim();
  }  
  else if(isSourceSegmentLanguage)
  {
  	currentSourceLanguage = new String(characters, startIndex, endIndex).trim();
  }
  else if(isTargetSegment)
  {
   currentTargetSegmentText = new String(characters, startIndex, endIndex).trim();
  }
  else if(isTargetTimedSeg)
  {
   currentTargetTimedSegmentText = new String(characters, startIndex, endIndex).trim();
  }  
  else if(isTargetSegmentLanguage)
  {
   currentTargetLanguage = new String(characters, startIndex, endIndex).trim();
  }
  else if(isStartTime)
  {
   currentStartTime = new String(characters, startIndex, endIndex).trim();
  }
  else if(isEndTime)
  {
   currentEndTime = new String(characters, startIndex, endIndex).trim();
  }
  else if(isAudioURL)
  {
   currentAudioURL = new String(characters, startIndex, endIndex).trim();
  }
  else if(isAudioLength)
  {
   currentAudioLength = new String(characters, startIndex, endIndex).trim();
  }
 }
 
 //
 //
 public ArrayList<CorporaSegment> getSegments()
 {
  return ncSegments;
 }
 
 //
 public String getMediaLength()
 {
  return mediaLength;
 }
 
 public CorpusInformation getCorpusInformation()
 {
  return corpusInformation;
 }
}