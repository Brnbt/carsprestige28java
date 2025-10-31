package fr.ensitech.carsprestige28.entity;

import javax.persistence.*;


@Entity
@Table(name = "address", catalog = "carsprestige28")

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    @Column(name = "number",nullable = true, length = 6)
	private String number;

    @Column(name = "type_street",nullable = true, length = 10)
    private String typeOfStreet;

    @Column(name = "street",nullable = true, length = 48)
    private String street;

    @Column(name = "postal_code",nullable = false, length = 5)
    private String postalCode;

    @Column(name = "city",nullable = false, length = 40)
    private String city;

    @Column(name = "country",nullable = false, length = 64)
    private String country;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
	
	public Address() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTypeOfStreet() {
		return typeOfStreet;
	}

	public void setTypeOfStreet(String typeOfStreet) {
		this.typeOfStreet = typeOfStreet;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
	public String toString() {
		return "Adresse [id=" + id + ", number=" + number + ", typeOfStreet=" + typeOfStreet + ", street=" + street
				+ ", postalCode=" + postalCode + ", city=" + city + ", country=" + country + "]";
	}
	
	
	
}
