package com.main.java.responsexml;

import java.io.FileWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/*
 * Marshaling Object into XMLFile
 * Reference - https://kodejava.org/how-to-generate-a-wrapper-element-around-xml-representation-in-jaxb
 * 
 * */

public class LowercaseXMLElementStreamWriter {
	String outputFileName;
	JAXBContext jabxContext;

	public LowercaseXMLElementStreamWriter(String fileName) throws Exception {

		outputFileName = fileName;

		jabxContext = JAXBContext.newInstance(ResponseOrder.class);
	}

	public void serializeObjectIntoXMLFile(ResponseOrder order) throws Exception {
		Writer writer = null;

		Marshaller marshaller = jabxContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(order, System.out);

		writer = new FileWriter(outputFileName);
		marshaller.marshal(order, writer);

	}
}
