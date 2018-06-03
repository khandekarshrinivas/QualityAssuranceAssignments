package com.main.java.requestxml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dealer")
public class Dealer {

	@XmlElement
	public String dealerid;

	@XmlElement
	public String dealeraccesskey;
}
