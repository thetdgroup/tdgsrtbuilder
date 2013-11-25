package com.thetdgroup.input_parsers.new_captions;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.thetdgroup.TDGSRTBuilder;
import com.thetdgroup.base_parser.BaseParser;

import comThetdgroupClLanguageIso639V1.LanguageCodeIso6392Type;
import comThetdgroupMetadataControlledvocabularyV1.Alignment;
import comThetdgroupMetadataControlledvocabularyV1.CorpusType;
import comThetdgroupMetadataControlledvocabularyV1.DataType;
import comThetdgroupMetadataControlledvocabularyV1.Encoding;

//
public class NC2TDGSRTParser extends BaseParser
{  
	private NCXMLReader tmxReader = new NCXMLReader();
	
	//
 public void parseFile(final String inputFile) throws Exception
 {
  FileInputStream fileInputStream = null;
  
  try
  {
   fileInputStream = new FileInputStream(inputFile);

   // Parse the input
   tmxReader = new NCXMLReader();
   SAXParserFactory factory = SAXParserFactory.newInstance();
   
   SAXParser saxParser = factory.newSAXParser();
   saxParser.parse(fileInputStream, tmxReader);
  }
  catch(Exception exception)
  {
   System.out.println(exception.toString());
  }
  finally
  {
   // Close stream
   fileInputStream.close(); 
  }
 }
 
 //
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
   corporaBuilder.addUploadInformation("jdoe", "john doe", "jdoe@thetdgroup.com", "192.168.0.201", "443", "HTTPS", "08/06/2010");
   
   //
   // Corpus Body
   corporaBuilder.addCorpusUnit(tmxReader.getSegments());
   
   //
   // Raw Text
   corporaBuilder.addCorpusSearchText(tmxReader.getSegments(), LanguageCodeIso6392Type.ENG.toString());

   //
   // Project Information
   corporaBuilder.setProjectID(tmxReader.getCorpusInformation().getProjectID());
   corporaBuilder.setProjectTitle(tmxReader.getCorpusInformation().getProjectName());
   corporaBuilder.setProjectDescription(tmxReader.getCorpusInformation().getProjectDescription());
   corporaBuilder.setMediaID(tmxReader.getCorpusInformation().getMediaID());
   
   //
   // Linguistic
   corporaBuilder.setCorpusType(CorpusType.MONOLINGUAL.toString());
   corporaBuilder.setAlignmentType(Alignment.UNALIGNED.toString());
  // corporaBuilder.addSourceLanguage(LanguageCodeIso6392Type.ENG.toString());
   corporaBuilder.addSourceLanguageDialect("US");
   corporaBuilder.addSourceLanguageDialect("UK");
   
   //
   // Format
   corporaBuilder.addFormatDataType(DataType.TRANSCRIBED_SPEECH.toString());
   corporaBuilder.addFormatEncoding(Encoding.UTF_8.toString());
   corporaBuilder.setFormatExtent(tmxReader.getMediaLength());
   corporaBuilder.addFormatMedium("Format medium 1");
   
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

