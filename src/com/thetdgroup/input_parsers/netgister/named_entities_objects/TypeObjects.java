package com.thetdgroup.input_parsers.netgister.named_entities_objects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections.keyvalue.DefaultKeyValue;
import org.apache.commons.collections.map.MultiValueMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class TypeObjects
{
	private ArrayList<DefaultKeyValue> keyValuesList = new ArrayList<DefaultKeyValue>();
	
	private static Pattern DETECTION_PATTERN = Pattern.compile("(\\{detection\\=\\[)(.*?)(\\})");
	private static Pattern EXACT_PATTERN = Pattern.compile("(exact=)(.*?)(,)");
	private static Pattern SUFFIX_PATTERN = Pattern.compile("(suffix=)(.*?)(,)");
	private static Pattern PREFIX_PATTERN = Pattern.compile("(prefix=)(.*?)(,)");
 private static Pattern OFFSET_PATTERN = Pattern.compile("(offset=)(.*?)(,)");
 private static Pattern LENGTH_PATTERN = Pattern.compile("(length=)(.*?)(\\})");
 
 //
 public void parse(JSONArray jsonArray) throws Exception
 {
	 //
	 // For Each entity type (person, places, cities....)
	 for(int iIndex = 0; iIndex < jsonArray.length(); iIndex++)
	 {
	 	JSONObject jsonObject = jsonArray.getJSONObject(iIndex);
	 	
 		DefaultKeyValue keyValueObject = new DefaultKeyValue(jsonObject.getString("type"), jsonObject.getString("name"));
 		keyValuesList.add(keyValueObject);
	 }
 }
 
 //
 public void print()
 {
  System.out.println("##############################");
  int iCount = 0;
  
  for(Iterator<DefaultKeyValue> iIterator = keyValuesList.iterator(); iIterator.hasNext(); iCount++) 
  {
  	DefaultKeyValue item = iIterator.next();
   System.out.println("\n*Counter: " + iCount + "\n*Item key: " + item.getKey() + "\n*Item value: " + item.getValue());
  }
 }
 
 //
 public String getValue(final String typeKey)
 {
  for(Iterator<DefaultKeyValue> iIterator = keyValuesList.iterator(); iIterator.hasNext(); ) 
	 {
	 	DefaultKeyValue item = iIterator.next();
	 	
	 	if(item.getKey().toString().equals(typeKey))
	 	{
	 		return item.getValue().toString();
	 	}
	 }
  
  //
  return "";
 }
 
 //
 public void populateInstanceObject(MultiValueMap entityInstances, final String instanceID, final String instanceType)
 {
	 for(DefaultKeyValue keyValue : keyValuesList)
	 {
	 	if(keyValue.getKey().toString().equals("instances"))
			{
	   //
	 		// Extract each instance
	 		Matcher InstanceMatch = DETECTION_PATTERN.matcher(keyValue.getValue().toString());
	
	 		while(InstanceMatch.find()) 
	 		{
	 		 String detectionString = InstanceMatch.group(0);
	 		 
	 		 DetectedInstance detectedInstance = new DetectedInstance();
	 		 detectedInstance.setInstanceID(instanceID);
	 		 detectedInstance.setInstanceType(instanceType);
	 		 detectedInstance.setInstanceDetection(keyValue.getValue().toString());
	 			
	    //
	    Matcher detectionMatch = EXACT_PATTERN.matcher(detectionString);
	    
	    while(detectionMatch.find()) 
	    {
	    	detectedInstance.setInstanceName(detectionMatch.group(2));
	    }
	    
	    //
	    detectionMatch = SUFFIX_PATTERN.matcher(detectionString);
	    
	    while(detectionMatch.find()) 
	    {
	    	detectedInstance.setSuffix(detectionMatch.group(2));
	    }
	    
	    //
	    detectionMatch = PREFIX_PATTERN.matcher(detectionString);
	    
	    while(detectionMatch.find()) 
	    {
	    	detectedInstance.setPrefix(detectionMatch.group(2));
	    }
	    
	    //
	    detectionMatch = OFFSET_PATTERN.matcher(detectionString);
	    
	    while(detectionMatch.find()) 
	    {
	    	detectedInstance.setInstanceOffset(detectionMatch.group(2));
	    }
	    
	    //
	    detectionMatch = LENGTH_PATTERN.matcher(detectionString);
	    
	    while(detectionMatch.find()) 
	    {
	    	detectedInstance.setInstanceLength(detectionMatch.group(2));
	    }
	    
	    //
	   	entityInstances.put(detectedInstance.getInstanceName(), detectedInstance);
	 		}
			}
	 }
	}
}
