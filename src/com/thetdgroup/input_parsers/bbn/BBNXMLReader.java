package com.thetdgroup.input_parsers.bbn;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import com.thetdgroup.input_parsers.bbn.bbn_objects.BBNAssetObject;
import com.thetdgroup.input_parsers.bbn.bbn_objects.BBNNamedEntityObject;
import com.thetdgroup.input_parsers.bbn.bbn_objects.BBNSpeechFragmentObject;
import com.thetdgroup.input_parsers.bbn.bbn_objects.BBNTokenObject;
import com.thetdgroup.srt_parser.corpus_information.CorpusInformation;

public class BBNXMLReader extends DefaultHandler
{
 //
 // Flags
 private boolean isAsset = false;
 
 private boolean isFragmentCollection = false;
 private boolean isFragmentSet = false;
 private boolean isSourceSpeechFragment = false;
 private boolean isMTSpeechFragment = false;
 private boolean isToken = false;
 private boolean isMTToken = false;
 
 private boolean isAnnotatedFragmentCollection = false;
 private boolean isAnnotatedFragmentSet = false;
 private boolean isAnnotatedSpeechFragment = false;
 private boolean isAnnotatedToken = false;
 private boolean isSpeechHTFragment = false;
 private boolean isHtToken = false;
 
 //
 // Elements
 private static String assetTag = "asset";
 private static String fragmentCollectionTag = "fragment_collection";
 private static String fragmentSetTag = "fragment_set";
 private static String speechFragmentTag = "speech_fragment";
 private static String tokenTag = "token";
 
 private static String mtFragmentTag = "speech_mt_fragment";
 private static String mtTokenTag = "mt_token";
 
