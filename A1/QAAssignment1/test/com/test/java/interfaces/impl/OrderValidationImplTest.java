package com.test.java.interfaces.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.main.java.interfaces.impl.OrderValidationImpl;
import com.main.java.requestxml.IncomingOrder;
import com.main.java.responsexml.ResponseOrder;
import com.test.java.mock.data.MockXMLObjectData;

public class OrderValidationImplTest {

	OrderValidationImpl orderValidationImpl;
	IncomingOrder order;

	@BeforeEach
	public void init() {

		orderValidationImpl = new OrderValidationImpl();
		order = new IncomingOrder();
	}

	private Object deserializeXMLToItemObject(String xml, Class<?> cls) {
		try {
			StringReader reader = new StringReader(xml);
			JAXBContext jaxbContext = JAXBContext.newInstance(cls);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Object object = jaxbUnmarshaller.unmarshal(reader);
			return object;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Test
	public void testCheckAndValidateOrderDetails_NonAuthorizedDealerIdTest() {

		order = (IncomingOrder) deserializeXMLToItemObject(MockXMLObjectData.NOT_AUTHORIZED_DEALERID,
				IncomingOrder.class);
		ResponseOrder response = orderValidationImpl.checkAndValidateOrderDetails(order);

		assertNotNull(response);
		assertEquals("Not authorized", response.error);
		assertEquals("failure", response.result);
	}

	@Test
	public void testCheckAndValidateOrderDetails_NonAuthorizedDealerAccessIdTest() {

		order = (IncomingOrder) deserializeXMLToItemObject(MockXMLObjectData.NOT_AUTHORIZED_DEALERACCESSKEY,
				IncomingOrder.class);
		ResponseOrder response = orderValidationImpl.checkAndValidateOrderDetails(order);

		assertNotNull(response);
		assertEquals("Not authorized", response.error);
		assertEquals("failure", response.result);
	}

	@Test
	public void testCheckAndValidateOrderDetails_EmptyOrderItems() {

		order = (IncomingOrder) deserializeXMLToItemObject(MockXMLObjectData.EMPTY_ORDER_ITEM_LIST,
				IncomingOrder.class);
		ResponseOrder response = orderValidationImpl.checkAndValidateOrderDetails(order);

		assertNotNull(response);
		assertEquals("failure", response.result);
		assertEquals("Invalid order", response.error);
		assertEquals("Invalid order item list", response.errormessage);

	}

	@Test
	public void testCheckAndValidateOrderDetails_NullOrderItems() {

		order = (IncomingOrder) deserializeXMLToItemObject(MockXMLObjectData.NULL_ORDER_ITEM_LIST, IncomingOrder.class);
		ResponseOrder response = orderValidationImpl.checkAndValidateOrderDetails(order);

		assertNotNull(response);
		assertEquals("failure", response.result);
		assertEquals("Invalid order", response.error);
		assertEquals("Invalid order item list", response.errormessage);

	}

	@Test
	public void testCheckAndValidateOrderDetails_InvalidOrderItemEntry() {

		order = (IncomingOrder) deserializeXMLToItemObject(MockXMLObjectData.INVALID_ORDER_ITEM_ENTRY,
				IncomingOrder.class);
		ResponseOrder response = orderValidationImpl.checkAndValidateOrderDetails(order);

		assertNotNull(response);
		assertEquals("failure", response.result);
		assertEquals("Invalid order", response.error);
		assertEquals("Invalid order item entry", response.errormessage);

	}

	@Test
	public void testCheckAndValidateOrderDetails_ValidIncomingXML() {

		order = (IncomingOrder) deserializeXMLToItemObject(MockXMLObjectData.VALID_INCOMING_XML1, IncomingOrder.class);
		ResponseOrder response = orderValidationImpl.checkAndValidateOrderDetails(order);

		assertNotNull(response);
		assertEquals(order.orderitems.size(), response.items.size());
	}

	@Test
	public void testCheckAndValidateOrderDetails_WithoutDeliveryAddress() {

		order = (IncomingOrder) deserializeXMLToItemObject(MockXMLObjectData.WITHOUT_DELIVERY_ADDRESS,
				IncomingOrder.class);
		ResponseOrder response = orderValidationImpl.checkAndValidateOrderDetails(order);

		assertNotNull(response);
		assertEquals("failure", response.result);
		assertEquals("Invalid xml", response.error);
	}

	@Test
	public void testCheckAndValidateOrderDetails_ResponseOutOfStock_InvalidPart() {

		order = (IncomingOrder) deserializeXMLToItemObject(MockXMLObjectData.VALID_INCOMING_XML2, IncomingOrder.class);
		ResponseOrder response = orderValidationImpl.checkAndValidateOrderDetails(order);

		assertNotNull(response);
		assertEquals(order.orderitems.size(), response.items.size());
	}

	@Test
	public void testCheckAndValidateOrderDetails_ResponseOutOfStock_InvalidPar1t() {

		order = (IncomingOrder) deserializeXMLToItemObject(MockXMLObjectData.VALID_INCOMING_XML2, IncomingOrder.class);
		ResponseOrder response = orderValidationImpl.checkAndValidateOrderDetails(order);

		assertNotNull(response);
		assertEquals(order.orderitems.size(), response.items.size());
	}

	@Test
	public void testCheckAndValidateOrderDetails_WithoutNameAddress() {

		order = (IncomingOrder) deserializeXMLToItemObject(MockXMLObjectData.INVALID_DELIVERY_ADDRESS_WITHOUT_NAME,
				IncomingOrder.class);
		ResponseOrder response = orderValidationImpl.checkAndValidateOrderDetails(order);

		assertNotNull(response);
		assertEquals("failure", response.result);
		assertEquals("Invalid order", response.error);
		assertEquals("Invalid delivery address", response.errormessage);

	}
	
	@Test
	public void testCheckAndValidateOrderDetails_WithoutStreetAddress() {

		order = (IncomingOrder) deserializeXMLToItemObject(MockXMLObjectData.INVALID_DELIVERY_ADDRESS_WITHOUT_STREET,
				IncomingOrder.class);
		ResponseOrder response = orderValidationImpl.checkAndValidateOrderDetails(order);

		assertNotNull(response);
		assertEquals("failure", response.result);
		assertEquals("Invalid order", response.error);
		assertEquals("Invalid delivery address", response.errormessage);

	}

	@Test
	public void testCheckAndValidateOrderDetails_WithoutCityAddress() {

		order = (IncomingOrder) deserializeXMLToItemObject(MockXMLObjectData.INVALID_DELIVERY_ADDRESS_WITHOUT_CITY,
				IncomingOrder.class);
		ResponseOrder response = orderValidationImpl.checkAndValidateOrderDetails(order);

		assertNotNull(response);
		assertEquals("failure", response.result);
		assertEquals("Invalid order", response.error);
		assertEquals("Invalid delivery address", response.errormessage);

	}
	
	@Test
	public void testCheckAndValidateOrderDetails_WithoutProvinceAddress() {

		order = (IncomingOrder) deserializeXMLToItemObject(MockXMLObjectData.INVALID_DELIVERY_ADDRESS_WITHOUT_PROVINCE,
				IncomingOrder.class);
		ResponseOrder response = orderValidationImpl.checkAndValidateOrderDetails(order);

		assertNotNull(response);
		assertEquals("failure", response.result);
		assertEquals("Invalid order", response.error);
		assertEquals("Invalid delivery address", response.errormessage);

	}
	
	@Test
	public void testCheckAndValidateOrderDetails_WithoutPostalAddress() {

		order = (IncomingOrder) deserializeXMLToItemObject(MockXMLObjectData.INVALID_DELIVERY_ADDRESS_WITHOUT_POSTAL_CODE,
				IncomingOrder.class);
		ResponseOrder response = orderValidationImpl.checkAndValidateOrderDetails(order);

		assertNotNull(response);
		assertEquals("failure", response.result);
		assertEquals("Invalid order", response.error);
		assertEquals("Invalid delivery address", response.errormessage);

	}
	
	@Test
	public void testCheckAndValidateOrderDetails_InvalidDealerIdDetails() {

		order = (IncomingOrder) deserializeXMLToItemObject(MockXMLObjectData.INVALID_DEALERID_DETAILS,
				IncomingOrder.class);
		ResponseOrder response = orderValidationImpl.checkAndValidateOrderDetails(order);

		assertNotNull(response);
		assertEquals("failure", response.result);
		assertEquals("Invalid xml", response.error);

	}

	@Test
	public void testCheckAndValidateOrderDetails_InvalidDealerAccessKeyDetails() {

		order = (IncomingOrder) deserializeXMLToItemObject(MockXMLObjectData.INVALID_DEALERACCESSKEY_DETAILS,
				IncomingOrder.class);
		ResponseOrder response = orderValidationImpl.checkAndValidateOrderDetails(order);

		assertNotNull(response);
		assertEquals("failure", response.result);
		assertEquals("Invalid xml", response.error);

	}
	
	@Test
	public void testCheckAndValidateOrderDetails_NegativePartNumber() {

		order = (IncomingOrder) deserializeXMLToItemObject(MockXMLObjectData.NEGATIVE_PARTNUMBER,
				IncomingOrder.class);
		ResponseOrder response = orderValidationImpl.checkAndValidateOrderDetails(order);

		assertNotNull(response);
		assertEquals("failure", response.result);
		assertEquals("Invalid order", response.error);
		assertEquals("Invalid order item entry", response.errormessage);

	}

	@Test
	public void testGenerateDealerResponse() throws Exception {
		orderValidationImpl.generateDealerResponse("requestXMLfiles/IncomingOrder.xml", "responseXMLfiles/test.xml");
	}

	
	@Test
	public void testOrderValidationImplMain_InvalidXML() throws Exception {
		String[] args = {"requestXMLfiles/InvalidXML.xml"};
		OrderValidationImpl.main(args);
	}
	
	@Test
	public void testOrderValidationImplMain() throws Exception {
		String[] args = {"requestXMLfiles/IncomingOrder.xml"};
		OrderValidationImpl.main(args);
	}
}