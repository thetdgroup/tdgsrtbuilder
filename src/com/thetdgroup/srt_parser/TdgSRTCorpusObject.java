package com.thetdgroup.srt_parser;

import org.json.JSONObject;

import com.thetdgroup.TDGSRTBuilder;
import com.thetdgroup.srt_parser.corpus_body.CorpusBodyObject;
import com.thetdgroup.srt_parser.corpus_metadata.CorpusMetadataObject;

import comThetdgroupSchemaTdgSrtV1.TDGSRTCorpusType;

public class TdgSRTCorpusObject
{
	private CorpusMetadataObject corpusMetadataObject = new CorpusMetadataObject();
	private CorpusBodyObject corpusBodyObject = new CorpusBodyObject();
	
	//
	public void parse(TDGSRTBuilder corporaBuilder) throws Exception
	{
		//
	TDGSRTCorpusType ompcCorpus = corporaBuilder.getLexicalResource();
		
		corpusMetadataObject.parse(ompcCorpus.getCorpusMetadata());
		corpusBodyObject.parse(ompcCorpus.getCorpusBody());
	}
	
	//
	public JSONObject toJSON() throws Exception
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("corpus_metadata", corpusMetadataObject.toJSON());
		jsonObject.put("corpus_body", corpusBodyObject.toJSON());
		
		return jsonObject;
	}
}
