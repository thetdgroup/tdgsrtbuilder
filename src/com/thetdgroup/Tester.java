package com.thetdgroup;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.thetdgroup.input_parsers.bbn.BBN2TDGSRTParser;
import com.thetdgroup.input_parsers.netgister.NetgisterParser;
import com.thetdgroup.input_parsers.new_captions.NC2TDGSRTParser;
import com.thetdgroup.srt_parser.corpus_segment.CorporaSegment;
import com.thetdgroup.srt_parser.TdgSRTDocumentParser;

import comThetdgroupClLanguageIso639V1.LanguageCodeIso6392Type;
import comThetdgroupMetadataControlledvocabularyV1.Alignment;
import comThetdgroupMetadataControlledvocabularyV1.CorpusType;
import comThetdgroupMetadataControlledvocabularyV1.DataType;
import comThetdgroupMetadataControlledvocabularyV1.Encoding;

public class Tester
{
	private final static String textDocument = "//Users//ericdamphousse/tmp/blabla.xml";
	//private final static String textDocument = "d:/tmp/blabla.xml";
	
	//
	public static void main(String[] arguments)
	{
		System.out.println("Create document");
		createDocument();
		
		//System.out.println("Load document");
		//loadDocument();
	
	// System.out.println("Parsing document");
	 
	 try
		{
	 /* NC2TDGSRTParser ncp = new NC2TDGSRTParser();
	 	ncp.parseFile("/usr/local/data/datawarehouse_input_data/newcaption_data/President_Obama_Signs_The_21st_Century_Communications_And_Video_Accessibility_Act_00m_00s__01m_16s_35h.rdf");
	 	ncp.createTDGSRTDocument("/usr/local/data/datawarehouse_input_data/newcaption_data/President_Obama_Signs_The_21st_Century_Communications_And_Video_Accessibility_Act_00m_00s__01m_16s_35h.xml");
			
			BBN2TDGSRTParser bbnParser = new BBN2TDGSRTParser();
			bbnParser.parseFile("/usr/local/data/datawarehouse_input_data/bbn_data/TV-Espanola_01_May_12_00_00_22 Content/files/clip_metadata.xml");
			bbnParser.createTDGSRTDocument("/usr/local/data/datawarehouse_input_data/bbn_data/TV-Espanola_01_May_12_00_00_22 Content/files/aaa.xml");
   */
	  
	 // NC2TDGSRTParser ncp = new NC2TDGSRTParser();
  // ncp.parseFile("d:\\tmp\\CNNcom_000._full.rdf");
  // ncp.createTDGSRTDocument("d:\\tmp\\CNNcom_000._full.xml");

 /*  BBN2TDGSRTParser bbnParser = new BBN2TDGSRTParser();
   bbnParser.parseFile("d:\\tmp\\clip_metadata.xml");
   bbnParser.createTDGSRTDocument("d:\\tmp\\bbn.xml");*/
	 	
	 //	NetgisterParser netGisterParser = new NetgisterParser();
  // netGisterParser.parseFile("/Users/ericdamphousse/tmp/json_test_file.txt");
  // netGisterParser.parseFile("d:/tmp/json_test_file.txt");

   TDGSRTBuilder documentParser = new TDGSRTBuilder();
   documentParser.loadDocument(new File("/Users/ericdamphousse/tmp/out_out.xml"));
   
   //documentParser.documentToJSON();
   documentParser.printDocument();
   
	  //
  // String content = FileUtils.readFileToString(new File("newcaption_data"), "UTF-8");
   
		//	SimpleSummariser storage = new SimpleSummariser();
  // String result = storage.summarise(content, 1);
  // System.out.println(result);
		} 
	 catch(Exception e)
		{
			e.printStackTrace();
		}
	 
	}
	
