package com.main.java.requestxml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "order")
public class IncomingOrder {

	@XmlElement
	public DeliveryAddress deliveryaddress;
	
	@XmlElement
	public Dealer dealer;
	
	@XmlElementWrapper(name = "orderitems")
	@XmlElement(name = "item")
	public List<Item> orderitems = new ArrayList<>();

}
