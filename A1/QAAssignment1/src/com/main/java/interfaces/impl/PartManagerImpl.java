package com.main.java.interfaces.impl;

import com.main.java.datalayer.OrderDB;
import com.main.java.interfaces.PARTMANAGER;
import com.main.java.requestxml.DeliveryAddress;

public class PartManagerImpl implements PARTMANAGER {

	@Override
	public PartResponse SubmitPartForManufactureAndDelivery(int partNumber, int quantity,
			DeliveryAddress deliveryAddress) {

		OrderDB db = new OrderDB();
		if (db.checkForOutOfStock(partNumber)) {
			return PartResponse.OUT_OF_STOCK;
		}
		if (db.checkForItemManufacturedAvailability(partNumber)) {
			return PartResponse.NO_LONGER_MANUFACTURED;
		}
		if (db.checkForItemAvailability(partNumber)) {
			return PartResponse.SUCCESS;
		}
		return PartResponse.INVALID_PART;
	}
}
