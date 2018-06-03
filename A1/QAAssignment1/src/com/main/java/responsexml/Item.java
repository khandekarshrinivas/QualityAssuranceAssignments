package com.main.java.responsexml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "partnumber", "quantity", "result", "errormessage" })
public class Item {

	@XmlElement
	public Integer partnumber;
	
	@XmlElement
	public Integer quantity;
	
	@XmlElement
	public String result;
	
	@XmlElement
	public String errormessage;

}
