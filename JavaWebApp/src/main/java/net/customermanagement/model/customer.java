package net.customermanagement.model;

public class customer {
	protected int id;
	protected String First_name;
	protected String Last_name;
	protected String Address;
	protected String City;
	protected String State;
	protected String Email;
	protected String Country;
	protected int phone;
	
	
	
	public customer(String First_name, String Last_name,String Address,String City,String State,String Country, String Email ) {
		super();
		this.First_name = First_name;
		this.Last_name = Last_name;
		this.Address = Address; 
		this.City = City;
		this.State = State;
		this.Email = Email;
		this.Country = Country;
	}

	public customer(int id,String First_name, String Last_name,String Address,String City,String State,String Country, String Email ) {
		super();
		this.id = id;
		this.First_name = First_name;
		this.Last_name = Last_name;
		this.Address = Address; 
		this.City = City;
		this.State = State;
		this.Email = Email;
		this.Country = Country;
		this.phone = phone;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return First_name;
	}
	public void setFirst_name(String First_name) {
		this.First_name = First_name;
	}
	public String getLast_name() {
		return Last_name;
	}
	public void setLast_name(String Last_name) {
		this.Last_name = Last_name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String Address) {
		this.Address = Address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String City) {
		this.City = City;
	}
	public String getState() {
		return State;
	}
	public void setState(String State) {
		this.State = State;
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String Country) {
		this.Country = Country;
	}
	
	public int getphone() {
		return phone;
	}
	public void setphone(int phone) {
		this.phone = phone;
	}

	

}
	

