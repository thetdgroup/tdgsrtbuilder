package com.thetdgroup.input_parsers.netgister.netgister_objects;

import org.json.JSONObject;

import com.thetdgroup.input_parsers.netgister.named_entities_objects.EntitiesObject;
import com.thetdgroup.input_parsers.netgister.named_entities_objects.RelationsObject;
import com.thetdgroup.input_parsers.netgister.named_entities_objects.SocialTagsObject;
import com.thetdgroup.input_parsers.netgister.named_entities_objects.TopicsObject;

public class NetgisterNamedEntityObject
{
 private SocialTagsObject socialTags = null;
 private EntitiesObject entitiesObject = null;
 private RelationsObject relationsObject = null;
 private TopicsObject topicsObject = null;
 
 //
 public void parse(JSONObject jsonObject) throws Exception
 {
  //
  if(jsonObject.has("extracted_social_tags"))
  {
  	socialTags = new SocialTagsObject();
  	socialTags.parse(jsonObject.getJSONArray("extracted_social_tags"));
  }
  
  //
  if(jsonObject.has("extracted_entities"))
  {
  	entitiesObject = new EntitiesObject();
  	entitiesObject.parse(jsonObject.getJSONArray("extracted_entities"));
  }  
  
  //
  if(jsonObject.has("extracted_relations"))
  {
  	relationsObject = new RelationsObject();
  	relationsObject.parse(jsonObject.getJSONArray("extracted_relations"));
  }
  
  //
  if(jsonObject.has("extracted_topics"))
  {
  	topicsObject = new TopicsObject();
  	topicsObject.parse(jsonObject.getJSONArray("extracted_topics"));
  } 
 }
 
 //
 public SocialTagsObject getSocialTagsObject()
 {
  return socialTags;
 }
 
 //
 public EntitiesObject getEntitiesObject()
 {
  return entitiesObject;
 }
 
 //
 public RelationsObject getRelationsObject()
 {
  return relationsObject;
 }
 
 //
 public TopicsObject getTopicsObject()
 {
  return topicsObject;
 }
 
 //
 public void print()
 {
  System.out.println("*********************************************");
  System.out.println("************ printing social tags ***********");
  System.out.println("*********************************************");
  socialTags.print();
  
  System.out.println("*********************************************");
  System.out.println("******* printing named entities tags ********");
  System.out.println("*********************************************");
  entitiesObject.print();
  
  System.out.println("*********************************************");
  System.out.println("********** printing relational tags *********");
  System.out.println("*********************************************");
  relationsObject.print();
  
  System.out.println("*********************************************");
  System.out.println("*************** printing topics *************");
  System.out.println("*********************************************");
  topicsObject.print();
 }
 
/* 
 jsonResponse.put("response_info", jsonResponseInfo);
 jsonResponse.put("response_meta_info", jsonMetaInfo);*/

}