	//
	//
	private static void createDocument()
	{
	 TDGSRTBuilder corporaBuilder = new TDGSRTBuilder();
		
		//
		try
		{
			corporaBuilder.createSRTDocument();
			
			// Upload Info
			corporaBuilder.addUploadInformation("jdoe", "john doe", "jdoe@thetdgroup.com", "192.168.0.201", "443", "HTTPS", "08/06/2010");
			
			// Reference Assets (For Unit level)
			corporaBuilder.addFileAsset("unit_asset_1.0", "my_file.txt", "text/plain");
			corporaBuilder.addFileAsset("unit_asset_1.1", "alif.jpg", "image/jpeg");
			
			// Reference Assets (For Segment level)
			corporaBuilder.addReferenceAsset("source_segment_1_asset_1", "mime_type", "image/jpeg");
			corporaBuilder.addReferenceAsset("source_segment_1_asset_1", "file_name", "alif.jpg");
			corporaBuilder.addReferenceAsset("source_segment_1_asset_2", "mime_type", "audio/mp3");
			corporaBuilder.addReferenceAsset("source_segment_1_asset_2", "file_name", "alif.mp3");
			
			corporaBuilder.addReferenceAsset("target_segment_1_asset_1", "mime_type", "image/jpeg");
			corporaBuilder.addReferenceAsset("target_segment_1_asset_1", "file_name", "baa.jpg");
			corporaBuilder.addReferenceAsset("target_segment_1_asset_2", "mime_type", "audio/mp3");
			corporaBuilder.addReferenceAsset("target_segment_1_asset_2", "file_name", "baa.mp3");			
			
			//
			// Corpus Body
			String[] unitLevelAssets = {"unit_asset_1.0", "unit_asset_1.1"};
			
			String[] sourceSegmentAssets = {"source_segment_1_asset_1", "source_segment_1_asset_2"};
			String sourceLanguage = LanguageCodeIso6392Type.ENG.toString();
			String sourceContent = "my source content";

			String[] targetSegmentAssets = {"target_segment_1_asset_1", "target_segment_1_asset_2"};
			String targetLanguage = LanguageCodeIso6392Type.ARA.toString();
			String targetContent = "my target content";
			
			for(int iIndex = 0; iIndex < 1; iIndex++)
			{
				CorporaSegment sourceSegment = new CorporaSegment(sourceLanguage, sourceContent + " " + iIndex, sourceSegmentAssets);
				sourceSegment.addSegmentAttribute("source prop key 1", "source prop value 1");
				sourceSegment.addSegmentAttribute("source prop key 2", "source prop value 2");
				
				CorporaSegment targetSegment = new CorporaSegment(targetLanguage, targetContent + " " + iIndex, targetSegmentAssets);
			 targetSegment.addSegmentAttribute("target prop key 1", "target prop value 1");
			 targetSegment.addSegmentAttribute("target prop key 2", "target prop value 2");

			 corporaBuilder.addCorpusUnit(unitLevelAssets,
			 																													sourceSegmentAssets,
																														 		sourceLanguage,
																														 		sourceContent + " " + iIndex,
																														 		targetSegmentAssets,
																														 		targetLanguage,
																														 		targetContent + " " + iIndex);
			 
			 corporaBuilder.addCorpusUnit(unitLevelAssets, sourceSegment,	targetSegment);
			}
			
			//
			// Content Type
			corporaBuilder.setCorpusTitle("The Corpus Title");
			corporaBuilder.addCorpusAlternateTitle("Corpus Alternate Title One");
			corporaBuilder.addCorpusAlternateTitle("Corpus Alternate Title Two");
			corporaBuilder.setCorpusVersion("Corpus Version 1.0", "08/06/2010");
			corporaBuilder.setCorpusSummary("Corpus Summary");
			
			corporaBuilder.addCorpusSubject("Subject MetaID 1", "Subject One");
			corporaBuilder.addCorpusSubject("Subject MetaID 2", "Subject Two");
			corporaBuilder.addCorpusGenre("Genre MetaID 1", "Genre One");
			corporaBuilder.addCorpusGenre("Genre MetaID 2", "Genre Two");
			corporaBuilder.addCorpusKeywords("Keyword 1");
			corporaBuilder.addCorpusKeywords("Keyword 2");
			corporaBuilder.addCity("111", "US", "United States");
			corporaBuilder.addCity("222", "CA", "Canada Hey");
			corporaBuilder.setDescription("Corpus Description");
			corporaBuilder.setDataQuality("Corpus is pretty good");
			corporaBuilder.addTemporalCoverage("Description of 1st temporal coverage", "07/06/2010", "08/06/2010");
			corporaBuilder.addTemporalCoverage("Description of 2nd temporal coverage", "08/06/2010", "09/06/2010");
			corporaBuilder.setCorpusCompleted(true);
			
			// Linguistic
			corporaBuilder.setCorpusType(CorpusType.PARALLEL.toString());
			corporaBuilder.setAlignmentType(Alignment.SENTENCE.toString());
			//corporaBuilder.setSourceLanguage("eng");
			corporaBuilder.addSourceLanguageDialect("US");
			corporaBuilder.addSourceLanguageDialect("UK");
			corporaBuilder.addTargetLanguage(LanguageCodeIso6392Type.KOR.toString());
			corporaBuilder.addTargetLanguage(LanguageCodeIso6392Type.FRE.toString());
			
			// Format
			corporaBuilder.addFormatDataType(DataType.ELECTRONIC_TEXT.toString());
			corporaBuilder.addFormatDataType(DataType.TRANSCRIBED_SPEECH.toString());
			corporaBuilder.addFormatEncoding(Encoding.ASCII.toString());
			corporaBuilder.addFormatEncoding(Encoding.UTF_8.toString());
			corporaBuilder.setFormatExtent("Size or duration of the resource");
			corporaBuilder.addFormatMedium("Format medium 1");
			corporaBuilder.addFormatMedium("Format medium 2");
	
			//
	  // Write
		 corporaBuilder.saveDocument(new File(textDocument));
	 }
 	catch(Exception exception)
 	{
 		exception.printStackTrace();
 	}		
	}
	
	//
	private static void loadDocument()
	{
		try
		{
			TdgSRTDocumentParser docParser = new TdgSRTDocumentParser();
			docParser.parse("/usr/local/data/datawarehouse_output_data/ompc_data/aets/Arabic-WeekFour-1-minutes 4.57.xml");

			System.out.println(docParser.toJSON());
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}
}
