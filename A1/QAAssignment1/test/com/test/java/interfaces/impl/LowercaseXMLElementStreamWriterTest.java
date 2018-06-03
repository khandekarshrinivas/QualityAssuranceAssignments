package com.test.java.interfaces.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.main.java.responsexml.LowercaseXMLElementStreamWriter;
import com.test.java.mock.data.MockXMLObjectData;

public class LowercaseXMLElementStreamWriterTest {
	
	LowercaseXMLElementStreamWriter lowercaseXMLElementStreamWriter;
	
	@BeforeEach
	public void init() throws Exception {

		String filename = "responseXMLfiles/test.xml";
		lowercaseXMLElementStreamWriter = new LowercaseXMLElementStreamWriter(filename);
	}
	
	@Test
	public void testSerializeObjectIntoXMLFile() throws Exception {
		lowercaseXMLElementStreamWriter.serializeObjectIntoXMLFile(MockXMLObjectData.getResponseOrder());
	}
}
