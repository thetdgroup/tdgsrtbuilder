package com.thetdgroup.input_parsers.netgister.named_entities_objects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.collections.map.MultiValueMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class BaseEntityObject
{
	private MultiValueMap entitiesMap = MultiValueMap.decorate(new TreeMap<String, TypeObjects>());
 
	//
	public void parse(JSONArray jsonArray) throws Exception
 {
  //
  // For Each entity type (person, places, cities....)
  for(int iIndex = 0; iIndex < jsonArray.length(); iIndex++)
  {
  	JSONObject jsonObject = jsonArray.getJSONObject(iIndex);
  	JSONArray objectName = jsonObject.names();
  	
  	//
  	// Parse the properties for this key
  	TypeObjects typeObject = new TypeObjects();
   typeObject.parse(jsonObject.getJSONArray(objectName.get(0).toString()));
  	
  	//
  	// Store
  	entitiesMap.put(objectName.get(0).toString(), typeObject);
  }
 }
	
	public MultiValueMap getEntities()
	{
	 return entitiesMap;
	}
	
	public ArrayList<TypeObjects> getEntities(final String entity)
	{
	 ArrayList<TypeObjects> entities = new ArrayList<TypeObjects>();
	 
	 //
		Set<String> collectionMapKeys = entitiesMap.keySet(); 
	 Iterator<String> mapIterator = collectionMapKeys.iterator();
	
		while(mapIterator.hasNext())
		{
			String entityType = mapIterator.next();
			
			if(entity.equalsIgnoreCase(entityType))
			{
				Collection<TypeObjects> entityCollection = entitiesMap.getCollection(entityType);
				Iterator<TypeObjects> collectionIterator = entityCollection.iterator();
			 
			 while(collectionIterator.hasNext())
			 {
			 	TypeObjects typeObject = collectionIterator.next();
			 	entities.add(typeObject);
    }
			}
		}
		
		//
		return entities;
	}
	
	//
 public void print()
 {
		Set<String> collectionMapKeys = entitiesMap.keySet(); 
	 Iterator<String> mapIterator = collectionMapKeys.iterator();
	
		while(mapIterator.hasNext())
		{
			String entityType = mapIterator.next();
			
	  System.out.println("*********************************************");
			System.out.println("All about: " + entityType);
	  System.out.println("*********************************************");
	
			//
			Collection<TypeObjects> entityCollection = entitiesMap.getCollection(entityType);
			Iterator<TypeObjects> collectionIterator = entityCollection.iterator();
		 
		 while(collectionIterator.hasNext())
		 {
		 	TypeObjects typeObject = collectionIterator.next();
		 	typeObject.print();
		 }
		}
 }
}
