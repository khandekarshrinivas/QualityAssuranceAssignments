package com.test.java.interfaces.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.main.java.requestxml.IncomingOrder;
import com.main.java.requestxml.LowercaseXMLElementStreamReader;

public class LowercaseXMLElementStreamReaderTest {
	@Test
	void testLowercaseXMLElementStreamReader() {
		try {
			LowercaseXMLElementStreamReader reader = new LowercaseXMLElementStreamReader(
					"requestXMLfiles/IncomingOrder.xml");
			IncomingOrder incomingOrder = (IncomingOrder) reader.DeserializeXMLIntoObject();
			assertEquals("XXX-1234-ABCD-1231", incomingOrder.dealer.dealerid);
			assertEquals("kkklas8882kk23nllfjj88290", incomingOrder.dealer.dealeraccesskey);
		} catch (Exception e) {
		}
	}

	@Test
	void testLowercaseXMLElementStreamReader_Exception() {

		assertThrows(Exception.class, () -> {
			LowercaseXMLElementStreamReader reader = new LowercaseXMLElementStreamReader("src/test.xml");
		});

	}
}
