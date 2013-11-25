package com.thetdgroup.input_parsers.netgister;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.collections.map.MultiValueMap;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import com.thetdgroup.TDGSRTBuilder;
import com.thetdgroup.base_parser.BaseParser;
import com.thetdgroup.input_parsers.netgister.named_entities_objects.DetectedInstance;
import com.thetdgroup.input_parsers.netgister.named_entities_objects.EntitiesObject;
import com.thetdgroup.input_parsers.netgister.named_entities_objects.TopicsObject;
import com.thetdgroup.input_parsers.netgister.named_entities_objects.TypeObjects;
import com.thetdgroup.input_parsers.netgister.netgister_objects.LanguageObject;
import com.thetdgroup.utils.InsertableStringBuilder;

import comThetdgroupMetadataControlledvocabularyV1.Alignment;
import comThetdgroupMetadataControlledvocabularyV1.CorpusType;
import comThetdgroupMetadataControlledvocabularyV1.DataType;

public final class NetgisterParser extends BaseParser
{
 private NetgisterJSONReader netgisterJSONReader = new NetgisterJSONReader();
 
 //
	//
 //
	public void parseFile(String inputFile) throws Exception
	{
	 File file = new File(inputFile);
	 String jsonTxt = FileUtils.readFileToString(file, "UTF-8");
	 
  JSONObject jsonData = new JSONObject(jsonTxt);
  parseJSON(jsonData);
	}

	//
	//
	//
	public String parseJSON(JSONObject jsonNetgisterObject) throws Exception
	{
	 netgisterJSONReader.parse(jsonNetgisterObject);

	 String strDocument = createTDGSRTDocument();
	 
	 //
	 return strDocument;
	}

