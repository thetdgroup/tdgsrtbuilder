package com.thetdgroup;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.keyvalue.DefaultKeyValue;
import org.apache.xmlbeans.XmlOptions;
import org.json.JSONArray;
import org.json.JSONObject;

import com.thetdgroup.input_parsers.bbn.bbn_objects.BBNAssetObject;
import com.thetdgroup.input_parsers.netgister.named_entities_objects.TopicsObject;
import com.thetdgroup.input_parsers.netgister.named_entities_objects.TypeObjects;
import com.thetdgroup.input_parsers.netgister.netgister_objects.LanguageObject;
import com.thetdgroup.srt_parser.corpus_segment.CorporaSegment;
import com.thetdgroup.srt_parser.corpus_segment.CorporaSegmentAttribute;
import com.thetdgroup.srt_parser.timestamp.TimeStampObject;
import com.thetdgroup.utils.InsertableStringBuilder;

import comThetdgroupClLanguageIso639V1.LanguageCodeIso6392Type;
import comThetdgroupMetadataControlledvocabularyV1.Alignment;
import comThetdgroupMetadataControlledvocabularyV1.CorpusType;
import comThetdgroupMetadataControlledvocabularyV1.DataType;
import comThetdgroupMetadataControlledvocabularyV1.Encoding;
import comThetdgroupMetadataControlledvocabularyV1.Polar;
import comThetdgroupSchemaTdgSrtV1.ContentType;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.Anniversary;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.City;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.Company;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.Continent;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.Country;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.Currency;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.EmailAddress;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.Facility;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.FaxNumber;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.Holiday;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.IndustryTerm;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.MarketIndex;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.MedicalCondition;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.MedicalTreatment;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.NaturalFeature;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.Organization;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.Person;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.PhoneNumber;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.PoliticalEvent;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.Position;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.Product;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.ProvinceOrState;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.PublishedMedium;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.Region;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.TVStation;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.Technology;
import comThetdgroupSchemaTdgSrtV1.ContentType.NamedEntities.URL;
import comThetdgroupSchemaTdgSrtV1.CorpusBodyType;
import comThetdgroupSchemaTdgSrtV1.CorpusBodyType.CorpusAnnotatedText;
import comThetdgroupSchemaTdgSrtV1.CorpusBodyType.CorpusAnnotatedText.AnnotatedText;
import comThetdgroupSchemaTdgSrtV1.CorpusBodyType.CorpusSearchText;
import comThetdgroupSchemaTdgSrtV1.CorpusBodyType.CorpusSearchText.SearchText;
import comThetdgroupSchemaTdgSrtV1.CorpusContentType;
import comThetdgroupSchemaTdgSrtV1.CorpusMetadataType;
import comThetdgroupSchemaTdgSrtV1.FormatType;
import comThetdgroupSchemaTdgSrtV1.LanguageType;
import comThetdgroupSchemaTdgSrtV1.LinguisticType;
import comThetdgroupSchemaTdgSrtV1.LinguisticType.SourceLanguages;
import comThetdgroupSchemaTdgSrtV1.ProjectInfoType;
import comThetdgroupSchemaTdgSrtV1.TDGSRTCorpusDocument;
import comThetdgroupSchemaTdgSrtV1.TDGSRTCorpusType;
import comThetdgroupSchemaTdgSrtV1.ReferencedAssetsType;
import comThetdgroupSchemaTdgSrtV1.TimeStampType;
import comThetdgroupSchemaTdgSrtV1.TimeStampType.Timestamp;
import comThetdgroupSchemaTdgSrtV1.UploadInformationType;
import comThetdgroupSchemaTdgSrtV1.ContentType.Genres;
import comThetdgroupSchemaTdgSrtV1.ContentType.Keywords;
import comThetdgroupSchemaTdgSrtV1.ContentType.Subjects;
import comThetdgroupSchemaTdgSrtV1.ContentType.TemporalCoverages;
import comThetdgroupSchemaTdgSrtV1.ContentType.Genres.Genre;
import comThetdgroupSchemaTdgSrtV1.ContentType.Subjects.Subject;
import comThetdgroupSchemaTdgSrtV1.ContentType.TemporalCoverages.TemporalCoverage;
import comThetdgroupSchemaTdgSrtV1.CorpusBodyType.CorpusUnit;
import comThetdgroupSchemaTdgSrtV1.CorpusBodyType.CorpusUnit.Segment;
import comThetdgroupSchemaTdgSrtV1.CorpusBodyType.CorpusUnit.Segment.SegmentAttribute;
import comThetdgroupSchemaTdgSrtV1.LinguisticType.TargetLanguages;
import comThetdgroupSchemaTdgSrtV1.ReferencedAssetsType.Asset;
import comThetdgroupSchemaTdgSrtV1.ReferencedAssetsType.Asset.Prop;
import comThetdgroupSchemaTdgSrtV1.UploadInformationType.UserInfo;

//
public final class TDGSRTBuilder
{
	private XmlOptions xmlOptions = null;
 private TDGSRTCorpusType srtDocument = null;
 
 //
 // Metadata for the SRT Document
 private CorpusMetadataType srtCorpusMetadataType = null;
 private CorpusContentType srtContentType = null;
 
 //
 // SRT Document Aligned Sentences
 private CorpusBodyType srtCorpusBodyType = null;
 
 //
	public TDGSRTBuilder()
	{
		HashMap<String, String> suggestedPrefixes = new HashMap<String, String>();
		suggestedPrefixes.put("urn:com:thetdgroup:schema:tdg_srt:v1", "tdg");
		suggestedPrefixes.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
		suggestedPrefixes.put("urn:com:thetdgroup:schema:tdg_srt:v1 tdg_srt-1_0.xsd", "SchemaLocation");

		xmlOptions = new XmlOptions();
		xmlOptions.setSaveSuggestedPrefixes(suggestedPrefixes);
		xmlOptions.setCharacterEncoding("UTF-8");
		xmlOptions.setSavePrettyPrint();
		xmlOptions.setSaveNamespacesFirst();
		xmlOptions.setLoadStripWhitespace();
		xmlOptions.setBaseURI(URI.create("www.thetdgroup.com"));
		xmlOptions.setDocumentSourceName("www.thetdgroup.com");
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveOuter();
	}
	
	//
	public void loadDocument(final File inputXMLFile) throws Exception
	{
		TDGSRTCorpusDocument doc = TDGSRTCorpusDocument.Factory.parse(inputXMLFile, xmlOptions);
		srtDocument = doc.getTDGSRTCorpus();
	}
	
	public void loadDocument(final String inputXMLString) throws Exception
	{
		TDGSRTCorpusDocument doc = TDGSRTCorpusDocument.Factory.parse(inputXMLString, xmlOptions);
		srtDocument = doc.getTDGSRTCorpus();
	}
	
