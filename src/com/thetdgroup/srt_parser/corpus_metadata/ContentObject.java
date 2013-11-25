package com.thetdgroup.srt_parser.corpus_metadata;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import comThetdgroupSchemaTdgSrtV1.ContentType;
import comThetdgroupSchemaTdgSrtV1.ContentType.Genres.Genre;
import comThetdgroupSchemaTdgSrtV1.ContentType.Subjects.Subject;
import comThetdgroupSchemaTdgSrtV1.ContentType.TemporalCoverages.TemporalCoverage;
import comThetdgroupSchemaTdgSrtV1.GeoSpatialInformationType.Country;

public class ContentObject
{
	private String title = "";
	private String summary = "";
	private String version = "";
	private String versionDate = "";
	private String description = "";
	private String dataQuality = "";
	private String corpusComplete = "";
	
	private List<String> alternateTitlesArray = new ArrayList<String>();
	private List<SubjectObject> subjectArray = new ArrayList<SubjectObject>();
	private List<GenreObject> genreArray = new ArrayList<GenreObject>();
	private List<KeywordObject> keywordsArray = new ArrayList<KeywordObject>();
	private List<TemporalCoverageObject> temporalArray = new ArrayList<TemporalCoverageObject>();
	private List<CountryObject> countriesArray = new ArrayList<CountryObject>();
	
	//
 public void parse(ContentType contentType)
 {
 	title = contentType.getTitle();
 	summary = contentType.getCorpusSummary();
 	version = contentType.getVersion();
 	versionDate = contentType.getVersionDate();
 	description = contentType.getDescription();
 	dataQuality = contentType.getDataQuality();
 	
 	//
 	if(contentType.getCorpusCompleted() != null)
 	{
 	 corpusComplete = contentType.getCorpusCompleted().toString();
 	}
 	
		//
		// Parse Alternate Titles
 	if(contentType.getAlternateTitleArray() != null)
 	{
			String[] alternateTitleArray = contentType.getAlternateTitleArray();
			
			for(int iIndex = 0; iIndex < alternateTitleArray.length; iIndex++)
			{
				alternateTitlesArray.add(alternateTitleArray[iIndex]);
			}
 	}
 	
 	//
		// Parse Subjects
		if(contentType.getSubjects() != null)
		{
			Subject[] subjectsArray = contentType.getSubjects().getSubjectArray();
			
			for(int iIndex = 0; iIndex < subjectsArray.length; iIndex++)
			{
				subjectArray.add(new SubjectObject(subjectsArray[iIndex]));
			}
		}
		
 	//
		// Parse Genres
		if(contentType.getGenres() != null)
		{
			Genre[] genresArray = contentType.getGenres().getGenreArray();
			
			for(int iIndex = 0; iIndex < genresArray.length; iIndex++)
			{
				genreArray.add(new GenreObject(genresArray[iIndex]));
			}
		}
		
 	//
		// Parse Keywords
		if(contentType.getKeywords() != null)
		{
			String[] keywordArray = contentType.getKeywords().getKeywordArray();
			
			for(int iIndex = 0; iIndex < keywordArray.length; iIndex++)
			{
				keywordsArray.add(new KeywordObject(keywordArray[iIndex]));
			}
		}
		
 	//
		// Parse Temporal 
		if(contentType.getTemporalCoverages() != null)
		{
			TemporalCoverage[] coverageArray = contentType.getTemporalCoverages().getTemporalCoverageArray();
			
			for(int iIndex = 0; iIndex < coverageArray.length; iIndex++)
			{
				temporalArray.add(new TemporalCoverageObject(coverageArray[iIndex]));
			}
		}
		
 	//
		// Parse Geospatial 
	/*	if(contentType.getGeoSpatialMetadata() != null)
		{
	  Country[] countryArray = contentType.getGeoSpatialMetadata().getCountryArray();
			
			for(int iIndex = 0; iIndex < countryArray.length; iIndex++)
			{
				countriesArray.add(new CountryObject(countryArray[iIndex]));
			}
  }*/
 }
 
 //
 public JSONObject toJSON() throws Exception
 {
 	//
 	JSONArray jsonAlternateTitlesArray = new JSONArray();
 	
 	for(String object : alternateTitlesArray)
 	{
 		jsonAlternateTitlesArray.put(object);
 	}
 	
 	//
 	JSONArray jsonSubjectArray = new JSONArray();
 	
 	for(SubjectObject object : subjectArray)
 	{
 		jsonSubjectArray.put(object.toJSON());
 	}
 	
 	//
 	JSONArray jsonGenreArray = new JSONArray();
 	
 	for(GenreObject object : genreArray)
 	{
 		jsonGenreArray.put(object.toJSON());
 	}
 	
 	//
 	JSONArray jsonKeywordsArray = new JSONArray();
 	
 	for(KeywordObject object : keywordsArray)
 	{
 		jsonKeywordsArray.put(object.toJSON());
 	}
 	
 	//
 	JSONArray jsonTemporalArray = new JSONArray();
 	
 	for(TemporalCoverageObject object : temporalArray)
 	{
 		jsonTemporalArray.put(object.toJSON());
 	}
 	
 	//
 	JSONArray jsonCountryArray = new JSONArray();
 	
 	for(CountryObject object : countriesArray)
 	{
 		jsonCountryArray.put(object.toJSON());
 	}
 	
		//
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("corpus_title", title);
		jsonObject.put("corpus_summary", summary);
		jsonObject.put("corpus_version", version);
		jsonObject.put("corpus_version_date", versionDate);
		jsonObject.put("corpus_description", description);
		jsonObject.put("corpus_quality", dataQuality);
		jsonObject.put("corpus_completed", corpusComplete);
		jsonObject.put("corpus_alternate_titles", jsonAlternateTitlesArray);
		jsonObject.put("corpus_subjects", jsonSubjectArray);
		jsonObject.put("corpus_genres", jsonGenreArray);
		jsonObject.put("corpus_keywords", jsonKeywordsArray);
		jsonObject.put("corpus_temporal_coverage", jsonTemporalArray);
		jsonObject.put("corpus_countries", jsonCountryArray);
		
		return jsonObject;
 }
}
