package com.thetdgroup.srt_parser.corpus_metadata;

import org.json.JSONObject;

import comThetdgroupSchemaTdgSrtV1.CorpusMetadataType;

public class CorpusMetadataObject
{
	private CorpusContentObject corpusContentObject = new CorpusContentObject();
	private UploadInformationObject uploadInformationObject = new UploadInformationObject();
	private ReferenceAssetsObject referenceAssetObject = new ReferenceAssetsObject();
	
	//
	public void parse(CorpusMetadataType corpusMetadata) throws Exception
	{
		if(corpusMetadata.getCorpusContent() != null)
		{
		 corpusContentObject.parse(corpusMetadata.getCorpusContent());
		}
		
		if(corpusMetadata.getUploadInformation() != null)
		{
		 uploadInformationObject.parse(corpusMetadata.getUploadInformation());
		}
		
		if(corpusMetadata.getReferencedAssets() != null)
		{
		 referenceAssetObject.parse(corpusMetadata.getReferencedAssets());
		}
 }
	
	//
	public JSONObject toJSON() throws Exception
	{
		//
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("corpus_content", corpusContentObject.toJSON());
		jsonObject.put("upload_information", uploadInformationObject.toJSON());
		jsonObject.put("reference_assets", referenceAssetObject.toJSON());
		
		return jsonObject;
	}
}