	//
	//
	//
	@SuppressWarnings("unchecked")
 public String createTDGSRTDocument() throws Exception
	{
	 TDGSRTBuilder corporaBuilder = new TDGSRTBuilder();
	 String strDocument = "";
	 
	 try
	 {
	  //
	  // Create 
	  corporaBuilder.createSRTDocument();
	  
	  // Upload Info
	  corporaBuilder.addUploadInformation(netgisterJSONReader.getAssetObject().getUserName(), 
	                                      "", 
	                                      "", 
	                                      "",
	                                      "", 
	                                      "", 
	                                      netgisterJSONReader.getAssetObject().getUploadTime());
	  
	  //
	 // String sourceLanguage = LanguageCodeIso6392Type.ENG.toString();
	 // String sourceContent = "my source content";
	 // CorporaSegment sourceSegment = new CorporaSegment(sourceLanguage, sourceContent);
	  
	  //
	  // Corpus Body
	 // corporaBuilder.addCorpusUnit(netgisterJSONReader.getAssetObject().getSourceText());
	  
	  //
	  // Project Information
	  corporaBuilder.setProjectID(netgisterJSONReader.getAssetObject().getSessionID());
	  corporaBuilder.setProjectTitle(netgisterJSONReader.getAssetObject().getAssetName());
	  
	  //
	  // Linguistic
	  corporaBuilder.setCorpusType(CorpusType.MONOLINGUAL.toString());
	  corporaBuilder.setAlignmentType(Alignment.UNALIGNED.toString());
	  
	  ArrayList<LanguageObject> languageList = netgisterJSONReader.getAssetObject().getSourceLanguages();
	  
	  for(LanguageObject language : languageList)
	  {
	   corporaBuilder.addSourceLanguage(language);
	  }
	  
	  //
	  // Set Indexable Search Text (plain without any markups)
   corporaBuilder.addCorpusSearchText(netgisterJSONReader.getAssetObject().getSourceText(), netgisterJSONReader.getAssetObject().getHighestProbabilitySourceLanguage().getLanguageISO3());
   
   //
	  // Format
	  corporaBuilder.addFormatDataType(DataType.ELECTRONIC_TEXT.toString());
	  corporaBuilder.addFormatEncoding(netgisterJSONReader.getAssetObject().getEncoding());
	  corporaBuilder.setFormatExtent(netgisterJSONReader.getAssetObject().getDuration());
	  corporaBuilder.addFormatMedium("Format medium 1");
	  
	  //
	  // Process Topics
	  //
	  TopicsObject topics = netgisterJSONReader.getAssetObject().getNamedEntityObject().getTopicsObject();
	  corporaBuilder.addCorpusSubjects(topics);
	  
	  //
	  // Process Named Entities
	  //
	  MultiValueMap entityInstances = MultiValueMap.decorate(new TreeMap<String, ArrayList<DetectedInstance>>());
	  EntitiesObject entities = netgisterJSONReader.getAssetObject().getNamedEntityObject().getEntitiesObject();
   
   //
	  // Anniversary
	  ArrayList<TypeObjects> entityList = entities.getEntities("Anniversary");
	  
	  for(TypeObjects typeObject : entityList)
	  {
	   corporaBuilder.addAnniversary(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"));
	   typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "anniversary");
	  }
	  
   //
	  // City
	  entityList = entities.getEntities("City");
	  
	  for(TypeObjects typeObject : entityList)
	  {
	   corporaBuilder.addCity(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"));
	   typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "city");
	  }
	  
	  //
	  // Company
	  entityList = entities.getEntities("Company");
	  
	  for(TypeObjects typeObject : entityList)
	  {
	   corporaBuilder.addCompany(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"), typeObject.getValue("shortname"), typeObject.getValue("score"), typeObject.getValue("nationality"), typeObject.getValue("ticker"), typeObject.getValue("symbol"));
	   typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "company");
	  }
   
   //
	  // Continent
	  entityList = entities.getEntities("Continent");
	  
	  for(TypeObjects typeObject : entityList)
	  {
	   corporaBuilder.addContinent(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"));
	   typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "continent");
	  }
	
   //
	  // Country
	  entityList = entities.getEntities("Country");
	  
	  for(TypeObjects typeObject : entityList)
	  {
	   corporaBuilder.addCountry(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"));
	   typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "country");
	  }
	  
	  //
	  // Currency
	  entityList = entities.getEntities("Currency");
	  
	  for(TypeObjects typeObject : entityList)
	  {
	   corporaBuilder.addCurrency(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"));
	   typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "currency");
	  }
	  
   //
	  // EmailAddress
	  entityList = entities.getEntities("EmailAddress");
	  
	  for(TypeObjects typeObject : entityList)
	  {
	   corporaBuilder.addEmail(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"));
	   typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "email_adress");
	  }
	  
   //
	  // Facility
	  entityList = entities.getEntities("Facility");
	  
	  for(TypeObjects typeObject : entityList)
	  {
	   corporaBuilder.addFacility(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"));
	   typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "facility");
	  }
	  
   //
	  // FaxNumber
	  entityList = entities.getEntities("FaxNumber");
	  
	  for(TypeObjects typeObject : entityList)
	  {
	   corporaBuilder.addFax(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"));
	   typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "fax_number");
	  }
	  
   //
	  // Holiday
	  entityList = entities.getEntities("Holiday");
	  
	  for(TypeObjects typeObject : entityList)
	  {
	   corporaBuilder.addHoliday(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"));
	   typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "holiday");
	  }
	  
   //
	  // IndustryTerm
	  entityList = entities.getEntities("IndustryTerm");
	  
	  for(TypeObjects typeObject : entityList)
	  {
	   corporaBuilder.addIndustry(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"));
	   typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "industry_term");
	  }
	  
   //
	  // MarketIndex
	  entityList = entities.getEntities("MarketIndex");
	  
	  for(TypeObjects typeObject : entityList)
	  {
	   corporaBuilder.addMarketIndex(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"));
	   typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "market_index");
	  }
	  
   //
	  // MedicalCondition
	  entityList = entities.getEntities("MedicalCondition");
	  
	  for(TypeObjects typeObject : entityList)
	  {
	   corporaBuilder.addMedicalCondition(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"));
	   typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "medical_condition");
	  }
	  
   //
	  // MedicalTreament
	  entityList = entities.getEntities("MedicalTreament");
	  
	  for(TypeObjects typeObject : entityList)
	  {
	   corporaBuilder.addMedicalTreament(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"));
	   typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "medical_treament");
	  }
	  
   //
	  // NaturalFeature
	  entityList = entities.getEntities("NaturalFeature");
	  
	  for(TypeObjects typeObject : entityList)
	  {
	   corporaBuilder.addNaturalFeature(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"));
	   typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "natural_feature");
   }
	  
   //
	  // Organizations
	  entityList = entities.getEntities("Organization");
	  
	  for(TypeObjects typeObject : entityList)
	  {
	   corporaBuilder.addOrganization(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"), typeObject.getValue("organizationtype"), typeObject.getValue("nationality"));
	   typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "organization");
	  }
	  
   //
   // Persons
   entityList = entities.getEntities("Person");
   
   for(TypeObjects typeObject : entityList)
   {
    corporaBuilder.addPerson(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"), typeObject.getValue("persontype"), typeObject.getValue("commonname"), typeObject.getValue("nationality"));
    typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "person");
   }
	   
   //
	  // PhoneNumber
	  entityList = entities.getEntities("PhoneNumber");
	  
	  for(TypeObjects typeObject : entityList)
	  {
	   corporaBuilder.addOrganization(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"), typeObject.getValue("organizationtype"), typeObject.getValue("nationality"));
	   typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "phone_number");
	  }
	  
   //
	  // PoliticalEvent
	  entityList = entities.getEntities("PoliticalEvent");
	  
	  for(TypeObjects typeObject : entityList)
	  {
	   corporaBuilder.addPoliticalEvent(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"), typeObject.getValue("politicaleventtype"), typeObject.getValue("date"), typeObject.getValue("datestring"), typeObject.getValue("location"));
	   typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "political_event");
	  }
	  
   //
	  // Position
	  entityList = entities.getEntities("Position");
	  
	  for(TypeObjects typeObject : entityList)
	  {
	   corporaBuilder.addPosition(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"));
	   typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "position");
	  }
	  
   //
	  // Product
	  entityList = entities.getEntities("Product");
	  
	  for(TypeObjects typeObject : entityList)
	  {
	   corporaBuilder.addProduct(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"), typeObject.getValue("producttype"));
	   typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "product");
	  }
	  
   //
	  // ProvinceOrState
	  entityList = entities.getEntities("ProvinceOrState");
	  
	  for(TypeObjects typeObject : entityList)
	  {
	   corporaBuilder.addProvinceOrState(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"));
	   typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "province_state");
	  }
	  
   //
	  // PublishedMedium
	  entityList = entities.getEntities("PublishedMedium");
	  
	  for(TypeObjects typeObject : entityList)
	  {
	   corporaBuilder.addPublishedMedium(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"));
	   typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "published_medium");
	  }
	  
   //
	  // Region
	  entityList = entities.getEntities("Region");
	  
	  for(TypeObjects typeObject : entityList)
	  {
	   corporaBuilder.addRegion(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"));
	   typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "region");
	  }
	  
   //
	  // Technology
	  entityList = entities.getEntities("Technology");
	  
	  for(TypeObjects typeObject : entityList)
	  {
	   corporaBuilder.addTechnology(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"));
	   typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "tech");
	  }
	  
   //
   // TVStation
   entityList = entities.getEntities("TVStation");
   
   for(TypeObjects typeObject : entityList)
   {
    corporaBuilder.addTVStation(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"));
    typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "tv");
   }
   
   //
	  // URL
	  entityList = entities.getEntities("URL");
	  
	  for(TypeObjects typeObject : entityList)
	  {
	   corporaBuilder.addURL(typeObject.getValue("_uri"), typeObject.getValue("name"), typeObject.getValue("relevance"));
	   typeObject.populateInstanceObject(entityInstances, typeObject.getValue("_uri"), "url");
	  }
	  
	  //
	  // Annotate the text with all found entities and add to marked up data (tdg:AnnotatedText)
   String annotatedText = corporaBuilder.getSearchText(netgisterJSONReader.getAssetObject().getHighestProbabilitySourceLanguage().getLanguageISO3());
	  InsertableStringBuilder stringBuffer = new InsertableStringBuilder(annotatedText);

		 //
			Set<String> collectionMapKeys = entityInstances.keySet(); 
		 Iterator<String> mapIterator = collectionMapKeys.iterator();
		
			while(mapIterator.hasNext())
			{
				String entityName = mapIterator.next();
			 
				Collection<DetectedInstance> entityCollection = entityInstances.getCollection(entityName);
				Iterator<DetectedInstance> collectionIterator = entityCollection.iterator();
			 
			 while(collectionIterator.hasNext())
			 {
			 	DetectedInstance typeObject = collectionIterator.next();
			 	
	    stringBuffer.insert(typeObject.getInstanceOffset(), "<" + typeObject.getInstanceType() + " id=\"" + typeObject.getInstanceID() + "\" class=\"" + typeObject.getInstanceType() + "\">", false);
	    stringBuffer.insert(typeObject.getInstanceOffset() + typeObject.getInstanceLength(), "</" + typeObject.getInstanceType() + ">", false);
    }
			}
	  
	  //
   // now set Annotated Text... this can be used for HTML marked up data
   corporaBuilder.addCorpusAnnotatedText(stringBuffer.toString(), netgisterJSONReader.getAssetObject().getHighestProbabilitySourceLanguage().getLanguageISO3());
   
   //
   // generate XML string
   strDocument = corporaBuilder.saveDocument();
	 }
	 catch(Exception exception)
	 {
	  exception.printStackTrace();
	 }
	 
	 //
	 return strDocument;
	}
}
