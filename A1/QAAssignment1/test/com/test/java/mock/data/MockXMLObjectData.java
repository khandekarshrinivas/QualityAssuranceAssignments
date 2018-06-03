package com.test.java.mock.data;

import com.main.java.responsexml.ResponseOrder;

public class MockXMLObjectData {
	
	public static final String NOT_AUTHORIZED_DEALERID = "<order>\r\n" + "<dealer>\r\n" + "<dealerid>XXX-1234-ABCD-1200</dealerid>\r\n"
			+ "<dealeraccesskey>kkklas8882kk23nllfjj88290</dealeraccesskey>\r\n" + "</dealer>\r\n" + "</order>";

	public static final String NOT_AUTHORIZED_DEALERACCESSKEY = "<order>\r\n" + "<dealer>\r\n"
			+ "<dealerid>XXX-1234-ABCD-1231</dealerid>\r\n"
			+ "<dealeraccesskey>kkklas8882kk23nllfjj11190</dealeraccesskey>\r\n" + "</dealer>\r\n" + "</order>";

	public static final String INVALID_DEALERID_DETAILS = "<order>\r\n" + "<dealer>\r\n" + "<dealerid>   </dealerid>\r\n"
			+ "<dealeraccesskey>  </dealeraccesskey>\r\n" + "</dealer>\r\n" + "</order>";

	public static final String INVALID_DEALERACCESSKEY_DETAILS = "<order>\r\n" + "<dealer>\r\n"
			+ "<dealerid>XXX-1234-ABCD-1200</dealerid>\r\n" + "<dealeraccesskey>  </dealeraccesskey>\r\n"
			+ "</dealer>\r\n" + "</order>";

	public static final String VALID_INCOMING_XML1 = "<order><dealer><dealerid>XXX-1234-ABCD-1234</dealerid> "
			+ "<dealeraccesskey>kkklas8882kk23nllfjj88290</dealeraccesskey> </dealer> "
			+ "<orderitems> <item> <partnumber>1234</partnumber> <quantity>2</quantity> </item> "
			+ "<item> <partnumber>5678</partnumber> <quantity>25</quantity> </item> </orderitems>"
	 		+ " <deliveryaddress> <name>Mrs. Jane Smith</name> <street>35 Streetname</street> "
			+ "<city>Halifax</city> <province>NS</province> <postalcode>B2T1A4</postalcode> </deliveryaddress> </order>";

	public static final String WITHOT_DEALER_XML = "<order><orderitems> <item> <partnumber>1234</partnumber> <quantity>2</quantity> </item> "
			+ "<item> <partnumber>5678</partnumber> <quantity>25</quantity> </item> </orderitems>"
			+ " <deliveryaddress> <name>Mrs. Jane Smith</name> <street>35 Streetname</street> "
			+ "<city>Halifax</city> <province>NS</province> <postalcode>B2T1A4</postalcode> </deliveryaddress> </order>";

	public static final String WITHOUT_DELIVERY_ADDRESS = "<order><dealer><dealerid>XXX-1234-ABCD-1234</dealerid> "
			+ "<dealeraccesskey>kkklas8882kk23nllfjj88290</dealeraccesskey> </dealer> </order>";

	public static final String VALID_INCOMING_XML2 = "<order><dealer><dealerid>XXX-1234-ABCD-1234</dealerid> "
			+ "<dealeraccesskey>kkklas8882kk23nllfjj88290</dealeraccesskey> </dealer> "
			+ "<orderitems> <item> <partnumber>0001</partnumber> <quantity>2</quantity> </item> "
			+ "<item> <partnumber>1201</partnumber> <quantity>25</quantity> </item> </orderitems>"
			+ " <deliveryaddress> <name>Mrs. Jane Smith</name> <street>35 Streetname</street> "
			+ "<city>Halifax</city> <province>NS</province> <postalcode>B2T1A4</postalcode> </deliveryaddress> </order>";

	public static final String NEGATIVE_PARTNUMBER = "<order><dealer><dealerid>XXX-1234-ABCD-1234</dealerid> "
			+ "<dealeraccesskey>kkklas8882kk23nllfjj88290</dealeraccesskey> </dealer> "
			+ "<orderitems><item> <partnumber>-1</partnumber> <quantity>25</quantity> </item> </orderitems>"
			+ " <deliveryaddress> <name>Mrs. Jane Smith</name> <street>35 Streetname</street> "
			+ "<city>Halifax</city> <province>NS</province> <postalcode>B2T1A4</postalcode> </deliveryaddress> </order>";
	
	public static final String EMPTY_ORDER_ITEM_LIST = "<order><dealer><dealerid>XXX-1234-ABCD-1234</dealerid> "
			+ "<dealeraccesskey>kkklas8882kk23nllfjj88290</dealeraccesskey> </dealer> " + "<orderitems> </orderitems>"
			+ " <deliveryaddress> <name>Mrs. Jane Smith</name> <street>35 Streetname</street> "
			+ "<city>Halifax</city> <province>NS</province> <postalcode>B2T1A4</postalcode> </deliveryaddress> </order>";

