package pl.coderslab.dao;

import java.sql.Date;

public class Customer {
	private int id;
	private String name;
	private String surname;
	private Date birthDate;

	public Customer(String name, String surname, Date birthDate, int id) {
		super();
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.id = id;
	}

	public Customer(String name, String surname, Date birthDate) {
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