	//
 public JSONObject documentToJSON() throws Exception
 {
  //
  // Content
  ContentType contentType = srtDocument.getCorpusMetadata().getCorpusContent().getContent();
  
  JSONObject jsonTypeObject = new JSONObject();
  jsonTypeObject.put("title", contentType.getTitle());

  //
  // Project
  ProjectInfoType projectType = srtDocument.getCorpusMetadata().getCorpusContent().getProject();
  
  JSONObject jsonProjectObject = new JSONObject();
  jsonProjectObject.put("media_id", projectType.getMediaID());
  
  //
  // Linguistic
  LinguisticType linguisticType = srtDocument.getCorpusMetadata().getCorpusContent().getLinguistic();
  
  JSONObject jsonLinguisticObject = new JSONObject();
  jsonLinguisticObject.put("alignment", linguisticType.getAlignment());

  //
  // Format
  FormatType formatType = srtDocument.getCorpusMetadata().getCorpusContent().getFormat();
    
  JSONObject jsonFormatObject = new JSONObject();
  jsonFormatObject.put("media_id", formatType.getDataTypeArray());
  
  //
  // Upload
  UploadInformationType uploadInformationType = srtDocument.getCorpusMetadata().getUploadInformation();
  
  JSONObject jsonUploadObject = new JSONObject();
  jsonUploadObject.put("date", uploadInformationType.getDate());
  jsonUploadObject.put("ip_address", uploadInformationType.getIPAddress());
  jsonUploadObject.put("port", uploadInformationType.getPort());
  jsonUploadObject.put("protocol", uploadInformationType.getProtocol());
  jsonUploadObject.put("email", uploadInformationType.getUserInfo().getEmail());
  jsonUploadObject.put("name", uploadInformationType.getUserInfo().getName());
  jsonUploadObject.put("user_id", uploadInformationType.getUserInfo().getUserID());
  
  //
  // Annotated Text
  JSONArray jsonAnnotatedTextArray = new JSONArray();
  AnnotatedText annotatedTextArray[] = srtDocument.getCorpusBody().getCorpusAnnotatedText().getAnnotatedTextArray();
  
  for(AnnotatedText annotatedText : annotatedTextArray)
  {
   JSONObject jsonObject = new JSONObject();
   jsonObject.put("language", annotatedText.getLanguage());
   jsonObject.put("text", annotatedText.getText());
 
   jsonAnnotatedTextArray.put(jsonObject);
  }
    
  //
  //
  JSONObject jsonDocumentObject = new JSONObject();
  jsonDocumentObject.put("content_type", jsonTypeObject);
  jsonDocumentObject.put("project_type", jsonProjectObject);
  jsonDocumentObject.put("linguistic_type", jsonLinguisticObject);
  jsonDocumentObject.put("format_type", jsonFormatObject);
  jsonDocumentObject.put("upload_type", jsonUploadObject);
  jsonDocumentObject.put("annotated_text", jsonAnnotatedTextArray);
  
  return jsonDocumentObject;
 }
	
	//
	public void saveDocument(final File outputXMLFile) throws Exception
	{
		srtDocument.save(outputXMLFile, xmlOptions);
	}
	
	public String saveDocument() throws Exception
	{
		return srtDocument.xmlText(xmlOptions);
	}
	
	public void printDocument()
	{
		System.out.println(srtDocument.toString());
	}
	
	public TDGSRTCorpusType getLexicalResource()
	{
		return srtDocument;
	}
	
	//
	// Create Master SRT Document
	//
	public void createSRTDocument() throws Exception
	{
		if(srtDocument != null)
		{
			throw new Exception("The SRTDocument already exists");
		}
		
		//
		TDGSRTCorpusDocument doc = TDGSRTCorpusDocument.Factory.newInstance();
		srtDocument = doc.addNewTDGSRTCorpus();
		
		//
		// Create Corpus Metadata
		srtCorpusMetadataType = srtDocument.addNewCorpusMetadata();
		srtContentType = srtCorpusMetadataType.addNewCorpusContent();
		
		//
		// Create Corpus Body
		srtCorpusBodyType = srtDocument.addNewCorpusBody();
	}
	
 //
 // PROJECT INFORMATION
 //
	public void setProjectID(final String projectID) throws Exception
	{
	 ProjectInfoType projectInfo = getProjectInfo();

	 //
	 projectInfo.setProjectID(projectID);
	}
	
 public void setProjectTitle(final String projectTitle) throws Exception
 {
  ProjectInfoType projectInfo = getProjectInfo();

  //
  projectInfo.setProjectTitle(projectTitle);
 }
	
 public void setProjectDescription(final String projectDescription) throws Exception
 {
  ProjectInfoType projectInfo = getProjectInfo();

  //
  projectInfo.setProjectDescription(projectDescription);
 }
 
 public void setMediaID(final String mediaID) throws Exception
 {
  ProjectInfoType projectInfo = getProjectInfo();

  //
  projectInfo.setMediaID(mediaID);
 }
 
