package pl.coderslab.dao;


public class Customer {
	private int id;
	private String name;
	private String surname;
	private String birthDate;

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", surname=" + surname + ", birthDate=" + birthDate + "]";
	}

	public Customer(String name, String surname, String birthDate, int id) {
		super();
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.id = id;
	}

	public Customer(int id) {
		this.id = id;
	}
	public Customer(String name, String surname, String birthDate) {
		super();
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getBirthDate() {
		return birthDate;
	}
	

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
}
