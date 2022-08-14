package com.shreeganesh.SpringREST3.api;

public class Studdentdto {

	private Integer id;
	private String name;
	private String address;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
	  @Override public String toString() { return "Studdentdto [id=" + id +
	  ", name=" + name + ", address=" + address + "]"; }
	 
	public Studdentdto(Integer id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public Studdentdto() {	}
	
	
}
