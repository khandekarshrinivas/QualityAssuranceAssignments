package com.main.java.requestxml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "deliveryaddress")
public class DeliveryAddress {

	@XmlElement
	public String name;
	@XmlElement
	public String street;
	@XmlElement
	public String city;
	@XmlElement
	public String province;
	@XmlElement
	public String postalcode;

}