 //
 private CorpusInformation corpusInformation = null;
 private BBNAssetObject bbnAssetObject = null;
 private BBNSpeechFragmentObject speechFragment = null;
 private BBNSpeechFragmentObject speechMTFragment = null;
 
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
  if(qualifiedName.equals(assetTag))
  {
   isAsset = true;
   bbnAssetObject = new BBNAssetObject();
   
   //
   // read attributes
   bbnAssetObject.setSessionID(attributes.getValue("session_id"));
   bbnAssetObject.setAssetName(attributes.getValue("asset_name"));
   bbnAssetObject.setUploadTime(attributes.getValue("upload_time"));
   bbnAssetObject.setLastModifiedTime(attributes.getValue("last_modified_time"));
   bbnAssetObject.setMediaURI(attributes.getValue("media_uri"));
   bbnAssetObject.setMediaType(attributes.getValue("media_type"));
   bbnAssetObject.setSourceLanguage(attributes.getValue("source_language"));
   bbnAssetObject.setSourceName(attributes.getValue("source_name"));
   bbnAssetObject.setUserName(attributes.getValue("user_name"));
   bbnAssetObject.setDuration(attributes.getValue("duration"));
  }
  else if(qualifiedName.equals(fragmentCollectionTag))
  {
   isFragmentCollection = true;
  }
  else if(qualifiedName.equals(fragmentSetTag))
  {
   isFragmentSet = true;
  }
  else if(qualifiedName.equals(speechFragmentTag))
  {
   isSourceSpeechFragment = true;
   speechFragment = new BBNSpeechFragmentObject();
   
   //
   // read attributes
   speechFragment.setSessionID(attributes.getValue("session_id"));
   speechFragment.setFragmentStartOffset(attributes.getValue("fragment_start_offset"));
   speechFragment.setFragmentDuration(attributes.getValue("fragment_duration"));
   speechFragment.setProgramID(attributes.getValue("program_id"));
   speechFragment.setFragmentID(attributes.getValue("fragment_id"));
   speechFragment.setFragmentStartTime(attributes.getValue("fragment_start_time"));
  }
  else if(qualifiedName.equals(tokenTag))
  {
   isToken = true;
   BBNTokenObject bbnTokenObject = new BBNTokenObject();
   
   //
   // read attributes
   bbnTokenObject.setStartOffset(attributes.getValue("token_start_offset"));
   bbnTokenObject.setDuration(attributes.getValue("token_duration"));
   bbnTokenObject.setTokenType(attributes.getValue("token_type"));
   bbnTokenObject.setSentenceID(attributes.getValue("sentence_id"));
   bbnTokenObject.setSentenceType(attributes.getValue("sentence_type"));
   bbnTokenObject.setSentenceBoundary(attributes.getValue("token_duration"));
   bbnTokenObject.setSpeakerID(attributes.getValue("speaker_id"));
   bbnTokenObject.setSpeakerGender(attributes.getValue("speaker_gender"));
   bbnTokenObject.setSpeakerName(attributes.getValue("speaker_name"));
   bbnTokenObject.setSessionID(attributes.getValue("session_id"));
   bbnTokenObject.setBaseForm(attributes.getValue("token_base_form"));
   bbnTokenObject.setBaseStartOffset(attributes.getValue("token_base_start_offset"));
   bbnTokenObject.setBaseDuration(attributes.getValue("token_base_duration"));
   bbnTokenObject.setPrintForm(attributes.getValue("token_print_form"));
   bbnTokenObject.setTokenID(attributes.getValue("token_id"));
   bbnTokenObject.setFragmentID(attributes.getValue("original_fragment_id"));
   
   //
   // ... and named entities, if any
   if(attributes.getValue("named_entity_id") != null)
   {
   	//
   	bbnTokenObject.setNamedEntityID(attributes.getValue("named_entity_id"));
   	
   	//
   	BBNNamedEntityObject bbnNEObject = new BBNNamedEntityObject();
	   bbnNEObject.setTokenID(attributes.getValue("token_id"));
	   bbnNEObject.setTokenLanguage(bbnAssetObject.getSourceLanguage());
	   bbnNEObject.setFragmentID(attributes.getValue("original_fragment_id"));
	   bbnNEObject.setNamedEntityID(attributes.getValue("named_entity_id"));
	   bbnNEObject.setNamedEntityBoundary(attributes.getValue("named_entity_boundary"));
	   bbnNEObject.setNamedEntityType(attributes.getValue("named_entity_type"));
	   bbnNEObject.setNameEntityValue(attributes.getValue("token_print_form"));
	   
	   speechFragment.addNamedEntity(bbnNEObject);
   }
   
   //
   // ... and add fragment and named entity (if any)
   speechFragment.addToken(bbnTokenObject.getTokenID(), bbnTokenObject);
  }
  else if(qualifiedName.equals(mtFragmentTag))
  {
   isMTSpeechFragment = true;
   speechMTFragment = new BBNSpeechFragmentObject();
   
   //
   // read attributes
   speechMTFragment.setSessionID(attributes.getValue("session_id"));
   speechMTFragment.setFragmentStartOffset(attributes.getValue("fragment_start_offset"));
   speechMTFragment.setFragmentDuration(attributes.getValue("fragment_duration"));
   speechMTFragment.setProgramID(attributes.getValue("program_id"));
   speechMTFragment.setFragmentID(attributes.getValue("fragment_id"));
   speechMTFragment.setFragmentStartTime(attributes.getValue("fragment_start_time"));
  }
  else if(qualifiedName.equals(mtTokenTag))
  {
   isMTToken = true;
   BBNTokenObject bbnTokenObject = new BBNTokenObject();
   
   //
   // read attributes
   bbnTokenObject.setTokenID(attributes.getValue("token_id"));
   bbnTokenObject.setTokenType(attributes.getValue("token_type"));
   bbnTokenObject.setPrintForm(attributes.getValue("token_print_form"));
   bbnTokenObject.setSessionID(attributes.getValue("session_id"));
   bbnTokenObject.setFragmentID(attributes.getValue("original_fragment_id"));   

   //
   // ... and named entities, if any
   if(attributes.getValue("named_entity_id") != null)
   {
   	//
   	bbnTokenObject.setNamedEntityID(attributes.getValue("named_entity_id"));
   	
   	//
   	BBNNamedEntityObject bbnNEObject = new BBNNamedEntityObject();
	   bbnNEObject.setTokenID(attributes.getValue("token_id"));
	   bbnNEObject.setTokenLanguage(bbnAssetObject.getTargetLanguage());
	   bbnNEObject.setFragmentID(attributes.getValue("original_fragment_id"));
	   bbnNEObject.setNamedEntityID(attributes.getValue("named_entity_id"));
	   bbnNEObject.setNamedEntityBoundary(attributes.getValue("named_entity_boundary"));
	   bbnNEObject.setNamedEntityType(attributes.getValue("named_entity_type"));
	   bbnNEObject.setNameEntityValue(attributes.getValue("token_print_form"));
	   
	   speechMTFragment.addNamedEntity(bbnNEObject);
   }
   
   //
   // ... and add fragment
   speechMTFragment.addToken(bbnTokenObject.getTokenID(), bbnTokenObject);
  }
 }
 
 public void endElement(String uri, String localName, String qualifiedName)
 {
  if(qualifiedName.equals(assetTag))
  {
   // reset
   isAsset = false;
  }
  else if(qualifiedName.equals(fragmentCollectionTag))
  {
   // reset
   isFragmentCollection = false;
  }
  else if(qualifiedName.equals(fragmentSetTag))
  {
   // reset
   isFragmentSet = false;
   
   //
   // add
   bbnAssetObject.addSpeechFragments(speechFragment, speechMTFragment);
   speechFragment = null;
   speechMTFragment = null;
  }
  else if(qualifiedName.equals(speechFragmentTag))
  {
   // reset
   isSourceSpeechFragment = false;
  }
  else if(qualifiedName.equals(mtFragmentTag))
  {
   // reset
   isMTSpeechFragment = false;
  }
  else if(qualifiedName.equals(tokenTag))
  {
   // reset
   isToken = false;
  }
  else if(qualifiedName.equals(mtTokenTag))
  {
   // reset
   isMTToken = false;
  } 
 }
 
 //
 public void characters(char[] characters, int startIndex, int endIndex)
 {
 }
 
 //
 //
 public BBNAssetObject getAssetObject()
 {
  return this.bbnAssetObject;
 }
}
