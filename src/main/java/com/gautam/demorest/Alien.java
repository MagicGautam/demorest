package com.gautam.demorest;


@jakarta.xml.bind.annotation.XmlRootElement  //we are using this because we want alien to be root element and others be the other hierarcical elements.
public class Alien 
{
	private String name;
	private int points;
	private int id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	//without the ToString method, the hash of the object will be printed.
	@Override
	public String toString() {
		return "Alien [name=" + name + ", points=" + points + ", id=" + id + "]";
	}
	
	
}
