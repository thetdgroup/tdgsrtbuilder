package com.thetdgroup.input_parsers.netgister;

import org.json.JSONArray;
import org.json.JSONObject;

import com.thetdgroup.input_parsers.netgister.netgister_objects.NetgisterAssetObject;
import com.thetdgroup.input_parsers.netgister.netgister_objects.NetgisterNamedEntityObject;
import com.thetdgroup.srt_parser.corpus_information.CorpusInformation;

//
public class NetgisterJSONReader
{ 
	//
 private CorpusInformation corpusInformation = new CorpusInformation();
 private NetgisterAssetObject netgisterAssetObject = new NetgisterAssetObject();

 //
 public NetgisterJSONReader()
	{
	 
	}
 
 //
 // This will parse the JSON object and make it ready for the tdg schema
 //
 public void parse(JSONObject jsonObject) throws Exception
	{
	 JSONObject jsonContentData = jsonObject.getJSONObject("content_data");
	 JSONArray jsonLanguages = jsonObject.getJSONArray("discovered_languages");
	 JSONObject jsonContentMetaData = jsonContentData.getJSONObject("content_metadata");
	 JSONObject jsonSemanticData = jsonObject.getJSONObject("semantic_object");
	 
	 //
	 // Process Corpus Info
 // corpusInformation.setMediaID(mediaID);
 // corpusInformation.setProjectID(projectID);
	// corpusInformation.setProjectName(projectName);
	// corpusInformation.setProjectDescription(projectDescription);
	 
	 //
	 // asset info
	 netgisterAssetObject.setAssetName(jsonContentData.getString("imported_file_name"));
	 
  //
  // language data
	 netgisterAssetObject.setSourceLanguage(jsonLanguages);
	 
	 // text data
	 netgisterAssetObject.addSourceFragments(jsonContentData.getString("content_text"));
 
  //
  // Process Names Entities
  NetgisterNamedEntityObject nameEntitiesObject = new NetgisterNamedEntityObject();
  nameEntitiesObject.parse(jsonSemanticData);
  //nameEntitiesObject.print();
  
  // ... add to assets
  netgisterAssetObject.addNamedEntityObject(nameEntitiesObject);
	}
 
 //
 //
 public NetgisterAssetObject getAssetObject()
 {
  return this.netgisterAssetObject;
 }
 
 //
 public void print()
 {
  this.netgisterAssetObject.getNamedEntityObject().print();
 }
 
 //
 public void printInput(JSONObject jsonNetgisterObject)throws Exception
 {
	 System.out.println("content_text: " + jsonNetgisterObject.getJSONObject("content_data").getString("content_text"));
	 System.out.println("node_path: " + jsonNetgisterObject.getJSONObject("content_data").getString("node_path"));
	 System.out.println("data_size: " + jsonNetgisterObject.getJSONObject("content_data").getString("data_size"));
	 System.out.println("type_display: " + jsonNetgisterObject.getJSONObject("content_data").getString("type_display"));
	 System.out.println("document_signature: " + jsonNetgisterObject.getJSONObject("content_data").getString("document_signature"));
	 System.out.println("imported_file_name: " + jsonNetgisterObject.getJSONObject("content_data").getString("imported_file_name"));
	 System.out.println("jcr:versionHistory: " + jsonNetgisterObject.getJSONObject("content_data").getString("jcr:versionHistory"));
	 System.out.println("jcr:uuid: " + jsonNetgisterObject.getJSONObject("content_data").getString("jcr:uuid"));
	 System.out.println("node_icon: " + jsonNetgisterObject.getJSONObject("content_data").getString("node_icon"));
	 System.out.println("node_image: " + jsonNetgisterObject.getJSONObject("content_data").getString("node_image"));
	 System.out.println("parent_node_path: " + jsonNetgisterObject.getJSONObject("content_data").getString("parent_node_path"));
	 System.out.println("jcr:baseVersion: " + jsonNetgisterObject.getJSONObject("content_data").getString("jcr:baseVersion"));
	 System.out.println("node_created_date: " + jsonNetgisterObject.getJSONObject("content_data").getString("node_created_date"));
	 System.out.println("jcr:isCheckedOut: " + jsonNetgisterObject.getJSONObject("content_data").getString("jcr:isCheckedOut"));
	 System.out.println("resource_name_key: " + jsonNetgisterObject.getJSONObject("content_data").getString("resource_name_key"));
	 System.out.println("jcr:mimeType: " + jsonNetgisterObject.getJSONObject("content_data").getString("jcr:mimeType"));
	 System.out.println("content_encoding: " + jsonNetgisterObject.getJSONObject("content_data").getString("content_encoding"));
	 System.out.println("node_name: " + jsonNetgisterObject.getJSONObject("content_data").getString("node_name"));
	 System.out.println("content_type: " + jsonNetgisterObject.getJSONObject("content_data").getString("content_type"));
	 System.out.println("file_physical_location: " + jsonNetgisterObject.getJSONObject("content_data").getString("file_physical_location"));
	 System.out.println("jcr:primaryType: " + jsonNetgisterObject.getJSONObject("content_data").getString("jcr:primaryType"));
	
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("application_name"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("manager"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("location"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("rights"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("type"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("license_location"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("slide_count"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("is_protected"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("description"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("contributor"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("character_count"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("resource_name_key"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("content_type"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("template"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("last_saved"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("keywords"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("content_location"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("character_count_with_whitespace"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("relation"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("format"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("content_status"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("modified"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("company"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("content_language"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("last_author"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("content_md5"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("language"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("identifier"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("presentation_format"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("last_printed"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("paragraph_count"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("subject"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("edit_time"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("license_url"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("mimetype_magic"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("security"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("date"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("version"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("creator"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("page_count"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("publisher"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("creation_date"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("author"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("revision_number"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("word_count"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("tika_mimetype"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("total_time"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("last_modifier"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("work_type"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("imported_file_name"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("content_disposition"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("line_count"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("source"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("coverage"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("application_version"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("content_length"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("notes"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("content_encoding"));
	 System.out.println(jsonNetgisterObject.getJSONObject("content_data").getJSONObject("content_metadata").getString("comments"));
 }
}
