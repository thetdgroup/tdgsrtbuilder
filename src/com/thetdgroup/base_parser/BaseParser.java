package com.thetdgroup.base_parser;

import java.io.File;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.jdom.input.DOMBuilder;
import org.jdom.input.SAXBuilder;
import org.jdom.output.DOMOutputter;

public abstract class BaseParser
{
	protected	SAXBuilder saxBuilder = new SAXBuilder();
	protected DOMOutputter domOutputter = new DOMOutputter();
	protected DOMBuilder domBuilder = new DOMBuilder();
	
	//
	public abstract void parseFile(String inputFile) throws Exception;
	public abstract String createTDGSRTDocument() throws Exception;
	
	//
	public void makeDirectory(String directoryName) throws Exception
	{
		try
		{
		 FileUtils.forceMkdir(new File(directoryName));
		}
		catch(Exception exception)
		{
			throw exception;
		}
	}
}
