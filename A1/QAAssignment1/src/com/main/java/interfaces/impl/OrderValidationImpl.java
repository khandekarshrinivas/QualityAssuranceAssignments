package com.main.java.interfaces.impl;

import java.util.List;

import com.main.java.interfaces.OrderValidation;
import com.main.java.interfaces.PARTMANAGER;
import com.main.java.requestxml.Dealer;
import com.main.java.requestxml.DeliveryAddress;
import com.main.java.requestxml.IncomingOrder;
import com.main.java.requestxml.Item;
import com.main.java.requestxml.LowercaseXMLElementStreamReader;
import com.main.java.responsexml.LowercaseXMLElementStreamWriter;
import com.main.java.responsexml.ResponseOrder;

public class OrderValidationImpl implements OrderValidation {

	private boolean checkDeliveryAddress(DeliveryAddress deliveryAddress) {

		if (deliveryAddress.city.isEmpty())
			return false;
		if (deliveryAddress.name.isEmpty())
			return false;
		if (deliveryAddress.street.isEmpty())
			return false;
		if (deliveryAddress.province.isEmpty())
			return false;
		if (deliveryAddress.postalcode.isEmpty())
			return false;
		return true;

	}

	private boolean checkDealerDetails(Dealer dealer) {

		if (dealer.dealerid.trim().isEmpty())
			return false;
		if (dealer.dealeraccesskey.trim().isEmpty())
			return false;
		return true;
	}

	private boolean validOrder(Item item) {

		if (item.partnumber <= 0)
			return false;
		if (item.quantity <= 0)
			return false;
		return true;
	}

	@Override
	public ResponseOrder checkAndValidateOrderDetails(IncomingOrder incomingOrder) {

		ResponseOrder responseOrder = null;
		SecurityImpl security = null;
		PartManagerImpl partManager = null;

			responseOrder = new ResponseOrder();
			security = new SecurityImpl();
			partManager = new PartManagerImpl();

			Dealer dealer = incomingOrder.dealer;

			if (!checkDealerDetails(dealer)) {
				responseOrder.result = "failure";
				responseOrder.error = "Invalid xml";
				responseOrder.items = null;
				return responseOrder;
			}

			if (!security.IsDealerAuthorized(dealer.dealerid, dealer.dealeraccesskey)) {
				responseOrder.result = "failure";
				responseOrder.error = "Not authorized";
				responseOrder.items = null;
				return responseOrder;
			}

			DeliveryAddress deliveryAddress = incomingOrder.deliveryaddress;
			if (deliveryAddress == null) {
				responseOrder.result = "failure";
				responseOrder.error = "Invalid xml";
				responseOrder.items = null;
				return responseOrder;
			}
			boolean isValidDeliveryAddress = checkDeliveryAddress(deliveryAddress);
			if (!isValidDeliveryAddress) {
				responseOrder.result = "failure";
				responseOrder.error = "Invalid order";
				responseOrder.errormessage = "Invalid delivery address";
				responseOrder.items = null;
				return responseOrder;
			}

			List<Item> orderItems = incomingOrder.orderitems;
			if (orderItems == null || orderItems.isEmpty()) {
				responseOrder.result = "failure";
				responseOrder.error = "Invalid order";
				responseOrder.errormessage = "Invalid order item list";
				responseOrder.items = null;
				return responseOrder;
			}

			for (Item item : orderItems) {
				if (!validOrder(item)) {
					responseOrder.result = "failure";
					responseOrder.error = "Invalid order";
					responseOrder.errormessage = "Invalid order item entry";
					responseOrder.items = null;
					return responseOrder;
				}
			}

			for (Item item : orderItems) {

				PARTMANAGER.PartResponse partResponse = partManager.SubmitPartForManufactureAndDelivery(item.partnumber,
						item.quantity, deliveryAddress);

				com.main.java.responsexml.Item responseItem = new com.main.java.responsexml.Item();

				responseItem.partnumber = item.partnumber;
				responseItem.quantity = item.quantity;
				responseItem.result = "failure";

				if (partResponse.equals(PARTMANAGER.PartResponse.SUCCESS)) {
					responseItem.result = "success";
					responseItem.errormessage = "";
				} else if (partResponse.equals(PARTMANAGER.PartResponse.OUT_OF_STOCK)) {
					responseItem.errormessage = "out of stock";
				} else if (partResponse.equals(PARTMANAGER.PartResponse.NO_LONGER_MANUFACTURED)) {
					responseItem.errormessage = "no longer manufactured";
				} else {
					responseItem.errormessage = "invalid part";
				}

				responseOrder.items.add(responseItem);
			}
		
		return responseOrder;
	}

	@Override
	public void generateDealerResponse(String inputXMLFile, String outputXMLFile) throws Exception {

		LowercaseXMLElementStreamReader reader = new LowercaseXMLElementStreamReader(inputXMLFile);
		IncomingOrder incomingOrder = (IncomingOrder) reader.DeserializeXMLIntoObject();

		ResponseOrder response = checkAndValidateOrderDetails(incomingOrder);
		LowercaseXMLElementStreamWriter writer = new LowercaseXMLElementStreamWriter(outputXMLFile);
		writer.serializeObjectIntoXMLFile(response);
	}

	public static void main(String[] args) throws Exception {
		String inputXMLFile = args[0];
		String outputXMLFile = "responseXMLfiles/DealerResponse.xml";
		try {
			OrderValidationImpl impl = new OrderValidationImpl();
			impl.generateDealerResponse(inputXMLFile, outputXMLFile);
		} catch (Exception e) {
			ResponseOrder responseOrder = new ResponseOrder();
			responseOrder.result = "failure";
			responseOrder.error = "invalid xml";
			responseOrder.items = null;
			LowercaseXMLElementStreamWriter writer = new LowercaseXMLElementStreamWriter(outputXMLFile);
			writer.serializeObjectIntoXMLFile(responseOrder);
			
		}

	}
}
