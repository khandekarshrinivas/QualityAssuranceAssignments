package com.main.java.responsexml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "order")
@XmlType(propOrder = { "result", "error", "errormessage", "items" })
public class ResponseOrder {

	@XmlElement
	@XmlElementWrapper(name = "orderitems")
	public List<Item> items = new ArrayList<>();

	@XmlElement
	public String result;

	@XmlElement
	public String error;

	@XmlElement
	public String errormessage;

}
