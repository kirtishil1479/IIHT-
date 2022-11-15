package com.core.SpringCoreDemo.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Employee {
	
	private String Employeename;
	private List<String>phones;
	private Set<String> address;
	private Map<String, String > courses;
	private Properties props;
	public String getEmployeename() {
		return Employeename;
	}
	public void setEmployeename(String employeename) {
		Employeename = employeename;
	}
	public List<String> getPhones() {
		return phones;
	}
	public void setPhones(List<String> phones) {
		this.phones = phones;
	}
	public Set<String> getAddress() {
		return address;
	}
	public void setAddress(Set<String> address) {
		this.address = address;
	}
	public Map<String, String> getCourses() {
		return courses;
	}
	public void setCourses(Map<String, String> courses) {
		this.courses = courses;
	}
	
	
	public Properties getProps() {
		return props;
	}
	public void setProps(Properties props) {
		this.props = props;
	}
	

	public Employee(String employeename, List<String> phones, Set<String> address, Map<String, String> courses,
			Properties props) {
		super();
		Employeename = employeename;
		this.phones = phones;
		this.address = address;
		this.courses = courses;
		this.props = props;
	}
	
	
	@Override
	public String toString() {
		return "Employee [Employeename=" + Employeename + ", phones=" + phones + ", address=" + address + ", courses="
				+ courses + ", props=" + props + "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