	//
	// DOCUMENT METADATA
	//
	public void setCorpusTitle(final String corpusTitle) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 
	 //
	 contentType.setTitle(corpusTitle);		
	}
	
	//
	public void addCorpusAlternateTitle(final String corpusAlternateTitle) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 
	 //
	 contentType.addAlternateTitle(corpusAlternateTitle);
	}
	
	//
	public void setCorpusVersion(final String corpusVersion, final String versionDate) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 
	 //
 	contentType.setVersion(corpusVersion);
 	contentType.setVersionDate(versionDate);
	}
	
	public void setCorpusSummary(final String corpusSummary) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 
	 //
 	contentType.setCorpusSummary(corpusSummary);
	}
	
	//
	public void addCorpusSubject(final String subjectMetaID, final String subjectName) throws Exception
	{
	 ContentType contentType = getCorpusContent();
 	Subjects subjectsObjects = contentType.getSubjects();
 	
	 if(subjectsObjects == null)
	 {
	 	subjectsObjects = contentType.addNewSubjects();
	 }
	 
	 //
	 Subject subjectObject = subjectsObjects.addNewSubject();
 	subjectObject.setMetaDataID(subjectMetaID);
 	subjectObject.setText(subjectName);
	}
	
	//
	public void addCorpusSubjects(final TopicsObject topics) throws Exception
	{
	 ContentType contentType = getCorpusContent();
 	Subjects subjectsObjects = contentType.getSubjects();
 	
	 if(subjectsObjects == null)
	 {
	 	subjectsObjects = contentType.addNewSubjects();
	 }
	 
	 //
	 //
		Set<String> collectionMapKeys = topics.getEntities().keySet(); 
	 Iterator<String> mapIterator = collectionMapKeys.iterator();
	
		while(mapIterator.hasNext())
		{
			String entityType = mapIterator.next();
			
			//
			Collection<TypeObjects> entityCollection = topics.getEntities().getCollection(entityType);
			Iterator<TypeObjects> collectionIterator = entityCollection.iterator();
		 
		 while(collectionIterator.hasNext())
		 {
		 	TypeObjects typeObject = collectionIterator.next();
		 	
			 Subject subjectObject = subjectsObjects.addNewSubject();
		 	subjectObject.setMetaDataID(typeObject.getValue("category"));
		 	subjectObject.setText(typeObject.getValue("categoryName"));
		 	
		 	typeObject.getValue("relevance");
		 }
		}
	}
	
	//
	public void addCorpusGenre(final String genreMetaID, final String genreName) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 Genres genreObjects = contentType.getGenres();
	 
	 if(genreObjects == null)
	 {
	 	genreObjects = contentType.addNewGenres();
	 }
	 
	 //
 	Genre genreObject = genreObjects.addNewGenre();
 	genreObject.setMetaDataID(genreMetaID);
 	genreObject.setText(genreName);
	}
	
	//
	public void addCorpusKeywords(final String keyword) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 Keywords keywordObjects = contentType.getKeywords();
	 
	 if(keywordObjects == null)
	 {
	 	keywordObjects = contentType.addNewKeywords();
	 }
	 
	 //
	 keywordObjects.addKeyword(keyword);
	}
	
	//
	// Named Entities
	//
	public void addAnniversary(final String entityID, final String entityName, final String relevanceScore) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 NamedEntities nameEntityObject = contentType.getNamedEntities();
	 
	 if(nameEntityObject == null)
	 {
	 	nameEntityObject = contentType.addNewNamedEntities();
	 }
	 
	 //
	 Anniversary entityType = nameEntityObject.addNewAnniversary();
	 entityType.setEntityID(entityID);
	 entityType.setEntityName(entityName);
	 entityType.setRelevanceScore(relevanceScore);
	}
	
	//
	public void addCity(final String entityID, final String entityName, final String relevanceScore) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 NamedEntities nameEntityObject = contentType.getNamedEntities();
	 
	 if(nameEntityObject == null)
	 {
	 	nameEntityObject = contentType.addNewNamedEntities();
	 }
	 
  //
	 City entityType = nameEntityObject.addNewCity();
	 entityType.setEntityID(entityID);
	 entityType.setEntityName(entityName);
	 entityType.setRelevanceScore(relevanceScore);
	}
	
	//
	public void addCompany(final String entityID, final String entityName, final String relevanceScore, final String shortName, final String score, final String nationality, final String ticker, final String symbol) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 NamedEntities nameEntityObject = contentType.getNamedEntities();
	 
	 if(nameEntityObject == null)
	 {
	 	nameEntityObject = contentType.addNewNamedEntities();
	 }
	 
  //
	 Company entityType = nameEntityObject.addNewCompany();
	 entityType.setEntityID(entityID);
	 entityType.setEntityName(entityName);
	 entityType.setRelevanceScore(relevanceScore);
	 entityType.setShortName(shortName);
	 entityType.setScore(score);
	 entityType.setNationality(nationality);
	 entityType.setTicker(ticker);
	 entityType.setSymbol(symbol);
	}
	
	//
	public void addContinent(final String entityID, final String entityName, final String relevanceScore) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 NamedEntities nameEntityObject = contentType.getNamedEntities();
	 
	 if(nameEntityObject == null)
	 {
	 	nameEntityObject = contentType.addNewNamedEntities();
	 }
	 
	 //
	 Continent entityType = nameEntityObject.addNewContinent();
	 entityType.setEntityID(entityID);
	 entityType.setEntityName(entityName);
	 entityType.setRelevanceScore(relevanceScore);
	}
		
	//
	public void addCountry(final String entityID, final String entityName, final String relevanceScore) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 NamedEntities nameEntityObject = contentType.getNamedEntities();
	 
	 if(nameEntityObject == null)
	 {
	 	nameEntityObject = contentType.addNewNamedEntities();
	 }
	 
	 //
	 Country entityType = nameEntityObject.addNewCountry();
	 entityType.setEntityID(entityID);
	 entityType.setEntityName(entityName);
	 entityType.setRelevanceScore(relevanceScore);
	}
	
	//
	public void addCurrency(final String entityID, final String entityName, final String relevanceScore) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 NamedEntities nameEntityObject = contentType.getNamedEntities();
	 
	 if(nameEntityObject == null)
	 {
	 	nameEntityObject = contentType.addNewNamedEntities();
	 }
	 
	 //
	 Currency entityType = nameEntityObject.addNewCurrency();
	 entityType.setEntityID(entityID);
	 entityType.setEntityName(entityName);
	 entityType.setRelevanceScore(relevanceScore);
	}
	
	//
	public void addEmail(final String entityID, final String entityName, final String relevanceScore) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 NamedEntities nameEntityObject = contentType.getNamedEntities();
	 
	 if(nameEntityObject == null)
	 {
	 	nameEntityObject = contentType.addNewNamedEntities();
	 }
	 
  //
	 EmailAddress entityType = nameEntityObject.addNewEmailAddress();
	 entityType.setEntityID(entityID);
	 entityType.setEntityName(entityName);
	 entityType.setRelevanceScore(relevanceScore);
	}
	
	//
	public void addFacility(final String entityID, final String entityName, final String relevanceScore) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 NamedEntities nameEntityObject = contentType.getNamedEntities();
	 
	 if(nameEntityObject == null)
	 {
	 	nameEntityObject = contentType.addNewNamedEntities();
	 }
	 
  //
	 Facility entityType = nameEntityObject.addNewFacility();
	 entityType.setEntityID(entityID);
	 entityType.setEntityName(entityName);
	 entityType.setRelevanceScore(relevanceScore);
	}
	
	//
	public void addFax(final String entityID, final String entityName, final String relevanceScore) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 NamedEntities nameEntityObject = contentType.getNamedEntities();
	 
	 if(nameEntityObject == null)
	 {
	 	nameEntityObject = contentType.addNewNamedEntities();
	 }
	 
  //
	 FaxNumber entityType = nameEntityObject.addNewFaxNumber();
	 entityType.setEntityID(entityID);
	 entityType.setEntityName(entityName);
	 entityType.setRelevanceScore(relevanceScore);
	}
	
	//
	public void addHoliday(final String entityID, final String entityName, final String relevanceScore) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 NamedEntities nameEntityObject = contentType.getNamedEntities();
	 
	 if(nameEntityObject == null)
	 {
	 	nameEntityObject = contentType.addNewNamedEntities();
	 }
	 
  //
	 Holiday entityType = nameEntityObject.addNewHoliday();
	 entityType.setEntityID(entityID);
	 entityType.setEntityName(entityName);
	 entityType.setRelevanceScore(relevanceScore);
	}
	
	//
	public void addIndustry(final String entityID, final String entityName, final String relevanceScore) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 NamedEntities nameEntityObject = contentType.getNamedEntities();
	 
	 if(nameEntityObject == null)
	 {
	 	nameEntityObject = contentType.addNewNamedEntities();
	 }
	 
  //
	 IndustryTerm entityType = nameEntityObject.addNewIndustryTerm();
	 entityType.setEntityID(entityID);
	 entityType.setEntityName(entityName);
	 entityType.setRelevanceScore(relevanceScore);
	}	
	
	//
	public void addMarketIndex(final String entityID, final String entityName, final String relevanceScore) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 NamedEntities nameEntityObject = contentType.getNamedEntities();
	 
	 if(nameEntityObject == null)
	 {
	 	nameEntityObject = contentType.addNewNamedEntities();
	 }
	 
  //
	 MarketIndex entityType = nameEntityObject.addNewMarketIndex();
	 entityType.setEntityID(entityID);
	 entityType.setEntityName(entityName);
	 entityType.setRelevanceScore(relevanceScore);
	}
	
	//
	public void addMedicalCondition(final String entityID, final String entityName, final String relevanceScore) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 NamedEntities nameEntityObject = contentType.getNamedEntities();
	 
	 if(nameEntityObject == null)
	 {
	 	nameEntityObject = contentType.addNewNamedEntities();
	 }
	 
  //
	 MedicalCondition entityType = nameEntityObject.addNewMedicalCondition();
	 entityType.setEntityID(entityID);
	 entityType.setEntityName(entityName);
	 entityType.setRelevanceScore(relevanceScore);
	}
	
	//
	public void addMedicalTreament(final String entityID, final String entityName, final String relevanceScore) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 NamedEntities nameEntityObject = contentType.getNamedEntities();
	 
	 if(nameEntityObject == null)
	 {
	 	nameEntityObject = contentType.addNewNamedEntities();
	 }
	 
  //
	 MedicalTreatment entityType = nameEntityObject.addNewMedicalTreatment();
	 entityType.setEntityID(entityID);
	 entityType.setEntityName(entityName);
	 entityType.setRelevanceScore(relevanceScore);
	}
	
	//
	public void addNaturalFeature(final String entityID, final String entityName, final String relevanceScore) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 NamedEntities nameEntityObject = contentType.getNamedEntities();
	 
	 if(nameEntityObject == null)
	 {
	 	nameEntityObject = contentType.addNewNamedEntities();
	 }
	 
  //
	 NaturalFeature entityType = nameEntityObject.addNewNaturalFeature();
	 entityType.setEntityID(entityID);
	 entityType.setEntityName(entityName);
	 entityType.setRelevanceScore(relevanceScore);
	}	
	
	//
	public void addOrganization(final String entityID, final String entityName, final String relevanceScore, final String type, final String nationality) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 NamedEntities nameEntityObject = contentType.getNamedEntities();
	 
	 if(nameEntityObject == null)
	 {
	 	nameEntityObject = contentType.addNewNamedEntities();
	 }
	 
  //
	 Organization entityType = nameEntityObject.addNewOrganization();
	 
	 entityType.setEntityID(entityID);
	 entityType.setEntityName(entityName);
	 entityType.setRelevanceScore(relevanceScore);
	 entityType.setOrganizationType(type);
	 entityType.setNationality(nationality);
	}
	
	//
	public void addPerson(final String entityID, final String entityName, final String relevanceScore, final String type, final String commonName, final String nationality) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 NamedEntities nameEntityObject = contentType.getNamedEntities();
	 
	 if(nameEntityObject == null)
	 {
	 	nameEntityObject = contentType.addNewNamedEntities();
	 }
	 
  //
	 Person entityType = nameEntityObject.addNewPerson();
  
  entityType.setEntityID(entityID);
  entityType.setEntityName(entityName);
  entityType.setRelevanceScore(relevanceScore);
  entityType.setPersonType(type);
  entityType.setCommonName(commonName);
  entityType.setNationality(nationality);
	}
	
	//
	public void addPhoneNumber(final String entityID, final String entityName, final String relevanceScore) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 NamedEntities nameEntityObject = contentType.getNamedEntities();
	 
	 if(nameEntityObject == null)
	 {
	 	nameEntityObject = contentType.addNewNamedEntities();
	 }
	 
  //
	 PhoneNumber entityType = nameEntityObject.addNewPhoneNumber();
	 entityType.setEntityID(entityID);
	 entityType.setEntityName(entityName);
	 entityType.setRelevanceScore(relevanceScore);
	}
	
	//
	public void addPoliticalEvent(final String entityID, final String entityName, final String relevanceScore, final String politicalEventType, final String date, final String dateString, final String location) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 NamedEntities nameEntityObject = contentType.getNamedEntities();
	 
	 if(nameEntityObject == null)
	 {
	 	nameEntityObject = contentType.addNewNamedEntities();
	 }
	 
  //
	 PoliticalEvent entityType = nameEntityObject.addNewPoliticalEvent();
	 entityType.setEntityID(entityID);
	 entityType.setEntityName(entityName);
	 entityType.setRelevanceScore(relevanceScore);
	 entityType.setPoliticalEventType(politicalEventType);
	 entityType.setDate(date);
	 entityType.setDateString(dateString);
	 entityType.setLocation(location);
	}
	
	//
	public void addPosition(final String entityID, final String entityName, final String relevanceScore) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 NamedEntities nameEntityObject = contentType.getNamedEntities();
	 
	 if(nameEntityObject == null)
	 {
	 	nameEntityObject = contentType.addNewNamedEntities();
	 }
	 
  //
	 Position entityType = nameEntityObject.addNewPosition();
	 entityType.setEntityID(entityID);
	 entityType.setEntityName(entityName);
	 entityType.setRelevanceScore(relevanceScore);
	}
	
	//
	public void addProduct(final String entityID, final String entityName, final String relevanceScore, final String productType) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 NamedEntities nameEntityObject = contentType.getNamedEntities();
	 
	 if(nameEntityObject == null)
	 {
	 	nameEntityObject = contentType.addNewNamedEntities();
	 }
	 
  //
	 Product entityType = nameEntityObject.addNewProduct();
	 entityType.setEntityID(entityID);
	 entityType.setEntityName(entityName);
	 entityType.setRelevanceScore(relevanceScore);
	 entityType.setProductType(productType);
	}
	
	//
	public void addProvinceOrState(final String entityID, final String entityName, final String relevanceScore) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 NamedEntities nameEntityObject = contentType.getNamedEntities();
	 
	 if(nameEntityObject == null)
	 {
	 	nameEntityObject = contentType.addNewNamedEntities();
	 }
	 
  //
	 ProvinceOrState entityType = nameEntityObject.addNewProvinceOrState();
	 entityType.setEntityID(entityID);
	 entityType.setEntityName(entityName);
	 entityType.setRelevanceScore(relevanceScore);
	}
	
	//
	public void addPublishedMedium(final String entityID, final String entityName, final String relevanceScore) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 NamedEntities nameEntityObject = contentType.getNamedEntities();
	 
	 if(nameEntityObject == null)
	 {
	 	nameEntityObject = contentType.addNewNamedEntities();
	 }
	 
  //
	 PublishedMedium entityType = nameEntityObject.addNewPublishedMedium();
	 entityType.setEntityID(entityID);
	 entityType.setEntityName(entityName);
	 entityType.setRelevanceScore(relevanceScore);
	}
	
	//
	public void addRegion(final String entityID, final String entityName, final String relevanceScore) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 NamedEntities nameEntityObject = contentType.getNamedEntities();
	 
	 if(nameEntityObject == null)
	 {
	 	nameEntityObject = contentType.addNewNamedEntities();
	 }
	 
  //
	 Region entityType = nameEntityObject.addNewRegion();
	 entityType.setEntityID(entityID);
	 entityType.setEntityName(entityName);
	 entityType.setRelevanceScore(relevanceScore);
	}
	
	//
	public void addTechnology(final String entityID, final String entityName, final String relevanceScore) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 NamedEntities nameEntityObject = contentType.getNamedEntities();
	 
	 if(nameEntityObject == null)
	 {
	 	nameEntityObject = contentType.addNewNamedEntities();
	 }
	 
  //
	 Technology entityType = nameEntityObject.addNewTechnology();
	 entityType.setEntityID(entityID);
	 entityType.setEntityName(entityName);
	 entityType.setRelevanceScore(relevanceScore);
	}
	
 //
 public void addTVStation(final String entityID, final String entityName, final String relevanceScore) throws Exception
 {
  ContentType contentType = getCorpusContent();
  NamedEntities nameEntityObject = contentType.getNamedEntities();
  
  if(nameEntityObject == null)
  {
   nameEntityObject = contentType.addNewNamedEntities();
  }
  
  //
  TVStation entityType = nameEntityObject.addNewTVStation();
  entityType.setEntityID(entityID);
  entityType.setEntityName(entityName);
  entityType.setRelevanceScore(relevanceScore);
 }
 
	//
	public void addURL(final String entityID, final String entityName, final String relevanceScore) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 NamedEntities nameEntityObject = contentType.getNamedEntities();
	 
	 if(nameEntityObject == null)
	 {
	 	nameEntityObject = contentType.addNewNamedEntities();
	 }
	 
  //
	 URL entityType = nameEntityObject.addNewURL();
	 entityType.setEntityID(entityID);
	 entityType.setEntityName(entityName);
	 entityType.setRelevanceScore(relevanceScore);
	}
	
	//
	public void setDescription(final String description) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 
	 //
	 contentType.setDescription(description);
	}
	
	//
	public void setDataQuality(final String quality) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 
	 //
	 contentType.setDataQuality(quality);
	}
	
	//
	public void addTemporalCoverage(final String periodDescription, final String periodStartDate, final String periodEndDate) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 TemporalCoverages temporalCoverages = contentType.getTemporalCoverages();
	 
	 if(temporalCoverages == null)
	 {
	 	temporalCoverages = contentType.addNewTemporalCoverages();
	 }
	 
	 //
	 TemporalCoverage temporalCoverage = temporalCoverages.addNewTemporalCoverage();
  temporalCoverage.setPeriodDescription(periodDescription);
  temporalCoverage.setStartDate(periodStartDate);
  temporalCoverage.setEndDate(periodEndDate);
	}

	//
	public void setCorpusCompleted(final boolean isCompleted) throws Exception
	{
	 ContentType contentType = getCorpusContent();
	 
	 //
	 if(isCompleted)
	 {
	  contentType.setCorpusCompleted(Polar.YES);
	 }
	 else
	 {
	 	contentType.setCorpusCompleted(Polar.NO);
	 }
	}
	
	//
	public void setCorpusType(final String corpusType) throws Exception
	{
	 LinguisticType linguisticType = srtContentType.getLinguistic();
	 
	 if(linguisticType == null)
	 {
	 	linguisticType = srtContentType.addNewLinguistic();
	 }
	 	 
	 //
	 linguisticType.setCorpusType(CorpusType.Enum.forString(corpusType));
	}
	
 //
	public void setAlignmentType(final String alignmentType) throws Exception
	{
	 LinguisticType linguisticType = srtContentType.getLinguistic();
	 
	 if(linguisticType == null)
	 {
	 	linguisticType = srtContentType.addNewLinguistic();
	 }
	 
	 //
	 linguisticType.setAlignment(Alignment.Enum.forString(alignmentType));
	}
	
	//
	public void addSourceLanguage(final LanguageObject sourceLanguage) throws Exception
	{
	 LinguisticType linguisticType = srtContentType.getLinguistic();
	 
	 if(linguisticType == null)
	 {
	 	linguisticType = srtContentType.addNewLinguistic();
	 }
	
	 //
	 SourceLanguages sourceLanguages = linguisticType.getSourceLanguages();
	 
	 if(sourceLanguages == null)
	 {
	 	sourceLanguages = linguisticType.addNewSourceLanguages();
	 }
	 
	 //
	 LanguageType languageType = sourceLanguages.addNewLanguage();
	 
	 languageType.setLanguageIso2(sourceLanguage.getLanguageISO2());
	 languageType.setLanguageIso3(sourceLanguage.getLanguageISO3());
	 languageType.setLanguageName(sourceLanguage.getLanguageName());
	 languageType.setLanguageProbability(sourceLanguage.getLanguageProbabilityAsString());
	}
	
	//
	public void addSourceLanguageDialect(final String dialect) throws Exception
	{
	 LinguisticType linguisticType = srtContentType.getLinguistic();
	 
	 if(linguisticType == null)
	 {
	 	linguisticType = srtContentType.addNewLinguistic();
	 }
	 
	 //
	 linguisticType.addSourceLanguageDialect(dialect);
	}
	
	//
	public void addTargetLanguage(final String targetLanguage) throws Exception
	{
	 LinguisticType linguisticType = srtContentType.getLinguistic();
	 
	 if(linguisticType == null)
	 {
	 	linguisticType = srtContentType.addNewLinguistic();
	 }
	 
	 //
	 TargetLanguages targetLanguages = linguisticType.getTargetLanguages();
	 
	 if(targetLanguages == null)
	 {
	 	targetLanguages = linguisticType.addNewTargetLanguages();
	 }
	 
	 //
	 targetLanguages.addLanguage(LanguageCodeIso6392Type.Enum.forString(targetLanguage));
	}
		
	//
	public void addFormatDataType(final String formatDataType) throws Exception
	{
	 FormatType formatType = srtContentType.getFormat();
	 
	 if(formatType == null)
	 {
	 	formatType = srtContentType.addNewFormat();
	 }
	 
	 //
	 formatType.addDataType(DataType.Enum.forString(formatDataType));
	}
	
	//
	public void addFormatEncoding(final String formatEncoding) throws Exception
	{
	 FormatType formatType = srtContentType.getFormat();
	 
	 if(formatType == null)
	 {
	 	formatType = srtContentType.addNewFormat();
	 }
	 
	 //
	 formatType.addEncoding(Encoding.Enum.forString(formatEncoding));
	}
	
	//
	public void setFormatExtent(final String formatExtent) throws Exception
	{
	 FormatType formatType = srtContentType.getFormat();
	 
	 if(formatType == null)
	 {
	 	formatType = srtContentType.addNewFormat();
	 }
	 
	 //
	 formatType.setExtent(formatExtent);
	}
	
	//
	public void addFormatMedium(final String formatMedium) throws Exception
	{
	 FormatType formatType = srtContentType.getFormat();
	 
	 if(formatType == null)
	 {
	 	formatType = srtContentType.addNewFormat();
	 }
	 
	 //
	 formatType.addMedium(formatMedium);
	}
	
	//
	public void addUploadInformation(final String userID, 
																																		final String userName, 
																																		final String userEmail,
																																		final String ipAddress, 
																																		final String port,
																																		final String protocol,
																																		final String date) throws Exception
	{
	 UploadInformationType uploadInformationType = srtCorpusMetadataType.getUploadInformation();
	 
	 if(srtCorpusMetadataType.getUploadInformation() == null)
	 {
	 	uploadInformationType = srtCorpusMetadataType.addNewUploadInformation();
	 }
		
	 //
		UserInfo userInfo =	uploadInformationType.addNewUserInfo();
		userInfo.setUserID(userID);
		userInfo.setName(userName);
		userInfo.setEmail(userEmail);
		
		uploadInformationType.setIPAddress(ipAddress);
		uploadInformationType.setPort(port);
		uploadInformationType.setProtocol(protocol);
		uploadInformationType.setDate(date);
	}
	
	//
	public void addReferenceAsset(final String assetID, final String property, final String value)
	{
	 ReferencedAssetsType referencedAssetsType = srtCorpusMetadataType.getReferencedAssets();
	 
	 if(referencedAssetsType == null)
	 {
	 	referencedAssetsType = srtCorpusMetadataType.addNewReferencedAssets();
	 }
	 
	 //
	 Asset asset = referencedAssetsType.addNewAsset();
		asset.setId(assetID);
		
		Prop assetPropertyObject = asset.addNewProp();
		assetPropertyObject.setType(property);
		assetPropertyObject.setValue(value);
	}
	
	//
	public void addFileAsset(final String assetID, final String fileName, final String fileMimeType)
	{
	 ReferencedAssetsType referencedAssetsType = srtCorpusMetadataType.getReferencedAssets();
	 
	 if(referencedAssetsType == null)
	 {
	 	referencedAssetsType = srtCorpusMetadataType.addNewReferencedAssets();
	 }
	 
	 //
	 Asset asset = referencedAssetsType.addNewAsset();
		asset.setId(assetID);
		
		Prop assetPropertyObject = asset.addNewProp();
		assetPropertyObject.setType("file_name");
		assetPropertyObject.setValue(fileName);
		
		assetPropertyObject = asset.addNewProp();
		assetPropertyObject.setType("mime_type");
		assetPropertyObject.setValue(fileMimeType);
	}
	
	//
 private ContentType getCorpusContent() throws Exception
 {
	 ContentType contentType = srtContentType.getContent();
	 
	 if(contentType == null)
	 {
	  contentType = srtContentType.addNewContent();
	 }
	 
	 //
	 return contentType;
 }
	
 //
 private ProjectInfoType getProjectInfo() throws Exception
 {
  ProjectInfoType projectInfoType = srtContentType.getProject();
  
  if(projectInfoType == null)
  {
   projectInfoType = srtContentType.addNewProject();
  }
  
  //
  return projectInfoType;
 }
 
 //
 // DOCUMENT BODY
 //
 public void addCorpusUnit(final String sourceLanguage, 
																								 		final String sourceContent,
																								 		final String targetLanguage, 
																								 		final String targetContent) throws Exception
	{
		CorpusUnit corpusUnit = srtCorpusBodyType.addNewCorpusUnit();
		
		//
		// Process Source
		Segment sourceSegment = corpusUnit.addNewSegment();
		sourceSegment.setLanguage(sourceLanguage);
		sourceSegment.setSegmentContent(sourceContent);

		//
		// Process Target
		Segment targetSegment = corpusUnit.addNewSegment();
		targetSegment.setLanguage(targetLanguage);
		targetSegment.setSegmentContent(targetContent);
	}
 
 //
 public void addCorpusUnit(final String[] unitAssets,
																								 		final String[] sourceAssets, 
																								 		final String sourceLanguage, 
																								 		final String sourceContent,
																								 		final String[] targetAssets,
																								 		final String targetLanguage, 
																								 		final String targetContent) throws Exception
 {
 	CorpusUnit corpusUnit = srtCorpusBodyType.addNewCorpusUnit();
 
 	//
 	//  Process Corpus Unit assets
 	for(String unitAsset : unitAssets)
 	{
   corpusUnit.addCorpusUnitAsset(unitAsset);
 	}
 	
 	//
 	// Process Source
 	Segment sourceSegment = corpusUnit.addNewSegment();
 	sourceSegment.setLanguage(sourceLanguage);
 	sourceSegment.setSegmentContent(sourceContent);
 	
 	//
 	// Process Source Segment assets
 	for(String segmentAsset : sourceAssets)
 	{
 		sourceSegment.addSegmentAsset(segmentAsset);
 	}
 	
 	//
 	// Process Target
 	Segment targetSegment = corpusUnit.addNewSegment();
 	targetSegment.setLanguage(targetLanguage);
 	targetSegment.setSegmentContent(targetContent);
 	
 	//
 	// Process Target Segment assets
 	for(String segmentAsset : targetAssets)
 	{
 		targetSegment.addSegmentAsset(segmentAsset);
 	}
 }
 
 //
 public void addCorpusUnit(final String[] unitAssets, 
 																										final CorporaSegment sourceSegment, 
 																										final CorporaSegment targetSegment)
 {
 	CorpusUnit corpusUnit = srtCorpusBodyType.addNewCorpusUnit();
  
 	//
 	//  Process Corpus Unit assets
 	if(unitAssets != null)
 	{
  	for(String unitAsset : unitAssets)
  	{
    corpusUnit.addCorpusUnitAsset(unitAsset);
  	}
 	}
 	
 	//
 	// Process Source Segment
 	Segment segment = corpusUnit.addNewSegment();
 	segment.setLanguage(sourceSegment.getLanguage());
 	segment.setSegmentContent(sourceSegment.getSegmentText());
 	
 	//... its assets
 	String[] assets = sourceSegment.getSegmentAssets();
 	
 	for(String segmentAsset : assets)
 	{
 		segment.addSegmentAsset(segmentAsset);
 	}
 	
 	// ... and its properties
 	List<CorporaSegmentAttribute> segmentAttributes = sourceSegment.getSegmentProperties();
 	
 	for(CorporaSegmentAttribute segmentProperty : segmentAttributes)
 	{
 		SegmentAttribute attribute = segment.addNewSegmentAttribute();
 		attribute.setAttributeKey(segmentProperty.getPropertyKey());
 		attribute.setAttributeValue(segmentProperty.getPropertyValue());
 	}
	
 	//
 	// Process Target Segments
  segment = corpusUnit.addNewSegment();
  segment.setLanguage(targetSegment.getLanguage());
  segment.setSegmentContent(targetSegment.getSegmentText());
  
 	//... its assets
 	assets = targetSegment.getSegmentAssets();
 	
 	for(String segmentAsset : assets)
 	{
 		segment.addSegmentAsset(segmentAsset);
 	}
 	
 	// ... and its properties
 	segmentAttributes = targetSegment.getSegmentProperties();
 	
 	for(CorporaSegmentAttribute segmentProperty : segmentAttributes)
 	{
 		SegmentAttribute attribute = segment.addNewSegmentAttribute();
 		attribute.setAttributeKey(segmentProperty.getPropertyKey());
 		attribute.setAttributeValue(segmentProperty.getPropertyValue());
 	}
 }
 
 //
 public void addCorpusUnit(final List<CorporaSegment> corporaSegmentList) throws Exception
 {
 	CorpusUnit corpusUnit = srtCorpusBodyType.addNewCorpusUnit();
  
 	//
 	// Process Segment assets
 	for(CorporaSegment segment : corporaSegmentList)
 	{
  	Segment corpusSegment = corpusUnit.addNewSegment();
  	corpusSegment.setLanguage(segment.getLanguage());
  	corpusSegment.setSegmentContent(segment.getSegmentText());
  	
  	//
  	// Set segment attributes
  	List<CorporaSegmentAttribute> segmentAttributes = segment.getSegmentProperties();
  	
  	if(segmentAttributes != null)
  	{
   	for(CorporaSegmentAttribute segmentProperty : segmentAttributes)
   	{
   		SegmentAttribute attribute = corpusSegment.addNewSegmentAttribute();
   		attribute.setAttributeKey(segmentProperty.getPropertyKey());
   		attribute.setAttributeValue(segmentProperty.getPropertyValue());
   	}
  	}
  	
  	//
  	// Set segment timestamps
   List<TimeStampObject> timeStampsList = segment.getSegmentTimeStamps();
   
   if(timeStampsList != null)
   {
   	TimeStampType segmentTimeStamps = corpusSegment.addNewSegmentTimeStamps();
   	
    for(TimeStampObject segmentTimeStamp : timeStampsList)
    {
     Timestamp timeStampAttribute = segmentTimeStamps.addNewTimestamp();
     timeStampAttribute.setToken(segmentTimeStamp.getTextContent());
     timeStampAttribute.setTimeStart(segmentTimeStamp.getTimeStart());
     timeStampAttribute.setTimeEnd(segmentTimeStamp.getTimeEnd());
     timeStampAttribute.setTokenDuration(segmentTimeStamp.getTokenDuration());
    }
   }
 	}
 }
 
 //
 public void addCorpusUnit(final BBNAssetObject bbnAssetObject) throws Exception
 {
  //
  // Process Segments
  int segmentCounter = 0;
  
  for(CorporaSegment corporaSourceSegment : bbnAssetObject.getSourceText())
  {
   CorpusUnit corpusUnit = srtCorpusBodyType.addNewCorpusUnit();
   List<TimeStampObject> timeStampsList = null;
   
   //
   // Source
   Segment sourceSegment = corpusUnit.addNewSegment();
   sourceSegment.setLanguage(corporaSourceSegment.getLanguage());
   sourceSegment.setSegmentContent(corporaSourceSegment.getSegmentText());
   
   // ... its attributes (source)
   for(CorporaSegmentAttribute attribute : corporaSourceSegment.getSegmentProperties())
   {
    SegmentAttribute segmentAttribute = sourceSegment.addNewSegmentAttribute();
    segmentAttribute.setAttributeKey(attribute.getPropertyKey());
    segmentAttribute.setAttributeValue(attribute.getPropertyValue());
    
    // Get the time stamps based on fragment id.. will be used below 
    if(attribute.getPropertyKey().equals("fragment_id"))
    {
     timeStampsList = bbnAssetObject.getTimestampSourceList(attribute.getPropertyValue());
    }
   }
   
   //... its assets (source)
   String[] assets = corporaSourceSegment.getSegmentAssets();
   
   if(assets != null)
   {
    for(String segmentAsset : assets)
    {
     sourceSegment.addSegmentAsset(segmentAsset);
    }
   }
   
  	//
  	//... its timestamps (see above where timeStampsList is assigned)
   if(timeStampsList != null)
   {
   	TimeStampType segmentTimeStamps = sourceSegment.addNewSegmentTimeStamps();
   	
    for(TimeStampObject segmentTimeStamp : timeStampsList)
    {
     Timestamp timeStampAttribute = segmentTimeStamps.addNewTimestamp();
     timeStampAttribute.setToken(segmentTimeStamp.getTextContent());
     timeStampAttribute.setTimeStart(segmentTimeStamp.getTimeStart());
     timeStampAttribute.setTimeEnd(segmentTimeStamp.getTimeEnd());
     timeStampAttribute.setTokenDuration(segmentTimeStamp.getTokenDuration());
    }
   }
   
   // reset
   timeStampsList.clear();
   timeStampsList = null;
   
   //
   // Get corresponding target
   CorporaSegment corporaTargetSegment = bbnAssetObject.getMTText().get(segmentCounter);
   
   Segment targetSegment = corpusUnit.addNewSegment();
   targetSegment.setLanguage(corporaTargetSegment.getLanguage());
   targetSegment.setSegmentContent(corporaTargetSegment.getSegmentText());
   
   // ... its attributes (target)
   for(CorporaSegmentAttribute attribute : corporaTargetSegment.getSegmentProperties())
   {
    SegmentAttribute segmentAttribute = targetSegment.addNewSegmentAttribute();
    segmentAttribute.setAttributeKey(attribute.getPropertyKey());
    segmentAttribute.setAttributeValue(attribute.getPropertyValue());
    
    // Get the time stamps based on fragment id.. will be used below 
    if(attribute.getPropertyKey().equals("fragment_id"))
    {
     timeStampsList = bbnAssetObject.getTimestampMTList(attribute.getPropertyValue());
    }
   }
   
   //... its assets (target)
   assets = corporaTargetSegment.getSegmentAssets();
   
   if(assets != null)
   {
    for(String segmentAsset : assets)
    {
     targetSegment.addSegmentAsset(segmentAsset);
    }
   }

   //
   //... its timestamps (see above where timeStampsList is assigned)
   if(timeStampsList != null)
   {
    TimeStampType segmentTimeStamps = targetSegment.addNewSegmentTimeStamps();
    
    for(TimeStampObject segmentTimeStamp : timeStampsList)
    {
     Timestamp timeStampAttribute = segmentTimeStamps.addNewTimestamp();
     timeStampAttribute.setToken(segmentTimeStamp.getTextContent());
     timeStampAttribute.setTimeStart(segmentTimeStamp.getTimeStart());
     timeStampAttribute.setTimeEnd(segmentTimeStamp.getTimeEnd());
     timeStampAttribute.setTokenDuration(segmentTimeStamp.getTokenDuration());
    }
   }
   
   //
   segmentCounter++;
  }
 }
 
 //
 public void addCorpusSearchText(final List<CorporaSegment> corporaSegmentList, final String language) throws Exception
 {
  CorpusSearchText corpusText = srtCorpusBodyType.addNewCorpusSearchText();
  
 	//
 	// Process Source Segments
  StringBuffer stringBuffer = new StringBuffer();
  
 	for(CorporaSegment segment : corporaSegmentList)
 	{
 		stringBuffer.append(segment.getSegmentText() + " ");
 	}

 	//
  // Source
  SearchText targetRawText = corpusText.addNewSearchText();
  targetRawText.setText(stringBuffer.toString());
  targetRawText.setLanguage(language);
 }
  
 //
 public void addCorpusSearchText(final List<CorporaSegment> corporaSourceSegmentList, 
 																																final String sourceLanguage,
 																																final List<CorporaSegment> corporaTargetSegmentList,
 																																final String targetLanguage) throws Exception
 {
  CorpusSearchText corpusText = srtCorpusBodyType.addNewCorpusSearchText();
  
 	//
 	// Process Source Segments
  StringBuffer corpusSearchText = new StringBuffer();
  
 	for(CorporaSegment segment : corporaSourceSegmentList)
 	{
 		corpusSearchText.append(segment.getSegmentText() + " ");
 	}
 	
  //
 	// ... add to search text (for indexing)
  SearchText searchtext = corpusText.addNewSearchText();
  searchtext.setText(corpusSearchText.toString());
  searchtext.setLanguage(sourceLanguage);

  //
  // Process Target Segments ... if any
  if(corporaTargetSegmentList.size() > 0)
  {
   StringBuffer targetStringBuffer = new StringBuffer();
   
   for(CorporaSegment segment : corporaTargetSegmentList)
   {
    targetStringBuffer.append(segment.getSegmentText() + " ");
   }
   
   //
   searchtext = corpusText.addNewSearchText();
   searchtext.setText(targetStringBuffer.toString());
   searchtext.setLanguage(targetLanguage);
  }
 }
 
 //
 public void addCorpusAnnotatedText(final List<CorporaSegment> corporaSegmentList, final String language) throws Exception
 {
  CorpusAnnotatedText corpusText = srtCorpusBodyType.addNewCorpusAnnotatedText();
  
  //
  // Process Source Segments
  StringBuffer stringBuffer = new StringBuffer();
  
  for(CorporaSegment segment : corporaSegmentList)
  {
   stringBuffer.append(segment.getSegmentText() + " ");
  }

  //
  // Source
  AnnotatedText targetRawText = corpusText.addNewAnnotatedText();
  targetRawText.setText(stringBuffer.toString());
  targetRawText.setLanguage(language);
 }
 
 //
 public void addCorpusAnnotatedText(final String annotatedText, final String language) throws Exception
 {
  CorpusAnnotatedText corpusText = srtCorpusBodyType.addNewCorpusAnnotatedText();

  //
  // 
  AnnotatedText targetRawText = corpusText.addNewAnnotatedText();
  targetRawText.setText(annotatedText);
  targetRawText.setLanguage(language);
 }
 
 //
 public void addCorpusAnnotatedText(final List<CorporaSegment> corporaSourceSegmentList, 
																																				final String sourceLanguage,
																																				final List<CorporaSegment> corporaTargetSegmentList,
																																				final String targetLanguage) throws Exception
 {
  StringBuffer stringBuffer = new StringBuffer();
	 CorpusAnnotatedText corpusText = srtCorpusBodyType.addNewCorpusAnnotatedText();
	 
		//
		// Process Source Segments
		for(CorporaSegment segment : corporaSourceSegmentList)
		{
			stringBuffer.append(segment.getSegmentText() + " ");
		}
		
  //
  AnnotatedText sourceText = corpusText.addNewAnnotatedText();
  sourceText.setText(stringBuffer.toString());
  sourceText.setLanguage(sourceLanguage);
	
	 //
	 // Process Target Segments
  stringBuffer.setLength(0);
	 
	 for(CorporaSegment segment : corporaTargetSegmentList)
	 {
	  stringBuffer.append(segment.getSegmentText() + " ");
	 }
	
	 //
	 AnnotatedText mtText = corpusText.addNewAnnotatedText();
	 mtText.setText(stringBuffer.toString());
	 mtText.setLanguage(targetLanguage);
 }
 
 //
 public String getSearchText(final String markupLanguage)
 {
  CorpusSearchText corpusSearchText = srtCorpusBodyType.getCorpusSearchText();
  SearchText[] searchArray = corpusSearchText.getSearchTextArray();
  
  // 
  for(SearchText text : searchArray)
  {
   if(text.getLanguage().compareTo(markupLanguage) == 0)
   {
    return text.getText();
   }
  }
  
  //
  return null;
 }
}
