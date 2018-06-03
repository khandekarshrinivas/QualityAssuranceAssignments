package com.main.java.interfaces;

import com.main.java.requestxml.IncomingOrder;
import com.main.java.responsexml.ResponseOrder;

public interface OrderValidation {

	public ResponseOrder checkAndValidateOrderDetails(IncomingOrder order);

	public void generateDealerResponse(String inputXMLFile, String outputXMLFile) throws Exception;

}
