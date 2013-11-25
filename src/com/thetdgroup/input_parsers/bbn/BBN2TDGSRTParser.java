package com.thetdgroup.input_parsers.bbn;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.thetdgroup.TDGSRTBuilder;
import com.thetdgroup.base_parser.BaseParser;
import comThetdgroupMetadataControlledvocabularyV1.Alignment;
import comThetdgroupMetadataControlledvocabularyV1.CorpusType;
import comThetdgroupMetadataControlledvocabularyV1.DataType;
import comThetdgroupMetadataControlledvocabularyV1.Encoding;

public final class BBN2TDGSRTParser extends BaseParser
{
 private BBNXMLReader bbnReader = null;
 
 //
 public void parseFile(final String inputFile) throws Exception
 {
  FileInputStream fileInputStream = null;
  
  try
  {
   fileInputStream = new FileInputStream(inputFile);

   // Parse the input
   bbnReader = new BBNXMLReader();
   SAXParserFactory factory = SAXParserFactory.newInstance();
   
   SAXParser saxParser = factory.newSAXParser();
   saxParser.parse(fileInputStream, bbnReader);
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
   corporaBuilder.addUploadInformation(bbnReader.getAssetObject().getUserName(), 
                                       "", 
                                       "", 
                                       "",
                                       "", 
                                       "", 
                                       bbnReader.getAssetObject().getUploadTime());
   
   //
   // Corpus Body
   corporaBuilder.addCorpusUnit(bbnReader.getAssetObject());
   
   //
   // Search Text and Annotated Text
  // corporaBuilder.addCorpusSearchText(bbnReader.getAssetObject().getSourceText(), bbnReader.getAssetObject().getMTText());
  // corporaBuilder.addCorpusAnnotatedText(bbnReader.getAssetObject().getSourceAnnotatedText(), bbnReader.getAssetObject().getMTAnnotatedText());
   
   //
   // Project Information
   corporaBuilder.setProjectID(bbnReader.getAssetObject().getSessionID());
   corporaBuilder.setProjectTitle(bbnReader.getAssetObject().getAssetName());
   
   //
   // Linguistic
   corporaBuilder.setCorpusType(CorpusType.PARALLEL.toString());
   corporaBuilder.setAlignmentType(Alignment.OTHER.toString());
   //corporaBuilder.addSourceLanguage(bbnReader.getAssetObject().getSourceLanguage());
   corporaBuilder.addTargetLanguage(bbnReader.getAssetObject().getTargetLanguage());
   
   //
   // Format
   corporaBuilder.addFormatDataType(DataType.TRANSCRIBED_SPEECH.toString());
   corporaBuilder.addFormatEncoding(Encoding.UTF_8.toString());
   corporaBuilder.setFormatExtent(bbnReader.getAssetObject().getDuration());
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

