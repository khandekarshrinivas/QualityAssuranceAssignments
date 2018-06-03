package com.main.java.interfaces;

import com.main.java.requestxml.DeliveryAddress;

public interface PARTMANAGER
{
	public enum PartResponse
	{
		SUCCESS,
		OUT_OF_STOCK,
		NO_LONGER_MANUFACTURED,
		INVALID_PART,
		INVALID_XML
	}

	// Submit part for manufacture and delivery.
	public PartResponse SubmitPartForManufactureAndDelivery(int partNumber, int quantity, DeliveryAddress deliveryAddress);
}