	public static final String NULL_ORDER_ITEM_LIST = "<order><dealer><dealerid>XXX-1234-ABCD-1234</dealerid> "
			+ "<dealeraccesskey>kkklas8882kk23nllfjj88290</dealeraccesskey> </dealer> " + "<orderitems> </orderitems>"
			+ " <deliveryaddress> <name>Mrs. Jane Smith</name> <street>35 Streetname</street> "
			+ "<city>Halifax</city> <province>NS</province> <postalcode>B2T1A4</postalcode> </deliveryaddress> </order>";

	public static final String INVALID_ORDER_ITEM_ENTRY = "<order><dealer><dealerid>XXX-1234-ABCD-1234</dealerid> "
			+ "<dealeraccesskey>kkklas8882kk23nllfjj88290</dealeraccesskey> </dealer> "
			+ "<orderitems> <item> <partnumber>0001</partnumber> <quantity>0</quantity> </item> "
			+ "<item> <partnumber>0</partnumber> <quantity>25</quantity> </item> </orderitems>"
			+ " <deliveryaddress> <name>Mrs. Jane Smith</name> <street>35 Streetname</street> "
			+ "<city>Halifax</city> <province>NS</province> <postalcode>B2T1A4</postalcode> </deliveryaddress> </order>";

	public static final String INVALID_DELIVERY_ADDRESS_WITHOUT_STREET = "<order><dealer><dealerid>XXX-1234-ABCD-1234</dealerid> "
			+ "<dealeraccesskey>kkklas8882kk23nllfjj88290</dealeraccesskey> </dealer> "
			+ "<orderitems> <item> <partnumber>1234</partnumber> <quantity>2</quantity> </item> "
			+ "<item> <partnumber>5678</partnumber> <quantity>25</quantity> </item> </orderitems>"
			+ " <deliveryaddress> <name>Mrs. Jane Smith</name> <street></street> "
			+ "<city>Halifax</city> <province>NS</province> <postalcode>B2T1A4</postalcode> </deliveryaddress> </order>";

	public static final String INVALID_DELIVERY_ADDRESS_WITHOUT_NAME = "<order><dealer><dealerid>XXX-1234-ABCD-1234</dealerid> "
			+ "<dealeraccesskey>kkklas8882kk23nllfjj88290</dealeraccesskey> </dealer> "
			+ "<orderitems> <item> <partnumber>1234</partnumber> <quantity>2</quantity> </item> "
			+ "<item> <partnumber>5678</partnumber> <quantity>25</quantity> </item> </orderitems>"
			+ " <deliveryaddress> <name></name> <street>1333 South PArk Street</street> "
			+ "<city>Halifax</city> <province>NS</province> <postalcode>B2T1A4</postalcode> </deliveryaddress> </order>";

	
	public static final String INVALID_DELIVERY_ADDRESS_WITHOUT_CITY = "<order><dealer><dealerid>XXX-1234-ABCD-1234</dealerid> "
			+ "<dealeraccesskey>kkklas8882kk23nllfjj88290</dealeraccesskey> </dealer> "
			+ "<orderitems> <item> <partnumber>1234</partnumber> <quantity>2</quantity> </item> "
			+ "<item> <partnumber>5678</partnumber> <quantity>25</quantity> </item> </orderitems>"
			+ " <deliveryaddress> <name>Mr Robert</name> <street>1333 South PArk Street</street> "
			+ "<city></city> <province>NS</province> <postalcode>B2T1A4</postalcode> </deliveryaddress> </order>";
	
	public static final String INVALID_DELIVERY_ADDRESS_WITHOUT_PROVINCE= "<order><dealer><dealerid>XXX-1234-ABCD-1234</dealerid> "
			+ "<dealeraccesskey>kkklas8882kk23nllfjj88290</dealeraccesskey> </dealer> "
			+ "<orderitems> <item> <partnumber>1234</partnumber> <quantity>2</quantity> </item> "
			+ "<item> <partnumber>5678</partnumber> <quantity>25</quantity> </item> </orderitems>"
			+ " <deliveryaddress> <name>Mr Robert</name> <street>1333 South PArk Street</street> "
			+ "<city>Halifax</city> <province></province> <postalcode>B2T1A4</postalcode> </deliveryaddress> </order>";
	
	public static final String INVALID_DELIVERY_ADDRESS_WITHOUT_POSTAL_CODE = "<order><dealer><dealerid>XXX-1234-ABCD-1234</dealerid> "
			+ "<dealeraccesskey>kkklas8882kk23nllfjj88290</dealeraccesskey> </dealer> "
			+ "<orderitems> <item> <partnumber>1234</partnumber> <quantity>2</quantity> </item> "
			+ "<item> <partnumber>5678</partnumber> <quantity>25</quantity> </item> </orderitems>"
			+ " <deliveryaddress> <name>Mr Robert</name> <street>1333 South PArk Street</street> "
			+ "<city>Halifax</city> <province>NS</province> <postalcode></postalcode> </deliveryaddress> </order>";
	
	public static final String INVALID_XML = "<order><dealer><dealerid>XXX-1234-ABCD-1234</dealerid> "
			+ "<dealeraccesskey>kkklas8882kk23nllfjj88290</dealeraccesskey> </dealer> "
			+ "<orderitems></orderitem> </order>";

	public static ResponseOrder getResponseOrder(){
		ResponseOrder order = new ResponseOrder();
		order.result="Success";
		order.errormessage="";
		return order;
	}

}
