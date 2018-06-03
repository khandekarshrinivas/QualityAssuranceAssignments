package com.main.java.requestxml;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;

public class LowercaseXMLElementStreamReader
{
	String inputFileName;
	JAXBContext jabxContext;

 	private static class LowercaseStreamReaderDelegate extends StreamReaderDelegate
	{
 		public LowercaseStreamReaderDelegate(XMLStreamReader xsr)
		{
			super(xsr);
		}
 

		@Override
		public String getLocalName()
		{
			return super.getLocalName().toLowerCase();
		}
	}

	public LowercaseXMLElementStreamReader(String fileName) throws Exception
	{
		// Validate the file exists.
		File f = new File(fileName);
		if (!f.exists() || f.isDirectory())
		{
			jabxContext = null;
			throw new Exception("Invalid XML input file name: " + fileName);
		}
		inputFileName = fileName;

		// Create the jabx context and get ready for unmarshalling.
		jabxContext = JAXBContext.newInstance(IncomingOrder.class);
    }

    // Returns the object from deserializing the input file's XML.
    public IncomingOrder DeserializeXMLIntoObject() throws Exception
    {
		XMLInputFactory xif = XMLInputFactory.newInstance();
		XMLStreamReader xsr = xif.createXMLStreamReader(new FileInputStream(inputFileName));
		xsr = new LowercaseStreamReaderDelegate(xsr);
		Unmarshaller unmarshaller = jabxContext.createUnmarshaller();
        return (IncomingOrder) unmarshaller.unmarshal(xsr);
    }
}







